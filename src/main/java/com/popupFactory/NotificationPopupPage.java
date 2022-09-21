package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class NotificationPopupPage {

	// Global Variables
	private Pojo objPojo;

	public NotificationPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	//locator
	By loc_hrdOfNotification=By.xpath("//span[@class='ui-dialog-title' and contains(text(),'Notification') or contains(text(),'notification')]");
	By loc_inputSearchBox = By.xpath("//input[@id='txtNotifcationSearchValue']");
	By btn_ViewAll = By.id("radioViewall");
	By loc_NotificationGrid= By.xpath("//table[@id='notificationstatusGrid']");
	By loc_iconCross = By.xpath("//span[contains(text(),'notification')]//parent::div/descendant::span[@class='ui-icon ui-icon-closethick']");

	public void verifyNotificationIcon(String strIcon)
	{
		By locator=By.xpath("//div[@data-original-title='"+strIcon+"']");
		objPojo.getObjUtilities().logReporter("Verify notification bell icon displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnNotificationIcon(String strIcon) {
		By locator=By.xpath("//div[@data-original-title='"+strIcon+"']");
		objPojo.getObjUtilities().logReporter("Verify notification bell icon displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjUtilities().logReporter("Verify user can click on notification bell icon",
				objPojo.getObjWrapperFunctions().click(locator));
	}
	public void verifyNotificationPopupHeader(){
		objPojo.getObjUtilities().logReporter("Verify Header of notification popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hrdOfNotification));
	}

	public void verifyNotification(String strFolderName)
	{
		By locator=By.xpath("(//td[@aria-describedby='notificationstatusGrid_Message'][contains(text(),'The Workflow State of the Folder "+strFolderName+" has been updated to Released')])[1]");
		objPojo.getObjUtilities().logReporter("Verify Notification On notification popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnSearchBoxFromNotifications(String strDesignName) {
		objPojo.getObjUtilities().logReporter("Enter '" + strDesignName + "' on notifications.",
				objPojo.getObjWrapperFunctions().setText(loc_inputSearchBox, strDesignName));
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_inputSearchBox, "Enter");
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void verifyNotificationForDesign(String strDesignName) {
		By locator=By.xpath("(//td[@aria-describedby='notificationstatusGrid_Message'][contains(text(),'"+strDesignName+"')and contains(text(),'compilation done')])[1]");
		objPojo.getObjUtilities().logReporter("Verify notification is appeared for design name '"+strDesignName+"'.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void verifyNotificationForRuleTreeGeneration(String strRuleTree) {
		By locator=By.xpath("(//td[@aria-describedby='notificationstatusGrid_Message'][contains(text(),'"+strRuleTree+"')])[1]");
		objPojo.getObjUtilities().logReporter("Verify notification is appeared for rule tree genaration.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnCrossIconFromNotifications() {
		objPojo.getObjUtilities().logReporter("Verify cross icon displayed on notification popup",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_iconCross));
		objPojo.getObjUtilities().logReporter("Click on cross icon from notification popup",
				objPojo.getObjWrapperFunctions().click(loc_iconCross));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void verifyNotificationForTaskUpdate(String strTxt,String strFolderName) {
		By locator=By.xpath("(//td[@aria-describedby='notificationstatusGrid_Message'][contains(text(),'"+strTxt+"') and contains(text(),'"+strFolderName+"')])[1]");
		objPojo.getObjUtilities().logReporter("Verify notification is appeared for task update '"+strFolderName+"'.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnViewAllFromNotifications() {
		objPojo.getObjUtilities().logReporter("Verify notification PopUp viewAll button displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_ViewAll));
		objPojo.getObjUtilities().logReporter("Click on notification PopUp viewAll button",
				objPojo.getObjWrapperFunctions().click(btn_ViewAll));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public void verifyNotificationForQHPReport(String strQueueId) {
		By locator = By
				.xpath("(//td[@aria-describedby='notificationstatusGrid_Message'][contains(text(),'QHP report')][contains(text(),'generated successfully')][contains(text(),'"
						+ strQueueId + "')])[1]");
		objPojo.getObjUtilities().logReporter("Verify notification is appeared for QHP report.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnNotificationPopUpBottomButton(String strButton) {
		By locator = By.xpath("//button[normalize-space()='"+strButton+"']");
		objPojo.getObjUtilities().logReporter("Verify notification PopUp "+strButton+" button displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjUtilities().logReporter("Click on notification PopUp "+strButton+" button",
				objPojo.getObjWrapperFunctions().click(locator));
	}
	
	public void verifyNotificationPopUpBottomButtonDisplayed(String strButton) {
		By locator = By.xpath("//button[normalize-space()='"+strButton+"']");
		objPojo.getObjUtilities().logReporter("Verify notification PopUp "+strButton+" button displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
	public void clickOnNotificationPopUpViewAllButton() {
		objPojo.getObjUtilities().logReporter("Verify notification PopUp viewAll button displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_ViewAll));
		objPojo.getObjUtilities().logReporter("Click on notification PopUp viewAll button",
				objPojo.getObjWrapperFunctions().click(btn_ViewAll));
	}
	
	public void verifyNotificationGridDisplayed() {
		objPojo.getObjUtilities().logReporter("Verify notification grid displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_NotificationGrid));
	}
}
