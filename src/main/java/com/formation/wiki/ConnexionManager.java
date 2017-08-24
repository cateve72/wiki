package com.formation.wiki;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionManager {
		
		public static String url="jdbc:mysql://localhost:3306/wiki";
		public static String user="root";
		public static String password="";

	public static Connection getConnexion() {
		Connection con=null;
		try {
			//pour charger driver jdbc
			Class.forName("com.mysql.jdbc.Driver");
			//pour recuperer une connexion
			con=DriverManager.getConnection(url, user, password);
			System.out.println("connexion établie avec succès");
			
			} catch (ClassNotFoundException e) {
				System.out.println("Erreur lors du chargement du Driver");
				
			} catch (Exception e) {
				System.out.println("Erreur lors de la connexion à la BDD");
			}
		
		return con;
	}
}
