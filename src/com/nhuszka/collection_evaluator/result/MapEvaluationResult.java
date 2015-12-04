package com.nhuszka.collection_evaluator.result;

import java.util.Collections;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class MapEvaluationResult extends CollectionEvaluationResult {
	
	public Map<DummyObject, DummyObject> map;

	public MapEvaluationResult(Map<DummyObject, DummyObject> map) {
		this.map = Collections.unmodifiableMap(map);
	}

	public Map<DummyObject, DummyObject> getMap() {
		return map;
	}

	@Override
	public void processResults() {
		for (String evaluation : evaluationResults.keySet()) {
			System.out.println(evaluation + ": " + evaluationResults.get(evaluation));
		}
	}
}