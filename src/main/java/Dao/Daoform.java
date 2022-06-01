package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Daoform {
	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbQcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	
	public static List<form> getAll() {
		List<form> lstform = new ArrayList<form>();
		try {
			startConnection();
			String sql = "select * from form ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			ResultSet rs =s.executeQuery();
			while(rs.next()) {
				form f = new form();
				f.setIdf(rs.getInt(1));
				f.setLibf(rs.getString(2));
				lstform.add(f);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lstform;
	}
	
	public static form find(int id) {
		form f = new form();
		try {
			String sql = "select * from reponse where id_form = ? ;";
			PreparedStatement s =  cnx.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet rs =s.executeQuery();
			rs.next();
			f.setIdf(rs.getInt(1));
			f.setLibf(rs.getString(2));
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		
		return f;
	}
}
