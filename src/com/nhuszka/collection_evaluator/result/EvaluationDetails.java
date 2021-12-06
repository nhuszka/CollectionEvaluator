package com.nhuszka.collection_evaluator.result;

import java.util.List;

import com.nhuszka.collection_evaluator.message.Texts;

class EvaluationDetails {

	private final String evaluationDescription;
	private final List<Long> measurements;
	private Long minimum;
	private Long maximum;
	private Double average;
	private Double averageWithoutZeros;
	private Double rateOfZeros;

	public EvaluationDetails(String evaluationDescription, List<Long> measurements) {
		this.evaluationDescription = evaluationDescription;
		this.measurements = measurements;
		calculateMetrics();
	}

	private void calculateMetrics() {
		Long sum = 0L;
		Integer numOfNonZeroMeasurements = 0;
		for (Long measurement : measurements) {
			sum += measurement;
			if (measurement > 0) {
				numOfNonZeroMeasurements++;
			}
			minimum = reCalculateMinimum(measurement);
			maximum = reCalculateMaximum(measurement);
		}

		average = (double) (sum / measurements.size());
		calculateAdditionalMetrics(sum, numOfNonZeroMeasurements);
	}

	private void calculateAdditionalMetrics(Long sum, Integer numOfNonZeroMeasurements) {
		Double numOfMeasurements = (double) measurements.size();
		if (numOfMeasurements > 1) {
			Double numOfZeroMeasurements = numOfMeasurements - numOfNonZeroMeasurements;
			rateOfZeros = (numOfZeroMeasurements / numOfMeasurements) * 100;
			averageWithoutZeros = numOfNonZeroMeasurements == 0
					? average
					: sum / numOfNonZeroMeasurements;
		}
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
		StringBuilder evaluation = new StringBuilder()
				.append(evaluationDescription)
				.append(":")
				.append(Texts.NEW_LINE)
				.append(Texts.AVERAGE)
				.append(average.intValue())
				.append(Texts.NEW_LINE);

		if (rateOfZeros != null && rateOfZeros.compareTo((double) 0) != 0) {
			evaluation.append(Texts.AVERAGE_WITHOUT_ZEROS)
					.append(averageWithoutZeros.intValue())
					.append(Texts.NEW_LINE)
					.append(Texts.RATE_OF_ZEROS)
					.append(rateOfZeros.intValue()).append("%")
					// .append(Texts.NEW_LINE)
					// .append(Texts.MINIMUM + minimum)
					.append(Texts.NEW_LINE)
					.append(Texts.MAXIMUM)
					.append(maximum)
					.append(Texts.NEW_LINE);
		}

		return evaluation.toString();
	}
}