package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class GuardrailsDentalLimitsInformationDetailPopUpPage {
	// Global Variables
	private Pojo objPojo;

	public GuardrailsDentalLimitsInformationDetailPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrGuardrailsDentalClassSelection = By
			.xpath("//span[contains(text(),'Guardrails - Dental Limits Information Detail ')]");
	By loc_plusIcon = By.xpath(
			"//span[contains(text(),'Guardrails - Dental Limits Information Detail ')]/parent::div/parent::div//span[@class='ui-icon ui-icon-plus']");
	By loc_Save = By.xpath(
			"(//span[contains(text(),'Guardrails - Dental Limits Information Detail ')]/parent::div/following-sibling::div//button[text()='Save'])[1]");
	By loc_btnClose = By.xpath(
			"//span[contains(text(),'Guardrails - Dental Limits Information Detail ')]/parent::div//span[text()='close']");

	/**
	 * Scenario: 120506
	 * 
	 * Description:
	 */
	public void verifyGuardrailsDentalLimitsInformationDetailPopUpHeaderIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Dental Class Selection popup header is displayed.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrGuardrailsDentalClassSelection));
	}

	public void clickPlusIconOnGuardrailsDentalLimitsInformationDetailOnPopUpPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_plusIcon));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void clickOnCheckboxToDeselectPreselectedServiceCodesOnGuardrailDentalLimitInformationDetailRepeater(
			int IndexId) {
		By DeselectAll = By
				.xpath("(//span[contains(text(),'Guardrails - Dental Limits Information Detail')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox'])['"
						+ IndexId + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(DeselectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select check box to deselect it.",
				objPojo.getObjWrapperFunctions().click(DeselectAll));
	}

	public void clickOnSaveButtonOnGuardrailDentalLimitInformationDetailRepeater() {
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_Save));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void verifyServiceAddedToGuardrailsDentalLimitsInformationDetail(String strColIdColumnName,
			String strAutopopulatedValue) {
		By locator = By.xpath(
				"//div[@col-id='" + strColIdColumnName + "']//child::span[text()='" + strAutopopulatedValue + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter(
				"Verify " + strAutopopulatedValue + " service added to Guardrails Dental Limits Information Detail",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyServiceRemovedfromGuardrailsDentalLimitsInformationDetail(String strColIdColumnName,
			String strAutopopulatedValue) {
		By locator = By.xpath(
				"//div[@col-id='" + strColIdColumnName + "']//child::span[text()='" + strAutopopulatedValue + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify " + strAutopopulatedValue + " service removed from vision service list",
				!objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	/**
	 * Scenario: 120512 Description: Verify the services code added against
	 * certain Dental limit in the ML then user should be able to add manually
	 * those in the Existing templates at both guardrail & actual repeater
	 */
	public void clickOnCheckboxToselectServiceCodesOnGuardrailDentalLimitInformationDetailRepeater(int IndexId) {
		By select = By
				.xpath("(//span[contains(text(),'Guardrails - Dental Limits Information Detail')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox'])['"
						+ IndexId + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(select);
		objPojo.getObjUtilities().logReporter("Verify user can click on select check box to select it.",
				objPojo.getObjWrapperFunctions().click(select));
	}

	public String searchBenefitServiceCodeOnGuardrailsDentalLimitsInformationDetailPopupPage(String str_serviceCode) {
		By locator = By.xpath("//td[@class='ui-search-input']/child::input[@id='gs_BenefitServiceCode']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can search Benefit Service Code '" + str_serviceCode
						+ "'Guardrails Dental Limits Information Detail Popup Page'",
				"User should be able to search Benefit Service Code '" + str_serviceCode
						+ "' Guardrails Dental Limits Information Detail Popup Page",
				"User is able to search Benefit Service Code '" + str_serviceCode
						+ "' Guardrails Dental Limits Information Detail Popup Page",
				objPojo.getObjWrapperFunctions().setText(locator, str_serviceCode));
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(locator, "enter");
		objPojo.getObjWrapperFunctions().waitFor(3);
		return str_serviceCode;
	}

	public void clickOnSelectCheckboxFromGuardrailsDentalLimitsInformationDetailToDeselect() {
		By loc_checkBoxSelected = By.xpath("//input[@type='checkbox' and @checked='checked/']");
		By loc_chkSelectService = By.xpath("//input[@type='checkbox' and @name='checkbox_manualGrid']");
		if (objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_checkBoxSelected)) {
			objPojo.getObjWrapperFunctions().click(loc_chkSelectService);
		} else {
			objPojo.getObjUtilities().logReporter("Click on select checkbox to deselect",
					objPojo.getObjWrapperFunctions().click(loc_chkSelectService));

		}
	}

	public String selectCheckboxforAnyBenefitservicecodeToDeselect(String strServicseName) {
		By locator = By.xpath("//td[text()='" + strServicseName + "']/preceding-sibling::td/input[@type='checkbox']");
		objPojo.getObjUtilities().logReporter("Verify user can Select check box on on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		return strServicseName;
	}

	public void clickOnCloseButtonOnGuardrailsDentalLimitsInformationDetailPopupPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on close button on 'Guardrails - Dental Limits Information Detail' popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnClose));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
}
