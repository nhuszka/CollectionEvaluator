package com.nhuszka.collection_evaluator.evaluator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.PutMapStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.RandomAccessMapStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SearchMapAfterSortStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SearchMapStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map.SortMapStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.MapGenerator;

class MapEvaluator extends CollectionEvaluator {

	private final Map<DummyObject, DummyObject> map;

	MapEvaluator(Integer numberOfElements) {
		this.map = new MapGenerator().generate(numberOfElements);

		evaluateHashMap(numberOfElements);
		evaluateLinkedHashMap(numberOfElements);
		evaluateTreeMap(numberOfElements);
	}

	private void evaluateHashMap(Integer numberOfElements) {
		evaluationStrategies.add(new SearchMapStrategy(map, createEmptyHashMap()));
		evaluationStrategies.add(new SearchMapAfterSortStrategy(map, createEmptyHashMap()));
		evaluationStrategies.add(new RandomAccessMapStrategy(map, createEmptyHashMap()));
		evaluationStrategies.add(new PutMapStrategy(map, createEmptyHashMap()));
		evaluationStrategies.add(new SortMapStrategy(map, createEmptyHashMap()));
	}
	
	private void evaluateLinkedHashMap(Integer numberOfElements) {
		evaluationStrategies.add(new SearchMapStrategy(map, createEmptyLinkedHashMap()));
		evaluationStrategies.add(new RandomAccessMapStrategy(map, createEmptyLinkedHashMap()));
		evaluationStrategies.add(new PutMapStrategy(map, createEmptyLinkedHashMap()));
	}

	private void evaluateTreeMap(Integer numberOfElements) {
		evaluationStrategies.add(new SearchMapStrategy(map, createEmptyTreeMap()));
		evaluationStrategies.add(new RandomAccessMapStrategy(map, createEmptyTreeMap()));
		evaluationStrategies.add(new PutMapStrategy(map, createEmptyTreeMap()));
	}
	

	private static Map<DummyObject, DummyObject> createEmptyHashMap() {
		return new HashMap<>();
	}
	
	private static Map<DummyObject, DummyObject> createEmptyLinkedHashMap() {
		return new LinkedHashMap<>();
	}

	private static Map<DummyObject, DummyObject> createEmptyTreeMap() {
		return new TreeMap<>();
	}
}
