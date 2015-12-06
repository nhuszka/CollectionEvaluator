package com.nhuszka.collection_evaluator.generator;

public class DummyObject implements Comparable<DummyObject> {
	private final String content = DummyStringGenerator.generateString();

	@Override
	public String toString() {
		return content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 7;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public int compareTo(DummyObject other) {
		return toString().compareTo(other.toString());
	}
}
