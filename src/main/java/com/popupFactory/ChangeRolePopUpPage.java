package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class ChangeRolePopUpPage {
	
	// Global Variables
	private Pojo objPojo;
	
	
	public ChangeRolePopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	
	By loc_drpSelectNewUserRole = By
			.xpath("//label[text()='Select New User Role:']/following-sibling::span/select");
	
	By loc_btnSaveOnChangeRole = By.xpath("//span[.='Change Role']/parent::div/following-sibling::div//button[.='Save']");
	By locator_hdrChangeRolePopUpPage = By.xpath("//span[text()='Change Role']");
	
	public void verifyChangeRolePopupPageHeaderIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify 'Change Role' popup page header is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator_hdrChangeRolePopUpPage));
	}

	public void selectDropdownOptionFromSelectNewUserRoleField(String strValue) {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpSelectNewUserRole);
		objPojo.getObjUtilities().logReporter("Veify user can select '"+strValue+"' option from 'Select New User Role' Dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpSelectNewUserRole, strValue,
						"Text"));
	}

	public void clickOnSaveButton() {
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on 'Change Role' PopUp Page",
				objPojo.getObjWrapperFunctions().click(loc_btnSaveOnChangeRole));
	}

	
	 
}
