package com.nhuszka.collection_evaluator.evaluator;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.NewMapElementAdditionEvaluator;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.RandomMapElementAccessEvaluator;

class MapEvaluator extends CollectionEvaluator {

	MapEvaluator() {
		evaluationStrategies.add(new RandomMapElementAccessEvaluator());
		evaluationStrategies.add(new NewMapElementAdditionEvaluator());
	}
}
