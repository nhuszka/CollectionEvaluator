package com.nhuszka.collection_evaluator.setting;

public class ArgumentParser {

	private StringBuilder errorMsg = new StringBuilder();

	public void createSettingsFromArguments(String[] arguments) {
		EvaluatedCollectionInterface evaluatedInterface = parseEvaluatedInterfaceParam(arguments);
		Integer numberOfElementsPerInterface = parseNumOfElementsPerCollectionArgument(arguments);

		EvaluatorSettings.createSettings(evaluatedInterface, numberOfElementsPerInterface);

		printErrorMessageOnDemand();
	}

	private EvaluatedCollectionInterface parseEvaluatedInterfaceParam(String[] arguments) {
		String argument1 = arguments[0];
		switch (argument1.toLowerCase()) {
			case "map" :
				return EvaluatedCollectionInterface.MAP;
			case "queue" :
				return EvaluatedCollectionInterface.QUEUE;
			default :
				break;
		}
		return fallbackToDefaultInterfaceParam();
	}

	private EvaluatedCollectionInterface fallbackToDefaultInterfaceParam() {
		// TODO other exception handling
		addUsageMsg();
		errorMsg.append("\n")
				.append("Incorrect first parameter, 'collection interface to evaluate'. ")
				.append("Fall back to default: ")
				.append(EvaluatorSettings.DEFAULT_INTERFACE_SETTING)
				.append("\n");
		return EvaluatorSettings.DEFAULT_INTERFACE_SETTING;
	}

	private void addUsageMsg() {
		errorMsg.append("Usage:")
				.append("\n")
				.append("\tfirst parameter (collection interface to evaluate): map/queue")
				.append("\n")
				.append("\tsecond parameter (number of elements per collection): an integer that is greater than 0")
				.append("\n");
	}

	private Integer parseNumOfElementsPerCollectionArgument(String[] arguments) {
		try {
			if (arguments.length > 1) {
				Integer numOfElementsParam = Integer.parseInt(arguments[1]);
				if (numOfElementsParam > 0) {
					return Integer.parseInt(arguments[1]);
				}
			}
			return fallbackToDefaultNumOfElementsParam();
		} catch (NumberFormatException nfe) {
			return fallbackToDefaultNumOfElementsParam();
		}
	}

	private Integer fallbackToDefaultNumOfElementsParam() {
		// TODO other exception handling
		if (errorMsg.toString().isEmpty()) {
			addUsageMsg();
		}
		errorMsg.append("\n")
				.append("Incorrect second parameter, 'number of elements per collection'. ")
				.append("Fall back to default: ")
				.append(EvaluatorSettings.DEFAULT_NUM_OF_ELEMENTS_SETTING)
				.append("\n");
		return EvaluatorSettings.DEFAULT_NUM_OF_ELEMENTS_SETTING;
	}

	private void printErrorMessageOnDemand() {
		String errorMessage = errorMsg.toString();
		if (!errorMessage.isEmpty()) {
			System.out.println(errorMessage);
		}
	}
}
