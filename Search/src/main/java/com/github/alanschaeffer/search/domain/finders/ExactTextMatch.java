package com.github.alanschaeffer.search.domain.finders;

import org.apache.commons.lang3.StringUtils;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class ExactTextMatch implements Finder {

	private final String queryString;

	public ExactTextMatch(String queryString) {
		this.queryString = queryString;
	}
	
	@Override
	public boolean match(SearchTarget target) {
		return StringUtils.equals(target.matchableText(), queryString);
	}

}
