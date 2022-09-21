package com.popupFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class CreateNewPackagePopUp {
	
	private Pojo objPojo;
	private String strPackageNameRandom = "";
	private String strPackageFolderNameRandom = "";

	public CreateNewPackagePopUp(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrCreatePackage=By.xpath("//div[@class='popover-header']//div[text()='Create Package']");

	By loc_btnRadioCreate = By.xpath("//input[@id='pkgCreate'][@type='radio']");
	By loc_inpPackageName= By.xpath("//label[text()='Package Name:']//parent::div//input[@id='txtPackageName']");
	By loc_inpPackageFldName= By.xpath("//label[text()='Package Folder Name:']//parent::div//input[@id='txtPackageFolderName']");
	By loc_iconCalender= By.xpath("//input[@id='pkgeffectiveDate']");
	By loc_drpFundingArrangement = By.xpath("//select[@id='drpfunding']");
	By loc_drpMarketSegment = By.xpath("//select[@id='drpMarketSegment']");
	By loc_drpFolderMode = By.xpath("//select[@id='folderModeDDLPackage']");
	By loc_drpState = By.xpath("//select[@id='drpState']");
	By loc_drpRegion = By.xpath("//select[@id='drpRegion']");
	By loc_drpCategoryPackageBuild = By.xpath("//select[@id='drpcategoryDDL']/option[text()='Package Build']");
	By loc_firstRowFromSelectDocTable = By.xpath("//table[@id='pkgDocSearch']//tr[@role='row' and @id='1']//td[@aria-describedby='pkgDocSearch_FolderName']");
	By loc_btnSelect = By.xpath("//span[contains(@class,'ui-icon ui-icon-check')]");
	By loc_hdrConfirmPopUp = By.xpath("//span[@id='ui-id-22' and text()='Confirm']");
	By loc_btnConfirmNoButton = By.xpath("//span[@id='ui-id-22' and text()='Confirm']//following::div[@class='ui-dialog-buttonset']//button[text()='No']");
	By loc_btnSubmit = By.xpath("//button[@id='btnPackageSave'][text()='Submit']");
	
	
	
	public void verifyCreatePackagePopupHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify create package pop up header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrCreatePackage));
	}
	
	public void clickCreateRadioButtonOnCreatePackagePopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on create radio button on Create Package Pop up",
				objPojo.getObjWrapperFunctions().click(loc_btnRadioCreate));
	}
	
	public String enterPackageNameOnCreatePackagePopup(String strPackageName){
		strPackageNameRandom=strPackageName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPackageName);
		objPojo.getObjWrapperFunctions().setText(loc_inpPackageName, strPackageNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strPackageNameRandom+"' as package name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPackageName));
		return strPackageNameRandom;		
	}

	public String enterPackageFolderNameOnCreatePackagePopup(String strPackagefolderName){
		strPackageFolderNameRandom=strPackagefolderName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPackageFldName);
		objPojo.getObjWrapperFunctions().setText(loc_inpPackageFldName, strPackageFolderNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strPackageFolderNameRandom+"' as package folder name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPackageFldName));
		return strPackageFolderNameRandom;		
	}		
	
	public String selectMarketSegmentOptionFromDropdown(String strMarketSegment) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strMarketSegment+"' from Market Segment dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpMarketSegment, strMarketSegment, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpMarketSegment);
		return strMarketSegment;	
	}
	public String selectFolderModeOptionFromDropdown(String strFolderMode) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strFolderMode+"' from Market Segment dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpFolderMode, strFolderMode, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpFolderMode);
		return strFolderMode;	
	}
	public String selectStateOptionFromDropDown(String strStateDrpValue) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strStateDrpValue+"' from state dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpState, strStateDrpValue, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpState);
		return strStateDrpValue;
	}
	public void clickOnSubmitButtonToSaveCreatedPackage(){
		objPojo.getObjUtilities().logReporter("Click on Yes Button on confirm pop up",
				objPojo.getObjWrapperFunctions().click(loc_btnSubmit));
	}	
	public String selectCategoryOptionFromDropdown(String strWorkflowCategory) {
		By loc_drpWorkflowCategory = By.xpath("//select[@id='drpcategoryDDL']");
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strWorkflowCategory+"' from workflow category dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpWorkflowCategory, strWorkflowCategory, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpWorkflowCategory);
		return strWorkflowCategory;	
	}
	public void selectEffectiveDateOnCreateFolderPopupPage(String strYear, String strMonth, String strDate){
        objPojo.getObjWrapperFunctions().datePickerForSH(loc_iconCalender, strYear, strMonth, strDate);

        objPojo.getObjUtilities().logReporter("Select date as '"+strDate+"', month as '"+strMonth+"', year as '"+strYear+"' from calender.",
                objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconCalender));       
    }
	public void selectBundleProductSelectionCheckbox(String strBundleCheckBoxName){
		By loc_chkBundleProdSelection = By.xpath("//label[text()='"+strBundleCheckBoxName+"']/parent::div//input");
		objPojo.getObjUtilities().logReporter("Click on Bundle Product Selection checkbox on Create Package Pop up",
				objPojo.getObjWrapperFunctions().click(loc_chkBundleProdSelection));
	}
	//Package Creation 
	By loc_drpCopyFrom = By.xpath("//select[@id='copyFromDDLPackage']");
    By loc_drpSelectPackageFolderName = By.xpath("(//label[text()='Select Package Folder Name:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
    By loc_drpSelectFolderVersion = By.xpath("(//label[text()='Select Version:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
    By loc_drpSelectPackageName = By.xpath("(//label[text()='Select Package Name:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
  public String selectDropdownOptionFromCopyFromField(String strCopyFromField) {
        objPojo.getObjUtilities().logReporter("Verify user can select '"+strCopyFromField+"' from copy from dropdown option",
                objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpCopyFrom, strCopyFromField, "Text"));
        objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpCopyFrom);
        return strCopyFromField;    
    }
    public String selectDropdownOptionFromPackageFolderNameField(String strPackageFolderName) {
        objPojo.getObjWrapperFunctions().waitFor(3);
        objPojo.getObjWrapperFunctions().setText(loc_drpSelectPackageFolderName, strPackageFolderName);
        objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectPackageFolderName, "keydown");
        objPojo.getObjUtilities().logReporter("Verify user can select package folder name '" + strPackageFolderName + "' ",
                objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectPackageFolderName, "enter"));
        objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
        return strPackageFolderName;
    }
    public String selectDropdownOptionFromFolderVersionField(String strSelectFolderVersion) {
        objPojo.getObjWrapperFunctions().waitFor(3);
        objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolderVersion, strSelectFolderVersion);
        objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "keydown");
        objPojo.getObjUtilities().logReporter("Verify user can select folder version '" + strSelectFolderVersion + "' ",
                objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "enter"));
        objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
        return strSelectFolderVersion;
    }
    public String selectDropdownOptionFromPackageNameField(String strPackageName) {
        objPojo.getObjWrapperFunctions().waitFor(3);
        objPojo.getObjWrapperFunctions().setText(loc_drpSelectPackageName, strPackageName);
        objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectPackageName, "keydown");
        objPojo.getObjUtilities().logReporter("Verify user can select package name '" + strPackageName + "' ",
                objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectPackageName, "enter"));
        objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
        return strPackageName;
    }
    public String enterPackageNameOnCopyPackagePopup(String strPackageName){
        objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPackageName);
        objPojo.getObjWrapperFunctions().setText(loc_inpPackageName, strPackageName);
        objPojo.getObjUtilities().logReporter("Enter '"+strPackageName+"' as package name",
                objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpPackageName));
        return strPackageName;        
    }
   
}


