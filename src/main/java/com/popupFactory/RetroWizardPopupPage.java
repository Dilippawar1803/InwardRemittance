package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class RetroWizardPopupPage {

	// Global Variables
	private Pojo objPojo;

	public RetroWizardPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	// Locator
	By hrdRetroWizardPopup = By.xpath("//span[text()='Retro Wizard']");
	By loc_EffectiveDate = By.xpath(
			"(//div[@id='retroAccountDialog']//label[contains(text(),'(Retro Effective Date)')]//following::img)[1]");
	By loc_RetroEndDate = By
			.xpath("(//div[@id='retroAccountDialog']//label[contains(text(),'(Retro End Date)')]//following::img)[1]");
	By loc_BtnSearch = By.xpath("//button[@type='button'][text()='Search']");
	By loc_BtnSave = By.xpath("//button[@id='saveBtn'][text()='Save']");
	By loc_ImpactedFolders = By.xpath("//span[text()='Impacted Folders']");
	By loc_selectCategory = By.xpath("//input[@id='retro_CategoryNamesAutoCompltDDL']");

	public void verifyHeaderOfRetroWizardPopupPage() {

		objPojo.getObjUtilities().logReporter("Verify user can see header of Version Management Pop Up",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(hrdRetroWizardPopup));
	}

	public void clickOnCalenderIconOnRetroEffectiveDate() {

		objPojo.getObjUtilities().logReporter("Click on calendar icon",
				objPojo.getObjWrapperFunctions().actionClick(loc_EffectiveDate));
	}

	public void clickOnCalenderIconOnRetroEndDate() {

		objPojo.getObjUtilities().logReporter("Click on calendar icon",
				objPojo.getObjWrapperFunctions().actionClick(loc_RetroEndDate));
	}

	public void selectYearDropdown(String strValue) {

		By locator = By.xpath("(//div[@class='ui-datepicker-title']//select)[2]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("User select dropdown with '" + strValue + "' .",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
	}

	public void selectMonthDropdown(String strValue) {

		By locator = By.xpath("(//div[@class='ui-datepicker-title']//select)[1]");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("User select dropdown with '" + strValue + "' .",
				objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strValue, "Text"));
	}

	public void clickOnDate(String strValue) {
		By locator = By.xpath("//a[text()='" + strValue + "']");
		objPojo.getObjUtilities().logReporter("Click on Search button ",
				objPojo.getObjWrapperFunctions().actionClick(locator));
	}

	public void clickOnSearchButton() {
		objPojo.getObjUtilities().logReporter("Click on Search button ",
				objPojo.getObjWrapperFunctions().actionClick(loc_BtnSearch));
	}

	public void verifyImpactedFolders() {
		objPojo.getObjUtilities().logReporter("Verify Impacted Folders ",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_ImpactedFolders));
	}

	public void clickOnSaveButtonOnRetroWizard() {
		objPojo.getObjUtilities().logReporter("Click on Search button ",
				objPojo.getObjWrapperFunctions().actionClick(loc_BtnSave));
	}

	public void selectCategory(String strCategoryOption) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strCategoryOption + "' option from select category dropdown",
				objPojo.getObjWrapperFunctions().setText(loc_selectCategory, strCategoryOption));
		
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectCategory, "keydown");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strCategoryOption + "' option from select category dropdown",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectCategory, "enter"));

	
	}

	public void clickOnCloseButtonOnRetroWizardMessageBox(String strMessage) {
		By locator = By.xpath("(//p[contains(text(),'"+strMessage+"')]/following::button[@type='button' and text()='Close'])[1]");
		objPojo.getObjUtilities().logReporter("Verify user can click on close button",
				objPojo.getObjWrapperFunctions().click(locator));
	}
}
