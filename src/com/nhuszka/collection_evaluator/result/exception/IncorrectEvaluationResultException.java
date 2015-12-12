package com.nhuszka.collection_evaluator.result.exception;

import com.nhuszka.collection_evaluator.message.Texts;

public class IncorrectEvaluationResultException extends Exception {

	private static final long serialVersionUID = -5209690484367059796L;

	private String evaluationDescription = Texts.UNKNOWN_EVALUATION;
	private String errorCause = Texts.UNKNOWN_CAUSE;

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
