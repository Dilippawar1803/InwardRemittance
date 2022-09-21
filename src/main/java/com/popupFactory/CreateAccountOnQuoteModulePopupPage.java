package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class CreateAccountOnQuoteModulePopupPage {
	private Pojo objPojo;

	public CreateAccountOnQuoteModulePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrAddAccount = By.xpath("//div[text()='Add Account']");
	By loc_btnClose = By.xpath("(//button[contains(text(),'Close')])[4]");
	By loc_txtAccountName = By.xpath("//label[contains(.,'Account Name*')]");
	By loc_inputEnterAccountName=By.xpath("//input[@id='accountname']");
	By loc_btnSave = By.xpath("(//button[@type='button'][contains(.,'Save')])[1]");

	public void verifyHeaderOfAddAccount(){	 
		objPojo.getObjUtilities().logReporter("Verify Header of Add Account.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddAccount));
	}
	public void verifyAccountNameText(){	   
		objPojo.getObjUtilities().logReporter("Verify Label of Account Name in Create Account.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtAccountName));
	}
	public void verifySaveAndCancelButtonInCreateAccount(String strName){	   
		By locator = By.xpath("(//button[@type='button'][contains(.,'"+strName+"')])[1]");
		objPojo.getObjUtilities().logReporter("Verify Label of Save And Cancel in Create Account.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));  		   
	}

	public String enterNameInAccountName(String strSetAccountName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputEnterAccountName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjUtilities().logReporter("Set Description on Account popup",
				"user should able to Set AccountName on Account popup",
				objPojo.getObjWrapperFunctions().setText(loc_inputEnterAccountName, strSetAccountName+strRandomKey));
		return strSetAccountName+strRandomKey;
	}
	public void clickOnSaveAccount() {
		objPojo.getObjUtilities().logReporter("Verify user can click Save Button  on create account.",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
	}

	public void verifyPopUpMessageOfAccountCreate(String strPopUpMsg){	
		By loc_Message = By.xpath("//div/p[text()='"+strPopUpMsg+"']");
		objPojo.getObjUtilities().logReporter("Verify Popup message display for close",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Message));
	}
	public void clickOnClose() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnClose);
		objPojo.getObjUtilities().logReporter("Verify user can click on Close Button.",
				objPojo.getObjWrapperFunctions().click(loc_btnClose));
	}


}
