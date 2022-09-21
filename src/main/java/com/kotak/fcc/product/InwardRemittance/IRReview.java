package com.kotak.fcc.product.InwardRemittance;

 

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.generic.Pojo;

 
public class  IRReview {
	private Pojo objPojo;

	public IRReview(Pojo pojo) {
		this.objPojo = pojo;
	}

                @FindBy(xpath = "(//div[@class='p-col-12 ng-star-inserted']//span)[30]")

                private WebElement type;

 

                @FindBy(xpath = "(//div[@class='p-col-12 ng-star-inserted']//span)[34]")

                private WebElement purposeCode;

 

                
                public void checkTypeOptionDisplayed(){

                                try{

                                                type.isDisplayed();

                                }

                                catch (Exception e){

                                                throw  new AssertionError("Type Option not found");

                                }

                               

}

               

                public void checkPurposeCodeDisplayed(){

                                try{

                                                purposeCode.isDisplayed();

                                }

                                catch (Exception e){

                                                throw  new AssertionError("Purpose Code not found");

                                }

                }

                                public void verifyReviewSection(){

                                                checkTypeOptionDisplayed();

                                                checkPurposeCodeDisplayed();

                                               

                                }

 

               

}