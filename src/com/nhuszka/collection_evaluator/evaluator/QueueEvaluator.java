package com.nhuszka.collection_evaluator.evaluator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.AddQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListAfterSortStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SortLinkedListStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.QueueGenerator;

class QueueEvaluator extends CollectionEvaluator {

	private final Queue<DummyObject> queue;

	QueueEvaluator(Integer numberOfElements) {
		this.queue = new QueueGenerator().generate(numberOfElements);

		evaluateLinkedList(numberOfElements);
		evaluatePriorityQueue(numberOfElements);
	}

	private void evaluateLinkedList(Integer numberOfElements) {
		evaluationStrategies.add(new SortLinkedListStrategy(queue));
		evaluationStrategies.add(new RandomAccessLinkedListStrategy(queue));
		evaluationStrategies.add(new RandomAccessLinkedListAfterSortStrategy(queue));
		evaluationStrategies.add(new AddQueueStrategy(queue, createEmptyLinkedList()));
	}

	private void evaluatePriorityQueue(Integer numberOfElements) {
		evaluationStrategies.add(new AddQueueStrategy(queue, createEmptyPriorityQueue()));
	}

	private static LinkedList<DummyObject> createEmptyLinkedList() {
		return new LinkedList<>();
	}

	private static PriorityQueue<DummyObject> createEmptyPriorityQueue() {
		return new PriorityQueue<>();
	}
}
