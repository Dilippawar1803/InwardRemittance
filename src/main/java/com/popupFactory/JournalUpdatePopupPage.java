package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class JournalUpdatePopupPage {
	
	private Pojo objPojo;

	public JournalUpdatePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrJournalUpdatePopup = By.xpath("//div[contains(@class,'ui-dialog-titlebar')]/span[text()='Journal Add']");
	By loc_drpActionRequired = By.xpath("//div[@id='actionDiv']/select");
	By loc_txtboxDescription = By.xpath("//textarea[@id='description']");

	By loc_btnSave = By.xpath("//div[@id='journalEntryAddDialogueDiv']//button[text()='Save']");
	
	public void verifyJournalUpdatePopupDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify user can See Journal Update Popup Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrJournalUpdatePopup));
	}
	
	
	public void selectDropdownOptionFromActionRequired(String strDropdownValue)
	{
		objPojo.getObjUtilities().logReporter("Verify user can select dropdown option '" + strDropdownValue + "' . ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpActionRequired, strDropdownValue, "Text"));
		
	}
	
	public void verifyUserSetTextInDescriptionTextBox(String strDescriptionBoxText)
	{
		objPojo.getObjUtilities().logReporter("Verify User Set Text In Description Text Box",
				objPojo.getObjWrapperFunctions().setText(loc_txtboxDescription, strDescriptionBoxText));
	}
	
	public void verifyUserCanClickOnSaveButton()
	{
		objPojo.getObjUtilities().logReporter("Verify User Can Click On Save Button",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
	}
	
	public void verifyDescriptionInJournalLog(String strDescriptionBoxText){
		By locator=By.xpath("//td[contains(@aria-describedby,'journalGrid_Description') and contains(text(),'"+strDescriptionBoxText+"')]");
		objPojo.getObjUtilities().logReporter("verify user can See the Discription on Journal log ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void verifyFieldPathInJournalLog(String strSectionName){
		By locator=By.xpath("//td[contains(@aria-describedby,'journalGrid_FieldPath') and contains(text(),'"+strSectionName+"')]");
		objPojo.getObjUtilities().logReporter("verify user can See the Field path on Journal log ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

}
