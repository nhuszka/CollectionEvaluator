package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class NewQueueElementAdditionEvaluator extends QueueEvaluationStrategy {

	public NewQueueElementAdditionEvaluator(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "New queue element addition in nanosec (average on " + NUM_OF_ITERATION + " iteration)";
	}

	@Override
	protected Long computeElapsedNanoSec(List<DummyObject> randomKeys) {
		Long totalElapsedNanoSec = 0l;

		// TODO: do not depend on concrete implementation
		// or use generics
		Queue<DummyObject> queueClone = new LinkedList<>();
		int numOfIteration = randomKeys.size();

		for (int i = 0; i < numOfIteration; ++i) {
			DummyObject newElement = new DummyObject();

			Long startTime = System.nanoTime();
			queueClone.add(newElement);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			totalElapsedNanoSec += elapsedNanoSec;
		}

		return totalElapsedNanoSec / numOfIteration;
	}
}
