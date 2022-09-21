package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class SyncPackagePopupPage {

	private Pojo objPojo;

	public SyncPackagePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrOpenSynSourceDocumen=By.xpath("//span[text()='Sync Package']");
	By loc_chkSelectAll = By.xpath("//input[@type='checkbox' and @id='selectallsynccheckbox']");
	By loc_btnSyncUp = By.xpath("//button[text()='Sync Up']");

	/**
	 * 
	 *  Scenario: 118249
	 *  Description: Portfolio packge Sync_TC002_Verify the "Sync Package " Functionality at the Portfolio-Package Build tab
	 */
	public void verifySyncPackagePopupPageHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify Sync Package popup header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrOpenSynSourceDocumen));
	}
	public void clickSelectAllCheckboxOnSyncPackagePopupPagePopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Select all checkbox on Sync Package popup page",
				objPojo.getObjWrapperFunctions().click(loc_chkSelectAll));
	}
	public void clickSyncUpButtonOnSyncPackagePopupPagePopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Open button on Sync Package popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSyncUp));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
}

