package atmsimulator;

// 1. Register the driver
// 2. Create Connection
// 3. Create Statement
// 4. Execute Query
// 5. Close Connection

import java.sql.*;   // To import the SQL library


public class Conn 
{
	Connection c;
	Statement s;
	public Conn() {
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);     // Driver need not be registered as it will be directly imported from the library 
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Cj@23022002");    // 1. To create connection with MySQL
			s = c.createStatement();                // To create statement, so we can execute queries (Conn class object)
			
		
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
