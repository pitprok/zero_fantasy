package models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the creature database table.
 * 
 */
@Entity
@NamedQuery(name="Creature.findAll", query="SELECT c FROM Creature c")
public class Creature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int accuracy;

	private int armor;

	private int attack;

	private int hitpoints;

	private String name;

	private int speed;

	//bi-directional many-to-one association to Monster
	@OneToMany(mappedBy="creature")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Monster> monsters;

	public Creature() {
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

	public List<Monster> getMonsters() {
		return this.monsters;
	}

	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}

	public Monster addMonster(Monster monster) {
		getMonsters().add(monster);
		monster.setCreature(this);

		return monster;
	}

	public Monster removeMonster(Monster monster) {
		getMonsters().remove(monster);
		monster.setCreature(null);

		return monster;
	}

}