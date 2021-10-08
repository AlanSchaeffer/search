package com.github.alanschaeffer.search.swing.domain.targets;

import javax.swing.JLabel;

public class LabelTarget implements ComponentTarget<JLabel> {

	private final JLabel label;

	public LabelTarget(JLabel label) {
		this.label = label;
	}
	
	@Override
	public String matchableText() {
		return label.getText();
	}

	@Override
	public JLabel getComponent() {
		return label;
	}
}
