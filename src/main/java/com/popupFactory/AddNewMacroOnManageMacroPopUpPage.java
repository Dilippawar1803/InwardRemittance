package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddNewMacroOnManageMacroPopUpPage {

	// Global Variables
	private Pojo objPojo;

	public AddNewMacroOnManageMacroPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_btnSave = By
			.xpath("(//label[text()='Is Public']//following::input)[1]//following::div//child::button[text()='Save']");
	By loc_dropdownVersion = By.xpath("//select[@id='macroVersion']");
	By loc_dropdownDesign = By.xpath("//select[@id='macroDesign']");
	By loc_inputMacroName = By.xpath("//input[@id='macroName'][@type='text']");
	By loc_inputNotes = By.xpath("//div/textarea[@id='macroNotes']");
	By loc_chkBoxIsPublic = By.xpath("(//label[text()='Is Public']/parent::div//input)[1]");
	By loc_chkBoxFtCheck = By.xpath("//div[@id='divMacroFTCheck']//label[text()='FT Check']/parent::div//input");
	By loc_chkBoxCopyNetworks = By.xpath("//div[@id='divMacroCopyNetworks']//label[text()='Copy Networks']/parent::div//input");
	By loc_btnCloseInAddMacro=By.xpath("//span[text()='Add Macro']//ancestor::div/a/span[text()='close']");
	public void verifyHeaderOfManageMacro(String strHeader) {
		By locator = By.xpath("//span[text()='" + strHeader + "']");
		objPojo.getObjUtilities().logReporter("Verify Header of Add Macro Popup ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public String enterMacroNameInInputBoxOnAddMacroPopupPage(String strMacroName) {
		String strRandomMacroName;
		strRandomMacroName = strMacroName + objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Verify user can enter macro name",
				objPojo.getObjWrapperFunctions().setText(loc_inputMacroName, strRandomMacroName));
		return strRandomMacroName;
	}

	public String enterNotesInInputBoxOnAddMacroPopupPage(String strNotes) {
		String strRandomMacroNotes;
		strRandomMacroNotes = strNotes + objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Verify user can enter notes in notes field",
				objPojo.getObjWrapperFunctions().setText(loc_inputNotes, strRandomMacroNotes));
		return strRandomMacroNotes;
	}

	public void selectDesignFromDropdown(String strDesignName) {
		objPojo.getObjUtilities().logReporter("Verify user can select '" + strDesignName + "' from  Design dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_dropdownDesign, strDesignName, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownDesign);
	}

	public void selectVersionOptionFromDropdown(String strSelectVersion) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Verify user can select '" + strSelectVersion + "' from  Design dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_dropdownVersion, strSelectVersion, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownVersion);
	}

	public void clickOnMacroCheckboxOnAddMacroPopupPage(String strCheckboxName) {
		By locator = By.xpath("(//label[text()='" + strCheckboxName + "']//following::input)[1]");
		objPojo.getObjUtilities().logReporter("Verify " + strCheckboxName + " macro checkbox is checked ",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnSaveButton() {
		objPojo.getObjUtilities().logReporter("Verify user is click on Save",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSave));
	}

	public String enterMacroNameOnAddMacroPopupPage(String strMacroName) {
		objPojo.getObjUtilities().logReporter("Verify user can enter macro name",
				objPojo.getObjWrapperFunctions().setText(loc_inputMacroName, strMacroName));
		return strMacroName;
	}

	public void verifyUIofAddMacroPopupPage(String strFieldsName) {
		By locator = By.xpath("//div[@id='addMicroDialog']//label[text()='" + strFieldsName + "']");
		objPojo.getObjUtilities().logReporter("Verify Field " + strFieldsName + " is displayed ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyCheckboxofAddMacroPopupPage(String strcheckboxName) {
		By locator = By
				.xpath("//div[@id='addMicroDialog']//label[text()='" + strcheckboxName + "']/parent::div//input");
		objPojo.getObjUtilities().logReporter("Verify Field " + strcheckboxName + " is displayed ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}

	public void verifySaveButton() {
		objPojo.getObjUtilities().logReporter("Verify user is Able to see Save Button On Add Macro Popup Page ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSave));
	}
	
	// 169130

	public void verifyUserCanSeeMacroNameTextBoxOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see macro name textbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputMacroName));

	}

	public void verifyUserCanSeeNotesTextBoxOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Notes textbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputNotes));

	}

	public void verifyUserCanSeeDesignDropDownOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see DropDown Design on Add Macro",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownDesign));

	}

	public void verifyUserCanSeeVersionDropDownOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see DropDown Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownVersion));

	}

	public void verifyUserCanSeeFTCheckCheckBoxOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Ft Check Checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxFtCheck));

	}

	public void verifyUserCanSeeCopyNetworkCheckBoxOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Copy Network Checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxCopyNetworks));

	}

	public void verifyUserCanSeeIsPublicCheckBoxOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see Is Public Checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxIsPublic));

	}

	public void verifyUserCanSeeSaveButtonOnAddMacroPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see save button",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSave));

	}

	public String enterMacroNameInInputBoxWithoutRandomCharactersOnAddMacroPopupPage(String strMacroName) {

		objPojo.getObjUtilities().logReporter("Verify user can enter macro name",
				objPojo.getObjWrapperFunctions().setText(loc_inputMacroName, strMacroName));
		return strMacroName;
	}

	public void clickOnCloseButtonFieldsOfAddMacroPopup() {
		objPojo.getObjUtilities().logReporter("Verify Field close button of For Add Macro Popup",
				objPojo.getObjWrapperFunctions().click(loc_btnCloseInAddMacro));
	}
}
