package com.nhuszka.collection_evaluator.result;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.collection_evaluator.message.Texts;
import com.nhuszka.collection_evaluator.result.exception.IncorrectEvaluationResultException;

public class CollectionEvaluationResult {

	private final List<EvaluationDetails> evaluationResults = new ArrayList<>();

	public final void addEvaluationResults(String evaluationDescription, List<Long> elapsedNanoSeconds)
			throws IncorrectEvaluationResultException {
		checkCorrectEvaluationResult(evaluationDescription, elapsedNanoSeconds);

		evaluationResults.add(new EvaluationDetails(evaluationDescription, elapsedNanoSeconds));
	}

	private void checkCorrectEvaluationResult(String evaluationDescription, List<Long> elapsedNanoSeconds)
			throws IncorrectEvaluationResultException {
		if (evaluationDescription == null || evaluationDescription.isEmpty()) {
			throw new IncorrectEvaluationResultException(Texts.MISSING_EVALUATION_DESCRIPTION);
		}
		if (elapsedNanoSeconds == null || elapsedNanoSeconds.isEmpty()) {
			throw new IncorrectEvaluationResultException(
					evaluationDescription, Texts.MISSING_EVALUATION_MEASUREMENTS);
		}
	}

	public void processResults() {
		for (EvaluationDetails evaluation : evaluationResults) {
			System.out.println(evaluation);
		}
	}
}
