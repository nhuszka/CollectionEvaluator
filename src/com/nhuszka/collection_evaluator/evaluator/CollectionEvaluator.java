package com.nhuszka.collection_evaluator.evaluator;

import java.util.Map;
import java.util.Queue;

import com.nhuszka.collection_evaluator.display.CollectionEvaluationResult;
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
				runPerformanceEvaluationOnMap(numberOfElements);
				break;
			case QUEUE :
				runPerformanceEvaluationOnQueue(numberOfElements);
				break;
			default :
				break;
		}
	}

	private void runPerformanceEvaluationOnMap(Integer numberOfElements) {
		MapGenerator mapGenerator = new MapGenerator();
		Map<DummyObject, DummyObject> map = mapGenerator.generate(numberOfElements);

		CollectionEvaluationResult evaluationResult = new MapEvaluator().evaluate(map); 
		evaluationResult.processResults();
	}

	private void runPerformanceEvaluationOnQueue(Integer numberOfElements) {
		CollectionGenerator queueGenerator = new QueueGenerator();
		Queue<DummyObject> queue = (Queue<DummyObject>) queueGenerator.generate(numberOfElements);

		CollectionEvaluationResult evaluationResult = new QueueEvaluator().evaluate(queue);
		evaluationResult.processResults();
	}
}
