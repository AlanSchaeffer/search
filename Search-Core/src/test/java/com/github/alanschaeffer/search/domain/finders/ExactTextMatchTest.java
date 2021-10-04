package com.github.alanschaeffer.search.domain.finders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;
import com.github.alanschaeffer.search.domain.targets.StringTarget;

public class ExactTextMatchTest {

	@Test
	public void test_Match() {
		var target = new StringTarget("test");
		
		assertTrue(new ExactTextMatch("test").match(target));
		assertFalse(new ExactTextMatch("tes").match(target));
	}
	
	@Test
	public void test_Null_Safe() {
		assertFalse(new ExactTextMatch("test").match(new StringTarget(null)));
		assertFalse(new ExactTextMatch(null).match(new StringTarget("test")));
	}
}
