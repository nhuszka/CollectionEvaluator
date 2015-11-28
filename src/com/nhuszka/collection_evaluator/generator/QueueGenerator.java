package com.nhuszka.collection_evaluator.generator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class QueueGenerator implements CollectionGenerator {

	@Override
	public Collection<DummyObject> generate(Integer numberOfElements) {
		final Queue<DummyObject> queue = new LinkedList<DummyObject>();

		for (int i = 0; i < numberOfElements; ++i) {
			queue.add(new DummyObject());
		}

		return queue;
	}
}
