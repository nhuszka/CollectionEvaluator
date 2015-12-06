package com.nhuszka.collection_evaluator.evaluator;

import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.NewQueueElementAdditionStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomLinkedListElementAccessStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.queue.LinkedListGenerator;

class QueueEvaluator extends CollectionEvaluator {

	QueueEvaluator(Integer numberOfElements) {
		Queue<DummyObject> queue = new LinkedListGenerator().generate(numberOfElements);

		evaluationStrategies.add(new RandomLinkedListElementAccessStrategy(queue));
		evaluationStrategies.add(new NewQueueElementAdditionStrategy(queue));
	}
}
