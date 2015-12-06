package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class RandomLinkedListElementAccessAfterSortStrategy extends RandomLinkedListElementAccessStrategy {

	public RandomLinkedListElementAccessAfterSortStrategy(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Random queue element access after sort in nanosec " + getEvaluationInfo();
	}

	@Override
	protected Long computeElapsedNanoSec() {
		LinkedList<DummyObject> linkedList = new LinkedList<>(queue);
		Collections.sort(linkedList);

		return computeElapsedNanoSecForRandomElementAccess(linkedList);
	}
}
