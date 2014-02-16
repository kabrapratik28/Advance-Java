import java.sql.*;

public class database {
	
	/**
	 * @param args
	 */
	Connection c = null;
	Statement stmt=null;
	public void connectionopen(){
		
		try {
	    	

		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Employee");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");
		}catch ( Exception e ) {
		      System.err.println("Database open error");
		      System.exit(0);
		    }
		
	}
	
	public void connectionclose(){
		try {
			c.close();
		}catch ( Exception e ) {
		      System.err.println( "Database close error" );
		      System.exit(0);
		    }
		
	}
	
	public void executequery(){
		try{
		stmt = c.createStatement();
	    ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
	    while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      
		}catch ( Exception e ) {
		      System.err.println( "Query execution error" );
		      System.exit(0);
		    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		database d1 = new database();
		d1.connectionopen() ; 
		d1.executequery();
		d1.connectionclose() ; 
		
	}

}
