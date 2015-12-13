package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class RandomAccessLinkedListAfterSortStrategy extends RandomAccessLinkedListStrategy {

	private final LinkedList<DummyObject> linkedList;

	public RandomAccessLinkedListAfterSortStrategy(Queue<DummyObject> queue) {
		super(queue);
		linkedList = new LinkedList<>(queue);
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return linkedList.getClass();
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.RANDOM_ACCESS_LINKED_LIST_AFTER_SORT_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		Collections.sort(linkedList);
		return super.computeElapsedNanoSeconds(linkedList);
	}
}
