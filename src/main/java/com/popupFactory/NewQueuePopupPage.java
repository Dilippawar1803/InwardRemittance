package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class NewQueuePopupPage {
	// Global Variables
	private Pojo objPojo;
	
	public NewQueuePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_btnCreateNewQuote = By.xpath("//button[@id='dropdownMenu2']");
	By loc_txtDescription = By.xpath("//label[text()='Queue Description']//following::textarea[@id='queueDescription'][@placeholder='Write description']");
	By loc_btnAddInNewQueuePopup = By.xpath("//label[text()='Queue Description']//following::button[@type='button' and text()='Save and Next']");


	/**
 	 * 
 	 * Scenario: 118217
 	 * Description: Verify The Data For The Medical Target Product After Successful Global Compare And Sync 
 	 */
	
	public void clickOnCreateNewQuoteFromGlobalUpadatesPage() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCreateNewQuote);
		objPojo.getObjUtilities().logReporter("Verify user can click create new Quote from global updates page",
				objPojo.getObjWrapperFunctions().click(loc_btnCreateNewQuote));
	}

	public void verifyHeaderOfPopup(String strLabelName){
		By locator = By.xpath("//div/label[text()='"+strLabelName+"']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can see  header "+strLabelName+"of new Quote from global updates page",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public String enterDescriptionInDescriptionBox(String strDescription) {
		String strRandomDescription;
		strRandomDescription = strDescription+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjUtilities().logReporter("Enter the description "+strDescription+"on new queue Popup page",
				objPojo.getObjWrapperFunctions().setText(loc_txtDescription, strRandomDescription));
		System.out.println("Get the entered description:"+strRandomDescription);
		return strRandomDescription;	
	}
	public void clickOnAddButtonInNewQueuePopupPage(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnAddInNewQueuePopup);
		objPojo.getObjUtilities().logReporter("Verify user can click on Create New button in 'New Queue' popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnAddInNewQueuePopup));
	}
	
	/**
	 * Scenario: 169964
	 * Description: Verify the product search functionality in Global compare and Sync
	 */
	
	public void selectQueueTypeInNewQueuePopupPage(String strQueueType)
	{
		By locator = By.xpath("(//text()[contains(.,'"+strQueueType+"')]//preceding-sibling::input[@class='queueType'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on "+strQueueType+" radio button on new New Queue Popup Page",
				objPojo.getObjWrapperFunctions().click(locator));
	}


}
