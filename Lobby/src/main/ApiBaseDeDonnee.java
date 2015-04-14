package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ApiBaseDeDonnee {
	
	private static Connection cn;
	private static boolean co = false;
	private static String url = "jdbc:mysql://mysql-hbct.alwaysdata.net/hbct_plugin";
	private static String user = "hbct_plugin";
	private static String password = "jeje";
	
	public static void connect(){
		if(!co){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn =  DriverManager.getConnection(url, user, password);
				co = true;
				System.out.println("Connexion a la base de donne effectue");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<ArrayList<String>> sendRequette(String requette){
		ArrayList<ArrayList<String>> listFinal = new ArrayList<ArrayList<String>>();
		if(!co){
			System.out.println("Pas de connexion a la base de donnee");
			return null;
		}
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = cn.createStatement();
			rs = st.executeQuery(requette);
			ResultSetMetaData meta = rs.getMetaData();
			while(rs.next()){
				ArrayList<String> list = new ArrayList<String>();
				for(int i = 1;i<=meta.getColumnCount();i++)
					list.add(rs.getString(i));
				listFinal.add(list);
			}
			return listFinal;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
			
		return null;
	}
	
	
}
