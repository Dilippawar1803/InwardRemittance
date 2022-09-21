package com.popupFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.generic.FileFunctions;
import com.generic.Pojo;

public class AddFieldPopupPage {
	private Pojo objPojo;
	private List<String> listReturnValue;
	
	public AddFieldPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By loc_hdrAddField=By.xpath("//span[text()='Add Field']");
	By loc_txtAreaFieldName=By.xpath("//textarea[@id='fieldname']");
	By loc_inpMDMName=By.xpath("//input[@id='mdmName']");
	By loc_btnAddOnAddFieldPopup=By.xpath("(//button[text()='Add'])[2]");
	By loc_drpdownFieldList=By.xpath("//label[contains(text(),'Select Element')]//following::select[@id='fieldlist']");
	
	public void verifyAddFieldPopupPageIsDisplayed(){
		objPojo.getObjUtilities().logReporter("Verify Add Field Pop Up is displayed",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddField));
	}
	
	public void clickOnSelectElementDropdownOnAddFieldPopUp(){
		objPojo.getObjUtilities().logReporter("Verify user can click on select element dropdown on Add Field Pop up",
		objPojo.getObjWrapperFunctions().click(loc_drpdownFieldList));
	}
	
	public void verifyDropdownValueOnAddFieldPopupPage(String strDropdownNames){
		objPojo.getObjUtilities().logReporter("Verify user can see dropdown",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpdownFieldList));
		objPojo.getObjUtilities().logReporter(
				"Verify user can see the dropdown value '" + strDropdownNames + "' from dropdown list",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpdownFieldList));
	}
	
	
	public void selectElementsFromDropdown(String strPath, String strDropdownValue) {
		By locator = By.xpath("(//label[text()='" + strPath + "']//following::select)[2]");
		objPojo.getObjWrapperFunctions().selectDropDownOption(locator, strDropdownValue, "Text");
		objPojo.getObjUtilities().logReporter("Select " + strPath + " dropdown and value as '" + strDropdownValue + "'",
		objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}
	
	
	public String setFieldNameOnAddFieldPopupPage(String strfieldName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_txtAreaFieldName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Set Field name On Add Field Popup Page",
				"user should able to Set Field name On Add Field Popup Page",
				"user is able  to Set Field name On Add Field Popup Page",
				objPojo.getObjWrapperFunctions().setText(loc_txtAreaFieldName, strfieldName+strRandomKey));
		return strfieldName+strRandomKey;
	}
	
	public String setMDMNameOnAddFieldPopupPage(String strMDMName){
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpMDMName);
		String strRandomKey=objPojo.getObjWrapperFunctions().getRandomStrings(3);
		objPojo.getObjUtilities().logReporter("Set MDM name On Add Field Popup Page",
				"user should able to Set MDM name On Add Field Popup Page",
				"user is able  to Set MDM name On Add Field Popup Page",
				objPojo.getObjWrapperFunctions().setText(loc_inpMDMName, strMDMName+strRandomKey));
		return strMDMName+strRandomKey;
	}
	
	public void clickOnAddOnAddFieldPopUp(){
		objPojo.getObjUtilities().logReporter("Verify user can click on Add button on Add Field Pop up",
		objPojo.getObjWrapperFunctions().click(loc_btnAddOnAddFieldPopup));
	}
		
	public void verifyDropdownForAddFieldPopupPage() {
		try {
			listReturnValue = FileFunctions.readFileIntoList(System.getProperty("user.dir")
					+ "/src/test/resources/testData/textFiles/TCID_170084_VerifyFunctionalityAndUIToAddMDMNameInFields.txt");
			for (String strValue : listReturnValue) {
				System.out.println("text file testData : " + strValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int index = 0; index < listReturnValue.size(); index++) {
			String strDropdownValue = listReturnValue.get(index).trim();
			if (!strDropdownValue.equals("")) {
				System.out.println(strDropdownValue);
				objPojo.getObjWrapperFunctions().waitFor(1);
				this.verifyDropdownValueOnAddFieldPopupPage(strDropdownValue);
			}
		}
	}	
}
