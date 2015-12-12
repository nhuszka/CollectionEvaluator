package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SearchMapAfterSortStrategy extends SearchMapStrategy {

	public SearchMapAfterSortStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SEARCH_MAP_AFTER_SORT_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		Map<DummyObject, DummyObject> sortedMap = new TreeMap<DummyObject, DummyObject>();
		sortedMap.putAll(map);
		return super.computeElapsedNanoSecToSearch(sortedMap);
	}
}
