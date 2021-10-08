package com.github.alanschaeffer.search.swing.components.descriptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.junit.Test;

public class ContainerWithTitledBorderParserTest {

	@Test
	public void test_Parse_Titled_Panel() {
		var panel = new JPanel();
		panel.setBorder(new TitledBorder("test"));
		
		assertEquals("test", new ContainerWithTitledBorderParser().parse(panel, null).get());
	}
	
	@Test
	public void test_Skip_Non_Titled_Panel() {
		assertTrue(new ContainerWithTitledBorderParser().parse(new JPanel(), null).isEmpty());
	}
	
	@Test
	public void test_Skip_Others() {
		assertTrue(new ContainerWithTitledBorderParser().parse(new JLabel("etc"), null).isEmpty());
	}
}
