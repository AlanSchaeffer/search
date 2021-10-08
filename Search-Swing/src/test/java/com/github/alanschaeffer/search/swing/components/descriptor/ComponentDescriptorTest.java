package com.github.alanschaeffer.search.swing.components.descriptor;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import org.junit.Test;

public class ComponentDescriptorTest {

	@Test
	public void test_Describe_Orphan_Label() {
		var label = new JLabel("My label");
		
		var descriptor = new ComponentDescriptor();
		
		assertEquals("My label", descriptor.describe(label));
	}
	
	@Test
	public void test_Describe_Titled_Panel() { 
		var panel = new JPanel();
		panel.setBorder(new TitledBorder("Title"));
		
		var descriptor = new ComponentDescriptor();
		
		assertEquals("Title", descriptor.describe(panel));
	}
	
	@Test
	public void test_Describe_Path() {
		var panel = new JPanel();
		panel.setBorder(new TitledBorder("Title"));
		
		var label = new JLabel("My label");
		panel.add(label);
		
		var descriptor = new ComponentDescriptor();
		
		assertEquals("Title -> My label", descriptor.describe(label));
	}
	
	@Test
	public void test_Skip_Empty_Nodes() {
		var panel = new JPanel();
		panel.setBorder(new TitledBorder("Title"));
		
		var innerPannel = new JPanel();
		panel.add(innerPannel);
		
		var label = new JLabel("My label");
		innerPannel.add(label);
		
		var descriptor = new ComponentDescriptor();
		
		assertEquals("Title -> My label", descriptor.describe(label));		
	}
	
	@Test
	public void test_Describe_Tab() {
		var label1 = new JLabel("My label");
		var label2 = new JLabel("Other label");
		
		var tabbedPane = new JTabbedPane();
		tabbedPane.add("First", label1);
		tabbedPane.add("Second", label2);
		
		var descriptor = new ComponentDescriptor();
		
		assertEquals("First -> My label", descriptor.describe(label1));
		assertEquals("Second -> Other label", descriptor.describe(label2));
	}
	
	@Test
	public void test_Custom_Parser_Stack() {
		var label = new JLabel("My label");
		
		var tabbedPane = new JTabbedPane();
		tabbedPane.add("First", label);
		
		var descriptor = new ComponentDescriptor(List.of(new TabParser()));
		
		assertEquals("First", descriptor.describe(label));
	}
	
	@Test
	public void test_Stop_Rule() {
		var label = new JLabel("My label");
		
		var tabbedPane = new JTabbedPane();
		tabbedPane.add("First", label);
		
		var descriptor = new ComponentDescriptor();
		descriptor.stopWhen(c -> tabbedPane.equals(c));
		
		assertEquals("My label", descriptor.describe(label));		
	}
}
