package com.github.alanschaeffer.search.domain.finders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.targets.StringTarget;

public class WordsMatchTest {

	@Test
	public void test_Match() {
		String query = "o rato roeu a roupa do rei de roma";
		
		var matcher = new WordsMatch(query);
		
		assertTrue(matcher.match(new StringTarget("rato")));
		assertTrue(matcher.match(new StringTarget("roupa")));
		assertTrue(matcher.match(new StringTarget("do")));
		assertFalse(matcher.match(new StringTarget("rainha")));
	}
	
	@Test
	public void test_Null_Safe() {
		assertFalse(new WordsMatch("q").match(new StringTarget(null)));
		assertFalse(new WordsMatch(null).match(new StringTarget("q")));
	}
}
