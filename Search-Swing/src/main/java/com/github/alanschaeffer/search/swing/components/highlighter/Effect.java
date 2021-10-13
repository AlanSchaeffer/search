package com.github.alanschaeffer.search.swing.components.highlighter;

import javax.swing.JComponent;

public interface Effect {

	void activate(JComponent component);

	void deactivate(JComponent component);
}
