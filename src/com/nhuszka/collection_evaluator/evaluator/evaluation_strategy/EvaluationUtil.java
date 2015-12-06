package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class EvaluationUtil {

	public static List<DummyObject> getRandomKeys(List<DummyObject> keys, Integer numOfIteration) {
		List<DummyObject> randomKeys = new ArrayList<>();

		Integer maxIndex = keys.size();
		for (int i = 0; i < numOfIteration; ++i) {
			Integer random = new Random().nextInt(maxIndex);
			randomKeys.add(keys.get(random));
		}

		return randomKeys;
	}
}
