package com.github.alanschaeffer.search.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.alanschaeffer.search.domain.finders.Finder;
import com.github.alanschaeffer.search.domain.result.SearchResult;
import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class Query {

	private final List<Finder> finders;

	Query(List<Finder> finders) {
		this.finders = finders;
	}

	public <T extends SearchTarget> SearchResult<T> in(List<T> targets) {
		return new SearchResult<>(targets.stream()
										 .map(t -> finders.stream()
												 		  .filter(f -> f.match(t))
												 		  .findFirst()
												 		  .map(f -> new SearchHit<>(t, finders.indexOf(f))))
										 .filter(Optional::isPresent)
										 .map(Optional::get)
										 .sorted(Comparator.comparing(h -> h.priority))
										 .map(h -> h.target)
										 .collect(Collectors.toList()));
	}
	
	private static class SearchHit<T extends SearchTarget> {
		private final T target;
		private final int priority;
		
		public SearchHit(T target, int priority) {
			this.target = target;
			this.priority = priority;
		}
	}
}