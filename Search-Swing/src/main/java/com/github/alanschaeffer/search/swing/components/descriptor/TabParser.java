package com.github.alanschaeffer.search.swing.components.descriptor;

import java.awt.Container;
import java.util.Optional;

import javax.swing.JTabbedPane;

public class TabParser implements ComponentDescriptorParser {

	@Override
	public Optional<String> parse(Container component, Container innerComponent) {
		if(component instanceof JTabbedPane tp) {
			int index = tp.indexOfComponent(innerComponent);
			
			if(index != -1) {
				return Optional.ofNullable(tp.getTitleAt(index));
			}
		}
		return Optional.empty();
	}
}
