package com.github.alanschaeffer.search.swing.components.descriptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

public class LabelParserTest {

	@Test
	public void test_Parse_Label() {
		var label = new JLabel("my");
		
		assertEquals("my", new LabelParser().parse(label, null).get());
	}
	
	@Test
	public void test_Skip_Others() {
		assertTrue(new LabelParser().parse(new JPanel(), null).isEmpty());
	}
}
