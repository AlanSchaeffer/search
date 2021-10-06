package com.github.alanschaeffer.search.swing.domain.target;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	@Test
	public void test_Extract_Checkboxes() {
		var panel = new JPanel();
		panel.add(new JCheckBox("check"));
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(1, result.size());
		assertEquals("check", result.get(0).matchableText());
	}
	
	@Test
	public void test_Extract_RadioButtons() {
		var panel = new JPanel();
		panel.add(new JRadioButton("radio"));
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(1, result.size());
		assertEquals("radio", result.get(0).matchableText());	
	}
	
	@Test
	public void test_Nested_Label() {
		var panel = new JPanel();
		var otherPanel = new JPanel();
		
		otherPanel.add(new JLabel("t"));
		panel.add(otherPanel);
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(1, result.size());
		assertEquals("t", result.get(0).matchableText());
	}
	
	@Test
	public void test_Nested_In_ScrollPane() {
		var panel = new JPanel();
		var scrollPane = new JScrollPane();
		var view = new JPanel();
		
		view.add(new JLabel("esc"));
		scrollPane.setViewportView(view);
		panel.add(scrollPane);
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(1, result.size());
		assertEquals("esc", result.get(0).matchableText());
	}
	
	@Test
	public void test_Split_Pane() {
		var panel = new JPanel();
		var splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JLabel("left"), new JLabel("right"));
		panel.add(splitPane);
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(2, result.size());
		assertTrue(result.stream().anyMatch(t -> "left".equals(t.matchableText())));
		assertTrue(result.stream().anyMatch(t -> "right".equals(t.matchableText())));
	}
	
	@Test
	public void test_Incomplete_Split_Pane() {
		var splitPaneLeftOnly = new JSplitPane();
		splitPaneLeftOnly.setLeftComponent(new JLabel("left"));
		
		var splitPaneRightOnly = new JSplitPane();
		splitPaneRightOnly.setRightComponent(new JLabel("right"));
		
		var panel = new JPanel();
		panel.add(splitPaneLeftOnly);
		panel.add(splitPaneRightOnly);
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(2, result.size());
		assertTrue(result.stream().anyMatch(t -> "left".equals(t.matchableText())));
		assertTrue(result.stream().anyMatch(t -> "right".equals(t.matchableText())));
	}
	
	@Test
	public void test_Tabbed_Pane() {
		var panel = new JPanel();
		var tabbedPane = new JTabbedPane();
		tabbedPane.add("my", new JLabel("text"));
		panel.add(tabbedPane);
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(1, result.size());
		assertEquals("text", result.get(0).matchableText());
	}
	
	@Test
	public void test_Ignore_Tables() {
		var panel = new JPanel();
		
		var tableModel = new DefaultTableModel(new String[] {"test"}, 0);
		var table = new JTable(tableModel);
		table.createDefaultColumnsFromModel();
		panel.add(table);
		
		var extractor = new ComponentTargetExtractor();
		
		List<SearchTarget> result = extractor.extract(panel);
		assertEquals(0, result.size());
	}
}
