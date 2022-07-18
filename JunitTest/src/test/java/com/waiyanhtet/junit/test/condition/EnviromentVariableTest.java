package com.waiyanhtet.junit.test.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class EnviromentVariableTest {

	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	void onlyOnStagingServer() {

	}

	@Test
	@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
	void notOnDeveloperWorkstation() {

	}
}
