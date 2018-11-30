package models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;


/**
 * The persistent class for the profession database table.
 * 
 */
@Entity
@NamedQuery(name="Profession.findAll", query="SELECT p FROM Profession p")
public class Profession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int accuracy;

	private int armor;

	private int attack;

	private int hitpoints;

	private String name;

	private int speed;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="profession")
	 @LazyCollection(LazyCollectionOption.FALSE)
	private List<User> users;

	public Profession() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getArmor() {
		return this.armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getHitpoints() {
		return this.hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setProfession(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setProfession(null);

		return user;
	}

}