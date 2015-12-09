package com.nhuszka.collection_evaluator.result;

import java.util.ArrayList;
import java.util.List;

public class CollectionEvaluationResult {
	
	private final List<EvaluationDetails> evaluationResults = new ArrayList<>();

	public final void addEvaluationResults(String evaluationDescription, List<Long> elapsedNanoSeconds) {
		checkCorrectEvaluationResult(evaluationDescription, elapsedNanoSeconds);
		
		evaluationResults.add(new EvaluationDetails(evaluationDescription, elapsedNanoSeconds));
	}

	private void checkCorrectEvaluationResult(String evaluationDescription, List<Long> elapsedNanoSeconds) {
		if (evaluationDescription == null || evaluationDescription.isEmpty()) {
			// TODO exception to indicate something is wrong with evaluation
		}
		if (elapsedNanoSeconds == null || elapsedNanoSeconds.isEmpty()) {
			// TODO exception to indicate something is wrong with evaluation
		}
	}

	public void processResults() {
		for (EvaluationDetails evaluation : evaluationResults) {
			System.out.println(evaluation);
		}
	}
	
	private class EvaluationDetails {
		
		private final String evaluationDescription;
		private final List<Long> measurements;
		private Long minimum;
		private Long maximum;
		private Long average;
		
		public EvaluationDetails(String evaluationDescription, List<Long> measurements) {
			this.evaluationDescription = evaluationDescription;
			this.measurements = measurements;
			calculateMetrics();
		}
		
		private void calculateMetrics() {
			Long sum = 0L;
			for (Long measurement : measurements) {
				sum += measurement;
				minimum = reCalculateMinimum(measurement);
				maximum = reCalculateMaximum(measurement);
			}
			average = sum / measurements.size();
		}
		
		private Long reCalculateMinimum(Long measurement) {
			if (minimum == null) {
				return measurement;
			}
			return measurement < minimum 
					? measurement 
					: minimum;
		}
		
		private Long reCalculateMaximum(Long measurement) {
			if (maximum == null) {
				return measurement;
			}
			return measurement > maximum
					? measurement 
					: maximum;
		}
		
		@Override
		public String toString() {
			StringBuilder evaluation = new StringBuilder();
			evaluation.append(evaluationDescription)
				.append(":")
				.append(" minimum: " + minimum)
				.append(" maximum: " + maximum)
				.append(" average: " + average);
			
			return evaluation.toString();
		}
	}
}
