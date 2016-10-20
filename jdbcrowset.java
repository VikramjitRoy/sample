import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  

import javax.sql.RowSetEvent;  
import javax.sql.RowSetListener;  
import javax.sql.rowset.JdbcRowSet;  
import javax.sql.rowset.RowSetProvider;  

public class JdbcRowset {  
	public static void main(String[] args) throws Exception {  
		Class.forName("com.mysql.jdbc.Driver");  

		//Creating and Executing RowSet  
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
		rowSet.setUrl("jdbc:mysql://localhost:3306/sample");  
		rowSet.setUsername("root");  
		rowSet.setPassword("Welcome123");  

		rowSet.setCommand("select * from emp_table");  
		rowSet.execute();  

		while (rowSet.next()) {  
			// Generating cursor Moved event  
			System.out.println("Id: " + rowSet.getInt(1));  
			System.out.println("Name: " + rowSet.getString(2));  
			System.out.println("zip: " + rowSet.getInt(3));  
		}  
        System.out.println("...............");
        
        System.out.println("inserting a row");
	    rowSet.moveToInsertRow();
	    rowSet.updateInt("emp_id",6);
	    rowSet.updateString("emp_name","melzzzz");
	    rowSet.updateInt("emp_zip",13);
	    rowSet.insertRow();
		rowSet.moveToCurrentRow();
		System.out.println("....row is inserted....");
		
		System.out.println("...............");
		
	    rowSet.setCommand("select * from emp_table");  
		rowSet.execute();
	    while (rowSet.next()) {  
			// Generating cursor Moved event  
			System.out.println("Id: " + rowSet.getInt(1));  
			System.out.println("Name: " + rowSet.getString(2));  
			System.out.println("zip: " + rowSet.getInt(3));  
		}  
	    
	    rowSet.last();
	    rowSet.deleteRow();
	    rowSet.setCommand("select * from emp_table");  
		rowSet.execute();
	    while (rowSet.next()) {  
			// Generating cursor Moved event  
			System.out.println("Id: " + rowSet.getInt(1));  
			System.out.println("Name: " + rowSet.getString(2));  
			System.out.println("zip: " + rowSet.getInt(3));  
		}

	}  
}  
