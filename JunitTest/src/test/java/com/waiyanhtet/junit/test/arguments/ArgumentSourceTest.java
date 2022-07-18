package com.waiyanhtet.junit.test.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class ArgumentSourceTest {
	
	@DisplayName("Display name of container")
	@ParameterizedTest(name = "{index} ===> the rank of {0} is {1}")
	@ArgumentsSource(MyArgumentProvider.class)
	void test_argument_source(String arguments) {
		
	}
}
