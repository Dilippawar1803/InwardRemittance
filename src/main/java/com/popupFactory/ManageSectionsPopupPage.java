package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class ManageSectionsPopupPage {
	private Pojo objPojo;

	public ManageSectionsPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrManage=By.xpath("//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/span[contains(text(),'Manage')]");
	By loc_btnAddSection=By.xpath("(//span[@class='ui-icon ui-icon-plus'])[2]");
	public void verifyManageSectionsPopUpIsDisplayed()
	{
		objPojo.getObjUtilities().logReporter("Verify Manage Pop Up page is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrManage));
	}
	
	public void clickOnAddSection(){
		objPojo.getObjUtilities().logReporter("Verify user can click on Add Section",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnAddSection));
	}
	
	public void closeManagesectionPopupPage(String strPageHeader){
		By locator=By.xpath("//span[contains(text(),'"+strPageHeader+"')]/parent::div//a[@class='ui-dialog-titlebar-close ui-corner-all']/child::span[@class='ui-icon ui-icon-closethick']");
		objPojo.getObjUtilities().logReporter("Verify user can close Manage section popup page",
				objPojo.getObjWrapperFunctions().click(locator));
	}
	
}

