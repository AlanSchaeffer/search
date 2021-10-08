package com.github.alanschaeffer.search.swing.domain.targets;

import javax.swing.JCheckBox;

public class CheckboxTarget implements ComponentTarget<JCheckBox> {

	private final JCheckBox checkbox;

	public CheckboxTarget(JCheckBox checkbox) {
		this.checkbox = checkbox;
	}
	
	@Override
	public String matchableText() {
		return checkbox.getText();
	}

	@Override
	public JCheckBox getComponent() {
		return checkbox;
	}
}
