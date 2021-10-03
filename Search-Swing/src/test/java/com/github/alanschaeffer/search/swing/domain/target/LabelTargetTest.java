package com.github.alanschaeffer.search.swing.domain.target;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Test;

public class LabelTargetTest {

	@Test
	public void test_Search_Target() {
		LabelTarget target = new LabelTarget(new JLabel("my text"));
		
		assertEquals("my text", target.matchableText());
	}
}
