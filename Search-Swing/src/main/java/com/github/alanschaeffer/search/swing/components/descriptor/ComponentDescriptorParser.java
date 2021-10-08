package com.github.alanschaeffer.search.swing.components.descriptor;

import java.awt.Container;
import java.util.Optional;

public interface ComponentDescriptorParser {

	Optional<String> parse(Container component, Container innerComponent);
}
