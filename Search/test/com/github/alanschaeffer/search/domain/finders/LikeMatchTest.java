package com.github.alanschaeffer.search.domain.finders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;
import com.github.alanschaeffer.search.domain.targets.StringTarget;

public class LikeMatchTest {

	@Test
	public void test_Match() {
		SearchTarget target = new StringTarget("my test etc etc");
		
		LikeMatch matcher = new LikeMatch();
		
		assertTrue(matcher.match(target, "my test etc etc"));
		assertTrue(matcher.match(target, "test"));
		assertTrue(matcher.match(target, "c et"));
		assertFalse(matcher.match(target, "teste"));
	}
	
	@Test
	public void test_Null_Safe() {
		LikeMatch matcher = new LikeMatch();
		assertFalse(matcher.match(new StringTarget(null), "teste"));
		assertFalse(matcher.match(new StringTarget("teste"), null));
	}
}
