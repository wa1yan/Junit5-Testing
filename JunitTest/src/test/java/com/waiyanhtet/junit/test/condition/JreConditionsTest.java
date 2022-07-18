package com.waiyanhtet.junit.test.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JreConditionsTest {

	@Test
	@EnabledOnJre(value = JRE.JAVA_17)
	void enabled_on_jre_17() {
		
	}
	
	@Test
	@EnabledOnJre(value = JRE.JAVA_11)
	void enabled_on_jre_11() {
		
	}
	
	@Test
	@DisabledOnJre(value = JRE.JAVA_17)
	void disabled_on_jre_17() {
		
	}
	
	@Test
	@EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
	void enabled_between_jre_11_and_jre_17() {
		
	}
	
	@Test
	@DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
	void disabled_between_jre_11_and_jre_17() {
		
	}
	
	@Test
	@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_10)
	void enabled_between_jre_8_and_jre_10() {
		
	}
}
