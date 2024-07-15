package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.remote.JMXConnectionNotification;

public class Jdbc {

	public static void main (String args[])
	
	{
// 	create database connection	
  String db_url = "jdbc:mysql://localhost:3306";
  String user = "root";
  String password ="root";
		
// establish the connection  
		
  try {
 		 // check whether the connection is successful		
  		Connection connect = DriverManager.getConnection(db_url,user,password);
  		
  		
  		if(connect!=null)
  		{
  			System.out.println("connection established");
  			
  		}
  		
  		else
  		{
  			System.out.println("connection not established");
  		}
// to create database, to create table and insert values to the table
			
	// create the statement	  		
  		
  	Statement st = connect.createStatement();
  		
  	String createDB = "create database db_empl";
  	
  	String use = "use db_empl";
  	String createTable = "create table db_empl(empcode int ,empname  varchar(10) ,empage int ,esalary int)";
  		
  	String insert = "insert into db_empl values(101,'jenny',25,10000),(102,'jacky',30,20000),(103,'joe',20,40000),(104,'john',40,80000),(105,'shameer',25,90000)";
  		
  	
  	String select = "select* from db_empl";

	  
  // execute the statements	
  	st.execute(createDB);
  	st.execute(use);
  	st.execute(createTable);
  	st.executeUpdate(insert);
	  
  // to select the data		
        ResultSet result = st.executeQuery(select);
  		
  // iterate the result		
	  while(result.next()) 
	  {
  	   System.out.println(result.getInt("empcode")+" "+result.getString("empname")+" "+result.getInt("empage")+" "+result.getInt("esalary"));
  	  }
// close the connection	  
  	connect.close();
   }
	  
// to handle the sql exception	  
  catch (SQLException e)
  
  {		
	  e.printStackTrace();
  }
		
	}
}
  	    
		    	
		        


