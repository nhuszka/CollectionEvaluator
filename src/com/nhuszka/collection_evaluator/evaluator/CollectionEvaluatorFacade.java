package com.nhuszka.collection_evaluator.evaluator;

import java.util.Map;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.CollectionGenerator;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.MapGenerator;
import com.nhuszka.collection_evaluator.generator.QueueGenerator;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.setting.EvaluatorSettings;

public class CollectionEvaluatorFacade {

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

		runPerformanceEvaluation(new CollectionEvaluationResult(), new MapEvaluator(map));
	}

	private void runPerformanceEvaluationOnQueue(Integer numberOfElements) {
		CollectionGenerator queueGenerator = new QueueGenerator();
		Queue<DummyObject> queue = (Queue<DummyObject>) queueGenerator.generate(numberOfElements);

		runPerformanceEvaluation(new CollectionEvaluationResult(), new QueueEvaluator(queue));
	}

	private void runPerformanceEvaluation(CollectionEvaluationResult evaluationResult, CollectionEvaluator evaluator) {
		evaluator.evaluate(evaluationResult);
		evaluationResult.processResults();
	}
}
