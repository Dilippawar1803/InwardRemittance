package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.FileFunctions;
import com.generic.Pojo;

public class DentalLimitsInformationDetailPopUpPage {
	// Global Variables
	private Pojo objPojo;
	private String strFolderNameRandom = "";
	private List<String> listReturnValue;

	public DentalLimitsInformationDetailPopUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hrdDentalLimitsInformationDetailReapeater = By.xpath("//span[contains(text(),'Dental Limits Information Detail')]");
	By loc_gridOption = By.xpath("//span[contains(text(),'Dental Limits Information Detail')]/parent::div/parent::div//following-sibling::div//span[@class='ui-icon ui-icon-plus']");
	By loc_close = By.xpath("//span[text()='Guardrails - Dental Limits Information Detail ']/ancestor::div//following-sibling::a[@role='button']/span");
	By loc_Save = By.xpath("(//button[@id='manualDataSourceSaveBtn'])[1]");
	By loc_isSelected = By.xpath("//span[contains(text(),'Dental Limits Information Detail ')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox']");
	By loc_plusIcon = By.xpath("//span[contains(text(),'Dental Limits Information Detail ')]/parent::div/parent::div//span[@class='ui-icon ui-icon-plus']");

	/**
	 * Scenario : 103 
	 * Description: Verify user is able to add Benefit Service Code in "Dental Limit Information Detail Repeater.
	 */
	public void verifyDentalLimitsInformationDetailReapeaterPopup() {
		objPojo.getObjUtilities().logReporter("verify Dental Limits Information Detail Reapeater Popup is displayed.",
				"User should see Dental Limits Information Detail Reapeater Popup is displayed.",
				" verify ia able to see Dental Limits Information Detail Reapeater Popup is displayed.",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hrdDentalLimitsInformationDetailReapeater));
	}
	public void clickOnGridOptionAddDentalLimitsInformationDetailReapeaterPopup() {
		objPojo.getObjUtilities().logReporter("Verify user can click on plus icon on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_gridOption));

	}
	public void verifyservicseAddededonDentalLimitsInformationDetailReapeaterPopup(String strServiceName) {
		By locator = By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='" + strServiceName + "']");
		objPojo.getObjUtilities().logReporter("verify Servicse is addede '" + strServiceName + "'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
	public void clickOnCloseIcon() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_close);
		objPojo.getObjUtilities().logReporter("Verify user can click on close icon of popup:",
				"User should be able to click on close icon on Dental Limits Information Detail Reapeater Popup  ",
				"User is able to click on close icon on Dental Limits Information Detail Reapeater Popup ",
				objPojo.getObjWrapperFunctions().click(loc_close));
	}
	public String selectCheckboxforanyBenefitservicecode(String strServicseName){
		By locator = By.xpath("//td[text()='"+strServicseName+"']/preceding-sibling::td/input[@type='checkbox']");
		objPojo.getObjUtilities().logReporter("Verify user can Select check box on on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(locator));	
		return strServicseName;
	}
	public void ClickOnSaveButtonOnPopUpDentalLimitsInformationDetail(){
		objPojo.getObjUtilities().logReporter("Verify user can click on save button on repeater ",
				objPojo.getObjWrapperFunctions().actionClick(loc_Save));	
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();

	}
	
	public void clickPlusIconOnDentalClassSelectionPopUpPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on create radio button on new foundation template popup page",
				objPojo.getObjWrapperFunctions().click(loc_plusIcon));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	
	public void verifyServiceCodeVisibleAsPreselectedOrNot(){
		//By locator=By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='"+strServicseName+"']");
		objPojo.getObjUtilities().logReporter("Verify the Dental service code is Preselected or not",
				"User should able to see the Dental service code is Preselected ",
				"User is able to see the Dental service code is Preselected ", 
				objPojo.getObjWrapperFunctions().isCheckBoxSelected(loc_isSelected));	
				
	}
	public void clickOnCheckboxToDeselectPreselectedServiceCodesOnDentalLimitInformationDetailRepeater(int IndexId) {
		By DeselectAll = By
				.xpath("(//span[contains(text(),'Dental Limits Information Detail')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox'])['"
						+ IndexId + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(DeselectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select check box to deselect it.",
				objPojo.getObjWrapperFunctions().click(DeselectAll));
	}
	
	public void verifyBenifitsLinkedtoLimits(String strServicseName){
		By locator=By.xpath("//div[@col-id='BenefitServiceCode']//child::span[text()='"+strServicseName+"']");
		objPojo.getObjUtilities().logReporter("Verify the Dental service code is available ",
				"User should able to see the Dental service code On Limit Information Details ",
				"User is able to see the Dental service code is Limit Information Details ", 
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));	
				
	}
	public void clickOnCheckboxToselectPreselectedServiceCodesOnDentalLimitInformationDetailRepeater(int IndexId) {
		By DeselectAll = By
		.xpath("(//span[contains(text(),'Dental Limits Information Detail')]/parent::div/following-sibling::div//following-sibling::table//input[@type='checkbox'])['"
		+ IndexId + "']");
		objPojo.getObjWrapperFunctions().checkElementDisplayed(DeselectAll);
		objPojo.getObjUtilities().logReporter("Verify user can click on select check box to deselect it.",
		objPojo.getObjWrapperFunctions().click(DeselectAll));
		}
	
