package com.github.alanschaeffer.search.swing.domain.targets;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Test;

import com.github.alanschaeffer.search.swing.domain.targets.LabelTarget;

public class LabelTargetTest {

	@Test
	public void test_Search_Target() {
		LabelTarget target = new LabelTarget(new JLabel("my text"));
		
		assertEquals("my text", target.matchableText());
	}
}
