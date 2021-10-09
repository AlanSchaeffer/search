package com.github.alanschaeffer.search.swing.components.highlighter;

import javax.swing.JComponent;

public class ComponentHighlighter {

	private final Effect effect;

	public ComponentHighlighter(Effect effect) {
		this.effect = effect;
	}

	public void highlight(JComponent component) {
		effect.activate(component);
	}
}
