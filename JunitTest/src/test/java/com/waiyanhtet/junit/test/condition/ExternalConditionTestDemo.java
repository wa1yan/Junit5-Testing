package com.waiyanhtet.junit.test.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

public class ExternalConditionTestDemo {

	@Test
	@EnabledIf("com.waiyanhtet.junit.test.condition.ExternalCondtionTest#isTest")
	void test() {

	}
}
