package com.cts.viewnews.bean;

public class UserArticle {

	private Article article;
	private User user;

	public UserArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserArticle [article=" + article + ", user=" + user + "]";
	}

}
