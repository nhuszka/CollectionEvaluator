package com.nhuszka.collection_evaluator.result;

import java.util.ArrayList;
import java.util.List;

public class CollectionEvaluationResult {
	
	private final List<Data> evaluationResults = new ArrayList<>();

	public final void addEvaluationResults(String evaluationDescription, List<Long> elapsedNanoSec) {
		evaluationResults.add(new Data(evaluationDescription, elapsedNanoSec));
	}

	public void processResults() {
		for (Data evaluation : evaluationResults) {
			System.out.println(evaluation);
		}
	}
	
	private class Data {
		private final String evaluationDescription;
		private final List<Long> measurements;
		
		public Data(String evaluationDescription, List<Long> measurements) {
			this.evaluationDescription = evaluationDescription;
			this.measurements = measurements;
		}
		
		@Override
		public String toString() {
			return evaluationDescription + ": " + measurements;
		}
	}
}
