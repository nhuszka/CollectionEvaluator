package com.nhuszka.collection_evaluator.setting;

public enum EvaluatedCollectionInterface {
	MAP("Map"), QUEUE("Queue");

	private String description;

	private EvaluatedCollectionInterface(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}