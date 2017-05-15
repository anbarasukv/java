package com;

import java.sql.Connection;
import java.sql.Statement;

public class insertMovie {
	public static void insertRec(String m_name,String relDate,int isactive,Connection con)
	{
		try{
	
	 System.out.println(m_name);
			Statement stmt = con.createStatement();
	stmt.executeUpdate("INSERT INTO movies (movie_name, release_date, is_active) VALUES ('"+m_name+"','"+relDate+"','"+isactive+"') ");
	//ResultSet rs=stmt.executeQuery("select * from movies");  
	//while(rs.next())  
	//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"   "+rs.getDate(3));  
	//con.close();  
	}
	catch(Exception e)
		{ 
		System.out.println(e);
		}  
	} 

}
