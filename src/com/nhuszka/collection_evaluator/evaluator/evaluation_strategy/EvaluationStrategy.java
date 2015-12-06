package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

public abstract class EvaluationStrategy {

	protected final static Integer NUM_OF_ITERATION = 10000;

	public abstract void evaluate(CollectionEvaluationResult evaluationResult);

	protected abstract String getEvaluationDescription();
}
