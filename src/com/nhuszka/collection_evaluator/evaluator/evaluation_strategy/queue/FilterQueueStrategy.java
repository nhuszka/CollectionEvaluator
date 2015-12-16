package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class FilterQueueStrategy extends QueueEvaluationStrategy {

	protected final Queue<DummyObject> queueToTest;

	public FilterQueueStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue);
		this.queueToTest = queueToTest;
		this.queueToTest.addAll(queue);
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return queueToTest.getClass();
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.FILTER_QUEUE_STRATEGY_TITLE;
	}

	@Override
	protected final List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			Long startTime = System.nanoTime();
			filterQueue();
			Long elapsedNanoSec = System.nanoTime() - startTime;
			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}

	protected List<DummyObject> filterQueue() {
		List<DummyObject> filteredElements = new ArrayList<>();
		for (DummyObject element : queueToTest) {
			if (isFiltered(element)) {
				filteredElements.add(element);
			}
		}
		return filteredElements;
	}

	protected final boolean isFiltered(DummyObject item) {
		return item.toString().contains("a");
	}
}