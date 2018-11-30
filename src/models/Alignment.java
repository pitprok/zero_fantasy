package models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;


/**
 * The persistent class for the alignment database table.
 * 
 */
@Entity
@NamedQuery(name="Alignment.findAll", query="SELECT a FROM Alignment a")
public class Alignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="alignment")
	 @LazyCollection(LazyCollectionOption.FALSE)
	private List<User> users;

	public Alignment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAlignment(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAlignment(null);

		return user;
	}

}