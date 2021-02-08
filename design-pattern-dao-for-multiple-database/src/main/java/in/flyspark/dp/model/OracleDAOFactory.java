package in.flyspark.dp.model;

public class OracleDAOFactory extends DAOFactory {

	public PersonDAO getPersonDAO() {
		return new OraclePersonDAO();
	}

	public LogDAO getLogDAO() {
		return new OracleLogDAO();
	}

}
