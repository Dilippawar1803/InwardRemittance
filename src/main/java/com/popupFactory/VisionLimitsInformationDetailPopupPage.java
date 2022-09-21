package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class VisionLimitsInformationDetailPopupPage {
	// Global Variables
	private Pojo objPojo;

	public VisionLimitsInformationDetailPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrPopupPage = By.xpath("//span[contains(text(),'Vision Limits Information Detail')]");
	By loc_btnClose = By.xpath("//span[contains(text(),'Vision Limits Information Detail')]/parent::div//span[text()='close']");
	
	public void verifyVisionLimitsInformationDetailPopupHeaderIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify 'Vision Limits Information Detail' popup header is displayed.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrPopupPage));
	}
	
	public void verifyServiceMappedToLimitDescription(String strColIdColumnName, String strAutopopulatedValue) {
		By locator = By.xpath(
				"//div[@col-id='" + strColIdColumnName + "']//child::span[text()='" + strAutopopulatedValue + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify " + strAutopopulatedValue + " service mapped to Limit Description",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnCloseButtonOnVisionLimitsInformationDetailPopupPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on close button on 'Vision Limits Information Detail' popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnClose));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
}
