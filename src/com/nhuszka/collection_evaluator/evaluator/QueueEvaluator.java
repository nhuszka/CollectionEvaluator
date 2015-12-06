package com.nhuszka.collection_evaluator.evaluator;

import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.NewQueueElementAdditionStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomQueueElementAccessStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;

class QueueEvaluator extends CollectionEvaluator {

	QueueEvaluator(Queue<DummyObject> queue) {
		evaluationStrategies.add(new RandomQueueElementAccessStrategy(queue));
		evaluationStrategies.add(new NewQueueElementAdditionStrategy(queue));
	}
}
