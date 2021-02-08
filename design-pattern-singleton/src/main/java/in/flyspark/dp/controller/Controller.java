package in.flyspark.dp.controller;

import java.sql.SQLException;

import in.flyspark.dp.model.DAOFactory;
import in.flyspark.dp.model.Model;
import in.flyspark.dp.model.Person;
import in.flyspark.dp.model.PersonDAO;
import in.flyspark.dp.view.CreateUserEvent;
import in.flyspark.dp.view.CreateUserListener;
import in.flyspark.dp.view.View;

public class Controller implements CreateUserListener {
	private View view;
	private Model model;

	private PersonDAO personDAO = DAOFactory.getPersonDAO();

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void userCreated(CreateUserEvent event) {
		System.out.println("Create User event received: " + event.getName() + "; " + event.getPassword());

		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}