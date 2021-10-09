package com.github.alanschaeffer.search.swing.components.highlighter;

import javax.swing.JComponent;
import javax.swing.JLabel;

public interface Effect {

	void activate(JComponent component);

	void deactivate(JComponent component);
}
