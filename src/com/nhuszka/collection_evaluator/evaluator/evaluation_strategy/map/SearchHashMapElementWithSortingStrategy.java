package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class SearchHashMapElementWithSortingStrategy extends SearchMapElementStrategy {

	public SearchHashMapElementWithSortingStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Search map element with sorting in nanosec (average on "
				+ NUM_OF_ITERATION + " iteration, "
				+ "collection: " + map.getClass() + ")";
	}

	@Override
	protected Long computeElapsedNanoSec() {
		Map<DummyObject, DummyObject> sortedMap = new TreeMap<DummyObject, DummyObject>();
		sortedMap.putAll(map);
		return super.computeElapsedNanoSecToSearch(sortedMap);
	}
}
