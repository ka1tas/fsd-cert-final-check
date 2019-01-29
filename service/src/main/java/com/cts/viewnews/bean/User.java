package com.cts.viewnews.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
// @Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "us_id",
// "us_name", "us_password", "us_email","us_username","us_role","us_language" })
// })
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	// @NotNull(message = "Name cannot be empty")
	// @Size(min = 1,max=50, message = "Name must be of 1 to 20 characters")
	@Column(name = "us_name")
	private String name;

	// @NotNull(message = "Email cannot be empty")
	// @Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	// @Size(min = 1,max=250, message = "Email must be of 3 to 250 characters")
	@Column(name = "us_email")
	private String email;

	// @NotNull(message = "Password cannot be empty")
	// @Size(min =3,max=25, message = "Passsword must be of 3 to 25 characters")
	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_blocked")
	private String blocked;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "us_role")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "us_language")
	private Language language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", blocked="
				+ blocked + ", role=" + role + ", language=" + language + "]";
	}




}
