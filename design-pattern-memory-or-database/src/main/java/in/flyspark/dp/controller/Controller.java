package in.flyspark.dp.controller;

import in.flyspark.dp.model.Database;
import in.flyspark.dp.model.Model;
import in.flyspark.dp.model.Person;
import in.flyspark.dp.view.AppListener;
import in.flyspark.dp.view.CreateUserEvent;
import in.flyspark.dp.view.CreateUserListener;
import in.flyspark.dp.view.SaveListener;
import in.flyspark.dp.view.View;

public class Controller implements CreateUserListener, SaveListener, AppListener {
	private View view;
	private Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void onUserCreated(CreateUserEvent event) {
		model.addPerson(new Person(event.getName(), event.getPassword()));
	}

	public void onSave() {
		try {
			model.save();
		} catch (Exception e) {
			view.showError("Error saving to database.");
		}
	}

	public void onOpen() {
		try {
			Database.getInstance().connect();
		} catch (Exception e) {
			view.showError("Cannot connect to database.");
		}

		try {
			model.load();
		} catch (Exception e) {
			view.showError("Error loading data from database.");
		}
	}

	public void onClose() {
		Database.getInstance().disconnect();
	}

}
