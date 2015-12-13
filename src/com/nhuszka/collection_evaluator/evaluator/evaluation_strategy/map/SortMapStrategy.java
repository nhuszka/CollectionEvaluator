package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SortMapStrategy extends MapEvaluationStrategy {

	private final Map<DummyObject, DummyObject> mapToTest;

	public SortMapStrategy(Map<DummyObject, DummyObject> map,
			Map<DummyObject, DummyObject> mapToTest) {
		super(map);
		this.mapToTest = mapToTest;
		mapToTest.putAll(map);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SORT_MAP_STRATEGY_TITLE;
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return mapToTest.getClass();
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		Long startTime = System.nanoTime();
		mapToTest.putAll(map);
		Long elapsedNanoSec = System.nanoTime() - startTime;

		elapsedNanoSeconds.add(elapsedNanoSec);
		return elapsedNanoSeconds;
	}
}
