package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomQueueElementAccessEvaluator extends QueueEvaluationStrategy {

	public RandomQueueElementAccessEvaluator(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Random queue element access in nanosec (average on " + NUM_OF_ITERATION + " iteration)";
	}

	@Override
	protected Long computeElapsedNanoSec(List<DummyObject> randomElements) {
		Long totalElapsedNanoSec = 0l;

		// TODO: do not depend on concrete implementation
		// or use generics
		LinkedList<DummyObject> linkedList = ((LinkedList<DummyObject>) queue);
		List<DummyObject> elementsInQueue = new ArrayList<>(queue);

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
