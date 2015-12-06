package com.nhuszka.collection_evaluator.result;

import java.util.Collections;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class MapEvaluation extends CollectionEvaluation {

	public Map<DummyObject, DummyObject> map;

	public MapEvaluation(Map<DummyObject, DummyObject> map) {
		this.map = Collections.unmodifiableMap(map);
	}

	public Map<DummyObject, DummyObject> getMap() {
		return map;
	}
}