public void verifyServiceRemovedfromMLDentalServiceList(String strColIdColumnName, String strAutopopulatedValue) {
		By locator = By.xpath("//div[@col-id='" + strColIdColumnName + "']//child::span[text()='" + strAutopopulatedValue + "']");
		objPojo.getObjUtilities().logReporter("Verify " + strAutopopulatedValue + " service removed from ML Dental service list",objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(locator));
	}
public void verifyTabsOnChildPopUpOfDentelLimit(String strTabs) {
    By locator = By.xpath("//span[text()='"+strTabs+"']");
    objPojo.getObjUtilities().logReporter(
            "User should able to see " + strTabs + " Tab on Child PopUp of Dental Limit  tab",
            objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
}
public void verifyTabsOnChildPopUpOfDentelLimits()

{
	
    try {
        listReturnValue = FileFunctions.readFileIntoList(System.getProperty("user.dir")
                + "/src/test/resources/testData/textFiles/120420_verifyTabsOnChildPopUpOfDentelLimits.txt");
        for (String strValue : listReturnValue) {
            System.out.println("text file testData : " + strValue);
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    for (int index = 0; index < listReturnValue.size(); index++) {
        String strTab = listReturnValue.get(index).trim();
        if (!strTab.equals("")) {
            objPojo.getObjWrapperFunctions().waitFor(1);
            this.verifyTabsOnChildPopUpOfDentelLimit(strTab);


        }}}

public void verifySelectAllCheckBoxAtChildPopup(String strCheckBox) {
    By locator = By.xpath("//div[@id='jqgh_manualGrid_IsSelect']//input[@type='checkbox']");
    objPojo.getObjUtilities().logReporter(
            "User should able to see " + strCheckBox + " SelectAll check box on Child PopUp of Dental Limit  tab",
            objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
}


/**
 * Scenario: 120420
 * Description:verify Tabs On Child PopUp Of Add Services Dentel Limit
 * Reconciliation
 */
public void verifyTabsOnChildPopUpOfAddServicesDentelLimits() {

    try {
        listReturnValue = FileFunctions.readFileIntoList(System.getProperty("user.dir")
                + "/src/test/resources/testData/textFiles/120420_verifyTabsOnChildPopUpOfAddServicesDentelLimits.txt");
        for (String strValue : listReturnValue) {
            System.out.println("text file testData : " + strValue);
        }
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    for (int index = 0; index < listReturnValue.size(); index++) {
        String strTab = listReturnValue.get(index).trim();
        if (!strTab.equals("")) {
            objPojo.getObjWrapperFunctions().waitFor(1);
            this.verifyTabsOnChildPopUpOfAddServicesDentelLimit(strTab);


        }}}



public void verifyTabsOnChildPopUpOfAddServicesDentelLimit(String strTabs) {
By locator = By.xpath("//div[text()='"+strTabs+"']");
objPojo.getObjUtilities().logReporter(
        "User should able to see " + strTabs + " Tab on PlusICon of Child popup of dental limit tab",
        objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));

}
}	

































