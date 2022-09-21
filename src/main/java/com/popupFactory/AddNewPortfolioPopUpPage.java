package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.FileFunctions;
import com.generic.Pojo;

import ru.yandex.qatools.allure.annotations.Step;

public class AddNewPortfolioPopUpPage {

	// Global Variables
	private Pojo objPojo;
	private String strFolderNameRandom = "";
	private List<String> listReturnValue;

	public AddNewPortfolioPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrAddNewPortfolio = By.xpath("//div[@id='folderPopup']/child::div[2]/div[text()='Add New Portfolio']");
	By loc_inpFolderName = By.xpath("//label[text()='Folder Name']//parent::div//input[@id='folderName']");
	By loc_iconCalender = By.xpath("//div[@id='folderDialog']//label[text()='Effective Date']/following-sibling::img");
	By loc_drpWorkflowCategory = By.xpath("//select[@id='categoryDDL1']");
	By loc_drpLineofBusiness = By.xpath("//select[@id='lineOfBusiness']");
	By loc_drpMarketSegment = By.xpath("//select[@id='marketSegment']");
	By loc_drpState = By.xpath("//select[@id='state']");
	By loc_drpRegion = By.xpath("//select[@id='region']");
	By loc_btnSaveAndNext = By.xpath("//button[@id='btnFolderDialogSave'][text()='Save & Next']");
	By loc_btnCancel = By.xpath("//div[@id='folderDialog']/button[text()='Cancel']");
	By loc_drpFundingArrangement = By.xpath("//select[@id='fundingArrangement']");
	By loc_drpFolderMode = By.xpath("//select[@id='folderModeDDL']");

	/**
	 * 
	 * Scenario: 118157 Description: Verify the functionality of Folder Creation
	 * at Portfolio Module
	 */

	public void verifyAddNewPortfolioPopupHeaderIsDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify Add New Portfolio popup header is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddNewPortfolio));
	}

	public String enterFolderNameOnAddNewPortfolioPopup(String strFolderName) {
		strFolderNameRandom = strFolderName + objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpFolderName);
		objPojo.getObjWrapperFunctions().setText(loc_inpFolderName, strFolderNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '" + strFolderNameRandom + "' as folder name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpFolderName));
		return strFolderNameRandom;
	}

	public void selectEffectiveDateOnAddFolderPopupPage(String strYear, String strMonth, String strDate) {
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconCalender, strYear, strMonth, strDate);
		objPojo.getObjUtilities()
				.logReporter(
						"Select date as '" + strDate + "', month as '" + strMonth + "', year as '" + strYear
								+ "' from calender.",
						objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconCalender));
	}

	public void verifyDropdownOptionsfromAddNewPortfolioPopup(By loc_drpName, String strdrpName) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strdrpName + "'  from  dropdown ",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpName, strdrpName));
	}

	// verifying dropdowns with option
	@Step("Verify the UI of Create Folder popup Page")
	public void verifyDropDownWithOptions(String strdrpName, String drpDownOptionsTxtFileName) {

		try {
			listReturnValue = FileFunctions.readFileIntoList(System.getProperty("user.dir")
					+ "/src/test/resources/testData/textFiles/" + drpDownOptionsTxtFileName + ".txt");
			for (String strValue : listReturnValue) {
				System.out.println("text file testData : " + strValue);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		By loc_drpName = By.xpath("//select[@id='" + strdrpName + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown '" + strdrpName + "",
				objPojo.getObjWrapperFunctions().actionClick(loc_drpName));
		for (int index = 0; index < listReturnValue.size(); index++) {
			String strDrpValue = listReturnValue.get(index).trim();
			if (!strDrpValue.equals("")) {
				objPojo.getObjWrapperFunctions().waitFor(1);

				this.verifyDropdownOptionsfromAddNewPortfolioPopup(loc_drpName, strDrpValue);
			}
		}
	}

	public String selectWorkFlowCategoryOptionFromDropdown(String strWorkflowCategory) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strWorkflowCategory + "' from workflow category dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpWorkflowCategory, strWorkflowCategory,
						"Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpWorkflowCategory);
		return strWorkflowCategory;
	}

	public String selectLineOfBusinessOptionFromDropdown(String strLineofBusiness) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strLineofBusiness + "' from Line of Business dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpLineofBusiness, strLineofBusiness,
						"Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpLineofBusiness);
		return strLineofBusiness;
	}

	public String selectMarketSegmentOptionFromDropdown(String strMarketSegementValue) {

		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strMarketSegementValue + "' from market segment dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpMarketSegment, strMarketSegementValue,
						"Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpMarketSegment);
		return strMarketSegementValue;
	}

	public String selectFundingArrangementOptionFromDropdown(String strFundingArrangement) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strFundingArrangement + "' from Funding Arrangement dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFundingArrangement, strFundingArrangement,
						"Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFundingArrangement);
		return strFundingArrangement;
	}

	public String selectStateOptionFromDropDown(String strStateDrpValue) {
		objPojo.getObjUtilities().logReporter("Verify user can select '" + strStateDrpValue + "' from state dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpState, strStateDrpValue, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpState);
		return strStateDrpValue;
	}

	public String selectRegionOptionFromDropdown(String strRegionDrpValue) {
		objPojo.getObjUtilities().logReporter("Verify user can select '" + strRegionDrpValue + "' from region dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpRegion, strRegionDrpValue, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpRegion);
		return strRegionDrpValue;
	}

	public void verifyCancelButtonOnAddNewPortfolioPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can see cancel button on add new portfolio popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCancel));

	}

	public void verifySaveAndNextButtonOnAddNewPortfolioPopupPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can see save and next button on add new portfolio popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSaveAndNext));

	}

	public void clickOnSaveAndNextButtonOnAddNewPortfolioPopupPage() {
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on save and next button on add new portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSaveAndNext));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	// new method
	// verifying state dropdown with option
	@Step("Verify the UI of Create Folder popup Page")
	public void verifyStateDropDownWithOptions(String strdrpName, List<String> listStatesFromML) {

		By loc_drpName = By.xpath("//select[@id='" + strdrpName + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown '" + strdrpName + "",
				objPojo.getObjWrapperFunctions().actionClick(loc_drpName));
		for (int index = 0; index < listStatesFromML.size(); index++) {
			String strDrpValue = listStatesFromML.get(index).trim();

			if (!strDrpValue.equals("")) {
				objPojo.getObjWrapperFunctions().waitFor(1);

				this.verifyDropdownOptionsfromAddNewPortfolioPopup(loc_drpName, strDrpValue);
			}
		}
	}

	public void selectFolderModeOptionFromDropdown(String strFolderMode) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strFolderMode + "' from Folder Mode dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFolderMode, strFolderMode, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFolderMode);
	}

	/**
	 * Scenario: 119952 Description: Verify that Folder Name is displayed
	 * correctly after creating the folder
	 */
	public void clickOnAddPortfolioOnPortfolioPage() {
		By loc_btnAddPortfolio = By.xpath("//button[text()='Add Portfolio']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnAddPortfolio);
		objPojo.getObjUtilities().logReporter("Verify user can click on Create Folder button",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnAddPortfolio));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	

}
