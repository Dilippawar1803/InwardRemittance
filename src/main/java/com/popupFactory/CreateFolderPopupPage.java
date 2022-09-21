package com.popupFactory;
import java.util.List;

import org.openqa.selenium.By;


import com.generic.FileFunctions;
import com.generic.Pojo;

import ru.yandex.qatools.allure.annotations.Step;

public class CreateFolderPopupPage {
	// Global Variables
	private Pojo objPojo;
	private String strFolderNameRandom="";
	private List<String> listReturnValue;
	public CreateFolderPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrCreateFolder=By.xpath("//span[text()='Create Folder']");
	By loc_inpFolderName= By.xpath("//label[text()='Folder Name']//parent::div//input[@id='folderName']");
	By loc_iconCalender= By.xpath("(//img[@src='/Content/css/custom-theme/images/calender-icon.svg'])[1]");
	By loc_drpWorkflowCategory = By.xpath("//select[@id='categoryDDL1']");
	By loc_drpLineofBusiness = By.xpath("//select[@id='lineOfBusiness']");
	By loc_drpMarketSegment = By.xpath("//select[@id='marketSegment']");
	By loc_drpState = By.xpath("//select[@id='state']");
	By loc_drpRegion = By.xpath("//select[@id='region']");
	By loc_btnSaveAndNext = By.xpath("//button[@id='btnFolderDialogSave'][text()='Save & Next']");
	By loc_drpFolderMode = By.xpath("//select[@id='folderModeDDL']");
	By loc_drpFundingArrangement = By.xpath("//select[@id='fundingArrangement']");
	By loc_btnCancel = By.xpath("//div[@id='folderDialog']/button[text()='Cancel']");


	public void verifyCreateFolderPopupHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify Create folder popup header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrCreateFolder));
	}
	public String enterFolderNameOnCreateFolderPopup(String strFolderName){
		strFolderNameRandom=strFolderName+objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpFolderName);
		objPojo.getObjWrapperFunctions().setText(loc_inpFolderName, strFolderNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strFolderNameRandom+"' as folder name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpFolderName));
		return strFolderNameRandom;
	}
	public void selectEffectiveDateOnCreateFolderPopupPage(String strYear, String strMonth, String strDate){
		objPojo.getObjWrapperFunctions().scrollToView(loc_iconCalender);
		objPojo.getObjWrapperFunctions().datePickerForSHActionClick(loc_iconCalender, strYear, strMonth, strDate);
		objPojo.getObjUtilities().logReporter("Select date as '"+strDate+"', month as '"+strMonth+"', year as '"+strYear+"' from calender.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconCalender));		
	}
	public String selectWorkFlowCategoryOptionFromDropdown(String strWorkflowCategory) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strWorkflowCategory+"' from workflow category dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpWorkflowCategory, strWorkflowCategory, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpWorkflowCategory);
		return strWorkflowCategory;	
	}
	public void selectFolderModeOptionFromDropdown(String strFolderMode) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strFolderMode+"' from Folder Mode dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFolderMode, strFolderMode, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFolderMode);	
	}
	public String selectLineOfBusinessOptionFromDropdown(String strLineOfBusiness) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strLineOfBusiness+"' from line of business dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpLineofBusiness, strLineOfBusiness, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpLineofBusiness);
		return strLineOfBusiness;	
	}
	public String selectMarketSegmentOptionFromDropdown(String strMarketSegementValue) {
		objPojo.getObjWrapperFunctions().scrollToView(loc_drpMarketSegment);
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strMarketSegementValue+"' from market segment dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpMarketSegment, strMarketSegementValue, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpMarketSegment);
		return strMarketSegementValue;
	}

	public String selectStateOptionFromDropDown(String strStateDrpValue) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strStateDrpValue+"' from state dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpState, strStateDrpValue, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpState);
		return strStateDrpValue;
	}
	public String selectRegionOptionFromDropdown(String strRegionDrpValue) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strRegionDrpValue+"' from region dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpRegion, strRegionDrpValue, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpRegion);
		return strRegionDrpValue;
	}

	public void clickOnSaveButtonOnCreateFolderPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can on save button on create folder popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSaveAndNext));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
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
				this.verifyDropdownOptionsfromCreateFolderPopup(loc_drpName, strDrpValue);
			}
		}
	}
	public void verifyDropdownOptionsfromCreateFolderPopup(By loc_drpName, String strdrpName) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strdrpName + "'  from  dropdown ",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpName, strdrpName));
	}
	public String selectFundingArrangementOptionFromDropdown(String strFundingArrangement) {
		objPojo.getObjUtilities().logReporter("Verify user can select '" + strFundingArrangement + "' from Funding Arrangement dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFundingArrangement, strFundingArrangement,"Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFundingArrangement);
		return strFundingArrangement;
	}
	public void verifyCancelButtonOnCreateFolderPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can see cancel button on add new portfolio popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCancel));
	}
	public void verifySaveAndNextButtonOnCreateFolderPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can see save and next button on add new portfolio popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSaveAndNext));

	}
	// verifying dropdowns with option
	@Step("Verify the UI of Create Folder popup Page")
	public void verifyDropDownWithOptionsStates(String strdrpName, List<String> listStatesFromML) {
		By loc_drpName = By.xpath("//select[@id='" + strdrpName + "']");
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown '" + strdrpName + "",
				objPojo.getObjWrapperFunctions().actionClick(loc_drpName));
		for (int index = 0; index < listStatesFromML.size(); index++) {
			String strDrpValue = listStatesFromML.get(index).trim();
			if (!strDrpValue.equals("")) {
				objPojo.getObjWrapperFunctions().waitFor(1);
				this.verifyDropdownOptionsfromCreateFolderPopup(loc_drpName, strDrpValue);
			}
		}
	}

	/**
	 * Scenario: 119939
	 * Description: Verify the functionality and UI of Create Folder icon within Foundation Template page and verify the Folder Name is displayed correctly
	 */
	
	public void verifyDropDownOnCreateFolderPopUp(String strdrpName)
	{
		By locator = By.xpath("//select[@id='"+strdrpName+"']");
		objPojo.getObjUtilities().logReporter("Verify "+strdrpName+" dropdown is displayed on create folder pop up",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator) );
	}
	public void verifyErrorOrValidationMessage(String strMessage)
	{
		By locator=By.xpath("//span[contains(text(),'"+strMessage+"')]");
		objPojo.getObjUtilities().logReporter("Verify "+strMessage+" is displayed on create folder pop up ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator) );
	}
	public void selectFundingArrangementOptionForDisabled() {
		objPojo.getObjUtilities().logReporter("Verify user not able to  see Funding Arrangement dropdown",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_drpFundingArrangement));
	}
	//120038
	public void verifyErrorMessageAfterselectDate(String strMessage){
		By locator=By.xpath("//span[contains(text(),'"+strMessage+"')] ");
		objPojo.getObjUtilities().logReporter("Verify Error  "+strMessage+"'s effective date. is displayed on create folder pop up ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
}

