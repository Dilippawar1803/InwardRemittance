package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class ManageItemDentalClassPopUpPage {
	private Pojo objPojo;
	
	public ManageItemDentalClassPopUpPage (Pojo pojo){
		this.objPojo = pojo;
	}
	public void verifyHeaderOfPopUpForParticularColumn(String strPopUpName){
		By locator=By.xpath("//span[text()='"+strPopUpName+"']");
		objPojo.getObjUtilities().logReporter("Verify Header Of Particular pop up",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(locator));
	}
}

