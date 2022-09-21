package com.popupFactory;


import org.openqa.selenium.By;

import com.generic.Pojo;

public class OpenProductsQuotePopupPage {
	private Pojo objPojo;

	public OpenProductsQuotePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_drpProductView=By.xpath("//select[@id='documentviewdropdown_0']");
	By loc_chkSelectAll = By.xpath("//input[@type='checkbox' and @id='selectallcheckbox']");
	By loc_btnOpen = By.xpath("//button[text()='Open']");
	
	
	/**
	 * Description: Verify user is able to open product
	 */
	public void clickSelectAllCheckboxOnOpenProductsFoundationTemplatePopupPage() {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can click on Select all checkbox on open products Quote popup page",
				objPojo.getObjWrapperFunctions().click(loc_chkSelectAll));
		objPojo.getObjWrapperFunctions().waitFor(2);
	}
	public void clickOpenButtonOnOpenProductsFoundationTemplatePopupPage() {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can click on Open button on open products Quote popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnOpen));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void clickOnProductsViewDropdown(){
		objPojo.getObjUtilities().logReporter("Verify user can click on product view dropdown on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_drpProductView));
	}
}
