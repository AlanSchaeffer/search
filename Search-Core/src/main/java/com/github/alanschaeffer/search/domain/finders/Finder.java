package com.github.alanschaeffer.search.domain.finders;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public interface Finder {

	boolean match(SearchTarget target);
}
