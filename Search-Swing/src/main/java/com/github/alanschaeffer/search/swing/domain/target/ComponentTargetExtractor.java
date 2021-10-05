package com.github.alanschaeffer.search.swing.domain.target;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public class ComponentTargetExtractor {

	public List<SearchTarget> extract(Container panel) {
		List<SearchTarget> result = new ArrayList<>();
		Queue<Component> componentQueue = new LinkedList<>();
		componentQueue.add(panel);
		
		while(!componentQueue.isEmpty()) {
			Component component = componentQueue.poll();
			
			if(component instanceof JTable) {
				// no need to check certain containers further
				continue;
			}
			
			if(component instanceof JLabel l) {
				result.add(new LabelTarget(l));
			} else if(component instanceof JScrollPane s) {
				// optimization for scroll pane, only viewport needs to be checked
				componentQueue.add(s.getViewport().getView());
			} else if(component instanceof JSplitPane s) {
				componentQueue.add(s.getLeftComponent());
				componentQueue.add(s.getRightComponent());
			} else if(component instanceof Container c) {
				componentQueue.addAll(Arrays.asList(c.getComponents()));
			}
		}
		
		return result;
	}
}
