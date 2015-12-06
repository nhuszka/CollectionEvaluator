package com.nhuszka.collection_evaluator.generator.map;

import java.util.HashMap;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class HashMapGenerator extends MapGenerator {

	public Map<DummyObject, DummyObject> generate(Integer numberOfElements) {
		final Map<DummyObject, DummyObject> map = new HashMap<DummyObject, DummyObject>();
		fillWithRandomElements(map, numberOfElements);
		return map;
	}
}
