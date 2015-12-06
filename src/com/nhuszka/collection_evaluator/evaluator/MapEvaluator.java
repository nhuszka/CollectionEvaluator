package com.nhuszka.collection_evaluator.evaluator;

import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.HashMapSortingStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.NewHashMapElementAdditionStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.NewTreeMapElementAdditionStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.RandomMapElementAccessStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SearchHashMapElementWithSortingStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SearchMapElementStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.map.HashMapGenerator;
import com.nhuszka.collection_evaluator.generator.map.TreeMapGenerator;

class MapEvaluator extends CollectionEvaluator {

	MapEvaluator(Integer numberOfElements) {
		Map<DummyObject, DummyObject> hashMap = new HashMapGenerator().generate(numberOfElements);
		evaluationStrategies.add(new SearchMapElementStrategy(hashMap));
		evaluationStrategies.add(new SearchHashMapElementWithSortingStrategy(hashMap));
		evaluationStrategies.add(new RandomMapElementAccessStrategy(hashMap));
		evaluationStrategies.add(new NewHashMapElementAdditionStrategy(hashMap));
		evaluationStrategies.add(new HashMapSortingStrategy(hashMap));

		Map<DummyObject, DummyObject> treeMap = new TreeMapGenerator().generate(numberOfElements);
		evaluationStrategies.add(new SearchMapElementStrategy(treeMap));
		evaluationStrategies.add(new RandomMapElementAccessStrategy(treeMap));
		evaluationStrategies.add(new NewTreeMapElementAdditionStrategy(treeMap));
	}
}
