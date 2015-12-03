package com.nhuszka.collection_evaluator.evaluator.map_evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.nhuszka.collection_evaluator.display.MapEvaluationResult;
import com.nhuszka.collection_evaluator.generator.DummyObject;

public abstract class MapEvaluationStrategy {

	final static Integer NUM_OF_ITERATION = 10000000;

	public abstract MapEvaluationResult evaluate(MapEvaluationResult result);

	protected List<DummyObject> computeRandomKeys(Map<DummyObject, DummyObject> map) {
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
