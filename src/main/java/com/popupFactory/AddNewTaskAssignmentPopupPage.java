package com.popupFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddNewTaskAssignmentPopupPage {

	private Pojo objPojo;
	private String strReturnVal = "";
	private String strFolderName="";
	private String strTaskNameRandom="";

	public AddNewTaskAssignmentPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrAddNewTaskAssignment=By.xpath("//span[text()='Add New Task Assignment']");
	By loc_Plans = By.xpath("(//label[text()='Plans']//following::span[contains(text(),'Select an Option')])[1]");
	By loc_StartDate = By.xpath("(//img[@src='/Content/css/custom-theme/images/calender-icon.svg'])[3]");
	By loc_EndDate = By.xpath("(//img[@src='/Content/css/custom-theme/images/calender-icon.svg'])[4]");
	By loc_Folder = By.xpath("(//label[text()='Folder']//following::span[contains(text(),'Select an Option')])[1]");
	By loc_Save=By.xpath("(//button[@id='newTaskCreationSaveBtn'][text()='Save'])[1]");
	By loc_iconCreateTask=By.xpath("(//button[@id='createNewTasksBtn'])[1]");
	By loc_hrdNewTask=By.xpath("//span[@class='ui-dialog-title'][contains(text(),'New Task Creation')]");
	By loc_Task=By.xpath("(//input[@type='text'][@id='newTaskDescription'])[1]");
	By loc_AssignUser=By.xpath("//label[text()='Assign User']/ancestor::div[2]/descendant::button[@title='Select an Option']");
	By loc_MasterList=By.xpath("//label[text()='Master List']/ancestor::div[2]/descendant::button[@title='Select an Option']");
	
	public void verifyAddNewTaskAssignmentPopupHeaderIsDisplayed(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddNewTaskAssignment);
		objPojo.getObjUtilities().logReporter("Verify Add new Assignment popup header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddNewTaskAssignment));
	}
	public void selectValueFromTheTaskStatusDropDown(String strPath, String strValue) {
		By locator = By.xpath("(//span[text()='Add New Task Assignment']//following::label[text()='Task Status']//following::select)[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("User select "+strPath+" dropdown with '" + strValue + "' .",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
	}
	public void selectValueFromTheDropDownList(String strPath, String strValue) {
		By locator = By.
				xpath("(//span[text()='Add New Task Assignment']//parent::div//following::div//label[text()='"+strPath+"']//following::select)[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("User select "+strPath+" dropdown with '" + strValue + "' .",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
	}
	public void clickOnSelectOptionsOnPlans() {	
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Plans);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of Plans.", 
				objPojo.getObjWrapperFunctions().click(loc_Plans));
	}
	public void clickOnSelectOptionsOnAssignUser() {		
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_AssignUser);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of assign User.", 
				objPojo.getObjWrapperFunctions().click(loc_AssignUser));
	}
	public void clickOnSelectOptionsOfFolder() {		
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Folder);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of assign User.", 
				objPojo.getObjWrapperFunctions().click(loc_Folder));
	}
	public void clickOnSelectOptionOnMasterList()
	{
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_MasterList);
		objPojo.getObjUtilities().logReporter("Click on select an options dropdown of Master List", 
				objPojo.getObjWrapperFunctions().click(loc_MasterList));
	}
	public void selectStartDate(String strYear, String strMonth, String strDate){
		objPojo.getObjWrapperFunctions().waitFor(5);
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_StartDate, strYear, strMonth, strDate);
		objPojo.getObjUtilities().logReporter("Select date as '"+strDate+"', month as '"+strMonth+"', year as '"+strYear+"' from calender.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_StartDate));		
	}	
	public void selectEndDate(String strYear, String strMonth, String strDate){
		objPojo.getObjWrapperFunctions().datePickerForSH(loc_EndDate, strYear, strMonth, strDate);
		objPojo.getObjUtilities().logReporter("Select date as '"+strDate+"', month as '"+strMonth+"', year as '"+strYear+"' from calender.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_EndDate));		
	}
	public void clickOnSelectAllCheckbox(String strValue) {
		By locator = By.xpath("//label[text()='" + strValue
				+ "']//following::div[contains(@class,'btn-group open')]//input[@type='checkbox' and @value='multiselect-all']");
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Click on Select all checkbox on " + strValue + "",
				objPojo.getObjWrapperFunctions().click(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void enterUsernameInAssignUserSearch(String strUserName) {
		By loc_search = By.xpath("//div[contains(@class,'btn-group open')]//input[@placeholder='Search']");
		objPojo.getObjWrapperFunctions().setText(loc_search, strUserName);
		objPojo.getObjUtilities().logReporter("Enter '"+strUserName+"' as Assign user name.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_search));
	}
	public void clickOnSaveButtonOnAddNewTaskPopup() {
		objPojo.getObjWrapperFunctions().waitFor(2);
		By loc_btnSave = By.xpath("(//span[text()='Add New Task Assignment']//following::button[@id='taskAssigWatchSaveBtn' and text()='Save'])[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSave);
		objPojo.getObjUtilities().logReporter("Click on Save button", 
				objPojo.getObjWrapperFunctions().actionClick(loc_btnSave));
	}
	//new task creation
	public void createNewTask()
	{
		objPojo.getObjUtilities().logReporter("Click on create new task", 
				objPojo.getObjWrapperFunctions().click(loc_iconCreateTask));
	}
	public void verifyHeaderofPopupNewTaskCreation()
	{
		objPojo.getObjUtilities().logReporter("verify header of new task", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hrdNewTask));
	}
	public void clickOnNewTaskDescription()
	{
		
		objPojo.getObjUtilities().logReporter("Click Add new task description", 
				objPojo.getObjWrapperFunctions().click(loc_Task));
	}
	public void clickOnSaveTask()
	{
		
		objPojo.getObjUtilities().logReporter("Click Add new task description", 
				objPojo.getObjWrapperFunctions().click(loc_Save));
	}
	
	public String enterTaskNameOnNewTaskCreationPopup(String strTaskName){
		strTaskNameRandom=strTaskName+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Task);
		objPojo.getObjWrapperFunctions().setText(loc_Task, strTaskNameRandom);
		objPojo.getObjUtilities().logReporter("Enter '"+strTaskNameRandom+"' as folder name",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_Task));
		return strTaskNameRandom;
	}
	public void clickAddNewTaskAssignment(){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddNewTaskAssignment);
		objPojo.getObjUtilities().logReporter("Click Add new Assignment popup header is displayed.", 
				objPojo.getObjWrapperFunctions().click(loc_hdrAddNewTaskAssignment));
	}
	public String getDateFromCalender(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMM/d/yyyy");
//		dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String strDateAndTime=dateFormat.format(date);
		return strDateAndTime;
	}
	public void clickOnRadioButton(String strRadioBtn)
	{
		By locator=By.xpath("(//input[@id='"+strRadioBtn+"'])[1]");
		objPojo.getObjUtilities().logReporter("Click on Radio Button ", 
				objPojo.getObjWrapperFunctions().click(locator));
	}
	
	//216081
		
		public void selectAccountDropdownInAddNewTaskAssignmentForAccount(String strDropdownID, String strOption) {
			By locator = By.xpath("//div[@id='taskAssignmentWatchlist']//select[@id='" + strDropdownID + "']");
			objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
			objPojo.getObjUtilities().logReporter("Verify User can select the Dropdown In Accounts tab",
					objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strOption, "Index"));
		}
		
		public void selectDropdownInAddNewTaskAssignmentForAccount(String strDropdownID, String strOption) {
			By locator = By.xpath("//div[@id='taskAssignmentWatchlist']//select[@id='" + strDropdownID + "']");
			objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
			objPojo.getObjUtilities().logReporter("Verify User can select the Dropdown In Accounts tab",
					objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strOption, "Text"));
		}
		public String getValueOfTaskDropdwonInAddNewTaskAssignmentForAccount(String strDropdownID, String strOption) {

			String strSelectedOption = "";
			By locator = By.xpath("//div[@id='taskAssignmentWatchlist']//select[@id='" + strDropdownID + "']");
			objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
			objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strOption, "Text");
			strSelectedOption = objPojo.getObjWrapperFunctions().getSelectedValueFromDropDown(locator);

			objPojo.getObjUtilities().logReporter(
					"Verify user can get Task name as " + strSelectedOption + " In Accounts ",
					!strSelectedOption.equals(""));
			return strSelectedOption;
		}
		
		public void selectValueForWFCategoryDropDownList(String strDrpDwn_Id, String strValue) {
			By locator = By.xpath("//label[text()='"+strDrpDwn_Id+"']/following::div/select[@id='taskAssigWatchWorkflowCategoryList']");
			objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
			objPojo.getObjUtilities().logReporter("User select "+strDrpDwn_Id+" dropdown with '" + strValue + "' .",
					objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
		}

		public void selectValueForWFStateDropDownList(String strDrpDwn_Id, String strValue) {
			By locator = By.xpath("//label[text()='"+strDrpDwn_Id+"']/following::div/select[@id='taskAssigWatchWorkFlowStatusList']");
			objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
			objPojo.getObjUtilities().logReporter("User select "+strDrpDwn_Id+" dropdown with '" + strValue + "' .",
					objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
		}

		public void selectTaskValueFromDropDownList(String strDrpDwn_Id, String strValue) {
			By locator = By.xpath("//label[text()='"+strDrpDwn_Id+"']//following::div/select[@id='taskAssigWatchTasksList']");
			objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
			objPojo.getObjUtilities().logReporter("User select "+strDrpDwn_Id+" dropdown with '" + strValue + "' .",
					objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
		}

}
