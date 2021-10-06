package com.github.alanschaeffer.search.swing.domain.target;

import static org.junit.Assert.assertEquals;

import javax.swing.JRadioButton;

import org.junit.Test;

public class RadioButtonTargetTest {

	@Test
	public void test_Target() {
		var target = new RadioButtonTarget(new JRadioButton("my"));
		
		assertEquals("my", target.matchableText());
	}
}
