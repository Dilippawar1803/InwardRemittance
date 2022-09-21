package com.popupFactory;

import org.openqa.selenium.By;
import com.generic.Pojo;

public class VisionLimitInformationListPopupPage {
	
	// Global Variables
		private Pojo objPojo;

		public VisionLimitInformationListPopupPage(Pojo pojo) {
			this.objPojo = pojo;
		}

		By loc_hdrVisionLimitInformationList = By.xpath("//span[text()='Vision Limit Information List']");
		By loc_btnSave = By.xpath("(//span[text()='Vision Limit Information List']/parent::div/following-sibling::div//button[text()='Save'])[1]");
		
		public void verifyVisionLimitInformationListPopupPageHeaderIsDisplayed() {
			objPojo.getObjUtilities().logReporter("Verify 'Vision Limit Information List' Popup header is displayed",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrVisionLimitInformationList));
		}
		
		public String selectLimitDescription(String strLimitDescription){
			By locator = By.xpath("//td[text()='"+strLimitDescription+"']/preceding-sibling::td/input");
			objPojo.getObjUtilities().logReporter("Verify user can select check box of ",
					objPojo.getObjWrapperFunctions().selectCheckBox(locator, true));
			return strLimitDescription;
		}
		
		public void clickOnSaveButton(){
			objPojo.getObjUtilities().logReporter("Verify user can click on save button",
					objPojo.getObjWrapperFunctions().actionClick(loc_btnSave));	
			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		}
}
