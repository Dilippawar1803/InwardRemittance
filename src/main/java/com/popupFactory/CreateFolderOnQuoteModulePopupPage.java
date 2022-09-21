package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.Pojo;

import ru.yandex.qatools.allure.annotations.Step;

public class CreateFolderOnQuoteModulePopupPage {
	private Pojo objPojo;

	public CreateFolderOnQuoteModulePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	private String strQuoteNameRandom="";


	By loc_QuoteName=By.xpath("//label[text()='Quote Name']//following::input[@id='folderName']");
	By loc_drpFolderMode= By.xpath("//select[@id='folderModeDDL']");
	By loc_btnSave = By.xpath("//button[@id='btnFolderDialogSave'][text()='Save & Next']");
	By loc_drpMarketSegment = By.xpath("//select[@id='marketSegment']");
	By loc_BtnCancel=By.xpath("(//button[text()='Cancel'])[2]");
	By loc_drpSearchTypeFilter = By.xpath("//select[@id='drpsearchTypeFilter']");
	By loc_txtAccountName=By.xpath("//input[contains(@id,'searchDoc')]");
	By loc_drpViewMode = By.xpath("//select[@id='drpViewModeLoad']");
	By loc_btnCreateQuote=By.xpath("//span[contains(@class,'ui-icon ui-icon-plus icons-Union')]");
	By loc_btnClose=By.xpath("(//span[text()='close'])[3]");
	By loc_drpFundingArrengement = By.xpath("//select[@id='fundingArrangement']");
	By loc_Calender=By.xpath("(//img[@src='/Content/css/custom-theme/images/calender-icon.svg'])[4]");
	By loc_labelSelectAccount=By.xpath("//input[@id='accountNamesAutoCompltDDL']");
	By loc_drpWorkflowCategory = By.xpath("//select[@id='categoryDDL1']");
	By loc_drpLineofBusiness = By.xpath("//select[@id='lineOfBusiness']");
	By loc_drpState = By.xpath("//select[@id='state']");
	By loc_drpRegion = By.xpath("//select[@id='region']");





	
	public void verifyDropdownOptionsFolderModeOnCreateQuote(String strDropdownValues) {
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFolderMode));
		objPojo.getObjUtilities().logReporter("Verify user can see the dropdown value '"+strDropdownValues+"' fronm dropdown list", 
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpFolderMode, strDropdownValues));
	}
	public void verifyDropdownOptionsMarketSegmentOnCreateQuote(String strDropdownValues) {
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown MarketSegment ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpMarketSegment));
		objPojo.getObjUtilities().logReporter("Verify user can see the dropdown value '"+strDropdownValues+"' fronm dropdown list", 
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpMarketSegment, strDropdownValues));
	}
	public void verifyDropdownOptionsFundingArrengementCreateQuote(String strDropdownValues) {
		objPojo.getObjUtilities().logReporter("Verify user can click on dropdown blanktext ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFundingArrengement));
		objPojo.getObjUtilities().logReporter("Verify user can see the dropdown value '"+strDropdownValues+"' fronm dropdown list", 
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpFundingArrengement, strDropdownValues));
	}

	public void verifyAccountIsCreatedOrNot(String strAccountName){	
		By locator = By.xpath("//h5/span[text()='"+strAccountName+"']");
		objPojo.getObjUtilities().logReporter("Verify Account is created "+strAccountName+" ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}
	public void clickOnCreatedAccount(String strAccountName){	
		By locator = By.xpath("//h5/span[text()='"+strAccountName+"']");
		objPojo.getObjUtilities().logReporter("Verify user can click on created account",
				objPojo.getObjWrapperFunctions().click(locator));
	}
	public void verifyCreatedAccountIsOpenForCreateFolder(String strAccountName){			
		By locator = By.xpath("//div/h2[text()='"+strAccountName+" List']");
		objPojo.getObjUtilities().logReporter("Verify Account is created "+strAccountName+" ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnAddGridToAddFolder(){
		objPojo.getObjUtilities().logReporter("Click on Add/Create quote to add details ",
				objPojo.getObjWrapperFunctions().click(loc_btnCreateQuote));

	}

	public void verifyHeaderOfPopUp(String strHeader){
		By locator=By.xpath("//span[text()='"+ strHeader+"']");
		objPojo.getObjUtilities().logReporter("Verify user can see header '"+strHeader+"'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}
	public void verifyCloseButton(){
		objPojo.getObjUtilities().logReporter("Verify user can chech Close Button is display at Right left corner",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnClose));
	}

	public String enterQuoteNameOnCreateFolderPopup(String strFolderName){
		strQuoteNameRandom=strFolderName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_QuoteName);
		objPojo.getObjWrapperFunctions().setText(loc_QuoteName, strQuoteNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strQuoteNameRandom+"' as folder name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_QuoteName));
		return strQuoteNameRandom;
	}
	public void selectEffectiveDateOnCreateFolderPopupPage(String strYear, String strMonth, String strDate){
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_Calender, strYear, strMonth, strDate);
		objPojo.getObjUtilities().logReporter("Select date as '"+strDate+"', month as '"+strMonth+"', year as '"+strYear+"' from calender.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Calender));		
	}

	public void verifySelectAccount(){
		objPojo.getObjUtilities().logReporter("Verify Select Account is selected ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_labelSelectAccount));			
	}
	public String selectWorkFlowCategoryOptionFromDropdown(String strWorkflowCategory) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strWorkflowCategory+"' from workflow category dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpWorkflowCategory, strWorkflowCategory, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpWorkflowCategory);
		return strWorkflowCategory;	
	}

	public String selectFolderModuleOptionFromDropdown(String strFolderModule) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strFolderModule+"' from Folder Module dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFolderMode, strFolderModule, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFolderMode);
		return strFolderModule;	
	}

	public String selectLineOfBusinessOptionFromDropdown(String strLineOfBusiness) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strLineOfBusiness+"' from line of business dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpLineofBusiness, strLineOfBusiness, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpLineofBusiness);
		return strLineOfBusiness;	
	}
	public String selectMarketSegmentOptionFromDropdown(String strMarketSegementValue) {
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
		objPojo.getObjUtilities().logReporter("Verify user can on save button on create Quote popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public String selectFundingArrengementOptionFromDropdown(String strFundingArrengement) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strFundingArrengement+"' from Funding Arrengement dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFundingArrengement, strFundingArrengement, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFundingArrengement);
		return strFundingArrengement;	
	}

	public void verifyCancelButton(){
		objPojo.getObjUtilities().logReporter("Verify user can check Close Button is display at Right left corner",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_BtnCancel));
	}

	public void verifyDropdownOptionsfromAddFolderPopupForAccounts(By loc_drpName, String strdrpName) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see the dropdown value '" + strdrpName + "'  from  dropdown ",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpName, strdrpName));
	}
	


	
	//new method
    // verifying state dropdown with option
    @Step("Verify the UI of Create Folder popup Page")
    public void verifyStateDropDownWithOptions(String strdrpName,List<String> listStatesFromML) {

    
        By loc_drpName = By.xpath("//select[@id='" + strdrpName + "']");
        objPojo.getObjUtilities().logReporter("Verify user can click on dropdown '" + strdrpName + "",
                objPojo.getObjWrapperFunctions().actionClick(loc_drpName));
        for (int index = 0; index < listStatesFromML.size(); index++) {
            String strDrpValue = listStatesFromML.get(index).trim();

            if (!strDrpValue.equals("")) {
                objPojo.getObjWrapperFunctions().waitFor(1);

                this.verifyDropdownOptionsfromAddFolderPopupForAccounts(loc_drpName, strDrpValue);
            }
        }
    }
}
