package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class CopyQuoteOnQuoteModulePopupPage {
	private Pojo objPojo;

	public CopyQuoteOnQuoteModulePopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_drpSelectAccount = By.xpath("//input[@id='accountNamesAutoCompltDDL']");

	public void verifyHeaderOfPopUp(String strHeader){
		By locator=By.xpath("//span[text()='"+ strHeader+"']");
		objPojo.getObjUtilities().logReporter("Verify user can see header '"+strHeader+"'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}
	
	public void verifySelectAccountDropdownOption(String strSelectedAccountName) {
		By locator = By.xpath("//li[@class='ui-menu-item']/a[text()='" + strSelectedAccountName + "']");
		objPojo.getObjUtilities().logReporter("Verify Select Account Drop Down List is present",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpSelectAccount));

		objPojo.getObjWrapperFunctions().setText(loc_drpSelectAccount, " ");
		objPojo.getObjWrapperFunctions().setText(loc_drpSelectAccount, strSelectedAccountName);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectAccount, "keydown");
		objPojo.getObjUtilities().logReporter(
				"Verify '" + strSelectedAccountName + "' option is present in Select Account Drop Down List",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

	}
	
	public void verifyWorkflowCategoryIsRetainedAsPerSelectedQuoteAndItIsNonEditable(String strWorflowCategory)
	{
		By locator = By.xpath("//select[@id='categoryDDL1' and @disabled]/option[text()='"+strWorflowCategory+"']");
		objPojo.getObjUtilities().logReporter(
				"Verify workflow category is retainable as per selected quote and it is non editable",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	
}
