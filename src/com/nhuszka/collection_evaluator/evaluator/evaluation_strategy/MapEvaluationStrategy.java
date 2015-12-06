package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.result.MapEvaluationResult;

public abstract class MapEvaluationStrategy implements EvaluationStrategy {

	protected abstract String getDescription();

	protected abstract Long computeElapsedNanoSec(Map<DummyObject, DummyObject> map, List<DummyObject> randomKeys);

	public final CollectionEvaluationResult evaluate(CollectionEvaluationResult result) {
		Map<DummyObject, DummyObject> map = ((MapEvaluationResult) result).getMap();
		List<DummyObject> randomKeys = computeRandomKeys(map);

		Long elapsedNanoSec = computeElapsedNanoSec(map, randomKeys);
		result.addEvaluationResult(getDescription(), elapsedNanoSec);
		return result;
	}

	private final List<DummyObject> computeRandomKeys(Map<DummyObject, DummyObject> map) {
		List<DummyObject> keys = new ArrayList<>(map.keySet());
		Integer numOfKeys = keys.size();

		List<DummyObject> randomKeys = new ArrayList<>();
		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			Integer random = new Random().nextInt(numOfKeys);
			randomKeys.add(keys.get(random));
		}

		return randomKeys;
	}

}
