package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluation;
import com.nhuszka.collection_evaluator.result.MapEvaluation;

public abstract class MapEvaluationStrategy extends EvaluationStrategy {

	protected abstract Long computeElapsedNanoSec(Map<DummyObject, DummyObject> map, List<DummyObject> randomKeys);

	public final CollectionEvaluation evaluate(CollectionEvaluation result) {
		// TODO avoid casting
		Map<DummyObject, DummyObject> map = ((MapEvaluation) result).getMap();
		List<DummyObject> randomKeys = computeRandomKeys(map);

		Long elapsedNanoSec = computeElapsedNanoSec(map, randomKeys);
		result.addEvaluationResult(getEvaluationDescription(), elapsedNanoSec);
		return result;
	}

	private final List<DummyObject> computeRandomKeys(Map<DummyObject, DummyObject> map) {
		List<DummyObject> keys = new ArrayList<>(map.keySet());
		return getRandomKeys(keys);
	}
}
