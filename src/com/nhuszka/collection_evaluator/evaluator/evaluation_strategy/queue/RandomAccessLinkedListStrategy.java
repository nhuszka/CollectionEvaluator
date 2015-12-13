package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class RandomAccessLinkedListStrategy extends QueueEvaluationStrategy {

	private final LinkedList<DummyObject> linkedList;

	public RandomAccessLinkedListStrategy(Queue<DummyObject> queue) {
		super(queue);
		linkedList = new LinkedList<>(queue);
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.RANDOM_ACCESS_LINKED_LIST_STRATEGY_TITLE;
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return linkedList.getClass();
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		return computeElapsedNanoSeconds(linkedList);
	}

	protected List<Long> computeElapsedNanoSeconds(LinkedList<DummyObject> list) {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		List<DummyObject> elementsInQueue = new ArrayList<>(list);
		List<DummyObject> randomElements = computeRandomElements();
		for (DummyObject element : randomElements) {
			Integer index = elementsInQueue.indexOf(element);

			Long startTime = System.nanoTime();
			list.get(index);
			Long elapsedNanoSec = System.nanoTime() - startTime;

			elapsedNanoSeconds.add(elapsedNanoSec);
		}

		return elapsedNanoSeconds;
	}
}
