package com.github.alanschaeffer.search.swing.components.descriptor;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JComponent;

public class ComponentDescriptor {
	
	private final List<ComponentDescriptorParser> parsers;
	private Predicate<Container> stopCondition = Objects::isNull;
	
	public ComponentDescriptor() {
		parsers = List.of(new LabelParser()
						 ,new TabParser()
						 ,new ContainerWithTitledBorderParser());
	}

	public ComponentDescriptor(List<ComponentDescriptorParser> parsers) {
		this.parsers = new ArrayList<>(Objects.requireNonNull(parsers, "Parsers cannot be null!"));
	}
	
	public void stopWhen(Predicate<Container> condition) {
		this.stopCondition = Objects.requireNonNull(condition, "Condition cannot be null!");
	}

	public String describe(JComponent component) {
		Deque<String> nodes = new LinkedList<>();
		Container previousComponent = null;
		Container currentComponent = component;
		
		while (!stopCondition.test(currentComponent)) {
			getComponentDescription(currentComponent, previousComponent).ifPresent(nodes::push);
			
			previousComponent = currentComponent;
			currentComponent = currentComponent.getParent();
		}
		
		return nodes.stream().collect(Collectors.joining(" -> "));
	}
	
	private Optional<String> getComponentDescription(Container currentComponent, Container previousComponent) {
		return parsers.stream()
					  .map(p -> p.parse(currentComponent, previousComponent))
					  .filter(Optional::isPresent)
					  .findFirst()
					  .orElseGet(Optional::empty);
	}
}
