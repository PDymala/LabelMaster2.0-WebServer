package com.diplabels.LabelMaster2;

import java.sql.SQLException;

public class LabelRepository {

	public LabelRepository() {

	}

	public boolean checkIfExist(String number) throws ClassNotFoundException, SQLException {
		DBHandler dbh = new DBHandler();

		return dbh.checkIfExist(number);
	}

	public void addToDatabase(String number) throws ClassNotFoundException, SQLException {
		DBHandler dbh = new DBHandler();
		dbh.addToDatabase(number);
	}

	public Label getLabel(String number) {
		return new Label();
	}

	public void deleteLabel(String number) throws ClassNotFoundException, SQLException {
		DBHandler dbh = new DBHandler();
		dbh.delete(number);
	}

}
