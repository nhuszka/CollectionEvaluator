package com.nhuszka.collection_evaluator.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

public abstract class CollectionEvaluator {
	protected final List<EvaluationStrategy> evaluationStrategies;

	public CollectionEvaluator() {
		evaluationStrategies = new ArrayList<>();
	}

	public CollectionEvaluationResult evaluate(CollectionEvaluationResult evaluationResult) {
		for (EvaluationStrategy evaluationStrategy : evaluationStrategies) {
			evaluationStrategy.evaluate(evaluationResult);
		}
		return evaluationResult;
	}
}
