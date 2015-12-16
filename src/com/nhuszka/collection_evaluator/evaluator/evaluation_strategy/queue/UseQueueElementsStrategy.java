package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public class UseQueueElementsStrategy extends QueueEvaluationStrategy {

	protected final Queue<DummyObject> queueToTest;

	public UseQueueElementsStrategy(Queue<DummyObject> queue, Queue<DummyObject> queueToTest) {
		super(queue);
		this.queueToTest = queueToTest;
		this.queueToTest.addAll(queue);
	}

	@Override
	protected Class<? extends Object> getEvaluatedCollectionClass() {
		return queueToTest.getClass();
	}

	@Override
	protected String getEvaluationTitle() {
		return Texts.USE_QUEUE_ELEMENT_STRATEGY_TITLE;
	}

	@Override
	protected List<Long> computeElapsedNanoSeconds() {
		List<Long> elapsedNanoSeconds = new ArrayList<>();

		Long startTime = System.nanoTime();
		computeHashCodesSum();
		Long elapsedNanoSec = System.nanoTime() - startTime;

		elapsedNanoSeconds.add(elapsedNanoSec);

		return elapsedNanoSeconds;
	}

	protected int computeHashCodesSum() {
		int hashCodesSum = 0;
		for (DummyObject element : queueToTest) {
			hashCodesSum += element.hashCode();
		}
		return hashCodesSum;
	}
}
