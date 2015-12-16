package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import java.util.List;

import com.nhuszka.collection_evaluator.message.Texts;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.result.exception.IncorrectEvaluationResultException;

public abstract class EvaluationStrategy {

	protected final static Integer NUM_OF_ITERATION = 10000;

	protected abstract List<Long> computeElapsedNanoSeconds();

	public final void evaluate(CollectionEvaluationResult evaluationResult)
			throws IncorrectEvaluationResultException {
		evaluationResult.addEvaluationResults(getEvaluationDescription(), computeElapsedNanoSeconds());
	}

	protected String getEvaluationDescription() {
		return getEvaluationTitle()
				+ String.format(Texts.EVALUATION_DETAILS, getEvaluatedCollectionClass());
	}

	protected abstract Class<? extends Object> getEvaluatedCollectionClass();

	protected abstract String getEvaluationTitle();
}
