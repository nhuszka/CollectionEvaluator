package com.nhuszka.collection_evaluator.display;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class MapEvaluationResult implements CollectionEvaluationResult {
	public Map<DummyObject, DummyObject> map;
	public Map<String, Long> evaluationResults;

	public MapEvaluationResult(Map<DummyObject, DummyObject> map) {
		this.map = Collections.unmodifiableMap(map);
		this.evaluationResults = new HashMap<>();
	}

	public Map<DummyObject, DummyObject> getMap() {
		return map;
	}

	public void addEvaluationResult(String evaluationDescription, Long elapsedNanoSec) {
		evaluationResults.put(evaluationDescription, elapsedNanoSec);
	}

	@Override
	public void processResults() {
		for (String evaluation : evaluationResults.keySet()) {
			System.out.println(evaluation + ": " + evaluationResults.get(evaluation));
		}
	}
}