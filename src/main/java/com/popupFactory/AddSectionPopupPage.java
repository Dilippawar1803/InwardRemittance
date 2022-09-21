package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddSectionPopupPage {
	private Pojo objPojo;

	public AddSectionPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrAddSection=By.xpath("//span[text()='Add Section']");
	By loc_txtAreaSectionName=By.xpath("//label[text()='Section Name']/parent::div/following-sibling::div/child::textarea");
	By loc_txtMDMName=By.xpath("//label[text()='MDM Name']/parent::div/following-sibling::div/child::input");
	By loc_btnAddSectionPopUp=By.xpath("(//button[text()='Add'])[2]");
	By loc_txtAreaFieldName=By.xpath("(//label[text()='Field Name']/following-sibling::textarea)[2]");
	
	public void verifyAddSectionPopupPageIsDisplayed()
	{
		objPojo.getObjUtilities().logReporter("Verify Add Section Pop Up is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddSection));
	}
	
	public String setSectionName(String strSectionName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtAreaSectionName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Set Section Name on Add Section popup",
				"user should able to Set Section name  on Add Section popup",
				"user is able to Set Section name on Add Section popup",
				objPojo.getObjWrapperFunctions().setText(loc_txtAreaSectionName, strSectionName+strRandomKey));
		return strSectionName+strRandomKey;
	}
	
	public String setMDMName(String strMDMName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtMDMName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Set Section Name on Add Section popup",
				"user should able to Set Section name  on Add Section popup",
				"user is able to Set Section name on Add Section popup",
				objPojo.getObjWrapperFunctions().setText(loc_txtMDMName, strMDMName+strRandomKey));
		return strMDMName+strRandomKey;
	}
	
	public void clickOnAddOnAddsectionPopUp()
	{
		objPojo.getObjUtilities().logReporter("Verify user can click on save on Add Design Pop up",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnAddSectionPopUp));
	}
	
	
	
}
