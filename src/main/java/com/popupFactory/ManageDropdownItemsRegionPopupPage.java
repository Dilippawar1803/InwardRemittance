package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class ManageDropdownItemsRegionPopupPage {

	private Pojo objPojo;

	public ManageDropdownItemsRegionPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hrd= By.xpath("//span[contains(text(),'Manage Dropdown Items -Region')]");
	By loc_close = By.xpath("//span[text()='Manage Dropdown Items -Region']/ancestor::div//following-sibling::a[@role='button']/span");

	

public void verifyManageDropdownItemsRegionPopup() {
	objPojo.getObjUtilities().logReporter("verify Manage Dropdown Items Region Popup is displayed.",
			"User should see Manage Dropdown Items Region Popup Popup is displayed.",
			" verify ia able to see Manage Dropdown Items Region Popup Popup is displayed.",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hrd));
}
public String getValuesOfDisplayTextOnManageDropdownItemsRegionPopUpPage()
{
	String DisplayText ="";
	By loc_DisplayTextValues = By.xpath("(//div[text()='Display Text']/parent::th//ancestor::div[@id='gview_dropdownitemsdialoggrid']//following-sibling::div[@class='ui-jqgrid-bdiv']/descendant::tr)[2]/td[2]");
	DisplayText = objPojo.getObjWrapperFunctions().getText(loc_DisplayTextValues,"Text");
	return DisplayText;
	
}
public void clickOnCloseIcon() {
	objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_close);
	objPojo.getObjUtilities().logReporter("Verify user can click on close icon of popup:",
			"User should be able to click on close icon on  Popup page  ",
			"User is able to click on close icon on Popup page",
			objPojo.getObjWrapperFunctions().click(loc_close));
}
}