package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	protected List<Long> computeElapsedNanoSecundums() {
		List<Long> elapsedNanoSecundums = new ArrayList<>();
		
		Queue<DummyObject> queueClone = new LinkedList<>();
		for (int i = 0; i < NUM_OF_ITERATION; ++i) {
			DummyObject newElement = new DummyObject();

			Long startTime = System.nanoTime();
			queueClone.add(newElement);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSecundums.add(elapsedNanoSec);
		}

		return elapsedNanoSecundums;
	}
}
