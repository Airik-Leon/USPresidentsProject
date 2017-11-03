package com.skilldistillery.data;

public class President {
	private String name;
	private String party;
	private int termNumber;
	private String fact;
	private int dateInOffice;

	public President() {
	}

	public President(String name, String party, int termNumber, String fact, int dateInOffice) {
		super();
		this.name = name;
		this.party = party;
		this.termNumber = termNumber;
		this.fact = fact;
		this.dateInOffice = dateInOffice;
	}

	public String getName() {
		return name;
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

	public int getDateInOffice() {
		return dateInOffice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [name=");
		builder.append(name);
		builder.append(", party=");
		builder.append(party);
		builder.append(", termNumber=");
		builder.append(termNumber);
		builder.append(", fact=");
		builder.append(fact);
		builder.append(", dateInOffice=");
		builder.append(dateInOffice);
		builder.append("]");
		return builder.toString();
	}
}
