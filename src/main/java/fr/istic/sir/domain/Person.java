package fr.istic.sir.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Person {

	private int id;
	
	private String lastName;
	
	private String firstName;
	
	private String sex;
	
	private String email;
	
	private Date birthday;
	
	private String facebook;
	
	private List<Home> homes = new ArrayList<Home>();
	
	private List<Person> friends = new ArrayList<Person>();

	public Person(String firstName, String lastName, String sex, String email,  String facebook) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex= sex;
		this.email = email;
		this.facebook = facebook;
	}
	
	public Person(){}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	public List<Home> getHomes() {
		return homes;
	}

	public void setHomes(List<Home> homes) {
		this.homes = homes;
	}
	
	@ManyToMany
	@JoinTable(name="Friends")
	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
}
