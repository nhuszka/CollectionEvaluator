package com.nhuszka.collection_evaluator.generator;

import java.util.LinkedList;
import java.util.Queue;

public class QueueGenerator {

	public Queue<DummyObject> generate(Integer numberOfElements) {
		// TODO do not depend on concrete implementation, use generics
		final Queue<DummyObject> queue = new LinkedList<DummyObject>();

		for (int i = 0; i < numberOfElements; ++i) {
			queue.add(new DummyObject());
		}

		return queue;
	}
}
