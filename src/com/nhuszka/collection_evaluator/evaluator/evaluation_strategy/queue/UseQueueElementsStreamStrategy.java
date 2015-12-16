package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class UseQueueElementsStreamStrategy extends UseQueueElementsStrategy {

	public UseQueueElementsStreamStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue, queueToTest);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.USE_QUEUE_ELEMENT_STREAM_STRATEGY_TITLE;
	}

	protected int computeHashCodesSum() {
		return queueToTest
				.stream()
				.mapToInt(e -> e.hashCode())
				.sum();
	}
}
