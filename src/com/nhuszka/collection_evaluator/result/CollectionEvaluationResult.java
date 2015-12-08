package com.nhuszka.collection_evaluator.result;

import java.util.ArrayList;
import java.util.List;

public class CollectionEvaluationResult {
	
	private final List<EvaluationDetails> evaluationResults = new ArrayList<>();

	public final void addEvaluationResults(String evaluationDescription, List<Long> elapsedNanoSeconds) {
		evaluationResults.add(new EvaluationDetails(evaluationDescription, elapsedNanoSeconds));
	}

	public void processResults() {
		for (EvaluationDetails evaluation : evaluationResults) {
			System.out.println(evaluation);
		}
	}
	
	private class EvaluationDetails {
		
		private final String evaluationDescription;
		private final List<Long> measurements;
		
		public EvaluationDetails(String evaluationDescription, List<Long> measurements) {
			this.evaluationDescription = evaluationDescription;
			this.measurements = measurements;
		}
		
		@Override
		public String toString() {
			return evaluationDescription + ": " + measurements;
		}
	}
}
