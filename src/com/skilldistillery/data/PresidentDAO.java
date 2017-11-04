package com.skilldistillery.data;

import java.util.List;
import java.util.function.BiPredicate;

public interface PresidentDAO {
		public List<President> filter(BiPredicate<President, String> matcher, String restrictions);
		public President getPresident(int termNumber);
		public List<President> getPresidentsByParty(String party);
		public List<President> getListPresidents();
	}

