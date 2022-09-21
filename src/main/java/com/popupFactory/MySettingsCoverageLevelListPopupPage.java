package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class MySettingsCoverageLevelListPopupPage {

	// Global Variables
	private Pojo objPojo;
	public MySettingsCoverageLevelListPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrMySettingsCoverageLevelList = By.xpath("//span[text()='My Settings - Coverage Level List']");

	public void verifyHeaderOfMySettingsCoverageLevelListPageIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify user can see header of  limit list information popup", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMySettingsCoverageLevelList));
	}
	public void clickOnNewRowFromParticularRepeater(String strColId, int intRowIndex) {
		//(//div[@class='ag-body-viewport']//child::div[@col-id='filter'])[1]
		By locator = By.xpath("(//div[@class='ag-body-viewport']//child::div[@col-id='" + strColId + "'])[" + intRowIndex + "]");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on new row from repeater ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}
	public void selectValueFromDropdownOnMySettingsCoverageLevelListPage(String strDropdownValue ) {
		By loc_settingDropdowns = By.xpath("//div[@class='ag-popup-editor']//div//select[contains(@id,'idfilter')]");
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strDropdownValue+"' option from dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_settingDropdowns, strDropdownValue, "Text"));		
	}
	public void clickOnSaveOrCancelButton(String strButtonName) {
		By loc_hdrSettingRepeater = By.xpath("//button[@id='gridCellDialog"+strButtonName+"Btn' and text()='"+strButtonName+"']");
		objPojo.getObjUtilities().logReporter("Click on "+strButtonName+" button",
				objPojo.getObjWrapperFunctions().click(loc_hdrSettingRepeater));

	}
	public void ScrollToViewUntilHeaderDisplayed(String strButtonName) {
		By locator = By.xpath("//button[@id='gridCellDialog"+strButtonName+"Btn' and text()='"+strButtonName+"']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on text '" + strButtonName + "' ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
}
