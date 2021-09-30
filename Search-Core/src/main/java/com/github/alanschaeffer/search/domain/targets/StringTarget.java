package com.github.alanschaeffer.search.domain.targets;

public class StringTarget implements SearchTarget {

	private final String string;

	public StringTarget(String string) {
		this.string = string;
	}

	@Override
	public String matchableText() {
		return string;
	}
	
	@Override
	public String toString() {
		return "StringTarget(" + string + ")";
	}
}
