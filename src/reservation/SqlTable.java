package reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTable {
	String name;
	String[] header;
	String[][] context = null;
	String[] result;

	public SqlTable(String name, String[] header) {
		this.name = name;
		this.header = header;
		result = new String[header.length];
	}

	public String[][] selectAll() {
		Statement stmt;
		String[][] context = null;

		int i = 0;

		try {

			stmt = Start.con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM " + name);

			rs.last();
			int nRecord = rs.getRow();
			context = new String[nRecord][header.length];
			rs.beforeFirst();

			while (rs.next()) {
				for (int j = 0; j < header.length; j++) {
					result[j] = rs.getString(header[j]);
					context[i][j] = result[j];
				}
				i++;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return context;
	}
}
