package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class GenerateRedlineDocumentPopUpPage {
	
	
		// Global Variables
		private Pojo objPojo;

		public GenerateRedlineDocumentPopUpPage(Pojo pojo) {
			this.objPojo = pojo;
		}
		
		// locators
		By hdrGenerateRedlineDocumentPopUp = By.xpath("//span[contains(@id,'ui-id')][text()='Generate Redline Document']");
		By loc_drpCollateralType = By.xpath("//label[text()='Collateral Type:']/following-sibling::select");
		By loc_btnQueue = By.xpath("//button[text()='Queue']");
		By loc_btnCrossIcon = By.xpath("//span[text()='Generate Redline Document']/following-sibling::a/span[text()='close']");
		By loc_chkBoxTextSelectAll = By.xpath("//span[@class='ag-filter-value'][contains(.,'(Select All)')]");
		By loc_inputTextInFilterBox = By.xpath("//input[@class='ag-filter-filter'][@type='text']");
		By loc_clickOnReapeterName = By.xpath("//div[@class='ag-theme-fresh']/div[contains(.,'Select Source Documents')][1]");
		By loc_AddButton = By.xpath("//button[@id='btnAddToGrid' and text()='Add']");
		By loc_btnclose = By.xpath("//span[text()='Generate Redline Document']/following::span[@class='ui-icon ui-icon-closethick']");

		public void verifyHeaderOfGenerateRedlineDocumentPopUp() {

			objPojo.getObjUtilities().logReporter("Verify user can see header of Generate Redline Document Pop Up",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(hdrGenerateRedlineDocumentPopUp));
		}
		
		public void selectCollateralTypeOnGenerateRedlineDocumentPopUp(String strCollateralType) {

			objPojo.getObjUtilities().logReporter(
					"Verify user can see select dropdown option '" + strCollateralType
					+ "' Collateral type dropdown On Generate Redline Document PopUp ",
					objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpCollateralType, strCollateralType, "text"));

		}
		
		public void clickOnSourceDocumentRowInGenerateRedlineDocumentPopUp(String strAccountFolderName)
		{
			By locator = By.xpath("//td[@aria-describedby='targetRedlineGrid_FolderName' and contains(.,'"+strAccountFolderName+"')]");
			objPojo.getObjUtilities().logReporter("verify user can click on Source Document Row In Generate Redline Document PopUp",
					objPojo.getObjWrapperFunctions().click(locator));
		}
		
		public void clickOnTargetDocumentRowInGenerateRedlineDocumentPopUp(String strAccountFolderName)
		{
			By locator = By.xpath("//td[@aria-describedby='sourceRedlineGrid_FolderName' and contains(.,'"+strAccountFolderName+"')]");
			objPojo.getObjUtilities().logReporter("verify user can click on Target Document Row In Generate Redline Document PopUp",
					objPojo.getObjWrapperFunctions().click(locator));
		}
		
		public void clickOnQueueButtonOnGenerateRedlineDocumentPopUp()
		{
			
			objPojo.getObjUtilities().logReporter("verify user can click on Queue button In Generate Redline Document PopUp",
					objPojo.getObjWrapperFunctions().click(loc_btnQueue));
		}
		
		public void clickOnCrossIconOnGenerateRedlineDocumentPopUp()
		{
			
			objPojo.getObjUtilities().logReporter("Verify user can click on cross icon on Generate Redline Document Pop Up",
					objPojo.getObjWrapperFunctions().click(loc_btnCrossIcon));
		}
		
	/**
	 * Scenario: 118251 
	 * Description: Verify RedlineDocument Navigation from
	 * Portfolio Folder 3Dot Menu
	 */
	public void clickOnFilterIconOnGenerateRedlineDocument(String strRepeaterName, int intIndex) {
		By locator = By.xpath("(//div[text()='" + strRepeaterName
				+ "']/ancestor::div[@class='icon-toolbar']/following-sibling::div[@id='borderLayout_eRootPanel']//span[@class='ag-icon ag-icon-filter'])["
				+ intIndex + "]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on filter icon on Generate Redline Document pop up",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnSelectAllFilterToDeselect() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_chkBoxTextSelectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select all check box to deselect it.",
				objPojo.getObjWrapperFunctions().click(loc_chkBoxTextSelectAll));
	}

	public String enterFilterOption(String strPortfolioFolderName) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can entere '" + strPortfolioFolderName + "' folder name in filter search box",
				objPojo.getObjWrapperFunctions().setText(loc_inputTextInFilterBox, strPortfolioFolderName));
		return strPortfolioFolderName;
	}

	public String clickOnCheckBoxFromFilterOption(String strPortfolioFolderName) {
		By locator = By.xpath("//span[@class='ag-filter-value'][contains(text(),'" + strPortfolioFolderName + "')]");
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strPortfolioFolderName + "' checkbox",
				objPojo.getObjWrapperFunctions().click(locator));
		return strPortfolioFolderName;
	}

	public void clickOnClearFilterOrApplyFilterButtonFromFilters(String strFilterName) {
		By locator = By.xpath("//button[@type='button'][contains(.,'" + strFilterName + "')]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify user can click on '" + strFilterName + "' filter",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void clickOnRepeaterText() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Reapeter name text",
				objPojo.getObjWrapperFunctions().click(loc_clickOnReapeterName));
	}

	public String getFolderVersionNo(String strFolderName) {
		By locator = By.xpath("(//div[@col-id='FolderName' and text()='" + strFolderName
				+ "']/following-sibling::div[@col-id='FolderVersionNumber'])[1]");
		String steVersion = objPojo.getObjWrapperFunctions().getText(locator, "Text");
		return steVersion;

	}

	public void clickOnAddButton() {
		objPojo.getObjUtilities().logReporter("Click on Add button",
				objPojo.getObjWrapperFunctions().click(loc_AddButton));
	}
	
	public void clickOnTargetVersionNumber(String strFolderName, String strFolderVersionNo) {
		By locator = By.xpath("//div[@id='targetBulkRedlineGridAG']/descendant::div[@col-id='FolderName' and text()='"
				+ strFolderName + "']/following-sibling::div[contains(text(),'" + strFolderVersionNo + "')]");
		objPojo.getObjUtilities().logReporter("Verify user can click on Version No",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void clickOnCloseButton() {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Verify user can click the close Icon ",
				objPojo.getObjWrapperFunctions().click(loc_btnclose));
	}

	public void clickOnFilterIconOnQuouedRedlineList(int intIndex) {
		By locator = By.xpath("(//button[@ref='eButtonShowMainFilter']/child::span[@class='ag-icon ag-icon-filter'])["
				+ intIndex + "]");
		objPojo.getObjUtilities().logReporter(
				"Verify user can click on filter icon on Generate Redline Document pop up",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void clickOnFolderVersionNumber(String strFolderName, String strFolderVersionNo) {
		By locator = By.xpath("(//div[@col-id='FolderName' and text()='" + strFolderName
				+ "']/following-sibling::div[contains(text(),'" + strFolderVersionNo + "')])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on Version No",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void verifyTheSRCAndTargetVersionNo(String strFolderName, String strFolderVersionNo) {
		By locator = By.xpath("//div[@id='targetBulkRedlineGridAG']/descendant::div[@col-id='FolderName' and text()='"
				+ strFolderName + "']/following-sibling::div[contains(text(),'" + strFolderVersionNo + "')]");
		objPojo.getObjUtilities().logReporter("Verify the Target folder Version No",
				objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(locator));
	}

}
