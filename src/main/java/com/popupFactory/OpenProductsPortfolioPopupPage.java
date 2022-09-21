package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class OpenProductsPortfolioPopupPage {

	private Pojo objPojo;

	public OpenProductsPortfolioPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_chkSelectAll = By.xpath("//input[@type='checkbox' and @id='selectallcheckbox']");
	By loc_btnOpen = By.xpath("//button[text()='Open']");
	By loc_drpProductView = By.xpath("//select[@id='documentviewdropdown_0']");
	By loc_drpProductView2 = By.xpath("//select[@id='documentviewdropdown_1']");
	
	/**
	 * Description: Verify user is able to open product
	 */
	public void clickSelectAllCheckboxOnOpenProductsPortfolioPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Select all checkbox on open Portfolio popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_chkSelectAll));
		objPojo.getObjWrapperFunctions().waitFor(2);
	}
	public void clickOpenButtonOnOpenProductsPortfolioPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Open button on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_btnOpen));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	public void clickOnProductsViewDropdown()
	{
		objPojo.getObjUtilities().logReporter("Verify user can click on product view dropdown on open products portfolio popup page",
				objPojo.getObjWrapperFunctions().click(loc_drpProductView));
	}
	
	 /**
		 * Scenario: 118230
		 * Description: 
		 */
		
		public void clickOnProductsViewForSecondProductDropdown()
		{
			//By locator = By.xpath("//select[@id='documentviewdropdown_0' and @disabled]");
			if(objPojo.getDriver().findElement(loc_drpProductView).isEnabled()){
			objPojo.getObjUtilities().logReporter("Verify user can click on product view dropdown on open products portfolio popup page for second product",
					objPojo.getObjWrapperFunctions().click(loc_drpProductView));
			}
			else{
				objPojo.getObjUtilities().logReporter("Verify user can click on product view dropdown on open products portfolio popup page for second product",
						objPojo.getObjWrapperFunctions().click(loc_drpProductView2));
			}
		}
		
		/**
		 * Scenario: 149502 
		 * Description: Verify Validate menu option at folder level
		 */
		public void clickOnOpenProductViewDropdownToSelectValue(String strProductName){
			By locator=By.xpath("//span[text()='"+strProductName+"']/ancestor::div[2]/descendant::select");
			objPojo.getObjUtilities().logReporter("Verify user can click on product view dropdown on open products portfolio popup page",
					objPojo.getObjWrapperFunctions().click(locator));
		}
		
		public void clickOnOpenProductViewDropdown(){
			By locator=By.xpath("//div[text()='Product Name']/following::div[@class='ag-body-container']/descendant::select");
			List<WebElement> list=objPojo.getObjWrapperFunctions().getWebElementList(locator);
			for(int intIndex=1;intIndex<=list.size();intIndex++){
				By loc_Product=By.xpath("//div[text()='Product Name']/following::div[@class='ag-body-container']/descendant::select["+intIndex+"]");
			objPojo.getObjUtilities().logReporter("Verify user can click on product view dropdown on open products portfolio popup page",
					objPojo.getObjWrapperFunctions().click(loc_Product));
			}
		}

	/**
	 * Scenario: 149546 
	 * Description:Verify Target Folder version number after
	 * performing copy network for Rx product
	 */
	public void selectProductInPopUp(String strProductName) {
		By locator = By.xpath("//span[text()='" + strProductName + "']//parent::div//parent::div//child::input");
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Click on product",
				objPojo.getObjWrapperFunctions().actionClick(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	/**
	 * Scenario: 149502 
	 * Description: Verify Validate menu option at folder level
	 */
	public String getAllProductName(String strProductType) {
		String strDrpdnValue = "";
		String strProductNameText = "";
		By loc_Viewdrpdn = By.xpath("//select[contains(@id,'documentviewdropdown')]");
		List<WebElement> list = objPojo.getObjWrapperFunctions().getWebElementList(loc_Viewdrpdn);
		for (int intIndex = 1; intIndex <= list.size(); intIndex++) {
			By loc_ViewdrpdnIndex = By.xpath("(//select[contains(@id,'documentviewdropdown')])[" + intIndex + "]");
			strDrpdnValue = objPojo.getObjWrapperFunctions().getSelectedValueFromDropDown(loc_ViewdrpdnIndex);
			By locGetText = By.xpath("(//select[contains(@id,'documentviewdropdown')])[" + intIndex
					+ "]/ancestor::div[2]/descendant::div[@col-id='FormName']/child::span[text()]");
			System.out.println("Drpdn selected value :" + strDrpdnValue);
			if (strDrpdnValue.contains(strProductType)) {
				strProductNameText = objPojo.getObjWrapperFunctions().getText(locGetText, "Text");
			}
		}
		return strProductNameText;

	}

}
