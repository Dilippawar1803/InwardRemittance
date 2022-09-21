package com.kotak.fcc.product.InwardRemittance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

public class IRDisposalInstructionDetails {
	
	// Global Variables
				private Pojo objPojo;
			public IRDisposalInstructionDetails(Pojo pojo) {
				this.objPojo = pojo;
			}
			By port = By.xpath("//input[@id='irPortDest']");
			By purposeCodeList = By.xpath("(//tr[@id='rowdata'])[1]");
			By searchIcon = By.xpath("//span[contains(text(),'search')]");

			By cosigneeName = By.xpath("//textarea[@id='irCosigneeName']");
			By cosigneeNameAddress = By.xpath("//textarea[@id='irCosigneeNameAdd']");
			By type = By.xpath("//mat-select[@id='remittanceDispType']");

			By underlyingInvoiceNo = By.xpath("//input[@id='irDispUnderLying']");
			By billNo = By.xpath("//input[@id='billNumber']");
			By billAmount = By.xpath("//input[@id='billAmount']");

			By buttonBill = By.xpath("//button[@id='billButton']");
			By billRealize = By.xpath("//mat-select[@id='billRealize']");
  
			public void clickOnSearchIcon() {
				objPojo.getObjUtilities().logReporter("click On Search Icon",
						objPojo.getObjWrapperFunctions().click(searchIcon));
			}   

			public void clickOnPurposeCodeList() {
				objPojo.getObjUtilities().logReporter("click On Purpose Code List",
						objPojo.getObjWrapperFunctions().click(purposeCodeList));
			} 
			
			public void setPortOfFinalDestinations(String portDestination) {
				objPojo.getObjUtilities().logReporter("set Port Of Final Destinations '" + portDestination + "' ",
						objPojo.getObjWrapperFunctions().setText(port, portDestination));
				
			}
			public void setCosigneeNameAddress(String cosigneeNameAddress) {
				objPojo.getObjUtilities().logReporter("set Cosignee Name Address" + cosigneeNameAddress + "' ",
						objPojo.getObjWrapperFunctions().setText(port, cosigneeNameAddress));
				
			}

public void fillAllDetailsDisposalInstructionDetails(String portDestination,String cosigneeNameAddress){

                clickOnSearchIcon();

                clickOnPurposeCodeList();

                setPortOfFinalDestinations(portDestination);

                setCosigneeNameAddress(cosigneeNameAddress);

}

//public void verifySubProductDisposal(String typeOption){
//
//                type.click();
//
//    WebElement locator =(WebElement) By.xpath("//span[contains(text(),'"+typeOption+" ')]");
//
//                String typeValue= locator.getText();
//
//                assert.assertEquals(typeOption, typeValue);
//
//}
//
// 
//
//public void verifyFieldValidationPurposeType(String typeOption){
//
//                type.click();
//
//    WebElement locator =(WebElement) By.xpath("//span[contains(text(),'"+typeOption+" ')]");
//
//                locator.click();
//
//                try{
//
//                                String str= port.getAttribute("aria-required");
//
//                                assert1.assertEquals(str, "true");
//
//                                }
//
//                                catch (Exception e){
//
//                                                throw  new AssertionError("Field not mandatory");
//
//                                }
//
//                ScreenshotNames.add("Verify Port Field Mandataroy");
//
//                try{
//
//                                                String str= cosigneeName.getAttribute("aria-required");
//
//                                                assert1.assertEquals(str, "true");
//
//                                                }
//
//                                                catch (Exception e){
//
//                                                                throw  new AssertionError("Field not mandatory");
//
//                                                }
//
//                ScreenshotNames.add("Verify cosigneeName Field Mandataroy");
//
//                try{
//
//                                                String str= cosigneeNameAddress.getAttribute("aria-required");
//
//                                                assert1.assertEquals(str, "false");
//
//                                                }
//
//                                                catch (Exception e){
//
//                                                                throw  new AssertionError("Field mandatory");
//
//                                                }
//
//                ScreenshotNames.add("Verify cosignee Name Address Field Mandataroy");
//
//}
//
//public void verifyUnderlyingInvoiceField(String typeOption){
//
//                type.click();
//
//    WebElement locator =(WebElement) By.xpath("//span[contains(text(),'"+typeOption+" ')]");
//
//                locator.click();
//
//                try{
//
//                                String str= underlyingInvoiceNo.getAttribute("aria-required");
//
//                                assert1.assertEquals(str, "true");
//
//                                }
//
//                                catch (Exception e){
//
//                                                throw  new AssertionError("Field not mandatory");
//
//                                }
//
//               
//
//                 ScreenshotNames.add("Verify Underlying In Voice Field Mandataroy");
//
//               
//
//}
//
// 
//
//public void verifyFieldValidationRealisatiopExportBills(String typeOption){
//
//                type.click();
//
//    WebElement locator =(WebElement) By.xpath("//span[contains(text(),'"+typeOption+" ')]");
//
//                locator.click();
//
//                buttonBill.click();
//
//                try{
//
//                                String str= billNo.getAttribute("aria-required");
//
//                                assert1.assertEquals(str, "true");
//
//                                }
//
//                                catch (Exception e){
//
//                                                throw  new AssertionError("Field not mandatory");
//
//                                }
//
//               
//
//                 ScreenshotNames.add("Verify Bill No Field Mandataroy");
//
//               
//
// 
//
//try{
//
//                String str= billAmount.getAttribute("aria-required");
//
//                assert1.assertEquals(str, "true");
//
//                }
//
//                catch (Exception e){
//
//                                throw  new AssertionError("Field not mandatory");
//
//                }
//
//try{
//
//                String str= billRealize.getAttribute("aria-required");
//
//                assert1.assertEquals(str, "true");
//
//                }
//
//                catch (Exception e){
//
//                                throw  new AssertionError("Field not mandatory");
//
//                }
//
//
// ScreenshotNames.add("Verify Bill Realize Field Mandataroy");
//
//
//}

}


