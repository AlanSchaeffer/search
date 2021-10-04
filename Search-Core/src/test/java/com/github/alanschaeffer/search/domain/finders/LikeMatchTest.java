package com.github.alanschaeffer.search.domain.finders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;
import com.github.alanschaeffer.search.domain.targets.StringTarget;

public class LikeMatchTest {

	@Test
	public void test_Match() {
		var target = new StringTarget("my test etc etc");
		
		assertTrue(new LikeMatch("my test etc etc").match(target));
		assertTrue(new LikeMatch("test").match(target));
		assertTrue(new LikeMatch("c et").match(target));
		assertFalse(new LikeMatch("teste").match(target));
	}
	
	@Test
	public void test_Null_Safe() {
		assertFalse(new LikeMatch("teste").match(new StringTarget(null)));
		assertFalse(new LikeMatch(null).match(new StringTarget("teste")));
	}
}
