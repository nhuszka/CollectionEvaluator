package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SearchMapStrategy extends MapEvaluationStrategy {

	public SearchMapStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SEARCH_MAP_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		return computeElapsedNanoSecToSearch(map);
	}

	protected List<Long> computeElapsedNanoSecToSearch(Map<DummyObject, DummyObject> mapToSearch) {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		List<DummyObject> randomKeys = computeRandomKeys();
		for (DummyObject key : randomKeys) {
			Long startTime = System.nanoTime();
			mapToSearch.containsKey(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
