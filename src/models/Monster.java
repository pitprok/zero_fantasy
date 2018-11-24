package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the monster database table.
 * 
 */
@Entity
@NamedQuery(name="Monster.findAll", query="SELECT m FROM Monster m")
public class Monster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int accuracy;

	private int armor;

	private int attack;

	private int hitpoints;

	private String name;

	private int speed;

	//bi-directional many-to-one association to Creature
	@ManyToOne
	private Creature creature;

	public Monster() {
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

	public Creature getCreature() {
		return this.creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

}