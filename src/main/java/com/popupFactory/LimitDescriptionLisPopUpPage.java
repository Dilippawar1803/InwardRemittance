package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class LimitDescriptionLisPopUpPage {
	private Pojo objPojo;
	public LimitDescriptionLisPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_plusIcon = By.xpath("//span[contains(text(),'Limit Description List ')]/parent::div/parent::div//span[@class='ui-icon ui-icon-plus']");
	By loc_close = By.xpath("//span[text()='Limit Description List ']/ancestor::div//following-sibling::a[@role='button']/span");
	By loc_Save = By.xpath("(//button[@id='manualDataSourceSaveBtn'])[1]");
	
	
	
	public void clickPlusIconOnDentalClassSelectionPopUpPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_plusIcon));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void clickOnCheckboxOfRepeaterToSelectservice(String strServicseName) {
		By locator = By.xpath(
				"//td[text()='"+strServicseName+"']/preceding-sibling::td/input[@type='checkbox']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		if (objPojo.getObjWrapperFunctions().isCheckBoxSelected(locator) == false) {
			objPojo.getObjUtilities().logReporter("Click on '" + strServicseName + "' checkbox",
					objPojo.getObjWrapperFunctions().click(locator));
			objPojo.getObjWrapperFunctions().waitFor(1);
		} else
			objPojo.getObjUtilities().logReporter("Checkbox of '" + strServicseName + "' already check",
					objPojo.getObjWrapperFunctions().checkElementPresence(locator));
	}


	public void clickOnCloseIcon() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_close);
		objPojo.getObjUtilities().logReporter("Verify user can click on close icon of popup:",
				"User should be able to click on close icon on  Popup page  ",
				"User is able to click on close icon on Popup page",
				objPojo.getObjWrapperFunctions().click(loc_close));
	}
	public void ClickOnSaveButtonOnPopUpDentalLimitDescriptionListPopUpPage(){
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_Save));	
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();

	}
}
