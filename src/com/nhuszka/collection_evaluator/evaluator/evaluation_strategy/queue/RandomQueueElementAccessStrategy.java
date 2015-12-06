package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomQueueElementAccessStrategy extends QueueEvaluationStrategy {

	public RandomQueueElementAccessStrategy(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Random queue element access in nanosec (average on " + NUM_OF_ITERATION + " iteration)";
	}

	@Override
	protected Long computeElapsedNanoSec() {
		Long totalElapsedNanoSec = 0l;

		// TODO: do not depend on concrete implementation or use generics
		LinkedList<DummyObject> linkedList = ((LinkedList<DummyObject>) queue);
		List<DummyObject> elementsInQueue = new ArrayList<>(queue);

		List<DummyObject> randomElements = computeRandomElements();
		for (DummyObject element : randomElements) {
			Integer index = elementsInQueue.indexOf(element);

			Long startTime = System.nanoTime();
			linkedList.get(index);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			totalElapsedNanoSec += elapsedNanoSec;
		}

		return totalElapsedNanoSec / randomElements.size();
	}
}
