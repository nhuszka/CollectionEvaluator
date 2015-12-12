package com.nhuszka.collection_evaluator.evaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.PutMapStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.RandomAccessMapStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SearchMapAfterSortStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SearchMapStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SortMapStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.map.HashMapGenerator;
import com.nhuszka.collection_evaluator.generator.map.TreeMapGenerator;

class MapEvaluator extends CollectionEvaluator {

	MapEvaluator(Integer numberOfElements) {
		evaluateHashMap(numberOfElements);
		evaluateTreeMap(numberOfElements);
	}

	private void evaluateHashMap(Integer numberOfElements) {
		Map<DummyObject, DummyObject> hashMap = new HashMapGenerator().generate(numberOfElements);

		evaluationStrategies.add(new SearchMapStrategy(hashMap));
		evaluationStrategies.add(new SearchMapAfterSortStrategy(hashMap));
		evaluationStrategies.add(new RandomAccessMapStrategy(hashMap));
		evaluationStrategies.add(new PutMapStrategy(hashMap, createEmptyHashMap()));
		evaluationStrategies.add(new SortMapStrategy(hashMap));
	}

	private void evaluateTreeMap(Integer numberOfElements) {
		Map<DummyObject, DummyObject> treeMap = new TreeMapGenerator().generate(numberOfElements);

		evaluationStrategies.add(new SearchMapStrategy(treeMap));
		evaluationStrategies.add(new RandomAccessMapStrategy(treeMap));
		evaluationStrategies.add(new PutMapStrategy(treeMap, createEmptyTreeMap()));
	}

	private static Map<DummyObject, DummyObject> createEmptyHashMap() {
		return new HashMap<>();
	}

	private static Map<DummyObject, DummyObject> createEmptyTreeMap() {
		return new TreeMap<>();
	}
}
