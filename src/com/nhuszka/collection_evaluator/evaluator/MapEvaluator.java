package com.nhuszka.collection_evaluator.evaluator;

import java.util.Map;
import com.nhuszka.collection_evaluator.display.CollectionEvaluationResult;
import com.nhuszka.collection_evaluator.display.MapEvaluationResult;
import com.nhuszka.collection_evaluator.generator.DummyObject;

class MapEvaluator {
	
	CollectionEvaluationResult evaluate(Map<DummyObject, DummyObject> map) {
		// TODO evaluate
		return new MapEvaluationResult(map);
	}
}
