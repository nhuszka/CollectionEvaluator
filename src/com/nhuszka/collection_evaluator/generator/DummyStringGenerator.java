package com.nhuszka.collection_evaluator.generator;

import java.util.Random;

public class DummyStringGenerator {

	private static final Integer MAX_LENGTH = 10;
	private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	public static String generateString() {
		final StringBuilder stringBuilder = new StringBuilder();
		final Random random = new Random();

		for (int i = 0; i < MAX_LENGTH; ++i) {
			char character = CHARACTERS[random.nextInt(CHARACTERS.length)];
			stringBuilder.append(character);
		}

		return stringBuilder.toString();
	}
}
