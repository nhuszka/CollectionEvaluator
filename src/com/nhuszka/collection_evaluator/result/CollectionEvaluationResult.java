package com.nhuszka.collection_evaluator.result;

import java.util.HashMap;
import java.util.Map;

public abstract class CollectionEvaluationResult {
	
	public Map<String, Long> evaluationResults;
	
	protected CollectionEvaluationResult() {
		evaluationResults = new HashMap<>();
	}
	
	public final void addEvaluationResult(String evaluationDescription, Long elapsedNanoSec) {
		evaluationResults.put(evaluationDescription, elapsedNanoSec);
	}

	public abstract void processResults();
}
