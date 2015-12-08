package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class NewTreeMapElementAdditionStrategy extends MapEvaluationStrategy {

	public NewTreeMapElementAdditionStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationDescription() {
		return "New map element addition in nanosec " + getEvaluationInfo();
	}

	@Override
	protected List<Long> computeElapsedNanoSecundums() {
		List<Long> elapsedNanoSecundums = new ArrayList<>();
		
		Map<DummyObject, DummyObject> mapClone = cloneMap();
		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			DummyObject newKey = new DummyObject();
			DummyObject newValue = new DummyObject();

			Long startTime = System.nanoTime();
			mapClone.put(newKey, newValue);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSecundums.add(elapsedNanoSec);
		}

		return elapsedNanoSecundums;
	}

	protected Map<DummyObject, DummyObject> cloneMap() {
		return new TreeMap<>(map);
	}
}
