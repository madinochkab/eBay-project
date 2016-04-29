package com.sqa.ms.util.helpers;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicAutomationTest {

	private String baseURL = "http://google.com";
	private Properties devProps;
	private String devPropsLocation = "src/main/resources/dev.properties";
	private String sharedMapUILocation = "src/main/resources/shared-map-ui.properties";
	private Properties shareMapUI;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@Test(dataProvider = "dp", priority = 50)
	public void f(Integer n, String s) {
		System.out.println("Test " + n);
	}

	@BeforeClass
	public void loadProperties() {
		this.shareMapUI = ConProperties.loadProperties(this.devPropsLocation);
		this.devProps = ConProperties.loadProperties(this.devPropsLocation);
	}

	@Test(priority = 1)
	public void setUpTest() {
		// setup web driver
		WebDriver driver = new FirefoxDriver();
		// go to web page
		driver.get(this.baseURL);
	}
}
