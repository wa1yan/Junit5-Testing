package com.waiyanhtet.junit.test.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class SystemPropertiesConditionTest {

	@Test
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	void test() {
		
	}
	
	@Test
	@DisabledIfSystemProperty(named = "ci-server", matches = "true")
	void notOnCiServer() {

	}
}
