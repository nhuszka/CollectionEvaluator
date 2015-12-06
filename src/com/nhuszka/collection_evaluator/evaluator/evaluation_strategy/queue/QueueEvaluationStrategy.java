package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationUtil;
import com.nhuszka.collection_evaluator.generator.DummyObject;

public abstract class QueueEvaluationStrategy extends EvaluationStrategy {

	protected final Queue<DummyObject> queue;

	public QueueEvaluationStrategy(Queue<DummyObject> queue) {
		this.queue = queue;
	}

	protected final List<DummyObject> computeRandomElements() {
		List<DummyObject> keys = new ArrayList<>(queue);
		return EvaluationUtil.getRandomKeys(keys, NUM_OF_ITERATION);
	}
}
