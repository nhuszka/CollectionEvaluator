package com.nhuszka.collection_evaluator.setting;

public class EvaluatorSettings {
	private EvaluatedCollectionInterface evaluatedInterface;
	private Integer numberOfElementsPerInterface;

	private static EvaluatorSettings settings;

	private EvaluatorSettings(EvaluatedCollectionInterface evaluatedInterface,
			Integer numberOfElementsPerInterface) {
		this.evaluatedInterface = evaluatedInterface;
		this.numberOfElementsPerInterface = numberOfElementsPerInterface;
	}

	public static void createSettings(EvaluatedCollectionInterface evaluatedInterface,
			Integer numberOfElementsPerInterface) {
		settings = new EvaluatorSettings(evaluatedInterface, numberOfElementsPerInterface);
	}

	// TODO Optional interface usage
	public static EvaluatorSettings getSettings() {
		if (settings == null) {
			settings = new EvaluatorSettings(EvaluatedCollectionInterface.MAP, 10);
		}
		return settings;
	}

	public EvaluatedCollectionInterface getEvaluatedInterface() {
		return evaluatedInterface;
	}

	public Integer getNumberOfElementsPerInterface() {
		return numberOfElementsPerInterface;
	}
}
