package in.flyspark.dp;

import javax.swing.SwingUtilities;

import in.flyspark.dp.controller.Controller;
import in.flyspark.dp.model.Model;
import in.flyspark.dp.view.View;

public class App {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				runApp();
			}
		});

	}

	public static void runApp() {
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);
	}
}
