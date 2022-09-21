package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddDesginPopUpPage {
	
	// Global Variables
	private Pojo objPojo;

	public AddDesginPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrAddDesignPopUp = By.xpath("//span[text()='Add Design']");
	By loc_inpDesignName = By.xpath("//label[text()='Design Name:']/following::input[@id='formdesignname']");
	By loc_chkboxIncludeInMDM = By.xpath("//label[text()='Include in MDM ?:']/following::input[@id='IsFlagMDM']");
	By loc_txtboxMDMSchemaNameDisabled = By.xpath("//input[@id='mdmschemaname' and @disabled]");
	By loc_txtboxMDMSchemaName = By.xpath("//input[@id='mdmschemaname']");
	By loc_btnSaveAddDesignPopUp = By.xpath("//div[@id='formdesigndialog']//button[text()='Save']");
	By loc_chkBoxIncludeInMDM = By.xpath("//input[@id='IsFlagMDM' and @placeholder='Include in MDM ?' ]");
	public void verifyAddDesignPopUpIsDisplayed()
	{
		objPojo.getObjUtilities().logReporter("Verify Add Design Pop Up is displayed", objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddDesignPopUp));
	}
	
	public String setDesignNameOnAddDesignPopUp(String strDesignName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpDesignName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjUtilities().logReporter("Set Design name on Add Design popup",
				"user should able to Set Design name on Add Design popup",
				"user is able to Set Design name on Add Design popup",
				objPojo.getObjWrapperFunctions().setText(loc_inpDesignName, strDesignName+strRandomKey));
		return strDesignName+strRandomKey;
	}
	//label[text()='Include in MDM ?:']/following::input[@id='IsFlagMDM']
	public void clickOnIncludeInMDMCheckboxOnAddDesignPopUp()
	{
		objPojo.getObjUtilities().logReporter("Verify user can click on check box 'Include in MDM?'",
				objPojo.getObjWrapperFunctions().click(loc_chkboxIncludeInMDM));
	}
	
	public void checkMDMSchemaNameTextBoxIsDisabledWhenIncludeInMDMCheckboxIsNotSelected()
	{
		objPojo.getObjUtilities().logReporter("Verify MDM Schema Name text box is disabled when Include in MDM checkbox is not selected",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtboxMDMSchemaNameDisabled));
	}
	
	public String setMDMSchemaNameOnAddDesignPopUp(String strMDMSchemaName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtboxMDMSchemaName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Set MDM Schema name on Add Design popup",
				"user should able to Set MDM Schema name on Add Design popup",
				"user is able to Set MDM Schema name on Add Design popup",
				objPojo.getObjWrapperFunctions().setText(loc_txtboxMDMSchemaName, strMDMSchemaName+strRandomKey));
		return strMDMSchemaName+strRandomKey;
	}
	
	public void clickOnSaveOnAddDesignPopUp()
	{
		objPojo.getObjUtilities().logReporter("Verify user can click on save on Add Design Pop up",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSaveAddDesignPopUp));
	}
	
	/*
	 * Scenario: 170081 
	 * Description: Verify that MDM Schema Added with unique MDM Schema name 
	 * 
	 */
	
	public String setUserCreatedMDMSchemaNameOnAddDesignPopUp(String strMDMSchemaName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtboxMDMSchemaName);
		objPojo.getObjUtilities().logReporter("Set MDM Schema name on Add Design popup",
				"user should able to Set MDM Schema name on Add Design popup",
				"user is able to Set MDM Schema name on Add Design popup",
				objPojo.getObjWrapperFunctions().setText(loc_txtboxMDMSchemaName, strMDMSchemaName));
		return strMDMSchemaName;
	}
	
	public void verifyErrorMessageOnAddDesignPopUp(String strErrorMsg)
	{
		By locator = By.xpath("//span[text()='"+strErrorMsg+"']");
		objPojo.getObjUtilities().logReporter("verify user can see "+strErrorMsg+" error message",
				objPojo.getObjWrapperFunctions().click(locator) );
	}

	/*
	 * Scenario: 170110 
	 * Description: verify CheckBox On Add Design Popup for Newly Created Design
	 */
	public void verifyCheckBoxStatusOnAddDesignPopupPage() {
		objPojo.getObjUtilities().logReporter("verify Checkbox status on Add Design popup Page",
				"Checkbox should be selected on Add Design popup Page", "Checkbox is selected on Add Design popup Page",
				objPojo.getObjWrapperFunctions().isCheckBoxSelected(loc_chkboxIncludeInMDM));
	}
	
	public void checkMDMSchemaNameTextBoxIsDisabled() {
		objPojo.getObjUtilities().logReporter("Verify MDM Schema Name text box is disabled",
		"Verify MDM Schema Name text box is disabled '" + "" + "'",
		" MDM Schema Name text box is disabled'" +"" + "'",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtboxMDMSchemaNameDisabled));
		}
}
