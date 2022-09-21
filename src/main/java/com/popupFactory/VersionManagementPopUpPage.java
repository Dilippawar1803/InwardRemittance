package com.popupFactory;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class VersionManagementPopUpPage {

	// Global Variables
	private Pojo objPojo;

	public VersionManagementPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	// locators
	By btn_BaselineVersion = By.xpath("//button[text()='Baseline Version']");
	By hdrVersionManagementPopUp = By.xpath("//span[contains(@id,'ui-id')][text()='Version Management']");
	By icon_Close = By.xpath("//span[text()='Version Management']/following-sibling::a/span[text()='close']");
	By icon_CloseButtonInMessagePopUp = By
			.xpath("//div[@id='messagedialog']/following-sibling::div//button[text()='Close']");
	By btn_NewVersion = By.xpath("//button[@id='newVersionHistory']");
	By loc_rowMinorVersion = By
			.xpath("//td[@aria-describedby='minorVersion_FolderVersionStateName' and text()='In Progress']");
	By loc_rowMajorVersion = By.xpath("(//td[@aria-describedby='majorVersionML_Status' and text()='Released'])[1]");
	By loc_VersionNO = By.xpath(
			"//td[@aria-describedby='minorVersion_FolderVersionStateName' and text()='In Progress']/preceding-sibling::td[@aria-describedby='minorVersion_FolderVersionNumber']");
	By loc_EditButton = By.xpath("//td[@id='pminorVersion_left']/descendant::td[@id='btnMinorVersionEdit']");
	By loc_InProgressVersion = By
			.xpath("//td[@aria-describedby='minorVersion_FolderVersionStateName' and text()='In Progress']");
	By loc_MajorVersionList = By.xpath(
			"//td[@aria-describedby='majorVersion_WFStateName']/self::td[text()='Release' or text()='Baselined' or text()='In Progress']");
	By loc_rowMasterlistMinorVersion = By
			.xpath("//td[@aria-describedby='minorVersionML_FolderVersionStateName' and text()='In Progress']");
	By loc_saveBaselineOfML = By.xpath("//button[@id='updateBaseLineML' and text()='Save']");
	By loc_InProgressMLVersion = By
			.xpath("//td[@aria-describedby='minorVersionML_FolderVersionStateName' and text()='In Progress']");
	By loc_MLMajorVersionList = By.xpath(
			"//td[@aria-describedby='majorVersionML_Status']//self::td[text()='Released' or text()='Baselined' or text()='In Progress']");
	By loc_iconCalenderRetro = By.xpath(
			"(//div[@id='retroAccountDialog']//label[contains(text(),'Date in which change must be made  (Retro Effective Date)')]//following::div//child::input//following::img)[1]");
	By loc_ReloadGridIcon = By.xpath("//td[@id='refresh_majorVersion']//span[@class='ui-icon ui-icon-refresh']");
	By loc_EditButtonML = By.xpath("//td[@id='pminorVersionML_left']/descendant::td[@id='btnMinorVersionEditML']");
	By loc_InProgressVersionML = By
			.xpath("//td[@aria-describedby='minorVersionML_FolderVersionStateName' and text()='In Progress']");
	By loc_VersionNOML = By.xpath(
			"//td[@aria-describedby='minorVersionML_FolderVersionStateName' and text()='In Progress']/preceding-sibling::td[@aria-describedby='minorVersionML_FolderVersionNumber']");
	/**
	 * 
	 * Scenario: TC002 Description: Verify if user can Create New Version
	 */

	public void verifyHeaderOfVersionManagementPopUp() {

		objPojo.getObjUtilities().logReporter("Verify user can see header of Version Management Pop Up",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(hdrVersionManagementPopUp));
	}

	public void clickOnBaselineVersionButton() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on Baseline Version Button in Version management Pop Up",
				objPojo.getObjWrapperFunctions().actionClick(btn_BaselineVersion));
	}

	public void clickOnMinorVersionRowAndCommentSection(String strAddCommentData) {
		By loc_comment = By.xpath("//div[@class='ui-wrapper']//child::textarea[@id='Comments']");
		objPojo.getObjUtilities().logReporter("Add comment in comment section minor Version Row",
				objPojo.getObjWrapperFunctions().actionClick(loc_comment));
		objPojo.getObjUtilities().logReporter("Add comment in comment section minor Version Row",
				objPojo.getObjWrapperFunctions().setText(loc_comment, strAddCommentData));
	}

	public void clickOnSave() {
		By loc_save = By.xpath("//button[@id='updateBaseLine' and text()='Save']");
		objPojo.getObjUtilities().logReporter("Click On Save Button for Minor Version",
				objPojo.getObjWrapperFunctions().click(loc_save));
		objPojo.getObjWrapperFunctions().waitFor(5);
	}

	public String getBaselinedVersion() {
		By loc_baselinedVersion = By.xpath(
				"//table[@id='minorVersion']//child::tr[2]/td[@aria-describedby='minorVersion_FolderVersionNumber']");
		String strBaselinedVersion = objPojo.getObjWrapperFunctions().getText(loc_baselinedVersion, "Text");
		return strBaselinedVersion;
	}

	public String getMinorVersion() {
		By loc_minorVersion = By.xpath(
				"//table[@id='minorVersion']//child::tr[2]/td[@aria-describedby='minorVersion_FolderVersionNumber']");
		String strMinorVersion = objPojo.getObjWrapperFunctions().getText(loc_minorVersion, "Text");
		return strMinorVersion;
	}

	public void verifyBaselineVersion(String strBaseLineVersion) {
		By loc_baselinedVersion = By
				.xpath("//table[@id='minorVersion']//child::tr[3]/td[@title='" + strBaseLineVersion + "']");
		objPojo.getObjUtilities().logReporter("verify '" + strBaseLineVersion + "' baseline version is created",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_baselinedVersion));
	}

	public void verifyMinorVersion(String strMinorVersion) {
		By loc_MinorVersion = By
				.xpath("//table[@id='minorVersion']//child::tr[2]/td[@title='" + strMinorVersion + "']");

		objPojo.getObjUtilities().logReporter("verify '" + strMinorVersion + "' in progress version is created",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_MinorVersion));

	}

	/**
	 *
	 * Scenario: 118050 Description: Verify if user is able to create a new version
	 * from major version
	 */

	public void clickOnNewVersionButton() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on New Version Button in Version management Pop Up",
				objPojo.getObjWrapperFunctions().click(btn_NewVersion));
	}

	public void checkNewVersionOfMajorIsCreated(String strMinorVerionYear) {
		By locator = By.xpath(
				"//table[@id='minorVersion']//child::tr[2]/td[3][contains(text(),'" + strMinorVerionYear + "_1.01')]");
		objPojo.getObjUtilities().logReporter(
				"Verify In progress version should be created as 1.01 in minor version list",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnCloseOnVersionManagemntPopUp() {
		objPojo.getObjUtilities().logReporter("Click On close Button on Version management Pop up",
				objPojo.getObjWrapperFunctions().click(icon_Close));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void clickOnRowInMinorVersion() {
		By loc_minorVersion = By.xpath("//td[@aria-describedby='minorVersionML_User']");
		objPojo.getObjUtilities().logReporter("Verify user can click on row",
				objPojo.getObjWrapperFunctions().click(loc_minorVersion));
	}

	public void clickOnGridIcon(String strIcon) {
		By locator = By.xpath("//td[@id='" + strIcon + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on grid icon" + strIcon + "",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnConfirmMsg(String strMessage) {
		By locator = By.xpath("(//p[contains(text(),'" + strMessage
				+ "')]/following::button[@type='button' and text()='Confirm'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on Confirm button",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	/**
	 * Scenario: 169873 Description: Verify the functionality of Workflow State
	 * Update when user sold the quote
	 */

	public void checkMajorVersionOfQuoteIsCreated(String strQuoteYear) {
		By locator = By
				.xpath("//table[@id='majorVersion']//child::tr[2]/td[3][contains(text(),'" + strQuoteYear + "_1.0')]");
		objPojo.getObjUtilities().logReporter("Verify Quote is updated to major version",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyMajorVersionGridIconsOnVerSionManagement(String strGridIcon) {
		By locator = By
				.xpath("//div[@id='pg_pmajorVersion']//td[contains(@data-original-title,'" + strGridIcon + "')]");
		objPojo.getObjUtilities().logReporter("Verify Grid icon " + strGridIcon + " for major version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyDownArrow(String strVersionRepeterName) {
		By locator = By.xpath("//span[text()='" + strVersionRepeterName + "']/parent::div/child::a");
		objPojo.getObjUtilities().logReporter("Verify Down arrow for " + strVersionRepeterName + "",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}

	/**
	 * Scenario: 149579 Description: Verify if User click on view icon in Minor
	 * Version List without selecting any Minorversion
	 */
	public void clickOnGridIconForMajorVersionOnVersionManagementPopup(String strGridIcon) {
		By locator = By
				.xpath("//div[@id='pg_pmajorVersion']//td[contains(@data-original-title,'" + strGridIcon + "')]");
		objPojo.getObjUtilities().logReporter("click on Grid icon " + strGridIcon + " for major version",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnGridIconForMinorVersionOnVersionManagementPopup(String strGridIcon) {
		By locator = By.xpath("//div[@id='pminorVersion']//td[contains(@data-original-title,'" + strGridIcon + "')]");
		objPojo.getObjUtilities().logReporter("click on Grid icon " + strGridIcon + " for Minor version",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public String verifyMessageFromMessageBox(String strMessage) {
		objPojo.getObjWrapperFunctions().waitFor(6);
		By locator = By.xpath("//p[text()='" + strMessage + "']");
		objPojo.getObjUtilities().logReporter("Verify message  '" + strMessage + "' is displayed from message box",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		return strMessage;
	}

	public void clickOnCloseButtonFromMessageBox(String strMessage) {
		By locator = By.xpath(
				"(//p[contains(text(),'" + strMessage + "')]/following::button[@type='button' and text()='Close'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on close button",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	/**
	 * Scenario: 149580 Description: Verify if User can collapse expand Minor
	 * version list
	 */
	public void clickOnDownOrUpArrowOnVersionManagementPopup(String strVersionRepeterName) {
		By locator = By.xpath("//span[text()='" + strVersionRepeterName + "']/parent::div/child::a");
		objPojo.getObjUtilities().logReporter("click on Down arrow for " + strVersionRepeterName + "",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyRepeaterExpandsOrNot(String strRepeterName) {
		By locator = By.xpath("//div[contains(@id,'FolderVersionNumber')][contains(.,'" + strRepeterName + "')]");
		System.out.println("locator : " + locator);
		objPojo.getObjUtilities().logReporter("Verify the " + strRepeterName + " Colapse or not",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyRepeterColapseOrNot(String strRepeterName) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		By locator = By.xpath("//div[contains(@id,'FolderVersionNumber')][contains(.,'" + strRepeterName + "')]");
		objPojo.getObjUtilities().logReporter("Verify the " + strRepeterName + " Colapse or not",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(locator));
	}

	/**
	 * Scenario: 149581 Description: Verify the columns displayed in Minor version
	 * list
	 */
	public void verifyColumnsOnVersionManagementPage(String strRepeterName, String strColumnName) {
		By locator = By.xpath("//span[text()='" + strRepeterName
				+ "']/following::span[@class='s-ico']/parent::div[text()='" + strColumnName + "'][1]");
		objPojo.getObjUtilities().logReporter("Verify columns on Version management Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyFolderNameOnVersionMangagementPopup(String strFolderName) {
		By loc_FolderName = By
				.xpath("//span[contains(.,'Version Management')]/following::h4[contains(.,'" + strFolderName + "')]");
		objPojo.getObjUtilities().logReporter("Verif columns on Version management Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_FolderName));
	}

	/**
	 * Scenario: 149582 Description: Verify the Functionality of Search icon in
	 * Minor Version List
	 */

	public String clickOnSearchIconOnVersionManagementPopup(String strField, String strValueTOSearch) {
		By locator = By.xpath("//span[text()='Minor Version List']//following::input[@name='" + strField + "'][1]");
		objPojo.getObjWrapperFunctions().click(locator);
		objPojo.getObjUtilities().logReporter("set value in search box for Minor version Column",
				objPojo.getObjWrapperFunctions().setText(locator, strValueTOSearch));
		objPojo.getObjWrapperFunctions().waitFor(3);
		return strValueTOSearch;
	}

	public void verifySearchedResultOnVersionManagementPopup(String strField, String strValueToVerify) {
		By loc_searchResult = By.xpath("//span[text()='Minor Version List']//following::td[contains(@aria-describedby,'"
				+ strField + "') and text()='" + strValueToVerify + "']");
		objPojo.getObjUtilities().logReporter("verify Search result for Minor version columns",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_searchResult));
		objPojo.getObjWrapperFunctions().waitFor(3);
	}

	/**
	 * Scenario: 149575 Description: Verify the UI of Version Management window
	 */
	public void verifyButtonsOnVersionManagementPopup(String strButton) {
		By locator = By.xpath("//div[contains(@class,'btn pull')]/child::button[text()='" + strButton + "']");
		objPojo.getObjUtilities().logReporter("Verify the Action Buttons on Version management Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyRepetersOnVersionManagementPopup(String strRepeterName) {
		By locator = By.xpath("//span[@class='ui-jqgrid-title'][contains(.,'" + strRepeterName + "')]");
		objPojo.getObjUtilities().logReporter("Verify the Action Buttons on Version management Popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	/**
	 * Scenario: 149586 Description: Verify the Functionality of Create corrective
	 * version Retro New Version Buttons if folder do not have any major version
	 */
	public void selectButtonsOfVersionManagementIsDisabled(String strButtonName) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		By locator = By.xpath("//button[text()='" + strButtonName + "']");
		objPojo.getObjUtilities().logReporter("Verify " + strButtonName + " Button is disabled ",
				!(objPojo.getObjWrapperFunctions().checkElementEnabled(locator)));
	}

	public void selectButtonofCorrectiveOfVersionManagementIsDisabled(String strButtonName, String strDisable) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		By locator = By.xpath("//button[text()='" + strButtonName + "']");
		String strReturnValue = objPojo.getObjWrapperFunctions().getAttribute(locator, "class");
		objPojo.getObjUtilities().logReporter("Verify " + strButtonName + " Button is disabled ",
				strReturnValue.contains(strDisable));

	}

	/**
	 * Scenario: 149593 Description: Verify the UI of Version Management window
	 */
	public void verifyMasterListNameOnVersionManagementWindow(String strView) {
		By locator = By.xpath("//div[@class='pull-left']//child::h4[text()='" + strView + "']");
		objPojo.getObjUtilities().logReporter("Verify Master list name " + strView + "",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyButtonOnVersionManagementWindow(String strButton) {
		By locator = By.xpath("//span[text()='Version Management']//following::button[text()='" + strButton + "']");
		objPojo.getObjUtilities().logReporter("Verify Master Button" + strButton + "",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyMinorAndMajorVersionList(String strList) {
		By locator = By.xpath("//span[text()='Version Management']//following::span[text()='" + strList + "']");
		objPojo.getObjUtilities().logReporter("Verify Master Button" + strList + "",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	/**
	 * Scenario: 149585 Description: Verify if User can delete InProgress version
	 * from version management
	 */
	public void verifyHeaderOfMinorOrMajorVersion(String strVersionName) {
		By locator = By.xpath("//span[text()='" + strVersionName + "']");
		objPojo.getObjUtilities().logReporter(
				"Verify user can see header " + strVersionName + " of Version Management Pop Up",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void clickOnRowInMinorVersionForPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify user can click on row",
				objPojo.getObjWrapperFunctions().click(loc_rowMinorVersion));
	}

	public void clickOnButtonsOnVersionManagementPopup(String strButton) {
		By locator = By.xpath("//div[contains(@class,'btn pull')]/child::button[text()='" + strButton + "']");
		objPojo.getObjUtilities().logReporter("Verify the Action Buttons on Version management Popup",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void clickOnConfirmButtonFromDelete(String strMessage) {
		By locator = By.xpath("(//p[contains(text(),'" + strMessage
				+ "')]/following::button[@type='button' and text()='Confirm'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on Confirm button",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	/**
	 * Scenario: 149594 Description: Verify the UI & functionality icons present at
	 * Major Version List in Version Management window
	 */
	public void clickOndownArrow(String strVersionRepeterName) {
		By locator = By.xpath("//span[text()='" + strVersionRepeterName + "']/parent::div/child::a");
		objPojo.getObjUtilities().logReporter("Verify Down arrow for " + strVersionRepeterName + "",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnRowInMajorVersion() {
		objPojo.getObjUtilities().logReporter("Verify user can click on row of major version",
				objPojo.getObjWrapperFunctions().click(loc_rowMajorVersion));
	}

	/**
	 * Scenario: 149644 Description: Verify the Functionality of Baseline button in
	 * Version Management window
	 */
	public String getVirsionNoOfInProgressVersion() {
		String strVersionNo = objPojo.getObjWrapperFunctions().getText(loc_VersionNO, "Text");
		return strVersionNo;
	}

	public void verifyAndClickOnBaselinedVersionOnVersionManagementPage(String strVersionNO) {
		By locator = By.xpath("//td[@aria-describedby='minorVersion_FolderVersionNumber' and text()='" + strVersionNO
				+ "']/following-sibling::td[@aria-describedby='minorVersion_FolderVersionStateName' and text()='Baselined']");
		objPojo.getObjUtilities().logReporter("Verify user can see the the Baselined Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjWrapperFunctions().click(locator);
	}

	public void verifyEditButtondisabledOrNot(String strValueToVerify) {
		String strAttriblueValue = objPojo.getObjWrapperFunctions().getAttributeValue(loc_EditButton, "Class");
		objPojo.getObjUtilities().logReporter(
				"Verify Edit button is Enabled or Disabled On Version Management Popup page",
				strAttriblueValue.contains(strValueToVerify));
	}

	public void verifyAndClickOnInProgressVersionOnVersionManagementPage() {
		objPojo.getObjUtilities().logReporter("Verify user can see the the Baselined Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_InProgressVersion));
		objPojo.getObjWrapperFunctions().click(loc_InProgressVersion);
	}

	public void verifyEditButtonEnabledOrNot() {
		objPojo.getObjUtilities().logReporter(
				"Verify Edit button is Enabled or Disabled On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementEnabled(loc_EditButton));
	}

	public void checkMajorVersionOfMLIsCreated(String strMLYear) {
		By locator = By
				.xpath("//table[@id='majorVersionML']//child::tr[2]/td[3][contains(text(),'" + strMLYear + "_1.0')]");
		objPojo.getObjUtilities().logReporter("Verify Master list is updated to major version",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	/**
	 * Scenario: 149642 Description: Verify the UI of Create corrective version in
	 * version Management window if only Minor versions are present
	 */
	public void verifyIsMajorVersionListIsEmpty() {
		objPojo.getObjUtilities().logReporter("Verify Major version list is Empty On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_MajorVersionList));
	}

	public void verifyButtonIsDisabledOrNot(String strButton, String strAttributeValue) {
		By locator = By.xpath("//div[contains(@class,'btn pull')]/child::button[text()='" + strButton + "']");
		String strButtonValue = objPojo.getObjWrapperFunctions().getAttributeValue(locator, "Class");
		objPojo.getObjUtilities().logReporter("Verify is Button is Disabled On Version Management Popup page",
				strButtonValue.contains(strAttributeValue));
	}

	public void verifyButtonIsDisabledOrNotByAttributeDisabled(String strButton) {
		By locator = By.xpath("//div[contains(@class,'btn pull')]/child::button[text()='" + strButton
				+ "' and @disabled='disabled']");
		String strButtonValue = objPojo.getObjWrapperFunctions().getAttributeValue(locator, "disabled");
		System.out.println("strButtonValue : " + strButtonValue);
		objPojo.getObjUtilities().logReporter("Verify is Button is Disabled On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	/**
	 * Scenario: 149577 Description: Verify the UI & Functionality of Reload grid
	 * icon in Major Version List
	 */
	public String searchOnMajorVersionColumnVersionManagementPopup(String strField, String strValueTOSearch) {
		By locator = By.xpath("//span[text()='Major Version List']//following::input[@name='" + strField + "'][1]");
		objPojo.getObjWrapperFunctions().click(locator);
		objPojo.getObjUtilities().logReporter("set value in search box for Minor version Column",
				objPojo.getObjWrapperFunctions().setText(locator, strValueTOSearch));
		objPojo.getObjWrapperFunctions().waitFor(3);
		return strValueTOSearch;
	}

	public void verifySearchedResultForMajorVersion(String strField, String strValueToVerify) {
		By loc_searchResult = By.xpath("//span[text()='Major Version List']//following::td[contains(@aria-describedby,'"
				+ strField + "') and text()='" + strValueToVerify + "']");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("verify Search result for Minor version columns",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_searchResult));
		objPojo.getObjWrapperFunctions().waitFor(3);
	}

	/**
	 * Scenario: 149596 Description: Verify the UI & Functionality of edit icon in
	 * Minor Version List
	 */

	public void clickOnRowInMinorVersionForMasterList() {
		objPojo.getObjUtilities().logReporter("Verify user can click on row",
				objPojo.getObjWrapperFunctions().click(loc_rowMasterlistMinorVersion));
	}

	/**
	 * Scenario: 149598 Description: Verify if User can delete InProgress version
	 * from version management
	 */
	public void clickOnSaveForMasterListBaselineVersion() {
		objPojo.getObjUtilities().logReporter("Click On Save Button for Minor Version",
				objPojo.getObjWrapperFunctions().click(loc_saveBaselineOfML));
		objPojo.getObjWrapperFunctions().waitFor(5);
	}

	public void clickOnGridIconIsDisplayed(String strIcon) {
		By locator = By.xpath("//td[@id='" + strIcon + "']");
		objPojo.getObjUtilities().logReporter("Verify user can Unable to see grid icon" + strIcon + "",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void checkNewVersionOfMajorIsCreatedForML(String strMinorVerionYear) {
		By locator = By.xpath("//table[@id='minorVersionML']//child::tr[2]/td[3][contains(text(),'" + strMinorVerionYear
				+ "_1.01')]");
		objPojo.getObjUtilities().logReporter(
				"Verify In progress version should be created as 1.01 in minor version list",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyIsMajorVersionListIsEmptyForML() {

		objPojo.getObjUtilities().logReporter("Verify Major version list is Empty On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_MLMajorVersionList));
	}

	public void verifyAndClickOnInProgressVersionOnVersionManagementPageForML() {

		objPojo.getObjUtilities().logReporter("Verify user can see the the In Progress Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_InProgressMLVersion));
		objPojo.getObjWrapperFunctions().click(loc_InProgressMLVersion);
	}

	public void verifyRowInMinorVersionForPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify user can click on row",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_rowMinorVersion));
	}

	public void clickOnCorrectiveVersionButton(String strButtonName) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		By locator = By.xpath("//button[text()='" + strButtonName + "']");
		objPojo.getObjUtilities().logReporter("Verify " + strButtonName + " Button is disabled ",
				(objPojo.getObjWrapperFunctions().actionClick(locator)));

	}

	/**
	 * Scenario: 149608 Description: Verify the status of Retro created versions
	 */

	public void verifyStatusOfMinorVersionForRetroButton(String strVersion, String strStatus) {
		By locator = By.xpath("//td[text()='" + strVersion + "']//following-sibling::td[text()='" + strStatus + "']");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter(
				"Verify user can able to see status " + strStatus + " for Version" + strVersion + " ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjWrapperFunctions().waitFor(2);
	}

	/**
	 * Scenario: 149587 Description: Verify if User can update & save InProgress
	 * version opened from version management
	 */
	public void verifyIsMajorVersionIsPresent() {
		objPojo.getObjUtilities().logReporter("Verify Major version list is Present On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_MajorVersionList));
	}

	public void verifyIsMinorVersionListIsEmpty() {
		objPojo.getObjUtilities().logReporter("Verify Minor version list is Empty On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_rowMinorVersion));
	}

	public void verifyRetroAndCorrectiveButtonsOfVersionManagementIsEnabled(String strButtonName) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		By locator = By.xpath("//button[text()='" + strButtonName + "']");
		objPojo.getObjUtilities().logReporter("Verify " + strButtonName + " Button is enable ",
				objPojo.getObjWrapperFunctions().checkElementEnabled(locator));
	}

	public void clickOnButtonsOnVersionManagement(String strButtons) {
		By locator = By.xpath("//button[@id='" + strButtons + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on Buttons on Version management Pop Up",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnCalenderIconOnRetro() {
		objPojo.getObjUtilities().logReporter("Click on calendar icon",
				objPojo.getObjWrapperFunctions().click(loc_iconCalenderRetro));
	}

	public String VerifyVersionNoOfInProgressVersion() {
		String strVersionNo = objPojo.getObjWrapperFunctions().getText(loc_VersionNO, "Text");
		System.out.println(strVersionNo);
		objPojo.getObjUtilities().logReporter("Verify Version Number is increased by 0.01",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_VersionNO));
		return strVersionNo;
	}

	public void verifyGridIconOnMinorVersionList(String strIcon) {
		By locator = By
				.xpath("//span[text()='Minor Version List']//following::td[@data-original-title='" + strIcon + "']");
		objPojo.getObjUtilities().logReporter("Verify user can able to see grid icon" + strIcon + "",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public String getVersionNameFromBaselineVersionPopup(int intIndex) {
		By loc_getVersionName = By
				.xpath("(//td[@aria-describedby='minorVersion_FolderVersionNumber'])[" + intIndex + "]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_getVersionName);
		String strVersion = objPojo.getObjWrapperFunctions().getText(loc_getVersionName, "Text").trim();
		return strVersion;
	}

	public void clickOnReloadGridIcon() {
		objPojo.getObjUtilities().logReporter("Click on Reload Grid icon",
				objPojo.getObjWrapperFunctions().click(loc_ReloadGridIcon));

	}

	public void verifyReloadGridIconHasGreyBackgroundColor() {
		String strColorCode = objPojo.getObjWrapperFunctions().getCSSValue(loc_ReloadGridIcon, "background-color");
		System.out.println("strColorCode::::" + strColorCode);

		if (strColorCode.equals("#d9e3ee")) {
			objPojo.getObjUtilities().logReporter("Verify Highlighted Color code" + strColorCode + "is grey",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ReloadGridIcon));
		} else
			objPojo.getObjUtilities().logReporter("Verified color is not grey-------->>", false);

	}
	public void clickOnGridIconOnMinorVersionList(String strIcon)
	{
		By locator=By.xpath("//span[text()='Minor Version List']//following::td[@data-original-title='"+strIcon+"']");
		objPojo.getObjUtilities().logReporter("Verify user can able to click on grid icon" + strIcon + "",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}
	

	//149604
	public void clickOnSaveOnVersionManagementPopInML() {
		By loc_save = By.xpath("//button[@id='updateBaseLineML' and text()='Save']");
		objPojo.getObjUtilities().logReporter("Click On Save Button for Minor Version",
				objPojo.getObjWrapperFunctions().click(loc_save));
		objPojo.getObjWrapperFunctions().waitFor(5);
	}
	
	public void verifyAndClickOnBaselinedVersionOnVersionManagementPageforML(String strVersionNO) {
		By locator = By.xpath("//td[@aria-describedby='minorVersionML_FolderVersionNumber' and text()='" + strVersionNO
				+ "']/following-sibling::td[@aria-describedby='minorVersionML_FolderVersionStateName' and text()='Baselined']");
		objPojo.getObjUtilities().logReporter("Verify user can see the the Baselined Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjWrapperFunctions().click(locator);
	}
	
	public void verifyEditButtondisabledOrNotInML(String strValueToVerify) {
		String strAttriblueValue = objPojo.getObjWrapperFunctions().getAttributeValue(loc_EditButtonML, "Class");
		objPojo.getObjUtilities().logReporter(
				"Verify Edit button is Enabled or Disabled On Version Management Popup page",
				strAttriblueValue.contains(strValueToVerify));
	}
	
	public void verifyAndClickOnInProgressVersionOnVersionManagementPageInML() {
		objPojo.getObjUtilities().logReporter("Verify user can see the the Baselined Version",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_InProgressVersionML));
		objPojo.getObjWrapperFunctions().click(loc_InProgressVersionML);
	}
	
	public void verifyEditButtonEnabledOrNotInML() {
		objPojo.getObjUtilities().logReporter(
				"Verify Edit button is Enabled or Disabled On Version Management Popup page",
				objPojo.getObjWrapperFunctions().checkElementEnabled(loc_EditButtonML));
	}
	
	public String getVersionNoOfInProgressVersionML() {
		String strVersionNo = objPojo.getObjWrapperFunctions().getText(loc_VersionNOML, "Text");
		return strVersionNo;
	}
	
	public String getMajorVersion() {
		By loc_majorVersion = By.xpath(
				"//table[@id='majorVersion']//child::tr[2]/td[@aria-describedby='majorVersion_FolderVersionNumber']");
		String strMajorVersion = objPojo.getObjWrapperFunctions().getText(loc_majorVersion, "Text");
		return strMajorVersion;
	}
	
	public void verifyFolderCategoryOnVersionManagementPopup(String folderCategory) {
		By locator = By.xpath("//td[@aria-describedby='minorVersion_CategoryName']");
		objPojo.getObjUtilities().logReporter("Verify folder category", "Folder category is '" + folderCategory + "'",
				folderCategory.equals(objPojo.getObjWrapperFunctions().getText(locator, "Text")));
	}
	

    
    //Ekta
    public void verifyListOfMinorVersionForAccountPage() {

    	By loc_versionList = By.xpath("//div[@class='ag-header-row']//div[text()='Version']");
    	List<WebElement> RowList = objPojo.getObjWrapperFunctions().getWebElementList(loc_versionList);
    	int size = RowList.size();
    	for (int intIndex = 1; intIndex <= size; intIndex++) {
    		By loc_version = By.xpath("(//div[@id='workflowStatesGridAccount']//div[text()='2022_0.01'])['" + intIndex + "']");
    		objPojo.getObjWrapperFunctions().scrollToViewDown(loc_version);
    		String strVersion = objPojo.getObjWrapperFunctions().getText(loc_version, "Text");
    		objPojo.getObjUtilities().logReporter("Verify only Minor version is displayed ", !strVersion.equals(""));
    	}
    }
}