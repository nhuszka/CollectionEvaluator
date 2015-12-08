package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomMapElementAccessStrategy extends MapEvaluationStrategy {

	public RandomMapElementAccessStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Random map element access in nanosec (average on "
				+ NUM_OF_ITERATION + " iteration, "
				+ "collection: " + map.getClass() + ")";
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();
		
		List<DummyObject> randomKeys = computeRandomKeys();
		for (DummyObject key : randomKeys) {
			Long startTime = System.nanoTime();
			map.get(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
