package in.flyspark.dp.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements Cloneable, Serializable {
	private static final long serialVersionUID = -3827840205710567196L;

	private Connection con;

	private Database() {
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new CloneNotSupportedException();
	}

	protected Object readResolve() {
		return getInstance();
	}

	private static class LazyInit {
		private static final Database INSTANCE = new Database();
	}

	public static final Database getInstance() {
		return LazyInit.INSTANCE;
	}

	public Connection getConnection() {
		return con;
	}

	public void connect() throws Exception {
		if (con != null)
			return;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patterns", "root", "");
	}

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
		}

		con = null;
	}

}