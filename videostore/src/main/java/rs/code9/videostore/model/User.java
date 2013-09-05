package rs.code9.videostore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3801171412234268950L;
	
	@NotEmpty(message = "This field is required!")
	private String name;
	
	@NotEmpty(message = "This field is required!")
	private String lastname;
	
	@Email(message = "Not valid email!")
	private String email;
	
	@NotEmpty(message = "This field is required!")
	private Date birthday;
	
	@NotEmpty(message = "This field is required!")
	private String username;
	
	@NotNull
	@Size(min = 5, max = 10, message = "Password must be between 5 and 10 characters long")
	private String password;

	@Column(name = "name")
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
