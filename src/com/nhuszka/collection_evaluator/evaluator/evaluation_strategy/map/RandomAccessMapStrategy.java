package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class RandomAccessMapStrategy extends MapEvaluationStrategy {

	public RandomAccessMapStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.RANDOM_ACCESS_MAP_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		List<DummyObject> randomKeys = computeRandomKeys();
		for (DummyObject key : randomKeys) {
			Long startTime = System.nanoTime();
			map.get(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
