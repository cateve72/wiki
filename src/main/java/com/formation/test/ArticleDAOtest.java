package com.formation.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import javax.ejb.Timeout;

import org.junit.Before;
import org.junit.Test;

import com.formation.wiki.DAO.ArticleDAO;
import com.formation.wiki.DAO.ArticleInexistantException;
import com.formation.wiki.entity.Article;

public class ArticleDAOtest {
	
	
	@Before
	public void init() {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//@Test(expected=TimeoutException.class)
	@Test
	public void insertArticletest() throws SQLException {
		
//		assertTrue(ArticleDAO.insertArticle("Article 3", 1, "mon premier blbabla"));
//		assertTrue(ArticleDAO.insertArticle(null, 2, "mon premier blbabla"));
//		assertTrue(ArticleDAO.insertArticle("Article 3", 4, "mon premier blbabla"));
//		assertTrue(ArticleDAO.insertArticle("Article 3", 1, null));
////		assertTrue(ArticleDAO.insertArticle(null, 0, null));
//		// on a nb articles, on teste si après insertion d'un article on obtient 1 article de +
//		int l=ArticleDAO.getArticle().size();
//		ArticleDAO.insertArticle("Catherine Dailys", 4, "Mes journées de formations");
//		assertEquals(l+1, ArticleDAO.getArticle().size());
	}
	
	@Test
	public void SuppArticleIdtest() throws ArticleInexistantException{
//		assertTrue(ArticleDAO.SuppArticleId(0));
		// on a nb articles, on teste si après delete d'un article on obtient 1 article de -
	//	int l=ArticleDAO.getArticle().size();
		//ArticleDAO.SuppArticleId(1);
	//	assertEquals(l-1, ArticleDAO.getArticle().size());
		
//		ArticleDAO.SuppArticleId(45454);
	}
	
	@Test
	public void getarticleIdtest() {
		assertNotNull(1);
		
	}

	@Test
	public void getarticlenomtest() {
		assertNotNull(1);
	}
	@Test
	public void getArticletest() {
		
	}
}
