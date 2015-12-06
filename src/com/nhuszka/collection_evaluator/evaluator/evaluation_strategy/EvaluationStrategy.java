package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

public abstract class EvaluationStrategy {

	protected final static Integer NUM_OF_ITERATION = 10000;

	protected abstract String getEvaluationDescription();

	protected abstract Long computeElapsedNanoSec();

	public final void evaluate(CollectionEvaluationResult evaluationResult) {
		evaluationResult.addEvaluationResult(getEvaluationDescription(), computeElapsedNanoSec());
	}
}
