package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class NewMapElementAdditionEvaluator extends MapEvaluationStrategy {

	public NewMapElementAdditionEvaluator(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationDescription() {
		return "New map element addition in nanosec (average on " + NUM_OF_ITERATION + " iteration)";
	}

	@Override
	protected Long computeElapsedNanoSec(List<DummyObject> randomKeys) {
		Long totalElapsedNanoSec = 0l;

		// TODO: do not depend on concrete implementation
		// or use generics
		Map<DummyObject, DummyObject> mapClone = new HashMap<>(map);
		int numOfIteration = randomKeys.size();

		for (int i = 0; i < numOfIteration; ++i) {
			DummyObject newKey = new DummyObject();
			DummyObject newValue = new DummyObject();

			Long startTime = System.nanoTime();
			mapClone.put(newKey, newValue);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			totalElapsedNanoSec += elapsedNanoSec;
		}

		return totalElapsedNanoSec / numOfIteration;
	}
}
