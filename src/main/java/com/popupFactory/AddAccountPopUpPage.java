package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddAccountPopUpPage {

	// Global Variables
	private Pojo objPojo;

	public AddAccountPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrAddAccountWindow = By.xpath("//div[@class='createaccountpopup']/child::div[text()='Add Account']");
	By loc_inpAccountName = By.xpath("//input[@id='accountname']");
	By loc_btnSaveAccount = By.xpath("//button[text()='Save']");
	By loc_btnCancelAccount = By.xpath(
			"//div[@class='createaccountpopup']//form[@class='form-horizontal mt15']//button[contains(text(),'Cancel')]");

	public void verifyAddAccountWindowIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Add Account window is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddAccountWindow));
	}

	public void verifyAccountNameTextBoxisDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Account Name text box is displayed on Add Account Window",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpAccountName));
	}

	public void verifySaveButtonisDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Save button is displayed on Add Account Window",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSaveAccount));
	}

	public void verifyCancelbButtonisDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Cancel button is displayed on Add Account Window",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCancelAccount));
	}

	public String setAddAccountName(String strAccName) {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpAccountName);
		String strRandomKey = objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjUtilities().logReporter("Set Account name on Add account popup",
				"user should able to Set Account name on Add account popup",
				"user is able to Set Account name on Add account popup",
				objPojo.getObjWrapperFunctions().setText(loc_inpAccountName, strAccName + strRandomKey));
		return strAccName + strRandomKey;
	}

	public void clickOnSaveButton() {
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on Add Account Window",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSaveAccount));
	}
}
