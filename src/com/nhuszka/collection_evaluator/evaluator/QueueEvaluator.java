package com.nhuszka.collection_evaluator.evaluator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.AddQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.FilterQueueParallelStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.FilterQueueStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListAfterSortStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SearchQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SortLinkedListStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.QueueGenerator;

class QueueEvaluator extends CollectionEvaluator {

	private final Queue<DummyObject> queue;

	QueueEvaluator(Integer numberOfElements) {
		this.queue = new QueueGenerator().generate(numberOfElements);

		evaluationStrategies.add(new AddQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new AddQueueStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new SearchQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new SearchQueueStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new FilterQueueStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new FilterQueueStreamStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new FilterQueueParallelStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new FilterQueueParallelStreamStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new RandomAccessLinkedListStrategy(queue));
		evaluationStrategies.add(new RandomAccessLinkedListAfterSortStrategy(queue));
		evaluationStrategies.add(new SortLinkedListStrategy(queue));
	}

	private static LinkedList<DummyObject> createEmptyLinkedList() {
		return new LinkedList<>();
	}

	private static PriorityQueue<DummyObject> createEmptyPriorityQueue() {
		return new PriorityQueue<>();
	}
}
