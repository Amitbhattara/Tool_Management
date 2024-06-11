package com.rentatool.test;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"com.toolrental.test", "com.toolrental"})
@Suite
@SuiteDisplayName("Tool Rental Application Test Suite")
public class ToolRentalApplicationTestSuite {

}
