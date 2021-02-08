package in.flyspark.dp.controller;

import in.flyspark.dp.model.Model;
import in.flyspark.dp.view.View;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

}
