package com.waiyanhtet.junit.test.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

public class CustomConditionTest {
	
	@Test
	@EnabledIf("isTest")
	void is_test() {
		
	}
	
	@Test
	@EnabledIf("isNotTest")
	void is_not_test() {
		
	}
	
	boolean isTest() {
		return true;
	}
	
	boolean isNotTest() {
		return false;
	}
	
	
}
