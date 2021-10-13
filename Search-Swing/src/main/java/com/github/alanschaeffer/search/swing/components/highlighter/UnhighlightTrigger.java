package com.github.alanschaeffer.search.swing.components.highlighter;

public interface UnhighlightTrigger {

	void activate(Runnable unhighlight);
	
	public static final UnhighlightTrigger NEVER_UNHILIGHT = r -> {};
}
