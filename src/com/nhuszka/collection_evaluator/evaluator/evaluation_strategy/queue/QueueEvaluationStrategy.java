package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluation;
import com.nhuszka.collection_evaluator.result.QueueEvaluation;

public abstract class QueueEvaluationStrategy extends EvaluationStrategy {

	protected abstract Long computeElapsedNanoSec(Queue<DummyObject> queue, List<DummyObject> randomKeys);

	public final CollectionEvaluation evaluate(CollectionEvaluation result) {
		// TODO avoid casting
		Queue<DummyObject> queue = ((QueueEvaluation) result).getQueue();
		List<DummyObject> randomKeys = computeRandomKeys(queue);

		Long elapsedNanoSec = computeElapsedNanoSec(queue, randomKeys);
		result.addEvaluationResult(getEvaluationDescription(), elapsedNanoSec);
		return result;
	}

	private final List<DummyObject> computeRandomKeys(Queue<DummyObject> queue) {
		List<DummyObject> keys = new ArrayList<>(queue);
		return getRandomKeys(keys);
	}
}
