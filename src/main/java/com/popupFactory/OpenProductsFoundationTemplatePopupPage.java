package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class OpenProductsFoundationTemplatePopupPage {
	private Pojo objPojo;

	public OpenProductsFoundationTemplatePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_drpProductView = By.xpath("//select[@id='documentviewdropdown_0']");
	By loc_chkSelectAll = By.xpath("//input[@type='checkbox' and @id='selectallcheckbox']");
	By loc_btnOpen = By.xpath("//button[text()='Open']");
	By loc_drpProductView2 = By.xpath("//select[@id='documentviewdropdown_1']");

	By loc_drpProductView3 = By.xpath("//select[@id='documentviewdropdown_2']");
	By loc_drpProductView4 = By.xpath("//select[@id='documentviewdropdown_3']");

	/**
	 * Description: Verify user is able to open product
	 */
	public void clickSelectAllCheckboxOnOpenProductsFoundationTemplatePopupPage() {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on Select all checkbox on open foundation template popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_chkSelectAll));
		objPojo.getObjWrapperFunctions().waitFor(2);
	}

	public void clickOpenButtonOnOpenProductsFoundationTemplatePopupPage() {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on Open button on open products foundation template popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnOpen));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void clickOnProductsViewDropdown() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on product view dropdown on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_drpProductView));
	}

	public String getProductName() {
		String strFoundationTemplateFieldValue = "";
		By locator = By.xpath("//div[@class='ag-body-container']//div[@col-id='FormName']//span");
		strFoundationTemplateFieldValue = objPojo.getObjWrapperFunctions().getText(locator, "text");
		return strFoundationTemplateFieldValue;
	}

	/**
	 * Scenario: 149546 Description:Verify Target Folder version number after
	 * performing copy network for Rx product
	 *
	 */
	public void selectProductInPopUp(String strProductName) {
		By locator = By.xpath("//span[text()='" + strProductName + "']//parent::div//parent::div//child::input");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Click on product",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void selectProductInPopUpForFtCheck(String strProductName) {
		// By locator =
		// By.xpath("//span[contains(text(),'"+strProductName+"')]/parent::div/following-sibling::div/span/input");
		// By locator =
		// By.xpath("//span[contains(text(),'"+strProductName+"')]//ancestor::div[@col-id='FormName']//preceding-sibling::div[@col-id='IsIncluded']//descendant::input[@type='checkbox']");
		By locator = By
				.xpath("//span[contains(text(),'" + strProductName + "')]//parent::div//parent::div//child::input");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Click on product",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void selectOneProductInPopUpForFtCheck(String strProductName) {

		By locatorFollowingSibling = By.xpath("//span[contains(text(),'" + strProductName
				+ "')]/parent::div[@col-id='FormName']/following-sibling::div[@col-id='IsIncluded']/span/input");
		By locatorPrecedingSibling = By.xpath("//span[contains(text(),'" + strProductName
				+ "')]//ancestor::div[@col-id='FormName']//preceding-sibling::div[@col-id='IsIncluded']//descendant::input[@type='checkbox']");
		if (objPojo.getObjWrapperFunctions().checkElementDisplayed(locatorPrecedingSibling)) {
			objPojo.getObjWrapperFunctions().actionClick(locatorPrecedingSibling);
			objPojo.getObjUtilities().logReporter(strProductName + " Expected product is selected", true);
			// System.out.println("Preceding Locator:"+locatorPrecedingSibling);
		} else if (objPojo.getObjWrapperFunctions().checkElementDisplayed(locatorFollowingSibling)) {
			objPojo.getObjWrapperFunctions().actionClick(locatorFollowingSibling);
			objPojo.getObjUtilities().logReporter(strProductName + " Expected product is selected", true);
			// System.out.println("Following Locator:"+locatorFollowingSibling);
		} else {
			objPojo.getObjUtilities().logReporter("Test Failed", false);
		}
	}
	

	public void selectProductInPopUpForFtCheck_1(String strProductName) {
		By locator = By.xpath("//span[contains(text(),'" + strProductName
				+ "')]//ancestor::div[@col-id='FormName']//following-sibling::div[@col-id='IsIncluded']//descendant::input[@type='checkbox']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Click on product",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void clickOnProductsViewDropdownView1() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on product view dropdown on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_drpProductView2));
	}

	public void clickOnProductsViewDropdownView2() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on product view dropdown on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_drpProductView3));
	}

	public void clickOnProductsViewDropdownView3() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on product view dropdown on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_drpProductView4));
	}

}
