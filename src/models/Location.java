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
	@Lob
	@Column(name="first_consequence_code",columnDefinition = "json")
	private Object firstConsequenceCode;
	
	@Column(name="first_consequence_text")
	private String firstConsequenceText;
	@Lob
	@Column(name="location_json",columnDefinition = "json")
	private Object locationJson;

	private String name;

	@Column(name="second_choice")
	private String secondChoice;
	@Lob
	@Column(name="second_consequence_code",columnDefinition = "json")
	private Object secondConsequenceCode;

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

	public Object getFirstConsequenceCode() {
		return this.firstConsequenceCode;
	}

	public void setFirstConsequenceCode(Object firstConsequenceCode) {
		this.firstConsequenceCode = firstConsequenceCode;
	}

	public String getFirstConsequenceText() {
		return this.firstConsequenceText;
	}

	public void setFirstConsequenceText(String firstConsequenceText) {
		this.firstConsequenceText = firstConsequenceText;
	}

	public Object getLocationJson() {
		return this.locationJson;
	}

	public void setLocationJson(Object locationJson) {
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

	public Object getSecondConsequenceCode() {
		return this.secondConsequenceCode;
	}

	public void setSecondConsequenceCode(Object secondConsequenceCode) {
		this.secondConsequenceCode = secondConsequenceCode;
	}

	public String getSecondConsequenceText() {
		return this.secondConsequenceText;
	}

	public void setSecondConsequenceText(String secondConsequenceText) {
		this.secondConsequenceText = secondConsequenceText;
	}

}