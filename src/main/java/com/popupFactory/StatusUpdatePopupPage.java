package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class StatusUpdatePopupPage {
	// Global Variables
	private Pojo objPojo;

	public StatusUpdatePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_hdrStatusUpdate=By.xpath("//h3[text()='Status Update']");
	By loc_btnSave=By.xpath("//button[@id='updatestatus'][@type='button']");
	By loc_drpWorkflowState = By.xpath("//select[@id='workflowstatelist']");
	By loc_drpApprovalStatus = By.xpath("//select[@id='approvaltypelist']");
	By loc_btnCancel=By.xpath("//button[@type='button'][contains(@id,'close')]");

	/**
	 * 
	 * Scenario: 118050
	 * Description: Verify if user is able to create a new version from major version
	 */
	public void verifyStatusUpdatePopupPageHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify Status Update popup header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrStatusUpdate));
	}
	public void clickOnSaveButtonOnStatusUpdatePopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on Status Update popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void selectValueFromWorkflowStateDropDown(String strWorkFlowState) {
		By locator = By.xpath("//select[@id='workflowstatelist']//option[text()='" + strWorkFlowState + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Select Workflow State on Status Update Pop up",
				"user should able to select Workflow State on Status Update Pop up",
				"user is able to select Workflow State on Status Update Pop up",
				objPojo.getObjWrapperFunctions().click(locator));
	}

	public void selectValueFromApprovalStateDropDown(String strApprovalState) {
		By locator = By.xpath("//select[@id='approvaltypelist']//option[text()='" + strApprovalState + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Select Approval State on Status Update Pop up",
				"user should able to select Approval State on Status Update Pop up",
				"user is able to select Approval State on Status Update Pop up",
				objPojo.getObjWrapperFunctions().click(locator));
	}
	
	/**
	 * Scenario: 169873
	 * Description: Verify the functionality of Workflow State Update when user sold the quote
	 */
	
	public void selectValueFromApprovalStatusDropDown(String strApprovalState) {
		By locator = By.xpath("//select[@id='approvaltypelist']");
		objPojo.getObjUtilities().logReporter("Select Approval State on Status Update Pop up",
				"user should able to select Approval State on Status Update Pop up",
				"user is able to select Approval State on Status Update Pop up",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strApprovalState, "text"));
	}
	public void verifyCommentTextBox()
	{
		By locator=By.xpath("//textarea[@id='comment']");
		 objPojo.getObjUtilities().logReporter("Verify user see Comment Textbox",
	                objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void verifyDropdownOnStatusUpdatePage(String strDropdownName) {
		By locator = By
				.xpath("//label[text()='" + strDropdownName + "']/parent::div[1]/following-sibling::div/child::select");
		System.out.println("locator :" + locator);
		objPojo.getObjUtilities().logReporter("Verify " + strDropdownName + " Dropdown on Status update workflow",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void verifySaveButtonIsHighlightedInBlueColor()
	{
		String strColorCode=objPojo.getObjWrapperFunctions().getCSSValue(loc_btnSave, "background-color");
		if(strColorCode.equals("#0174b2"))
		{
			objPojo.getObjUtilities().logReporter("Verify Highlighted Color code"+strColorCode+"is blue",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSave));
		}
		else
			objPojo.getObjUtilities().logReporter("Verified color is not blue-------->>", false);
	}
	public void verifyCancelButtonOnStatusUpdatePopupPage()
	{
		objPojo.getObjUtilities().logReporter("Verify Cancel Button",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCancel));
	}

	public void verifyCellBorderIsHighlightedInRedColor(String strColId, int intRowIndex) {
		By locator = By.xpath(
				"(//div[@class='ag-body-viewport']//child::div[@col-id='" + strColId + "'])[" + intRowIndex + "]");
		String strColorCode = objPojo.getObjWrapperFunctions().getCSSValue(locator, "box-shadow");
		if (strColorCode.equals("##ff0000")) {
			objPojo.getObjUtilities().logReporter("Verify Highlighted Color code" + strColorCode + "is red",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		} else
			objPojo.getObjUtilities().logReporter("Verified color is not red-------->>", false);
	}
}
