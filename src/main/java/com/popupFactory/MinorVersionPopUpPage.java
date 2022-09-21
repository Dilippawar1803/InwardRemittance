package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class MinorVersionPopUpPage {

	// Global Variables
	private Pojo objPojo;

	public MinorVersionPopUpPage(Pojo pojo) 
	{
		this.objPojo = pojo;
	}

	//locators
	By loc_iconCalender = By.xpath("//div[@id='minoreffectivedatedialog']//label[text()='Effective Date']/following-sibling::img");
	//By hdrMinorVersionPopUp = By.xpath("//span[@id='ui-id-27' and text()='Minor Version']");
	By hdrMinorVersionPopUp = By.xpath("//span[contains(@id,'ui-id')][text()='Minor Version']");
	By loc_drpCategory = By.xpath("//select[@id='categoryDDL']");
	By btnSave = By.xpath("//button[@id='minoreffectivebtn' and text()='Save']");
	By loc_drpCasacdeChangesOn = By.xpath("//select[@id='CascadeDDL']");
	
	By loc_calenderIconML=By.xpath("(//div[@id='minoreffectivedatedialogML']//label[text()='Effective Date']/following::img)[1]");
	By loc_BtnSaveOnML=By.xpath("//button[@id='minoreffectivebtnML' and text()='Save']");
	By loc_ErrorMsg=By.xpath("//span[contains(text(),'Effective Date should be greater or equal to major Version')]");
	/**
	 * 
	 * Scenario: 118050
	 * Description: Verify if user is able to create a new version from major version
	 */
	

	public void verifyHeaderOfMinorVersionPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see header of Minor version Pop Up", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(hdrMinorVersionPopUp));
	}
	
	
	public void selectEffectiveDateOnMinorVersionPopUp(String strYear, String strMonth, String strDate) {
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconCalender, strYear, strMonth, strDate);
		objPojo.getObjUtilities()
				.logReporter(
						"Select date as '" + strDate + "', month as '" + strMonth + "', year as '" + strYear
								+ "' from calender.",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconCalender));
	}
	
	public void clickOnCalenderIcon()
	{
		objPojo.getObjUtilities().logReporter("Click on calendar icon", objPojo.getObjWrapperFunctions().click(loc_iconCalender));
	}
	
	public void selectCategoryFromdropDown(String strCategoryDropDownOption)
	{
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strCategoryDropDownOption+"' from category dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpCategory, strCategoryDropDownOption, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpCategory);
	}
	
	public void clickOnSaveButton()
	{
		objPojo.getObjUtilities().logReporter("Click on Save Button", objPojo.getObjWrapperFunctions().click(btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void clickOnCalenderIconOnML()
	{
		
		objPojo.getObjUtilities().logReporter("Click on calendar icon", objPojo.getObjWrapperFunctions().actionClick(loc_calenderIconML));
	}
	public void selectEffectiveDateOnMinorVersionPopUpForML(String strYear, String strMonth, String strDate) {
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_calenderIconML, strYear, strMonth, strDate);
		objPojo.getObjUtilities()
				.logReporter(
						"Select date as '" + strDate + "', month as '" + strMonth + "', year as '" + strYear
								+ "' from calender.",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_calenderIconML));
	}
	public void clickOnSaveButtonOnML()
	{
		objPojo.getObjUtilities().logReporter("Click on Save Button", objPojo.getObjWrapperFunctions().actionClick(loc_BtnSaveOnML));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void verifyErrorMessageForEffectiveDate()
	{
		objPojo.getObjUtilities().logReporter("Verify Error message for Effective Date", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ErrorMsg));
	}

	

}
