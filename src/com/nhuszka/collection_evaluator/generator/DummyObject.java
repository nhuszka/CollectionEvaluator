package com.nhuszka.collection_evaluator.generator;

public class DummyObject {
	private final String content = DummyStringGenerator.generateString();

	@Override
	public String toString() {
		return content;
	}
}
