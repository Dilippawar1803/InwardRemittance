package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class CorrectiveVersionPopupPage {

	// Global Variables
	private Pojo objPojo;

	public CorrectiveVersionPopupPage(Pojo pojo) 
	{
		this.objPojo = pojo;
	}

	//locators
	By loc_calenderIconCorrectiveVersion=By.xpath("(//div[@id='correctiveVersionDialog']//label[text()='Effective Date']/following::img)[1]");    	
	By loc_btnCreate= By.xpath("//button[@id='btnCreateVersion' and text()='Create']");
	By loc_CorrectiveVersionButton = By.xpath("//button[@id='btnCorrectiveVersionHistory' and text()='Corrective Version']");
	By loc_drpCategory = By.xpath("//select[@id='foldercategoryDDL']");
	By loc_messageFolderVersionSuccefull= By.xpath("//p[contains(text(),'Folder Version created successfully.')]");


	/**
	 * Scenario: 149603
	 *  Description: Test If User can Create Corrective version of folder
	 */
	public void verifyHeaderOfVersionSubPopup(String strHeader)	 {
		 By locator= By.xpath("//span[text()='"+strHeader+"']");
		 objPojo.getObjUtilities().logReporter("Verify user can able to see  header of "+strHeader+" ",
				 objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	 }
	 public void clickOnCalenderIconOnCorrectiveVersion(){
		 objPojo.getObjUtilities().logReporter("Click on calendar icon",
				 objPojo.getObjWrapperFunctions().actionClick(loc_calenderIconCorrectiveVersion));

	 }
	 public void selectEffectiveDateOnMinorVersionPopUpForCorrectiveVersion(String strYear, String strMonth, String strDate) {
		 objPojo.getObjWrapperFunctions().datePickerForSH(loc_calenderIconCorrectiveVersion, strYear, strMonth, strDate);
		 objPojo.getObjUtilities().logReporter(
				 "Select date as '" + strDate + "', month as '" + strMonth + "', year as '" + strYear
				 + "' from calender.",
				 objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_calenderIconCorrectiveVersion));
	 }
	 public void clickOnCreateButtonOnCorrectiveVersion(){
		 objPojo.getObjUtilities().logReporter("Click on Create Button",
				 objPojo.getObjWrapperFunctions().actionClick(loc_btnCreate));
		 objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	 }
	//149621
		 public void selectCategoryFromDropDown(String strCategoryDropDownOption)
			{
				objPojo.getObjUtilities().logReporter("Verify user can select '"+strCategoryDropDownOption+"' from category dropdown",
						objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpCategory, strCategoryDropDownOption, "Text"));
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpCategory);
			}
		 public void verifyMessageForFolderVersionCreatedSuccessfully(String strMessage) {
				objPojo.getObjUtilities().logReporter("Verify folder created successfully",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_messageFolderVersionSuccefull));
			}

	
}
