package com.nhuszka.collection_evaluator.setting;

public class EvaluatorSettings {
	public static final EvaluatedCollectionInterface DEFAULT_INTERFACE_SETTING = EvaluatedCollectionInterface.MAP;
	public static Integer DEFAULT_NUM_OF_ELEMENTS_SETTING = 100;

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
			settings = new EvaluatorSettings(DEFAULT_INTERFACE_SETTING, DEFAULT_NUM_OF_ELEMENTS_SETTING);
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
