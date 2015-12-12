package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SortMapStrategy extends MapEvaluationStrategy {

	public SortMapStrategy(Map<DummyObject, DummyObject> map) {
		super(map);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SORT_MAP_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		Long startTime = System.nanoTime();

		Map<DummyObject, DummyObject> mapClone = new TreeMap<DummyObject, DummyObject>();
		mapClone.putAll(map);

		Long elapsedNanoSec = System.nanoTime() - startTime;

		elapsedNanoSeconds.add(elapsedNanoSec);
		return elapsedNanoSeconds;
	}
}
