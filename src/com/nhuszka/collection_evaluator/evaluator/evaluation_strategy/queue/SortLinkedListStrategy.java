package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class SortLinkedListStrategy extends QueueEvaluationStrategy {

	private final LinkedList<DummyObject> linkedList;

	public SortLinkedListStrategy(Queue<DummyObject> queue) {
		super(queue);
		linkedList = new LinkedList<>(queue);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.SORT_LINKED_LIST_STRATEGY_TITLE;
	}

	@Override
	protected Queue<DummyObject> getEvaluatedCollection() {
		return linkedList;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		Long startTime = System.nanoTime();
		Collections.sort(linkedList);
		Long elapsedNanoSec = System.nanoTime() - startTime;

		elapsedNanoSeconds.add(elapsedNanoSec);

		return elapsedNanoSeconds;
	}
}
