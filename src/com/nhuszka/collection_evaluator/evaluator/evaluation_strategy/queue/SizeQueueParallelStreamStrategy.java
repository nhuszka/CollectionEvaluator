package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SizeQueueParallelStreamStrategy extends SizeQueueStrategy {

	public SizeQueueParallelStreamStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue, queueToTest);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SIZE_PARALLEL_STREAM_QUEUE_STRATEGY_TITLE;
	}

	@Override
	protected void getQueueSize() {
		queueToTest
				.parallelStream()
				.count();
	}
}