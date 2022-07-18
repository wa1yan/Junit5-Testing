package com.waiyanhtet.junit.test.repeated;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTestDemo {

	@RepeatedTest(value = 4, name = "{displayName} : {currentRepetition} of {totalRepetition}")
	@DisplayName("Repeated test demo !")
	void repeated_test_custom_display_name(TestInfo info) {
		System.out.println(info);
	}
	
	@RepeatedTest(4)
	void repeated_test_repetition_demo(RepetitionInfo info) {
		System.out.println(info);
	}
	
	@RepeatedTest(value = 3, name = RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
	void repeated_test_with_long_pattern() {
		
	}
}
