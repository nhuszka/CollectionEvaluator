package com.nhuszka.collection_evaluator.setting;

import java.util.Optional;

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
	
	private static EvaluatorSettings getNewlyCreatedDefaultSettings() {
		return settings = new EvaluatorSettings(DEFAULT_INTERFACE_SETTING, DEFAULT_NUM_OF_ELEMENTS_SETTING);
	}

	public static EvaluatorSettings getSettings() {
		return Optional.ofNullable(settings).orElse(getNewlyCreatedDefaultSettings());
	}

	public EvaluatedCollectionInterface getEvaluatedInterface() {
		return evaluatedInterface;
	}

	public Integer getNumberOfElementsPerInterface() {
		return numberOfElementsPerInterface;
	}
}
