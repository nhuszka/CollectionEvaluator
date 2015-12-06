package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationUtil;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;

public abstract class QueueEvaluationStrategy extends EvaluationStrategy {

	protected final Queue<DummyObject> queue;

	public QueueEvaluationStrategy(Queue<DummyObject> queue) {
		this.queue = queue;
	}

	protected abstract Long computeElapsedNanoSec(List<DummyObject> randomKeys);

	public final void evaluate(CollectionEvaluationResult evaluationResult) {
		List<DummyObject> randomKeys = computeRandomKeys();

		Long elapsedNanoSec = computeElapsedNanoSec(randomKeys);
		evaluationResult.addEvaluationResult(getEvaluationDescription(), elapsedNanoSec);
	}

	private final List<DummyObject> computeRandomKeys() {
		List<DummyObject> keys = new ArrayList<>(queue);
		return EvaluationUtil.getRandomKeys(keys, NUM_OF_ITERATION);
	}
}
