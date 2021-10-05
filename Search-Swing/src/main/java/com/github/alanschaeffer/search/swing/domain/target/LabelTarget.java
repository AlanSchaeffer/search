package com.github.alanschaeffer.search.swing.domain.target;

import javax.swing.JLabel;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class LabelTarget implements SearchTarget {

	private final JLabel label;

	public LabelTarget(JLabel label) {
		this.label = label;
	}
	
	@Override
	public String matchableText() {
		return label.getText();
	}
	
	public JLabel getComponent() {
		return label;
	}
}
