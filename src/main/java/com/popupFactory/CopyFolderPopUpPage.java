package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class CopyFolderPopUpPage {
	private Pojo objPojo;
	private String strFolderNameRandom = "";
	
	
	public CopyFolderPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
		
	}
	
	By loc_hdrOpencopyfolder=By.xpath("//span[text()='Copy Folder']");
	By loc_inpFolderName= By.xpath("//label[text()='Folder Name']//parent::div//input[@id='folderName']");
    By loc_btnSave = By.xpath("//button[@id='btnFolderDialogSave'][text()='Save & Next']");
    By loc_inpQuoteFolderName= By.xpath("//label[text()='Quote Name']//parent::div//input[@id='folderName']");
    

	/**
	 * 
	 *  Scenario: 
	 *  Description: 
	 */
	public void verifyCopyFolderPopupPageHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify copy folder popup header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrOpencopyfolder));
	}
	public String enterFolderNameOnCopyFolderPopup(String strFolderName){
		strFolderNameRandom=strFolderName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpFolderName);
		objPojo.getObjWrapperFunctions().clearText(loc_inpFolderName);
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjWrapperFunctions().setText(loc_inpFolderName, strFolderNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strFolderNameRandom+"' as package name",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpFolderName));
		return strFolderNameRandom;		
	}
	public void clickOnSaveButtonToSaveCopyFolder(){
		objPojo.getObjUtilities().logReporter("Click on Save Button on confirm pop up",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	public String enterFolderNameOnCopyFolderPopupForQuote(String strFolderName){
		strFolderNameRandom=strFolderName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpQuoteFolderName);
		objPojo.getObjWrapperFunctions().clearText(loc_inpQuoteFolderName);
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjWrapperFunctions().setText(loc_inpQuoteFolderName, strFolderNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strFolderNameRandom+"' as package name",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpQuoteFolderName));
		return strFolderNameRandom;		
	}
	
	
	
	
	
	
	By loc_inpAccountFolderName= By.xpath("//label[text()='Folder Name']//parent::div//input[@id='folderName']");
	public String enterFolderNameOnCopyFolderPopupForAccount(String strFolderName){
	    strFolderNameRandom=strFolderName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
	    objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpAccountFolderName);
	    objPojo.getObjWrapperFunctions().clearText(loc_inpAccountFolderName);
	    objPojo.getObjWrapperFunctions().waitFor(2);
	    objPojo.getObjWrapperFunctions().setText(loc_inpAccountFolderName, strFolderNameRandom);
	    objPojo.getObjUtilities().logReporter("Enter '"+strFolderNameRandom+"' as package name",
	    objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpAccountFolderName));
	    return strFolderNameRandom;      
		
	}
	
	
	
	
	
}



