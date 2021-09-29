package com.github.alanschaeffer.search.domain.finders;

import org.apache.commons.lang3.StringUtils;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class ExactTextMatch implements Finder {

	@Override
	public boolean match(SearchTarget target, String queryString) {
		return StringUtils.equals(target.matchableText(), queryString);
	}

}
