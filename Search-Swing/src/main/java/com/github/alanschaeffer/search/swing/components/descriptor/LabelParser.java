package com.github.alanschaeffer.search.swing.components.descriptor;

import java.awt.Container;
import java.util.Optional;

import javax.swing.JLabel;

public class LabelParser implements ComponentDescriptorParser {

	@Override
	public Optional<String> parse(Container component, Container innerComponent) {
		if(component instanceof JLabel l) {
			return Optional.ofNullable(l.getText());
		}
		return Optional.empty();
	}
}
