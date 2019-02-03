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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authStatus ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthenticationStatus other = (AuthenticationStatus) obj;
		if (authStatus != other.authStatus)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authStatus=" + authStatus + ", user=" + user + "]";
	}

}
