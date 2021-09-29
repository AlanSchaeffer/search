package com.github.alanschaeffer.search.domain;

import java.util.List;
import java.util.stream.Collectors;

import com.github.alanschaeffer.search.domain.finders.Finder;
import com.github.alanschaeffer.search.domain.result.SearchResult;
import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class Query {

	private final String queryString;
	private final List<Finder> finders;

	public Query(String queryString, List<Finder> finders) {
		this.queryString = queryString;
		this.finders = finders;
	}

	public <T extends SearchTarget> SearchResult<T> in(List<T> targets) {
		return new SearchResult<>(targets.stream()
										 .filter(t -> finders.stream().anyMatch(f -> f.match(t, queryString)))
										 .collect(Collectors.toList()));
	}
	
}