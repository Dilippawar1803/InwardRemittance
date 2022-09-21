package com.view.kotak.fcc.product;

import com.generic.Pojo;
import com.kotak.fcc.product.InwardRemittance.IRDisposalInstructionDetails;
import com.kotak.fcc.product.InwardRemittance.IRGeneralDetails;

import ru.yandex.qatools.allure.annotations.Step;

public class InwardRemittanceView {
	private Pojo objPojo;
	private String testData = "", testData1="", testData2 ="";
	
	// Reference object of Pages
	IRDisposalInstructionDetails objIRDisposalInstructionDetails;
	IRGeneralDetails objIRGeneralDetails;
		
		// Constructor of class
		public InwardRemittanceView(Pojo pojo) {
			this.objPojo = pojo;
			objIRDisposalInstructionDetails = new IRDisposalInstructionDetails(objPojo);
			objIRGeneralDetails = new IRGeneralDetails(objPojo);
		
		}
		@Step("verify Sub Product Disposal")
		public void verifySubProductDisposal() {
			testData = objPojo.getObjUtilities().dpString("TypeOption");
			if (!testData.equals(""))
				testData1=	objIRDisposalInstructionDetails.verifySubProductDisposal(testData);
			objPojo.getObjUtilities().logReporter("Verify Disposal Value", testData.equals(testData1));
		
		}
		@Step("verify Sub Product Disposal")
		public void verifySubProductDisposal_1() {
			testData = objPojo.getObjUtilities().dpString("TypeOptionOne");
			if (!testData.equals(""))
			testData1=	objIRDisposalInstructionDetails.verifySubProductDisposal(testData);
			System.out.println(testData +"gjjjjjjjjjjjjjjj");
			System.out.println(testData1 +"mmmmmmmmmmmmm");
			objPojo.getObjUtilities().logReporter("Verify Disposal Value", testData.equals(testData1));
		
		}
		
		@Step("check Swift All Details Displayed")
		public void checkSwiftAllDetailsDisplayed() {
			testData = objPojo.getObjUtilities().dpString("PortalRefSwift");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("SenderReference");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("Amount");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("Currency");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("Customer");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("ValueDate");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("SwiftMT");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
			testData = objPojo.getObjUtilities().dpString("ReceiverReference");
			if (!testData.equals(""))
				objIRGeneralDetails.checkSwiftDetailsDisplayed(testData);
		
		}
		}
