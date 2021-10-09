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
}
