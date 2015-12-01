package com.nhuszka.collection_evaluator.display;

import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class MapEvaluationResult implements CollectionEvaluationResult {
	public Map<DummyObject, DummyObject> map;
	
	public MapEvaluationResult(Map<DummyObject, DummyObject> map) {
		this.map = map;
	}
	
	@Override
	public void processResults() {
		System.out.println(map);
	}
}