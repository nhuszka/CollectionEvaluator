package com.nhuszka.collection_evaluator;

import com.nhuszka.collection_evaluator.evaluator.CollectionEvaluatorFacade;
import com.nhuszka.collection_evaluator.message.Texts;
import com.nhuszka.collection_evaluator.setting.ArgumentParser;

public class CollectionEvaluatorStarter {

	public static void main(String[] arguments) {
		System.out.println(Texts.START_PROGRAM);

		ArgumentParser argumentParser = new ArgumentParser();
		argumentParser.createSettingsFromArguments(arguments);

		CollectionEvaluatorFacade evaluatorApp = new CollectionEvaluatorFacade();
		evaluatorApp.start();

		System.out.println(Texts.END_PROGRAM);
	}
}
