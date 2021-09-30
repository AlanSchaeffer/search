package com.github.alanschaeffer.search.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.alanschaeffer.search.domain.finders.Finder;

public class Finders {
	
	private final List<Function<String, Finder>> finderFactories = new ArrayList<>();

	public Finders add(Function<String, Finder> finderFactory) {
		finderFactories.add(finderFactory);
		return this;
	}
	
	public List<Finder> forQuery(String queryString) {
		return finderFactories.stream()
							  .map(f -> f.apply(queryString))
							  .collect(Collectors.toList());
	}
}