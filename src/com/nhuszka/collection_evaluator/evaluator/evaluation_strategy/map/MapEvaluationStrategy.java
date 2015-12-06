package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationUtil;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

public abstract class MapEvaluationStrategy extends EvaluationStrategy {

	protected final Map<DummyObject, DummyObject> map;

	public MapEvaluationStrategy(Map<DummyObject, DummyObject> map) {
		this.map = map;
	}

	protected abstract Long computeElapsedNanoSec(List<DummyObject> randomKeys);

	public final void evaluate(CollectionEvaluationResult evaluationResult) {
		List<DummyObject> randomKeys = computeRandomKeys();

		Long elapsedNanoSec = computeElapsedNanoSec(randomKeys);
		evaluationResult.addEvaluationResult(getEvaluationDescription(), elapsedNanoSec);
	}

	private final List<DummyObject> computeRandomKeys() {
		List<DummyObject> keys = new ArrayList<>(map.keySet());
		return EvaluationUtil.getRandomKeys(keys, NUM_OF_ITERATION);
	}
}
