package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class CopyMacroPopUpPage {

	// Global Variables
	private Pojo objPojo;

	public CopyMacroPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrCopyMacro = By
			.xpath("//span[text()='Copy Macro']");
	By loc_btnSaveAndEdit = By
			.xpath("//button[text()='Save and Edit']");
	By loc_dropdownVersion = By.xpath("//select[@id='copymacroVersion']");
	By loc_dropdownDesignDisabled = By.xpath("//select[@id='copymacroDesign' and @disabled]");
	By loc_inputMacroName = By.xpath("//input[@id='copymacroName'][@type='text']");
	By loc_inputNotes = By.xpath("//div/textarea[@id='copymacroNotes']");
	By loc_chkBoxFtCheck = By.xpath("//div[@id='copydivMacroFTCheck']//label[text()='FT Check']/parent::div//input");
	By loc_chkBoxCopyNetworks = By.xpath("//div[@id='copydivMacroCopyNetworks']//label[text()='Copy Networks']/parent::div//input");
	By loc_chkBoxIsPublic = By.xpath("(//label[text()='Is Public']/parent::div//input)[2]");
	By 	loc_msgEnterUniqueMacroName = By.xpath("//span[text()='Please Enter Unique Macro Name']");

	By loc_iconClose = By
			.xpath("//span[text()='Copy Macro']/parent::div//span[@class='ui-icon ui-icon-closethick']");
	
	
	public void verifyHeaderOfCopyMacroPopUpPage() {
		
		objPojo.getObjUtilities().logReporter("Verify Header of Copy Macro Popup ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrCopyMacro));
	}

	public void verifyUserCanSeeMacroNameTextBoxOnCopyMacroPopUp() {
		
		objPojo.getObjUtilities().logReporter("Verify user can see macro name textbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputMacroName));
		
	}
	
	public void verifyUserCanSeeNotesTextBoxOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Notes textbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputNotes));

	}
	
	public void verifyUserCanSeeDesignDropDownAsDisabledOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see DropDown Design as disabled",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownDesignDisabled));

	}
	
	public void verifyUserCanSeeVersionDropDownOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see DropDown Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownVersion));

	}
	
	public void verifyUserCanSeeFTCheckCheckBoxOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Ft Check Checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxFtCheck));

	}
	
	public void verifyUserCanSeeCopyNetworkCheckBoxOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Copy Network Checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxCopyNetworks));

	}

	public void verifyUserCanSeeIsPublicCheckBoxOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Is Public Checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxIsPublic));

	}
	
	public void verifyUserCanSeeCloseIconOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see close icon",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconClose));

	}

	public void clickOnSaveAndEditButton() {
		objPojo.getObjUtilities().logReporter("Verify user is click on Save and edit",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSaveAndEdit));
	}
	

	
	public void verifyUserCanNotCopyMacroWithExistingMacroNameOnCopyMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify User gets Message as 'Please Enter Unique Macro Name' while copying macro with existing name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_msgEnterUniqueMacroName));

	}
	
	


	public void verifyUserCanSelectMacroVersionFromCopyMacroPopUpPage(String strMacroVersion) {
		objPojo.getObjUtilities().logReporter(
				"Verify User can select version " + strMacroVersion + " from copy macro pop up page",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_dropdownVersion, strMacroVersion, "text"));
	}
	
	public String enterMacroNameOnAddMacroPopupPage(String strMacroName) {
		String strRandomMacroName;
		strRandomMacroName = strMacroName + objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Verify user can clear existing macro name",
				objPojo.getObjWrapperFunctions().clearText(loc_inputMacroName));
		objPojo.getObjUtilities().logReporter("Verify user can enter macro name",
				objPojo.getObjWrapperFunctions().setText(loc_inputMacroName, strMacroName));
		return strMacroName;
	}
	
	
}
