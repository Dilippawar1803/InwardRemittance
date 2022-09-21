package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class PackageSyncLogPopupPage {

	// Global Variables
	private Pojo objPojo;

	public PackageSyncLogPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrPackageSyncLog = By.xpath("//div[@class='modal-header']//child::h5[text()='Package Sync Log']");
	By loc_btnClosePackageBuild = By.xpath(
			"//div//following-sibling::div//h5[text()='Package Sync Log']//parent::div//following-sibling::div//div//div//button[contains(text(),'Close')]");

	/**
	 * Scenario: 171457 Description: Verify that user is able to navigate at Package
	 * Sync Log
	 */
	public void verifyThePackageSyncLogHeaderDisplayedAtPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify user can See Package Sync Log Header on portfolio module",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrPackageSyncLog));
	}

	public void VerifyCloseButtonOfPackageSyncLog() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnClosePackageBuild);
		objPojo.getObjUtilities().logReporter("Verify Close button of Package Sync Log tab on portfolio module",
				objPojo.getObjWrapperFunctions().click(loc_btnClosePackageBuild));
	}

	public void clickOnCloseIconOnPackageSyncLog() {
		By locator = By.xpath("(//button//span//i[@class='icons-closeicon'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on close Icon On Package Sync Log tab",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	// Verify Column Text
	public void verifyColumnTextInPackageSyncLogOnPortfolioModule(String strColumnName) {
		By locator = By.xpath("//h5[.='Package Sync Log']//parent::div/following-sibling::div//div[.='" + strColumnName
				+ "'][contains(@class,'Header')]");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify Column Text " + strColumnName + " On portfolio module",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	// Get any Value From Record
	public String getAnyValueFromRecordOfPackageSyncLog(String strColId) {
		By locator = By.xpath(
				"(//h5[.='Package Sync Log']//parent::div/following-sibling::div//div[@row-index='0']//div[@col-id='"
						+ strColId + "'])[1]");
		String strTextValueOfFilterContainer = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get filter container value as '" + strTextValueOfFilterContainer + "' ",
				!strTextValueOfFilterContainer.equals(""));
		return strTextValueOfFilterContainer;
	}

	/**
	 * Scenario: 171491 Description: Verify the columns displayed at Portfolio
	 * Module and filter functionality for all columns
	 */
	public void clickOnFilterIconOnPacakageSyncLogPopUp(int intFilterIndex) {
		By locator = By.xpath(
				"(//h5[text()='Package Sync Log']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body p-0']//span[@class='ag-icon ag-icon-filter'])["
						+ intFilterIndex + "]");
		objPojo.getObjUtilities().logReporter("Click on filter icon on package sync log pop up",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	// Verify Column Text
	public void clickOnColumnTextInPackageSyncLogOnPortfolioModule(String strColumnName) {
		By locator = By.xpath("//h5[.='Package Sync Log']//parent::div/following-sibling::div//div[.='" + strColumnName
				+ "'][contains(@class,'Header')]");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify Column Text " + strColumnName + " On portfolio module",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	// Verify Filtered value
	public void verifyFilteredValueAfterApplyingFilter(String strColumnID, String strFiltredValue) {
		By locator = By.xpath(
				"//h5[.='Package Sync Log']/parent::div/following-sibling::div//div[@row-index='0']//div[@col-id='"
						+ strColumnID + "' and text()='" + strFiltredValue + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see filtered value '" + strFiltredValue + "' on Package sync log tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	// Verify Filtered value with span tag
	public void verifyFilteredValueWithSpanTagAfterApplyingFilter(String strColumnID, String strFiltredValue) {
		By locator = By.xpath(
				"//h5[.='Package Sync Log']/parent::div/following-sibling::div//div[@row-index='0']//div[@col-id='"
						+ strColumnID + "']//span[text()='" + strFiltredValue + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see filtered value '" + strFiltredValue + "' on Package sync log tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

}
