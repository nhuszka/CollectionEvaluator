package com.nhuszka.collection_evaluator.evaluator;

import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.NewQueueElementAdditionEvaluator;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomQueueElementAccessEvaluator;
import com.nhuszka.collection_evaluator.generator.DummyObject;

class QueueEvaluator extends CollectionEvaluator {

	QueueEvaluator(Queue<DummyObject> queue) {
		evaluationStrategies.add(new RandomQueueElementAccessEvaluator(queue));
		evaluationStrategies.add(new NewQueueElementAdditionEvaluator(queue));
	}
}
