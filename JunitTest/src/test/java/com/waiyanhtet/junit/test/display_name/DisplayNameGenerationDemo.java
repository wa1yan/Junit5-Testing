package com.waiyanhtet.junit.test.display_name;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class DisplayNameGenerationDemo {

	@Order(1)
	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
	class simple_display_name_demo_test {
		
		@Test
		void test1() { //test1
			
		}
		
	}
	
	@Order(2)
	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
	class standard_display_name_demo_test {
		
		@Test
		void test1() { //test1()
			
		}
		
	}
	
	@Order(3)
	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class replace_underscore_display_name_demo_test {
		
		@Test
		void test1() { 
			
		}
		
	}
	
	@Order(4)
	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
	class indicative_senstence_display_name_demo_test {
		
		@Test
		void test_1() {
			
		}
		
		@Test
		void test_2() {
			
		}
		
	}
	
	@Nested
	@IndicativeSentencesGeneration( separator = "->", generator  = DisplayNameGenerator.ReplaceUnderscores.class)
	class indicative_senstence_anno_display_name_demo_test {
		
		@Test
		void test_1() {
			
		}
		
		@Test
		void test_2() {
			
		}
		
	}
}
