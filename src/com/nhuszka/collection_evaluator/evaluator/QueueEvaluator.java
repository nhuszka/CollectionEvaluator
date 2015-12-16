package com.nhuszka.collection_evaluator.evaluator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.AddQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.FilterQueueParallelStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.FilterQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.FilterQueueStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListAfterSortStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RandomAccessLinkedListStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.RemoveQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SearchQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SizeQueueParallelStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SizeQueueStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SizeQueueStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.SortLinkedListStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.UseQueueElementsParallelStreamStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.UseQueueElementsStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue.UseQueueElementsStreamStrategy;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.QueueGenerator;

class QueueEvaluator extends CollectionEvaluator {

	private final Queue<DummyObject> queue;

	QueueEvaluator(Integer numberOfElements) {
		this.queue = new QueueGenerator().generate(numberOfElements);

		evaluationStrategies.add(new AddQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new AddQueueStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new RemoveQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new RemoveQueueStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new SearchQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new SearchQueueStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new RandomAccessLinkedListStrategy(queue));
		evaluationStrategies.add(new RandomAccessLinkedListAfterSortStrategy(queue));
		evaluationStrategies.add(new SortLinkedListStrategy(queue));

		evaluationStrategies.add(new SizeQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new SizeQueueStrategy(queue, createEmptyPriorityQueue()));
		evaluationStrategies.add(new SizeQueueStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new SizeQueueStreamStrategy(queue, createEmptyPriorityQueue()));
		evaluationStrategies.add(new SizeQueueParallelStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new SizeQueueParallelStreamStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new UseQueueElementsStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new UseQueueElementsStrategy(queue, createEmptyPriorityQueue()));
		evaluationStrategies.add(new UseQueueElementsStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new UseQueueElementsStreamStrategy(queue, createEmptyPriorityQueue()));
		evaluationStrategies.add(new UseQueueElementsParallelStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new UseQueueElementsParallelStreamStrategy(queue, createEmptyPriorityQueue()));

		evaluationStrategies.add(new FilterQueueStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new FilterQueueStrategy(queue, createEmptyPriorityQueue()));
		evaluationStrategies.add(new FilterQueueStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new FilterQueueStreamStrategy(queue, createEmptyPriorityQueue()));
		evaluationStrategies.add(new FilterQueueParallelStreamStrategy(queue, createEmptyLinkedList()));
		evaluationStrategies.add(new FilterQueueParallelStreamStrategy(queue, createEmptyPriorityQueue()));
	}

	private static LinkedList<DummyObject> createEmptyLinkedList() {
		return new LinkedList<>();
	}

	private static PriorityQueue<DummyObject> createEmptyPriorityQueue() {
		return new PriorityQueue<>();
	}
}
