package com.kotak.fcc.product.InwardRemittance;

 

import org.openqa.selenium.By;

import com.generic.Pojo;

public class IRChargesDebitAdditionalDetails {
	private Pojo objPojo;
	public IRChargesDebitAdditionalDetails(Pojo pojo) {
		this.objPojo = pojo;
	}
	By searchIcon = By.xpath("//span[contains(text(),'search')]");
	By accountCodeList = By.xpath("//tr[@id='rowdata'])[1]");
	By additionalDetails = By.xpath("//textarea[@id='addDetailsText']");

	public void clickOnSearchIcon() {	
		objPojo.getObjUtilities().logReporter("clickOnSearchIcon",
				objPojo.getObjWrapperFunctions().click(searchIcon));
	}

	public void clickOnAccountList() {
		objPojo.getObjUtilities().logReporter("account Code List",
				objPojo.getObjWrapperFunctions().click(accountCodeList));
	}
	public void setAdditionalDetails(String details) {
		objPojo.getObjUtilities().logReporter("set Additional Details '" + details + "' ",
				objPojo.getObjWrapperFunctions().setText(additionalDetails, details));
		
	}

public void setChargesDetails(String details){

                clickOnSearchIcon();

                clickOnAccountList();

                setAdditionalDetails(details);

               

}

}