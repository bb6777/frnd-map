import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.*;
//import javax.naming.spi.DirStateFactory.Result;

public class hsql {
public static void main (String [] args) {

try{
	

Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
//String query = "SELECT * FROM INVOICE";
String query = "SELECT customer.city as stay, sum(invoice.total) AS amount, customer.firstname as who, customer.lastname, invoice.customerid\r\n" + 
		"FROM customer\r\n" + 
		"INNER JOIN invoice ON customer.id = invoice.customerid\r\n" + 
		"WHERE invoice.customerid=12\r\n" + 
		"GROUP BY customerid, id\r\n";
		
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
while (rs.next()) {
	System.out.println("Amount Total:" + rs.getString("amount"));
	System.out.println("City:" + rs.getString("stay"));
	System.out.println("Who:" + rs.getString("who"));
}

}

catch (Exception e) {
	System.err.println(e);;
}


}}