package com.github.alanschaeffer.search.swing.components.highlighter;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.junit.Test;

public class ComponentHighlighterTest {

	@Test
	public void test_Highlight() {
		var component = new JLabel("label");
	
		var effect = new TestEffect(c -> ((JLabel) c).setText("activated"), c -> {});
		var highlighter = new ComponentHighlighter(effect);
		
		highlighter.highlight(component);
		
		assertEquals("activated", component.getText());
	}
	
	@Test
	public void test_Only_One_Highlighted_Component_At_A_Time() {
		var label1 = new JLabel("original");
		var label2 = new JLabel("original");
		
		var effect = new TestEffect(c -> ((JLabel) c).setText("activated"), c -> ((JLabel) c).setText("original"));
		var highlighter = new ComponentHighlighter(effect);
		
		highlighter.highlight(label1);
		
		assertEquals("activated", label1.getText());
		assertEquals("original", label2.getText());
		
		highlighter.highlight(label2);
		
		assertEquals("original", label1.getText());
		assertEquals("activated", label2.getText());
	}
	
	@Test
	public void test_Unhighlight_Trigger() {
		var component = new JLabel("original");
		
		var effect = new TestEffect(c -> ((JLabel) c).setText("activated"), c -> ((JLabel) c).setText("original"));
		var unhighlightTrigger = new TestUnhighlightTrigger();
		var highlighter = new ComponentHighlighter(effect);
		highlighter.setUnhighlightTrigger(unhighlightTrigger);
		
		highlighter.highlight(component);
		
		assertEquals("activated", component.getText());
		
		unhighlightTrigger.trigger();
		
		assertEquals("original", component.getText());
	}
	
	@Test
	public void test_Dont_Unhighlight_Unrelated_Component() {
		var component = new JLabel("original");
		var unrelatedComponent = new JLabel("other");
		
		var effect = new TestEffect(c -> ((JLabel) c).setText("activated"), c -> ((JLabel) c).setText("original"));
		var highlighter = new ComponentHighlighter(effect);
		highlighter.setUnhighlightTrigger(r -> highlighter.unhighlight(unrelatedComponent));
		
		highlighter.highlight(component);
		
		assertEquals("activated", component.getText());
		assertEquals("other", unrelatedComponent.getText());
	}
	
	private static class TestEffect implements Effect {
		
		private Consumer<JComponent> activateEffect;
		private Consumer<JComponent> deactivateEffect;

		public TestEffect(Consumer<JComponent> activateEffect, Consumer<JComponent> deactivateEffect) {
			this.activateEffect = activateEffect;
			this.deactivateEffect = deactivateEffect;
		}

		@Override
		public void activate(JComponent component) {
			activateEffect.accept(component);
		}

		@Override
		public void deactivate(JComponent component) {
			deactivateEffect.accept(component);
		}
	}
	
	private static class TestUnhighlightTrigger implements UnhighlightTrigger {

		private Runnable current;
		
		@Override
		public void activate(Runnable unhighlight) {
			current = unhighlight;
		}
		
		public void trigger() {
			if(current != null) current.run();
		}
	}
}
