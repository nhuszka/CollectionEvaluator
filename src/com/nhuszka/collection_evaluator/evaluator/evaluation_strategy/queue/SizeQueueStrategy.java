package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SizeQueueStrategy extends QueueEvaluationStrategy {

	protected final Queue<DummyObject> queueToTest;

	public SizeQueueStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue);
		this.queueToTest = queueToTest;
		this.queueToTest.addAll(queue);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SIZE_QUEUE_STRATEGY_TITLE;
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return queueToTest.getClass();
	}

	@Override
	protected final List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		Long startTime = System.nanoTime();

		getQueueSize();

		Long elapsedNanoSec = System.nanoTime() - startTime;
		elapsedNanoSeconds.add(elapsedNanoSec);

		return elapsedNanoSeconds;
	}

	protected void getQueueSize() {
		queueToTest.size();
	}
}
