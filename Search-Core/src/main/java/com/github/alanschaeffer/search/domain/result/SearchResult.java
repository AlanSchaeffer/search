package com.github.alanschaeffer.search.domain.result;

import java.util.List;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class SearchResult<T extends SearchTarget> {

	private final List<T> hits;

	public SearchResult(List<T> hits) {
		this.hits = hits;
	}
	
	public int hits() {
		return hits.size();
	}

	public T hit(int i) {
		if(i >= hits.size()) return null;
		return hits.get(i);
	}
}
