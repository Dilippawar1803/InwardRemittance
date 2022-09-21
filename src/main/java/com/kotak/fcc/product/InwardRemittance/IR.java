package com.kotak.fcc.product.InwardRemittance;
import org.openqa.selenium.By;

import com.generic.Pojo;

public class IR  {

	// Global Variables
			private Pojo objPojo;
		public IR(Pojo pojo) {
			this.objPojo = pojo;
		}

		By RequestToBankIcon = By.xpath("//img[@title='Request to Bank']");
		By editIcon = By.xpath("//img[@title='Edit']");
		By SearchBox = By.xpath("//input[@aria-label='Search content in table']");
		By EditTransactions = By.xpath("//div[contains(text(),'Edit Transactions')]");
		By Review = By.xpath("//div[contains(text(),'Review')]");
		By record = By.xpath("//tr[@id='rowdata']");
		By filterButton = By.xpath("//div[@id='accordionHeaderId']");
		
		By portalRefId = By.xpath("//input[@id='refId']");
		By custRefId = By.xpath("//input[@id='custRefId']");
		By boRefId = By.xpath("//input[@id='boRefId']");
		By beneficiaryName = By.xpath("//input[@id='nostroNumber']");
		By applicantActNo = By.xpath("//input[@id='remitterName']");
		By counterpartyActNo = By.xpath("//input[@id='counterpartyActNo']");
		By CCY = By.xpath("//span[contains(text(),'CCY')]");
		By status = By.xpath("//span[contains(text(),'Status')]");
		
		By FTInquiry = By.xpath("//a//div[contains(text(),'IR Inquiry')]");
		By imgDetails = By.xpath("//span//img[contains(@id,'DETAIL')]");
		By buttonTransction = By.xpath("//span[contains(text(),'Transaction Flow')]");
		By imgView = By.xpath("//span//img[@title='View']");
		By download = By.xpath("//em[@class='fa fa-file-pdf-o pdfIcon']");
		By pageTile = By.xpath("//div[contains(text(),'DI - Inward Remittance')]");
		  

 
public void verifyAllFeileds(){

                checkEditTransactionsDisplayed();

                checkReviewDisplayed();

                //checkRequestToBankIconDisplayed();

}


public void checkDIInwardRemittanceDisplayed() {
	objPojo.getObjUtilities().logReporter("check DI Inward Remittance Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(pageTile));	
}

public void checkEditTransactionsDisplayed() {
	objPojo.getObjUtilities().logReporter("check Edit Transactions Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(EditTransactions));	
}

public void checkTransactionsReceivedFromNostroUtilityDisplayed() {
	objPojo.getObjUtilities().logReporter("check Transactions Received From Nostro Utility Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(record));	
}
public void checkReviewDisplayed() {
	objPojo.getObjUtilities().logReporter("check Review Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(Review));	
}
public void checkStatusDisplayed() {
	objPojo.getObjUtilities().logReporter("check Status Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(status));	
}


public void clickEditTransactions() {
	objPojo.getObjUtilities().logReporter("click Edit Transactions",
			objPojo.getObjWrapperFunctions().click(EditTransactions));
}

public void clickOnDetails() {
	objPojo.getObjUtilities().logReporter("click On Details",
			objPojo.getObjWrapperFunctions().click(imgDetails));
}
public String  clickOnView() {
	String Url= objPojo.getDriver().getCurrentUrl();
	objPojo.getObjUtilities().logReporter("click On View",
			objPojo.getObjWrapperFunctions().click(imgView));
	return Url;
}
public void clickOnDownload(String windowUrl) {
	objPojo.getObjWrapperFunctions().switchToWindowContainsURL("https://nbuat.kotak.com/trade/portal#/view?tnxid=&referenceid=IR22070000369411&productCode=IR&eventTnxStatCode=&mode=view&operation=PREVIEW&subProductCode=CSTIN");
	objPojo.getDriver().manage().window().maximize();
	objPojo.getObjUtilities().logReporter("click On Download",
			objPojo.getObjWrapperFunctions().click(download));
	objPojo.getObjWrapperFunctions().switchToWindowContainsURL(windowUrl);
}
public void clickOnTransctionButton() {
	objPojo.getObjUtilities().logReporter("click On Transction Button",
			objPojo.getObjWrapperFunctions().click(buttonTransction));
}
public void clickRequestToBankIcon() {
	objPojo.getObjUtilities().logReporter("click Request To BankIcon",
			objPojo.getObjWrapperFunctions().click(RequestToBankIcon));
}
public void clickFilterButton() {
	
	objPojo.getObjUtilities().logReporter("click Filter Button",
			objPojo.getObjWrapperFunctions().click(filterButton));
	objPojo.getObjWrapperFunctions().waitFor(2);
}
public void setSearchBoxValue(String portalRef) {
	objPojo.getObjUtilities().logReporter("Verify user can enter '" + portalRef + "' ",
			objPojo.getObjWrapperFunctions().setText(SearchBox, portalRef));
	
}

public void checkRequestToBankIconDisplayed() {
	objPojo.getObjUtilities().logReporter("check Request To Bank Icon Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(RequestToBankIcon));	
}
public void checkPortalRefIdDisplayed() {
	objPojo.getObjUtilities().logReporter("check Portal RefId Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(portalRefId));	
}
public void checkCustomerReferenceDisplayed() {
	objPojo.getObjUtilities().logReporter("check Customer Reference Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(custRefId));	
}

public void checkMasterReferenceDisplayed() {
	objPojo.getObjUtilities().logReporter("check Master Reference Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(boRefId));	
}

public void checkBeneficiaryNameDisplayed() {
	objPojo.getObjUtilities().logReporter("check Beneficiary Name Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(beneficiaryName));	
}
public void checkApplicantAccountNoDisplayed() {
	objPojo.getObjUtilities().logReporter("check Applicant Account No Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(applicantActNo));	
}

public void checkCounterPartyActNoDisplayed() {
	objPojo.getObjUtilities().logReporter("check Counter Party Act No Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(counterpartyActNo));	
}

public void checkCCYDisplayed() {
	objPojo.getObjUtilities().logReporter("check CCY Displayed",
			objPojo.getObjWrapperFunctions().checkElementDisplayed(CCY));	
}

public void clickFTInquiry() {
	objPojo.getObjUtilities().logReporter("clickFTInquiry",
			objPojo.getObjWrapperFunctions().click(FTInquiry));	
}
public void clickEditIcon() {
	objPojo.getObjUtilities().logReporter("clickFTInquiry",
			objPojo.getObjWrapperFunctions().click(editIcon));	
}
 
public void verifySearchCriteriaTransactions() {

                clickFTInquiry();
                clickFilterButton();
                checkPortalRefIdDisplayed();
                checkCustomerReferenceDisplayed();
                checkBeneficiaryNameDisplayed();
                checkApplicantAccountNoDisplayed();
                checkStatusDisplayed();
                checkCCYDisplayed();

}

 

}

 