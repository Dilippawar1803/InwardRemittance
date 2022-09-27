package com.pageFactory;
import java.util.List;
import org.openqa.selenium.By;
import com.generic.FileFunctions;
import com.generic.Pojo;


import ru.yandex.qatools.allure.annotations.Step;


public class LoginPage {

	// Global Variables
	private Pojo objPojo;
	private List<String> listReturnValue;
	
	public LoginPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	// headers
	By loc_inpUsername = By.xpath("//input[@id='userName']");
	By loc_inpPassword = By.xpath("//input[@id='credentialInputField']");
	By loc_btnNext = By.xpath("//button[text()='Next']");
	By loc_btnSecureLogin = By.xpath("//button[text()='Secure login']");
	
	public void verifyUserIsOneMedicareSyncLoginPage(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdreMedicareSync);
		objPojo.getObjUtilities().logReporter("Verify user is on the login page of eMedicareSync", objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdreMedicareSync));
	}

	public void setUserID(String userID) {
		objPojo.getObjUtilities().logReporter("Set user name", userID,
				objPojo.getObjWrapperFunctions().setText(loc_inpUsername, userID));
	}

	public void setPassword(String password) {
		objPojo.getObjUtilities().logReporter("Set password", password,
				objPojo.getObjWrapperFunctions().setText(loc_inpPassword, password));
	}

	public void verifyUserLoggedIn(String strTitle) {
		objPojo.getObjUtilities().logReporter("Verify user login is successfull by using page title",
				objPojo.getDriver().getTitle(), strTitle,
				objPojo.getDriver().getTitle().toLowerCase().contains(strTitle.toLowerCase()));
	}

	public void clickOnNextBuoon() {
		objPojo.getObjUtilities().logReporter("Click 'Next' button",
				objPojo.getObjWrapperFunctions().click(loc_btnNext));
	}
	public void clickOnSecureLoginButton() {
		objPojo.getObjUtilities().logReporter("Click 'SecureLogin' button",
				objPojo.getObjWrapperFunctions().click(loc_btnSecureLogin));
	}
	
    public void verifyUserNameTextboxIsDisplayedOnLoginPage() {
        objPojo.getObjUtilities().logReporter("Verify user see UserName Textbox on Login page",
                objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpUsername));
    }
    public void verifypasswordTextboxIsDisplayedOnLoginPage() {
        objPojo.getObjUtilities().logReporter("Verify user see Password Text on Login page",
                objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPassword));
    }
    

    
	
	
}
