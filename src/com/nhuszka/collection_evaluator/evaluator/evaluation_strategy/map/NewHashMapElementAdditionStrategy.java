package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.HashMap;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class NewHashMapElementAdditionStrategy extends NewTreeMapElementAdditionStrategy {

	public NewHashMapElementAdditionStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected Map<DummyObject, DummyObject> cloneMap() {
		return new HashMap<>(map);
	}
}
