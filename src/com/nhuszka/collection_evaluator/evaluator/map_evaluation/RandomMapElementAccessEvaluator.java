package com.nhuszka.collection_evaluator.evaluator.map_evaluation;

import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.display.MapEvaluationResult;
import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomMapElementAccessEvaluator extends MapEvaluationStrategy {

	@Override
	public MapEvaluationResult evaluate(MapEvaluationResult result) {
		Long estimatedTime = computeEstimatedTime(result.getMap());
		System.out.println(estimatedTime);
		return result;
	}

	private Long computeEstimatedTime(Map<DummyObject, DummyObject> map) {
		List<DummyObject> randomKeys = computeRandomKeys(map);

		for (int i = 0; i < 10; ++i) {
			Long startTime = System.nanoTime();
			for (DummyObject key : randomKeys) {
				map.get(key);
			}
			Long estimatedTime = System.nanoTime() - startTime;
			System.out.println(estimatedTime);
		}

		return 0l;
	}
}
