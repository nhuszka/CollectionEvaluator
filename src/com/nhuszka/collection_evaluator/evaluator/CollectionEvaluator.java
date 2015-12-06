package com.nhuszka.collection_evaluator.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.result.CollectionEvaluation;

abstract class CollectionEvaluator {
	protected final List<EvaluationStrategy> evaluationStrategies;

	CollectionEvaluator() {
		evaluationStrategies = new ArrayList<>();
	}

	CollectionEvaluation evaluate(CollectionEvaluation evaluationResult) {
		for (EvaluationStrategy evaluationStrategy : evaluationStrategies) {
			evaluationStrategy.evaluate(evaluationResult);
		}
		return evaluationResult;
	}
}
