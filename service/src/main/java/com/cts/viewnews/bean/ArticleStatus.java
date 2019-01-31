package com.cts.viewnews.bean;

public class ArticleStatus {

	private boolean saveArticle;
	private boolean articleExist;

	public ArticleStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSaveArticle() {
		return saveArticle;
	}

	public void setSaveArticle(boolean saveArticle) {
		this.saveArticle = saveArticle;
	}

	public boolean isArticleExist() {
		return articleExist;
	}

	public void setArticleExist(boolean articleExist) {
		this.articleExist = articleExist;
	}

	@Override
	public String toString() {
		return "ArticleStatus [saveArticle=" + saveArticle + ", articleExist=" + articleExist + "]";
	}

}
