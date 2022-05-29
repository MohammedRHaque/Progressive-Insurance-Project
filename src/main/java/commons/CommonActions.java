package commons;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



import base.BaseClass;

public class CommonActions {

	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(4));

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			element.click();
			Reporter.log("Element is Clicking :" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Element is unable to Click :" + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}

	}

	public void inputtext(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			element.sendKeys(text);
			Reporter.log(text + "Value Passed to :" + element + "<br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("element is not found " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}

	}
	public String geturl() {
	String currentUrl	= BaseClass.driver.getCurrentUrl();
	Reporter.log("Now this is the Current URL :" +currentUrl + "<br>");
	return currentUrl;
	}
	

	  public void charValue(WebElement element, char text) { try {
	  wait.until(ExpectedConditions.visibilityOf(element));
	  element.sendKeys(String.valueOf(text)); Reporter.log(text +
	  "Value Passed to the :" + element + "<br>"); } catch (Exception e) {
	  e.printStackTrace(); Reporter.log("Element is not Found " + element + "\n" +
	  e.getMessage() + "<br>"); Assert.fail(); }
	 

	}

	public void selectValue(WebElement element, String value) {

		try {
			sleep(0.5);
			Select select = new Select(element);
			select.selectByValue(value);
			Reporter.log(value + "Value has been selected from the element :" + element + "<br>");

		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Locator Doesn't match " + element + "\n" + e.getMessage() + "<br>");
			Assert.fail();
		}

	}

	public void sleep(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isSelected(WebElement element) {
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = element.isSelected();
			if (status) {
				Reporter.log("Element is Selected " + element + "<br>");
			} else {
				Reporter.log("Element is not Selected " + element + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Element not Found " + element + e.getMessage() + "<br>");
			Assert.fail();
		}
		return status;

	}
	
	public boolean isPresent(By by) {
		boolean status = false;
		try {
			List<WebElement> elements = BaseClass.driver.findElements(by);
			if(elements.size() > 0) {
				status = true;
				Reporter.log(by + " : Element is Present" + "<br>");
			}else {
				Reporter.log(by + " : Element is Not Present" + "<br>");
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log("Element is not found : " + by+"\n" + e.getMessage() + "<br>");
		}
		return status;
	}
	public void waitunitVisible (WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public boolean isDisplayed (WebElement element) {
		 
		return element.isDisplayed() ;
	}
}
