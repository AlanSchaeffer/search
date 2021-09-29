package com.github.alanschaeffer.search.domain.finders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.finders.ExactTextMatch;
import com.github.alanschaeffer.search.domain.targets.SearchTarget;
import com.github.alanschaeffer.search.domain.targets.StringTarget;

public class ExactTextMatchTest {

	@Test
	public void test_Match() {
		SearchTarget target = new StringTarget("test");
		ExactTextMatch matcher = new ExactTextMatch();
		
		assertTrue(matcher.match(target, "test"));
		assertFalse(matcher.match(target, "tes"));
	}
	
	@Test
	public void test_Null_Safe() {
		ExactTextMatch matcher = new ExactTextMatch();
		
		assertFalse(matcher.match(new StringTarget(null), "test"));
		assertFalse(matcher.match(new StringTarget("test"), null));
	}
}
