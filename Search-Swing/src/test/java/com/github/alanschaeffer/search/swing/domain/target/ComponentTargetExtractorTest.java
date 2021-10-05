package com.github.alanschaeffer.search.swing.domain.target;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class ComponentTargetExtractorTest {

	@Test
	public void test_Extract_Labels() {
		var panel = new JPanel();
		panel.add(new JLabel("text"));
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		
		assertEquals(1, result.size());
		assertEquals("text", result.get(0).matchableText());
	}
}
