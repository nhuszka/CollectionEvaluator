package com.nhuszka.collection_evaluator.generator;

import java.util.Collection;

public interface CollectionGenerator {

	public Collection<DummyObject> generate(Integer numberOfElements);
}
