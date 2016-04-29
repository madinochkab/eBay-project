/**
 *   File Name: Locator.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 21, 2016
 *
 */

package com.sqa.ms.util.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Locator //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Siebenthal, Madina
 * @version 1.0.0
 * @since 1.0
 *
 */
public class Locator {
	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		return driver.findElements(By.tagName(tagName));

	}

	// - Create a helper method which locates all elements on a page and stores
	// them inside a List Collection using the CSS Selector strategy:
	public static List<WebElement> getCSS(WebDriver driver, String cssSelector) {
		return null;
	}

	public static List<WebElement> getLinks(WebDriver driver) {

		return getByTagName(driver, "a");
	}

	public static List<WebElement> getPictures(WebDriver driver) {
		return getByTagName(driver, "img");
	}

	public static List<WebElement> getTextElements(WebDriver driver, String text) {
		return null;
	}
	// *These are deviations of the following method:

}
