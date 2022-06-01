package Dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	//import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	public class Daoquestion {
		static Connection cnx = null;
		public static void   startConnection() {
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbQcm", "root", "");
		  }catch(Exception e) {
			System.out.println(e);
		  }
		}
		
		public static List<question> getquestions(int idf) {
			List<question> lstquest = new ArrayList<question>();
			try {
				startConnection();
				String sql = "select * from question where id_form=? ;";
				PreparedStatement s =  cnx.prepareStatement(sql);
				s.setInt(1, idf);
				ResultSet rs =s.executeQuery();
				while(rs.next()) {
					question q = new question();
				      q.setIdq(rs.getInt(1));
				      q.setIdf(rs.getInt(2));
				      q.setLibq(rs.getString(3));
				      
				    lstquest.add(q);
				}
				cnx.close();
			}catch(Exception e1) {System.out.println(e1);}
			return lstquest;
		}
		
}
