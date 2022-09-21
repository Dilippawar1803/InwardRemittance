package com.popupFactory;


import org.openqa.selenium.By;

import com.generic.Pojo;

public class LimitInformationDetailsPopupPage {
	private Pojo objPojo;

	public LimitInformationDetailsPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrLimitInformationDetail = By.xpath("//span[contains(text(),'Limit Information Detail')]");
	By loc_iconClose = By.xpath("//span[text()='Limit Information Detail ']/ancestor::div//following-sibling::a[@role='button']/span");
	By loc_btnClose= By.xpath("//span[contains(text(),'Limit Information Detail')]/ancestor::div//following-sibling::a[@role='button']/span");
	
	public void verifyMedicalLimitsInformationDetailPopupDisplayed(){
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see header of Limits Information Detail popup", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrLimitInformationDetail));
	}
	public void clickOnCloseIcon() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconClose);
		objPojo.getObjUtilities().logReporter("Verify user can click on close icon of popup",
				"User should be able to click on close icon on Limits Information Detail Reapeater Popup  ",
				"User is able to click on close icon on Limits Information Detail Reapeater Popup ",
				objPojo.getObjWrapperFunctions().click(loc_iconClose));
	}
	public void closePopupPage(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnClose);
		objPojo.getObjUtilities().logReporter("Verify user can click on close icon of popup",
				"User should be able to click on close icon on Limits Information Detail Reapeater Popup  ",
				"User is able to click on close icon on Limits Information Detail Reapeater Popup ",
				objPojo.getObjWrapperFunctions().click(loc_btnClose));
		
	}
}
