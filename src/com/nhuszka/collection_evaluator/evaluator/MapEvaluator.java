package com.nhuszka.collection_evaluator.evaluator;

import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.NewMapElementAdditionStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.RandomMapElementAccessStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;

class MapEvaluator extends CollectionEvaluator {

	MapEvaluator(Map<DummyObject, DummyObject> map) {
		evaluationStrategies.add(new RandomMapElementAccessStrategy(map));
		evaluationStrategies.add(new NewMapElementAdditionStrategy(map));
	}
}
