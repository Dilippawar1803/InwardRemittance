package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class CopyNetworkIntoPopupPage {

	// Global Variables
	private Pojo objPojo;
	public CopyNetworkIntoPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	//locator
		By hrdOfCopyNetworkInto=By.xpath("//span[contains(@id,'ui-id')][text()='Copy Network Into']");
		By loc_drpSelectFolderType=By.xpath("(//label[text()='Select Folder Type:']/parent::div/descendant::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[2]");
		By loc_drpSelectFolderVersion=By.xpath("(//label[text()='Select Folder Version:']/parent::div/descendant::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[2]");
		By loc_drpCopyFrom = By.xpath("(//label[text()='Select Folder:']/parent::div/descendant::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[2]");
		By loc_drpSelectProduct=By.xpath("(//label[text()='Select Product:']/parent::div/descendant::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[2]");
		By loc_Macro=By.xpath("//label[text()='Select Macro:']/parent::div/descendant::input[contains(@class,'custom-combobox-input ui-widget ui-widget')]");
		By loc_btnSubmit = By.xpath("//button[@type='submit'][contains(.,'Copy')]");
		By loc_btnAdd = By.xpath("//a[@id='btnAdd']");
		By loc_btnCopy = By.xpath("//button[@id='btnCopySave']");
		By loc_btnClose = By.xpath("//span[text()='Copy Network Into']/following-sibling::a/span");
		public void verifyOptionsOrTabsOfCopyNetworkInto(String strOptions)
		{
			By locator=By.xpath("//div[@id='copyNetworks']//child::label[text()='"+strOptions+"']");
			objPojo.getObjUtilities().logReporter("Verify user can see "+ strOptions+"option ",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
		public void verifyHeaderOfCopyNetworkIntoPopup()
		{
			objPojo.getObjUtilities().logReporter("Verify user can see header of Version Management Pop Up", 
	                objPojo.getObjWrapperFunctions().checkElementDisplayed(hrdOfCopyNetworkInto));
		}
		public void verifySourceAndTargetOptions(String strOptions)
		{
			By locator=By.xpath("//div[@id='copyNetworks']//child::div[text()='"+strOptions+"']");
			objPojo.getObjUtilities().logReporter("Verify user can see "+ strOptions+"option ",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
		public String selectFolderTypeOptionFromDropdown(String strSelectFolderType){
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolderType, strSelectFolderType);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderType, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can select folder type dropdown '"+strSelectFolderType+"' ",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderType, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
			return strSelectFolderType;
		}
		
		public String selectFolderFromDropdown(String strFolderName) {
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().setText(loc_drpCopyFrom, strFolderName);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpCopyFrom, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can select folder dropdown '"+strFolderName+"' ",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpCopyFrom, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
			return strFolderName;
		}
		
		public String selectFolderVersionOptionFromDropdown(String strSelectFolderVersion){
			objPojo.getObjWrapperFunctions().waitFor(3);
			objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolderVersion, strSelectFolderVersion);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can select folder version '"+strSelectFolderVersion+"' ",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
			return strSelectFolderVersion;
		}
		
		public String selectProductOptionFromDropdown(String strSelectProduct){
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().setText(loc_drpSelectProduct, strSelectProduct);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can select product '"+strSelectProduct+"' ",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
			return strSelectProduct;
		}
		
		public String selectMacroOptionFromDropdown(String strSelectProduct){
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().setText(loc_Macro, strSelectProduct);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_Macro, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can select Macro '"+strSelectProduct+"' ",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_Macro, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
			return strSelectProduct;
		}
		
		public void selectValueFromSourceOrTargetDropdown(String DropdownName, String strValue){
			By locator=By.xpath("//div[contains(text(),'"+DropdownName+"')]/parent::div/descendant::input");
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().setText(locator, strValue);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(locator, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can Select "+DropdownName+" '"+strValue+"' ",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(locator, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		}
		
		public void clickOnAddButton(){
			By loc_AddButton=By.xpath("//a[contains(.,'Add')]");
			objPojo.getObjUtilities().logReporter("Verify user can click on Add button",
					objPojo.getObjWrapperFunctions().click(loc_AddButton));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		}
		public void clickOnSubmitButtonOnAddProductPopupPage() {
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjUtilities().logReporter("Verify user can click on submit button",
					objPojo.getObjWrapperFunctions().click(loc_btnSubmit));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		}
		
		public void verifyCopyNetworkMassage(String strMassage){
			By locator=By.xpath("//td[contains(.,'"+strMassage+"')]");
			objPojo.getObjUtilities().logReporter("Verify user can see the massage "+strMassage+"",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
		
		
		
		public String verifyMessageFromMessageBoxCopyNetworkSyncForProduct(String strMessage) {
			objPojo.getObjWrapperFunctions().waitFor(6);
			By locator = By.xpath("//td[contains(text(),'" + strMessage + "')]");
			objPojo.getObjUtilities().logReporter("Verify message '" + strMessage + "' is displayed from message box",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
			return strMessage;
		}

		public void clickOnCloseButtonFromMessageBoxCopyNetworkSyncForProduct(String strMessage) {
			By locator = By.xpath(
					"//td[contains(text(),'" + strMessage + "')]/following::button[@type='button' and text()='Close'][1]");
			objPojo.getObjUtilities().logReporter("Verify user can click on close button",
					objPojo.getObjWrapperFunctions().click(locator));
		}

		public void selectProductOptionFromDropdownFirstOtion() {
			objPojo.getObjWrapperFunctions().waitFor(2);
			objPojo.getObjWrapperFunctions().clearText(loc_drpSelectProduct);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "keydown");
			objPojo.getObjWrapperFunctions().waitFor(1);
			objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "keydown");
			objPojo.getObjUtilities().logReporter("Verify user can select product",
					objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "enter"));
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();

		}
		
		
		/**
		 * Scenario: 149655
		 * Description: Verify functionality of Options at 3 Dot menu under product level at Foundation Template
		 */
		
		public void verifyAddOnCopyNetworkIntoPopupPage() {
			objPojo.getObjUtilities().logReporter("Verify user can see add On Copy Network into Popup Page",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnAdd));

		}
		public void verifyCopyButtonOnCopyNetworkIntoPopupPage() {
			objPojo.getObjUtilities().logReporter("Verify user can see copy button On Copy Network into Popup Page",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCopy));

		}
		
		public void clickOnCloseButtonOnCopyNetworkIntoPopupPage() {
			objPojo.getObjUtilities().logReporter("Verify user can click on Close button on Copy Network into Popup Page",
					objPojo.getObjWrapperFunctions().actionClick(loc_btnClose));

		}
		/**
		 * Scenario: 149656
		 * Description: Verify functionality of 
		 * Below Options under product level
		 */
		public void clickOnCloseIconOnCopyNetworkPopup(String strPopupName){
			By locator=By.xpath("//span[contains(text(),'"+strPopupName+"')]/parent::div/descendant::span[contains(@class,'closethick')]");
			objPojo.getObjUtilities().logReporter("Verify user can click on Close button on Copy Network Form/into Popup Page",
					objPojo.getObjWrapperFunctions().actionClick(locator));
		}


}
