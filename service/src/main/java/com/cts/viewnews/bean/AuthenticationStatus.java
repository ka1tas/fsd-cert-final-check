package com.cts.viewnews.bean;

public class AuthenticationStatus {

	private boolean authStatus;
	private User user;

	public AuthenticationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationStatus(boolean authStatus, User user) {
		super();
		this.authStatus = authStatus;
		this.user = user;
	}

	public boolean isAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(boolean authStatus) {
		this.authStatus = authStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authStatus=" + authStatus + ", user=" + user + "]";
	}

}
