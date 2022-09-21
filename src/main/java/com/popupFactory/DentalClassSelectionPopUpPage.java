package com.popupFactory;
import org.openqa.selenium.By;
import com.generic.Pojo;


public class DentalClassSelectionPopUpPage {
	// Global Variables
	private Pojo objPojo;

	public DentalClassSelectionPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrDentalClassSelection=By.xpath("//span[contains(text(),'Dental Class Selection ')]");
	By loc_plusIcon = By.xpath("//span[contains(text(),'Dental Class Selection ')]/parent::div/parent::div//span[@class='ui-icon ui-icon-plus']");
	By loc_Save = By.xpath("(//span[contains(text(),'Dental Class Selection ')]/parent::div/following-sibling::div//button[text()='Save'])[1]");
	By loc_closeIcon= By.xpath("//span[contains(text(),'Dental Class Selection ')]/parent::div/a/span");                 

	/**
	 * Scenario: 063
	 * Description: 
	 */
	public void verifyDentalClassSelectionPopUpHeaderIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify Dental Class Selection popup header is displayed.", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrDentalClassSelection));
	}
	public void clickPlusIconOnDentalClassSelectionPopUpPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_plusIcon));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public String selectCheckboxforanyBenefitservicecode(String strServicseName){
		By locator = By.xpath("//td[text()='"+strServicseName+"']/preceding-sibling::td/input[@type='checkbox']");
		objPojo.getObjUtilities().logReporter("Verify user can Select check box on on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(locator));	
		return strServicseName;
	}
	public void clickOnSaveButtonOnPopUpDentalLimitsInformationDetail(){
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_Save));	
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	public void verifySelectedDentalServiceListIsDisplayedOrNot(String strServicseName){
		By locator=By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='"+strServicseName+"']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator);
		objPojo.getObjUtilities().logReporter("Verify the selected Dental service code is displayed or not",
				"User should able to see the selected Dental service code is displayed",
				"User is able to see the selected Dental service code is displayed", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));	  
	}
	public void clickCloseIconOnDentalClassSelectionPopUpPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_closeIcon));
	}
	
	public String getBenefitCategory_1Value(String strServicseName)
	{
		String strBenefitCategory_1="";
		By locator = By.xpath("//td[text()='"+strServicseName+"']/following-sibling::td[@aria-describedby='manualGrid_BenefitCategory1']");
		strBenefitCategory_1=objPojo.getObjWrapperFunctions().getText(locator, "text");
		return strBenefitCategory_1;
	}
	
	public String getBenefitCategory_2Value(String strServicseName)
	{
		String strBenefitCategory_2="";
		By locator = By.xpath("//td[text()='"+strServicseName+"']/following-sibling::td[@aria-describedby='manualGrid_BenefitCategory2']");
		strBenefitCategory_2=objPojo.getObjWrapperFunctions().getText(locator, "text");
		return strBenefitCategory_2;
	}

}
