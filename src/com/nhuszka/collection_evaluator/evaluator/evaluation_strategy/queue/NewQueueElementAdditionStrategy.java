package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class NewQueueElementAdditionStrategy extends QueueEvaluationStrategy {

	public NewQueueElementAdditionStrategy(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "New queue element addition in nanosec " + getEvaluationInfo();
	}

	@Override
	protected Long computeElapsedNanoSec() {
		Long totalElapsedNanoSec = 0l;

		Queue<DummyObject> queueClone = new LinkedList<>();
		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			DummyObject newElement = new DummyObject();

			Long startTime = System.nanoTime();
			queueClone.add(newElement);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			totalElapsedNanoSec += elapsedNanoSec;
		}

		return totalElapsedNanoSec / NUM_OF_ITERATION;
	}
}
