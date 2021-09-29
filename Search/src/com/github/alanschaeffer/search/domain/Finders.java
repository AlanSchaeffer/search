package com.github.alanschaeffer.search.domain;

import java.util.ArrayList;
import java.util.List;

import com.github.alanschaeffer.search.domain.finders.Finder;

public class Finders {
	
	private final List<Finder> finders = new ArrayList<>();

	public Finders add(Finder finder) {
		finders.add(finder);
		return this;
	}
	
	public List<Finder> list() {
		return new ArrayList<>(finders);
	}
}