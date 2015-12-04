package com.nhuszka.collection_evaluator.evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.map_evaluation.MapEvaluationStrategy;
import com.nhuszka.collection_evaluator.evaluator.map_evaluation.RandomMapElementAccessEvaluator;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.result.MapEvaluationResult;

class MapEvaluator {
	private static final List<MapEvaluationStrategy> evaluationStrategies;
	static {
		evaluationStrategies = new ArrayList<>();
		evaluationStrategies.add(new RandomMapElementAccessEvaluator());
	}

	CollectionEvaluationResult evaluate(Map<DummyObject, DummyObject> mapToEvaluate) {
		MapEvaluationResult result = new MapEvaluationResult(mapToEvaluate);

		for (MapEvaluationStrategy evaluationStrategy : evaluationStrategies) {
			evaluationStrategy.evaluate(result);
		}

		return result;
	}
}
