package com.formation.wiki.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.formation.wiki.entity.Article;

public class ArticleDAO {

	private EntityManager em;
	private EntityTransaction tx;
	public ArticleDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	// Methode d'ajout d'un article
	public void addArt(Article id) {
		tx.begin();
		em.persist(id);	
		tx.commit();
	}
	
	// Methode pour supprimer d'un article
	public void suppArt(Article id) {
		tx.begin();
		em.remove(id);	
		tx.commit();
	}
	
	public void changerEtatArt(Article id) {

		if (id.getStatut().getWaitingforvalidation()==false && id.getStatut().getPublished()==true) {
			id.getStatut().setPublished(true);
			id.getStatut().setWaitingforvalidation(false);
		}else {
			id.getStatut().setPublished(false);
			id.getStatut().setWaitingforvalidation(true);
		}
		tx.begin();
		em.merge(id);
		tx.commit();
	}
	
//	//insere un Article
//		public static boolean insertArticle(String nom, int idUser, String contenu) {
//			boolean insertOK=false;
//			String requestInsertArticle = "INSERT INTO article (nom,idUser,contenu) VALUES"
//					+" ('"+nom+"',"+idUser+",'"+contenu+"')";
//			System.out.println(requestInsertArticle);
//			Connection c=ConnexionManager.getConnexion();
//				try {
//					Statement st= c.createStatement();
//					st.executeUpdate(requestInsertArticle);
//					insertOK=true;
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//					insertOK=false;
//				}
//				System.out.println(insertOK);
//		
//				return insertOK;
//			}
//		
//	//supprimer article par Id
//		public static void SuppArticleId(int idArticle) throws ArticleInexistantException{
//			Article article= getarticleId(idArticle);
//			if(article==null) {
//				throw new ArticleInexistantException(idArticle);
//			}
//			else {
//			String requestSuppArticle = "DELETE FROM article where "
//					+ "idArticle=" + idArticle +"";
//			System.out.println(requestSuppArticle);
//			Connection c=ConnexionManager.getConnexion();
//				try {
//					Statement st= c.createStatement();
//					st.executeUpdate(requestSuppArticle);
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//	}
//		//Recuperer article par Id
//		public static Article getarticleId(int idArticle) {
//			String request="select * from article where "
//					+ "idArticle='" + idArticle +"'";
//			Article a=null;
//			try {
//				Connection c=ConnexionManager.getConnexion();
//				Statement st= c.createStatement();
//				ResultSet rs= st.executeQuery(request);
//				if (rs.next()) {
//					a=new Article();
//					a.setNom(rs.getString("nom"));
//					a.setContenu(rs.getString("contenu"));
//					a.setIdUser(rs.getInt("idUser"));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return a;
//		}
//		
//		//Recuperer article par nom
//		public static Article getarticlenom(String nom) {
//			String request="select * from article where "
//					+ "nom='" + nom +"'";
//			Article a=null;
//			try {
//				Connection c=ConnexionManager.getConnexion();
//				Statement st= c.createStatement();
//				ResultSet rs= st.executeQuery(request);
//				if (rs.next()) {
//					a=new Article();
//					a.setNom(rs.getString("nom"));
//					a.setContenu(rs.getString("contenu"));
//					a.setIdUser(rs.getInt("idUser"));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return a;
//		}
//		
//		//trouver tous les articles
//		public static List<Article> getArticle(){
//			String requestAll="select * from article" ;
//			List<Article> listArt = null;
//			try {
//				Connection c=ConnexionManager.getConnexion();
//				Statement st= c.createStatement();
//				ResultSet rs= st.executeQuery(requestAll);
//				listArt=new ArrayList<Article>();
//				
//				while (rs.next()) {
//					Article a=new Article();
//					a.setNom(rs.getString("nom"));
//					a.setContenu(rs.getString("contenu"));
//					a.setIdUser(rs.getInt("idUser"));
//					listArt.add(a);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return listArt;
//		}
}
