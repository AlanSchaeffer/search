package com.github.alanschaeffer.search.swing.domain.target;

import java.awt.Component;

import com.github.alanschaeffer.search.domain.targets.SearchTarget;

public interface ComponentTarget<T extends Component> extends SearchTarget {

	T getComponent();
}
