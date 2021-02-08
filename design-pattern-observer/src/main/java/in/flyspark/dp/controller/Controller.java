package in.flyspark.dp.controller;

import in.flyspark.dp.model.Model;
import in.flyspark.dp.view.LoginFormEvent;
import in.flyspark.dp.view.LoginListener;
import in.flyspark.dp.view.View;

public class Controller implements LoginListener {
	private View view;
	private Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void loginPerformed(LoginFormEvent event) {
		System.out.println("Login event received: " + event.getName() + "; " + event.getPassword());

	}

}