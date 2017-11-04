package com.skilldistillery.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
public class USPresidentDAOImpl implements PresidentDAO {
	private List<President> presList;
	public USPresidentDAOImpl() {
		presList = new ArrayList<>(); 
		loadPresidents(); 
	}
	public void loadPresidents() {
		File filename = new File("WebContent/WEB-INF/Presidents.txt"); 
		FileReader fr; 
		BufferedReader br; 
		try {
			fr = new FileReader(filename); 
			br = new BufferedReader(fr);
			String line = br.readLine();
			President currentPresident; 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy"); 
			while((line = br.readLine()) != null) {
				String[] lineAsArray = line.split("&"); 
				currentPresident = new President(); 
				try {
					currentPresident.setTermNumber(Integer.parseInt(lineAsArray[0].trim()));
					currentPresident.setFirstName(lineAsArray[1]);
					currentPresident.setMiddleName(lineAsArray[2]);
					currentPresident.setLastName(lineAsArray[3]);
					//still need to check for incomplete years
					currentPresident.setTermStarted(LocalDate.parse(lineAsArray[4].trim(), formatter));
					if(currentPresident.getTermNumber() != 45) {
						currentPresident.setTermEnded(LocalDate.parse(lineAsArray[5].trim(), formatter));
					}
					currentPresident.setParty(lineAsArray[6]);
					if(currentPresident.getTermNumber()== 45) {
						currentPresident.setFact(lineAsArray[6]);
					}
					else {
						//need to set all facts for errors to stop occurring 
						currentPresident.setFact(lineAsArray[7]); 
						
					}
				}
				catch(NumberFormatException nfe) {
					nfe.printStackTrace();
				}
				catch(NullPointerException ex) {
					ex.printStackTrace();
				}
				presList.add(currentPresident); 
			}
		}
		catch(IOException error) {
			error.printStackTrace();
		}
	}
	@Override
	public President getPresident(int termNumber) {
		return null;
	}

	@Override
	public List<President> getPresidentsByParty(String party) {
		BiPredicate<President, String> partyFilter= (x,s)->x.getParty().equals(s); 
		return this.filter(partyFilter, party); 
	}

	@Override
	public List<President> getListPresidents() {
		return presList;
	}

	@Override
	public List<President> filter(BiPredicate<President, String> matcher, String party) {
		List<President> filtered = new ArrayList<>();
		for (President p : presList) {
			if (matcher.test(p, party)) {
				filtered.add(p);
				System.out.println(p);
			}
		}
		return filtered;
	}

}
