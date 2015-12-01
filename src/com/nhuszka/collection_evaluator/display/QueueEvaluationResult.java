package com.nhuszka.collection_evaluator.display;

import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;

public class QueueEvaluationResult implements CollectionEvaluationResult {
	public Queue<DummyObject> queue;
	
	public QueueEvaluationResult(Queue<DummyObject> queue) {
		this.queue = queue;
	}
	
	@Override
	public void processResults() {
		System.out.println(queue);
	}
}
