import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


public class databaseconnection {
	
	Connection connect = null;
	java.sql.Statement statement = null;
	java.sql.PreparedStatement preparedStatement = null;
	java.sql.PreparedStatement preparedStatement2 = null;
	ResultSet resultSet = null;
	
	
	public databaseconnection(String Host, String Port){
		
		 try {
				Class.forName("com.mysql.jdbc.Driver"); //loading driver
				String url =  "jdbc:mysql://"+Host+":"+Port+"/Employee"; 
				String username = "root"; 
				String password = "pratik";
				
				//connecting 
				connect = DriverManager.getConnection(url, username, password);
				
				// Statements allow to issue SQL queries to the database
			    statement = connect.createStatement();
		
			  //statement for returing results at particular id
			    preparedStatement = connect.prepareStatement("select * from Employee.employee where id=?;") ;
			    
			   //statement for updating 
			    preparedStatement2 = connect.prepareStatement("update Employee.employee set name=?,surname=?,start_year=?,dob=? where id=?;") ;
		 }
		 catch (Exception e) 
		 {
					// TODO Auto-generated catch block
					System.out.println("DATABASE OPEN PROBLEM !!!");
		 }
	}
	
	public void closedatabaseconnection()
	{
		 try {
			 resultSet.close() ; 
			 statement.close() ; 
			 connect.close() ; 
		 }
		 catch (Exception e) 
		 {
					// TODO Auto-generated catch block
					System.out.println("DATABASE CLOSE PROBLEM !!!");
		 }
	}
	
	public int size_of_data()
	{
		int size=0 ; 
		try{
		resultSet = statement.executeQuery("select max(id) from employee ; ");
		while(resultSet.next() )
		{
			size = resultSet.getInt(1) ; 
		}
		}catch(Exception e){
			System.out.println("Size didnt get");
		}
		return size;
		
	}
	
	
	public employee getemployee(int idofemp){
		employee e2 = new employee() ; 
		try {
			
			
			preparedStatement.setInt(1, idofemp);
			resultSet = preparedStatement.executeQuery() ; 
			
		    while(resultSet.next())
			{
				
				e2.Job_id = resultSet.getInt(1);
				e2.Name = resultSet.getString(2);
				e2.Surname = resultSet.getString(3);
				e2.Start_year = resultSet.getString(4);
				e2.DOB = resultSet.getString(5) ; 
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Employee of this id not found"+String.valueOf(idofemp));
		} 

		return e2 ; 
	}
	
	
	public void changeemployeedata(employee e3)
	{
		try {
			
			
			preparedStatement2.setString(1, e3.Name);
			preparedStatement2.setString(2, e3.Surname);
			preparedStatement2.setString(3, e3.Start_year);
			preparedStatement2.setString(4, e3.DOB);
			preparedStatement2.setInt(5, e3.Job_id);
			preparedStatement2.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Not updated Employee : "+String.valueOf(e3.Job_id));
		} 
		
		
	}
	
}
