package com.popupFactory;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class SelectMedicalProductPopUp {
	private Pojo objPojo;
	private String strPackageNameRandom = "";

	public SelectMedicalProductPopUp(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrCreatePackage=By.xpath("//span[contains(text(),'Select Medical Product')]");
	By loc_clickOnFld=By.xpath("//td[text()='Shubham_New']");

	public void verifyCreatePackagePopupHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify create package pop up header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrCreatePackage));
	}
	public void searchFolderNameSelectMedicalProductPopUpPage(String strFolderName) {
		By locator = By.xpath("//input[@name='FolderName']");
		objPojo.getObjUtilities().logReporter("Verify user can search " + strFolderName + " on select Select Medical Product PopUpPage",
				"User should be able to search folder " + strFolderName + " on portfolio Page",
				"User can search " + strFolderName + " on portfolio Page",
				objPojo.getObjWrapperFunctions().setText(locator, strFolderName));
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(locator, "Enter");
	}
	public void clickOnFolderNameOnSelectMedicalProductPopUpPage(){
		objPojo.getObjUtilities().logReporter("Click on folder name",
				objPojo.getObjWrapperFunctions().click(loc_clickOnFld));
	}
	public  void clickOnSaveOrCancelButtonOnSelectMedicalProductPopUpPage(String Btn_Name){
		By loc_clickBtn=By.xpath("//div[@class='col-sm-12 d-flex justify-content-end pr-0 pt-3']//button[text()='"+Btn_Name+"']");
		objPojo.getObjUtilities().logReporter("Click on folder name",
				objPojo.getObjWrapperFunctions().click(loc_clickBtn));
	}
	
	public String verifyAndSelectFirstRowFromSelectDocument(){
		String strSelectedFolderName = "";
		String strSelectedDocumentName = "";
		By locator =By.xpath("//table[@id='pkgDocSearch']//tr[@role='row']");
		List<WebElement> list = objPojo.getObjWrapperFunctions().getWebElementList(locator);
		int intIndex=0;
		for (int i = 0; i < 10; i++) {
			Random rn = new Random();
			intIndex = rn.nextInt(list.size()-1);
			System.out.println("Size::"+list.size());
			System.out.println("Index:"+intIndex);
			if (intIndex!=0) {
				System.out.println("Index not zero:"+intIndex);
				break;
			}	
		}
		By loc_folderName= By.xpath("//table[@id='pkgDocSearch']//tr[@role='row' and @id='"+intIndex+"']//td[@aria-describedby='pkgDocSearch_FolderName']");
		objPojo.getObjUtilities().logReporter("Verify at least first row is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_folderName));
		objPojo.getObjUtilities().logReporter("Click to select the first row from table",
				objPojo.getObjWrapperFunctions().click(loc_folderName));
		strSelectedFolderName=objPojo.getObjWrapperFunctions().getText(loc_folderName, "text");
		
		By loc_DocName= By.xpath("//table[@id='pkgDocSearch']//tr[@role='row' and @id='"+intIndex+"']//td[@aria-describedby='pkgDocSearch_FormInstanceName']");
		strSelectedDocumentName=objPojo.getObjWrapperFunctions().getText(loc_DocName, "text");
		return strSelectedFolderName+";"+strSelectedDocumentName;
	}
	
	public void clickOnFolderNameOnSelectMedicalProductPopUpPage(String strPortfolioFolderName){
		By loc_DocName= By.xpath("//td[text()='"+strPortfolioFolderName+"']");
		
		objPojo.getObjUtilities().logReporter("Click on folder name",
				objPojo.getObjWrapperFunctions().click(loc_DocName));
	}
	
	public void verifyCreatePackagePopupHeaderIsDisplayedforSpecificProduct(String strPopupHeader) {
		By locator=By.xpath("//span[contains(text(),'"+strPopupHeader+"')]");
		objPojo.getObjUtilities().logReporter("Verify create package pop up header is displayed.",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
}

