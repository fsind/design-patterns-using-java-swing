package in.flyspark.dp.model;

public class MySQLDAOFactory extends DAOFactory {
	public PersonDAO getPersonDAO() {
		return new MySQLPersonDAO();
	}

	public LogDAO getLogDAO() {
		return new MySQLLogDAO();
	}
}
