package com.nhuszka.collection_evaluator.generator.map;

import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class TreeMapGenerator extends MapGenerator {

	public Map<DummyObject, DummyObject> generate(Integer numberOfElements) {
		final Map<DummyObject, DummyObject> map = new TreeMap<DummyObject, DummyObject>();
		fillWithRandomElements(map, numberOfElements);
		return map;
	}
}
