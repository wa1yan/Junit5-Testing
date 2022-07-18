package com.waiyanhtet.junit.test.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OperationSystemConditionTest {

	@Test
	@EnabledOnOs(OS.WINDOWS)
	void enabled_on_windows() {
		System.out.println("This is windows testing for enabled");
	}
	
	@Test
	@DisabledOnOs(OS.WINDOWS)
	void disabled_on_windows() {
		System.out.println("This is windows testing for disabled");
	}
	
	@Test
	@EnabledOnOs({OS.LINUX,OS.MAC})
	void test_on_others() {
		System.out.println("This is other os testing");
	}
}
