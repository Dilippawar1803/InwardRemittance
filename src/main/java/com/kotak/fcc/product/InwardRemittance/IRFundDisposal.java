package com.kotak.fcc.product.InwardRemittance;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class IRFundDisposal {
	private Pojo objPojo;

	public IRFundDisposal(Pojo pojo) {
		this.objPojo = pojo;
	}

	By fundAmount = By.xpath("//input[@id='fundAmount']");
	By accountCodeList = By.xpath("(//tr[@id='rowdata'])[1]");
	By searchIcon = By.xpath("//span[contains(text(),'search')]");
	By cosigneeName = By.xpath("//textarea[@id='irCosigneeName']");

	public void clickOnSearchIcon() {
		objPojo.getObjUtilities().logReporter("click On Search Icon",
				objPojo.getObjWrapperFunctions().click(searchIcon));
	}

	public void clickOnAccountList() {
		objPojo.getObjUtilities().logReporter("click On Account List",
				objPojo.getObjWrapperFunctions().click(accountCodeList));
	}

	public void setFundAmount(String fundamount) {
		objPojo.getObjUtilities().logReporter("set Fund Amount '" + fundamount + "' ",
				objPojo.getObjWrapperFunctions().setText(fundAmount, fundamount));

	}

	public void setCosigneeNameAddress(String cosigneeNameAddress) {
		objPojo.getObjUtilities().logReporter("set cosignee Name '" + cosigneeNameAddress + "' ",
				objPojo.getObjWrapperFunctions().setText(cosigneeName, cosigneeNameAddress));

	}

	public void setDetailsFundDisposal(String fundamount) {

		clickOnSearchIcon();

		clickOnAccountList();

		setFundAmount(fundamount);

	}

}
