package com.github.alanschaeffer.search.swing.domain.targets;

import javax.swing.JRadioButton;

public class RadioButtonTarget implements ComponentTarget<JRadioButton> {

	private final JRadioButton radioButton;

	public RadioButtonTarget(JRadioButton radioButton) {
		this.radioButton = radioButton;
	}
	
	@Override
	public String matchableText() {
		return radioButton.getText();
	}

	@Override
	public JRadioButton getComponent() {
		return radioButton;
	}
}
