package com.sqa.ms;

import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sqa.ms.util.helpers.ConProperties;

public class BasicAutoTest {

	private static String baseURL;

	private static Properties devProps;

	private static String devPropsLocation = "src/main/resources/dev.properties";

	private static WebDriver driver;

	private static Properties sharedMapUI;

	private static String sharedMapUILocation = "src/main/resources/shared-map-ui.properties";

	@DataProvider(name = "UserAccountInfo")
	public static Object[][] getLoginData() {
		// Create a 2D Object with only one level (for one test)
		Object[][] data = new Object[1][];
		// Create a test with 2 elements for username and password
		Object[] test = { devProps.get("username"), devProps.get("password") };
		// Set the array of parameters to be the first element (and only) for
		// the data
		data[0] = test;
		//// System.out.println("Username:" + data[0][0] + " Password:" +
		//// data[0][1]);
		return data;
	}

	@BeforeClass(enabled = false, groups = "chrome")
	public static void setupChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);
	}

	@BeforeClass(groups = "firefox", dependsOnMethods = "loadProperties")
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get(devProps.getProperty("baseURL"));
	}

	@BeforeClass(enabled = false, groups = "opera")
	public static void setupOpera() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
		driver = new OperaDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);
	}

	@BeforeClass(enabled = false, groups = "safari")
	public static void setupSafari() throws InterruptedException {
		driver = new SafariDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void loadProperties() {
		sharedMapUI = ConProperties.loadProperties(sharedMapUILocation);
		devProps = ConProperties.loadProperties(devPropsLocation);
	}

	@Test(dataProvider = "dp", priority = 50)
	public void test(Integer n, String s) {
		System.out.println("Test " + n);
	}

	@Test(dataProvider = "UserAccountInfo")
	public void testLogin(String username, String password) throws InterruptedException {
		clickSigninBtn();
		enterCredentialsAndLogin(username, password);
		if (isElementPresent(By.partialLinkText("Sign"))) {
			Assert.fail("Did not sign in correctly.");
		}
	}

	/**
	 *
	 */
	private void clickSigninBtn() {
		WebElement signInBtn;
		signInBtn = driver.findElement(By.xpath(sharedMapUI.getProperty("signInBtn")));
		signInBtn.click();
	}

	/**
	 * @param username
	 * @param password
	 */
	private void enterCredentialsAndLogin(String username, String password) {
		WebElement usernameFld;
		WebElement passwordFld;
		usernameFld = driver.findElement(By.xpath(sharedMapUI.getProperty("usernameFld")));
		passwordFld = driver.findElement(By.xpath(sharedMapUI.getProperty("passwordFld")));
		usernameFld.sendKeys(username);
		passwordFld.sendKeys(password);
		passwordFld.submit();
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}

// private static String baseURL;
// private static Properties devProps;
// private static String devPropsLocation = "src/main/resources/dev.properties";
// private static String sharedMapUILocation =
// "src/main/resources/shared-map-ui.properties";
// private static Properties shareMapUI;
// static WebDriver driver;
//
// @DataProvider
// public static Object[][] dp() {
// return new Object[][] { { 1, "a" }, { 2, "b" } };
// }
//
// @BeforeClass(enabled = false, groups = "chrome")
// public static void setupChrome() throws InterruptedException {
// System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
// driver = new ChromeDriver();
// driver.get("http://gmail.com");
// Thread.sleep(1000);
//
// }
//
// @BeforeClass(groups = "firefox", dependsOnMethods = "loadProperties")
// public static void setupFirefox() throws InterruptedException {
// driver = new FirefoxDriver();
// driver.get(devProps.getProperty("baseURL"));
//
// }
//
// @BeforeClass(enabled = false, groups = "opera")
// public static void setupOpera() throws InterruptedException {
// System.setProperty("webdriver.opera.driver", "drivers/operadriver");
// driver = new OperaDriver();
// driver.get("http://gmail.com");
// Thread.sleep(1000);
//
// }
//
// @BeforeClass(enabled = false, groups = "safari")
// public static void setupSafari() throws InterruptedException {
// driver = new SafariDriver();
// driver.get("http://gmail.com");
// Thread.sleep(1000);
//
// }
//
// @Test(dataProvider = "dp", priority = 50)
// public void f(Integer n, String s) {
// System.out.println("Test " + n);
// }
//
// @DataProvider(name = "UserAccountInfo")
// public Object[][] getLoginData() {
// // create 2D object with only one level (for one test)
// Object[][] data = new Object[1][];
// // create a test with 2 elements for username and password
// Object[] test = { devProps.get("username"), devProps.get("password") };
// // set an array of parameters to be the first element (and only) for the
// // data
// data[0] = test;
// // System.out.println(" username: " + data[0][0] + " password: " +
// // data[0][1]);
// return data;
// }
//
// @BeforeClass
// public void loadProperties() {
// shareMapUI = ConProperties.loadProperties(this.sharedMapUILocation);
// devProps = ConProperties.loadProperties(this.devPropsLocation);
// }
//
// @Test(dataProvider = "UserAccountInfo")
// public void testLogin(String username, String password) throws
// InterruptedException {
// System.out.println("Basic Test: U-" + username + "/P-" + password);
// WebElement signInBtn;
// WebElement usernameFld;
// WebElement passwordFld;
// signInBtn =
// driver.findElement(By.xpath(shareMapUI.getProperty("signInBtn")));
// signInBtn.click();
// usernameFld =
// driver.findElement(By.xpath(shareMapUI.getProperty("usernameFld")));
// passwordFld =
// driver.findElement(By.xpath(shareMapUI.getProperty("passwordFld")));
// usernameFld.sendKeys(username);
// passwordFld.sendKeys(password);
// passwordFld.submit();
//
// if (isElementPresent(By.partialLinkText("Sign"))) {
// Assert.fail("Did not sign in correctly");
// }
// String helloMessage =
// driver.findElement(By.cssSelector("//a[@id='gh-ug']")).getText();
// System.out.println(helloMessage);
// // Thread.sleep(1000);
//
// }
//
// private boolean isElementPresent(By by) {
// try {
// this.driver.findElement(by);
// return true;
// } catch (NoSuchElementException e) {
// return false;
// }
// }
//
// }
//
/// **
// * @param partialLinkText
// * @return
// */
