package com.github.alanschaeffer.search.domain.finders;

import org.apache.commons.lang3.StringUtils;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class LikeMatch implements Finder {

	@Override
	public boolean match(SearchTarget target, String queryString) {
		return StringUtils.contains(target.matchableText(), queryString);
	}

}
