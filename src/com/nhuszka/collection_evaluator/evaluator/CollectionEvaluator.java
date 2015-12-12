package com.nhuszka.collection_evaluator.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.message.Texts;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.result.exception.IncorrectEvaluationResultException;

abstract class CollectionEvaluator {

	protected final List<EvaluationStrategy> evaluationStrategies;

	CollectionEvaluator() {
		evaluationStrategies = new ArrayList<>();
	}

	void evaluate(CollectionEvaluationResult evaluationResult) {
		for (EvaluationStrategy evaluationStrategy : evaluationStrategies) {
			evaluateStrategy(evaluationResult, evaluationStrategy);
		}
	}

	private void evaluateStrategy(CollectionEvaluationResult evaluationResult, EvaluationStrategy evaluationStrategy) {
		try {
			evaluationStrategy.evaluate(evaluationResult);
		} catch (IncorrectEvaluationResultException exception) {
			System.out.println(getEvaluationErrorMessage(exception));
		}
	}

	private String getEvaluationErrorMessage(IncorrectEvaluationResultException exception) {
		return new StringBuilder()
				.append(Texts.SKIP_EVALUATION_ERROR)
				.append(Texts.NEW_LINE)
				.append(exception.getEvaluationDescription())
				.append(Texts.NEW_LINE)
				.append(exception.getErrorCause())
				.append(Texts.NEW_LINE)
				.toString();
	}
}
