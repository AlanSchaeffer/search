package com.github.alanschaeffer.search.domain.finders;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class WordsMatch implements Finder {

	private final String[] words;
	
	public WordsMatch(String queryString) {
		if(queryString == null) {
			words = new String[0];
		} else {
			this.words = toWords(queryString);
		}
	}
	
	private String[] toWords(String queryString) {
		return Stream.of(StringUtils.split(queryString))
					 .map(s -> " " + s + " ")
					 .collect(Collectors.toList())
					 .toArray(new String[0]);
	}
	
	@Override
	public boolean match(SearchTarget target) {
		if(words.length == 0) return false;
		return StringUtils.containsAny(" " + target.matchableText() + " ", words);
	}
}
