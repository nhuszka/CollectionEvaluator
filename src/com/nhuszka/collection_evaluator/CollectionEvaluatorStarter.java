package com.nhuszka.collection_evaluator;

import com.nhuszka.collection_evaluator.setting.ArgumentParser;

public class CollectionEvaluatorStarter {

	public static void main(String[] arguments) {
		ArgumentParser argumentParser = new ArgumentParser();
		argumentParser.createSettingsFromArguments(arguments);

		CollectionEvaluator evaluatorApp = new CollectionEvaluator();
		evaluatorApp.start();
	}
}
