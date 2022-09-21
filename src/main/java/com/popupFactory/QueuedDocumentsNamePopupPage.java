package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class QueuedDocumentsNamePopupPage {
	// Global Variables
	private Pojo objPojo;
	
	public QueuedDocumentsNamePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_btnCrossIcon = By.xpath("//span[text()='Queued Documents Name']/following-sibling::a/span[text()='close']");
	/**
	 * Scenario:  149517
	 * Description: Verify that user is able to navigate to the Error Summary Report child window after clicking on 508 Compliance button
	 */
	public void verifyHeaderOfQueuedDocumentsNamePopup(String strHeaderName){
		By locator = By.xpath("//span[text()='"+strHeaderName+"']");
		objPojo.getObjUtilities().logReporter("Verify user can see  header  of "+strHeaderName+" Page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnAnyRowOnQueuedDocumentsNamePopup(String strFolderName, int intIndex){
		objPojo.getObjWrapperFunctions().waitFor(3);
		By locator=By.xpath("(//td[@aria-describedby='downloadQueuedCollateralsGrid_FolderName' and text()='"+strFolderName+"'])["+intIndex+"]");
		objPojo.getObjUtilities().logReporter("click On first row of Queued Documents Name Popup",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}
	public void clickOnDownloadOption(String strTitle,int intRowIndex){
		By locator=By.xpath("(//td/descendant::img[contains(@title,'"+strTitle+"')])["+intRowIndex+"]");
		objPojo.getObjUtilities().logReporter("click on Download option for "+strTitle+" on Queued Documents Name Popup Page",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjWrapperFunctions().waitFor(5);
	}
	
	public void clickOnFiveHundredCompilanceButton(){
		By loc_CompilanceButton=By.xpath("//span[contains(.,'View Compliance')]/following::button[contains(.,'508 Compliance')]");
		objPojo.getObjUtilities().logReporter("click on 508 Compliance on View Compliance Queued Documents Name Popup Page",
				objPojo.getObjWrapperFunctions().click(loc_CompilanceButton));
	}
	public void verifyErrorSummaryReportHeader(){
		By loc_ErrorSummaryReport=By.xpath("//span[@class='ui-dialog-title'][contains(.,'Error Summary Report')]");
		objPojo.getObjUtilities().logReporter("verify Error Summary Report Header ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ErrorSummaryReport));
	}
	
	/**
	 * Scenario:  149518
	 * Description: Verify that user is able to see appropriate message on Clicking Generate Report at the Error Summary Report child window
	 */
	public void clickOnGenrateReportButton(){
		objPojo.getObjWrapperFunctions().waitFor(2);
		By loc_GenrateReport=By.xpath("//span[text()='Error Summary Report']/following::div[contains(.,'Generate Report')]//parent::button[@id='btnGenerateErrorReport']");
		objPojo.getObjUtilities().logReporter("click on Generate Report button on Error Summary Report window",
				objPojo.getObjWrapperFunctions().click(loc_GenrateReport));
	}
	

	/**
	 * Scenario:  149514
	 * Description: Verify that user is able to locate Download column for PDF under Queued Document Name popup window
	 */
	public void verifyColumnNameQueuedDocumentsNamePopup(String strColumnName){
		By locator = By.xpath("(//table[@class='ui-jqgrid-htable']//tr[@class='ui-jqgrid-labels']//th//child::div[text()='"+strColumnName+"'])[1]");
		objPojo.getObjWrapperFunctions().scrollToView(locator);
		objPojo.getObjUtilities().logReporter("Verify user can see  Column Name of "+strColumnName+" Queued Document Name popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjWrapperFunctions().waitFor(2);

	}

	public void verifyOnDownloadOption(String strTitle,int intRowIndex){
		By locator=By.xpath("(//td/descendant::img[contains(@title,'"+strTitle+"')])["+intRowIndex+"]");
		objPojo.getObjUtilities().logReporter("verify user is able to see Download option for "+strTitle+" on Queued Documents Name Popup Page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	public void verifyButton508ComplianceDisplayInCollateralCompliance(String strButtonText){
		By locator = By.xpath("//button[text()='"+strButtonText+"']");
		objPojo.getObjUtilities().logReporter("Verify user can see  button is display  for collateral compliances in "+strButtonText+" on Queued Documents Name Popup Page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}


	/**
	 * Scenario: 149657
	 * Description: Verify functionality of Below Options under product level at Account
	 */
	
	
	public void verifyQueuedCollateralIsDisplayed(String strCollateralName)
	{
		By locator = By.xpath("//td[@aria-describedby='downloadQueuedCollateralsGrid_CollateralName' and contains(.,'"+strCollateralName+"')]");
		objPojo.getObjUtilities().logReporter("Verify user can see the queued collateral '"+strCollateralName+"' in Collateral Queued section ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}

	
	public void clickOnCrossIconOnQueuedDocumentsNamePopUpPage()
	{
		
		objPojo.getObjUtilities().logReporter("Verify user can click on cross icon on Queued Documents Name Pop Up",
				objPojo.getObjWrapperFunctions().click(loc_btnCrossIcon));
	}
	

}
