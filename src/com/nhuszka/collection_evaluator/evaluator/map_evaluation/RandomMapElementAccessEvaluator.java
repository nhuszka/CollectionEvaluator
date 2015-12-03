package com.nhuszka.collection_evaluator.evaluator.map_evaluation;

import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomMapElementAccessEvaluator extends MapEvaluationStrategy {

	@Override
	protected String getDescription() {
		return "Random map element access";
	}

	@Override
	protected Long computeElapsedNanoSec(Map<DummyObject, DummyObject> map, List<DummyObject> randomKeys) {
		Long startTime = System.nanoTime();

		for (DummyObject key : randomKeys) {
			map.get(key);
		}

		Long elapsedNanoSec = System.nanoTime() - startTime;
		return elapsedNanoSec;
	}
}
