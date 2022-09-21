package com.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pageFactory.Utils.LocatorStrategy;



/**
 * @ScriptName : WrapperFunctions
 * @Description : Core wrapper function required for framework
 * @Author : Automation Tester
 */
public class WrapperFunctions extends LoadableComponent<WrapperFunctions> {
	private Pojo objPojo;
	private RobotClass objRobotClass;
	private Boolean flag = false;
	private SynchronizationUtilities objSynchronizationUtilities;

	public WrapperFunctions(Pojo pojo) {
		this.objPojo = pojo;
		objRobotClass = new RobotClass();
		objSynchronizationUtilities = new SynchronizationUtilities(objPojo);
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 */
	public boolean waitFor(String timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(Integer.parseInt(timeUnitSeconds), TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementDisplayed(By locator) {
		try {
			objSynchronizationUtilities.waitForElementVisibilityLocated(locator);
			objSynchronizationUtilities.setHighlight(objPojo.getDriver().findElement(locator));
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * 
	 */
	public boolean checkElementDisplayed(WebElement webElement) {
		try {

			objSynchronizationUtilities.waitForElementVisibility(webElement);
			objSynchronizationUtilities.setHighlight(webElement);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';",
					objSynchronizationUtilities.getElementFluent(webElement));
			return webElement.isDisplayed();

		} catch (NotFoundException exception) {

			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;

		} catch (Exception exception) {

			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementPresence(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.setHighlight(objPojo.getDriver().findElement(locator));
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean isElementDisplayed(By locator) {
		try {
			objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementVisibile(By locator) {
		try {
			objSynchronizationUtilities.waitForElementVisibilityLocated(locator);
			objSynchronizationUtilities.setHighlight(objPojo.getDriver().findElement(locator));
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	// public boolean checkElementInVisibile(By locator) {
	// try {
	// this.waitForElementInVisibilityLocated(locator);
	// return !objPojo.getDriver().findElement(locator).isDisplayed();
	// } catch (Exception exception) {
	// return false;
	// }
	// }
	// Updated by Rohini 17 Oct
	public boolean checkElementInVisibile(By locator) {
		try {
			objSynchronizationUtilities.waitForElementInVisibilityLocated(locator);
			return !objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean waitForElementDisplayed(By locator, int timeInMiliSeconds) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(objPojo.getDriver(), timeInMiliSeconds);
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean waitForElementEditable(By locator) {
		try {
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NotFound Exception");
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method wait for visibility of element
	 *              located
	 * @param :
	 *            locator - By identification of element
	 */
	public void waitForAngularHasFinishedProcessing() throws NotFoundException {
		objPojo.getWebDriverWait().until(AngularConditions.angularHasFinishedProcessing());
	}

	/**
	 * @Description : This is wrapper method to check the web element is enabled
	 *              on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementEnabled(By locator) {
		try {
			objSynchronizationUtilities.waitForElementVisibilityLocated(locator);
			return objPojo.getDriver().findElement(locator).isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is enabled
	 *              on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementSelected(By locator) {
		try {
			objSynchronizationUtilities.waitForElementVisibilityLocated(locator);
			return objPojo.getDriver().findElement(locator).isSelected();
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if click successful
	 * @author : Automation Tester
	 */
	public boolean click(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			objPojo.getDriver().manage().timeouts().setScriptTimeout(objPojo.getScriptTimeoutWait(), TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			objSynchronizationUtilities.setHighlight(objPojo.getDriver().findElement(locator));
			js.executeScript("return arguments[0].click()", objSynchronizationUtilities.getElementFluent(locator));
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			try {
				objSynchronizationUtilities.waitForElementPresence(locator);
				objSynchronizationUtilities.waitForElementToBeClickable(locator);
				objSynchronizationUtilities.getElementFluent(locator).click();
				waitAfterEachClick();
				return true;
			} catch (Exception exceptionJavascript) {
				objPojo.setCustomException("NoSuchElement Exception");
				return false;
			}
		}
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if click successful
	 * @author : Automation Tester
	 */
	public boolean clickWithPresenceAndFulent(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objPojo.getDriver().manage().timeouts().setScriptTimeout(objPojo.getScriptTimeoutWait(), TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("return arguments[0].click()", objSynchronizationUtilities.getElementFluent(locator));
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			try {
				objSynchronizationUtilities.waitForElementPresence(locator);
				objSynchronizationUtilities.getElementFluent(locator).click();
				waitAfterEachClick();
				return true;
			} catch (Exception exceptionJavascript) {
				objPojo.setCustomException("NoSuchElement Exception");
				return false;
			}
		}
	}

	/**
	 * @Method : doubleClick
	 * @Description : This is wrapper method used for doubleClick on element
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if double click successful
	 * @author : Automation Tester
	 */
	public boolean doubleClick(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			Actions actionBuilder = new Actions(objPojo.getDriver());
			actionBuilder.doubleClick(webElement).build().perform();
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : setText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean setText(By locator, String fieldValue) {
		try {
			// waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementVisibilityLocated(locator);
			WebElement webElement = objSynchronizationUtilities.getElementFluent(locator);
			clearText(webElement);
			objSynchronizationUtilities.setHighlight(webElement);
			// webElement.clear();
			webElement.sendKeys(fieldValue);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : setBootStrapDivText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean setBootStrapInputText(By locator, String fieldValue) {
		try {
			boolean selected = false;
			By locatorNotFpund = By.xpath("//div[@id='ddlTypeOfMeeting-list']//div[text()='No data found.']");
			WebElement input = objSynchronizationUtilities.getElementFluent(locator);
			this.click(locator);
			System.out.println("LocatorID ------> " + LocatorStrategy.getLocatorID());
			WebElement ul = input.findElement(By.xpath(
					".//following::div/ul[@role='listbox' and @id='" + LocatorStrategy.getLocatorID() + "'][1]"));
			this.waitFor(2);
			objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li"));
			List<WebElement> list = ul.findElements(By.xpath(".//li"));
			System.out.println("list------------>" + list.size());
			if (list.size() != 0) {

				for (WebElement expectedLink : list) {
					System.out.println("innerHTML---> " + expectedLink.getAttribute("innerHTML"));
					if (expectedLink.getAttribute("innerHTML").trim().equals(fieldValue)) {
						waitAfterEachClick();
						objSynchronizationUtilities.setHighlight(expectedLink);
						expectedLink.click();
						selected = true;
						break;
					}
				}
			} else {

				if (this.checkElementDisplayed(locatorNotFpund)) {
					this.click(locator);
					objSynchronizationUtilities.getElementFluent(locator);
					this.click(locator);
				}
				System.out.println("LocatorID ------> " + LocatorStrategy.getLocatorID());
				WebElement ul1 = input.findElement(By.xpath(
						".//following::div/ul[@role='listbox' and @id='" + LocatorStrategy.getLocatorID() + "'][1]"));
				this.waitFor(2);
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(ul1, By.xpath(".//li"));
				List<WebElement> list1 = ul1.findElements(By.xpath(".//li"));
				System.out.println("list------------>" + list1.size());
				for (WebElement expectedLink : list1) {
					System.out.println("innerHTML---> " + expectedLink.getAttribute("innerHTML"));
					if (expectedLink.getAttribute("innerHTML").trim().equals(fieldValue)) {
						waitAfterEachClick();
						objSynchronizationUtilities.setHighlight(expectedLink);
						expectedLink.click();
						selected = true;
						break;
					}
				}

			}
			return selected;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	// Not using selenium void org.openqa.selenium.WebElement.clear() command
	// having open issue
	// with chrome hence using customized clear command
	// Please update all clear commands after issue close (Ref -
	// https://github.com/SeleniumHQ/selenium/issues/4110)
	// Comment added by - Harshvardhan
	public void clearText(WebElement webElement) {
		/*
		 * Actions navigator = new Actions(objPojo.getDriver());
		 * navigator.click(webElement) .sendKeys(Keys.END) .keyDown(Keys.SHIFT)
		 * .sendKeys(Keys.HOME) .keyUp(Keys.SHIFT) .sendKeys(Keys.BACK_SPACE)
		 * .perform();
		 */
		//webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);;
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);

	}

	/**
	 * @Method : setBootStrapDivText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean setBootStrapTableText(By locator, String fieldValue) {
		try {
			boolean selected = false;
			WebElement input = objSynchronizationUtilities.getElementFluent(locator);
			clearText(input);
			// input.clear();
			input.sendKeys(fieldValue);
			WebElement ul = objSynchronizationUtilities.getElementFluent(locator)
					.findElement(By.xpath(".//parent::div/ul"));
			objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li/div/h4"));
			List<WebElement> list = ul.findElements(By.xpath(".//li"));
			System.out.println("list------------>" + list.size());
			for (WebElement expectedList : list) {
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(expectedList, By.xpath(".//div"));
				WebElement expectedDiv = expectedList.findElement(By.xpath(".//div"));
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(expectedDiv, By.xpath(".//h4"));
				WebElement hdr = expectedDiv.findElement(By.xpath(".//h4"));
				System.out.println("innerHTML---> " + hdr.getAttribute("innerHTML"));
				if (hdr.getAttribute("innerHTML").trim().equals(fieldValue)) {

					// added wait by pranay
					waitFor(2);

					expectedList.click();
					selected = true;
					break;
				}
			}
			return selected;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : sendKeyBoardKeys
	 * @Description : This is wrapper method is used to send keyboard keys
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            key - key name
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean sendKeyBoardKeys(By locator, String key) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (key.equalsIgnoreCase("enter"))
				webElement.sendKeys(Keys.ENTER);
			if (key.equalsIgnoreCase("shift"))
				webElement.sendKeys(Keys.SHIFT);
			if (key.equalsIgnoreCase("tab"))
				webElement.sendKeys(Keys.TAB);
			if (key.equalsIgnoreCase("keydown"))
				webElement.sendKeys(Keys.DOWN);
			if (key.equalsIgnoreCase("escape"))
				webElement.sendKeys(Keys.ESCAPE);

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : sendKeyBoardKeys
	 * @Description : This is wrapper method is used to send keyboard keys
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            key - key name
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	/*public boolean keysHoldAndClick(By locator, String key) {
		try {
			WebElement webElement = objPojo.getDriver().findElement(locator);
			Actions action = new Actions(objPojo.getDriver());
			if (key.equalsIgnoreCase("enter")) {
				action.keyDown(Keys.ENTER);
				action.click(webElement);
				action.keyDown(Keys.ENTER);
			}
			if (key.equalsIgnoreCase("shift")) {
				action.keyDown(Keys.SHIFT);
				action.click(webElement);
				action.keyDown(Keys.SHIFT);
			}
			if (key.equalsIgnoreCase("tab")) {
				action.keyDown(Keys.TAB);
				action.click(webElement);
				action.keyDown(Keys.TAB);
			}
			action.build().perform();
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}*/
	
	/**
     * @Method : sendKeyBoardKeys
     * @Description : This is wrapper method is used to send keyboard keys
     * @param :
     *            locator - By identification of element
     * @param :
     *            key - key name
     * @return : - true if text entered successfully
     * @author : Automation Tester
     */
    public boolean keysHoldAndClick(By locator, String key) {
        try {
            WebElement webElement = objPojo.getDriver().findElement(locator);
            Actions action = new Actions(objPojo.getDriver());
            if (key.equalsIgnoreCase("enter")) {
                action.keyDown(Keys.ENTER);
                action.click(webElement);
                action.keyDown(Keys.ENTER);
            }
            if (key.equalsIgnoreCase("shift")) {
                action.keyDown(Keys.SHIFT);
                action.click(webElement);
                action.keyDown(Keys.SHIFT);
            }
            if (key.equalsIgnoreCase("control")) {
                action.keyDown(Keys.CONTROL);
                action.click(webElement);
                action.keyDown(Keys.CONTROL);
            }
            if (key.equalsIgnoreCase("tab")) {
                action.keyDown(Keys.TAB);
                action.click(webElement);
                action.keyDown(Keys.TAB);
            }
            action.build().perform();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to extract the text value of an
	 *              webelement : This method is used for dom
	 *              ul/li/div/div/h4/span
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            textBy - String - "value" or "text"
	 * @return : text value of the passed locator
	 * @author : Automation Tester
	 * @created on : 04-Oct-2017
	 */
	public String getText(By locator, String textBy) {
		String strText = "";
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = this.objPojo.getDriver().findElement(locator);
			objSynchronizationUtilities.setHighlight(webElement);
			switch (textBy.toLowerCase()) {
			case "value":
				strText = webElement.getAttribute("value");
				break;

			case "text":
				strText = webElement.getText();
				break;
			default:
				strText = webElement.getText();
				break;
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
		}
		return strText;
	} // getText()

	/**
	 * @Method : selectCheckBox
	 * @Description : This is wrapper method select/deselect checkbox
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            status - select/deselect
	 * @author : Automation Tester
	 */
	public boolean selectCheckBox(By locator, boolean status) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : isCheckBoxSelected
	 * @Description : This is wrapper checkbox is selected or not
	 * @param :
	 *            locator - By identification of element
	 * @author : Automation Tester
	 */
	public boolean isCheckBoxSelected(By locator) {
		boolean state = false;
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox"))
				state = webElement.isSelected();

			return state;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : selectRadioButton
	 * @Description : This is wrapper method select/deselect radio button
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            status - select/deselect
	 * @author :Automation Tester
	 */
	public boolean selectRadioButton(By locator, boolean status) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("radio")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : isRadioButtonSelected
	 * @Description : This is wrapper RadioButton is selected or not
	 * @param :
	 *            locator - By identification of element
	 * @author :Automation Tester
	 */
	public boolean isRadioButtonSelected(By locator) {
		boolean state = false;
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("radio"))
				state = webElement.isSelected();

			return state;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : mouseHover
	 * @Description : This is wrapper method used for Mouse Hovering to the
	 *              element
	 * @param :
	 *            locator - By identification of element
	 * @author :Automation Tester
	 */
	public boolean mouseHover(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			Actions actionBuilder = new Actions(objPojo.getDriver());
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToWindowUsingTitle
	 * @Description : This is wrapper method used switch to window using the
	 *              given title
	 * @param :
	 *            locator - Window title
	 * @author : Automation Tester
	 */
	public boolean switchToWindowUsingTitle(String windowTitle) {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			System.out.println(mainWindowHandle);
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();
			System.out.println(openWindows);

			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					String window = objPojo.getDriver().switchTo().window(windows).getTitle();
					if (windowTitle.equals(window))
						return true;
					else
						objPojo.getDriver().switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : saveWindowHandle
	 * @Description : This is wrapper method used save current window handle
	 * @param :
	 *            locator - Window title
	 * @retun : windowHandle
	 * @author : Automation Tester
	 */
	public String saveWindowHandle() {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			return mainWindowHandle;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : switchToWindowUsingURL
	 * @Description : This is wrapper method used switch to window using the
	 *              given URL
	 * @param :
	 *            locator - Window title
	 * @author : Automation Tester
	 */
	public boolean switchToWindowUsingURL(String windowURL) {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					String currentWindowURL = objPojo.getDriver().switchTo().window(windows).getCurrentUrl();
					if (windowURL.equals(currentWindowURL))
						return true;
					else
						objPojo.getDriver().switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToWindowUsingURL
	 * @Description : This is wrapper method used switch to window using the
	 *              given URL
	 * @param :
	 *            locator - Window title
	 * @author : Automation Tester
	 */
	public boolean switchToWindowContainsURL(String windowURL) {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					String currentWindowURL = objPojo.getDriver().switchTo().window(windows).getCurrentUrl();
					if (currentWindowURL.contains(windowURL))
						return true;
					else
						objPojo.getDriver().switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToWindowUsingHandle
	 * @Description : This is wrapper method used switch to window using the
	 *              given Handle
	 * @param :
	 *            locator - Window title
	 * @author : Automation Tester
	 */
	public boolean switchToWindowUsingHandle(String windowHandle) {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					System.out.println(" windows : " + windows);
					objPojo.getDriver().switchTo().window(windows);
					if (windows.equals(windowHandle))
						return true;
					else
						objPojo.getDriver().switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : closeWindowUsingHandle
	 * @Description : This is wrapper method to close window using the given
	 *              Handle
	 * @param :
	 *            locator - Window title
	 * @author : Automation Tester
	 */
	public boolean closeWindowUsingHandleAndSwitchToAnotherWindow(String windowHandleToClose,
			String mainWindowHandleSwitch) {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					objPojo.getDriver().switchTo().window(windows);
					if (windows.equals(windowHandleToClose)) {
						objPojo.getDriver().close();
						// System.out.println("*************** Closed window");
						objPojo.getDriver().switchTo().window(mainWindowHandleSwitch);
						// System.out.println("*************** Switched
						// window");
						return true;
					} else
						objPojo.getDriver().switchTo().window(mainWindowHandle);
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToWindowUsingHandle
	 * @Description : This is wrapper method used switch to window using the
	 *              given Handle
	 * @param :
	 *            locator - Window title
	 * @author : Automation Tester
	 */
	public boolean closeCurrentWindowAndSwitchToNewWindowUsingHandle(String windowHandle) {
		try {
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) {
				objPojo.getDriver().switchTo().window(mainWindowHandle).close();
				for (String windows : openWindows) {
					objPojo.getDriver().switchTo().window(windows);
					if (windows.equals(windowHandle))
						return true;
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchTabToRight
	 * @Description : switch to tab to right (work only if new tab get opened to
	 *              right from main current window)
	 * @param :
	 * @author : Automation Tester
	 */
	public boolean switchTabToRight() {
		try {
			this.waitFor(objPojo.getObjConfig().getProperty("midwait"));
			String mainWindowHandle = objPojo.getDriver().getWindowHandle();
			Set<String> openWindows = objPojo.getDriver().getWindowHandles();

			if (!openWindows.isEmpty()) {
				for (String windows : openWindows) {
					if (!windows.equals(mainWindowHandle)) {
						objPojo.getDriver().switchTo().window(windows);
						return true;
					}
				}
			}
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToFrameUsingIframe_Element
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            locator - The most common one. You locate your iframe like
	 *            other elements, then pass it into the method
	 *            eg.driver.switchTo().frame(driver.findElement(By.xpath(
	 *            ".//iframe[@title='Fill Quote']")))
	 * @author : Automation Tester
	 */
	public boolean switchToFrameUsingIframeElement(By locator) {
		try {
			objPojo.getDriver().switchTo().defaultContent();
			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(locator));
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : switchToFrameUsingNameOrId
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            frameName - Name/Id of frame you want to switch
	 * @author : Automation Tester
	 */
	public boolean switchToFrameUsingNameOrId(String frameName) {
		try {
			objPojo.getDriver().switchTo().defaultContent();
			objPojo.getDriver().switchTo().frame(frameName);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToFrameUsingIndex
	 * @Description : This method will switch you to the Frame by Frame name
	 * @param :
	 *            index - Index on page
	 * @author : Automation Tester
	 */
	public boolean switchToFrameUsingIndex(int index) {
		try {
			objPojo.getDriver().switchTo().defaultContent();
			objPojo.getDriver().switchTo().frame(index);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToDefaultContent
	 * @Description : This method will switch you to the default Window
	 * @author : Automation Tester
	 */
	public void switchToDefaultContent() {
		objPojo.getDriver().switchTo().defaultContent();
	}

	/**
	 * @Method : selectDropDownOption
	 * @Description : This is wrapper method select drop down element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            option - drop down element (user may specify text/value/index)
	 * @param :
	 *            selectType - select dorp down element by Text/Value/Index
	 * @author : Automation Tester
	 */
	public boolean selectDropDownOption(By locator, String option, String... selectType) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			objSynchronizationUtilities.waitForElementVisibility(webElement);
			objSynchronizationUtilities.setHighlight(webElement);
			Select sltDropDown = new Select(webElement);
			if (selectType.length > 0 && !selectType[0].equals("")) {
				if (selectType[0].equalsIgnoreCase("Value"))
					sltDropDown.selectByValue(option);
				else if (selectType[0].equalsIgnoreCase("Text"))
					sltDropDown.selectByVisibleText(option);
				else if (selectType[0].equalsIgnoreCase("Index"))
					sltDropDown.selectByIndex(Integer.parseInt(option));

				// webElement.sendKeys(Keys.TAB);
				return true;
			} else {
				// Web elements from dropdown list
				List<WebElement> options = sltDropDown.getOptions();
				boolean blnOptionAvailable = false;
				int iIndex = 0;
				for (WebElement weOptions : options) {
					if (weOptions.getText().trim().equals(option)) {
						sltDropDown.selectByIndex(iIndex);
						blnOptionAvailable = true;
						break;
					} else
						iIndex++;
				}
				// webElement.sendKeys(Keys.TAB);
				return blnOptionAvailable;
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectCustomizedDropDownOption
	 * @Description : This is wrapper method select drop down element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            option - drop down element
	 * @author : Automation Tester
	 */
	public boolean selectCustomizedDropDownOption(By locator, String option) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement mainContainer = objSynchronizationUtilities.getElementFluent(locator);
			mainContainer.click();
			objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(mainContainer, By.xpath(".//ul"));
			WebElement ul = objSynchronizationUtilities.getNestedElementFluent(mainContainer, By.xpath(".//ul"));
			// WebElement ul = mainContainer.findElement(By.xpath(".//ul"));
			objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(ul,
					By.xpath(".//li/a[contains(text(), '" + option + "')]"));
			WebElement li = objSynchronizationUtilities.getNestedElementFluent(ul,
					By.xpath(".//li/a[contains(text(), '" + option + "')]"));
			// WebElement li =
			// mainContainer.findElement(By.xpath(".//li/a[contains(text(),'" +
			// option +"')]"));
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", li);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("arguments[0].click()", li);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifyDropDownOptionValues
	 * @Description : This is wrapper method select drop down element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            option - if want to verify more then one option pass values
	 *            separated by ';'
	 * @author : Automation Tester
	 */
	public boolean verifyDropDownOptionValues(By locator, String option) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			Select sltDropDown = new Select(webElement);

			// Web elements from dropdown list
			List<WebElement> options = sltDropDown.getOptions();
			boolean blnOptionAvailable = false;
			ArrayList<String> optionsList;

			if (option.contains(";"))
				optionsList = new ArrayList<String>(Arrays.asList(option.trim().split(";")));
			else {
				optionsList = new ArrayList<String>();
				optionsList.add(option);
			}

			for (WebElement weOptions : options) {
				String optionValue = weOptions.getText().trim();
				if (optionsList.contains(optionValue)) {
					blnOptionAvailable = true;
					optionsList.remove(optionValue);
					if (optionsList.isEmpty())
						break;
				}
			}
			return blnOptionAvailable;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getSelectedValueFromDropDown
	 * @Description : This is wrapper method select drop down element
	 * @param :
	 *            locator - By identification of element
	 * @author : Automation Tester
	 */
	public String getSelectedValueFromDropDown(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			Select selectDorpDown = new Select(objPojo.getDriver().findElement(locator));
			String selectedDorpDownValue = selectDorpDown.getFirstSelectedOption().getText();
			return selectedDorpDownValue;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : selectValueFromUnorderedList
	 * @Description : This is wrapper method select drop down element from
	 *              UnorderedList eg.
	 *              <ul>
	 *              <li></li>
	 *              <li></li>
	 *              </ul>
	 * @param :
	 *            locator - By identification of main list
	 * @param :
	 *            value - Value to select
	 * @author : Automation Tester
	 */
	public boolean selectValueFromUnorderedList(By locator, String value) {
		try {
			boolean returnValue = false;
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement unorderedList = objSynchronizationUtilities.getElementFluent(locator);
			unorderedList.click();
			this.waitFor(3); // Wait Added By Yogesh
			List<WebElement> options = unorderedList.findElements(By.xpath("./li"));
			for (WebElement option : options) {
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(unorderedList,
						By.xpath(".//li/a/span/span"));
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(option, By.xpath(".//a/span/span"));
				WebElement span = option.findElement(By.xpath(".//a/span/span"));
				if (span.getAttribute("innerHTML").equals(value)) {
					((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							span);
					span.click();
					returnValue = true;
					break;
				}
			}
			return returnValue;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getAttribute
	 * @Description : This function return locator attribute
	 * @param :
	 *            locator - By identification of element
	 * @author : Automation Tester
	 */
	public String getAttribute(By locator, String sElementAttribute) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			return webElement.getAttribute(sElementAttribute);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : selectCheckBoxForSpecificColumn
	 * @Description : This is wrapper method to select chechbox from table with
	 *              respect to particular column content
	 * @param :
	 *            locator - By identification of element (table with all rows)
	 * @param :
	 *            columnContent - String column content
	 * @param :
	 *            Status true - to check the checkbox false - to uncheck the
	 *            checkbox
	 * @columnNumberForRadio : integer column number for radio button
	 * @author :Automation Tester
	 */
	public boolean selectCheckBoxForSpecificColumn(By locator, String columnContent, int columnNumberForCheckBox,
			boolean Status) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(locator);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//tbody/tr"));
			List<WebElement> weResultRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weResultRows) {
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for (WebElement weColumn : weColumns) {
					if (weColumn.getText().trim().equals(columnContent)) {
						By tempLocator = By.xpath(".//td['" + columnNumberForCheckBox + "']/input[@type='checkbox']");
						WebElement weCheckbox = weRow.findElement(tempLocator);
						if ((weCheckbox.isSelected() && !Status) || (!weCheckbox.isSelected() && Status)) {
							weCheckbox.click();
							return true;
						}
					}
				}
			}
			return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectLinkAgainstForSpecificColumnOfTable
	 * @Description : This is wrapper method to select link from table with
	 *              respect to particular column content
	 * @param :
	 *            locator - By identification of element (table with all rows)
	 * @param :
	 *            columnContent - String column content
	 * @columnNumberForRadio : integer column number for radio button
	 * @author :Automation Tester
	 */
	public boolean clickLinkAgainstSpecificColumnOfTable(By locator, String columnContent, int columnNumberForLink) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(locator);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//tbody/tr"));
			List<WebElement> weResultRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weResultRows) {
				List<WebElement> weColumns = weRow.findElements(By.xpath(".//td"));
				for (WebElement weColumn : weColumns) {
					if (weColumn.getText().trim().equals(columnContent)) {
						By tempLocator = By.xpath(".//td['" + columnNumberForLink + "']/a");
						WebElement weCheckbox = weRow.findElement(tempLocator);
						weCheckbox.click();
						return true;
					}
				}
			}
			return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifyTableContent
	 * @Description : it will check given data in whole table
	 * @param :
	 *            locator - By identification of element (table with all rows)
	 * @param :
	 *            columnHeader - String column header
	 * @param :
	 *            ContentToVerify - String Content to be verify
	 * @author : Automation Tester
	 */
	public boolean verifyTableContent(By locator, String columnHeader, String ContentToVerify) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement weResultTable = objPojo.getDriver().findElement(locator);

			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//thead/tr/th"));
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders) {
				String strHeader = weColumnHeader.getText().trim();
				// System.out.println("strHeader------->" + strHeader);
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeader) + "]"));
				// System.out.println("************************---------->" +
				// weExceptedClm.getText());
				if (weExceptedClm.getText().trim().equals(ContentToVerify)) {
					blnverify = true;
					return blnverify;
				}
			}
			return blnverify;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : clickTableColumnContent
	 * @Description : it will check given data in whole table
	 * @param :
	 *            locator - By identification of element (table with all rows)
	 * @param :
	 *            columnHeader - String column header
	 * @param :
	 *            ContentToVerify - String Content to be verify
	 * @author : Automation Tester
	 */
	public boolean clickTableColumnContent(By locator, String columnHeader, String ContentToVerify) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement weResultTable = objPojo.getDriver().findElement(locator);

			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//thead/tr/th"));
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders) {
				String strHeader = weColumnHeader.getText().trim();
				// System.out.println("strHeader------->" + strHeader);
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeader) + "]"));
				System.out.println("************************---------->" + weExceptedClm.getText());
				if (weExceptedClm.getText().trim().equals(ContentToVerify)) {
					weExceptedClm.click();
					blnverify = true;
					return blnverify;
				}
			}
			return blnverify;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @method : getAttributeValue
	 * @param :
	 *            locator : By identification of element
	 * @param :
	 *            AttributeName : Name of attribute Whose value we want
	 * @author : Automation Tester
	 */
	public String getAttributeValue(By locator, String attributeName) {
		try {
			WebElement webElement = objPojo.getDriver().findElement(locator);
			return webElement.getAttribute(attributeName);
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			return null;
		}
	}

	/**
	 * @method : getTagName
	 * @param :
	 *            locator
	 * @return : TageName for given locator
	 * @author : Automation Tester
	 * 
	 */
	public String getTagName(By locator) {
		try {
			WebElement webElement = objPojo.getDriver().findElement(locator);
			return webElement.getTagName();
		} catch (Exception exception) {
			return null;
		}
	}

	public boolean clickUsingJavaScript(By locator) {
		try {
			WebElement element = objPojo.getDriver().findElement(locator);
			objPojo.getDriver().manage().timeouts().setScriptTimeout(objPojo.getScriptTimeoutWait(), TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("arguments[0].click()", element);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public void pageRefresh() {
		objPojo.getDriver().navigate().refresh();
		objPojo.getObjUtilities().logReporter("Page is Getting refreshed....", true);
	}

	public void compareCurrentWindowURL(String expectedURL) {
		this.waitFor(objPojo.getObjConfig().getProperty("maxwait"));
		objPojo.getObjUtilities().logReporter("Verify current browser URL", expectedURL,
				objPojo.getDriver().getCurrentUrl(),
				objPojo.getDriver().getCurrentUrl().trim().equalsIgnoreCase(expectedURL));
	}

	/**
	 * @Method : getElementWidth
	 * @Description : This is wrapper method to get web element width
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if click successful
	 * @author : Automation Tester
	 */
	public int getElementWidth(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			return webElement.getSize().getWidth();
		} catch (Exception exception) {
			exception.printStackTrace();
			return 0;
		}
	}

	/**
	 * @Method : getElementHeight
	 * @Description : This is wrapper method to get web element Height
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if click successful
	 * @author : Automation Tester
	 */
	public int getElementHeight(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			return webElement.getSize().getHeight();
		} catch (Exception exception) {
			exception.printStackTrace();
			return 0;
		}
	}

	public List<WebElement> getWebElementList(By locator) {
		return objPojo.getDriver().findElements(locator);
	}

	/**
	 * Scroll element to view using javascript
	 */
	public boolean scrollToView(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean datePicker(By locator, String date) {
		try {
			String[] dateArray = date.split("/");

			// in eCW App- month index start with 0 , Hence we have to do "n-1"
			// Also month value does not have prefix "0" hence we have to
			// replace "0" with ""
			String month = dateArray[0];
			int tempIntMonth = 0;

			try {
				tempIntMonth = Integer.parseInt(month);
				System.out.println("current month is " + tempIntMonth);
				if (tempIntMonth >= 1) {
					if (((dateArray[0].startsWith("0")))) {
						tempIntMonth = tempIntMonth - 1;
						System.out.println("Twmp month is " + tempIntMonth);
						if (tempIntMonth == 0) {
							dateArray[0] = tempIntMonth + "";
						} else {
							dateArray[0] = tempIntMonth + "";
							dateArray[0] = dateArray[0].replaceAll("0", "");
							System.out.println("New month is " + dateArray[0].toString());
						}
					} else {
						tempIntMonth = tempIntMonth - 1;
						dateArray[0] = tempIntMonth + "";
					}

				} else {

					dateArray[0] = tempIntMonth + "";
					System.out.println("I am in else part " + dateArray[0]);
				}

			} catch (Exception e) {

			}

			By divCalendarPopup = By.xpath("//div[@id='ui-datepicker-div']");
			By lnkDate = By
					.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text(),'"
							+ (dateArray[1].startsWith("0") ? dateArray[1].substring(dateArray[1].indexOf("0") + 1)
									: dateArray[1])
							+ "')]");
			By drpMonth = By.xpath(
					"//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']");
			By drpYear = By.xpath(
					"//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']");

			objPojo.getObjUtilities().logReporter("Click on calendar icon", this.click(locator));
			objPojo.getObjUtilities().logReporter("Verify calendar popup displayed",
					this.checkElementDisplayed(divCalendarPopup));
			objPojo.getObjUtilities().logReporter("Select year from calendar popup", dateArray[2],
					this.selectDropDownOption(drpYear, dateArray[2], "Value"));
			objPojo.getObjUtilities().logReporter("Select month from calendar popup", dateArray[0],
					this.selectDropDownOption(drpMonth, (dateArray[0].toString()), "Value"));
			objPojo.getObjUtilities().logReporter("Select date from calendar popup", dateArray[1], this.click(lnkDate));

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public boolean datePicker(By locator, String strYear, String strMonth, String strDate) {

		try {
			By divCalendarPopup = By.xpath("//table[@id='Calendar1'][@title='Calendar']");

			By lnkMonth = By.xpath("//form[@id='Form1']/table/tbody/tr/td/font/b/a[text()='" + strMonth + "']");
			By drpYear = By.xpath("//select[@id='cboYears']");

			By lnkDate = By.xpath("//table[@id='Calendar1'][@title='Calendar']/tbody/tr/td/following::a[text()='"
					+ strDate + "'][1]");

			objPojo.getObjUtilities().logReporter("Click on calendar icon", this.click(locator));
			this.switchToWindowUsingTitle("Calendar");
			objPojo.getObjUtilities().logReporter("Verify calendar popup displayed",
					this.checkElementDisplayed(divCalendarPopup));

			objPojo.getObjUtilities().logReporter("Select year from calendar popup", strYear,
					this.selectDropDownOption(drpYear, strYear, "Text"));

			objPojo.getObjUtilities().logReporter("Select month from calendar popup", strMonth, this.click(lnkMonth));

			objPojo.getObjUtilities().logReporter("Select date from calendar popup", strDate, this.click(lnkDate));

			return true;
		}

		catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

	/**
	 * @Method : setBootStrapTableTextforH4span
	 * @Description : This is wrapper method to select drop down value from the
	 *              generated list : This method is used for dom
	 *              ul/li/div/div/h4/span
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text is selected
	 * @author : Automation Tester ( Rohini Kulkarni - Ivavsys)
	 */

	public boolean setBootStrapTableTextforH4span(By locator, String fieldValue) {
		try {
			boolean selected = false;
			WebElement input = objSynchronizationUtilities.getElementFluent(locator);
			clearText(input);

			input.sendKeys(new CharSequence[] { fieldValue });
			this.waitFor(5); // CHANGES Added By Yogesh 9 Dec 17
			WebElement ul = objSynchronizationUtilities.getElementFluent(locator)
					.findElement(By.xpath(".//parent::div/ul"));
			objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li//h4/span"));
			List<WebElement> list = ul.findElements(By.xpath(".//li"));
			System.out.println("list------------>" + list.size());
			for (WebElement expectedList : list) {

				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(expectedList, By.xpath(".//h4"));
				WebElement hdr = expectedList.findElement(By.xpath(".//h4"));

				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(hdr, By.xpath(".//span"));
				WebElement span = hdr.findElement(By.xpath(".//span"));

				System.out.println("innerHTML---> " + span.getAttribute("innerHTML"));
				if (span.getAttribute("innerHTML").trim().contains(fieldValue)) {
					((JavascriptExecutor) this.objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(false);",
							new Object[] { span });
					span.click();
					selected = true;
					break;
				}
			}
			return selected;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : rightClick
	 * @Description : This is wrapper method to simulate mouse right click
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if right click action is successful
	 * @author : Automation Tester
	 * @created on : 05-Oct-2017
	 */

	public boolean rightClick(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			WebElement webElement = this.objPojo.getDriver().findElement(locator);
			Actions actionBuilder = new Actions(this.objPojo.getDriver());
			actionBuilder.contextClick(webElement).build().perform();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : searchTableRow
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement searchTableRow(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			WebElement weExceptedClm = null;
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					return weExceptedClm;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : searchTableRow
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement searchTableRow(By weResultTableForTbody, int columnIndexForSearch, String textToSearch) {
		try {
			WebElement weExceptedClm = null;
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				weExceptedClm = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					return weExceptedClm;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;

	}

	/**
	 * @Method : selectTableForSpecficColumn
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            ColoumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableForSpecficColumn(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int ColoumnIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedSpecificColoum = weRow.findElement(By.xpath(".//td[" + ColoumnIndex + "]"));
					return weExceptedSpecificColoum;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableForSpecficColumn
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            ColoumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableForSpecficColumn(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch, int ColoumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedSpecificColoum = weRow.findElement(By.xpath(".//td[" + ColoumnIndex + "]"));
					return weExceptedSpecificColoum;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowCheckbox
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            checkboxColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowCheckbox(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int checkboxColIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));

			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedCheckBox = weRow
							.findElement(By.xpath(".//td[" + checkboxColIndex + "]//input[@type='checkbox']"));
					return weExceptedCheckBox;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowCheckbox
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            checkboxColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowCheckbox(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int checkboxColIndex) {

		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedCheckBox = weRow
							.findElement(By.xpath(".//td[" + checkboxColIndex + "]//input[@type='checkbox']"));
					return weExceptedCheckBox;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowTextBox
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows) ALSO Support if input has @dateformat='mm/dd/yy'
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            textBoxColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowTextBox(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int textBoxColIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedTextBox = weRow.findElement(
							By.xpath(".//td[" + textBoxColIndex + "]//input[@type='text' or @dateformat='mm/dd/yy']"));
					return weExceptedTextBox;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowTextBox
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * 
	 *            ALSO Support if input has @dateformat='mm/dd/yy'
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            textBoxColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowTextBox(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int textBoxColIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				System.out.println("weColumns " + weColumns.getAttribute("value"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedTextBox = weRow.findElement(
							By.xpath(".//td[" + textBoxColIndex + "]//input[@type='text' or @dateformat='mm/dd/yy']"));
					return weExceptedTextBox;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowRadioButton
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            radiobuttonColIndex - Integer Content to be verifyed from
	 *            excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowRadioButton(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int radiobuttonColIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedRadioButton = weRow
							.findElement(By.xpath(".//td[" + radiobuttonColIndex + "]//input[@type='radio']"));
					return weExceptedRadioButton;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowRadioButton
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            radiobuttonColIndex - Integer Content to be verifyed from
	 *            excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowRadioButton(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int radiobuttonColIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedRadioButton = weRow
							.findElement(By.xpath(".//td[" + radiobuttonColIndex + "]//input[@type='radio']"));
					return weExceptedRadioButton;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowDropDown
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            dropdownColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowDropDown(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int dropdownColIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedDropDownBox = weRow
							.findElement(By.xpath(".//td[" + dropdownColIndex + "]//select"));
					return weExceptedDropDownBox;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowDropDown
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            dropdownColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowDropDown(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int dropdownColIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedDropDownBox = weRow
							.findElement(By.xpath(".//td[" + dropdownColIndex + "]//select"));
					return weExceptedDropDownBox;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : deleteTableRow
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            deleteColumnIndex - Integer Content to be verifyed from excel
	 * @param :
	 *            deleteIndex - Integer Content to be verifyed from excel verify
	 *            your deleteindext('I' Tag) number in that webTable
	 * @author : Automation Tester
	 */
	public WebElement deleteTableRow(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int deleteColumnIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExcepteDeleteElement = weRow.findElement(By.xpath(".//td[" + deleteColumnIndex
							+ "]//*[contains(@class,'trash') or contains(@class,'delete')]"));
					return weExcepteDeleteElement;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : deleteTableRow
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            deleteColumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement deleteTableRow(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int deleteColumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExcepteDeleteElement = weRow.findElement(By.xpath(".//td[" + deleteColumnIndex
							+ "]//*[contains(@class,'trash') or contains(@class,'delete') or contains(@class,'cancel')]"));
					return weExcepteDeleteElement;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : get Table Column Header
	 * @Description : it will give table header size in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @author : Framework Developer
	 */
	public Hashtable<String, String> getTableColumnHeader(By weResultTableForThead) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForThead);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForThead,
					By.xpath(".//thead/tr/th"));
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders) {
				String strHeader = weColumnHeader.getText().trim();
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}
			return dataColumnHeader;

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return dataColumnHeader;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return dataColumnHeader;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return dataColumnHeader;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return dataColumnHeader;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return dataColumnHeader;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return dataColumnHeader;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return dataColumnHeader;
		}

	}

	/**
	 * @Method : selectTableRowClickPlus
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            plusColumnIndex - Integer Content to be verifyed from excel
	 * @param :
	 *            plusIndex - Integer Content to be verifyed from excel verify
	 *            your plusIndex('I' Tag) number in that webTable
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowClickPlus(By weResultTableForThead, By weResultTableForTbody,
			String columnHeaderNameForSearch, String textToSearch, int plusColumnIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExcepteDeleteElement = weRow
							.findElement(By.xpath(".//td[" + plusColumnIndex + "]//*[contains(@class,'plus')]"));
					return weExcepteDeleteElement;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectTableRowClickPlus
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            plusColumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowClickPlus(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int plusColumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExcepteDeleteElement = weRow
							.findElement(By.xpath(".//td[" + plusColumnIndex + "]//*[contains(@class,'plus')]"));
					return weExcepteDeleteElement;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : selectLastRow
	 * @Description : it will give last row of the table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @author : Framework Developer
	 */
	public WebElement selectLastRow(By weResultTableForTbody) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			int tableRowSize = weRows.size();
			WebElement weExceptedRow = weResultTable.findElement(By.xpath("//tbody/tr[" + tableRowSize + "]"));
			return weExceptedRow;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * @Method : tableRowSize
	 * @Description : it will give table rows size
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @author : Framework Developer
	 */
	public int getTableRowSize(By weResultTableForTbody) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			int tableRowSize = weRows.size();
			return tableRowSize;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return 0;
		}
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param :
	 *            WebElement -By identification of Locator
	 * @return : - true if click successful
	 * @author : Framework Developer
	 */
	public boolean click(WebElement element) {
		try {
			// waitFor(2);
			objSynchronizationUtilities.getElementFluent(element);
			objSynchronizationUtilities.waitForElementVisibility(element);
			element.click();
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to extract the text value of an
	 *              webelement
	 * @param :
	 *            webElement - By identification of Locator
	 * @param :
	 *            textBy - String - "value" or "text"
	 * @return : text value of the passed locator
	 * @author : Automation Tester
	 * @created on :
	 */
	public String getText(WebElement webElement, String textBy) {
		String strText = "";
		try {
			objSynchronizationUtilities.setHighlight(webElement);
			switch (textBy.toLowerCase()) {
			case "value":
				strText = webElement.getAttribute("value");
				break;

			case "text":
				strText = webElement.getText();
				break;
			default:
				strText = webElement.getText();
				break;
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return strText;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return strText;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return strText;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return strText;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return strText;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return strText;
		}
		return strText;
	}

	/**
	 * @Method : uploadFileUsingRobotActions
	 * @Description : This is wrapper method to upload file
	 * @param :
	 *            filePath - path of file to upload
	 * @return : - true if upload is successful
	 * @author : Automation Tester
	 * @created on : 06-Oct-2017
	 */

	// public boolean uploadFile(String fileNameOnly, String thinkTime) {
	//
	//
	// try {
	//
	// String filePath = System.getProperty("user.dir") +
	// "\\src\\test\\resources\\testData\\AllImageDoc\\" + fileNameOnly;
	// System.out.println("Upload file Path: "+System.getProperty("user.dir") +
	// "\\src\\test\\resources\\testData\\AllImageDoc\\" + fileNameOnly);
	// objRobotClass.uploadFileUsingRobotActions(filePath);
	// waitFor(thinkTime);
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// }

	/**
	 * @Method : uploadFileUsingAutoIT
	 * @Description : This is wrapper method to upload file using AutoIT
	 * @param :
	 *            filePath - path of file to upload
	 * @return : - true if upload is successful
	 * @author : Framework Developer
	 * @created on : 11-Nov-2017
	 */
	// USING AUTO-IT
	public boolean uploadFile(String fileNameOnly, String thinkTime) {
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\AllImageDoc\\"
					+ fileNameOnly;
			System.out.println("Upload file Path: " + System.getProperty("user.dir")
					+ "\\src\\test\\resources\\testData\\AllImageDoc\\" + fileNameOnly);
			this.waitFor(5);
			String sys_path = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\";

			Runtime.getRuntime().exec(sys_path + "Fileupload.exe" + " " + filePath);
			waitFor(thinkTime);

			return true;
		} catch (Exception e) {
			objPojo.setCustomException("FileInputOutput Exception");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : clearText
	 * @Description : This is wrapper method to clear text
	 * @param :
	 *            locator
	 * @return : - true if upload is successful
	 * @author : Framework Developer
	 * @created on : 17-Oct-2017
	 */
	public boolean clearText(By locator) {

		WebElement input;
		try {
			input = objSynchronizationUtilities.getElementFluent(locator);
			clearText(input);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	// public void fullPageScreenShot(String fileName){
	// System.out.println("In full page ss");
	// String fileWithPath = System.getProperty("user.dir") + "\\target\\" +
	// fileName + ".png";
	// System.out.println("path "+fileWithPath);
	// try {
	// Screenshot screenshot = new
	// AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(objPojo.getDriver());
	// ImageIO.write(screenshot.getImage(),"PNG",new File(fileWithPath));
	// System.out.println("Screen Shot captured");
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// }

	// Added by Framework Developer
	public void waitAfterEachClick() {
		waitFor(objPojo.getAfterClickwait());
		System.out.println("After Click wait is " + objPojo.getAfterClickwait());
	}

	// Added by Framework Developer
	// Accept Alert Handle Pop up
	public void alertBoxAccept() {
		Alert alert = objPojo.getDriver().switchTo().alert();
		alert.accept();
		// log.info("alert accept successfully.");
	}

	/**
	 * 
	 * Purpose- Method For waiting for an alert and acceptng it
	 *
	 * @param waitTime
	 * @return returns true if alert is displayed and accepted, else returns
	 *         false
	 */
	public boolean isAlertWaitAndAccepted(int waitTime) {
		boolean blnAlert = false;
		if (isAlertPresent(waitTime)) {
			try {
				Alert alert = objPojo.getDriver().switchTo().alert();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException exception) {
					objPojo.getObjUtilities().logReporter(
							"Exception occured while waiting for an alert using thread sleep method.", true);
				}
				alert.accept();
				objPojo.getObjUtilities().logReporter("Alert is displayed and accepted successfully.", true);
				blnAlert = true;
			} catch (NoAlertPresentException e) {
				objPojo.getObjUtilities().logReporter("Alert not present", true);
				blnAlert = false;
			}
		} else {
			objPojo.getObjUtilities()
					.logReporter("Alert not present in time - " + waitTime + " - NoAlertPresentException", true);
			blnAlert = false;
		}
		return blnAlert;
	}

	/**
	 * Method: for verifying if accept exists and accepting the alert
	 * 
	 * @throws Exception
	 */
	public boolean acceptAlert() {
		boolean blnFlag = false;
		try {
			Alert alert = objPojo.getDriver().switchTo().alert();
			String sText = alert.getText();
			alert.accept();
			objPojo.getObjUtilities().logReporter("Accepted the alert:" + sText, true);
			return blnFlag = true;
		} catch (NoAlertPresentException exception) {
			objPojo.getObjUtilities()
					.logReporter("Alert is not displayed to accept." + exception + "NoAlertPresentException", true);
		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter("Alert is not displayed to accept." + " - " + exception, true);
			blnFlag = false;
		}
		return blnFlag;
	}

	/**
	 * Method: for verifying if accept exists and accepting the alert
	 * 
	 * @return - String (returns text present on the Alert)
	 * @throws Exception
	 */
	public String getAlertMessage() {
		String strText = null;
		try {
			Alert alert = objPojo.getDriver().switchTo().alert();
			strText = alert.getText();
			objPojo.getObjUtilities().logReporter("Text present in the alert:" + strText, true);
		} catch (NoAlertPresentException exception) {
			objPojo.getObjUtilities().logReporter("Alert is not displayed to accept." + " - " + exception, true);
			return strText = null;
		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter("Unable to read alert message." + " - " + exception, true);
			return strText = null;
		}
		return strText;
	}

	/**
	 * Method: for verifying if accept exists and rejecting/dismissing the alert
	 * 
	 * @return - boolean (returns True when dismiss action is performed else
	 *         returns false)
	 * @throws Exception
	 */
	public boolean dismissAlert() {
		try {
			Alert alert = objPojo.getDriver().switchTo().alert();
			String sText = alert.getText();
			alert.dismiss();
			objPojo.getObjUtilities().logReporter("Dismissed the alert:" + sText, true);
			return true;
		} catch (NoAlertPresentException exception) {
			objPojo.getObjUtilities().logReporter("Alert is not displayed to dismiss.", true);
			return false;
		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter("Unable to dismiss the alert." + " - " + exception, true);
			return false;
		}

	}

	// Added by Framework Developer
	// Reject Alert
	public void alertBoxReject() {
		Alert alert = objPojo.getDriver().switchTo().alert();
		alert.dismiss();
		// log.info("alert dismiss successfully.");
	}

	// by Framework Developer
	// Description : This method should be used for Drag & Drop / Re Order
	// You need to pass source locator and target locator
	public boolean dragAndDrop(String sourceElementName, By sourceLocator, By targetLocator) {
		try {
			WebElement SourcewebElement = objPojo.getDriver().findElement(sourceLocator);
			WebElement TargetwebElement = objPojo.getDriver().findElement(targetLocator);

			Actions builder = new Actions(objPojo.getDriver());
			builder.dragAndDrop(SourcewebElement, TargetwebElement).build().perform();
			waitAfterEachClick();
			System.out.println("drag and drop file successfully.");
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToNestedFrameUsingIframeElement
	 * @Description : This method will switch you to the nested frame
	 * @param :
	 *            frmLocator1 - First Frame : frmLocator2 - Second Frame Date :
	 *            2nd Nov 2017
	 * @author : Framework Developer
	 *
	 */
	public boolean switchToNestedFrameUsingIframeElement(By frmLocator1, By frmLocator2) {
		try {

			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(frmLocator1));
			objSynchronizationUtilities.waitForElementPresence(frmLocator2);
			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(frmLocator2));

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : saveWindowFileUsingRobotActions
	 * @Description : This is wrapper method to save Window File
	 * @return : - true if Save is successful
	 * @author : Automation Tester updated by : Rohini Kulkarni - Ivavsys
	 * @created on : 02-Nov-2017
	 */
	public boolean saveWindowFileUsingRobotActions() {
		try {
			objRobotClass.saveWindowFileUsingRobotActions();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}

	}

	/**
	 * Scroll element to view using javascript This script is used for scrolling
	 * down. By Framework Developer
	 */
	public boolean scrollToViewDown(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(false);", webElement);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method :
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            element - WebElement identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean setText(WebElement element, String fieldValue) {
		try {
			objSynchronizationUtilities.waitForElementVisibility(element);
			clearText(element);
			element.sendKeys(fieldValue);
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : switchToNestedFrameUsingIframeElement
	 * @Description : This method will switch you to the nested frame
	 * @param :
	 *            frmLocator1 - First Frame : frmLocator2 - Second Frame :
	 *            frmLocator3 - Third Frame Date : 20 Nov 2017
	 * @author : Framework Developer
	 *
	 */
	public boolean switchToNestedFrameUsingIframeElement(By frmLocator1, By frmLocator2, By frmLocator3) {
		try {

			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(frmLocator1));
			objSynchronizationUtilities.waitForElementPresence(frmLocator2);
			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(frmLocator2));
			objSynchronizationUtilities.waitForElementPresence(frmLocator3);
			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(frmLocator3));

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : clickOnCanvasCo-Ordinates
	 * @Description : Click on Body Canvas using (x,y) Co-ordinates
	 * @author : Framework Developer
	 * @created on : 09-Nov-2017
	 */
	public boolean clickOnCanvas(By Locator, int x, int y) {
		try {
			WebElement element = objPojo.getDriver().findElement(Locator);
			Actions builder = new Actions(objPojo.getDriver());
			Action drawAction = builder.moveToElement(element, 0, 0) // start
																		// points
																		// x
																		// axis
																		// and y
																		// axis.
					.clickAndHold(element).moveByOffset(x, y).clickAndHold(element).release(element).build();
			drawAction.perform();

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	// by Framework Developer
	// Description : This method should be used for Drag & Drop / Re Order
	// You need to pass WebElement for source and target
	public boolean dragAndDrop(String sourceElementName, WebElement source, WebElement target) {
		try {

			Actions builder = new Actions(objPojo.getDriver());
			builder.dragAndDrop(source, target).build().perform();
			waitAfterEachClick();
			System.out.println("drag and drop file successfully.");
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectDropDownOption
	 * @Description : This is wrapper method select drop down element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            option - drop down element (user may specify text/value/index)
	 * @param :
	 *            selectType - select dorp down element by Text/Value/Index
	 * @author : Automation Tester
	 */
	public boolean selectDropDownOption(WebElement webElement, String option, String... selectType) {
		try {
			System.out.println("Inside new selectDropDownOption *********************************");
			// waitForElementPresence(locator);
			// WebElement webElement = objPojo.getDriver().findElement(locator);
			// objSynchronizationUtilities.waitForElementVisibility(webElement);
			Select sltDropDown = new Select(webElement);
			if (selectType.length > 0 && !selectType[0].equals("")) {
				if (selectType[0].equalsIgnoreCase("Value"))
					sltDropDown.selectByValue(option);
				else if (selectType[0].equalsIgnoreCase("Text"))
					sltDropDown.selectByVisibleText(option);
				else if (selectType[0].equalsIgnoreCase("Index"))
					sltDropDown.selectByIndex(Integer.parseInt(option));
				// webElement.sendKeys(Keys.TAB);
				return true;
			} else {
				// Web elements from dropdown list
				List<WebElement> options = sltDropDown.getOptions();
				boolean blnOptionAvailable = false;
				int iIndex = 0;
				for (WebElement weOptions : options) {
					if (weOptions.getText().trim().equals(option)) {
						sltDropDown.selectByIndex(iIndex);
						blnOptionAvailable = true;
						break;
					} else
						iIndex++;
				}
				// webElement.sendKeys(Keys.TAB);
				return blnOptionAvailable;
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * Scroll element to view using javascript This script is used for scrolling
	 * down. By Framework Developer updated by 23rd Nov
	 */
	public boolean scrollToViewDown(WebElement webElement) {
		try {
			// waitForElementPresence(locator);
			// WebElement webElement = objPojo.getDriver().findElement(locator);
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(false);", webElement);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : uploadImageUsingInput
	 * @Description : Upload Image using Input Element (Ex:
	 *              fileNameOnly=emg1.jpg)
	 * @author : Framework Developer
	 * @created on : 13-Nov-2017 Updated by Pranay - Note: use below method from
	 *          log reporter only
	 */
	public Boolean uploadImageUsingInput(By Locator, String fileNameOnly) {
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\AllImageDoc\\"
					+ fileNameOnly;
			System.out.println("Uplad the file from : " + filePath);
			objPojo.getDriver().findElement(Locator).sendKeys(filePath);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			objPojo.setCustomException("FileInputOutput Exception");
			return false;
		}
	}

	// Author Framework Developer
	// Below method will take ScreenShot and will store under below path
	// This method should be used for Manual Assert Scenario like- Print
	// Preview/Fax/Chart Display
	public boolean takeTCIDScreenShot() {

		try {
			// Take SS here
			String tcid = objPojo.getObjUtilities().dpString("TC ID");
			String date_time = objPojo.getObjUtilities().getDateInSpecifiedFormat("dd_MMM_yyyy_HH_mm_ss");
			waitFor(2);
			String d = "\\";
			File dir = new File(System.getProperty("user.dir") + "\\target\\ManualAssert_ScreenShot");
			File file = new File(dir, d);

			String final_ss_path = file + date_time + "_TCID_" + tcid + ".png";

			// String final_ss_path = file + date_time+ ".png";

			if (!file.exists()) {
				file.mkdir();
				flag = objPojo.getObjUtilities().takeScreenShot(objPojo.getDriver(), final_ss_path);
			} else {
				flag = objPojo.getObjUtilities().takeScreenShot(objPojo.getDriver(), final_ss_path);
			}

			objPojo.getObjUtilities().logReporter(" Screen Shot Path " + final_ss_path, true);

			return flag;

		} catch (Exception e) {
			objPojo.setCustomException("FileInputOutput Exception");
			e.printStackTrace();
			return false;
		}
	}

	// Method by Framework Developer
	// This method is for gettig the text on the alert box.

	public String alertGetText() {
		Alert alert = objPojo.getDriver().switchTo().alert();
		return alert.getText();
		// log.info("alert dismiss successfully.");
	}

	// Method by Framework Developer
	public boolean datePicker(WebElement element, String date) {
		try {
			String[] dateArray = date.split("/");

			// in eCW App- month index start with 0 , Hence we have to do "n-1"
			String month = dateArray[0];
			int tempIntMonth = 0;

			try {
				tempIntMonth = Integer.parseInt(month);
				if (tempIntMonth >= 1) {
					tempIntMonth = tempIntMonth - 1;
					dateArray[0] = tempIntMonth + "";
				}

			} catch (Exception e) {

			}
			// month logic completed - update on 02 Nov

			By divCalendarPopup = By.xpath("//div[@id='ui-datepicker-div']");
			By lnkDate = By
					.xpath("//div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text(),'"
							+ (dateArray[1].startsWith("0") ? dateArray[1].substring(dateArray[1].indexOf("0") + 1)
									: dateArray[1])
							+ "')]");
			By drpMonth = By.xpath(
					"//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']");
			By drpYear = By.xpath(
					"//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']");

			objPojo.getObjUtilities().logReporter("Click on calendar icon", this.click(element));
			objPojo.getObjUtilities().logReporter("Verify calendar popup displayed",
					this.checkElementDisplayed(divCalendarPopup));
			objPojo.getObjUtilities().logReporter("Select year from calendar popup", dateArray[2],
					this.selectDropDownOption(drpYear, dateArray[2], "Value"));
			objPojo.getObjUtilities()
					.logReporter("Select month from calendar popup", dateArray[0],
							this.selectDropDownOption(drpMonth,
									(dateArray[0].startsWith("0")
											? dateArray[0].substring(dateArray[0].indexOf("0") + 1) : dateArray[0]),
									"Value"));
			objPojo.getObjUtilities().logReporter("Select date from calendar popup", dateArray[1], this.click(lnkDate));

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method :
	 * @Description : This is wrapper method to press function keys irrespective
	 *              of a webelement or locator
	 * @param :
	 *            key
	 * @return : - true if text entered successfully
	 * @author : Framework Developer Created on : 29-Nov-2017
	 */
	public boolean sendFunctionKeys(String functionKey) {
		try {

			Actions action = new Actions(objPojo.getDriver());
			switch (functionKey.toUpperCase()) {
			case "F1":
				action.sendKeys(Keys.COMMAND + "" + Keys.F1);
				break;
			case "F2":
				action.sendKeys(Keys.COMMAND + "" + Keys.F2);
				break;

			case "F3":
				action.sendKeys(Keys.COMMAND + "" + Keys.F3);
				break;

			case "F4":
				action.sendKeys(Keys.COMMAND + "" + Keys.F4);
				break;

			case "F5":
				action.sendKeys(Keys.COMMAND + "" + Keys.F5);
				break;

			case "F6":
				action.sendKeys(Keys.COMMAND + "" + Keys.F6);
				break;

			case "F7":
				action.sendKeys(Keys.COMMAND + "" + Keys.F7);
				break;

			case "F8":
				action.sendKeys(Keys.COMMAND + "" + Keys.F8);
				break;

			case "F9":
				action.sendKeys(Keys.COMMAND + "" + Keys.F9);
				break;

			case "F10":
				action.sendKeys(Keys.COMMAND + "" + Keys.F10);
				break;

			case "F11":
				action.sendKeys(Keys.COMMAND + "" + Keys.F11);
				break;

			case "F12":
				action.sendKeys(Keys.COMMAND + "" + Keys.F12);
				break;

			default:
				// objPojo.getObjUtilities().logReporter("Function key parameter
				// is not passed correctly.", true);
				return false;

			}

			return true;

		} catch (Exception e) {
			objPojo.setCustomException("Tool Limitation");
			return false;
		}

	}

	/**
	 * @Method : doubleClick
	 * @Description : This is wrapper method used for doubleClick on element
	 * @param :
	 *            WebElement - By identification of Locator
	 * @return : - true if double click successful
	 * @author : Automation Tester
	 */
	public boolean doubleClick(WebElement webElement) {
		try {
			objSynchronizationUtilities.waitForElementVisibility(webElement);
			objSynchronizationUtilities.waitForElementToBeClickable(webElement);
			Actions actionBuilder = new Actions(objPojo.getDriver());
			actionBuilder.doubleClick(webElement).build().perform();
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : editTableRow
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            editColumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement editTableRow(By weResultTableForTbody, int columnIndexForSearch, String textToSearch,
			int editColumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedEditElement = weRow.findElement(By.xpath(
							".//td[" + editColumnIndex + "]//*[contains(@class,'edit') or contains(@class,'pencil')]"));
					return weExceptedEditElement;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : editTableRow
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers)
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnHeaderNameForSearch - String column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            editColumnIndex - Integer Content to be verifyed from excel
	 * @param :
	 *            editIndex - Integer Content to be verifyed from excel verify
	 *            your editIndex('I' Tag) number in that webTable
	 * @author : Automation Tester
	 */
	public WebElement editTableRow(By weResultTableForThead, By weResultTableForTbody, String columnHeaderNameForSearch,
			String textToSearch, int editColumnIndex) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		try {
			dataColumnHeader = getTableColumnHeader(weResultTableForThead);
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeaderNameForSearch.trim()) + "]"));
				if (weExceptedClm.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedEditElement = weRow.findElement(By.xpath(
							".//td[" + editColumnIndex + "]//*[contains(@class,'edit') or contains(@class,'pencil')]"));
					return weExceptedEditElement;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : setTextWithoutClearText
	 * @Description : This is wrapper method to set text for input element :
	 *              This method is for a special case where : a sendKeys() is
	 *              done without clearing the text.
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Framework Developer
	 */
	public boolean setTextWithoutClearText(By locator, String fieldValue) {
		try {

			WebElement webElement = objSynchronizationUtilities.getElementFluent(locator);
			webElement.sendKeys(fieldValue);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : uploadFileUsingAutoIT
	 * @Description : This is wrapper method to upload file using AutoIT
	 * @param :
	 *            filePath - path of file to upload
	 * @return : - true if upload is successful
	 * @author : Framework Developer
	 * @created on : 23-Dec-2017
	 */
	// USING AUTO-IT
	public boolean uploadFilefromDownloads(String fileNameOnly, String thinkTime) {
		try {
			String filePath = System.getProperty("user.home") + "\\Downloads\\" + fileNameOnly;
			System.out.println("Upload file Path: " + filePath);
			this.waitFor(5);
			String sys_path = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\";

			Runtime.getRuntime().exec(sys_path + "Fileupload.exe" + " " + filePath);
			waitFor(thinkTime);

			return true;
		} catch (Exception e) {
			objPojo.setCustomException("FileInputOutput Exception");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Waits for an alert till the timeout expires
	 * 
	 * @param waitTime
	 *            (int) The time in seconds to wait until returning a failure
	 * @return - True (Boolean) if element is located within timeout period else
	 *         false
	 * @author : Framework Developer
	 */
	public boolean isAlertPresent(int timeUnitSeconds) {
		boolean blnFlag = false;
		objPojo.getObjUtilities().logReporter("Waiting for presence of alert", true);
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			objPojo.getWebDriverWait().until(ExpectedConditions.alertIsPresent());
			Alert alert = objPojo.getDriver().switchTo().alert();
			objPojo.getObjUtilities().logReporter("Alert with text '" + alert.getText() + "' is displayed", true);
			return blnFlag = true;
		} catch (NoAlertPresentException exception) {
			objPojo.getObjUtilities().logReporter(
					"alert not present in time - " + timeUnitSeconds + " Seconds - NoAlertPresentException", true);
			exception.printStackTrace();
			return blnFlag;
		} catch (TimeoutException exception) {
			objPojo.getObjUtilities().logReporter(
					"alert not present in time - " + timeUnitSeconds + " Seconds - TimeoutException", true);
			exception.printStackTrace();
			return blnFlag;
		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter("alert not present - " + exception, true);
			exception.printStackTrace();
			return blnFlag;
		}

	}

	// Framework Developer
	// Below code will delete all files from your "Temp" folder.
	// for cache related issue
	public void clearTempFolder() {
		File file = new File(System.getProperty("java.io.tmpdir"));
		try {
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			objPojo.setCustomException("FileInputOutput Exception");
			e.printStackTrace();
		}

	}

	// Framework Developer
	// Below code will delete all cookies of your browser
	// CAUTION : DO NOT CALL THIS METHOD RANDOMLY.
	// DISCUSS WITH YOUR SUPERIOR BEFORE CALLING THIS METHOD.
	// THIS MIGHT STOP YOUR EXECUTION
	public void deleteAllBrowserCookies() {
		objPojo.getDriver().manage().deleteAllCookies();
	}

	public void setResouceName(String resName) {
		objPojo.setResourceName(resName);
	}

	/**
	 * @author Framework Developer
	 * @Method : selectTableForSpecficColumn
	 * @Description : it will check given data in whole table which come in span
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            ColoumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableForSpecficColumnWithSpan(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch, int ColoumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]/span"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedSpecificColoum = weRow
							.findElement(By.xpath(".//td[" + ColoumnIndex + "]/span"));
					return weExceptedSpecificColoum;
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : setBootStrapDivText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : Framework Developer
	 */
	public boolean setBootStrapTablesText(By locator, String fieldValue) {
		try {
			boolean selected = false;
			WebElement input = objSynchronizationUtilities.getElementFluent(locator);
			clearText(input);
			// input.clear();
			input.sendKeys(fieldValue);
			WebElement ul = objSynchronizationUtilities.getElementFluent(locator)
					.findElement(By.xpath(".//parent::div/ul"));
			objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li//div/h4"));
			List<WebElement> list = ul.findElements(By.xpath(".//li"));
			System.out.println("list------------>" + list.size());
			for (WebElement expectedList : list) {
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(expectedList, By.xpath(".//div"));
				WebElement expectedDiv = expectedList.findElement(By.xpath(".//div"));
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(expectedDiv, By.xpath(".//h4"));
				WebElement hdr = expectedDiv.findElement(By.xpath(".//h4"));
				System.out.println("innerHTML---> " + hdr.getAttribute("innerHTML"));
				if (hdr.getAttribute("innerHTML").trim().contains(fieldValue)) {
					waitFor(2);
					expectedList.click();
					selected = true;
					break;
				}
			}
			return selected;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getLatestDownloadedFileName
	 * @Description : This is wrapper method to get name of latest downloaded
	 *              file.
	 * @return : - file name in a string otherwise "";
	 * @author : Framework Developer
	 * @created on : 11-Nov-2017
	 */

	public String getLatestDownloadedFileName() {

		String latestFile = "";
		try {
			String downloadFilepath = System.getProperty("user.dir")
					+ objPojo.getObjConfig().getProperty("downloads.path").trim();
			System.out.println("verify download path : " + downloadFilepath);
			File directoryForDownload = new File(downloadFilepath);
			File[] downloadedFiles = directoryForDownload.listFiles();

			if (downloadedFiles == null || downloadedFiles.length == 0) {
				return "";
			}
			File lastModifiedFile = downloadedFiles[0];
			for (int i = 1; i < downloadedFiles.length; i++) {
				if (lastModifiedFile.lastModified() < downloadedFiles[i].lastModified()) {
					lastModifiedFile = downloadedFiles[i];
				}
			}
			latestFile = lastModifiedFile.getName().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return latestFile;
	}

	/**
	 * @Method : deleteFile
	 * @Description : This is wrapper method to delete file file.
	 * @return : - file name in a boolean value either true/false
	 * @author : Framework Developer
	 * @created on : 07-feb-2018
	 */
	public boolean deleteFile(String fileName) {
		Boolean flag = false;
		try {
			String downloadFilepath = System.getProperty("user.dir")
					+ objPojo.getObjConfig().getProperty("downloads.path").trim();
			System.out.println("download path : " + downloadFilepath);
			File file = new File(downloadFilepath +"\\"+ fileName.trim());
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
				flag = true;
			} else {
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete  file from download exception failed");
		}
		return flag;
	}
	/**
	 * @Method : existFile
	 * @Description : This is wrapper method to Exists file file.
	 * @return : - file name in a boolean value either true/false
	 * @author : Framework Developer
	 * @created on : 07-feb-2018
	 */
	public boolean existsFile(String fileName) {
		Boolean flag = false;
		try {
			String downloadFilepath = System.getProperty("user.dir")
					+ objPojo.getObjConfig().getProperty("downloads.path").trim();
			System.out.println("download path : " + downloadFilepath);
			File file = new File(downloadFilepath + fileName.trim());
			if (file.exists()) {
				System.out.println(file.getName() + " is exists!");
				flag = true;
			} else {
				System.out.println("exists operation is failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exists file from download exception failed");
		}
		return flag;
	}

	/**
	 * @Method : deleteAllFile
	 * @Description : This is wrapper method to Delete All file from download
	 *              Directory
	 * @author : Framework Developer
	 * @created on : 08-feb-2018
	 */

	public void deleteAllFile() {
		try {
			String downloadFilepath = System.getProperty("user.dir")
					+ objPojo.getObjConfig().getProperty("downloads.path").trim();
			System.out.println("download path : " + downloadFilepath);
			File file = new File(downloadFilepath);
			String[] entries = file.list();
			for (String s : entries) {
				File currentFile = new File(file.getPath(), s);
				currentFile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete All file from download exception failed");
		}

	}

	/**
	 * @Method : verifyTableContent
	 * @Description : it will check given data in whole table
	 * @param :
	 *            locator - By identification of element (table with all rows)
	 * @param :
	 *            columnHeader - String column header
	 * @param :
	 *            ContentToVerify - String Content to be verify
	 * @author : Automation Tester
	 */
	public boolean verifyTableContents(By locator, String columnHeader, String ContentToVerify) {
		Hashtable<String, String> dataColumnHeader = new Hashtable<String, String>();
		int intColumnNumber = 1;
		boolean blnverify = false;
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement weResultTable = objPojo.getDriver().findElement(locator);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//thead/tr/th"));
			List<WebElement> weColumnsHeaders = weResultTable.findElements(By.xpath(".//thead/tr/th"));
			for (WebElement weColumnHeader : weColumnsHeaders) {
				String strHeader = weColumnHeader.getText().trim();
				System.out.println("strHeader------->" + strHeader);
				if (!strHeader.equals(""))
					dataColumnHeader.put(strHeader, String.valueOf(intColumnNumber));
				intColumnNumber++;
			}

			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(locator, By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weExceptedClm = weRow
						.findElement(By.xpath(".//td[" + dataColumnHeader.get(columnHeader) + "]"));
				System.out.println("************************---------->" + weExceptedClm.getAttribute("value"));
				if (weExceptedClm.getAttribute("value").trim().contains(ContentToVerify)) {
					blnverify = true;
					return blnverify;
				}
			}
			return blnverify;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : setBrowserDiamension
	 * @Description : This method is used for set browser with Diamension with
	 *              specific hight and width.
	 * @param :
	 *            int intWidth, int intHight
	 * @author : Framework Developer
	 */

	public boolean setBrowserDiamension(int intWidth, int intHight) {
		try {
			System.out.println(
					"**************** Browser Default Diamension : " + objPojo.getDriver().manage().window().getSize());
			Dimension diamension = new Dimension(intWidth, intHight);
			// Resize the current window to the given dimension
			objPojo.getDriver().manage().window().setSize(diamension);
			System.out.println(
					"**************** Resize Browser Diamension : " + objPojo.getDriver().manage().window().getSize());
			objPojo.getObjWrapperFunctions().waitFor(objPojo.getObjConfig().getProperty("driver.WebDriverWait"));

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;

		}
	}

	/**
	 * @Method : setBrowserDefaultDiamension
	 * @Description : This method is used for set Browser Default Diamension.
	 * @param :
	 * @author : Framework Developer
	 */
	public boolean setBrowserDefaultDiamension() {

		try {
			objPojo.getDriver().manage().window().maximize();
			System.out.println("**************** Set Browser Default Diamension.");
			objPojo.getObjWrapperFunctions().waitFor(objPojo.getObjConfig().getProperty("driver.WebDriverWait"));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;

		}
	}

	/**
	 * @Method : selectTableForSpecficColumnwithSpan
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            ColoumnIndex - Integer Content to be verifyed from excel
	 * @author : Framework Developer
	 */
	public WebElement selectTableForSpecficColumnwithSpan(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch, int ColoumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().equalsIgnoreCase(textToSearch.trim())) {
					WebElement weExceptedSpecificColoum = weRow
							.findElement(By.xpath(".//td[" + ColoumnIndex + "]//span"));
					return weExceptedSpecificColoum;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean closeDriver() {

		try {
			objPojo.getDriver().close();
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

	}

	public boolean openNewWindow() {

		// Use robot class to press Ctrl+t keys
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
			return true;
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * @Method : selectRadioButton
	 * @Description : This is wrapper method select/deselect radio button
	 * @param :
	 *            webElement - By identification of element
	 * @param :
	 *            status - select/deselect
	 * @author :Automation Tester
	 */
	public boolean selectRadioButton(WebElement webElement, boolean status) {
		try {
			objSynchronizationUtilities.waitForElementVisibility(webElement);
			if (webElement.getAttribute("type").equals("radio")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * Waits for the completion of Ajax jQuery processing by checking "return
	 * jQuery.active == 0" condition.
	 *
	 * @param driver
	 *            - The driver object to be used to wait and find the element
	 * @param timeOutInSeconds
	 *            - The time in seconds to wait until returning a failure
	 * @return True (Boolean) if jquery/ ajax is loaded within specified
	 *         timeout.
	 * @throws Exception
	 */
	public boolean waitForJQueryProcessing(int timeOutInSeconds) {
		objPojo.getObjUtilities().logReporter("Waiting ajax processing to complete..", true);
		boolean jQcondition = false;
		try {
			new WebDriverWait(objPojo.getDriver(), timeOutInSeconds).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driverObject) {
					return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0");
				}
			});
			jQcondition = (Boolean) ((JavascriptExecutor) objPojo.getDriver())
					.executeScript("return window.jQuery != undefined && jQuery.active === 0");
			// System.out.println(jQcondition);
			return jQcondition;
		} catch (TimeoutException exTimeoutException) {

			objPojo.getObjUtilities().logReporter(
					"TimeOut Page Loading is not completed in time - " + timeOutInSeconds + " - " + exTimeoutException,
					true);

		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter(
					"Page Loading is not completed in time - " + timeOutInSeconds + " - " + exception, true);

		}
		return jQcondition;
	}

	/**
	 * Waits until page is loaded. Default timeout is 250 seconds. Poll time is
	 * every 500 milliseconds.
	 *
	 * @param driver
	 *            - The driver object to use to perform this element search
	 * @return void
	 * @throws Exception
	 * @author Framework Developer
	 */

	public void waitForPageToLoad() {

		objPojo.getObjUtilities().logReporter("Waiting for page to be loaded...", true);
		try {
			int waitTime = 0;
			boolean isPageLoadComplete = false;
			do {
				isPageLoadComplete = ((String) ((JavascriptExecutor) objPojo.getDriver())
						.executeScript("return document.readyState")).equals("complete");
				System.out.print(".");
				Thread.sleep(500);
				waitTime++;
				if (waitTime > 500) {
					break;
				}
			} while (!isPageLoadComplete);

			if (!isPageLoadComplete) {

				objPojo.getObjUtilities().logReporter("Unable to load webpage with in default timeout 250 seconds",
						true);
			}
		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter("Unable to load web page - " + exception, false);
		}

	}

	/**
	 * Method - Safe Method for User Click, waits until the element is loaded
	 * and then performs a click action
	 * 
	 * @param locatorToClick
	 * @param locatorToCheck
	 * @param waitTime
	 * @return - boolean (returns True when click action is performed else
	 *         returns false)
	 * @throws Exception
	 */
	public void safeClick(By locatorToClick, By locatorToCheck, int waitElementToClick, int waitElementToCheck)
			throws Exception {
		boolean bResult = false;

		int iAttempts = 0;
		while (iAttempts < 3) {
			try {
				objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locatorToClick));
				objPojo.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locatorToClick));
				WebElement element = objPojo.getDriver().findElement(locatorToClick);

				if (element.isDisplayed()) {
					element.click();
					waitForPageToLoad();
					waitForJQueryProcessing(waitElementToCheck);
					objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locatorToCheck));
					WebElement elementToCheck = objPojo.getDriver().findElement(locatorToCheck);
					if (elementToCheck.isDisplayed()) {
						objPojo.getObjUtilities().logReporter("Clicked on element " + locatorToClick, true);
						break;
					} else {
						Thread.sleep(1000);
						continue;
					}
				}
			} catch (Exception exception) {
				objPojo.getObjUtilities().logReporter(
						"Attempt: " + iAttempts + "\n Unable to click on element " + locatorToClick + " - " + exception,
						true);
			}
			iAttempts++;
		}
		if (!bResult) {
			objPojo.getObjUtilities().logReporter("Unable to click on element " + locatorToClick, true);
		}
	}

	/**
	 * Method to copy the given text to clip board
	 * 
	 * @param sText
	 */
	private void copyTextToClipboard(String sText) {
		StringSelection stringSelection = new StringSelection(sText);
		Clipboard _clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		_clpbrd.setContents(stringSelection, null);
	}

	/**
	 * Method to paste the text using key strokes
	 * 
	 * @param robot
	 */
	private void pasteCopiedText(Robot robot) {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	/**
	 * Method: for uploading file by using Robot class
	 * 
	 * @return - null
	 * @throws Exception
	 */
	public void uploadFileRobot(By locator, String sFileLocation, int waitTime) {
		try {
			if (this.checkElementDisplayed(locator)) {
				this.copyTextToClipboard(sFileLocation);
				this.scrollToView(locator);
				if (this.waitForElementEditable(locator)) {
					Thread.sleep(2000);
					Actions builder = new Actions(objPojo.getDriver());

					Action myAction = builder.click(objPojo.getDriver().findElement(locator)).release().build();

					myAction.perform();
					Thread.sleep(15000);
					Robot robot = new Robot();
					this.pasteCopiedText(robot);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);
					objPojo.getObjUtilities().logReporter("File at location " + sFileLocation
							+ " is Uploaded by upload field " + locator + " using Robot Functionality", true);
				} else {
					objPojo.getObjUtilities().logReporter(
							"Unable to click on element with locator" + locator + " for uploading a file", true);

				}
			} else {
				objPojo.getObjUtilities().logReporter(
						"Unable to upload file - " + sFileLocation + " using upload field - " + locator, true);

			}
		} catch (StaleElementReferenceException exception) {
			objPojo.getObjUtilities().logReporter("Element with " + locator + "is not attached to the page document",
					true);

		} catch (NoSuchElementException exception) {
			objPojo.getObjUtilities().logReporter("Element " + locator + " was not found in DOM", true);

		} catch (Exception exception) {
			objPojo.getObjUtilities().logReporter(
					"Unable to upload file - " + sFileLocation + " using upload field - " + locator + " - " + exception,
					true);

		}

	}

	/**
	 * Below method is used for only switching iFrames single or Nested. For
	 * this method no need to switch frame you just pass locator which you want
	 * and perform action event, It will switch iframe automatically and perform
	 * locator action event.
	 * 
	 * @param locator
	 *            Created By : Framework Developer
	 * 
	 */
	public boolean switchToIframeSingleWithNestedUsingIframeByIndex(By locator) {

		try {

			int intParentFrame;
			int intChildFrame;
			int intLocatorCount = 0;
			int intFrameCount = -1;
			int intCount = 0;

			objPojo.getDriver().switchTo().defaultContent();

			int intParentIframeCount = objPojo.getDriver().findElements(By.tagName("iframe")).size();

			System.out.println("**************** into Parent Iframe Count ---> " + intParentIframeCount);

			for (intParentFrame = 0; intParentFrame < intParentIframeCount; intParentFrame++)

			{
				objPojo.getDriver().switchTo().defaultContent();
				objPojo.getDriver().switchTo().frame(intParentFrame);
				System.out
						.println(" **************** into Parent Iframe Count continue looping --->  " + intParentFrame);
				intLocatorCount = objPojo.getDriver().findElements(locator).size();
				System.out.println("**************** into Parent iframe Locator size found ---> " + intLocatorCount);

				while (!(intLocatorCount > 0)) {

					intCount++;

					int intChildIframeCount = objPojo.getDriver().findElements(By.tagName("iframe")).size();
					System.out.println("**************** into Child Iframe Count ---> " + intChildIframeCount);

					System.out.println(
							"**************** into Child Iframe Count continue looping --->  " + intChildIframeCount);

					for (intChildFrame = 0; intChildFrame < intChildIframeCount; intChildFrame++) {
						checkChildIframe(intChildFrame);

						intLocatorCount = checkIframeElement(locator);
						System.out.println(
								" **************** into Parent iframe Locator size found ---> " + intLocatorCount);

						if (intLocatorCount > 0) {
							System.out.println(" Locator found successfully and  Break child loop..!!!!!!!");
							break;
						}
					}
					if (intCount > 0) {
						break;
					}
				}
				if (intLocatorCount > 0)

				{
					intFrameCount = intParentFrame;
					System.out.println("**************** Final locator found frame count  ----> " + intFrameCount);
					System.out.println(" **************** Locator found successfully and  Break parent loop..!!!!!!!");
					break;
				}
			}
			return true;

		} catch (NoSuchFrameException exFrameException) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exFrameException.getMessage());
			exFrameException.printStackTrace();
			return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {

			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;

		}

	}

	public int checkIframeElement(By locator) {
		try {
			System.out.println(" intLocatorCount before ");
			int intLocatorCount = objPojo.getDriver().findElements(locator).size();
			System.out.println(" intLocatorCount " + intLocatorCount);
			return intLocatorCount;
		} catch (Exception e) {
			System.out.println(" intLocatorCount " + 0);
			return 0;
		}
	}

	public boolean checkChildIframe(int intChildFrame) {
		try {
			System.out.println(" intChildFrame before try");
			objPojo.getDriver().switchTo().frame(intChildFrame);
			System.out.println(" intChildFrame " + intChildFrame);
			return true;
		} catch (Exception e) {
			System.out.println(" intChildFrame catch");
			return false;
		}
	}

	public boolean checkIFrameLocator(By locatorIframe, By locator) {
		try {
			objPojo.getDriver().switchTo().defaultContent();
			objPojo.getDriver().switchTo().frame(objPojo.getDriver().findElement(locatorIframe));
			objSynchronizationUtilities.waitForElementPresence(locator);
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean switchToIframeSingleWithNestedUsingIframeByIndex_1(By locator) {

		try {

			int intParentFrame;
			int intChildFrame;
			int intLocatorCount = 0;
			int intFrameCount = -1;
			int intCount = 0;

			objPojo.getDriver().switchTo().defaultContent();

			int intParentIframeCount = objPojo.getDriver().findElements(By.tagName("iframe")).size();

			System.out.println("**************** into Parent Iframe Count ---> " + intParentIframeCount);

			for (intParentFrame = 0; intParentFrame < intParentIframeCount; intParentFrame++)

			{
				objPojo.getDriver().switchTo().defaultContent();
				objPojo.getDriver().switchTo().frame(intParentFrame);
				System.out
						.println(" **************** into Parent Iframe Count continue looping --->  " + intParentFrame);
				intLocatorCount = objPojo.getDriver().findElements(locator).size();
				System.out.println("**************** into Parent iframe Locator size found ---> " + intLocatorCount);

				while (!(intLocatorCount > 0)) {

					intCount++;

					int intChildIframeCount = objPojo.getDriver().findElements(By.tagName("iframe")).size();
					System.out.println("**************** into Child Iframe Count ---> " + intChildIframeCount);

					System.out.println(
							"**************** into Child Iframe Count continue looping --->  " + intChildIframeCount);

					intLocatorCount = objPojo.getDriver().findElements(locator).size();
					System.out
							.println(" **************** into Parent iframe Locator size found ---> " + intLocatorCount);

					if (intLocatorCount > 0) {
						System.out.println(" Locator found successfully and  Break child loop..!!!!!!!");
						break;
					}
					if (intCount > 0) {
						break;
					}
				}
				if (intLocatorCount > 0)

				{
					intFrameCount = intParentFrame;
					System.out.println("**************** Final locator found frame count  ----> " + intFrameCount);
					System.out.println(" **************** Locator found successfully and  Break parent loop..!!!!!!!");
					break;
				}
			}
			return true;

		} catch (NoSuchFrameException exFrameException) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exFrameException.getMessage());
			exFrameException.printStackTrace();
			return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {

			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;

		}

	}

	/*
	 * @Method : isCheckBoxSelected
	 * 
	 * @Description : This is wrapper checkbox is selected or not
	 * 
	 * @param : WebElement - By identification of element
	 * 
	 * @author : Automation Tester
	 */
	public boolean isCheckBoxSelected(WebElement webElement) {
		boolean state = false;
		try {
			objSynchronizationUtilities.waitForElementVisibility(webElement);
			if (webElement.getAttribute("type").equals("checkbox"))
				state = webElement.isSelected();
			return state;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : selectSpanValueFromUnorderedList
	 * @Description : This is wrapper method select drop down element from
	 *              UnorderedList eg.
	 *              <ul>
	 *              <li></li>
	 *              <li></li>
	 *              </ul>
	 * @param :
	 *            locator - By identification of main list
	 * @param :
	 *            value - Value to select
	 * @author : Automation Tester
	 */
	public boolean selectSpanValueFromUnorderedList(By locator, String value) {
		try {
			boolean returnValue = false;
			objSynchronizationUtilities.waitForElementPresence(locator);
			WebElement unorderedList = objSynchronizationUtilities.getElementFluent(locator);
			unorderedList.click();
			this.waitFor(3); // Wait Added By Yogesh
			List<WebElement> options = unorderedList.findElements(By.xpath("./li"));
			for (WebElement option : options) {
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(unorderedList,
						By.xpath(".//li/a/span"));
				objSynchronizationUtilities.waitForPresenceOfNestedElementLocated(option, By.xpath(".//a/span"));
				WebElement span = option.findElement(By.xpath(".//a/span"));
				if (span.getAttribute("innerHTML").equals(value)) {
					((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
							span);
					this.clickWithPresenceAndFulent(span);
					returnValue = true;
					break;
				}
			}
			return returnValue;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if click successful
	 * @author : Automation Tester
	 */
	public boolean clickWithPresenceAndFulent(WebElement weElement) {
		try {
			objPojo.getDriver().manage().timeouts().setScriptTimeout(objPojo.getScriptTimeoutWait(), TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("return arguments[0].click()", objSynchronizationUtilities.getElementFluent(weElement));
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			try {
				objSynchronizationUtilities.getElementFluent(weElement).click();
				waitAfterEachClick();
				return true;
			} catch (Exception exceptionJavascript) {
				objPojo.setCustomException("NoSuchElement Exception");
				return false;
			}
		}
	}

	/**
	 * @Method : sendKeyBoardKeys
	 * @Description : This is wrapper method is used to send keyboard keys
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            key - key name
	 * @return : - true if text entered successfully
	 * @author : Automation Tester
	 */
	public boolean sendKeyBoardKeys(WebElement webElement, String key) {
		try {

			if (key.equalsIgnoreCase("enter"))
				webElement.sendKeys(Keys.ENTER);
			if (key.equalsIgnoreCase("shift"))
				webElement.sendKeys(Keys.SHIFT);
			if (key.equalsIgnoreCase("tab"))
				webElement.sendKeys(Keys.TAB);
			if (key.equalsIgnoreCase("keydown"))
				webElement.sendKeys(Keys.DOWN);
			if (key.equalsIgnoreCase("escape"))
				webElement.sendKeys(Keys.ESCAPE);

			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getCSSValue
	 * @Description : This is wrapper method to Get CSS Value of WebElement on
	 *              the page
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            String - Pass the Value as a Attribute Name
	 *            (Ex."color","background-color")
	 * @return : String - Get the CSS Value of WebElement
	 */
	public String getCSSValue(By locator, String attributeName) {
		try {
			String strValue = null;
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.waitForElementToBeClickable(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			strValue = webElement.getCssValue(attributeName);
			String[] numbers = strValue.replace("rgba(", "").replace(")", "").split(",");
			int number1 = Integer.parseInt(numbers[0]);
			numbers[1] = numbers[1].trim();
			int number2 = Integer.parseInt(numbers[1]);
			numbers[2] = numbers[2].trim();
			int number3 = Integer.parseInt(numbers[2]);
			strValue = String.format("#%02x%02x%02x", number1, number2, number3);
			return strValue;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			return null;
		}
	}

	/**
	 * @Method : getCSSValue
	 * @Description : This is wrapper method to Get CSS Value of WebElement on
	 *              the page
	 * @param :
	 *            WebElement - By identification of element
	 * @param :
	 *            String - Pass the Value as a Attribute Name
	 *            (Ex."color","background-color")
	 * @return : String - Get the CSS Value of WebElement
	 */
	public String getCSSValue(WebElement webElement, String attributeName) {
		try {
			String strValue = null;
			objSynchronizationUtilities.waitForElementVisibility(webElement);
			objSynchronizationUtilities.waitForElementToBeClickable(webElement);
			strValue = webElement.getCssValue(attributeName);
			String[] numbers = strValue.replace("rgba(", "").replace(")", "").split(",");
			int number1 = Integer.parseInt(numbers[0]);
			numbers[1] = numbers[1].trim();
			int number2 = Integer.parseInt(numbers[1]);
			numbers[2] = numbers[2].trim();
			int number3 = Integer.parseInt(numbers[2]);
			strValue = String.format("#%02x%02x%02x", number1, number2, number3);
			return strValue;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			return null;
		}
	}

	/**
	 * @Method : verifyTableRowDisableFields
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers & rows
	 * @param :
	 *            columnIndexForSearch - int column header
	 * @param :
	 *            textToSearch - String Content to be verified from excel
	 * @author : Automation Tester
	 */
	public void verifyTableRowDisableFields(By weResultTableForTbody, int columnIndexForSearch, String textToSearch) {
		try {
			WebElement weExceptedClm = null;
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				weExceptedClm = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weExceptedClm.getAttribute("innerText").trim().equalsIgnoreCase(textToSearch.trim())) {
					List<WebElement> weCells = weRow.findElements(By.xpath(".//td"));
					int i = 1;
					for (WebElement weCell : weCells) {
						objPojo.getObjUtilities().logReporter("Verified Table Row Disable Fields",
								weExceptedClm.getAttribute("innerText").trim(), "Column Number : " + i,
								!weCell.isEnabled());
						i++;
					}
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();

		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();

		}
	}

	/**
	 * @Method : getCalenderData
	 * @Description : This is wrapper method to Get Calendar Data
	 * @param :
	 *            String Date -Ex."01/04/2019",String format
	 *            -Ex."MM/dd/yyyy",String search -Ex."Month"
	 * @return : Calendar Data in a String value
	 * @author : Framework Developer
	 * @created on : 04-Jan-2019
	 */
	public String getCalendarData(String Date, String format, String search) {
		try {
			String strvalue = "";
			int intValue = 0;
			SimpleDateFormat df = new SimpleDateFormat(format);
			Date date = df.parse(Date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			if (search.equalsIgnoreCase("Day")) {
				df = new SimpleDateFormat("EEE", Locale.getDefault());
				strvalue = df.format(date);
			}
			if (search.equalsIgnoreCase("DayFullName")) {
				df = new SimpleDateFormat("EEEE", Locale.getDefault());
				strvalue = df.format(date);
			}
			if (search.equalsIgnoreCase("Week")) {
				intValue = cal.get(Calendar.WEEK_OF_YEAR);
				strvalue = String.valueOf(intValue);
			}
			if (search.equalsIgnoreCase("Month")) {
				intValue = cal.get(Calendar.MONTH);
				intValue = intValue + 1;
				strvalue = String.valueOf(intValue);
			}
			if (search.equalsIgnoreCase("MonthFullName")) {
				df = new SimpleDateFormat("MMMM");
				strvalue = df.format(date);
			}
			if (search.equalsIgnoreCase("MonthName")) {
				df = new SimpleDateFormat("MMM");
				strvalue = df.format(date);
			}
			if (search.equalsIgnoreCase("Year")) {
				intValue = cal.get(Calendar.YEAR);
				strvalue = String.valueOf(intValue);
			}
			if (search.equalsIgnoreCase("Date")) {
				intValue = cal.get(Calendar.DATE);
				strvalue = String.valueOf(intValue);
			}
			return strvalue;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Get Calendar Data failed");
			return null;
		}
	}

	/**
	 * @Method : selectCheckBox
	 * @Description : This is wrapper method select/deselect checkbox
	 * @param :
	 *            WebElement - By identification of Locator
	 * @param :
	 *            status - select/deselect
	 * @author : Automation Tester
	 */
	public boolean selectCheckBox(WebElement webElement, boolean status) {
		try {
			if (webElement.getAttribute("type").equals("checkbox")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					this.clickWithPresenceAndFulent(webElement);
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : actionClick
	 * @Description : This is wrapper method used for actionClick on element
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if Action click successful
	 * @author : Automation Tester
	 */
	public boolean actionClick(By locator) {
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			// waitForElementToBeClickable(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			objSynchronizationUtilities.setHighlight(webElement);
			Actions actionBuilder = new Actions(objPojo.getDriver());
			actionBuilder.moveToElement(webElement).click(webElement).release().build().perform();
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifySortingTable
	 * @Description : This is wrapper method used for verifySortingTable on
	 *              element
	 * @param :
	 *            weResultTableForTbody - By identification of element
	 * @param :
	 *            tableColIndex - Column Index
	 * @param :
	 *            sortByASCorDES - Sorty By Name Ex.'Ascending' or 'Descending'.
	 * @return : - true if Sorting is successful
	 * @author : Automation Tester
	 */
	public boolean verifySortingTable(By weResultTableForTbody, int tableColIndex, String sortByName) {
		try {
			boolean blnReturnStatus = false;
			objSynchronizationUtilities.waitForElementPresence(weResultTableForTbody);
			objSynchronizationUtilities.waitForElementToBeClickable(weResultTableForTbody);
			WebElement WebReturnElement = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> webresult = WebReturnElement
					.findElements(By.xpath(".//tbody//tr//td[" + tableColIndex + "]"));
			ArrayList<String> objArray = new ArrayList<String>();
			for (int i = 0; i < webresult.size(); i++) {
				objArray.add(objPojo.getObjWrapperFunctions().getText(webresult.get(i), "text"));
			}
			ArrayList<String> retArray = new ArrayList<String>();
			retArray.addAll(objArray);
			if (sortByName.equalsIgnoreCase("Ascending")) {
				Collections.sort(retArray);
				Collections.reverse(retArray);
				blnReturnStatus = true;
				for (int j = 0; j < retArray.size(); j++) {
					if (!objArray.get(j).equals(retArray.get(j))) {
						blnReturnStatus = false;
						break;
					}
				}
				objPojo.getObjUtilities().logReporter("Verify Specific Column Ascending", blnReturnStatus);
			} else if (sortByName.equalsIgnoreCase("Descending")) {
				Collections.sort(retArray);

				blnReturnStatus = true;
				for (int j = 0; j < retArray.size(); j++) {
					if (!objArray.get(j).equals(retArray.get(j))) {
						blnReturnStatus = false;
						break;
					}
				}
				objPojo.getObjUtilities().logReporter("Verify Specific Column Descending", blnReturnStatus);
			}
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : mouseHover
	 * @Description : This is wrapper method used for Mouse Hovering to the
	 *              element
	 * @param :
	 *            locator - By identification of element
	 * @author :Automation Tester
	 */
	public boolean mouseHover(WebElement webElement) {
		try {

			Actions actionBuilder = new Actions(objPojo.getDriver());
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : tableRowSize_1
	 * @Description : it will give table rows size
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @author : Framework Developer
	 */
	public int getTableRowSize_1(By weResultTableForTbody) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			// waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
			// By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			int tableRowSize = weRows.size();
			return tableRowSize;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return 0;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return 0;
		}
	}

	/**
	 * @Method : verifySortingList
	 * @Description : This is wrapper method used for verifySortingList on
	 *              element
	 * @param :
	 *            List<WebElement> - List of Web element
	 * @param :
	 *            sortByName - Sorty By Name Ex.'Ascending' or 'Descending'.
	 * @return : - true if Sorting is successful
	 * @author : Automation Tester
	 */
	public boolean verifySortingList(List<WebElement> list, String sortByName) {
		try {
			boolean blnReturnStatus = false;
			ArrayList<String> objArray = new ArrayList<String>();
			ArrayList<String> retArray = new ArrayList<String>();
			for (WebElement element : list) {
				objArray.add(element.getText().trim());
			}
			retArray.addAll(objArray);
			if (sortByName.equalsIgnoreCase("Ascending")) {
				Collections.sort(retArray);
				blnReturnStatus = retArray.equals(objArray);
			} else if (sortByName.equalsIgnoreCase("Descending")) {
				Collections.sort(retArray);
				Collections.reverse(retArray);
				blnReturnStatus = retArray.equals(objArray);
			}
			return blnReturnStatus;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is enabled
	 *              on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 */
	public boolean checkElementEnabled(WebElement webElement) {
		try {

			return webElement.isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Method : selectTableRowTextBox
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * 
	 *            ALSO Support if input has @dateformat='mm/dd/yy'
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            textBoxColIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableRowTextBoxByContains(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch, int textBoxColIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				System.out.println("weColumns " + weColumns.getAttribute("value"));
				if (weColumns.getText().trim().contains(textToSearch.trim())) {
					WebElement weExceptedTextBox = weRow.findElement(
							By.xpath(".//td[" + textBoxColIndex + "]//input[@type='text' or @dateformat='mm/dd/yy']"));
					return weExceptedTextBox;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * @Method : verifyTableRowDisableFields
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            headers & rows
	 * @param :
	 *            columnIndexForSearch - int column header
	 * @param :
	 *            textToSearch - String Content to be verified from excel
	 * @author : Automation Tester
	 */
	public void verifyTableRowDisableFieldsByContains(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch) {
		try {
			WebElement weExceptedClm = null;
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				weExceptedClm = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weExceptedClm.getAttribute("innerText").trim().contains(textToSearch.trim())) {
					List<WebElement> weCells = weRow.findElements(By.xpath(".//td"));
					int i = 1;
					for (WebElement weCell : weCells) {
						objPojo.getObjUtilities().logReporter("Verified Table Row Disable Fields",
								weExceptedClm.getAttribute("innerText").trim(), "Column Number : " + i,
								!weCell.isEnabled());
						i++;
					}
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();

		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();

		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();

		}
	}

	/**
	 * @Method : searchTableRowByContains
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement searchTableRowByContains(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch) {
		try {
			WebElement weExceptedClm = null;
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				weExceptedClm = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weExceptedClm.getText().trim().contains(textToSearch.trim())) {
					return weExceptedClm;
				}
			}
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;

	}

	/**
	 * Scroll element to view using javascript
	 */
	public boolean scrollToView(WebElement webElement) {
		try {
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : verifySortingList
	 * @Description : This is wrapper method used for verify SortingList on
	 *              element
	 * @param :
	 *            List<WebElement> - List of Web element
	 * @param :
	 *            sortByName - Sorty By Name Ex.'Ascending' or 'Descending'.
	 * @return : - true if Sorting is successful
	 * @author : Automation Tester
	 */
	public boolean verifySortingListByCharacter(ArrayList<String> objArray, String sortByName) {
		try {
			boolean blnReturnStatus = false;
			ArrayList<String> retArray = new ArrayList<String>();
			retArray.addAll(objArray);
			if (sortByName.equalsIgnoreCase("Ascending")) {
				Collections.sort(retArray);
				blnReturnStatus = retArray.equals(objArray);
			} else if (sortByName.equalsIgnoreCase("Descending")) {
				Collections.sort(retArray);
				Collections.reverse(retArray);
				blnReturnStatus = retArray.equals(objArray);
			}
			return blnReturnStatus;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectTableForRandomColumn
	 * @Description : it will check given data in whole table
	 * @param :
	 *            WebElement - By identification of element (table with all
	 *            rows)
	 * @param :
	 *            columnIndexForSearch - Integer column header
	 * @param :
	 *            textToSearch - String Content to be verifyed from excel
	 * @param :
	 *            ColoumnIndex - Integer Content to be verifyed from excel
	 * @author : Automation Tester
	 */
	public WebElement selectTableForRandomColumn(By weResultTableForTbody, int columnIndexForSearch,
			String textToSearch, int ColoumnIndex) {
		try {
			WebElement weResultTable = objPojo.getDriver().findElement(weResultTableForTbody);
			objSynchronizationUtilities.waitForPresenceOfNestedElementsLocated(weResultTableForTbody,
					By.xpath(".//tbody/tr"));
			List<WebElement> weRows = weResultTable.findElements(By.xpath(".//tbody/tr"));
			for (WebElement weRow : weRows) {
				WebElement weColumns = weRow.findElement(By.xpath(".//td[" + columnIndexForSearch + "]"));
				if (weColumns.getText().trim().contains(textToSearch.trim())) {
					WebElement weExceptedSpecificColoum = weRow.findElement(By.xpath(".//td[" + ColoumnIndex + "]"));
					return weExceptedSpecificColoum;
				}
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return null;
	}

	/*
	 * @Method : isCheckBoxSelected
	 * 
	 * @Description : This is wrapper checkbox is selected or not
	 * 
	 * @param : WebElement - By identification of element
	 * 
	 * @author : Automation Tester
	 */
	public boolean isCheckBoxSelectedWithoutVisibility(WebElement webElement) {
		boolean state = false;
		try {
			// waitForElementVisibility(webElement);
			if (webElement.getAttribute("type").equals("checkbox"))
				state = webElement.isSelected();
			return state;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * 
	 * /**
	 * 
	 * @Method : uploadFileUsingAutoIT
	 * @Description : This is wrapper method to upload file using AutoIT
	 * @param :
	 *            filePath - path of file to upload
	 * @return : - true if upload is successful
	 * @author : Framework Developer
	 * @created on : 12-Feb-2019
	 */
	// USING AUTO-IT
	public boolean uploadFileExtension(String fileNameOnly, String endWithExtension) {
		try {
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\AllImageDoc\\"
					+ fileNameOnly;
			System.out.println("Upload file Path: " + System.getProperty("user.dir")
					+ "\\src\\test\\resources\\testData\\AllImageDoc\\" + fileNameOnly);
			this.waitFor(5);

			return (filePath.toString().endsWith(endWithExtension));
		} catch (Exception e) {
			objPojo.setCustomException("FileInputOutput Exception");
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : pageNavigateToBack
	 * @Description : This is wrapper method is to navigate from current page to
	 *              previous one.
	 * @param :
	 * @return :
	 * @author : Framework Developer
	 * @created on : 20-Mar-2019
	 */
	public void pageNavigateToBack() {
		objPojo.getDriver().navigate().back();
		objPojo.getObjUtilities().logReporter("Current Page is navigated to previous page.", true);
	}

	/**
	 * @Method : selectDatePicker
	 * @Description : This is wrapper method to Set Date
	 * @param :
	 *            locator - Identify WebElement of Set Date input field or Date
	 *            Picker Icon ,String date - "01/07/2019","MM/dd/yyyy",
	 * @return : boolean -(returns True when Select Date From Date Picker is
	 *         Successfully done else returns false)
	 * @author : Framework Developer
	 * @created on : 17-04-2019
	 */
	public boolean selectDatePicker(By locator, String date) {
		try {
			boolean blnReturnStatus = false;
			int yearDiff = 0, intMonth = 0, intDate = 0, monthDiff = 0;
			String month = "", year = "";
			String date_dd_MM_yyyy[] = (date.split(" ")[0]).split("/");
			intMonth = Integer.parseInt(this.getCalendarData(date, "MM/dd/yyyy", "Month")) - 1;
			// get the year difference between current year and year to set in
			// calander
			yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
			monthDiff = Integer.parseInt(date_dd_MM_yyyy[0]) - Calendar.getInstance().get(Calendar.MONTH);
			intDate = Integer.parseInt(this.getCalendarData(date, "MM/dd/yyyy", "Date"));
			month = this.getCalendarData(date, "MM/dd/yyyy", "MonthFullName");
			year = this.getCalendarData(date, "MM/dd/yyyy", "Year");

			By lnkNext = By.xpath("//div[@id='ui-datepicker-div']//span[text()='Next']");
			By lnkPrev = By.xpath("//div[@id='ui-datepicker-div']//span[text()='Prev']");
			By lblMonth = By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-title']/span[1]");
			By lblYear = By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-title']/span[2]");
			By lnkDate = By
					.xpath("//div[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//tbody/tr/td[@data-month='"
							+ intMonth + "']//a[text()='" + intDate + "']");

			this.click(locator);
			if (this.checkElementDisplayed(lblMonth)) {
				// if you have to move next year
				while (yearDiff > 0) {
					if (this.getText(lblYear, "text").equals(year) && this.getText(lblMonth, "text").equals(month)) {
						this.click(lnkDate);
						System.out.println("Select Next Date : " + date);
						blnReturnStatus = true;
						break;
					} else {
						this.click(lnkNext);
					}
				}
				// if you have to move previous year
				while (yearDiff < 0) {
					if (this.getText(lblYear, "text").equals(year) && this.getText(lblMonth, "text").equals(month)) {
						this.click(lnkDate);
						System.out.println("Select Previous Date : " + date);
						blnReturnStatus = true;
						break;
					} else {
						this.click(lnkPrev);
					}
				}
				// when date is in current year
				while (yearDiff == 0) {
					// if we have to move previous month
					if (monthDiff <= 0) {
						if (this.getText(lblYear, "text").equals(year)
								&& this.getText(lblMonth, "text").equals(month)) {
							this.click(lnkDate);
							System.out.println("Select Previous Date : " + date);
							blnReturnStatus = true;
							break;
						} else {
							this.click(lnkPrev);
						}
					} else if (monthDiff > 0) {
						// if we have to move next month
						if (this.getText(lblYear, "text").equals(year)
								&& this.getText(lblMonth, "text").equals(month)) {
							this.click(lnkDate);
							System.out.println("Select Next Date : " + date);
							blnReturnStatus = true;
							break;
						} else {
							this.click(lnkNext);
						}
					}
				}

			}
			return blnReturnStatus;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Select Date Picker failed");
			return false;
		}
	}

	public void scrollToDownWithoutLocator(String strDownVal) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("window.scrollBy(0," + strDownVal + ")");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void scrollToUpWithoutLocator(String strDownVal) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("window.scrollBy(0," + strDownVal + ")");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean setDateForSFDC(By locator, String strDate) {

		try {

			By locatorNextMonth = By
					.xpath("//a[@title='Go to next month']/span[text()='Go to next month']/parent::a[1]");
			By locDatePickerOpen = By
					.xpath("//div[@class='visible DESKTOP uiDatePicker--default uiDatePicker oneOne']");
			By locSelectDate = By
					.xpath("//div[@class='uiDatePickerGrid--default uiDatePickerGrid']//tr/td[@class='uiDayInMonthCell']/span[text()='"
							+ strDate + "']");

			this.click(locator);
			this.checkElementDisplayed(locDatePickerOpen);
			objPojo.getObjUtilities().logReporter("Verify date picker popup is opened.",
					this.checkElementDisplayed(locDatePickerOpen));
			this.checkElementDisplayed(locatorNextMonth);
			objPojo.getObjUtilities().logReporter("click 'Next Month' icon on calender popup.",
					this.click(locatorNextMonth));
			this.checkElementDisplayed(locSelectDate);
			objPojo.getObjUtilities().logReporter("set date on datepicker ", strDate, this.click(locSelectDate));

			return true;

		} catch (Exception exception) {

			System.out.println("Exception ERROR ---> " + exception.getMessage());
			exception.printStackTrace();

			return false;
		}
	}

	public boolean navigateToURL() {
		try {
			objPojo.getDriver().navigate().to("https://salefish.salefishonline.com/");
			objPojo.getObjUtilities().logReporter("navigate to URL on login page", true);
			return true;

		} catch (Exception exception) {
			exception.getMessage();
			return false;

		}

	}

	public boolean getUrl(String strUrl) {
		try {
			objPojo.getDriver().get(strUrl);
			objPojo.getObjUtilities().logReporter("open new URL ", true);
			return true;

		} catch (Exception exception) {
			exception.getMessage();
			return false;

		}

	}

	/* Vaibhav */
	public void refreshWebPage() {

		objPojo.getDriver().navigate().refresh();

	}

	/* vaibhav */
	public boolean waitForMinutes(int timeUnitMinutes) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitMinutes, TimeUnit.MINUTES));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/* vaibhav */
	public static void selectDropDownLotNumber(WebElement ele, String strDropDownOption) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(strDropDownOption);

	}

	public String removedNonNumericCharFromString(String strStringValue) {
		try {
			String regex = "[^0-9]";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(strStringValue);
			String strNumber = matcher.replaceAll("");
			;
			System.out.println("Removed Non Numeric Char : " + strNumber);
			return strNumber;
		} catch (Exception exception) {
			System.out.println("get Exception : " + exception.getMessage());
			return null;
		}

	}

	public void waitForWeAreCreatingDocumentToDisappear() {
		int counter = 1;
		By spinnerLoaderLocator = By.xpath("//h4[contains(.,'Just a moment please...')]");

		if (objPojo.getObjWrapperFunctions().checkElementVisibile(spinnerLoaderLocator)) {

			while (objPojo.getObjWrapperFunctions().checkElementVisibile(spinnerLoaderLocator)) {

				counter++;
				System.out.println("Counter--> " + counter);
				if (objPojo.getObjWrapperFunctions().checkElementInVisibile(spinnerLoaderLocator)) {

					objPojo.getObjUtilities().logReporter("Verify We are creating document now!   ... is disappeared",
							true);
					break;
				} else {
					objPojo.getObjWrapperFunctions().waitFor(3);
					objPojo.getObjWrapperFunctions().checkElementVisibile(spinnerLoaderLocator);
					objPojo.getObjUtilities().logReporter("Verify Processing... is appeared", "waiting for 30 sec",
							true);
				}
			}

			objPojo.getObjUtilities().logReporter("Verify Processing... is disappeared", true);

		}

	}

	// random string generation
	public String getRandomStrings(int length) {
		String strValue = "QWERTYUIOPASDFGHJKLZXCVBNM";

		String randomString = "";
		for (int index = 0; index < length; index++) {
			int rnum = (int) Math.floor((Math.random() * strValue.length()));
			randomString += strValue.substring(rnum, rnum + 1);
		}
		return randomString;
	}

	// date picker
	public boolean datePickerForSH(By locator, String strYear, String strMonth, String strDate) {

		By tblCalendarPopup = By.xpath("//table[@class='ui-datepicker-calendar']");

		By drpMonth = By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']");
		By drpYear = By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']");
		By tblDate = By
				.xpath("//table[@class='ui-datepicker-calendar']//tr//td//following::td//a[text()='" + strDate + "']");

		objPojo.getObjUtilities().logReporter("Click on calendar icon", this.actionClick(locator));
		objPojo.getObjUtilities().logReporter("Verify calendar popup displayed",
				this.checkElementDisplayed(tblCalendarPopup));

		objPojo.getObjUtilities().logReporter("Select year from calendar popup", strYear,
				this.selectDropDownOption(drpYear, strYear, "Text"));

		objPojo.getObjUtilities().logReporter("Select month from calendar popup", strMonth,
				this.selectDropDownOption(drpMonth, strMonth, "Text"));

		objPojo.getObjUtilities().logReporter("Select date from calendar popup", strDate, this.click(tblDate));

		return true;

	}

	public void waitForLoaderToDisappear() {
		int counter = 1;
		By spinnerLoaderLocator = By.xpath(
				"//div[@id='pleaseWaitDialog']//h4[text()='Processing...']/parent::div/div/following-sibling::h6[text()='Please Wait!']");

		if (this.checkElementVisibile(spinnerLoaderLocator)) {

			while (this.checkElementVisibile(spinnerLoaderLocator)) {

				counter++;
				System.out.println("Counter--> " + counter);
				if (this.checkElementInVisibile(spinnerLoaderLocator)) {

					objPojo.getObjUtilities().logReporter("Verify Processing... is disappeared", true);
					break;
				} else {
					this.waitFor(3);
					this.checkElementVisibile(spinnerLoaderLocator);
					objPojo.getObjUtilities().logReporter("Verify Processing... is appeared", "waiting for disappeared",
							true);

					if (counter > 30)
						break;
				}
			}

			objPojo.getObjUtilities().logReporter("Verify Processing... is disappeared", true);

		}

	}

	// Unzip folder

	public List<String> getFileNameFromZipFile(String strZipFileName) {
		ArrayList<String> listOfFileName = null;
		try {
			listOfFileName = new ArrayList<String>();
			ZipFile zipFile = new ZipFile(
					System.getProperty("user.dir") + "/src/test/resources/downloads/" + strZipFileName);
			Enumeration<?> enumration = zipFile.entries();
			while (enumration.hasMoreElements()) {
				ZipEntry zipEntry = (ZipEntry) enumration.nextElement();
				String name = zipEntry.getName();
				long size = zipEntry.getSize();
				long compressedSize = zipEntry.getCompressedSize();
				System.out.printf("File name: %-20s | File size: %6d | compressed size: %6d\n", name, size,
						compressedSize);
				listOfFileName.add(name);
				File file = new File(name);
				if (name.endsWith("/")) {
					file.mkdirs();
					continue;
				}
				File parent = file.getParentFile();
				if (parent != null) {
					parent.mkdirs();
				}
				InputStream inputStream = zipFile.getInputStream(zipEntry);
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				byte[] bytes = new byte[1024];
				int length;
				while ((length = inputStream.read(bytes)) >= 0) {
					fileOutputStream.write(bytes, 0, length);
				}
				inputStream.close();
				fileOutputStream.close();
			}
			zipFile.close();
		} catch (IOException ioException) {
			System.out.println("I got exception : " + ioException.getMessage());
			ioException.printStackTrace();
		}
		return listOfFileName;
	}
	
	// USING AUTO-IT
		public boolean uploadFileFromDownloadSection(String fileNameOnly, String thinkTime) {
			try {
				String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\downloads\\"
						+ fileNameOnly;
				System.out.println("Upload file Path: " + System.getProperty("user.dir")
						+ "\\src\\test\\resources\\downloads\\" + fileNameOnly);
				this.waitFor(5);
				String sys_path = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\";

				Runtime.getRuntime().exec(sys_path + "Fileupload.exe" + " " + filePath);
				waitFor(thinkTime);

				return true;
			} catch (Exception e) {
				objPojo.setCustomException("FileInputOutput Exception");
				e.printStackTrace();
				return false;
			}
		}

		public boolean checkElementNOTDisplayed(By locator) {
			try {
				objSynchronizationUtilities.waitForElementPresence(locator);
				return!(objPojo.getDriver().findElement(locator).isDisplayed());
			} catch (Exception e) {
				// e.printStackTrace();
				return true;
			}
		}
		
	//scroll to column inner scroll
	public boolean scrollToRightInsideWindow(int intRightscroll) {
		try {
			int i = 0;
			while (i < intRightscroll) {
				Actions act = new Actions(objPojo.getDriver());
				objPojo.getObjWrapperFunctions().waitFor(1);
				act.sendKeys(Keys.ARROW_RIGHT).build().perform();
				++i;
			}
			return true;
		} catch (Exception exception) {
			System.out.println("Exception ERROR ---> " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}
	
	public boolean scrollToLeftInsideWindow(int intLeftscroll) {
		try {
			int i = 0;
			while (i < intLeftscroll) {
				Actions act = new Actions(objPojo.getDriver());
				objPojo.getObjWrapperFunctions().waitFor(1);
				act.sendKeys(Keys.ARROW_LEFT).build().perform();
				++i;
			}
			return true;
		} catch (Exception exception) {
			System.out.println("Exception ERROR ---> " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}
	
	public boolean writeTextFileUsingFiles(String strInputTextToWrite,String strTextFilePath) {
		boolean blnFlag = false;
		try {
			List<String> lines = Arrays.asList(strInputTextToWrite);
			Path file = Paths.get(System.getProperty("user.dir")+"/src/test/resources/testData/textFiles/"+strTextFilePath+".txt");
			Files.write(file, lines, Charset.forName("UTF-8"));
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return blnFlag;
		}

	}
	
	public String getTextFileDataUsingFiles(String strTextFilePath){
		try {
			List<String> list =	FileFunctions.readFileIntoList(System.getProperty("user.dir")+"/src/test/resources/testData/textFiles/"+strTextFilePath+".txt");
			String strReadData=list.get(0);
			return strReadData;
		} catch (Exception exception) {
			System.out.println("I got exception  : "+exception.getMessage());
			exception.printStackTrace();
			return null;
		}
	}
	
	public String getLatestScreenshot() {

		String latestFile = "";
		try {
			String downloadFilepath = System.getProperty("user.dir")
					+"/target/surefire-reports/ScreenShot/";
			System.out.println("verify screenshot path : " + downloadFilepath);
			File directoryForDownload = new File(downloadFilepath);
			File[] downloadedFiles = directoryForDownload.listFiles();

			if (downloadedFiles == null || downloadedFiles.length == 0) {
				return "";
			}
			File lastModifiedFile = downloadedFiles[0];
			for (int i = 1; i < downloadedFiles.length; i++) {
				if (lastModifiedFile.lastModified() < downloadedFiles[i].lastModified()) {
					lastModifiedFile = downloadedFiles[i];
				}
			}
			latestFile = lastModifiedFile.getName().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return latestFile;
	}
	
	// date picker
	public boolean datePickerForSHActionClick(By locator, String strYear, String strMonth, String strDate) {
		By tblCalendarPopup = By.xpath("//table[@class='ui-datepicker-calendar']");
		By drpMonth = By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']");
		By drpYear = By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']");
		By tblDate = By
				.xpath("//table[@class='ui-datepicker-calendar']//tr//td//following::td//a[text()='" + strDate + "']");
		objPojo.getObjUtilities().logReporter("Click on calendar icon", this.actionClick(locator));
		objPojo.getObjUtilities().logReporter("Verify calendar popup displayed",
				this.checkElementDisplayed(tblCalendarPopup));
		objPojo.getObjUtilities().logReporter("Select year from calendar popup", strYear,
				this.selectDropDownOption(drpYear, strYear, "Text"));
		objPojo.getObjUtilities().logReporter("Select month from calendar popup", strMonth,
				this.selectDropDownOption(drpMonth, strMonth, "Text"));
		objPojo.getObjUtilities().logReporter("Select date from calendar popup", strDate, this.actionClick(tblDate));

		return true;

	}
	

	public boolean verifyListIsDescendingOrNotForStringType(List<String> verifyList) {
		boolean sorted = false;
		try {
			List<String> tmpList = new ArrayList<String>(verifyList);
			Collections.sort(tmpList, Collections.reverseOrder());
			return tmpList.equals(verifyList);

		} catch (Exception exception) {
			System.out.println("I got exception : " + exception.getMessage());
			exception.printStackTrace();
			return sorted;
		}
	}

	public boolean verifyListIsAscendingOrNotForStringType(List<String>verifyList){
		boolean sorted=false;
		try {
			List<String> tmpList = new ArrayList<String>(verifyList);
			Collections.sort(tmpList);
			return tmpList.equals(verifyList);
			
		} catch (Exception exception) {
			System.out.println("I got exception : "+exception.getMessage());
			exception.printStackTrace();
			return sorted;
		}
	}
	
	public boolean verifyListIsDescendingOrNot(List<Integer>verifyList){
		boolean sorted=false;
		try {
			List<Integer> tmpList = new ArrayList<Integer>(verifyList);
			Collections.sort(tmpList, Collections.reverseOrder());
			return tmpList.equals(verifyList);
			
		} catch (Exception exception) {
			System.out.println("I got exception : "+exception.getMessage());
			exception.printStackTrace();
			return sorted;
		}
	}
	
	public boolean verifyListIsAscendingOrNot(List<Integer> verifyList) {
		boolean sorted = false;
		try {
			List<Integer> tmpList = new ArrayList<Integer>(verifyList);
			Collections.sort(tmpList);
			return tmpList.equals(verifyList);

		} catch (Exception exception) {
			System.out.println("I got exception : " + exception.getMessage());
			exception.printStackTrace();
			return sorted;
		}
	}
	
	public boolean copyTheText() {
		try {
			Actions actions = new Actions(objPojo.getDriver());
			actions.keyDown(Keys.CONTROL);
			actions.sendKeys("a");
			actions.keyUp(Keys.CONTROL);
			actions.build().perform();
			actions.keyDown(Keys.CONTROL);
			actions.sendKeys("c");
			actions.keyUp(Keys.CONTROL);
			actions.build().perform();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}

	}

	public boolean pasteTheText() {
		try {
			Actions actions = new Actions(objPojo.getDriver());
			actions.keyDown(Keys.CONTROL);
			actions.sendKeys("v");
			actions.keyUp(Keys.CONTROL);
			actions.build().perform();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public String getRandomNumber(int length) {
		String strValue = "764";

		String randomString = "";
		for (int index = 0; index < length; index++) {
			int rnum = (int) Math.floor((Math.random() * strValue.length()));
			randomString += strValue.substring(rnum, rnum + 1);
		}
		return randomString;
	}
	public boolean shiftFocusAtDesiredPoint(By locator) {
		try {
			WebElement webelement = objPojo.getDriver().findElement(locator);		
	        new Actions(objPojo.getDriver()).moveToElement(webelement).perform();
	        return true;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}	
	}

	public boolean isElementDisplayedForRedirectPage(By locator) {
		try {
			objSynchronizationUtilities.waitForElementVisibilityLocated(locator);
			objSynchronizationUtilities.setHighlight(objPojo.getDriver().findElement(locator));
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

	// date picker
	public boolean datePickerForSHWithoutClick(By locator, String strYear, String strMonth, String strDate) {

		By tblCalendarPopup = By.xpath("//table[@class='ui-datepicker-calendar']");

		By drpMonth = By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']");
		By drpYear = By.xpath("//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']");
		By tblDate = By
				.xpath("//table[@class='ui-datepicker-calendar']//tr//td//following::td//a[text()='" + strDate + "']");

		objPojo.getObjUtilities().logReporter("Verify calendar popup displayed",
				this.checkElementDisplayed(tblCalendarPopup));

		objPojo.getObjUtilities().logReporter("Select year from calendar popup", strYear,
				this.selectDropDownOption(drpYear, strYear, "Text"));

		objPojo.getObjUtilities().logReporter("Select month from calendar popup", strMonth,
				this.selectDropDownOption(drpMonth, strMonth, "Text"));

		objPojo.getObjUtilities().logReporter("Select date from calendar popup", strDate, this.click(tblDate));

		return true;

	}
	public boolean scrollToBottomInsideWindow(int intBottomscroll) {
		try {
			int i = 0;
			while (i < intBottomscroll) {
				Actions act = new Actions(objPojo.getDriver());
				objPojo.getObjWrapperFunctions().waitFor(1);
				act.sendKeys(Keys.ARROW_DOWN).build().perform();
				System.out.println("Scroll is done by :"+i);
				++i;
			}
			return true;
		} catch (Exception exception) {
			System.out.println("Exception ERROR ---> " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}
	//Package Creation
	public boolean writeTextFileUsingFilesUsingList(List<String> strInputTextToWrite,String strTextFilePath) {
        boolean blnFlag = false;
        try {
            List<String> lines = strInputTextToWrite;
            Path file = Paths.get(System.getProperty("user.dir")+"/src/test/resources/testData/textFiles/"+strTextFilePath+".txt");
            Files.write(file, lines, Charset.forName("UTF-8"));
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return blnFlag;
        }
   }
	public String getTextByUsingJavaScripts(By locator) {
		String strText = "";
		try {
			objSynchronizationUtilities.waitForElementPresence(locator);
			objSynchronizationUtilities.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = objPojo.getDriver().findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			strText=(String) js.executeScript("return arguments[0].innerHTML;",objPojo.getDriver().findElement(locator));
		} catch (NoSuchElementException exception) {
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (TimeoutException exception) {
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (NotFoundException exception) {
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotVisibleException exception) {
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (ElementNotInteractableException exception) {
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return null;
		} catch (Exception exception) {
			System.out.println("NoSuchElement Exception");
			exception.printStackTrace();
			return null;
		}
		return strText;
	}
	public boolean setResolutionByJavaScriptExecutor(){
		 try {
			 JavascriptExecutor executor = (JavascriptExecutor)objPojo.getDriver();
			// executor.executeScript("document.body.style.zoom = '"+intResolutionInPoint+"'");   
			 executor.executeScript("document.body.style.zoom = 0.6");    	
			 return true;	
		 }
		 catch (Exception exception) {
			 objPojo.setCustomException("NotFound Exception");
				System.out.println("I got timeout " + exception.getMessage());
				exception.printStackTrace();
				return false;	
			}
       
   }



}