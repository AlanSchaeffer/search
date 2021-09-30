package com.github.alanschaeffer.search.domain.finders;

import org.apache.commons.lang3.StringUtils;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class LikeMatch implements Finder {

	private final String queryString;

	public LikeMatch(String queryString) {
		this.queryString = queryString;
	}
	
	@Override
	public boolean match(SearchTarget target) {
		return StringUtils.contains(target.matchableText(), queryString);
	}
}
