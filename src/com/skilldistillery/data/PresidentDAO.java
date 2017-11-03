package com.skilldistillery.data;

import java.util.List;

public interface PresidentDAO {
		public List<President> filter();
		public President getPresident(int termNumber);
		public List<President> getPresidentsByParty(String party);
		public List<President> getListPresidents();
	}

