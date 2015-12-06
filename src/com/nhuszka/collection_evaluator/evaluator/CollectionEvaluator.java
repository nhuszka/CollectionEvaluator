package com.nhuszka.collection_evaluator.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

abstract class CollectionEvaluator {
	protected final List<EvaluationStrategy> evaluationStrategies;

	CollectionEvaluator() {
		evaluationStrategies = new ArrayList<>();
	}

	void evaluate(CollectionEvaluationResult evaluationResult) {
		for (EvaluationStrategy evaluationStrategy : evaluationStrategies) {
			evaluationStrategy.evaluate(evaluationResult);
		}
	}
}
