package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class LogOffPopupPage {
	private Pojo objPojo;

	public LogOffPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	

	 By loc_ConfirmationMassage=By.xpath("//span[text()='Confirm Log Off']/following::p[contains(text(),'Are you sure you want to Log off')]");
 	 By loc_LogOutFromApplication = By.xpath("//div[@class='text-center client-logo']/following::p[contains(text(),'You have been logged off from the application')]");
 	 By loc_eBsUserIcon=By.xpath("//div[@class='pull-right dropdownclick']/child::img");
     By loc_LogOffPopup=By.xpath("//a[contains(@class,'logofflink')]/child::span[text()='Log Off']");
     By loc_logoutConfermationPopup=By.xpath("//span[text()='Confirm Log Off']");
     By loc_iconCloseOfConfirmationPopup=By.xpath("(//span[text()='Confirm Log Off']/following::span[@class='ui-icon ui-icon-closethick'])[1]");
     By loc_eBenefitSyncLogoAtLogoutPage=By.xpath("//div[@class='text-center client-logo']//child::img[@title='eBenefitSync']");
     
     /**
	  *  Scenario: 118161
	  *  Description: Verify the  Log Off button functionality
	  */
	public void clickOneBenefitSyncuserIcon() {
		objPojo.getObjUtilities().logReporter("click on the user icon from Left side menue bar",
				"User should able to click on the user icon from Left side menue bar",
				"User is able to click on the user icon from Left side menue bar",
				objPojo.getObjWrapperFunctions().click(loc_eBsUserIcon));
	}

	public void verifyLogOffPopUp() {
		objPojo.getObjUtilities().logReporter("Verify Log off Popup is displayed by clicking on user icon",
				"User should able to see the log off popup", "User is able to see the log off popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_LogOffPopup));
	}

	public void clickOnLogOffText() {
		objPojo.getObjUtilities().logReporter("click on Log out button", "User should able toclick on Log out button",
				"User is able to click on Log out button", objPojo.getObjWrapperFunctions().click(loc_LogOffPopup));
	}

	public void verifyLogOffConfirmPopup() {
		objPojo.getObjUtilities().logReporter("verify Log out Confirmation popup is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_logoutConfermationPopup));
	}

	public void verifyLogOutConfirmationMassage() {
		objPojo.getObjUtilities().logReporter("verify Log out Confirmation massage is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ConfirmationMassage));
	}

	public void verifyButtonsOnLogOutConfirmationPopup(String strButtonName) {
		By locator = By
				.xpath("(//span[text()='Confirm Log Off']/following::button[text()='" + strButtonName + "'])[1]");
		objPojo.getObjUtilities().logReporter("verify buttons on Log out Confirmation popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void clickOnLogOutConfirmationButton(String strButton) {
		By locator = By.xpath("(//span[text()='Confirm Log Off']/following::button[text()='" + strButton + "'])[1]");
		objPojo.getObjUtilities().logReporter("click on " + strButton + " confirmation button",
				"User should able to click on " + strButton + " confirmation button",
				"User is able to click on " + strButton + " confirmation button",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyUserGetLogOffFromApplication() {
		objPojo.getObjUtilities().logReporter("Verify user is log out from application",
				"User should able to log out from applicationr", "User is able to log out from application",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_LogOutFromApplication));
	}

	public void clickOnCloseIconOnConfirmationPopup() {
		objPojo.getObjUtilities().logReporter("Verify click on close icon On Confirmation Popup",
				objPojo.getObjWrapperFunctions().click(loc_iconCloseOfConfirmationPopup));
	}
	
	public void verifyEBenefitSyncIconIsPresentAtTheLogOffScreen() {
		objPojo.getObjUtilities().logReporter("Verify eBenefitSync Logo is present at the LogOff Screen",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_eBenefitSyncLogoAtLogoutPage));
	}
	public void clickOnEBenefitSyncIconIsPresentAtTheLogOffScreen(){
		objPojo.getObjUtilities().logReporter("Verify user can click on eBenefitSync Logo is present at the LogOff Screen",
				objPojo.getObjWrapperFunctions().click(loc_eBenefitSyncLogoAtLogoutPage));
	}
}
