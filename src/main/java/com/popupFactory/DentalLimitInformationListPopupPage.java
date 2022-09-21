package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class DentalLimitInformationListPopupPage {
	
	private Pojo objPojo;

	public DentalLimitInformationListPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdr = By.xpath("//span[text()='Dental Limit Information List']");
	By loc_saveButton=By.xpath("(//div[@id='manualDialogBtn']/child::button[text()='Save'])[2]");
	
	public void verifyTheHeaderOfDentalServicePopup(){
		objPojo.getObjUtilities().logReporter("Verify user can see header of dental Limit imformation list popup", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdr));
	}
	
	public String selectDentalLimitCheckBox(String strDentalLimitDescription){
		By loc_checkBox=By.xpath("//td[@aria-describedby='manualGrid_LimitDescription' and text()='"+strDentalLimitDescription+"']/preceding-sibling::td/child::input");
		objPojo.getObjUtilities().logReporter("select check box on Dental Limit list popup",
				"User should able to select check box on Dental Limit list popup",
				"User is able to select check box on Dental Limit list popup", 
				objPojo.getObjWrapperFunctions().click(loc_checkBox));
		return strDentalLimitDescription;		
	}
	public void clickOnSaveButton(){
		objPojo.getObjUtilities().logReporter("click On Save button", objPojo.getObjWrapperFunctions().click(loc_saveButton));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	public void verifySelectedDentalServiceListIsDisplayedOrNot(String strLimitDiscription){
		  By locator=By.xpath("(//div[@col-id='LimitDescription']//child::span[text()='"+strLimitDiscription+"'])[2]");
		  objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		  objPojo.getObjUtilities().logReporter("Verify the selected Dental Limit list is displayed or not",
					"User should able to see the selected Dental Limit Description",
					"User is able to see the selected Dental Limit Description", 
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		  
	  }

}
