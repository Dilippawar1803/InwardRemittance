package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class MiscellaneousDeductibleGuardrailPopupPage {

	// Global Variables
	private Pojo objPojo;

	public MiscellaneousDeductibleGuardrailPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrMiscellaneousDeductibleGuardrail = By.xpath("//span[text()='Guardrails - Miscellaneous Deductible List']");
	By loc_hdrMiscellaneousDeductibleList = By.xpath("//span[text()='Miscellaneous Deductible List']");
	By loc_btnSaveMDL=By.xpath("(//button[@id='manualDataSourceSaveBtn'])[2]");
	By loc_btnSave=By.xpath("(//span[contains(text(),'Miscellaneous Deductible List')]/following::button[text()='Save'])[1]");
	By loc_MiscellaneousDeductibleGuardrailCheckbox= By.xpath("//span[text()='Miscellaneous Deductible List']//following::input[@name='checkbox_manualGrid'][1]");

	/**
	 * Scenario: 118205
	 * Description: Verify user can select the Limit description at the "Limit List" Repeater
	 */
	public void verifyHeaderOfMiscellaneousDeductibleGuardrailPoupPageIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify user can see header of  Miscellaneous Deductible Guardrail  popup", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMiscellaneousDeductibleGuardrail));
	}
	public String selectMiscellaneousDeductibleGuardrailCheckBoxFromPopupPage(String strMiscellaneousDeductible){
		By locator = By.xpath("(//input[@id='checkbox_1'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can select Deductible  Types '"+strMiscellaneousDeductible+"' from popup page", 
				objPojo.getObjWrapperFunctions().click(locator));
		return strMiscellaneousDeductible;		
	}
	
	public void verifySelectedCheckboxOptionValueIsDisplayedForSameColId(String strRepeaterName,String strColumnColId,String strCheckboxOptionSelected,int intRowIndex) {
		By locator = By.xpath("(//span[text()='"+strRepeaterName+"']//parent::td//parent::tr//parent::table//parent::div//preceding-sibling::div//parent::div//parent::div//preceding-sibling::div//child::div[@col-id='"+strColumnColId+"']//child::span[text()='"+strCheckboxOptionSelected+"'])["+intRowIndex+"]");
		objPojo.getObjUtilities().logReporter("Verify user can see the option'"+strCheckboxOptionSelected+"' selected in row ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void verifyHeaderOfMiscellaneousDeductibleListPoupPageIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify user can see header of  Miscellaneous Deductible List  popup", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMiscellaneousDeductibleList));
	}
	public String selectMiscellaneousDeductibleListCheckBoxFromPopupPage(String strMiscellaneousDeductibleList){
		By locator = By.xpath("//input[@id='checkbox_1']");
		objPojo.getObjUtilities().logReporter("Verify user can select Deductible  Types '"+strMiscellaneousDeductibleList+"' from popup page", 
				objPojo.getObjWrapperFunctions().click(locator));
		return strMiscellaneousDeductibleList;		
	}
	
	public void clickOnSaveButtonMDL(){
		objPojo.getObjUtilities().logReporter("click On Save button MDL",
				objPojo.getObjWrapperFunctions().click(loc_btnSaveMDL));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	
	/**
	 * Scenario : 118205
	 * Description : Verify the display Functionality of Miscellaneous deductible repeaters
	 */
	public String selectCheckBoxForDiductibleType(String strDeductibleType){
		By locator = By.xpath("(//td[text()='"+strDeductibleType+"']/preceding-sibling::td[@aria-describedby='manualGrid_IsSelect']/child::input)[1]");
		objPojo.getObjUtilities().logReporter("Verify user can select Deductible  Types '"+strDeductibleType+"' from popup page", 
				objPojo.getObjWrapperFunctions().click(locator));
		return strDeductibleType;		
	}
	
	public void verifyDeductibleTypeAddedInReapeterOrNot(String strDeductibleType){
		By locator=By.xpath("//div[@col-id='DeductibleType']/descendant::span[text()='"+strDeductibleType+"']");
		objPojo.getObjWrapperFunctions().waitFor(5);
		objPojo.getObjUtilities().logReporter("Verify user can see the selected Deductible  Types '"+strDeductibleType+"' in reapeter", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnSaveButton(){
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("click On Save button",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	public String clickOnMiscellaneousDeductibleGuardrailCheckbox(String strDeductibleType){
		By loc_deductibleType = By.xpath("//span[text()='Miscellaneous Deductible List']//following::td[@title='"+strDeductibleType+"'][1]");
		if(	objPojo.getObjWrapperFunctions().isCheckBoxSelected(loc_MiscellaneousDeductibleGuardrailCheckbox))
		{
			objPojo.getObjUtilities().logReporter("Verify checkbox selected", 
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_deductibleType));	
		}
		else
		{
			objPojo.getObjUtilities().logReporter("Verify checkbox selected", 
					objPojo.getObjWrapperFunctions().selectCheckBox(loc_MiscellaneousDeductibleGuardrailCheckbox, true));
			objPojo.getObjUtilities().logReporter("Verify deductibleType :'"+strDeductibleType+"'", 
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_deductibleType));
		}
		return strDeductibleType;
	}
}


