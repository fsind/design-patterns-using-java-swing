package in.flyspark.dp.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import in.flyspark.dp.model.Model;

public class View extends JFrame {

	private static final long serialVersionUID = -1877833662364287349L;

	private Model model;

	public View(Model model) throws HeadlessException {
		super("MVC");
		this.model = model;

	}

}
