package com.waiyanhtet.junit.test.lifecycle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardAndDisplayNameDemo {

	
	@BeforeAll
	static void  test1() {
		System.out.println("This is before all.");
	}
	
	@AfterAll
	static void  test_after_all() {
		System.out.println("This is after all.");
	}
	
	@BeforeEach
	void test2() {
		System.out.println("This is before each.");
	}
	
	@AfterEach
	void test3() {
		System.out.println("This is after each.");
	}
	
	@Test
	void test4() {	
		
		//Group Assertions
		List<String> list = List.of("true","b","c","s");		
		assertAll(
				"list",
				() -> assertEquals("true",list.get(0)),
				() -> assertInstanceOf(String.class, list.get(1)),
				() -> assertSame(true, !false),
				() -> assertNotNull(list.get(3), "This is null value."),
				() -> assertThrows(ArrayIndexOutOfBoundsException.class,()-> list.get(4))
				);
		
		assertEquals("true",list.get(0));
		
		Assumptions.assumeTrue(list.size() > 5);
		assertNotNull(list.get(4));
		
		Assumptions.assumeTrue(list.size() > 5);
		assertNotNull(list.get(6));	
	}
}
