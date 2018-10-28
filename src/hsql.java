import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.*;
import javax.naming.spi.DirStateFactory.Result;

public class hsql {
public static void main (String [] args) {

try{
	

Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
String query = "SELECT * FROM INVOICE";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
while (rs.next()) {
	System.out.println("customerID:" + rs.getString("CUSTOMERID"));
}

}

catch (Exception e) {
	System.err.println(e);;
}


}}