package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class UpdateProductNamePopUpPage {

	// Global Variables
	private Pojo objPojo;

	public UpdateProductNamePopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_inputBoxUpadteProductName = By.xpath("//input[@placeholder='Enter Document Name']");
	By loc_btnSave = By.xpath("//button[@id='btnUpdatedocname' and text()='Save']");
	By loc_inputBoxUpadtePackageName = By.xpath("//input[@placeholder='Enter Package Name']");

	
	By loc_hdrUpdateProductName = By.xpath("//div[contains(@class,'ui-dialog-titlebar')]/span[text()='Update Product Name']");


	/**
	 * Scenario: 124605 Description: Verify if user can update product name when
	 * copy FT product
	 **/
	
	public void verifyHeaderOfUpdateProductName(String strheaderName) {
		By locator = By.xpath("(//span[text()='" + strheaderName + "'])[2]");
		objPojo.getObjUtilities().logReporter("Verify user can see header " + strheaderName + " of Update Product Name Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public String  enterProductNameInUpdateProductNamePopupPage(String strProductName) {
		String strProductNameRandom = "";
		objPojo.getObjWrapperFunctions().waitFor(3);
		strProductNameRandom = strProductName +"_"+ objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjUtilities().logReporter("Verify user can enter product name '" + strProductNameRandom + "' in input box ",
				objPojo.getObjWrapperFunctions().setText(loc_inputBoxUpadteProductName, strProductNameRandom));
		return strProductNameRandom;
	}

	public void clickOnSaveButtonOnUpdateProductNamePopupPage() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSave);
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on update product name pop up",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSave));
	}

//
	public void verifyUpdateProductNamePopupPage() {
		By loc_UpdateProductName = By.xpath(
				"(//div[@class=ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix]//span[text()='Update Product Name'])");
		objPojo.getObjUtilities().logReporter("Verify user can see cancel button on add new portfolio popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_UpdateProductName));
	}

	public void enterFolderNameInInputBox(String strTextToEnter) {
		By locator = By.xpath("//input[@placeholder='Enter Folder Name']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can enter folder name '" + strTextToEnter + "' in input box ",
				objPojo.getObjWrapperFunctions().setText(locator, strTextToEnter));
	}
	public void clickOnSaveButtonOnEditFolderNamePopUp() {
		By locator = By.xpath("(//button[@id='btnUpdatedocname'and text()='Save'])");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on Update folder name pop up",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyUpdateProductNameFieldIsDisabledAndNotEditable() {
		By locator = By.xpath("//input[@id='txtdocName' and @disabled]");
		objPojo.getObjUtilities().logReporter("Verify The Update Product Name is disabled and not Editable",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnYesButtonWhenWeChangeView(String strMessage) {
		By locator = By.xpath("//p[text()='"+strMessage+"']//ancestor::div[@role='dialog']//descendant::div[@class='ui-dialog-buttonset']//button[text()='Yes']");
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on edit folder name pop up",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}
	
	
	public void verifyUpdateProductNamePopUpDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify user can See Update Product Name Popup Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrUpdateProductName));
	}
	
	public void clearTextOfDocumentNameTextBoxOnUpdatePoductNamePopUp()
	{
		By locator = By.xpath("//label[text()='Document Name']/following-sibling::input");
		objPojo.getObjUtilities().logReporter("Verify user can clear text of document name text box on Update Product Name Popup",
				objPojo.getObjWrapperFunctions().clearText(locator));
	}
	
	public String enterTextonDocumentNameTextBoxOnUpdatePoductNamePopUp(String strNewProductName)
	{
		By locator = By.xpath("//label[text()='Document Name']/following-sibling::input");
		strNewProductName=strNewProductName+objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Verify user can enter text on document name text box on Update Product Name Popup",
				objPojo.getObjWrapperFunctions().setText(locator,strNewProductName ));
		return strNewProductName;
	}
	
	public void clickOnSaveButtonOnUpdatePoductNamePopUp()
	{
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on Update Product Name Popup",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
	}
	
	public String  enterProductNameInUpdatePackageNamePopupPage(String strProductName) {
		String strProductNameRandom = "";
		objPojo.getObjWrapperFunctions().waitFor(3);
		strProductNameRandom = strProductName +"_"+ objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjUtilities().logReporter("Verify user can enter product name '" + strProductNameRandom + "' in input box ",
				objPojo.getObjWrapperFunctions().setText(loc_inputBoxUpadtePackageName, strProductNameRandom));
		return strProductNameRandom;
	}
}
