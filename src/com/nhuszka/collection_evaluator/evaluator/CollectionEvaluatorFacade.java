package com.nhuszka.collection_evaluator.evaluator;

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
		runPerformanceEvaluation(new CollectionEvaluationResult(), new MapEvaluator(numberOfElements));
	}

	private void runPerformanceEvaluationOnQueue(Integer numberOfElements) {
		runPerformanceEvaluation(new CollectionEvaluationResult(), new QueueEvaluator(numberOfElements));
	}

	private void runPerformanceEvaluation(CollectionEvaluationResult evaluationResult,
			CollectionEvaluator evaluator) {
		evaluator.evaluate(evaluationResult);
		evaluationResult.processResults();
	}
}
