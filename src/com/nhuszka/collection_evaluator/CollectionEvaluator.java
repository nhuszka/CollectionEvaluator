package com.nhuszka.collection_evaluator;

import java.util.Map;
import java.util.Queue;

import com.nhuszka.collection_evaluator.generator.CollectionGenerator;
import com.nhuszka.collection_evaluator.generator.DummyObject;
import com.nhuszka.collection_evaluator.generator.MapGenerator;
import com.nhuszka.collection_evaluator.generator.QueueGenerator;

public class CollectionEvaluator {

	public void start() {
		MapGenerator mapGenerator = new MapGenerator();
		Map<DummyObject, DummyObject> map = mapGenerator.generate(10);

		CollectionGenerator queueGenerator = new QueueGenerator();
		Queue<DummyObject> queue = (Queue<DummyObject>) queueGenerator.generate(10);

		System.out.println(map);
		System.out.println(queue);
	}
}
