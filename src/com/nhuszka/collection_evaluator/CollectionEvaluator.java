package com.nhuszka.collection_evaluator;

import java.util.Map;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.CollectionGenerator;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.MapGenerator;
import com.nhuszka.collection_evaluator.generator.QueueGenerator;
import com.nhuszka.collection_evaluator.setting.EvaluatorSettings;

public class CollectionEvaluator {

	public void start() {
		EvaluatorSettings settings = EvaluatorSettings.getSettings();
		Integer numberOfElements = settings.getNumberOfElementsPerInterface();

		switch (settings.getEvaluatedInterface()) {
			case MAP :
				evaluateMap(numberOfElements);
				break;
			case QUEUE :
				evaluateQueue(numberOfElements);
				break;
			default :
				break;
		}
	}

	private void evaluateMap(Integer numberOfElements) {
		MapGenerator mapGenerator = new MapGenerator();
		Map<DummyObject, DummyObject> map = mapGenerator.generate(numberOfElements);

		System.out.println(map);
	}

	private void evaluateQueue(Integer numberOfElements) {
		CollectionGenerator queueGenerator = new QueueGenerator();
		Queue<DummyObject> queue = (Queue<DummyObject>) queueGenerator.generate(numberOfElements);

		System.out.println(queue);
	}
}
