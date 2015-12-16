package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class FilterQueueStreamStrategy extends QueueEvaluationStrategy {

	protected final Queue<DummyObject> queueToTest;

	public FilterQueueStreamStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue);
		this.queueToTest = queueToTest;
		queueToTest.addAll(queue);
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return queueToTest.getClass();
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.FILTER_QUEUE_STREAM_STRATEGY_TITLE;
	}

	@Override
	protected final List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		Long startTime = System.nanoTime();

		filterStream();

		Long elapsedNanoSec = System.nanoTime() - startTime;
		elapsedNanoSeconds.add(elapsedNanoSec);

		return elapsedNanoSeconds;
	}

	protected void filterStream() {
		queueToTest
				.stream()
				.filter(item -> item.toString().contains("a"))
				.collect(Collectors.toList());
	}
}
