package com.formation.wiki.DAO;

public class ArticleInexistantException extends Exception {
	private static final long serialVersionUID = 1;
	private int idArticle;
	
	
	public ArticleInexistantException(int idArticle) {
		super();
		this.idArticle = idArticle;
	}


	@Override
	public String toString() {
		return "ArticleInexistantException [idArticle=" + idArticle + "]";
	}

}
