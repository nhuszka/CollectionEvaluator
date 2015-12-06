package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class SearchMapElementStrategy extends MapEvaluationStrategy {

	public SearchMapElementStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Search map element in nanosec (average on "
				+ NUM_OF_ITERATION + " iteration, "
				+ "collection: " + map.getClass() + ")";
	}

	@Override
	protected Long computeElapsedNanoSec() {
		return computeElapsedNanoSecToSearch(map);
	}

	protected Long computeElapsedNanoSecToSearch(Map<DummyObject, DummyObject> mapToSearch) {
		Long totalElapsedNanoSec = 0l;

		List<DummyObject> randomKeys = computeRandomKeys();
		for (DummyObject key : randomKeys) {
			Long startTime = System.nanoTime();
			mapToSearch.containsKey(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;
			totalElapsedNanoSec += elapsedNanoSec;
		}

		return totalElapsedNanoSec / randomKeys.size();
	}
}
