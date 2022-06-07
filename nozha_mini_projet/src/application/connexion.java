package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connexion {
	static Connection cn=null ;
	static {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException ex) {
	System.out.println("Problème de chargement du Driver!");
	System.exit(1);
	}
	String url = "jdbc:mysql://localhost:3306/projet_java";
	try {
	 cn =DriverManager.getConnection(url,"root","");
     }
	catch (SQLException e) {
	System.err.println("Error opening SQL connection:"+ e.getMessage());
	}
	
   
	
}
	public static Connection getCn() {
		return cn;
	}
   



}
