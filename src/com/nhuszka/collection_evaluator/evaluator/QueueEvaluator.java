package com.nhuszka.collection_evaluator.evaluator;

import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.result.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.result.QueueEvaluationResult;

class QueueEvaluator {
	
	CollectionEvaluationResult evaluate(Queue<DummyObject> queue) {
		// TODO evaluate
		return new QueueEvaluationResult(queue);
	}
}
