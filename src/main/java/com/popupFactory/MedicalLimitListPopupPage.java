package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class MedicalLimitListPopupPage {

	// Global Variables
	private Pojo objPojo;

	public MedicalLimitListPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrLimitList = By.xpath("//span[text()='Limit List']");
	By loc_btnSave=By.xpath("//span[text()='Limit List']//following::button[@id='manualDataSourceSaveBtn'][text()='Save']");

	/**
	 * Scenario: 118125
	 * Description: Verify user can select the Limit description at the "Limit List" Repeater
	 */
	public void verifyHeaderOfLimitListPoupPageIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify user can see header of  limit list information popup", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrLimitList));
	}
	public String selectLimitDescriptionCheckBoxFromPopupPage(String strLimitDescription){
		By locator = By.xpath("//td[@aria-describedby='manualGrid_LimitDescription' and text()='"+strLimitDescription+"']/preceding-sibling::td/child::input");
		objPojo.getObjUtilities().logReporter("Verify user can select limit description '"+strLimitDescription+"' from popup page", 
				objPojo.getObjWrapperFunctions().click(locator));
		return strLimitDescription;		
	}
	public void clickOnSaveButton(){
		objPojo.getObjUtilities().logReporter("click On Save button",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void verifySelectedCheckboxOptionValueIsDisplayedForSameColId(String strRepeaterName,String strColumnColId,String strCheckboxOptionSelected,int intRowIndex) {
		By locator = By.xpath("(//span[text()='"+strRepeaterName+"']//parent::td//parent::tr//parent::table//parent::div//preceding-sibling::div//parent::div//parent::div//preceding-sibling::div//child::div[@col-id='"+strColumnColId+"']//child::span[text()='"+strCheckboxOptionSelected+"'])["+intRowIndex+"]");
		objPojo.getObjUtilities().logReporter("Verify user can see the option'"+strCheckboxOptionSelected+"' selected in row ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
}
