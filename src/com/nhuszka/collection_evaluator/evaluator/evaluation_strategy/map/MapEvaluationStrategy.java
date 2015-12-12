package com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationStrategy;
import com.nhuszka.collection_evaluator.evaluator.evaluation_strategy.EvaluationUtil;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.message.Texts;

public abstract class MapEvaluationStrategy extends EvaluationStrategy {

	protected final Map<DummyObject, DummyObject> map;

	public MapEvaluationStrategy(Map<DummyObject, DummyObject> map) {
		this.map = map;
	}

	protected final List<DummyObject> computeRandomKeys() {
		List<DummyObject> keys = new ArrayList<>(map.keySet());
		return EvaluationUtil.getRandomKeys(keys, NUM_OF_ITERATION);
	}

	@Override
	protected String getEvaluationDescription() {
		return getEvaluationTitle() + String.format(Texts.EVALUATION_DETAILS, NUM_OF_ITERATION, map.getClass());
	}

	protected abstract String getEvaluationTitle();

}
