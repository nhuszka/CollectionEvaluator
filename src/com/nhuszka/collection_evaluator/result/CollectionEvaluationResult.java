package com.nhuszka.collection_evaluator.result;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.collection_evaluator.result.exception.IncorrectEvaluationResultException;

public class CollectionEvaluationResult {

	private static final String MISSING_EVALUATION_DESCRIPTION = "Missing evaluation description";
	private static final String MISSING_EVALUATION_MEASUREMENTS = "Missing evaluation measurements";

	private final List<EvaluationDetails> evaluationResults = new ArrayList<>();

	public final void addEvaluationResults(String evaluationDescription, List<Long> elapsedNanoSeconds)
			throws IncorrectEvaluationResultException {
		checkCorrectEvaluationResult(evaluationDescription, elapsedNanoSeconds);

		evaluationResults.add(new EvaluationDetails(evaluationDescription, elapsedNanoSeconds));
	}

	private void checkCorrectEvaluationResult(String evaluationDescription, List<Long> elapsedNanoSeconds)
			throws IncorrectEvaluationResultException {
		if (evaluationDescription == null || evaluationDescription.isEmpty()) {
			throw new IncorrectEvaluationResultException(MISSING_EVALUATION_DESCRIPTION);
		}
		if (elapsedNanoSeconds == null || elapsedNanoSeconds.isEmpty()) {
			throw new IncorrectEvaluationResultException(evaluationDescription, MISSING_EVALUATION_MEASUREMENTS);
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
