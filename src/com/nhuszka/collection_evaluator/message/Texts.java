package com.nhuszka.collection_evaluator.message;

public class Texts {

	public static final String MAP = "map";
	public static final String QUEUE = "queue";

	public static final String NEW_LINE = "\n";

	public static final String FALL_BACK_TO_DEFAULT = "Fall back to default: ";
	public static final String INCORRECT_FIRST_PARAMETER = "Incorrect first parameter, 'collection interface to evaluate'.";
	public static final String INCORRECT_SECOND_PARAMETER = "Incorrect second parameter, 'number of elements per collection'.";
	public static final String USAGE = "Usage:";
	public static final String USAGE_FIRST_PARAMETER = "first parameter (collection interface to evaluate):";
	public static final String USAGE_SECOND_PARAMETER = "second parameter (number of elements per collection): an integer that is greater than 0";

	public static final String EVALUATION_DETAILS = " (%d iteration, %s)";

	public static final String PUT_MAP_STRATEGY_TITLE = "New map element addition in nanosec";
	public static final String RANDOM_ACCESS_MAP_STRATEGY_TITLE = "Random map element access in nanosec";
	public static final String SEARCH_MAP_STRATEGY_TITLE = "Search map element in nanosec";
	public static final String SEARCH_MAP_AFTER_SORT_STRATEGY_TITLE = "Search map element with sorting (converting into TreeMap) in nanosec";
	public static final String SORT_MAP_STRATEGY_TITLE = "Map sorting (converting into TreeMap) in nanosec";

	public static final String ADD_QUEUE_STRATEGY_TITLE = "New queue element addition in nanosec";
	public static final String RANDOM_ACCESS_LINKED_LIST_STRATEGY_TITLE = "Random queue element access in nanosec";
	public static final String RANDOM_ACCESS_LINKED_LIST_AFTER_SORT_STRATEGY_TITLE = "Random queue element access after sort in nanosec";
	public static final String SORT_LINKED_LIST_STRATEGY_TITLE = "Queue sorting in nanosec";

	public static final String SEARCH_QUEUE_STRATEGY_TITLE = "Search queue element in nanosec";
	public static final String FILTER_QUEUE_STREAM_STRATEGY_TITLE = "Filter queue elements (stream) in nanosec";
	public static final String FILTER_QUEUE_STREAM_PARALLEL_STRATEGY_TITLE = "Filter queue elements (stream - parallel) in nanosec";

	public static final String SKIP_EVALUATION_ERROR = "Error! Skipping evaluation:";
	public static final String MISSING_EVALUATION_DESCRIPTION = "Missing evaluation description";
	public static final String MISSING_EVALUATION_MEASUREMENTS = "Missing evaluation measurements";

	public static final String UNKNOWN_EVALUATION = "Unknown evaluation";
	public static final String UNKNOWN_CAUSE = "Unknown cause";

	public static final String MINIMUM = "minimum: ";
	public static final String MAXIMUM = "maximum: ";
	public static final String RATE_OF_ZEROS = "rate of 0 values: ";
	public static final String AVERAGE = "average: ";
	public static final String AVERAGE_WITHOUT_ZEROS = "average without zeros: ";
}
