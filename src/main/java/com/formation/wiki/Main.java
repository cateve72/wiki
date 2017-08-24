package com.formation.wiki;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.formation.wiki.DAO.ArticleInexistantException;
import com.formation.wiki.DAO.UtilisateurDAO;
import com.formation.wiki.entity.Utilisateur;

public class Main {

	public static void main(String[] args) throws SQLException, TimeoutException, ArticleInexistantException {
		
		Utilisateur user = new Utilisateur();
		user.setLogin("James6");
		user.setPassword("Joe6");
		user.setNom("Do6e");
		user.setActiver(true);
		user.setPrenom("James6");
		user.setEmail("James6.Doe@ererer.com");
		UtilisateurDAO dao= new UtilisateurDAO();
		dao.addUser(user);
		
		try{
			System.out.println(dao.isUserExist("James6", "Joe6"));
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (TimeoutException e) {
			e.printStackTrace();
		}
		
		System.out.println(dao.findbyId(1).getActiver());
		dao.changerEtatUser(dao.findbyId(1));
		System.out.println(dao.findbyId(1).getActiver());
	}

}
