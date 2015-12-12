package com.nhuszka.collection_evaluator.setting;

import com.nhuszka.collection_evaluator.message.Texts;

public class ArgumentParser {

	private StringBuilder errorMsg = new StringBuilder();

	public void createSettingsFromArguments(String[] arguments) {
		final EvaluatedCollectionInterface evaluatedInterface = parseEvaluatedInterfaceParam(arguments);
		final Integer numberOfElementsPerInterface = parseNumOfElementsPerCollectionArgument(arguments);

		EvaluatorSettings.createSettings(evaluatedInterface, numberOfElementsPerInterface);

		printErrorMessageOnDemand();
	}

	private EvaluatedCollectionInterface parseEvaluatedInterfaceParam(String[] arguments) {
		if (arguments.length > 0) {
			String argument1 = arguments[0];
			switch (argument1.toLowerCase()) {
				case Texts.MAP :
					return EvaluatedCollectionInterface.MAP;
				case Texts.QUEUE :
					return EvaluatedCollectionInterface.QUEUE;
				default :
					break;
			}
		}
		return fallbackToDefaultInterfaceParam();
	}

	private EvaluatedCollectionInterface fallbackToDefaultInterfaceParam() {
		addUsageMsg();
		errorMsg.append(Texts.NEW_LINE)
				.append(Texts.INCORRECT_FIRST_PARAMETER)
				.append(Texts.NEW_LINE)
				.append(Texts.FALL_BACK_TO_DEFAULT)
				.append(EvaluatorSettings.DEFAULT_INTERFACE_SETTING)
				.append(Texts.NEW_LINE);
		return EvaluatorSettings.DEFAULT_INTERFACE_SETTING;
	}

	private void addUsageMsg() {
		errorMsg.append(Texts.USAGE)
				.append(Texts.NEW_LINE)
				.append(Texts.USAGE_FIRST_PARAMETER)
				.append(Texts.MAP).append("/").append(Texts.QUEUE)
				.append(Texts.NEW_LINE)
				.append(Texts.USAGE_SECOND_PARAMETER)
				.append(Texts.NEW_LINE);
	}

	private Integer parseNumOfElementsPerCollectionArgument(String[] arguments) {
		try {
			if (arguments.length > 1) {
				final String secondArgument = arguments[1];
				Integer numOfElementsParam = Integer.parseInt(secondArgument);
				if (numOfElementsParam > 0) {
					return numOfElementsParam;
				}
			}
			return fallbackToDefaultNumOfElementsParam();
		} catch (NumberFormatException nfe) {
			return fallbackToDefaultNumOfElementsParam();
		}
	}

	private Integer fallbackToDefaultNumOfElementsParam() {
		if (errorMsg.toString().isEmpty()) {
			addUsageMsg();
		}
		errorMsg.append(Texts.NEW_LINE)
				.append(Texts.INCORRECT_SECOND_PARAMETER)
				.append(Texts.NEW_LINE)
				.append(Texts.FALL_BACK_TO_DEFAULT)
				.append(EvaluatorSettings.DEFAULT_NUM_OF_ELEMENTS_SETTING)
				.append(Texts.NEW_LINE);
		return EvaluatorSettings.DEFAULT_NUM_OF_ELEMENTS_SETTING;
	}

	private void printErrorMessageOnDemand() {
		String errorMessage = errorMsg.toString();
		if (!errorMessage.isEmpty()) {
			System.out.println(errorMessage);
		}
	}
}
