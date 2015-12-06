package com.nhuszka.collection_evaluator.generator.queue;

import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public abstract class QueueGenerator {

	protected void fillWithRandomElements(Queue<DummyObject> queue, Integer numberOfElements) {
		for (int i = 0; i < numberOfElements; ++i) {
			queue.add(new DummyObject());
		}
	}
}
