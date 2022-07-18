package com.waiyanhtet.junit.test.suites;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@SelectPackages(value = { "com.waiyanhtet.junit.test" })
@ExcludePackages(value = "com.waiyanhtet.junit.test.suites")
@Suite
@SuiteDisplayName("All Packed test with suites")
public class TestSuite {

}
