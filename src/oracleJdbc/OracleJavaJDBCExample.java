package oracleJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJavaJDBCExample {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String USER = "sys as sysdba";
		String PASS = "<passcode>";
		// Creating Connection
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (conn != null) {
				System.out.println("Connected to the Oracle DB!");
				stmt = conn.createStatement();
				/*
				 * String sql = "CREATE TABLE EMPLOYEE " + "(EMPID INTEGER not NULL, " +
				 * " FIRSTNAME VARCHAR(255), " + " LASTNAME VARCHAR(255), " +
				 * " PRIMARY KEY ( EMPID ))";
				 * 
				 * stmt.executeUpdate(sql);
				 * System.out.println("SQL Table created successfully...");
				 */
				// Execute a query
				/*
				 * System.out.println("Inserting records into the table..."); String sql =
				 * "INSERT INTO EMPLOYEE VALUES (100, 'John', 'Doe')"; stmt.executeUpdate(sql);
				 * sql = "INSERT INTO EMPLOYEE VALUES (101, 'Jane', 'Smith')";
				 * stmt.executeUpdate(sql); sql =
				 * "INSERT INTO EMPLOYEE VALUES (102, 'Alice', 'Johnson')";
				 * stmt.executeUpdate(sql);
				 * System.out.println("Inserted records into the table...");
				 */
				String QUERY = "SELECT EMPID, FIRSTNAME, LASTNAME FROM EMPLOYEE";
				ResultSet rs = stmt.executeQuery(QUERY);
				while(rs.next()){
		            //Display values
		            System.out.print("EMPID: " + rs.getInt("EMPID"));
		            System.out.print(", FIRSTNAME: " + rs.getString("FIRSTNAME"));
		            System.out.println(", LASTNAME: " + rs.getString("LASTNAME"));
		         }
			} else {
				System.out.println("Failed to make connection!");
			}
			

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close the connection & statement object
			stmt.close();
			conn.close();
		}

	}

}
