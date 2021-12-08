package travel.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conn {
	Connection c ;
	Statement s ;
	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///tms","root","12345");
			s = c.createStatement();
		}catch(Exception e) {

		}
	}
}
