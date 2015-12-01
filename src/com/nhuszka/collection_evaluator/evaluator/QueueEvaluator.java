package com.nhuszka.collection_evaluator.evaluator;

import java.util.Queue;
import com.nhuszka.collection_evaluator.display.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.display.QueueEvaluationResult;
import com.nhuszka.collection_evaluator.generator.DummyObject;

class QueueEvaluator {
	
	CollectionEvaluationResult evaluate(Queue<DummyObject> queue) {
		// TODO evaluate
		return new QueueEvaluationResult(queue);
	}
}
