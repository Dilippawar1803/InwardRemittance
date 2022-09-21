package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class MySettingsDentalNetworkListPopupPage {
	private Pojo objPojo;

	public MySettingsDentalNetworkListPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrMySettingsDentalNetworkList = By.xpath("//span[text()='My Settings - Dental Network List']");
	
	
	public void verifyMySettingsDentalNetworkListPopupDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify user can See My Settings Dental Network List Popup Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMySettingsDentalNetworkList));
	}
	
	public void verifySettingRepeatersAreDisplayed(String strRepeaterName){
		By loc_hdrSettingRepeater = By.xpath("//div[text()='"+strRepeaterName+"']");
		objPojo.getObjUtilities().logReporter("Verify settings repeater "+strRepeaterName+" displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrSettingRepeater));		
	}

	public void verifyButtonDisplayed(String strButtonName) {
		By loc_hdrSettingRepeater = By.xpath("//button[@id='gridCellDialog"+strButtonName+"Btn' and text()='"+strButtonName+"']");
		objPojo.getObjUtilities().logReporter("Verify buttons are "+strButtonName+" displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrSettingRepeater));
	
	}
	
	public void ClickOnRowDropdownOnLevelSettings(String colIDsettings) {
		By loc_settingRepeater = By.xpath("//div[@class='ag-body-container']//div[@col-id='"+colIDsettings+"']");
		objPojo.getObjUtilities().logReporter("Click on "+colIDsettings+" row",
				objPojo.getObjWrapperFunctions().click(loc_settingRepeater));	
	}

	public void selectValueFromDropdownOnLevelSettings(String strDropdown ,String strDropdownValue ) {
		By loc_settingDropdowns = By.xpath("//select[@id='"+strDropdown+"']");
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strDropdownValue+"' option from dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_settingDropdowns, strDropdownValue, "Text"));		
	}
	public void clickOnSaveOrCancelButton(String strButtonName) {
		By loc_hdrSettingRepeater = By.xpath("//button[@id='gridCellDialog"+strButtonName+"Btn' and text()='"+strButtonName+"']");
		objPojo.getObjUtilities().logReporter("Click on "+strButtonName+" button",
				objPojo.getObjWrapperFunctions().click(loc_hdrSettingRepeater));
	
	}
	public void verifyMySettingsRxNetworkListPopupDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify user can See My Settings Rx Network List Popup Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMySettingsDentalNetworkList));
	}
	
	
}
