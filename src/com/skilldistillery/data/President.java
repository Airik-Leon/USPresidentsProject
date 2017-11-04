package com.skilldistillery.data;

import java.time.LocalDate;

public class President {
	private int termNumber;
	private String firstName;
	private String middleName; 
	private String lastName; 
	private LocalDate termStarted;
	private LocalDate termEnded; 
	private String party;
	private String fact;
	private String URL;

	public President() {
	}

	public President(String firstName, String middleName, String lastName, String party, int termNumber, String fact, LocalDate termStarted, LocalDate termEnded, String URL) {
		super();
		this.firstName = firstName;
		this.middleName = middleName; 
		this.lastName = lastName; 
		this.party = party;
		this.termNumber = termNumber;
		this.fact = fact;
		this.termStarted = termStarted;
		this.termEnded = termEnded; 
		this.URL = URL;
	}
	public President(String firstName, String middleName, String lastName, String party, int termNumber, String fact, String URL) {
		super();
		this.firstName = firstName;
		this.middleName = middleName; 
		this.lastName = lastName; 
		this.party = party;
		this.termNumber = termNumber;
		this.fact = fact;

		this.URL = URL;
	}


	public String getUrl() {
		return URL;
	}

	public String getParty() {
		return party;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public String getFact() {
		return fact;
	}
	public void setName(String name) {
		this.firstName = name;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getTermEnded() {
		return this.termEnded; 
	}
	public LocalDate getTermStarted() {
		return this.termStarted; 
	}
	public void setTermEnded(LocalDate termEnded) {
		this.termEnded = termEnded;
	}
	public void setTermStarted(LocalDate termStarted) {
		this.termStarted = termStarted;
	}
	

	public void setUrl(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [termNumber=");
		builder.append(termNumber);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", termStarted=");
		builder.append(termStarted);
		builder.append(", termEnded=");
		builder.append(termEnded);
		builder.append(", party=");
		builder.append(party);
		builder.append(", fact=");
		builder.append(fact);
		builder.append("]");
		return builder.toString();
	}

}
