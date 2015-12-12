package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationUtil;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public abstract class QueueEvaluationStrategy extends EvaluationStrategy {

	protected final Queue<DummyObject> queue;

	public QueueEvaluationStrategy(Queue<DummyObject> queue) {
		this.queue = queue;
	}

	protected final List<DummyObject> computeRandomElements() {
		List<DummyObject> keys = new ArrayList<>(queue);
		return EvaluationUtil.getRandomKeys(keys, NUM_OF_ITERATION);
	}

	@Override
	protected String getEvaluationDescription() {
		return getEvaluationTitle() + String.format(Texts.EVALUATION_DETAILS, NUM_OF_ITERATION, queue.getClass());
	}

	protected abstract String getEvaluationTitle();
}
