package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class VisionServicesListPopupPage {
	// Global Variables
	private Pojo objPojo;

	public VisionServicesListPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrVisionServicesList = By.xpath("//span[text()='Vision Services List']");
	By loc_checkboxSelectAll = By.xpath(
			"//span[text()='VisionServiceList']/parent::div/following-sibling::div//input[@type='checkbox'][@class='check-all']");
	By loc_btnSave = By.xpath(
			"(//span[text()='VisionServiceList']/ancestor::div[contains(@class,'body')]/following-sibling::div/button[text()='Save'])[1]");

	public void verifyVisionServicesListPopupHeaderIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Vision Services List popup header is displayed.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrVisionServicesList));
	}

	public void verifyUserCanSeeSearchTextBox(String strColumnName) {
		By locator = By.xpath("//tr[contains(@class,'search')]//input[@name='" + strColumnName + "']");
		objPojo.getObjUtilities().logReporter("Verify " + strColumnName + " search text box is visible to user",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifySelectAllCheckboxIsVisibleToUser() {
		objPojo.getObjUtilities().logReporter("Verify Select All checkbox is visible to user",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_checkboxSelectAll));
	}

	public void selectVisionServiceNameCheckbox(String strVisionServiceName) {
		By locator = By.xpath("//td[text()='" + strVisionServiceName + "']/preceding-sibling::td/input");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select " + strVisionServiceName + " - Vision Service checkbox",
				objPojo.getObjWrapperFunctions().selectCheckBox(locator, true));
	}

	public void clickOnSaveButtonOnVisionServicesListPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on Vision Services List popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
}
