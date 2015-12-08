package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class HashMapSortingStrategy extends MapEvaluationStrategy {

	public HashMapSortingStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Map sorting in nanosec " + getEvaluationInfo();
	}

	@Override
	protected List<Long> computeElapsedNanoSecundums() {
		List<Long> elapsedNanoSecundums = new ArrayList<>();
		
		Long startTime = System.nanoTime();
		
		Map<DummyObject, DummyObject> mapClone = new TreeMap<DummyObject, DummyObject>();
		mapClone.putAll(map);
		
		Long elapsedNanoSec = System.nanoTime() - startTime;
		
		elapsedNanoSecundums.add(elapsedNanoSec);
		return elapsedNanoSecundums;
	}
}
