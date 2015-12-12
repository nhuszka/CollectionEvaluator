package com.nhuszka.collection_evaluator.result.exception;

public class IncorrectEvaluationResultException extends Exception {

	private static final long serialVersionUID = -5209690484367059796L;

	private String evaluationDescription = "Unknown evaluation";
	private String errorCause = "Unknown cause";

	public IncorrectEvaluationResultException(String errorCause) {
		this.errorCause = errorCause;
	}

	public IncorrectEvaluationResultException(String evaluationDescription, String errorCause) {
		this.evaluationDescription = evaluationDescription;
		this.errorCause = errorCause;
	}

	public String getEvaluationDescription() {
		return evaluationDescription;
	}

	public String getErrorCause() {
		return errorCause;
	}
}
