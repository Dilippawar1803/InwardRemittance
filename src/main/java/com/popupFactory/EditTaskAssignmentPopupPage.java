package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class EditTaskAssignmentPopupPage {

	private Pojo objPojo;
	private String strReturnVal = "";
	private String strFolderName="";
	private String strTaskNameRandom="";

	//locator
	By loc_SaveEditTask=By.xpath("(//span[text()='Edit Task Assignment']//following::button[@id='taskAssigWatchSaveBtn' and text()='Save'])[1]");
	By loc_hdrEditTaskAssignment=By.xpath("//span[text()='Edit Task Assignment']");
	By loc_Plans = By.xpath("//label[text()='Plans']/ancestor::div[2]/descendant::button[@title='Select an option']");
	
	public EditTaskAssignmentPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	public void selectValueFromTheTaskStatusDropDown(String strPath, String strValue) {
		By locator = By.xpath("(//span[text()='Edit Task Assignment']//following::label[text()='"+strPath+"']//following::select)[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("User select "+strPath+" dropdown with '" + strValue + "' .",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
	}
	public void clickOnAssignUserOnEditTask()
	{
		By locator=By.xpath("//label[text()='Assign User']//following::span[contains(text(),'Select an Option')]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of assign User.", 
				objPojo.getObjWrapperFunctions().click(locator));
	}
	public void verifyHeaderOfEditTaskPopup()
	{
		By locator=By.xpath("//span[text()='Edit Task Assignment']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Click Edit Assignment Task popup header is displayed.", 
				objPojo.getObjWrapperFunctions().click(locator));
	}
	public void clickOnPlanOnEditTask()
	{
		By locator=By.xpath("(//label[text()='Plans']//following::span[contains(@class,'multiselect-selected-text')][text()='Select an option'])[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of Plans.", 
				objPojo.getObjWrapperFunctions().click(locator));
	}
	
	public void clickOnSaveEditTask()
	{
		
		objPojo.getObjUtilities().logReporter("Verify user can click on save edit task",
				objPojo.getObjWrapperFunctions().click(loc_SaveEditTask));
	}
	
	/**
	 *
	 * Scenario: 118050
	 * Description: Verify if user is able to create a new version from major version
	 */
	
	public void clickEditTaskAssignment(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrEditTaskAssignment);
		objPojo.getObjUtilities().logReporter("Click Edit Task Assignment popup header is displayed.", 
				objPojo.getObjWrapperFunctions().click(loc_hdrEditTaskAssignment));
	}
	
	public void clickOnSelectOptionsOnPlans() {	
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Plans);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of Plans.", 
				objPojo.getObjWrapperFunctions().actionClick(loc_Plans));
	}
}
