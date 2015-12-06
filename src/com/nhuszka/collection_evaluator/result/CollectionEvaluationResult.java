package com.nhuszka.collection_evaluator.result;

import java.util.ArrayList;
import java.util.List;

public class CollectionEvaluationResult {

	public List<String> evaluationResults;

	public CollectionEvaluationResult() {
		evaluationResults = new ArrayList<String>();
	}

	public final void addEvaluationResult(String evaluationDescription, Long elapsedNanoSec) {
		evaluationResults.add(evaluationDescription + ": " + elapsedNanoSec);
	}

	public void processResults() {
		for (String evaluation : evaluationResults) {
			System.out.println(evaluation);
		}
	}
}
