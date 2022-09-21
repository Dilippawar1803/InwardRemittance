package com.popupFactory;


import org.openqa.selenium.By;

import com.generic.Pojo;

public class SelectSourceProductPopup {
	private Pojo objPojo;
	private String strReturnVal="";
	
	public SelectSourceProductPopup(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrSelectSourceProductPopup = By.xpath("//span[@class='ui-dialog-title' and text()='Select Source Product']");
	By loc_inputFolderNameSearch=By.xpath("//td[@class='ui-search-input']/following::input[@name='FolderName']");
	By loc_gridIconSelect=By.xpath("//span[contains(@class,'ui-icon ui-icon-check')]");
	/** 
	 * Scenario: 118188
	 * Description: Verify Functionality  for generating SOB Collateral
	 */
	public void verifySelectSourceProductPopupPageIsDisplayed(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrSelectSourceProductPopup);
		objPojo.getObjUtilities().logReporter("Verify select source products popup page is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrSelectSourceProductPopup));
	}
	public String searchFolderNameOnSelectSourceProductPopup(String strSetText) {
		objPojo.getObjWrapperFunctions().click(loc_inputFolderNameSearch);
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can Search folder name on select source products popup page",
				objPojo.getObjWrapperFunctions().setText(loc_inputFolderNameSearch, strSetText));
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_inputFolderNameSearch, "Enter");
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strSetText;
	}
	public void clickOnFolderNameOnSelectSourceProductPopup(String strFolderName) {
		By locator = By.xpath("//td[@aria-describedby='docSearch_FolderName' and text()='"+strFolderName+"']");
		objPojo.getObjUtilities().logReporter("click on Folder on Select Source Popup", 
				objPojo.getObjWrapperFunctions().click(locator));
	}
	public void clickOnSelectIconOnSelectSourceProductPopup() {
		objPojo.getObjUtilities().logReporter("click on Select Icon on Select Source Popup",
				objPojo.getObjWrapperFunctions().click(loc_gridIconSelect));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
}
