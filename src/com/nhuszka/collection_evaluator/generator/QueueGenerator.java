package com.nhuszka.collection_evaluator.generator;

import java.util.LinkedList;
import java.util.Queue;

public class QueueGenerator {

	public Queue<DummyObject> generate(Integer numberOfElements) {
		final LinkedList<DummyObject> queue = new LinkedList<DummyObject>();
		fillWithRandomElements(queue, numberOfElements);
		return queue;
	}

	protected void fillWithRandomElements(Queue<DummyObject> queue, Integer numberOfElements) {
		for (int i = 0; i < numberOfElements; ++i) {
			queue.add(new DummyObject());
		}
	}
}
