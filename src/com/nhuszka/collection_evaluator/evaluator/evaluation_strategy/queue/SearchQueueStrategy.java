package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SearchQueueStrategy extends QueueEvaluationStrategy {

	private final Queue<DummyObject> queueToTest;

	public SearchQueueStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue);
		this.queueToTest = queueToTest;
		queueToTest.addAll(queue);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SEARCH_QUEUE_STRATEGY_TITLE;
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return queueToTest.getClass();
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		List<DummyObject> randomElements = computeRandomElements();
		for (DummyObject key : randomElements) {
			Long startTime = System.nanoTime();
			queueToTest.contains(key);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
