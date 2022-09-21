package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class DentalLimitDescriptionListPopUpPage {
	// Global Variables
	private Pojo objPojo;
	private String strFolderNameRandom = "";

	public DentalLimitDescriptionListPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hrdDentalLimitsDentalLimitDescriptionList = By
			.xpath("//span[contains(text(),'Dental Limit Description List')]");

	By loc_gridOption = By.xpath(
			"//span[contains(text(),'Dental Limit Description List ')]/parent::div/parent::div//following-sibling::div//span[@class='ui-icon ui-icon-plus']");
	By loc_close = By.xpath(
			"//span[text()='Dental Limit Description List ']/ancestor::div//following-sibling::a[@role='button']/span");
	By loc_Save = By.xpath("(//button[@id='manualDataSourceSaveBtn'])[1]");
	By loc_isSelected = By.xpath(
			"//span[contains(text(),'Dental Limits Information Detail ')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox']");
	By loc_plusIcon = By.xpath(
			"//span[contains(text(),'Dental Limits Information Detail ')]/parent::div/parent::div//span[@class='ui-icon ui-icon-plus']");
	By loc_iconFilterBenefitServiceCode = By.xpath(
			"(//div[text()='Benefit Service Code']/ancestor::div/child::div[@id='subGridDialog']/child::div/div/following-sibling::div//following::button/child::span[@class='ag-icon ag-icon-filter'])[1]");
	By loc_plusIconOnLimitDescription = By.xpath(
			"//span[contains(text(),'Dental Limit Description List ')]/parent::div/parent::div//span[@class='ui-icon ui-icon-plus']");

	// -------------------------------------------------------------
	public void clickOnBenefitServiceCodeFilterIcon() {
		objPojo.getObjUtilities().logReporter(
				"Click on filter foundation folder name filter icon on foundation template Page",
				objPojo.getObjWrapperFunctions().click(loc_iconFilterBenefitServiceCode));
	}

	public String searchBenefitServiceCodeOnDentalLimitDescriptionListPopUpPage(String str_serviceCode) {
		By locator = By.xpath("//td[@class='ui-search-input']/child::input[@id='gs_BenefitServiceCode']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can search Benefit Service Code '" + str_serviceCode
						+ "'On Dental Limit Description List PopUp Page",
				"User should be able to search Benefit Service Code '" + str_serviceCode
						+ "' On Dental Limit Description List PopUp Page",
				"User is able to search Benefit Service Code '" + str_serviceCode
						+ "' On Dental Limit Description List PopUp Page",
				objPojo.getObjWrapperFunctions().setText(locator, str_serviceCode));
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(locator, "enter");
		objPojo.getObjWrapperFunctions().waitFor(3);
		return str_serviceCode;
	}

	/**
	 * Scenario : Description: Verify user is able to add Benefit Service Code
	 * in "Dental Limit Information Detail Repeater.
	 */
	public void verifyDentalLimitDescriptionListPopUpPage() {
		objPojo.getObjUtilities().logReporter("verify Dental Limit Description List PopUp Page is displayed.",
				"User should see Dental Limit Description List PopUp Page is displayed.",
				" verify ia able to see Dental Limit Description List PopUp Page is displayed.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hrdDentalLimitsDentalLimitDescriptionList));
	}

	public void clickOnGridOptionAddDentalLimitDescriptionListPopUpPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on plus icon on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_gridOption));

	}

	public void verifyservicseAddededonDentalLimitsInformationDetailReapeaterPopup(String strServiceName) {
		By locator = By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='" + strServiceName + "']");
		objPojo.getObjUtilities().logReporter("verify Servicse is addede '" + strServiceName + "'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void clickOnCloseIcon() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_close);
		objPojo.getObjUtilities().logReporter("Verify user can click on close icon of popup:",
				"User should be able to click on close icon on  Popup page  ",
				"User is able to click on close icon on Popup page", objPojo.getObjWrapperFunctions().click(loc_close));
	}

	public String selectCheckboxforanyBenefitservicecode(String strServicseName) {
		By locator = By.xpath("//td[text()='" + strServicseName + "']/preceding-sibling::td/input[@type='checkbox']");
		objPojo.getObjUtilities().logReporter("Verify user can Select check box on on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		return strServicseName;
	}

	public String selectCheckboxforanyBenefitservicecodeToDeselect(String strServicseName) {
		By locator = By.xpath("//td[text()='" + strServicseName + "']/preceding-sibling::td/input[@type='checkbox']");
		objPojo.getObjUtilities().logReporter("Verify user can Select check box on on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		return strServicseName;
	}

	public void ClickOnSaveButtonOnPopUpDentalLimitDescriptionListPopUpPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_Save));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();

	}

	public void clickPlusIconOnDentalClassSelectionPopUpPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_plusIcon));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void verifyServiceCodeVisibleAsPreselectedOrNot() {
		// By
		// locator=By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='"+strServicseName+"']");
		objPojo.getObjUtilities().logReporter("Verify the Dental service code is Preselected or not",
				"User should able to see the Dental service code is Preselected ",
				"User is able to see the Dental service code is Preselected ",
				objPojo.getObjWrapperFunctions().isCheckBoxSelected(loc_isSelected));

	}

	public void clickOnCheckboxToDeselectPreselectedServiceCodesOnDentalLimitInformationDetailRepeater(int IndexId) {
		By DeselectAll = By
				.xpath("(//span[contains(text(),'Dental Limits Information Detail')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox'])['"
						+ IndexId + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(DeselectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select check box to deselect it.",
				objPojo.getObjWrapperFunctions().click(DeselectAll));
	}

	public void verifyBenifitsLinkedtoLimits(String strServicseName) {
		By locator = By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='" + strServicseName + "']");
		objPojo.getObjUtilities().logReporter("Verify the Dental service code is available ",
				"User should able to see the Dental service code On Limit Information Details ",
				"User is able to see the Dental service code is Limit Information Details ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}

	public void clickOnCheckboxToselectPreselectedServiceCodesOnDentalLimitInformationDetailRepeater(int IndexId) {
		By DeselectAll = By
				.xpath("(//span[contains(text(),'Dental Limits Information Detail')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox'])['"
						+ IndexId + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(DeselectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select check box to deselect it.",
				objPojo.getObjWrapperFunctions().click(DeselectAll));
	}

	public void clickPlusIconOnGuardrailsDentalLimitsInformationDetailPopUpPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_plusIcon));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void clickPlusIconOnDentalLimitDescriptionPopUpPage() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_plusIconOnLimitDescription);
		objPojo.getObjUtilities().logReporter("Verify user can click on plus icon button",
				objPojo.getObjWrapperFunctions().actionClick(loc_plusIconOnLimitDescription));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void verifySelectCheckboxFromGuardrailsDentalLimitsInformationDetailPopUpPageIsCheckedOrNot() {
		By loc_checkBoxSelected = By.xpath("//input[@type='checkbox' and @checked='checked/']");
		By loc_chkSelectService = By.xpath("//input[@type='checkbox' and @name='checkbox_manualGrid']");
		if (objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_checkBoxSelected)) {
			objPojo.getObjWrapperFunctions().click(loc_checkBoxSelected);
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().click(loc_checkBoxSelected);

		} else {
			objPojo.getObjUtilities().logReporter("Click on select checkbox to deselect",
					objPojo.getObjWrapperFunctions().click(loc_chkSelectService));

		}
	}
}
