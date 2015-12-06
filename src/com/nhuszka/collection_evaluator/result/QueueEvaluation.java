package com.nhuszka.collection_evaluator.result;

import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class QueueEvaluation extends CollectionEvaluation {

	public Queue<DummyObject> queue;

	public QueueEvaluation(Queue<DummyObject> queue) {
		this.queue = queue;
	}

	public Queue<DummyObject> getQueue() {
		return queue;
	}
}
