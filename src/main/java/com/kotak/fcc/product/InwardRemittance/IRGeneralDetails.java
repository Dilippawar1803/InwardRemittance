package com.kotak.fcc.product.InwardRemittance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class IRGeneralDetails  {
	private String testData = "", testData_2 = "";
	private Pojo objPojo;
	public IRGeneralDetails(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By instructionsText = By.xpath("//textarea[@id='customerInstructionText']");
	By saveButton = By.xpath("//*[@id='saveButton']");
	By NextButton = By.xpath("//*[@id='next']");
	By submitButton = By.xpath("//*[@id='submit']");
	By CreateForm = By.xpath("//*[@id='mat-button-toggle-33-button']");
	By TransferReference = By.xpath("//*[@id='transfereeReference']");
	By customerReference = By.xpath("//*[@id='customerReference']");
	
	By swiftMT = By.xpath("//div[contains(@id,'message')]");
	By amount = By.xpath("//div[@id='remittanceAmount']");
	
	public void setInstructions(String instructions) {
		objPojo.getObjUtilities().logReporter("Verify user can enter '" + instructions + "' ",
				objPojo.getObjWrapperFunctions().setText(instructionsText, instructions));
		
	}
	public void clickSaveButton() {
		objPojo.getObjUtilities().logReporter("click Save Button",
				objPojo.getObjWrapperFunctions().click(saveButton));
	}

	public String getSwiftFT() {
				testData=	objPojo.getObjWrapperFunctions().getText(swiftMT, "text");
		 return testData;
	}

	public void clickNextButton() {
		objPojo.getObjUtilities().logReporter("click Next Button",
				objPojo.getObjWrapperFunctions().click(NextButton));
	}  
	public String getSettledAmount() {
		testData=	objPojo.getObjWrapperFunctions().getText(amount, "text");
 return testData;
}           
	public void clickSubmitButton() {
		objPojo.getObjUtilities().logReporter("clickSubmit Button",
				objPojo.getObjWrapperFunctions().click(submitButton));
	}       
	public void checkSwiftDetailsDisplayed(String text) {
		 By locator =By.xpath("//label[contains(text(),'"+text+" ')]");
		objPojo.getObjUtilities().logReporter("Verify Swift Details" + text + " is displayed ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	
	
                
}

