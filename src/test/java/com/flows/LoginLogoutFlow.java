package com.flows;

import com.flows.commonFlows.CommonFlow;
import com.generic.Pojo;
import com.kotak.fcc.product.InwardRemittance.FTI;
import com.pageFactory.LoginPage;
import com.popupFactory.LogOffPopupPage;

import ru.yandex.qatools.allure.annotations.Step;


public class LoginLogoutFlow {

	// Global Variable
	private Pojo objPojo;
	private String testData = "";
	private String testData_1="";
	
	
	// Reference object of Pages
	private LoginPage objLoginPage;
	private LogOffPopupPage objLogOffPopupPage;
	private FTI objFTI;

	// Constructor of class
	public LoginLogoutFlow(Pojo pojo) {
		this.objPojo = pojo;
		objLoginPage = new LoginPage(objPojo);
		objFTI = new FTI(objPojo);
		new CommonFlow(objPojo);
		objLogOffPopupPage = new LogOffPopupPage(objPojo);
	}

	
	
//This method is for login into Fcc with valid user name and password
	@Step("Login into the system for FCC")
	public void doLoginFCC() {
		objLoginPage.setUserID(objPojo.getObjConfig().getProperty("userid"));
		objLoginPage.clickOnNextBuoon();
		objLoginPage.setPassword(objPojo.getObjConfig().getProperty("userpasswd"));
		objLoginPage.clickOnSecureLoginButton();
		objLoginPage.verifyUserLoggedIn(objPojo.getObjConfig().getProperty("loginTitle"));
	}
	//This method is for login into FTI with valid user name and password
	@Step("Login into the system For FTI ")
	public void doLoginFTI() {
		objFTI.setUserIDForFTI(objPojo.getObjConfig().getProperty("useridFTI"));
		
		objFTI.setPasswordForFTI(objPojo.getObjConfig().getProperty("userpasswdFTI"));
		objFTI.clickOnSignInButton();
		objLoginPage.verifyUserLoggedIn(objPojo.getObjConfig().getProperty("loginTitleFTI"));
	}
	
	//This method is for login into Fcc Checker with valid user name and password
		@Step("Login into the system For Fcc Checker")
		public void doLoginFCCChecker() {
			objFTI.setUserIDForFTI(objPojo.getObjConfig().getProperty("useridFCCChecker"));
			
			objFTI.setPasswordForFTI(objPojo.getObjConfig().getProperty("userpasswdFCCChecker"));
			objFTI.clickOnSignInButton();
			objLoginPage.verifyUserLoggedIn(objPojo.getObjConfig().getProperty("loginTitleFTI"));
		}
	
	
	@Step("Login into the system.")
	public void doLoginWithExcelParameter() {
		testData = objPojo.getObjUtilities().dpString("userid");
		if (!testData.equals(""))
			objLoginPage.setUserID(testData);
		testData = objPojo.getObjUtilities().dpString("userpasswd");
		if (!testData.equals(""))
			objLoginPage.setPassword(testData);
		testData = objPojo.getObjUtilities().dpString("LoginWithOption");
		if(!testData.equals(""))
		 objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		testData = objPojo.getObjUtilities().dpString("loginTitle");
		if(!testData.equals(""))
			objLoginPage.verifyUserLoggedIn(testData);
//		if(!this.VerifyTitle()){
//			objLoginPage.inputEmail();
//			objLoginPage.clickOnNext();
//			objLoginPage.inputPassword();
//			objLoginPage.clickOnNext();
//			objLoginPage.checkDaysCheckbox();
//			objPojo.getObjWrapperFunctions().waitFor(15);
//			objLoginPage.clickOnNext();
//			objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
//			objLoginPage.verifyUserLoggedIn(objPojo.getObjConfig().getProperty("loginTitle"));
//		}
	}

	 
	@Step("Verify Title in the Application")
	public boolean VerifyTitle() { 
		String strTitle =objPojo.getDriver().getTitle();
		String getEBSTitle=objPojo.getObjConfig().getProperty("loginTitle");
		if(strTitle.toLowerCase().equals(getEBSTitle.toLowerCase())){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	

	public void LogOutFromTheApplication() {
		objLogOffPopupPage.clickOneBenefitSyncuserIcon();
		objLogOffPopupPage.clickOnLogOffText();
		objLogOffPopupPage.verifyLogOutConfirmationMassage();
		testData = objPojo.getObjUtilities().dpString("Btn_Yes");
		if (!testData.equals(""))
			objLogOffPopupPage.clickOnLogOutConfirmationButton(testData);
		objLogOffPopupPage.verifyUserGetLogOffFromApplication();
	}
}
