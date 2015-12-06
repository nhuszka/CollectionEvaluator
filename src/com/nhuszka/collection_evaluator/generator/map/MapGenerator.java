package com.nhuszka.collection_evaluator.generator.map;

import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public abstract class MapGenerator {

	protected void fillWithRandomElements(Map<DummyObject, DummyObject> map, Integer numberOfElements) {
		for (int i = 0; i < numberOfElements; ++i) {
			map.put(new DummyObject(), new DummyObject());
		}
	}
}
