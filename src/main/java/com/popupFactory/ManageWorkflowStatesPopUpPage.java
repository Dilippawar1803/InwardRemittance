package com.popupFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class ManageWorkflowStatesPopUpPage {
	// Global Variables
	private Pojo objPojo;
	private String strReturnValue = "";

	public ManageWorkflowStatesPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_cancleManaheWorkflowstatesPopup = By
			.xpath("(//span[text()='Manage Workflow States']//ancestor::div/a/span[text()='close'])[2]");

	By loc_BulkWorkFlowUpdate = By.xpath("//span[@id='btnPortfolioBulkWorkflowUpdate']");
	By loc_Procced = By.xpath("//button[@type='button'][text()='Proceed' and @id='workflowStateTransferFoundation'] ");
	By loc_ProccedInPortfolio = By.xpath("//button[@type='button'][text()='Proceed' and @id='workflowStateTransfer']");
	By loc_btnProcessForAccount = By
			.xpath("//button[@type='button'][text()='Proceed' and @id='workflowStateTransferAccount']");
	By loc_ReleaseOptionTargetWorkflow = By.xpath(
			"(//label[contains(text(),'Select Target Workflow State')])[3]/parent::div[1]/descendant::select[1]//option[text()='Release']");
	By loc_ManageWorkFlowStates = By.xpath("//span[@id='ui-id-6' and text()='Manage Workflow States']");
	By loc_dropdownTargetWorkflowState = By.xpath("//select[@id='targetworkflowStatesDDL']");
	By loc_chkBulkWorkFlow = By.xpath("//div[contains(text(),'Bulk Workflow ')]/input");
	By loc_iconRefreshGrid = By.xpath("//span[@id='refreshWFGrid' and contains(@class,'ui-icon ui-icon-refresh')]");
	By loc_inpEffectiveDateForFoundationTemplate = By
			.xpath("//label[text()='Effective Date']//following-sibling::input[@id='effectivedate']");
	By loc_PopUpHrdManangeWorkFlowStatesOfAccount = By
			.xpath("//span[@id='ui-id-1' and text()='Manage Workflow States']");
	By loc_iconEffectiveDateForFoundationTemplate = By.xpath(
			"//label[text()='Effective Date']/following-sibling::input[@id='effectivedate']/following-sibling::img[contains(@class,'datepicker')]");
	By loc_titleManageWorkFlowStates = By.xpath(
			"//div[@id='workflowStatesDialogFoundation']/preceding-sibling::div/span[.='Manage Workflow States']");
	By loc_BulkWorkFlowUpdatePackageBuilld = By.xpath("(//span[@id='btnPortfolioBulkWorkflowUpdate'])[2]");
	By loc_ManageWorkFlowStatesProductBuild = By.xpath("//span[@id='ui-id-6' and text()='Manage Workflow States']");
	By loc_hdrManageWorkFlowStateOnFT = By.xpath("(//div//child::span[text()='Manage Workflow States'])[2]");
	By loc_folderMinorVersion = By.xpath(
			"//span[text()='Manage Workflow States']//following::div[@col-id='VersionNumber' and contains(text(),'2022_0.')][1]");
	By loc_CloseManageWorkflowStatesPopUP = By.xpath(
			"(//span[text()='Manage Workflow States']//following::span[@class='ui-icon ui-icon-closethick'])[1]");
	By loc_CloseManageWorkflowStatesPopUPFT = By.xpath(
			"(//span[text()='Manage Workflow States']//following::span[@class='ui-icon ui-icon-closethick'])[2]");
	By loc_inpEffectiveDateForPortfolio = By
			.xpath("//label[text()='Effective Date']//following-sibling::input[@id='effectivedatePortfolio']");
	By loc_iconEffectiveDateForPortfolio = By.xpath(
			"//label[text()='Effective Date']/following-sibling::input[@id='effectivedatePortfolio']/following-sibling::img[contains(@class,'datepicker')]");
	By loc_titleManageWorkFlowStatesPF = By
			.xpath("//div[@id='workflowStatesDialog']/preceding-sibling::div/span[.='Manage Workflow States']");
	By loc_iconEffectiveDateForAccount = By.xpath(
			"//label[text()='Effective Date']/following-sibling::input[@id='effectivedateAccount']/following-sibling::img[contains(@class,'datepicker')]");
	By loc_EffectiveDatePortfolio = By
			.xpath("//label[text()='Effective Date']//following-sibling::input[@id='effectivedatePortfolio']");
	By loc_iconCalender = By.xpath("//input[@id='effectivedatePortfolio']");
	By loc_icnBulkWorkflowFoundation = By.xpath("(//span[@id='btnPortfolioBulkWorkflowUpdate'])");

	public void clickOnBulkWorkFlowIcon() {
		objPojo.getObjUtilities().logReporter("Verify Hearing product type is displaying ",
				"Verify Hearing product type  is displaying '" + loc_BulkWorkFlowUpdate + "'",
				"Verify Hearing product type  is displaying'" + loc_BulkWorkFlowUpdate + "'",
				objPojo.getObjWrapperFunctions().click(loc_BulkWorkFlowUpdate));
	}

	public void clickOnTheFolderNameCheckbox(String strFolderName) {
		objPojo.getObjWrapperFunctions().waitFor(5);
		By loc_FolderCheckbox = By.xpath("//span[text()='Manage Workflow States']/following::div[text()='"
				+ strFolderName + "' and @col-id='FolderName']/parent::div/child::div/descendant::span[1]");
		objPojo.getObjUtilities().logReporter("click on Folder checkbox on manage workflow State Popup",
				"user should able to click on Folder checkbox on manage workflow State Popup",
				"user is able to click on Folder checkbox on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().actionClick(loc_FolderCheckbox));
	}

	public void clickOnProcessButtonOnWorkFlowPopup() {
		objPojo.getObjUtilities().logReporter("click on Process button on manage workflow State Popup",
				"user should able to click on Process button on manage workflow State Popup",
				"user is able to click on Process button on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().click(loc_Procced));
	}

	public void selectBulkWorkFlowDropDown(String strDropdownName, String strActionDropdown) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[3]/parent::div[1]/descendant::select[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void clickOnConfirmationPopupButton() {
		By loc_btnYes = By.xpath("(//button[text()='Yes'])[2]");
		objPojo.getObjUtilities().logReporter("Verify user can click on Yes button", "User should click on yes button",
				"User is able to click on yes button", objPojo.getObjWrapperFunctions().click(loc_btnYes));
	}

	public void clickOnCloseButton() {
		By loc_btnClose = By.xpath(
				"//p[text()='Please refer to the Bulk Workflow Log to check the status of all the folder(s) that were processed for bulk workflow update.']/ancestor::div/child::div[11]/div/child::button");
		objPojo.getObjUtilities().logReporter("Verify user can click on Yes button", "User should click on yes button",
				"User is able to click on yes button", objPojo.getObjWrapperFunctions().click(loc_btnClose));
	}

	public void clickTOSwithcOnManageWorkflowTabs(String strTabName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("(//span[text()='Manage Workflow States']/following::a[text()='" + strTabName + "'])[3]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on icon Bulk Workflow Log ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyStatusBulkWorkFlow(String strFolderName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By loc_StatusBulkWorkflow = By.xpath("//div[text()='Bulk Workflow Log']/following::div[text()='" + strFolderName
				+ "' and @col-id='FolderName']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_StatusBulkWorkflow);
		objPojo.getObjUtilities().logReporter("Verify user can Verify Status of Bulk Workflow ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_StatusBulkWorkflow));
	}

	/**
	 * Scenario: 118062 Description: Verify User Can Update The WF Status Using
	 * Bulk Workflow Update Feature At Portfolio
	 */
	public void selectBulkWorkFlowDropDownForPortfolio(String strDropdownName, String strActionDropdown) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[1]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void clickTOSwithcOnManageWorkflowTabsForPortfolio(String strTabName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("(//span[text()='Manage Workflow States']/following::a[text()='" + strTabName + "'])[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strTabName + "' Tab",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyStatusBulkWorkFlowForPortfolio(String strFolderName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By loc_StatusBulkWorkflow = By.xpath("//div[text()='Manage Workflow States']/following::div[text()='"
				+ strFolderName + "' and @col-id='FolderName']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_StatusBulkWorkflow);
		objPojo.getObjUtilities().logReporter("Verify user can Verify Status of Bulk Workflow ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_StatusBulkWorkflow));
	}

	public void clickOnProcessButtonOnWorkFlowPopupForPortfolio() {
		objPojo.getObjUtilities().logReporter("click on Process button on manage workflow State Popup",
				"user should able to click on Process button on manage workflow State Popup",
				"user is able to click on Process button on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().click(loc_ProccedInPortfolio));
	}

	public void verifyColumnDataDisplayedAtTheBulkWorkflowTab(String strData) {
		By locator = By
				.xpath("(//div[@class='ag-body-viewport']//following::div[@row-index='0'])[3]//child::div[@col-id='"
						+ strData + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see " + strData + " column data",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyColumnDataDisplayedAtBulkWorkflowTabOfPackageBuildTab(String strData) {
		By locator = By.xpath("//div[@class='ag-body-viewport']//following::div[@class='ag-header-row']//div[@col-id='"
				+ strData + "']");
		objPojo.getObjUtilities().logReporter("Verify user can see " + strData + " column data",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	/**
	 * 
	 * Scenario: TCID_216040 Description: Verify if user cannot update the WF of
	 * the folder if there are open tasks for the folder
	 */

	// confirmation message
	public void verifyConfirmationMessage(String strMessage) {
		By locator = By.xpath("//p[text()='" + strMessage + "']");
		objPojo.getObjUtilities().logReporter("Verify confirmation message of " + strMessage + " Bulk Workflow Log ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}

	public void verifyStatusBulkWorkFlowForAccountInBulkWorkfloLog(String strFolderName, String strStatus) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("//div[text()='Bulk WorkFlow Log']/following::div[text()='" + strFolderName
				+ "' and @col-id='FolderName']//following-sibling::div[@col-id='Status']//span[text()='" + strStatus
				+ "']");
		objPojo.getObjUtilities().logReporter("Verify user can Verify Status of Bulk Workflow ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void clickStatusFailureForBulkWorkfloLogInBulkWorkFlow(String strFolderName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("//div[text()='Bulk WorkFlow Log']/following::div[text()='" + strFolderName
				+ "' and @col-id='FolderName']//following-sibling::div[@col-id='Status']//span[text()='Failure']");
		objPojo.getObjUtilities().logReporter("Verify user can Verify Status of Bulk Workflow ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void clickOnProcessButtonOnWorkFlowPopupForAccount() {
		objPojo.getObjUtilities().logReporter("click on Process button on manage workflow State Popup",
				"user should able to click on Process button on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().click(loc_btnProcessForAccount));
	}

	public void verifyDropdownIsDisabledOnBulkWorkFlowTabForFoundationTemplate(String strDropdownName) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[3]/parent::div[1]/descendant::select[1]");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is disabled ",
				!(objPojo.getObjWrapperFunctions().checkElementEnabled(locator)));
	}

	public void verifyDropdownIsEnabledOnBulkWorkFlowTabForFoundationTemplate(String strDropdownName) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[3]/parent::div[1]/descendant::select[1]");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void verifyDropdownIsDisabledOnBulkWorkFlowTabForAccountAndPortfolio(String strDropdownName) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[1]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is disabled ",
				!(objPojo.getObjWrapperFunctions().checkElementEnabled(locator)));
	}

	public void verifyDropdownIsEnabledOnBulkWorkFlowTabForAccountAndPortfolio(String strDropdownName) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[1]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void verifyDropdownIsEnabledforSelectTargetOnBulkWorkFlowTabAccountAndPortfolio(String strDropdownName) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[2]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void verifyCalenderOFEffectiveDateIsEnabledOnBulkWorkFlowTabAccountAndPortfolio(String strDropdownName) {
		By locator = By.xpath("(//label[contains(text(),'" + strDropdownName + "')])[1]//following-sibling::input");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	/**
	 * Scenario: 215853 Description:Bulk Workflow_TC005_Verify the "Select
	 * Target Workflow State" drop down on selection of Category as "Benefit
	 * Correction" at Foundation
	 */
	public void verifyDropDownForSelectTargetWorkflowCategory() {
		By locator = By.xpath(
				"(//label[contains(text(),'Select Target Workflow State')])[3]/parent::div[1]/descendant::select[1]");
		objPojo.getObjUtilities().logReporter("Click on Target Workflow State dropdown ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjUtilities().logReporter(" Verify the dropdown option as 'Release'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ReleaseOptionTargetWorkflow));

	}

	/**
	 * Scenario:TCID_216022 Description:Verify Visibility or Hidden
	 * functionality for Select Category drop down field at account module
	 */

	public void clickOnDropdownAtAccount(String drpdownId) {
		By locator = By.xpath("//select[@id='" + drpdownId + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown  ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyDropDownOptionsForDropdownFieldAtAccount(String drpdownId, String strDropdownValue) {
		By locator = By.xpath("//select[@id='" + drpdownId + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValue + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValue));
	}

	public void verifyManageWorkFlowStatesPopUp() {
		objPojo.getObjUtilities().logReporter("Verify Manage WorkFlow States Pop Up is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ManageWorkFlowStates));

	}

	public void verifyDropdownOptionsForSelectSourceWorkflowStateDropDown(String strDropdownValue) {
		By locator = By.xpath("//select[@id='sourceworkflowStatesDDL']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown Slect Source Workflow State ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValue + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValue));
	}

	public void clickTOSelectTargetWorkflowStateDropDownForPortpolio(String strTabName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_dropdownTargetWorkflowState);
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strTabName + "' Tab",
				objPojo.getObjWrapperFunctions().actionClick(loc_dropdownTargetWorkflowState));
	}

	public void verifyDropDownForSelectTargetWorkflowCategoryOnPortPoliopage(String strDropdownName,
			String strDropDownValue) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[1]/parent::div[1]/descendant::select");
		By locator1 = By.xpath("//select[@id='targetworkflowStatesDDL']//option[text()='" + strDropDownValue + "']");
		objPojo.getObjUtilities().logReporter("Click on Target Workflow State dropdown ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjUtilities().logReporter(" Verify the dropdown option as '" + strDropDownValue + "'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator1));

	}

	/**
	 * Scenario: 215854 Description:Verify the folder list Displayed as per
	 * combination of Select Category and Select Source Workflow State at
	 * Foundation
	 */
	public void verifyHeaderOfFoundationSearchInBulkWorkFlow(String strHeader) {
		By locator = By.xpath("//div[@id='portfolioSearchGrid']//div[text()='" + strHeader + "']");
		objPojo.getObjUtilities().logReporter("Verify Header of Foundation Search in Bulk workFlow for Foundation",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyColumnOfFoundationSearchnBulkWorkFlow(String strColumnName, int index) {
		By locator = By.xpath("((//div[text()='" + strColumnName + "'])[" + index
				+ "]//following::div[@class='customSortDownLabel'])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify column " + strColumnName + " and sorting of Foundation Search in Bulk workFlow for Foundation",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyRefreshGridOfFoundationSearchinBulkWorkFlow() {
		objPojo.getObjUtilities().logReporter(
				"Verify Refresh grid Icon for Foundation Search in Bulk workFlow for Foundation",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconRefreshGrid));
	}

	public void verifyFilterOptionOfFoundationSearchinBulkWorkFlow(int index) {
		By locator = By
				.xpath("(//div[@title='Folder Name']//ancestor::div[@class='ag-header-row']//following-sibling::div//descendant::span[@class='ag-icon ag-icon-filter'])["
						+ index + "]");
		objPojo.getObjUtilities().logReporter(
				"Verify Filter for Each column Foundation Search in Bulk workFlow for Foundation",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyCheckBoxOptionOfFoundationSearchinBulkWorkFlow() {
		objPojo.getObjUtilities().logReporter("Verify CheckBox in Foundation Search in Bulk workFlow for Foundation",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBulkWorkFlow));
	}

	public boolean isStatusOfBulkWorkFlowStatusColumnDisplayedAsSuccess(String strFolderName, String strStatus) {
		Boolean blnReturnStatus;
		By loc_SuccessStatus = By.xpath("//div[text()='Bulk WorkFlow Log']/following::div[text()='" + strFolderName
				+ "' and @col-id='FolderName']//following-sibling::div[@col-id='Status']//span[text()='" + strStatus
				+ "']");
		By loc_Failure = By.xpath("//div[text()='Bulk WorkFlow Log']/following::div[text()='" + strFolderName
				+ "' and @col-id='FolderName']//following-sibling::div[@col-id='Status']//span[text()='Failure']");

		blnReturnStatus = false;
		int intIndex = 0;
		while (!blnReturnStatus) {
			objPojo.getObjUtilities().logReporter("Refresh page",
					objPojo.getObjWrapperFunctions().click(loc_iconRefreshGrid));
			// objPojo.getObjWrapperFunctions().sendFunctionKeys("F5"));
			objPojo.getObjWrapperFunctions().waitFor(5);
			blnReturnStatus = objPojo.getObjWrapperFunctions().isElementDisplayed(loc_SuccessStatus);
			intIndex++;
			if (objPojo.getObjWrapperFunctions().isElementDisplayed(loc_SuccessStatus)) {
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_SuccessStatus);
				blnReturnStatus = true;
				break;
			}
			if (objPojo.getObjWrapperFunctions().isElementDisplayed(loc_Failure)) {
				blnReturnStatus = true;
				objPojo.getObjUtilities().logReporter("getting Failure Status-------->>", false);
				break;
			}
			if (intIndex > 20) {
				objPojo.getObjUtilities().logReporter("Not getting Success Status-------->>", false);
				break;
			}
			intIndex++;
		}
		System.out.println("To check how many times it runs:" + intIndex);
		return blnReturnStatus;
	}

	/**
	 * 
	 * Scenario: TCID_216051 Description:Verify the Folders list pulled at the
	 * Manage workflow State when user selects the Action renew option and
	 * target WF state as Release
	 * 
	 */

	public void verifyListofMajorVersion() {

		By loc_versionList = By.xpath("(//div[@class='ag-header-row']//div[@col-id='VersionNumber'])[2]");
		List<WebElement> RowList = objPojo.getObjWrapperFunctions().getWebElementList(loc_versionList);
		int size = RowList.size();
		for (int intIndex = 1; intIndex <= size; intIndex++) {
			By loc_version = By.xpath("(//div[text()='2022_1.0'])['" + intIndex + "']");
			objPojo.getObjWrapperFunctions().scrollToViewDown(loc_version);
			String strVersion = objPojo.getObjWrapperFunctions().getText(loc_version, "Text");
			objPojo.getObjUtilities().logReporter("Verify the version is displayed or Not", !strVersion.equals(""));
		}

	}

	public void selectDropdownforSelectTargetOnBulkWorkFlowTabAccountAndPortfolio(String strDropdownName,
			String strActionDropdown) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[2]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void selectEffectiveDateOnBulkWorkFlowTab(By locator, String strYear, String strMonth, String strDate) {
		objPojo.getObjWrapperFunctions().datePickerForSHActionClick(locator, strYear, strMonth, strDate);
		objPojo.getObjUtilities()
				.logReporter(
						"Verify user can select date as '" + strDate + "', month as '" + strMonth + "', year as '"
								+ strYear + "' from calender.",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void selectEffectiveDateOnBulkWorkFlowTabForFoundationTemplate(String strYear, String strMonth,
			String strDate) {
		this.selectEffectiveDateOnBulkWorkFlowTab(loc_inpEffectiveDateForFoundationTemplate, strYear, strMonth,
				strDate);
	}

	public void selectBulkWorkFlowDropDownOnFoundationTemplatePage(String strDropdownID, String strActionDropdown) {
		By locator = By.xpath("//select[@id='" + strDropdownID + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strActionDropdown + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void selectEffectiveDateOnWorkFlowStatePopUpPageForFoundationTemplate(String strYear, String strMonth,
			String strDate) {
		objPojo.getObjWrapperFunctions().datePickerForSHActionClick(loc_inpEffectiveDateForFoundationTemplate, strYear,
				strMonth, strDate);
		objPojo.getObjUtilities().logReporter(
				"Select date as '" + strDate + "', month as '" + strMonth + "', year as '" + strYear
						+ "' from calender.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpEffectiveDateForFoundationTemplate));
	}

	public void selectBulkWorkFlowDropDownForPackageBuildsModule(String strActionDrpdownValue) {
		By locator = By
				.xpath("//option[text()='" + strActionDrpdownValue + "']//parent::select[@id='WFbulkDDLPortfolio']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strActionDrpdownValue + "' from action dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDrpdownValue, "Text"));
	}

	public void verifyManageWorkFlowStatesPopUpOfAccountPage() {
		objPojo.getObjUtilities().logReporter("Verify Manage WorkFlow States Pop Up is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_PopUpHrdManangeWorkFlowStatesOfAccount));

	}

	public void selectDropDownOptionOnManageWorkFlowStatePopUpOfAccountPage(String strActionDrpdownValue,
			String strIdOfActionDropDown) {
		By locator = By.xpath("//option[text()='" + strActionDrpdownValue + "']//parent::select[@id='"
				+ strIdOfActionDropDown + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strActionDrpdownValue + "' from action dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDrpdownValue, "Text"));
	}

	// Start the index from 2 as for 1st index it gives column name text value
	public String getAnyValueOfParticularColumnFromManageWorkflowStates(String strColumnName, String strColId,
			int intRowIndex) {
		By locator = By.xpath(
				"(//div[@id='workflowStatesGridFoundation']//div[@col-id='" + strColId + "'])[" + intRowIndex + "]");
		String strTextValueOfColumnRows = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get column '" + strColumnName + "' value as '" + strTextValueOfColumnRows + "' ",
				!strTextValueOfColumnRows.equals(""));
		return strTextValueOfColumnRows;
	}

	public void clickOnFilterIcon(String strColumnName, int intColumnIndex) {
		By locator = By
				.xpath("(//span[text()='Manage Workflow States']/parent::div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/following-sibling::div[@id='workflowStatesDialogFoundation']//span[@class='ag-icon ag-icon-filter'])["
						+ intColumnIndex + "]");
		objPojo.getObjUtilities().logReporter(
				"Click on filter icon for column '" + strColumnName + "' on portfolio page ",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnSelectAllFilterToDeselect() {
		By loc_chkBoxTextSelectAll = By.xpath("//span[@class='ag-filter-value'][contains(.,'(Select All)')]");
		objPojo.getObjWrapperFunctions().scrollToView(loc_chkBoxTextSelectAll);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxTextSelectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select all check box to deselect it.",
				objPojo.getObjWrapperFunctions().click(loc_chkBoxTextSelectAll));
	}

	public ArrayList<String> getListOfColumValuesFromFilterContainer(int intTotalNoOFRecords) {
		ArrayList<String> lstColumnValuesOfFilterContainer;
		lstColumnValuesOfFilterContainer = new ArrayList<>();
		By locator = By.xpath(
				"//span[@class='ag-icon ag-icon-checkbox-unchecked']//ancestor::label[@class='ag-set-filter-item']//descendant::span[@class='ag-filter-value']");
		List<WebElement> list = objPojo.getObjWrapperFunctions().getWebElementList(locator);
		int intListSize = list.size();
		System.out.println("list size::" + intListSize);
		if (intListSize >= intTotalNoOFRecords) {
			for (int index = 1; index <= intTotalNoOFRecords; index++) {
				By loc_txtValuesOfFilterConatiner = By
						.xpath("(//span[@class='ag-icon ag-icon-checkbox-unchecked']//ancestor::label[@class='ag-set-filter-item']//descendant::span[@class='ag-filter-value'])["
								+ index + "]");
				objPojo.getObjWrapperFunctions().scrollToView(loc_txtValuesOfFilterConatiner);
				String strColumnValue = objPojo.getObjWrapperFunctions().getText(loc_txtValuesOfFilterConatiner, "text")
						.trim();
				lstColumnValuesOfFilterContainer.add(strColumnValue);
			}
		} else {
			objPojo.getObjUtilities().logReporter("Size of list is less than the number of records you are validating",
					false);
		}
		return lstColumnValuesOfFilterContainer;
	}

	public void verifyColumnsWithCheckboxAppended(List<String> lstOfColumnValuesOfFilter, int intTotalNoOFRecords) {
		Boolean blnStatus = false;
		int intListSize = lstOfColumnValuesOfFilter.size();
		if (intListSize >= intTotalNoOFRecords) {
			for (int index = 0; index < intTotalNoOFRecords; index++) {
				String strColumnValueOFFilterContainer = lstOfColumnValuesOfFilter.get(index);
				if (!strColumnValueOFFilterContainer.equals("")) {
					By locator = By.xpath("//span[normalize-space(text())='" + strColumnValueOFFilterContainer
							+ "'and @class='ag-filter-value']//parent::label[@class='ag-set-filter-item']//child::span[@class='ag-icon ag-icon-checkbox-unchecked']");
					objPojo.getObjWrapperFunctions().scrollToView(locator);
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
					blnStatus = true;
				}
			}
			objPojo.getObjUtilities().logReporter("User can see columns with checkboxes appended", blnStatus);
		} else {
			objPojo.getObjUtilities().logReporter("Size of list is less than the number of records you are validating",
					false);
		}
	}

	public String enterFilterOption(String strFilterName) {
		objPojo.getObjUtilities().logReporter("Verify user can enter '" + strFilterName + "' in filter search box",
				objPojo.getObjWrapperFunctions().setText(loc_inputTextInFilterBox, strFilterName));
		return strFilterName;
	}

	public String verifyTheSearchedValueOfFilteredOption(String strFilterName) {
		By locator = By.xpath("//span[@class='ag-filter-value'][contains(text(),'" + strFilterName + "')]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see searched result for filter name '" + strFilterName + "'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		return strFilterName;
	}

	public void clickOnColumnText(String strColumnText) {
		By locator = By.xpath("//div[text()='" + strColumnText + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strColumnText + "' text",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public String clickOnCheckBoxFromFilterOptions(String strFilterValue) {
		By locator = By.xpath("//span[@class='ag-filter-value'][contains(text(),'" + strFilterValue + "')]");
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strFilterValue + "' checkbox",
				objPojo.getObjWrapperFunctions().click(locator));
		return strFilterValue;
	}

	public void clickOnClearFilterOrApplyFilterButtonFromFilters(String strFilterName) {
		By locator = By.xpath("//button[@type='button'][contains(.,'" + strFilterName + "')]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strFilterName + "' filter",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyValuesSelectedInSearchTextBoxOfFilterAreDisplayedInDisabledSearchBoxOfColumn(int strColumnIndex) {
		By locator = By
				.xpath("((//span[text()='Manage Workflow States'])[2]/parent::div/following-sibling::div[@id='workflowStatesDialogFoundation']//input[@ref='eColumnFloatingFilter'])["
						+ strColumnIndex + "]");

		objPojo.getObjUtilities().logReporter(
				"Verify Values Selected In Search Text Box Of Filter Are Displayed In Disabled Search Box Of Column",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyFilterIsNotAppliedAfterApplyingFilterWithOutDeselectingSelectAllCheckbox(String strColumnID) {
		/* String strColumnValueRow2=""; */
		By locator = By.xpath("(//div[@id='workflowStatesGridFoundation']//div[@col-id='" + strColumnID + "'])[3]");
		/*
		 * strColumnValueRow2=objPojo.getObjWrapperFunctions().getText(locator,
		 * "text"); System.out.println(strColumnValueRow2);
		 */
		objPojo.getObjUtilities().logReporter(
				"Verify filter is not applied after applying filter without deselecting select all checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	By loc_inputTextInFilterBox = By.xpath("//input[@class='ag-filter-filter'][@type='text']");

	public void clickOnReloadGrid() {
		By locator = By.xpath("//span[@id='refreshWFGrid']");
		objPojo.getObjUtilities().logReporter("Click on reload option",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void verifyFilteredValueShouldNotBeVisibleAfterApplyingFilterWithOutDeselectingSelectAllCheckbox(
			String strColumnID, String strFiltredValue) {
		String strColumnValueRow2 = "";
		By locator = By.xpath("(//div[@id='workflowStatesGridFoundation']//div[@col-id='" + strColumnID + "'])[3]");
		strColumnValueRow2 = objPojo.getObjWrapperFunctions().getText(locator, "text");
		System.out.println(strColumnValueRow2);
		objPojo.getObjUtilities().logReporter(
				"Verify user Should not see filtered value '" + strFiltredValue + "' on Manage workflow states pop up",
				!strColumnValueRow2.equals(strFiltredValue));
	}

	// Start the index from 2 as for 1st index it gives column name text value
	public String getAnyValueOfParticularColumnFromManageWorkflowStatesWithSpanTag(String strColumnName,
			String strColId, int intRowIndex) {
		By locator = By.xpath("(//div[@id='workflowStatesGridFoundation']//div[@col-id='" + strColId + "'])["
				+ intRowIndex + "]/span/span");
		String strTextValueOfColumnRows = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get column '" + strColumnName + "' value as '" + strTextValueOfColumnRows + "' ",
				!strTextValueOfColumnRows.equals(""));
		return strTextValueOfColumnRows;
	}

	public void verifyColumnsDisplayedAtTheBulkWorkflowTab(String strData) {
		By locator = By.xpath("//div[@class='ag-body-viewport']//following::div[@class='ag-header-row']//div[@col-id='"
				+ strData + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see " + strData + " column data",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyColumnsDisplayedAtBulkWorkflowTabOfPackageBuildTab(String strData) {
		By locator = By
				.xpath("//div[@class='ag-header-viewport']//following::div[@class='ag-header-row']//div[@col-id='"
						+ strData + "']");
		objPojo.getObjUtilities().logReporter("Verify user can see " + strData + " column data",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyDropdownOptionsOfSelectSourceWorkflowStateDrpDownForSelectSourceCategory(
			String strDropdownValue) {
		By locator = By.xpath("//select[@id='sourceworkflowStatesDDLFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown Slect Source Workflow State ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValue + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValue));
	}

	public void verifyDropdownOptionsOfSelectSourceWorkflowStateDropDownAfterSelectingFoundationConfigOption(
			String strDropdownValue) {
		By locator = By.xpath("//select[@id='targetworkflowStatesDDLFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown Slect Source Workflow State ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValue + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValue));
	}

	public void clickOnProceedButtonOnWorkFlowManageStatesPopup(String strModuleID) {
		By loc_btnProceed = By.xpath("//button[@type='button'][text()='Proceed' and @id='" + strModuleID + "']");
		objPojo.getObjUtilities().logReporter("click on Proceed button on manage workflow State Popup",
				"user should able to click on Proced button on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().click(loc_btnProceed));
	}

	public void clickOnCloseButtonOnManageWorkflowStatesPopUp(String strConfirmMessage) {
		By loc_btnClose = By
				.xpath("//p[text()='" + strConfirmMessage + "']/ancestor::div/child::div[11]/div/child::button");
		objPojo.getObjUtilities().logReporter("Verify user can click on close button",
				"User should click on close button", "User is able to click on yes button",
				objPojo.getObjWrapperFunctions().click(loc_btnClose));
	}

	public void verifyEffectiveDateFieldIsDisplayedOnBulkWorkflowTab() {
		objPojo.getObjUtilities().logReporter("Verify 'Effective Date' field is displayed on Bulk Workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpEffectiveDateForFoundationTemplate));
	}

	public void verifyUserCanEnterAndSetDateInEffectiveDateInputFieldOnBulkWorkflowTab(String strInputDate) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can type " + strInputDate + " date in 'Effective Date' input field",
				objPojo.getObjWrapperFunctions().setText(loc_inpEffectiveDateForFoundationTemplate, strInputDate));
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_inpEffectiveDateForFoundationTemplate, "enter");
		strReturnValue = objPojo.getObjWrapperFunctions().getAttribute(loc_inpEffectiveDateForFoundationTemplate,
				"value");
		objPojo.getObjUtilities().logReporter("Verify " + strInputDate + " date is set in'Effective Date' input field",
				strReturnValue.equals(strInputDate));
	}

	public void selectEffectiveDateOnBulkWorkFlowTab(String strMonth, String strDate, String strYear) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strMonth + "/" + strDate + "/" + strYear
						+ "' as 'Effective Date' on Bulk WorkFlow tab from Calender.",
				objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconEffectiveDateForFoundationTemplate, strYear,
						strMonth, strDate));
	}

	public void verifyManageWorkFlowStatesPopUpIsDisplayedOnFoundationTemplatePage() {
		objPojo.getObjUtilities().logReporter("Verify Manage WorkFlow States Pop Up is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_titleManageWorkFlowStates));

	}

	public void selectBulkWorkFlowDropDown(String strDrpDwnName, String strSelectID, String strDrpDwnOptn) {
		By locator = By.xpath(
				"(//label[contains(.,'" + strDrpDwnName + "')]/parent::div//select[@id='" + strSelectID + "'])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strDrpDwnOptn + "' dropdown option from " + strDrpDwnName + " dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strDrpDwnOptn, "Text"));
	}

	public String getSelectedDropdownOptionFromBulkWorkFlowDropdownFields(String strDrpDwnName, String strSelectID) {
		By locator = By.xpath(
				"(//label[contains(.,'" + strDrpDwnName + "')]/parent::div//select[@id='" + strSelectID + "'])[1]");
		String strDropdownOption = objPojo.getObjWrapperFunctions().getSelectedValueFromDropDown(locator);
		objPojo.getObjUtilities().logReporter(
				"Veify user can get selected dropdown option from '" + strDrpDwnName + "' Dropdown",
				!strDropdownOption.equals(""));
		return strDropdownOption;
	}

	public void verifyBulkWorkFlowDropDownIsDisplayed(String strDrpDwnName, String strSelectID) {
		By locator = By.xpath(
				"(//label[contains(.,'" + strDrpDwnName + "')]/parent::div//select[@id='" + strSelectID + "'])[1]");
		objPojo.getObjUtilities().logReporter("Verify " + strDrpDwnName + " dropdown is Displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyBulkWorkFlowDropDownIsEnabled(String strDrpDwnName, String strSelectID) {
		By locator = By.xpath(
				"(//label[contains(.,'" + strDrpDwnName + "')]/parent::div//select[@id='" + strSelectID + "'])[1]");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDrpDwnName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	/**
	 * Scenario: 171518 Description: AG grid_79387_TC120_Verify filter
	 * functionality on Portfolio Screen for Bulk WF Update>>Manage Workflow
	 * States Popup
	 */
	public void clickOnFilterIconOnPortfolioPage(String strColumnName, int intColumnIndex) {
		By locator = By
				.xpath("(//span[text()='Manage Workflow States']//following::span[@class='ag-icon ag-icon-filter'])['"
						+ intColumnIndex + " ']");

		objPojo.getObjUtilities().logReporter(
				"Click on filter icon for column '" + strColumnName + "' on portfolio page ",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public String getAnyValueOfParticularColumnFromManageWorkflowStatesOnPortfolioWithSpanTag(String strColumnName,
			String strColId, int intRowIndex) {
		By locator = By
				.xpath("(//div[@id='workflowStatesGrid']//div[@col-id='" + strColId + "'])['" + intRowIndex + "']");
		/*
		 * (//div[@id='workflowStatesGridFoundation']//div[@col-id='
		 * " + strColId + "'])[" + intRowIndex + "]span/span
		 */
		String strTextValueOfColumnRows = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get column '" + strColumnName + "' value as '" + strTextValueOfColumnRows + "' ",
				!strTextValueOfColumnRows.equals(""));
		return strTextValueOfColumnRows;
	}

	public String getAnyValueOfParticularColumnFromManageWorkflowStatesOnPortfolio(String strColumnName,
			String strColId, int intRowIndex) {
		By locator = By
				.xpath("(//div[@id='workflowStatesGrid']//div[@col-id='" + strColId + "'])['" + intRowIndex + "']");
		String strTextValueOfColumnRows = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get column '" + strColumnName + "' value as '" + strTextValueOfColumnRows + "' ",
				!strTextValueOfColumnRows.equals(""));
		return strTextValueOfColumnRows;
	}

	public void verifyManageWorkFlowStatesPopUpOnProductBuild() {
		objPojo.getObjUtilities().logReporter("Verify Manage WorkFlow States Pop Up is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ManageWorkFlowStatesProductBuild));

	}

	/**
	 * Scenario: 171519 Description: AG grid_79387_TC123_Verify filter
	 * functionality on Portfolio>>Package Build Screen for Bulk WF
	 * Update>>Manage Workflow States Popup
	 **/
	public void clickOnBulkWorkFlowIconOnPackageBuild() {
		objPojo.getObjUtilities().logReporter("Verify Hearing product type is displaying ",
				"Verify Hearing product type  is displaying '" + loc_BulkWorkFlowUpdatePackageBuilld + "'",
				"Verify Hearing product type  is displaying'" + loc_BulkWorkFlowUpdatePackageBuilld + "'",
				objPojo.getObjWrapperFunctions().click(loc_BulkWorkFlowUpdatePackageBuilld));
	}

	public void verifyValuesSelectedInSearchTextBoxOfFilterAreDisplayedInDisabledSearchBoxOfColumnPortfolipPage(
			int strColumnIndex) {
		By locator = By
				.xpath("((//span[text()='Manage Workflow States'])/parent::div/following-sibling::div[@id='workflowStatesDialog']//input[@ref='eColumnFloatingFilter'])["
						+ strColumnIndex + "]");
		objPojo.getObjUtilities().logReporter(
				"Verify Values Selected In Search Text Box Of Filter Are Displayed In Disabled Search Box Of Column",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyFilterIsNotAppliedAfterApplyingFilterWithOutDeselectingSelectAllCheckboxOnPortfolioPage(
			String strColumnID) {
		/* String strColumnValueRow2=""; */
		By locator = By.xpath("(//div[@id='workflowStatesGrid']//div[@col-id='" + strColumnID + "'])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify filter is not applied after applying filter without deselecting select all checkbox",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void clickOnFilterIconOnManageWorkflowStates(String ColumnName, int intColumnIndex) {
		By locator = By
				.xpath("(//span[text()='Manage Workflow States']//following::span[@class='ag-icon ag-icon-filter'])["
						+ intColumnIndex + "]");
		objPojo.getObjUtilities().logReporter("Click on filter icon for column '" + ColumnName + "' on portfolio page ",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public String getExecutionDateColumnDataOnBulkWorkflowLogTab(String strFolderName, String strExecutionDate_id,
			String strData, String strUpdatedBy_Id) {
		By locator = By
				.xpath("//div[text()='" + strFolderName + "']/following-sibling::div[@col-id='" + strExecutionDate_id
						+ "' and text()='" + strData + "']/parent::div/div[@col-id='" + strUpdatedBy_Id + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strValueOfExecutionDate = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter("Verify user can see the date '" + strData + "' in the clolumn ",
				!strValueOfExecutionDate.equals(""));
		return strValueOfExecutionDate;
	}

	public String getAnyValueForColumnWithParticularFolderName(String strFolderName, String strCol_id) {
		By locator = By
				.xpath("//div[text()='" + strFolderName + "']/following-sibling::div[@col-id='" + strCol_id + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strValueOfUpdatedByColumn = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter("Verify user can see the date '" + strCol_id + "' in the clolumn ",
				!strValueOfUpdatedByColumn.equals(""));
		return strValueOfUpdatedByColumn;

	}

	public void clickOnFolderNameCheckBoxToSelectMultipleFoldersInBulkWFTab(int intIndex) {
		By locator = By
				.xpath("//span[text()='Manage Workflow States']/following::div[@col-id='FolderName']/parent::div[@row-id='"
						+ intIndex + "']/child::div/descendant::span[2]");
		objPojo.getObjUtilities().logReporter(" user can select Folders in list",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyTheHeaderOfManageWorkflowStatesPopUp() {
		objPojo.getObjUtilities().logReporter("Verify user can see Manage workflow state pop up column data",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrManageWorkFlowStateOnFT));
	}

	public void verifyTabsOnManageWorkflowStatePopUp(String strTabName) {
		By locator = By.xpath("(//span[text()='Manage Workflow States']/following::a[text()='" + strTabName + "'])[3]");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see " + strTabName + " On Manage workflow State pop up",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyFieldsOnBulkWorkflowTabOnFT(String strFieldName) {
		By locator = By.xpath("//div//label[@id='" + strFieldName + "']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see " + strFieldName + " field under bulk workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyColumnsDisplayedAtTheBulkWorkflowLogTab(String strFieldName) {
		By locator = By.xpath("//div[text()='" + strFieldName + "']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify user can see " + strFieldName + " column under bulk workflow ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyDropdownOptionsFromParticularFiled(String strDropdownValues) {
		By locator = By
				.xpath("((//label[contains(text(),'Action')])[3])//following::select[@id='WFBulkDDLActionFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public String getValueOfAnyColumnForParticularExecutionDateOnBulkWorkflowLogTab(String strFolderName,
			String strExecutionDate, String strCol_Id) {
		By locator = By.xpath("//div[text()='" + strFolderName
				+ "' and @col-id='FolderName']/following-sibling::div[@col-id='ExecutionDate' and .='"
				+ strExecutionDate + "']/parent::div/div[@col-id='" + strCol_Id + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strValueOfUpdatedByColumn = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get UpdatedBy column Value as " + strValueOfUpdatedByColumn + "",
				!strValueOfUpdatedByColumn.equals(""));
		return strValueOfUpdatedByColumn;
	}

	public String getColumnNameOnBulkWorkflowLogTab(String strColumnName) {
		By locator = By.xpath("//span[text()='Manage Workflow States']/following::div[text()='" + strColumnName + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strGetColumnName = objPojo.getObjWrapperFunctions().getText(locator, "Text");
		objPojo.getObjUtilities().logReporter("Verify user can get Value of column name", !strGetColumnName.equals(""));
		return strGetColumnName;
	}

	public String getFirstValueOfParticularColumnOnBulkWorkflowLogTab(String strCol_Id) {
		By locator = By.xpath("//span[text()='Manage Workflow States']/ancestor::div//div[@row-index='0']/div[@col-id='"
				+ strCol_Id + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strColumnValue = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter("Verify user can get Value of column name", !strColumnValue.equals(""));
		return strColumnValue;
	}

	/* 215873 */
	public void getValueOfParticularColumnOnBulkWorkflowLogTab(String strCol_Id) {
		By locator = By.xpath("//span[text()='Manage Workflow States']/ancestor::div//div[@row-index='0']/div[@col-id='"
				+ strCol_Id + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strColumnValue = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter(
				"Verify user can get Value " + strColumnValue + " of " + strCol_Id + " column name",
				!strCol_Id.equals(""));

	}

	public void verifyDropdownIsHiddenOnBulkWorkFlowTabForFoundationTemplate(String strDropdownName) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[3]/parent::div[1]/descendant::select[1]");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is hidden ",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(locator));
	}

	public void verifyMinorVersionOnBulkWorkFlowTabForFoundationTemplate() {
		objPojo.getObjUtilities().logReporter("Verify minor version folder is present",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_folderMinorVersion));
	}

	public String getColumnFieldDataDisplayedAtTheBulkWorkflowTab(String strColID) {
		By locator = By
				.xpath("(//div[@class='ag-body-viewport']//following::div[@row-index='0'])[3]//child::div[@col-id='"
						+ strColID + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().waitFor(2);
		String strActualColData = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter("Getting column data " + strActualColData + " for column ID " + strColID,
				!strActualColData.equals(""));
		return strActualColData;

	}

	public String getValueOfAnyColumnForParticularVersionOnBulkWorkflowLogTab(String strFolderName, String strTargateWF,
			String strCol_Id) {
		By locator = By.xpath("//div[text()='" + strFolderName
				+ "' and @col-id='FolderName']/following-sibling::div[@col-id='TargetWF' and .='" + strTargateWF
				+ "']/parent::div/div[@col-id='" + strCol_Id + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strValueOfFolderVersionColumn = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter("Verify user can get Folder Version column Value as "
				+ strValueOfFolderVersionColumn + " of " + strFolderName + "",
				!strValueOfFolderVersionColumn.equals(""));
		return strValueOfFolderVersionColumn;
	}

	public void clickOnCloseTickToCloseManageWorkflowStatesPopUP() {
		objPojo.getObjUtilities().logReporter("Verify Close Manage Work flow States Pop UP",
				objPojo.getObjWrapperFunctions().click(loc_CloseManageWorkflowStatesPopUP));
	}

	public void clickOnCloseTickToCloseManageWorkflowStatesPopUPForFT() {
		objPojo.getObjUtilities().logReporter("Verify Close Manage Work flow States Pop UP",
				objPojo.getObjWrapperFunctions().click(loc_CloseManageWorkflowStatesPopUPFT));
	}

	/* 215965 */
	public void verifyEffectiveDateFieldIsDisplayedOnBulkWorkflowTabForPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify 'Effective Date' field is displayed on Bulk Workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpEffectiveDateForPortfolio));
	}

	public void verifyUserCanEnterAndSetDateInEffectiveDateInputFieldOnBulkWorkflowTabOnPortfolio(String strInputDate) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can type " + strInputDate + " date in 'Effective Date' input field",
				objPojo.getObjWrapperFunctions().setText(loc_inpEffectiveDateForPortfolio, strInputDate));
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_inpEffectiveDateForPortfolio, "enter");
		strReturnValue = objPojo.getObjWrapperFunctions().getAttribute(loc_inpEffectiveDateForPortfolio, "value");
		objPojo.getObjUtilities().logReporter("Verify " + strInputDate + " date is set in'Effective Date' input field",
				strReturnValue.equals(strInputDate));
	}

	public void selectEffectiveDateOnBulkWorkFlowTabForPortfolio(String strMonth, String strDate, String strYear) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strMonth + "/" + strDate + "/" + strYear
						+ "' as 'Effective Date' on Bulk WorkFlow tab from Calender.",
				objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconEffectiveDateForPortfolio, strYear, strMonth,
						strDate));
	}

	public void verifyManageWorkFlowStatesPopUpIsDisplayedOnPortfolioPage() {
		objPojo.getObjUtilities().logReporter("Verify Manage WorkFlow States Pop Up is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_titleManageWorkFlowStatesPF));

	}

	public void verifyEffectiveDateOfCalenderIsEnabledOnBulkWorkFlowTabPortfolio(String strDropdownName) {
		By locator = By.xpath("(//label[contains(text(),'" + strDropdownName + "')])[5]//following-sibling::input");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void clickOnCloseButtonFieldsOfAddMacroPopup() {
		objPojo.getObjUtilities().logReporter("Cick on Cancle Manage Workflow States Button",
				objPojo.getObjWrapperFunctions().click(loc_cancleManaheWorkflowstatesPopup));
	}

	public void verifyVersionUpdatedToNextYear(String strYear) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("//div[text()='Bulk Workflow Log']/following::div[text()='" + strYear
				+ "_0.01' and @col-id='Version']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can Verify Updated Year Version of Bulk Workflow ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyDropdownOptionsFromTargetWorkflowState(String strDropdownValues) {
		By locator = By.xpath(
				"((//label[contains(text(),'Select Target Workflow State')])[3])//following::select[@id='targetworkflowStatesDDLFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	// 215956
	public void verifyHeaderOfManageWorkflowStatesPopUp(String strIndex) {
		By locator = By.xpath("(//div//child::span[text()='Manage Workflow States'])[" + strIndex + "]");
		objPojo.getObjUtilities().logReporter("Verify user can see Manage workflow status Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyTabOnManageWorkFlowStatePopupForPortfolio(String strTabName) {
		By locator = By.xpath("(//a[text()='" + strTabName + "'])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see '" + strTabName + "'Tab  from Manage WorkFlow Status Popup ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyFieldsDisplayAfterClickingBulkWorkflowForPortfolio(String strFieldname) {
		By locator = By.xpath("(//label[contains(text(),'" + strFieldname + "')])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see Field'" + strFieldname + "'Afetr clicking Bulk Workflow",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyFileldsDisplayedAfterChangingTab(String strColumnName) {
		By locator = By.xpath("//div[text()='" + strColumnName + "']");
		objPojo.getObjUtilities().logReporter("Verify user can see Field'" + strColumnName + ".",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void clickToSwitchTabOnManageWorkFlowStatus(String strTabName, String strIndex) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("(//span[text()='Manage Workflow States']/following::a[text()='" + strTabName + "'])["
				+ strIndex + "]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can Navigate on " + strTabName + " Tab",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void verifyDropdownOptionsFromActionField(String strDropdownValues) {
		By loc_action = By.xpath("//select[@id='WFbulkDDLPortfolio']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_action, strDropdownValues));
	}

	public void verifyDropdownOptionsFromSelectSourceCategoryField(String strDropdownValues) {
		By locator = By.xpath("//select[@id='WFcategoryDDL']");
		// label[contains(text(),'Action')]//following::select[@id='WFbulkDDLPortfolio']/option[text()='"+strDropdownValues+"']
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromSelectSourceWorkflowStateField(String strDropdownValues) {
		By locator = By.xpath("//select[@id='sourceworkflowStatesDDL']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromApprovalStatusField(String strDropdownValues) {
		By locator = By.xpath("//select[@id='approvaltypestatuslistPortfolio']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void selectBulkWorkFlowDropDownOptionForAllModule(String strLabletext, String strindex,
			String strDropdownValue) {
		By locator = By.xpath("(//label[contains(text(),'" + strLabletext + "')])[" + strindex
				+ "]/parent::div[1]/descendant::select[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownValue + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strDropdownValue, "Text"));
	}

	/* 215878 */
	public void selectEffectiveDateOnBulkWorkFlowTabForAccount(String strMonth, String strDate, String strYear) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strMonth + "/" + strDate + "/" + strYear
						+ "' as 'Effective Date' on Bulk WorkFlow tab from Calender.",
				objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconEffectiveDateForAccount, strYear, strMonth,
						strDate));
	}

	public void selectBulkWorkFlowDropDownForAccount(String strDropdownName, String strActionDropdown) {
		By locator = By
				.xpath("(//label[contains(text(),'" + strDropdownName + "')])[2]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public String getStatusOfParticularFolderName(String strColumnName, String strStatusValue) {
		By locator = By.xpath("//div[@col-id='" + strColumnName + "' and text()='" + strStatusValue + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		String strValueOfUpdatedByColumn = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();
		objPojo.getObjUtilities().logReporter("Verify user can see '" + strStatusValue + "' is updated in the column ",
				!strValueOfUpdatedByColumn.equals(""));
		return strValueOfUpdatedByColumn;

	}

	// 215850

	public void verifyDropdownOptionsFromSourceCategoryInFT(String strDropdownValues) {
		By locator = By.xpath(
				"//label[contains(text(),'Select Source Category ')]//following::select[@id='WFcategoryDDLFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromSourceWorkflowStateInFT(String strDropdownValues) {
		By locator = By.xpath(
				"//label[contains(text(),'Select Source Workflow State ')]//following::select[@id='sourceworkflowStatesDDLFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromApprovalStatusInFT(String strDropdownValues) {
		By locator = By.xpath(
				"//label[contains(text(),'Approval Status')]//following::select[@id='approvaltypestatuslistFoundation']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public String verifyListofVersion() {

		By loc_versionList = By.xpath("(//div[@class='ag-header-row']//div[@col-id='VersionNumber'])[2]");
		List<WebElement> RowList = objPojo.getObjWrapperFunctions().getWebElementList(loc_versionList);
		int size = RowList.size();
		for (int intIndex = 1; intIndex <= size; intIndex++) {
			By loc_version = By.xpath("(//div[text()='2022_1.0'])['" + intIndex + "']");
			objPojo.getObjWrapperFunctions().scrollToViewDown(loc_version);
			String strVersion = objPojo.getObjWrapperFunctions().getText(loc_version, "Text");
			System.out.println("+ Version ");
			objPojo.getObjUtilities().logReporter("Verify the Major version is displayed", !strVersion.equals(""));
		}
		return strReturnValue;

	}

	/**
	 * Scenario: 215996 Description: Bulk WF_Verify the fields at the "Bulk
	 * Workflow Tab" enable and disable functionality when user selects "Action
	 * = Renew"
	 */

	public void verifyEffectiveDateIsEnabledOnBulkWorkFlowTabForPortfolio(String strDropdownName) {
		By locator = By.xpath("(//label[contains(text(),'" + strDropdownName + "')])[5]//following-sibling::input");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void verifyBulkWorkFlowDropDownIsEnabledUsingID(String strDropDownId) {
		By locator = By.xpath("//select[@id='" + strDropDownId + "']");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropDownId + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	/**
	 * Scenario: TCID_216000 Description:Verify the Folders list pulled at the
	 * Manage workflow State when user selects the Action Finalize and Renew
	 * option
	 */

	public void selectBulkWorkFlowDropDownForPortfolioUpdated(String strDropdownName, String strActionDropdown,
			int index) {
		By locator = By.xpath("(//label[contains(text(),'" + strDropdownName + "')])[" + index
				+ "]/parent::div[1]/descendant::select");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void verifyFolderAtManageWorkflowState(String strFolderName) {
		objPojo.getObjWrapperFunctions().waitFor(5);
		By loc_FolderCheckbox = By.xpath("//span[text()='Manage Workflow States']/following::div[text()='"
				+ strFolderName + "' and @col-id='FolderName']/parent::div/child::div/descendant::span[1]");
		objPojo.getObjUtilities().logReporter("click on Folder checkbox on manage workflow State Popup",
				"user should able to click on Folder checkbox on manage workflow State Popup",
				"user is able to click on Folder checkbox on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_FolderCheckbox));
	}

	public void verifyTabsOnManageWorkflowTabsForAccount(String strTabName) {
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		By locator = By.xpath("(//span[text()='Manage Workflow States']/following::a[text()='" + strTabName + "'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can see '" + strTabName + "' Tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	/* 216012 */

	public void verifyDropdownAtAccount(String DropdownName) {
		By locator = By.xpath("(//label[text()='" + DropdownName + "'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can see  " + DropdownName + " dropdown  ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	// 215953 - Verify User Can Update The WF Status Using Bulk Workflow Update
	// Feature for Portfolio

	public void verifyListofMinorVersion() {

		By loc_versionList = By.xpath("(//div[@class='ag-header-row']//div[@col-id='VersionNumber'])[2]");
		List<WebElement> RowList = objPojo.getObjWrapperFunctions().getWebElementList(loc_versionList);
		int size = RowList.size();
		for (int intIndex = 1; intIndex <= size; intIndex++) {
			By loc_version = By.xpath("(//div[text()='2022_0.01'])['" + intIndex + "']");
			objPojo.getObjWrapperFunctions().scrollToViewDown(loc_version);
			String strVersion = objPojo.getObjWrapperFunctions().getText(loc_version, "Text");
			objPojo.getObjUtilities().logReporter("Verify only Minor version is displayed ", !strVersion.equals(""));
		}
	}

	public void verifyEffectiveDateOnBulkWFIsEnabledInPortfolio() {

		objPojo.getObjUtilities().logReporter("Verify Effective Date is Enabled in the Bulk Workflow",
				objPojo.getObjWrapperFunctions().checkElementEnabled(loc_EffectiveDatePortfolio));
	}

	// 215855
	public void clickOnCheckBoxInFoundationTemplateSearch(String strFolderName) {
		By locator = By.xpath("//div[@id='workflowStatesGridFoundation']//div[text()='" + strFolderName
				+ "']//parent::div/child::div/descendant::span[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify User can able to Click onto Selected Folder CheckBox",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public boolean isStatusOfBulkWorkFlowStatusColumnDisplayed(String strFolderName, String strStatus) {
		Boolean blnReturnStatus;
		By loc_SuccessStatus = By.xpath("//div[@id='workflowStatesGridFoundation']//following::div[text()='"
				+ strFolderName + "' and @col-id='FolderName']//following-sibling::div[@col-id='Status']//span[text()='"
				+ strStatus + "']");
		By loc_Failure = By.xpath("//div[@id='workflowStatesGridFoundation']//following::div[text()='" + strFolderName
				+ "' and @col-id='FolderName']//following-sibling::div[@col-id='Status']//span[text()='Failure']");

		blnReturnStatus = false;
		int intIndex = 0;
		while (!blnReturnStatus) {
			objPojo.getObjUtilities().logReporter("Refresh page",
					objPojo.getObjWrapperFunctions().click(loc_iconRefreshGrid));
			// objPojo.getObjWrapperFunctions().sendFunctionKeys("F5"));
			objPojo.getObjWrapperFunctions().waitFor(5);
			blnReturnStatus = objPojo.getObjWrapperFunctions().isElementDisplayed(loc_SuccessStatus);
			intIndex++;
			if (objPojo.getObjWrapperFunctions().isElementDisplayed(loc_SuccessStatus)) {
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_SuccessStatus);
				blnReturnStatus = true;
				break;
			}
			if (objPojo.getObjWrapperFunctions().isElementDisplayed(loc_Failure)) {
				blnReturnStatus = true;
				objPojo.getObjUtilities().logReporter("getting Failure Status-------->>", false);
				break;
			}
			if (intIndex > 20) {
				objPojo.getObjUtilities().logReporter("Not getting Success Status-------->>", false);
				break;
			}
			intIndex++;
		}
		System.out.println("To check how many times it runs:" + intIndex);
		return blnReturnStatus;
	}

	public void clickOnCloseIcon() {
		By locator = By.xpath(
				"//button[@id='workflowStateTransfer']//following::div//span[text()='Manage Workflow States']//following-sibling::a//span[text()='close']");
		objPojo.getObjUtilities().logReporter("Verify user can click on close icon. ",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void selectTheBulkWorkFlowDropDownForTargetcategory(String strDropdownName, String strActionDropdown) {
		By locator = By
				.xpath("(//label[contains(.,'Select Target Category')]/parent::div//select[@id='categoryDDL'])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void selectTheBulkWorkFlowDropDownForTargetWorkFlowState(String strDropdownName, String strActionDropdown) {
		By locator = By.xpath(
				"(//label[contains(.,'Select Target Workflow State')]/parent::div//select[@id='targetworkflowStatesDDLFoundation'])[1]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select dropdown option '" + strDropdownName + "' from section dropdown ",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strActionDropdown, "Text"));
	}

	public void verifyValuesSelectedInSearchTextBoxOfFilterAreDisplayedInDisabledSearchBoxOfColumnForManageWorkFlowStates() {
		By locator = By.xpath(
				"(//span[text()='Manage Workflow States'])[2]/parent::div/following-sibling::div[@id='workflowStatesDialogFoundation']//input[@ref='eColumnFloatingFilter']");
		String strDisabledText = objPojo.getObjWrapperFunctions().getAttributeValue(locator, "readonly");
		System.out.println("Disabled text is " + strDisabledText);
		objPojo.getObjUtilities().logReporter("User can see disabled text  ", strDisabledText.equals("true"));
	}

	public void verifyTheBulkWorkFlowDropDownIsEnableForTargetWorkFlowState(String strDropdownName) {
		By locator = By.xpath(
				"(//label[contains(.,'Select Target Workflow State')]/parent::div//select[@id='targetworkflowStatesDDLFoundation'])[1]");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	// created workFlow State 215951-215999-(DropDown):
	public void verifyTheBulkWorkFlowDropDownIsEnableForSelectSourceWorkFlowState(String strDropdownName) {
		By locator = By.xpath(
				" (//label[contains(.,'Select Source Workflow State ')]/parent::div//select[@id='sourceworkflowStatesDDLFoundation'])[1]");
		objPojo.getObjUtilities().logReporter("Verify Dropdown " + strDropdownName + " is enabled ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void verifyEffectiveDateFieldIsDisplayedOnBulkWorkflowTabOnPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify 'Effective Date' field is displayed on Bulk Workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_EffectiveDatePortfolio));

	}

	/**
	 * Scenario:216039 Description:Bulk Workflow_Verify user can updates the WF
	 * of the Multiple folder using the Bulk WF update
	 * 
	 */
	public void clickOnCheckboxToSelectAllFolder() {
		objPojo.getObjWrapperFunctions().waitFor(5);
		By loc_FolderCheckbox = By.xpath(
				"(//span[text()='Manage Workflow States']/following::div[@class='customTable']//following::input[@id='selectAllAccountBulkCheckBox'])[1]");
		objPojo.getObjUtilities().logReporter("click on  checkbox on manage workflow State Popup to select all folders",
				"user should able to click on  checkbox on manage workflow State Popup",
				"user is able to click checkbox on manage workflow State Popup",
				objPojo.getObjWrapperFunctions().actionClick(loc_FolderCheckbox));
	}

	public void verifyErrorMessagewhenUserSelectsMoreFolders(String strMessage) {
		By locator = By.xpath("//p[text()='" + strMessage + "']");
		objPojo.getObjUtilities().logReporter("Verify error message of " + strMessage + " Bulk Workflow Log ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}

	public void clickOnCloseButtonForErrorMessage() {
		By loc_btnClose = By.xpath(
				"//p[text()='Maximum 20 folder allow to proceed further. Please change your folder selection criteria.']/ancestor::div/child::div[11]/div/child::button");
		objPojo.getObjUtilities().logReporter("Verify user can click on close  button",
				"User should click on close button", "User is able to click on close button",
				objPojo.getObjWrapperFunctions().click(loc_btnClose));
	}

	public String getFolderNameFromFolderListOnManageWorkflowStatesPopUpPage() {
		By locator = By.xpath(
				"//span[text()='Manage Workflow States']/following::div[@col-id='FolderName']/parent::div[@row-id='0']/child::div[2]");
		String strFolderName = objPojo.getObjWrapperFunctions().getText(locator, "text").trim();

		return strFolderName;
	}

	public void verifyDropdownOptionsFromParticularField(String strDropdownValues) {
		By locator = By
				.xpath("(//label[contains(text(),'Action')])[1]//following::select[@id='WFBulkDDLActionAccount']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromSourceCategoryInAccount(String strDropdownValues) {
		By locator = By.xpath(
				"//label[contains(text(),'Select Source Category ')]//following::select[@id='WFcategoryDDLAccount']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromSourceWorkflowStateInAccount(String strDropdownValues) {
		By locator = By.xpath(
				"//label[contains(text(),'Select Source Workflow State ')]//following::select[@id='sourceworkflowStatesDDLAccount']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void verifyDropdownOptionsFromApprovalStatusInAccount(String strDropdownValues) {
		By locator = By.xpath(
				"//label[contains(text(),'Approval Status')]//following::select[@id='approvaltypestatuslistAccount']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValues + "' fronm dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValues));
	}

	public void clickOnCloseButtonOnManageWorkflowPopUpPage(String strErrorMessage) {
		By loc_btnClose = By
				.xpath("//p[text()='" + strErrorMessage + "']/ancestor::div/child::div[11]/div/child::button");
		objPojo.getObjUtilities().logReporter("Verify user can click on close button",
				"User should click on clode button", "User is able to click on close button",
				objPojo.getObjWrapperFunctions().click(loc_btnClose));
	}

	public void verifySelectSourceCategoryFieldsOnBulkWorkflowTab(String strFieldName) {
		By locator = By.xpath("//div//label[@id='" + strFieldName + "'][contains(text(),'Select Source Category')]");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see Select Source Category field under bulk workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void selectEffectiveDateOnManageWorkflowStatesWindow(String strYear, String strMonth, String strDate) {
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconCalender, strYear, strMonth, strDate);

		objPojo.getObjUtilities()
				.logReporter(
						"Select date as '" + strDate + "', month as '" + strMonth + "', year as '" + strYear
								+ "' from calender.",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconCalender));
	}

	public void closeManageWorkflowStatesWindow() {
		By locator = By
				.xpath("//span[text()='Manage Workflow States']//parent::div//descendant::span[text()='close'][1]");
		objPojo.getObjUtilities().logReporter("Close manage workflow states window",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyBulkWorkFlowDropDownForTargetWFCategory(String strDropdownName, String index) {
		By locator = By.xpath("(//label[contains(text(),'" + strDropdownName + "')])[" + index + "]");
		objPojo.getObjUtilities().logReporter("Verify user can see '" + strDropdownName + "' under bulk workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifySelectSourceCategoryLabel() {
		By labelSelectCategory = By.xpath("(//label[contains(text(),'Select Source Category')])[1]");
		objPojo.getObjUtilities().logReporter("Verify Select Source Category label is visible",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(labelSelectCategory));
	}

	public void verifyAndClickOnStatusOfFolderOnBulkWorkflowLog(String strFolderName, String strStatus) {
		By locator = By.xpath("//div[text()='Manage Workflow States']/following::div[text()='" + strFolderName
				+ "']//following-sibling::div[@col-id='Status']//span[text()='" + strStatus + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on'" + strStatus + "Status on Bulk Workflow log tab.",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyOnProcessButtonOnWorkFlowPopupForAccount() {
		By loc_closePopUpMsg = By.xpath(
				"//p[text()='Please refer to the Bulk Workflow Log to check the status of all the folder(s) that were processed for bulk workflow update.']");
		objPojo.getObjUtilities().logReporter(
				"User is able to see close pop up message'Please refer to the Bulk Workflow Log to check the status of all the folder(s) that were processed for bulk workflow update.'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_closePopUpMsg));
	}

	public void verifyFieldsDisplayAfterClickingBulkWorkflowForFoundation(String strFieldname) {
		By locator = By.xpath("(//label[@id='lblWFcategoryFoundation' and contains(text(),'" + strFieldname + "')])");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see Field'" + strFieldname + "'Afetr clicking Bulk Workflow",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyTargetFieldsOnBulkWorkflowTabFT(String strFieldId, String strFieldName) {
		By locator = By.xpath("//div//label[@id='" + strFieldId + "'][text()='" + strFieldName + "']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see " + strFieldName + " field on bulk workflow tab",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyDropdownOptionsForSelectTargetWorkflowStateDropDown(String strDropdownValue) {
		By locator = By.xpath(
				"//label[text()='Select Target Workflow State']/following::select[@id='targetworkflowStatesDDL']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown Slect Source Workflow State ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownValue + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownValue));
	}

	public void verifyOptionsForTargetWorkflowStateDropDown(String strDropdownOptions) {
		By locator = By.xpath(
				"//label[contains(text(),'Select Target Workflow State')]//parent::div//child::select[@id='targetworkflowStatesDDL']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownOptions + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownOptions));
	}

	public void verifyOptionsForSelectTargetWorkflowStateDropDown(String strDropdownOptions) {
		By locator = By.xpath(
				"//label[contains(text(),'Select Target Workflow State')]/parent::div//select[@id='targetworkflowStatesDDLFoundation']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownOptions + "' from dropdown list",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(locator, strDropdownOptions));
	}

	public void clickOnBulkWorkFlowIconFoundationTemp() {
		objPojo.getObjUtilities().logReporter("click on bulkwork flow icon ",
				objPojo.getObjWrapperFunctions().click(loc_icnBulkWorkflowFoundation));
	}

	// Verify column Text
	public void verifyColumnText(String strColumnText) {
		By locator = By.xpath("//div[text()='" + strColumnText + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify user can see column name as '" + strColumnText + "'",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	/**
	 * Scenario: 171517 Description: Verify Values Selected In Search Text Box
	 * Of Filter Are Displayed In Disabled Search Box
	 */
	public void verifyTheValuesSelectedInSearchTextBoxOfFilterAreDisplayedInDisabledSearchBoxOnManageWorkFlowStatusPopUp(
			String strColumnName, int intColumnIndex) {

		objPojo.getObjWrapperFunctions().waitFor(2);
		By locator = By.xpath(
				"(//span[text()='Manage Workflow States']//following::input[@ref='eColumnFloatingFilter' and @readonly])[1]");
		objPojo.getObjWrapperFunctions().waitFor(2);
		String strDisabledText = objPojo.getObjWrapperFunctions().getAttributeValue(locator, "readonly");
		objPojo.getObjUtilities().logReporter("Verify User can see disabled text : " + strDisabledText,
				strDisabledText.equals("true"));
	}

}
