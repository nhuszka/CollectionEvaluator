package com.nhuszka.collection_evaluator.setting;

import com.nhuszka.collection_evaluator.message.Texts;

public enum EvaluatedCollectionInterface {
	MAP(Texts.MAP), QUEUE(Texts.QUEUE);

	private String description;

	private EvaluatedCollectionInterface(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}