package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class MyTasksPopUpPage {
		private Pojo objPojo;

		public MyTasksPopUpPage(Pojo pojo) {
			this.objPojo = pojo;
		}
		
		By loc_hdrMyTasks = By.xpath("//div[contains(@class,'ui-dialog-titlebar')]/span[text()='My Tasks']");
		By loc_btnCrossIcon = By.xpath("//span[text()='My Tasks']/following-sibling::a/span[text()='close']");
		
		public void verifyMyTasksPopupDisplayed() {
			objPojo.getObjUtilities().logReporter("Verify user can See My Tasks Popup Displayed",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrMyTasks));
		}
		
		public void verifyTabsOnMyTasksPopUpPage(String strTabName)
		{
			By locator = By.xpath("//ul[@id='myTaskandcurrentlockstatus']/child::li/a[text()='"+strTabName+"']");
			objPojo.getObjUtilities().logReporter("Verify user can See Tab '"+strTabName+"' on My Tasks Popup",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
		
		public void verifySubTabsUnderMyTaksOnMyTasksPopUpPage(String strSubTabName)
		{
			By locator = By.xpath("//div[@id='myTask']//ul/li/a[normalize-space(text())='"+strSubTabName+"']");
			objPojo.getObjUtilities().logReporter("Verify user can See sub tab '"+strSubTabName+"' under tab My Tasks on My Tasks Popup",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
		
		public void clickOnTabsOnMyTasksPopUpPage(String strTabName)
		{
			By locator = By.xpath("//ul[@id='myTaskandcurrentlockstatus']/child::li/a[text()='"+strTabName+"']");
			objPojo.getObjUtilities().logReporter("Verify user can click on Tab '"+strTabName+"' on My Tasks Popup",
					objPojo.getObjWrapperFunctions().click(locator));
		}
		
		public void verfiyColumnsUnderCurrentLockStatus(String strColumnName)
		{
			By locator = By.xpath("//div[@id='currentLockStatus']//div[@id='borderLayout_eRootPanel']//div[normalize-space(text())='"+strColumnName+"']");
			objPojo.getObjUtilities().logReporter("Verify user can see column '"+strColumnName+"' under Current lock Status tab on My Tasks Popup",
					objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		}
		
		public void clickOnCrossIconOnMyTasksPopUpPage()
		{
			
			objPojo.getObjUtilities().logReporter("Verify user can click on cross icon on My Tasks Popup",
					objPojo.getObjWrapperFunctions().click(loc_btnCrossIcon));
		}
		
	

}
