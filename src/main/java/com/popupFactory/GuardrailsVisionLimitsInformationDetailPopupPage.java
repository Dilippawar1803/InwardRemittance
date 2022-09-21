package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class GuardrailsVisionLimitsInformationDetailPopupPage {
	// Global Variables
	private Pojo objPojo;

	public GuardrailsVisionLimitsInformationDetailPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrPopupPage = By.xpath("//span[contains(text(),'Guardrails - Vision Limits Information Detail')]");
	By loc_btnSave = By.xpath(
			"//span[contains(text(),'Guardrails - Vision Limits Information Detail')]/parent::div/following-sibling::div//button[text()='Save']");
	By loc_btnClose = By.xpath("//span[contains(text(),'Guardrails - Vision Limits Information Detail')]/parent::div//span[text()='close']");
	
	public void verifyGuardrailsVisionLimitsInformationDetailPopupHeaderIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify 'Guardrails - Vision Limits Information Detail' popup header is displayed.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrPopupPage));
	}

	public void deselectBenefitServiceCodeCheckbox(String strBenefitServiceCode) {
		By locator = By.xpath("//td[text()='" + strBenefitServiceCode + "']/preceding-sibling::td/input");
		objPojo.getObjUtilities().logReporter(
				"Verify user can remove " + strBenefitServiceCode + " service from Vision Service List",
				objPojo.getObjWrapperFunctions().selectCheckBox(locator, false));
	}

	public void clickOnSaveButtonOnGuardrailsVisionLimitsInformationDetailPopupPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on save button on Guardrails - Vision Limits Information Detail popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	public void verifyServiceMappedToLimitDescription(String strColIdColumnName, String strAutopopulatedValue) {
		By locator = By.xpath(
				"//div[@col-id='" + strColIdColumnName + "']//child::span[text()='" + strAutopopulatedValue + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify " + strAutopopulatedValue + " service mapped to Limit Description",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnPlusIconFromRepeaters(String strRepeaterName) {
		By locator = By.xpath("//div[text()='" + strRepeaterName
				+ "']//parent::div//following-sibling::td/child::span[contains(@class,'ui-icon ui-icon-plus')]");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on plus icon on '"+strRepeaterName+"' repeater",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyServiceRemovedfromVisionServiceList(String strColIdColumnName, String strAutopopulatedValue) {
		By locator = By.xpath(
				"//div[@col-id='" + strColIdColumnName + "']//child::span[text()='" + strAutopopulatedValue + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify " + strAutopopulatedValue + " service removed from vision service list",
				!objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnCloseButtonOnGuardrailsVisionLimitsInformationDetailPopupPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on close button on 'Guardrails - Vision Limits Information Detail' popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnClose));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void selectBenefitServiceCodeCheckbox(String strBenefitServiceCode) {
		By locator = By.xpath("//td[text()='" + strBenefitServiceCode + "']/preceding-sibling::td/input");
		if (!objPojo.getObjWrapperFunctions().isCheckBoxSelected(locator)) {
			objPojo.getObjUtilities().logReporter(
					"Verify user can select " + strBenefitServiceCode + " service from Vision Service List",
					objPojo.getObjWrapperFunctions().click(locator));
		}

	}

}
