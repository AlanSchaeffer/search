package com.github.alanschaeffer.search.swing.domain.target;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class ComponentTargetExtractor {

	public List<SearchTarget> extract(JPanel panel) {
		List<SearchTarget> result = new ArrayList<>();
		
		for (Component component : panel.getComponents()) {
			if(component instanceof JLabel) {
				result.add(new LabelTarget((JLabel) component));
			}
		}
		
		return result;
	}
}
