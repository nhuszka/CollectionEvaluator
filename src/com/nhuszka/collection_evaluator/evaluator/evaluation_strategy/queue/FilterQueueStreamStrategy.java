package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class FilterQueueStreamStrategy extends FilterQueueStrategy {

	public FilterQueueStreamStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue, queueToTest);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.FILTER_QUEUE_STREAM_STRATEGY_TITLE;
	}

	@Override
	protected List<DummyObject> filterQueue() {
		return queueToTest
				.stream()
				.filter(item -> isFiltered(item))
				.collect(Collectors.toList());
	}
}
