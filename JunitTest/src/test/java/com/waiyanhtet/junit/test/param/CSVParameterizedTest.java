package com.waiyanhtet.junit.test.param;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class)
public class CSVParameterizedTest {

	@Order(1)
	@ParameterizedTest
	@CsvSource({
			 "apple,         1",
			 "banana,        2",
			 "'lemon, lime', 0xF1",
			 "strawberry,    700_000"})
	void test_with_csv(String fruit, int rank) {
		System.out.println(fruit);
		System.out.println(rank);
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource(
			 value= {"apple, Orange", "fruits, 'Lemon, Straw'", "Grape , NIL"},
			 nullValues = "NIL"
			)
	void test_with_csv2(String fruit1, String fruit2) {
		System.out.println(fruit1 +" "+ fruit2);
	}
	
	@Order(3)
	@ParameterizedTest(name = "[{index}] {arguments}")
	@CsvSource(useHeadersInDisplayName = true,textBlock = """
			 FRUIT,         RANK
			apple,         1
			banana,        2
			'lemon, lime', 0xF1
			strawberry,    700_000
			""")
	void test_with_cs_with_header(String fruit1, String fruit2) {
		System.out.println(fruit1 +" "+ fruit2);
	}
	
	@Order(4)
	@ParameterizedTest()
	@CsvFileSource(files = "src/test/resources/csvsource1.csv", numLinesToSkip = 1)
	void test_with_csv_file_in_resource(String fruit, int rank) {
		System.out.println(fruit +" " + rank);
	}
	
	@Order(5)
	@ParameterizedTest()
	@CsvFileSource(resources = "/csvsource1.csv", numLinesToSkip = 1)
	void test_with_csv_file(String fruit, int rank) {
		System.out.println(fruit +" " + rank);
	}
	
	@Order(6)
	@ParameterizedTest(name = "[{index}] {arguments}")
	@CsvFileSource(resources = "/csvsource1.csv",useHeadersInDisplayName = true)
	void test_with_csv_with_header(String fruit, int rank) {
		System.out.println(fruit +" " + rank);
	}
}
