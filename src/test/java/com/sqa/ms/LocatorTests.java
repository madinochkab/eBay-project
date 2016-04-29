package com.sqa.ms;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sqa.ms.util.helpers.Locator;

public class LocatorTests {

	static WebDriver driver;

	@BeforeClass
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();

	}

	@Test(priority = 1)
	public void test1() {
		String pageTitle = "MSN.com - Hotmail, Outlook, Skype, Bing, Latest News, Photos & Videos";

		driver.get("http://msn.com");
		Assert.assertEquals(driver.getTitle(), pageTitle, "page does not seem successfull");
		System.out.println("page title: " + driver.getTitle());

	}

	@Test(priority = 2)
	public void test2() {
		List<WebElement> links = Locator.getLinks(this.driver);
		int i = 1;
		for (WebElement link : links) {
			String text = link.getText();
			if (text.equals("")) {
				text = "non text element (" + i + ")";
				i++;
			}
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
	}
}
