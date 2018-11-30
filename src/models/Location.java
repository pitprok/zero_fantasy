package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="background_url")
	private String backgroundUrl;

	private String description;

	@Column(name="first_choice")
	private String firstChoice;
	
	@Column(name="first_consequence_code",columnDefinition = "json")
	private String firstConsequenceCode;
	
	@Column(name="first_consequence_text")
	private String firstConsequenceText;
	
	@Column(name="location_json",columnDefinition = "json")
	private String locationJson;

	private String name;

	@Column(name="second_choice")
	private String secondChoice;
	
	@Column(name="second_consequence_code",columnDefinition = "json")
	private String secondConsequenceCode;

	@Column(name="second_consequence_text")
	private String secondConsequenceText;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBackgroundUrl() {
		return this.backgroundUrl;
	}

	public void setBackgroundUrl(String backgroundUrl) {
		this.backgroundUrl = backgroundUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFirstChoice() {
		return this.firstChoice;
	}

	public void setFirstChoice(String firstChoice) {
		this.firstChoice = firstChoice;
	}

	public String getFirstConsequenceCode() {
		return this.firstConsequenceCode;
	}

	public void setFirstConsequenceCode(String firstConsequenceCode) {
		this.firstConsequenceCode = firstConsequenceCode;
	}

	public String getFirstConsequenceText() {
		return this.firstConsequenceText;
	}

	public void setFirstConsequenceText(String firstConsequenceText) {
		this.firstConsequenceText = firstConsequenceText;
	}

	public String getLocationJson() {
		return this.locationJson;
	}

	public void setLocationJson(String locationJson) {
		this.locationJson = locationJson;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondChoice() {
		return this.secondChoice;
	}

	public void setSecondChoice(String secondChoice) {
		this.secondChoice = secondChoice;
	}

	public String getSecondConsequenceCode() {
		return this.secondConsequenceCode;
	}

	public void setSecondConsequenceCode(String secondConsequenceCode) {
		this.secondConsequenceCode = secondConsequenceCode;
	}

	public String getSecondConsequenceText() {
		return this.secondConsequenceText;
	}

	public void setSecondConsequenceText(String secondConsequenceText) {
		this.secondConsequenceText = secondConsequenceText;
	}

}