package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class RandomAccessMapStrategy extends MapEvaluationStrategy {

	private final Map<DummyObject, DummyObject> mapToTest;

	public RandomAccessMapStrategy(Map<DummyObject, DummyObject> map,
			Map<DummyObject, DummyObject> mapToTest) {
		super(map);
		this.mapToTest = mapToTest;
		mapToTest.putAll(map);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.RANDOM_ACCESS_MAP_STRATEGY_TITLE;
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return mapToTest.getClass();
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		List<DummyObject> randomKeys = computeRandomKeys();
		for (DummyObject key : randomKeys) {
			Long startTime = System.nanoTime();
			mapToTest.get(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
