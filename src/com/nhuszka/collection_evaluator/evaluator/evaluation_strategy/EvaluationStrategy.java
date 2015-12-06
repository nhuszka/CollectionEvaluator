package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluation;

public abstract class EvaluationStrategy {

	protected final static Integer NUM_OF_ITERATION = 10000;

	public abstract CollectionEvaluation evaluate(CollectionEvaluation result);

	protected abstract String getEvaluationDescription();

	protected List<DummyObject> getRandomKeys(List<DummyObject> keys) {
		List<DummyObject> randomKeys = new ArrayList<>();

		Integer maxIndex = keys.size();
		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			Integer random = new Random().nextInt(maxIndex);
			randomKeys.add(keys.get(random));
		}

		return randomKeys;
	}
}
