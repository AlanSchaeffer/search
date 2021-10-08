package com.github.alanschaeffer.search.swing.domain.targets;

import java.awt.Component;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public interface ComponentTarget<T extends Component> extends SearchTarget {

	T getComponent();
}
