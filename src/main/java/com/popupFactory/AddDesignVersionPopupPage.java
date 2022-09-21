package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddDesignVersionPopupPage {
	private Pojo objPojo;

	public AddDesignVersionPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_txtVersionDate=By.xpath("(//input[@placeholder='Enter Effective Date'])[1]");
	By loc_hdrAddDesignVersionPopup=By.xpath("//span[text()='Add Design Version']");
	By loc_calendar = By.xpath("//span[text()='Select an Effective Date for new Design Version.']");
	By loc_chkCopyDesignVersion=By.xpath("//input[@id='isCreateFormDesignVersion']");
	By loc_btnSave=By.xpath("(//button[text()='Save'][@class='btn-classic'])[1]");
	
	public void verifyAddDesignVersionPopupIsDisplayed()
	{
		objPojo.getObjUtilities().logReporter("Verify Add Design Version Popup is displayed", objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddDesignVersionPopup));
	}
	
	public void enterVersionDate(){
		objPojo.getObjUtilities().logReporter("Verify user can click on text box of effective date",
				objPojo.getObjWrapperFunctions().click(loc_txtVersionDate));
	}
	
	public void clickOnCalendarIcon(){
		objPojo.getObjUtilities().logReporter("Verify user can click on calendar icon",
				objPojo.getObjWrapperFunctions().click(loc_calendar));
	}
	public String selectDateFromCalenderForParticularField(String strYear, String strMonth, String strDate) {
		objPojo.getObjWrapperFunctions().scrollToView(loc_calendar);
		objPojo.getObjWrapperFunctions().datePickerForSHWithoutClick(loc_calendar, strYear, strMonth, strDate);
		objPojo.getObjUtilities().logReporter("Select date as '" + strDate + "', month as '" + strMonth + "', year as '"
				+ strYear + "' from calender.", objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_calendar));
		return strYear;
	}
	
	public void clickOnCopyDesignVersionCheckBox(){
		objPojo.getObjUtilities().logReporter("Verify user can click on text box of effective date",
				objPojo.getObjWrapperFunctions().click(loc_chkCopyDesignVersion));
	}
	
	public void clickOnSave(){
		objPojo.getObjUtilities().logReporter("Verify user can click on save button",
				objPojo.getObjWrapperFunctions().click(loc_btnSave));
	}
}
