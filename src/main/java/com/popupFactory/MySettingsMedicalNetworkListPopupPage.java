package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class MySettingsMedicalNetworkListPopupPage {
	private Pojo objPojo;

	public MySettingsMedicalNetworkListPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrMySettingsMedicalNetworkTierList = By.xpath("//span[text()='My Settings - Network Tier List']");
	By loc_okButton=By.xpath("(//button[text()='OK'])[2]");
	
	
	public void verifyMySettingsMedicalNetworkListPopupDisplayed() {
		objPojo.getObjWrapperFunctions().scrollToView(loc_hdrMySettingsMedicalNetworkTierList);
		objPojo.getObjUtilities().logReporter("Verify user can See My Settings Medical Network Tier List Popup Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMySettingsMedicalNetworkTierList));
	}
 
	public void changeFilterColumnValueFromDropdown(String strValue ,String strDropdownValue) {
		By locator=By.xpath("(//span[text()='"+strValue+"'])[1]");
		objPojo.getObjWrapperFunctions().click(locator);
		By locator_1=By.xpath("//div[@class='Dropdown']//select");
		objPojo.getObjWrapperFunctions().click(locator_1);
		objPojo.getObjUtilities().logReporter("User select dropdown with '" + strDropdownValue + "' .",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator_1, strDropdownValue, "Text"));
	}
	
	public void clickOnOkConfermationButton() {
		objPojo.getObjUtilities().logReporter("User able to click on Ok Button",
				objPojo.getObjWrapperFunctions().click(loc_okButton));
		
	}

}
