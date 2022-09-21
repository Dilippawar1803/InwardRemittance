package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.FileFunctions;
import com.generic.Pojo;

import ru.yandex.qatools.allure.annotations.Step;

public class PropertiesPopupPage {

	// Global Variables
	private Pojo objPojo;
	private List<String> listReturnValue;
	private String testData = "";
	private String testData_1 = "";
	private int intIndex = 0;

	public PropertiesPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrPackageSyncLog = By.xpath("//div[@class='modal-header']//child::h5[text()='Package Sync Log']");
	By loc_btnClosePackageBuild = By.xpath(
			"//div//following-sibling::div//h5[text()='Package Sync Log']//parent::div//following-sibling::div//div//div//button[contains(text(),'Close')]");

	/**
	 * Scenario: Description:
	 */

	public void clickOnTabOnPropertiesPopupPage(String strTabName) {
		By loc_Tab = By.xpath("//a[text()='" + strTabName + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strTabName + "' popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_Tab));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void verifyThePackageSyncLogHeaderDisplayedAtPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify user can See Package Sync Log Header on portfolio module",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrPackageSyncLog));
	}

	public void VerifyCloseButtonOfPackageSyncLog() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnClosePackageBuild);
		objPojo.getObjUtilities().logReporter("Verify Close button of Package Sync Log tab on portfolio module",
				objPojo.getObjWrapperFunctions().click(loc_btnClosePackageBuild));
	}

	/**
	 * Scenario: 171491 Description: Verify the columns displayed at Portfolio
	 * Module and filter functionality for all columns
	 */

	public void clickOnFilterIconOnPacakageSyncLogPopUp(int intFilterIndex) {
		By locator = By
				.xpath("(//h5[text()='Package Sync Log']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body p-0']//span[@class='ag-icon ag-icon-filter'])["
						+ intFilterIndex + "]");
		objPojo.getObjUtilities().logReporter("Click on filter icon on package sync log pop up",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyColumns(String strColumnName) {
		By locator = By.xpath("//div[text()='" + strColumnName + "']");
		objPojo.getObjUtilities().logReporter("Verify user can see the Column name '" + strColumnName + "' ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void verifyUserRoleAfterSync(String strSyncUserName) {
		By locuserNameForSync = By.xpath("//table[@id='FTAuditTrailLogGrid']//td[@title='"+strSyncUserName+"']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locuserNameForSync);
		objPojo.getObjUtilities().logReporter("Verify user role should be visible as '"+strSyncUserName+"' in FT check audit trail",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locuserNameForSync));
	}

	@Step("Verify columns displayed at the FT Check Audit Trail ")
	public void verifyColumnsDisplayedAtFTCheckAuditTrail() {
		try {
			listReturnValue = FileFunctions.readFileIntoList(System.getProperty("user.dir")
					+ "/src/test/resources/testData/textFiles/TCID_160097_VerifyTheUIOfFTCheckAuditTrailWindow.txt");
			for (String strValue : listReturnValue) {
				System.out.println("text file testData : " + strValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int index = 0; index < listReturnValue.size(); index++) {
			String strColumnName = listReturnValue.get(index).trim();
			if (!strColumnName.equals("")) {
				objPojo.getObjWrapperFunctions().waitFor(1);
				this.verifyColumns(strColumnName);

				// Scroll right
				testData = objPojo.getObjUtilities().dpString("ColId_FolderVersion");
				testData_1 = objPojo.getObjUtilities().dpString("RowIndex_2");
				if (!testData.equals("") && !testData_1.equals("")) {
					intIndex = Integer.parseInt(testData_1);
					this.clickOnAnyColumnCell(testData, intIndex);
					objPojo.getObjWrapperFunctions().scrollToRightInsideWindow(1);

				}
			}

		}

	}

	public void clickOnAnyColumnCell(String strColId, int intRowIndex) {
		By locator = By.xpath("(//td[@aria-describedby='" + strColId + "'])[" + intRowIndex + "]");
		objPojo.getObjUtilities().logReporter("Verify user can click On column Cell",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyStatusOfSyncStatusColumnDisplayedAsSynOrNoSync(String strPortfolioFolderName) {
		By loc_sync = By.xpath("//td[text()='" + strPortfolioFolderName + "']/following-sibling::td[text()='Sync']");
		By loc_NoSync = By
				.xpath("//td[text()='" + strPortfolioFolderName + "']/following-sibling::td[text()='NoSync']");
		// Scroll right
		testData = objPojo.getObjUtilities().dpString("ColId_FolderVersion");
		testData_1 = objPojo.getObjUtilities().dpString("RowIndex_2");
		if (!testData.equals("") && !testData_1.equals("")) {
			intIndex = Integer.parseInt(testData_1);
			this.clickOnAnyColumnCell(testData, intIndex);
			objPojo.getObjWrapperFunctions().scrollToRightInsideWindow(4);

			if (objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_sync)) {
				objPojo.getObjUtilities().logReporter("Verify user can see the Column is status sync  ",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_sync));
			} else {
				objPojo.getObjUtilities().logReporter("Verify user can see the Column name status is  no Sync",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_NoSync));
			}

		}
	}
}

