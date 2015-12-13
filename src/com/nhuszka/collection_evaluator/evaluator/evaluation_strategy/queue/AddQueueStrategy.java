package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class AddQueueStrategy extends QueueEvaluationStrategy {

	private final Queue<DummyObject> queueToEvaluate;

	public AddQueueStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToEvaluate) {
		super(queue);
		this.queueToEvaluate = queueToEvaluate;
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.ADD_QUEUE_STRATEGY_TITLE;
	}

	@Override
	protected Queue<DummyObject> getEvaluatedCollection() {
		return queueToEvaluate;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			DummyObject newElement = new DummyObject();

			Long startTime = System.nanoTime();
			queueToEvaluate.add(newElement);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
