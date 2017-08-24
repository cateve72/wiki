package com.formation.wiki.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.wiki.ConnexionManager;
import com.formation.wiki.entity.Commentaire;

public class CommentaireDAO {
	// insere un commentaire
	public static void insertComm(String contenu, int idUser, int idArticle) {
		String requestInsertComm = "INSERT INTO commentaire (contenu,idUser,idArticle) VALUES" 
				+ " ('" + contenu + "',"
				+ idUser + "," + idArticle + ")";
		System.out.println(requestInsertComm);
		Connection c = ConnexionManager.getConnexion();
		try {
			Statement st = c.createStatement();
			st.executeUpdate(requestInsertComm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// supprimer commentaire par Id
	public static void SuppCommId(int idComment) {
		String requestSuppComm = "DELETE FROM commentaire where " 
				+ "idComment=" + idComment + "";
		System.out.println(requestSuppComm);
		Connection c = ConnexionManager.getConnexion();
		try {
			Statement st = c.createStatement();
			st.executeUpdate(requestSuppComm);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//recuperer commentaire lié à 1 article
			public static List<Commentaire> getComment(int idArticle){
				String requestAll="select * from commentaire where "
						+ "idArticle=" + idArticle + "";
				List<Commentaire> listComm = null;
				try {
					Connection c=ConnexionManager.getConnexion();
					Statement st= c.createStatement();
					ResultSet rs= st.executeQuery(requestAll);
					listComm=new ArrayList<Commentaire>();
					
					while (rs.next()) {
						Commentaire a=new Commentaire();
						a.setComment(rs.getString("comment"));
						a.setId(rs.getInt("id"));
						a.setCommentDate(rs.getDate("commentDate"));
						listComm.add(a);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return listComm;
			}
	
}
