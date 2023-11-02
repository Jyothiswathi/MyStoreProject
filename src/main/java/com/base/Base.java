package com.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Base {

	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public void click(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().build().perform();
	}

	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean isDisplayed = false;
		try {
			ele.isDisplayed();
			isDisplayed = true;
		} catch (Exception e) {

			isDisplayed = false;
		} finally {
			if (isDisplayed) {
				System.out.println("successfully found element");
			} else {
				System.out.println("unable to locate the element");
			}
		}
		return isDisplayed;
	}

	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean isSelected = false;
		isSelected = findElement(driver, ele);
		if (isSelected) {
			isSelected = ele.isSelected();
			if (isSelected) {
				System.out.println("the element is selected");
			} else {
				System.out.println("the element is selected");
			}
		} else {
			System.out.println("the element is  not selected");
		}
		return isSelected;

	}

	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean isEnabled = false;
		isEnabled = findElement(driver, ele);
		if (isEnabled) {
			isEnabled = ele.isEnabled();
			if (isEnabled) {
				System.out.println("The element is enabled");
			} else {
				System.out.println("The element is not enabled");
			}
		} else {
			System.out.println("Not Enabled");
		}
		return isEnabled;
	}

	boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	public void sendkeys(WebElement ele, String text) {
		boolean isSendKeyys = false;
		try {
			isSendKeyys = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			isSendKeyys = true;
		} catch (Exception e) {
			System.out.println("Element not found");
			isSendKeyys = false;

		} finally {
			if (isSendKeyys) {
				System.out.println("Successfully entered value");
			} else

			{
				System.out.println("unable to locate a value");
			}
		}

	}

}
