package com.popupFactory;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class ManageFieldsPopupPage {
	private Pojo objPojo;

	public ManageFieldsPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	//locators
	By loc_SaveIcon=By.xpath("(//span[@class='ui-icon ui-icon-newwin'])[2]");
	
	
	public void clickOnSaveIconOnManageFieldsPopupPage(){
	objPojo.getObjUtilities().logReporter("Verify user can click on save icon ",
				objPojo.getObjWrapperFunctions().clickUsingJavaScript(loc_SaveIcon));	
	}
	
	public ArrayList<String> getFieldNameListOnManageFieldsPopupPage(){
		ArrayList<String> list = new ArrayList<String>();
		int rows=objPojo.getDriver().findElements(By.xpath("//table[@id='fieldlistdialoggrid']/tbody/tr")).size();
		for(int i=1;i<rows;i++)
		{
			By locator=By.xpath("//table[@id='fieldlistdialoggrid']/tbody/tr['"+i+"'+1]/td[2]");
			String fieldName=objPojo.getObjWrapperFunctions().getText(locator, "text");
			System.out.println(fieldName);
			list.add(fieldName);		
		}
		return list;
		
	}
	
	public void verifyFieldName(String strFieldName){
		objPojo.getObjUtilities().logReporter("Verify "+strFieldName+" added successfully",
				this.getFieldNameListOnManageFieldsPopupPage().contains(strFieldName));		
	}

}