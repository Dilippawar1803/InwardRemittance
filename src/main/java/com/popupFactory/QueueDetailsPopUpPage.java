package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class QueueDetailsPopUpPage {
	// Global Variables
	private Pojo objPojo;

	public QueueDetailsPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	public void getAndVerifyProductNameValue(String strColID) {
		By locator = By.xpath("(//div[text()='" + strColID
				+ "']//following::td[@aria-describedby='ftcheckQueueItemsList_ProductName'])");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strgetValue1 = objPojo.getObjWrapperFunctions().getText(locator, "text");

		objPojo.getObjUtilities().logReporter(
				"Verify user can get Value " + strgetValue1 + " of " + strColID + " column name", !strColID.equals(""));

	}

	public void getAndVerifyStatusOfProduct(String strColID) {
		By locator = By.xpath("(//div[text()='" + strColID
				+ "']//following::td[@aria-describedby='ftcheckQueueItemsList_StatusName'])");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strStatus = objPojo.getObjWrapperFunctions().getText(locator, "text");
		objPojo.getObjUtilities().logReporter(
				"Verify user can get Value " + strStatus + " of " + strColID + " column name", !strColID.equals(""));

	}

}
