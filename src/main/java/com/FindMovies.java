package com;

import java.sql.*;
import java.util.ArrayList;

public class FindMovies {
	public static ArrayList<Movies> findAllMovies(Connection con) {
		try {
			ArrayList<Movies> list = new ArrayList<Movies>();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select movie_name, release_date, is_active from movies");
			while (rs.next()) {
				// System.out.println(rs.getString(1)+" "+rs.getString(2)+"
				// "+rs.getDate(3));
				Movies m = new Movies();
				m.movie_name = rs.getString("movie_name");
				m.release_date = rs.getDate("release_date");
				m.is_active = rs.getInt("is_active");

				list.add(m);
				// list.add('movie_name+""+release_date+""+is_active');

			}
			return list;
			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
