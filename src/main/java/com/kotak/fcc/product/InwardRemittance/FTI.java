package com.kotak.fcc.product.InwardRemittance;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.generic.Pojo;

public class FTI {
	// Global Variables
		private Pojo objPojo;
		private String testData="";
	public FTI(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By cleanPayment = By.xpath("//span[contains(text(),'Clean Payments Processing')]");
	By nostroUtility = By.xpath("//span[contains(text(),'Nostro Utility')]");
	By btnMasterBrowser = By.xpath("//button[contains(text(),'Master browser')]");
	By startButton = By.xpath("//button[@value='Start...']");
	By pullBack = By.xpath("//a[text()='Pull Back']");
	By enquiry = By.xpath("//a[text()='Enquiry']");
	By PullBackfromFCC = By.xpath("//a[text()='Pull Back from FCC']");
	By inputDeatails = By.xpath("(//div[@id='body-section1'])[1]");
	By refranceNumber = By.xpath("//input[@id='refNo']");
	
	By CRN = By.xpath("//input[@id='CRN']");
	By amount = By.xpath("//input[@id='Amount']");
	By currency = By.xpath("//input[@id='Currency']");
	By stmtDateTo = By.xpath("//input[@id='stmtDateTo']");
	By getDetailsButton = By.xpath("//input[@id='pullbackenquiry']");
	By checkList = By.xpath("//input[@id='checkList']");
	By process = By.xpath("//a[text()='Process']");
	By msgPullBack = By.xpath("//span[text()='pullback done successfully.']");
	By imgView = By.xpath("//span//img[@title='View']");

	By download = By.xpath("//em[@class='fa fa-file-pdf-o pdfIcon']");
	By user = By.xpath("//input[@id='username']");
	By userPassword = By.xpath("//input[@id='password']");
	By btnLogin = By.xpath("//button[@id='login']");
	By zoneList = By.xpath("//table[@id='managezones:zones']//tbody//tr");
	By messageTpye = By.xpath("//select[@id='type']");
	By swifMessage = By.xpath("//textarea[@id='swiftMessage']");
	By inpOpenMaster  = By.xpath("//input[@id='_id3:OpenCleanPaymentsMasterWP_MBFiltersWP_MBFilterGenericWP_ctlArgMasterFilter_ReferenceGroup_Reference2']");
	By btnRegresh = By.xpath("//button[@id='_id3:OpenCleanPaymentsMasterWP_Refresh']");
	By masterBrowserResult = By.xpath("//table[@id='_id3:OpenCleanPaymentsMasterWP_MBResultsViewWP_MBResultsMastersWP_ctlResults']//tbody/tr");
	By btnOpen = By.xpath("//button[@id='_id3:OpenCleanPaymentsMasterWP_OpenMaster']");
	By btnContinue= By.xpath("//button[@id='_id3:CPayCustomerInMasterWP_CurrentEventsP_ContinueStep']");
	
	
	//This method for Contuine Search master no and click on matser no in FTI
	public void clickOnContinueButton() {
		objPojo.getObjUtilities().logReporter("click On Continue Button For FTI",
				objPojo.getObjWrapperFunctions().click(btnContinue));
	}
	// This method for Open Search master no and click on matser no in FTI
	public void clickOnOpenButton() {
		objPojo.getObjUtilities().logReporter("click On Open Button For FTI",
				objPojo.getObjWrapperFunctions().click(btnOpen));
	}
	// This method for Select Search master no and click on matser no in FTI
	public void clickOnMasterBrowserResult() {
		objPojo.getObjUtilities().logReporter("click On Master Browser Result For FTI",
				objPojo.getObjWrapperFunctions().click(masterBrowserResult));
	}
	// This method for Refresh Button in FTI
	public void clickOnRefreshButton() {
		objPojo.getObjUtilities().logReporter("click On Refresh Button For FTI",
				objPojo.getObjWrapperFunctions().click(btnRegresh));
	}
	public void setUserIDForFTI(String userID) {
		objPojo.getObjUtilities().logReporter("Set User Name For FTI", userID,
				objPojo.getObjWrapperFunctions().setText(user, userID));
	}
	public void setOpenMasterForFTI(String userID) {
		objPojo.getObjUtilities().logReporter("Set open Master For FTI", userID,
				objPojo.getObjWrapperFunctions().setText(inpOpenMaster, userID));
	}
	public void fileUploadSwiftMessage(String fileName) {
		objPojo.getObjUtilities().logReporter("Set User Name For FTI", fileName,
				objPojo.getObjWrapperFunctions().uploadFile(fileName, "30"));
	}
	public void selectMessageTypeFromThemeBridge(String Option) {
		objPojo.getObjUtilities().logReporter("Select Message For ThemeBridge", Option,
				objPojo.getObjWrapperFunctions().selectDropDownOption(messageTpye, Option, "Value"));
	}
	//This method is for Set Password in FTI
	public void setPasswordForFTI(String password) {
		objPojo.getObjUtilities().logReporter("Set password For FTI", password,
				objPojo.getObjWrapperFunctions().setText(userPassword, password));
	}
	//This method is for click on Browser Button In left menu in FTI
	public void clickOnMasterBrowserButton() {
		objPojo.getObjUtilities().logReporter("click On Master Browser Button For FTI",
				objPojo.getObjWrapperFunctions().click(btnMasterBrowser));
	}
	//This method is for click on clean Payment Processing Zone list in FTI
	public void clickOnCleanPaymentProcessing() {
		objPojo.getObjUtilities().logReporter("click On clean Payment Processing  For FTI",
				objPojo.getObjWrapperFunctions().click(cleanPayment));
	}
	//This method is for click on Sigh in Button in FTI
	public void clickOnSignInButton() {
		objPojo.getObjUtilities().logReporter("click On Sign In Button For FTI",
				objPojo.getObjWrapperFunctions().click(btnLogin));
	}
	
	//This method is for click on Zone list in FTI
	public void clickOnZoneList() {
		objPojo.getObjUtilities().logReporter("click On Zone List For FTI",
				objPojo.getObjWrapperFunctions().click(zoneList));
	}
	
	public void setRefranceNumber(String refNumber) {
		objPojo.getObjUtilities().logReporter("Verify user can enter '" + refNumber + "' in filter ",
				objPojo.getObjWrapperFunctions().setText(refranceNumber, refNumber));
		
	}

	public void setCRN(String strCRN) {
		objPojo.getObjUtilities().logReporter("Verify user can enter '" + strCRN + "' ",
				objPojo.getObjWrapperFunctions().setText(CRN, strCRN));
		
	}
	public void setAmount(String strAmount) {
		objPojo.getObjUtilities().logReporter("Verify user can enter '" + strAmount + "' ",
				objPojo.getObjWrapperFunctions().setText(amount, strAmount));
		
	}
	public void setCurrency(String strCurrency) {
		objPojo.getObjUtilities().logReporter("Verify user can enter '" + strCurrency + "' ",
				objPojo.getObjWrapperFunctions().setText(currency, strCurrency));
		
	}

	public void setStatementDateFrom() {
		objPojo.getObjUtilities().logReporter("set Statement Date From",
				objPojo.getObjWrapperFunctions().click(stmtDateTo));
	}
	public void clickGetDetailsButton() {
		objPojo.getObjUtilities().logReporter("click Get Details Button",
				objPojo.getObjWrapperFunctions().click(getDetailsButton));
	}
	
	public void checkRefranceNumberDisplayed() {
		objPojo.getObjUtilities().logReporter("Check Refrance Number is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(refranceNumber));
	}

	public void checkPullBackCRNDisplayed() {
		objPojo.getObjUtilities().logReporter("Check Pull Back CRN is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(CRN));	
	}

	public void checkPullBackCurrencyDisplayed() {
		objPojo.getObjUtilities().logReporter("Check Pull Back Currency is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(currency));
		
	}

	public void checkPullBackAmountDisplayed() {
		objPojo.getObjUtilities().logReporter("Check Pull Back Amount is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(amount));
		
		
	}
	
	public void checkPullBackDisplayed() {
		objPojo.getObjUtilities().logReporter("Check Pull Back is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(pullBack));
		
		
	}

	public void checkPullBackStatementDateFromDisplayed() {
		objPojo.getObjUtilities().logReporter("Check Pull Back Statement Date From is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(stmtDateTo));
		
		
	}

	public void verifyPullBackDoneMessageDisplayed() {
		objPojo.getObjUtilities().logReporter("verify Pull Back Done Message Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(msgPullBack));
		
		
	}
	
	public void clickNostroUtility() {
		objPojo.getObjUtilities().logReporter("Scroll to Nostro Utility",
				objPojo.getObjWrapperFunctions().scrollToView(nostroUtility));
		objPojo.getObjUtilities().logReporter("click Nostro Utility",
				objPojo.getObjWrapperFunctions().click(nostroUtility));
	}
	public void clickOnStartButton() {
		objPojo.getObjUtilities().logReporter("Scroll to Start Button",
				objPojo.getObjWrapperFunctions().scrollToView(nostroUtility));
		objPojo.getObjUtilities().logReporter("click Start Button for FTI",
				objPojo.getObjWrapperFunctions().click(startButton));
	}
	
	
	
	public void clickOnPullBack() {
		objPojo.getObjUtilities().logReporter("click pull Back for FTI",
				objPojo.getObjWrapperFunctions().click(pullBack));
	}

	
	public void verifyBullBankOption() {
		objPojo.getObjUtilities().logReporter("verify Bull Bank Option is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(enquiry));
		
	}

	public void checkPullBackRefranceNumberDisplayed() {
		objPojo.getObjUtilities().logReporter("check Pull Back Refrance Number Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(refranceNumber));
		
	}
	
	public void clickOnPullBackfromFCC() {
		objPojo.getObjUtilities().logReporter("click On Pull Back from FCC",
				objPojo.getObjWrapperFunctions().click(PullBackfromFCC));
		
	}
		
	public void clickOnInputDeatails() {
		objPojo.getObjUtilities().logReporter("click On input Deatails",
				objPojo.getObjWrapperFunctions().click(inputDeatails));
		
	}
	
	public void clickOnCheckList() {
		objPojo.getObjUtilities().logReporter("click On Check List",
				objPojo.getObjWrapperFunctions().click(checkList));
		
	}
	public void clickOnProcess() {
		objPojo.getObjUtilities().logReporter("click On Process",
				objPojo.getObjWrapperFunctions().click(process));
		
	}


	public void verifyPullBackMessageDisplayed() {

		testData = objPojo.getObjUtilities().dpString("RefranceNumber");
		if (!testData.equals(""))
			
		setRefranceNumber(testData);
		testData = objPojo.getObjUtilities().dpString("CRN");
		if (!testData.equals(""))
		setCRN(testData);
		testData = objPojo.getObjUtilities().dpString("Amount");
		if (!testData.equals(""))
		setAmount(testData);
		testData = objPojo.getObjUtilities().dpString("Currency");
		if (!testData.equals(""))
		setCurrency(testData);
		setStatementDateFrom();
		clickGetDetailsButton();
		clickOnCheckList();
		clickOnProcess();
		verifyPullBackDoneMessageDisplayed();

	}

	public void verifyPullBackInquiryMenuSearchCriteriaDisplayed() {

		checkPullBackRefranceNumberDisplayed();
		checkPullBackCRNDisplayed();
		checkPullBackCurrencyDisplayed();
		checkPullBackAmountDisplayed();
		checkPullBackStatementDateFromDisplayed();

	}

}