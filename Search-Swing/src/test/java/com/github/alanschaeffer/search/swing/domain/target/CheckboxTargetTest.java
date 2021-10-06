package com.github.alanschaeffer.search.swing.domain.target;

import static org.junit.Assert.assertEquals;

import javax.swing.JCheckBox;

import org.junit.Test;

public class CheckboxTargetTest {

	@Test
	public void test_Target() {
		var target = new CheckboxTarget(new JCheckBox("test"));
		
		assertEquals("test", target.matchableText());
	}
}
