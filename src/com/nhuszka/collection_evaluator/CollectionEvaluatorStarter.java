package com.nhuszka.collection_evaluator;

import com.nhuszka.collection_evaluator.evaluator.CollectionEvaluatorFacade;
import com.nhuszka.collection_evaluator.setting.ArgumentParser;

public class CollectionEvaluatorStarter {

	public static void main(String[] arguments) {
		ArgumentParser argumentParser = new ArgumentParser();
		argumentParser.createSettingsFromArguments(arguments);

		CollectionEvaluatorFacade evaluatorApp = new CollectionEvaluatorFacade();
		evaluatorApp.start();
	}
}
