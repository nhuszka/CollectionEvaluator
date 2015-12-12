package com.nhuszka.collection_evaluator.evaluator;

import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SortLinkedListStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.AddQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListAfterSortStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.queue.LinkedListGenerator;

class QueueEvaluator extends CollectionEvaluator {

	QueueEvaluator(Integer numberOfElements) {
		Queue<DummyObject> queue = new LinkedListGenerator().generate(numberOfElements);

		evaluationStrategies.add(new SortLinkedListStrategy(queue));
		evaluationStrategies.add(new RandomAccessLinkedListStrategy(queue));
		evaluationStrategies.add(new RandomAccessLinkedListAfterSortStrategy(queue));
		evaluationStrategies.add(new AddQueueStrategy(queue));
	}
}
