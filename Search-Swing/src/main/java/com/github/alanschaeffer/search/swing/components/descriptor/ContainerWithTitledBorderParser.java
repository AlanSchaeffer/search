package com.github.alanschaeffer.search.swing.components.descriptor;

import java.awt.Container;
import java.util.Optional;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class ContainerWithTitledBorderParser implements ComponentDescriptorParser {

	@Override
	public Optional<String> parse(Container component, Container innerComponent) {
		if(component instanceof JComponent jc) {
			if(jc.getBorder() instanceof TitledBorder tb) {
				return Optional.ofNullable(tb.getTitle());
			}
		}
		return Optional.empty();
	}

}
