package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class PutMapStrategy extends MapEvaluationStrategy {

	private final Map<DummyObject, DummyObject> mapToTest;

	public PutMapStrategy(Map<DummyObject, DummyObject> originalMap,
			Map<DummyObject, DummyObject> mapToTest) {
		super(originalMap);
		this.mapToTest = mapToTest;
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.PUT_MAP_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		mapToTest.putAll(map);
		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			DummyObject newKey = new DummyObject();
			DummyObject newValue = new DummyObject();

			Long startTime = System.nanoTime();
			mapToTest.put(newKey, newValue);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
