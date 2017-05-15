package conDB;
import java.sql.Connection;
import java.sql.DriverManager;


public class connectUtil {
	
			public static Connection connectDB()
		{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/online_movie_portal?useSSL=false","root","root"); 
			  
			System.out.println("DB CONNECTED");
			  return  con;
			}
			catch(Exception e)
				{ 
				System.out.println(e);
				}
		return null;  
			} 

		
	}


