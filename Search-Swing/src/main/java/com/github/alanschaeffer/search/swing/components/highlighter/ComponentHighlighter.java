package com.github.alanschaeffer.search.swing.components.highlighter;

import javax.swing.JComponent;

public class ComponentHighlighter {

	private final Effect effect;
	private UnhighlightTrigger unhighlightTrigger = UnhighlightTrigger.NEVER_UNHILIGHT;
	
	private JComponent currentlyHighlightedComponent;

	public ComponentHighlighter(Effect effect) {
		this.effect = effect;
	}
	
	public void setUnhighlightTrigger(UnhighlightTrigger unhighlightTrigger) {
		if(unhighlightTrigger == null) this.unhighlightTrigger = UnhighlightTrigger.NEVER_UNHILIGHT;
		else this.unhighlightTrigger = unhighlightTrigger;
	}

	public synchronized void highlight(JComponent component) {
		if(currentlyHighlightedComponent != null) {
			effect.deactivate(currentlyHighlightedComponent);
		}
		currentlyHighlightedComponent = component;
		
		if(component != null) {
			effect.activate(component);
			unhighlightTrigger.activate(() -> unhighlight(component));
		}
	}
	
	public synchronized void unhighlight(JComponent component) {
		if(currentlyHighlightedComponent != null) {
			highlight(null);
		}
	}
}
