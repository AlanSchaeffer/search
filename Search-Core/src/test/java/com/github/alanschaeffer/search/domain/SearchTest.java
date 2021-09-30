package com.github.alanschaeffer.search.domain;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.finders.ExactTextMatch;
import com.github.alanschaeffer.search.domain.finders.LikeMatch;
import com.github.alanschaeffer.search.domain.result.SearchResult;
import com.github.alanschaeffer.search.domain.targets.SearchTarget;
import com.github.alanschaeffer.search.domain.targets.StringTarget;

public class SearchTest {

	@Test
	public void test_Search() {
		StringTarget testTarget = new StringTarget("test");
		StringTarget otherTarget = new StringTarget("other");
		
		List<SearchTarget> targets = Arrays.asList(testTarget, otherTarget);
		
		Search search = new Search();
		search.finders().add(ExactTextMatch::new);
		SearchResult<SearchTarget> result = search.find("test").in(targets);
		
		assertEquals(1, result.hits());
		assertEquals(testTarget, result.hit(0));
	}
	
	@Test
	public void test_Finder_Priority() {
		StringTarget exactTarget = new StringTarget("test");
		StringTarget partialTarget = new StringTarget("unit test");
		StringTarget anotherPartialTarget = new StringTarget("testing environment");
		StringTarget unrelated = new StringTarget("rats");
		
		List<SearchTarget> targets = Arrays.asList(partialTarget, exactTarget, anotherPartialTarget, unrelated);
		
		Search search = new Search();
		search.finders().add(ExactTextMatch::new)
						.add(LikeMatch::new);
		SearchResult<SearchTarget> result = search.find("test").in(targets);
		
		assertEquals(3, result.hits());
		assertEquals(exactTarget, result.hit(0));
		assertEquals(partialTarget, result.hit(1));
		assertEquals(anotherPartialTarget, result.hit(2));
	}
}
