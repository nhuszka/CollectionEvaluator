package com.nhuszka.collection_evaluator.result;

import java.util.HashMap;
import java.util.Map;

public class CollectionEvaluationResult {

	public Map<String, Long> evaluationResults;

	public CollectionEvaluationResult() {
		evaluationResults = new HashMap<>();
	}

	public final void addEvaluationResult(String evaluationDescription, Long elapsedNanoSec) {
		evaluationResults.put(evaluationDescription, elapsedNanoSec);
	}

	public void processResults() {
		for (String evaluation : evaluationResults.keySet()) {
			System.out.println(evaluation + ": " + evaluationResults.get(evaluation));
		}
	}
}
