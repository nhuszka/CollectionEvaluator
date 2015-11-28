package com.nhuszka.collection_evaluator.generator;

import java.util.HashMap;
import java.util.Map;

public class MapGenerator {

	public Map<DummyObject, DummyObject> generate(Integer numberOfElements) {
		final Map<DummyObject, DummyObject> map = new HashMap<DummyObject, DummyObject>();

		for (int i = 0; i < numberOfElements; ++i) {
			map.put(new DummyObject(), new DummyObject());
		}

		return map;
	}
}
