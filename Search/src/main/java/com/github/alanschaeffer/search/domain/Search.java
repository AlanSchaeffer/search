package com.github.alanschaeffer.search.domain;

public class Search {

	private Finders finders = new Finders();
	
	public Finders finders() {
		return finders;
	}

	public Query find(String queryString) {
		return new Query(finders.forQuery(queryString));
	}
}
