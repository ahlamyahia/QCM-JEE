package Dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	public class Daoreponse {
		static Connection cnx = null;
		public static void   startConnection() {
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbQcm", "root", "");
		  }catch(Exception e) {
			System.out.println(e);
		  }
		}
		
		public static List<reponse> getReponse(int idq) {
			List<reponse> lstreponse = new ArrayList<reponse>();
			try {
				startConnection();
				String sql = "select * from reponse where id_question=? ;";
				PreparedStatement s =  cnx.prepareStatement(sql);
				s.setInt(1, idq);
				ResultSet rs =s.executeQuery();
				while(rs.next()) {
					reponse re = new reponse();
					
					re.setIdr(rs.getInt(1));
					re.setIdq(rs.getInt(2));
				      re.setLibr(rs.getString(3));
				      //re.setCorrect(rs.getBoolean(4));
				      lstreponse.add(re);
				}
				cnx.close();
			}catch(Exception e1) {System.out.println(e1);}
			return lstreponse;
		}
		// score
		public static boolean isCorrecte(int reponse) {
			boolean result=false;
			try {
				startConnection();
				String sql = "select correct from reponse where id_reponse = ? ;";
				PreparedStatement s =  cnx.prepareStatement(sql);
				s.setInt(1, reponse);
				ResultSet rs =s.executeQuery();
				rs.next();
				result = rs.getBoolean(1);
				cnx.close();
			}catch(Exception e1) {System.out.println(e1);}
		
			return result;
		}

}
