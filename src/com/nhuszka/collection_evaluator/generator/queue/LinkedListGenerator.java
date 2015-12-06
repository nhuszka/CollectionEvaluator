package com.nhuszka.collection_evaluator.generator.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class LinkedListGenerator extends QueueGenerator {

	public Queue<DummyObject> generate(Integer numberOfElements) {
		final LinkedList<DummyObject> queue = new LinkedList<DummyObject>();
		fillWithRandomElements(queue, numberOfElements);
		return queue;
	}
}
