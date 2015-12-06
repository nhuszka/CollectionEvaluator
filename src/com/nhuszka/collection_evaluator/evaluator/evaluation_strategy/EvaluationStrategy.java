package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

public interface EvaluationStrategy {

	final static Integer NUM_OF_ITERATION = 1000;

	CollectionEvaluationResult evaluate(CollectionEvaluationResult result);
}
