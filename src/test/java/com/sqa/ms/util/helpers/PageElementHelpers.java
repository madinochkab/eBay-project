package com.sqa.ms.util.helpers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PageElementHelpers {

	// public static List<WebElement> getPictures(WebDriver driver);
	// public static List<WebElement> getLinks(WebDriver driver);
	// public static List<WebElement> getTextElements(WebDriver driver, String
	// text);
	//
	// *These are deviations of the following method:
	//
	// public static List<WebElement> getByTagName(WebDriver driver, String
	// tagName);

	@AfterClass
	public void afterClass() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}

}
