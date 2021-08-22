
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EmployeeDemo {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultsSet = null;
		
//		step 1: load the DB drivers, important: import all the necessary jar files to the library
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
		} catch (ClassNotFoundException ex) {
			System.out.println("problem in loading UCanAccess Driver");
			ex.printStackTrace();
		}
		
		try {
//			step 2: A create and get the connection to DB
			String msAccDB = "/Users/chenqiao/Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			connection = DriverManager.getConnection(dbURL);
			
//			step 2: B create JDBC statement
			statement = connection.createStatement();
			
//			step 2: C execute SQL query and process the result
//			
////			insert a record into employee table
			String insertSQL = "insert into employee(name,salary) values('Carrie Chen',100000)";
			statement.executeUpdate(insertSQL);
		
////			update a record
			String updateSQL = "update employee set salary =9000 where name ='SIMON LI'";
			statement.executeUpdate(updateSQL);
			
			
//			delete a record
//			String deleteSQL = "delete from employee where name ='Carrie'";
//			statement.execute(deleteSQL);
//			
//			read and display the employee table 
			String readSQL = "select * from employee";
			resultsSet = statement.executeQuery(readSQL);
			
			while (resultsSet.next()) {
				int id = resultsSet.getInt(1);  //the index of element in the resultSet start with 1
				String name = resultsSet.getString(2);
				double salary = resultsSet.getDouble(3);
				System.out.println("employee #"+id+": "+name+" ,"+salary);
			}
//			tidy the code: ctl+shift+f
			
		} catch (SQLException sqlex) {
		
			sqlex.printStackTrace();
		}finally {
			
//			step 3: close database connection and release all resource
			try {
				if (connection != null) {
					resultsSet.close();
					statement.close();
					connection.close();
				}
				
				
			} catch (SQLException sqlex) {
				
				sqlex.printStackTrace();
			}
			
			
			
		}
		
		
		
	}

}
