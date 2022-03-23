import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti {
	static Connection myConn;
	 static Statement myStat;
	 static ResultSet myRs; 
	 
	static ResultSet yap() {
		String url="jdbc:sqlite:C://biletotomasyon/bilet.db";
		
		 myConn =null;
		try {
			myConn=DriverManager.getConnection(url);
			//System.out.println("baðlandýnýz");
               myStat = (Statement) myConn.createStatement();
		       myRs = myStat.executeQuery("select * from tblYoneticiGirisi");
		      
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
		return myRs;
		}
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myRs;
	}

}
