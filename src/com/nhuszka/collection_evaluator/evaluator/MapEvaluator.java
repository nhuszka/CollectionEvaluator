package com.nhuszka.collection_evaluator.evaluator;

import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.NewMapElementAdditionEvaluator;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.RandomMapElementAccessEvaluator;
import com.nhuszka.collection_evaluator.generator.DummyObject;

class MapEvaluator extends CollectionEvaluator {

	MapEvaluator(Map<DummyObject, DummyObject> map) {
		evaluationStrategies.add(new RandomMapElementAccessEvaluator(map));
		evaluationStrategies.add(new NewMapElementAdditionEvaluator(map));
	}
}
