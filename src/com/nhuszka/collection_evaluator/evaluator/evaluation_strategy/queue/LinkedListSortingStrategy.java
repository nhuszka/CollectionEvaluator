package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class LinkedListSortingStrategy extends QueueEvaluationStrategy {

	public LinkedListSortingStrategy(Queue<DummyObject> queue) {
		super(queue);
	}

	@Override
	protected String getEvaluationDescription() {
		return "Queue sorting in nanosec " + getEvaluationInfo();
	}

	@Override
	protected List<Long> computeElapsedNanoSecundums() {
		List<Long> elapsedNanoSecundums = new ArrayList<>();
		
		LinkedList<DummyObject> linkedList = new LinkedList<>(queue);

		Long startTime = System.nanoTime();
		Collections.sort(linkedList);
		Long elapsedNanoSec = System.nanoTime() - startTime;

		elapsedNanoSecundums.add(elapsedNanoSec);
		
		return elapsedNanoSecundums;
	}
}
