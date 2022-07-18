package com.waiyanhtet.junit.test.param;

import java.util.EnumSet;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(OrderAnnotation.class)
public class ParameterizedTestDemo {

	
	@Order(1)
	@ParameterizedTest
	@ValueSource(strings = {"a","b"})
	void test(String str) {

	}
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = {1,2})
	void test(int num) {

	}
	
	@Order(3)
	@ParameterizedTest
	@NullSource
	@EmptySource
	void null_and_empty_source_test(String text) {
		System.out.println("Text is "+ text);
	}
	
	@Order(4)
	@ParameterizedTest
	@NullSource
	@EmptySource
	//@ValueSource(strings = {" ","	","\t","\n"})
	void null_and_empty_and_blank_test(String text) {
		System.out.println("Text is "+ text);
		Assertions.assertTrue(text == null || text.trim().isEmpty());
	}
	
	@Order(5)
	@ParameterizedTest
	@EnumSource(Role.class)
	void enum_source_test(Role role) {
		System.out.println("Role is "+ role);
	}
	
	@Order(6)
	@ParameterizedTest
	@EnumSource(mode = Mode.INCLUDE, names = {"Admin","Member"})
	void enum_source_strings_test(Role role) {
		System.out.println("Role " + role);
		Assertions.assertTrue(EnumSet.of(Role.Admin, Role.Member).contains(role));
	}
	
	@Order(7)
	@ParameterizedTest
	@EnumSource(mode = Mode.MATCH_ALL, names ="^.*m.*$")
	void enum_source_regex_test(Role role) {
		System.out.println("Role " + role);
		Assertions.assertTrue(role.name().contains("m"));
	}
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	void method_source_test1(String argument) {
		System.out.println(argument);
	}

	static Stream<String> stringProvider() {
		return Stream.of("apple","orange");
	}
	
	@ParameterizedTest
	@MethodSource("testWithDefaultLocalMethodSource") //same method name
	void method_source_test2(String argument) {
		System.out.println(argument);
	}
	
	static Stream<String> testWithDefaultLocalMethodSource(){
		return Stream.of("pineapple","grape","strawberry");
	}
}
