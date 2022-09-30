package com.Script.kotak.fcc.product;

import java.lang.reflect.Method;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flows.LoginLogoutFlow;
import com.flows.commonFlows.CommonFlow;
import com.generic.BaseTest;
import com.kotak.fcc.product.InwardRemittance.FTI;
import com.kotak.fcc.product.InwardRemittance.IR;
import com.kotak.fcc.product.InwardRemittance.IRAttachment;
import com.kotak.fcc.product.InwardRemittance.IRDisposalInstructionDetails;
import com.kotak.fcc.product.InwardRemittance.IRGeneralDetails;
import com.view.kotak.fcc.product.InwardRemittanceView;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class InwardRemittanceTest extends BaseTest {
	// Global variables
	private CommonFlow objCommonFlow;
	private LoginLogoutFlow objLoginLogoutFlow;
	private String testCaseID = "";
	private IR objIR;
	private IRGeneralDetails objIRGeneralDetails;
	private IRAttachment objIRAttachment;
	private FTI objFTI;
	private String testdata = "", testdataone = "", MasterNo;
	private IRDisposalInstructionDetails objIRDisposalInstructionDetails;
	private InwardRemittanceView objInwardRemittanceView;

	// Initialize Flows
	public void initializeFlowsAndPages() {
		objCommonFlow = new CommonFlow(this);
		objLoginLogoutFlow = new LoginLogoutFlow(this);
		objIR = new IR(this);
		objIRGeneralDetails = new IRGeneralDetails(this);
		objIRAttachment = new IRAttachment(this);
		objFTI = new FTI(this);
		objIRDisposalInstructionDetails = new IRDisposalInstructionDetails(this);
		objInwardRemittanceView = new InwardRemittanceView(this);
	}

	@BeforeClass(groups = { "P1", "P2", "P3" })
	public void initializeEnvironment() {
		this.initializeWebEnvironment("excel/InwardRemittance");
		this.initializeFlowsAndPages();
		/* Resource Name has to be before login */
		objCommonFlow.setResourceName("Divya Jhariya");
		// objLoginLogoutView.doLogin();
	}

	@AfterClass(groups = { "P1", "P2", "P3" })
	public void tearDownEnvironment() {
		this.getObjWrapperFunctions().waitFor(7);
		this.tearDownWebEnvironment();
		objCommonFlow = null;
		objLoginLogoutFlow = null;
		objIR = null;
		objIRGeneralDetails = null;
		objFTI = null;
		objIRDisposalInstructionDetails = null;
		objInwardRemittanceView = null;
	}

	@BeforeMethod(groups = { "P1", "P2", "P3" })
	public void redirect_Me_To_HomePage_On_FCC_Application(Method method) {
		testCaseID = method.getName();
		this.startTestExecutionVideoRecording(testCaseID);
		this.getObjWrapperFunctions().waitFor(5);
		System.out.println("Video Recording Started ....!!");
	}

	// @AfterMethod
	// public void stopVideoRecording(){
	// this.stopTestExecutionVideoRecording();
	// this.getObjWrapperFunctions().waitFor(5);
	// System.out.println("Video Recording Stopped ....!!");
	// }

	@Title("TCID_FCC_CG_IRM_001_MessageToBank_MenuOptions_Verification")
	@Description("VerifyMessageToBank_MenuOptions_Verification")
	@Test(priority = 1, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM001MessageToBankMenuOptionsVerification() {
		this.loadTestData("FCC_CG_IRM_001_MessageToBank_MenuOptions_Verification");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		// Theme Bridge
		objCommonFlow.openAUT_URL_ThemeBridge();
		objInwardRemittanceView.selectMessageTypeFromThemeBridge();
		objInwardRemittanceView.FileUploadFromThemeBrizge();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		// FTI
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickOnCleanPaymentProcessing();
		objFTI.clickOnStartButton();
		objFTI.clickOnMasterBrowserButton();
		objInwardRemittanceView.setOpenMasterForFTI();
		objFTI.clickOnRefreshButton();
		objFTI.clickOnMasterBrowserResult();
		objFTI.clickOnOpenButton();
		objFTI.clickOnContinueButton();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.verifyAllFeileds();
	}

	@Title("TCID_FCC_CG_IRM_0008_VerifySearchCriteriaTransactions")
	@Description("VerifySearchCriteriaTransactions")
	@Test(priority = 2, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM0008VerifySearchCriteriaTransactions() {
		this.loadTestData("FCC_CG_IRM_0008_VerifySearchCriteriaTransactions");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		// Theme Bridge
		objCommonFlow.openAUT_URL_ThemeBridge();
		objInwardRemittanceView.selectMessageTypeFromThemeBridge();
		objInwardRemittanceView.FileUploadFromThemeBrizge();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		// FTI
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickOnCleanPaymentProcessing();
		objFTI.clickOnStartButton();
		objFTI.clickOnMasterBrowserButton();
		objInwardRemittanceView.setOpenMasterForFTI();
		objFTI.clickOnRefreshButton();
		objFTI.clickOnMasterBrowserResult();
		objFTI.clickOnOpenButton();
		objFTI.clickOnContinueButton();
		objInwardRemittanceView.checkSwiftAllDetailsDisplayed();
		objInwardRemittanceView.FillAllValues();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToInwardRemittance();
		objIR.verifySearchCriteriaTransactions();
	}

	@Title("TCID_FCC_CG_IRM_0010_VerifyMenuOptionsAvailable")
	@Description("VerifyMenuOptionsAvailable")
	@Test(priority = 3, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM0010VerifyMenuOptionsAvailable() {
		this.loadTestData("FCC_CG_IRM_0010_VerifyMenuOptionsAvailable");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		// Theme Bridge
		objCommonFlow.openAUT_URL_ThemeBridge();
		objInwardRemittanceView.selectMessageTypeFromThemeBridge();
		objInwardRemittanceView.FileUploadFromThemeBrizge();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		// FTI
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickOnCleanPaymentProcessing();
		objFTI.clickOnStartButton();
		objFTI.clickOnMasterBrowserButton();
		objInwardRemittanceView.setOpenMasterForFTI();
		objFTI.clickOnRefreshButton();
		objFTI.clickOnMasterBrowserResult();
		objFTI.clickOnOpenButton();
		objFTI.clickOnContinueButton();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.checkDIInwardRemittanceDisplayed();
	}

	@Title("TCID_FCC_CG_IRM_0011_VerifyTransactionsReceivedFromNostroUtility")
	@Description("VerifyTransactionsReceivedFromNostroUtility")
	@Test(priority = 4, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM0011VerifyTransactionsReceivedFromNostroUtility() {
		this.loadTestData("FCC_CG_IRM_0011_VerifyTransactionsReceivedFromNostroUtility");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		// Theme Bridge
		objCommonFlow.openAUT_URL_ThemeBridge();
		objInwardRemittanceView.selectMessageTypeFromThemeBridge();
		objInwardRemittanceView.FileUploadFromThemeBrizge();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		// FTI
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickOnCleanPaymentProcessing();
		objFTI.clickOnStartButton();
		objFTI.clickOnMasterBrowserButton();
		objInwardRemittanceView.setOpenMasterForFTI();
		objFTI.clickOnRefreshButton();
		objFTI.clickOnMasterBrowserResult();
		objFTI.clickOnOpenButton();
		objFTI.clickOnContinueButton();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickEditTransactions();
		objIR.checkTransactionsReceivedFromNostroUtilityDisplayed();
	}

	@Title("TCID_FCC_CG_IRM_0025_verifyAuditDetailsForInwardRemittanceTransaction")
	@Description("verifyAuditDetailsForInwardRemittanceTransaction")
	@Test(priority = 5, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM0025verifyAuditDetailsForInwardRemittanceTransaction() {
		this.loadTestData("FCC_CG_IRM_0025_verifyAuditDetailsForInwardRemittanceTransaction");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		// Theme Bridge
		objCommonFlow.openAUT_URL_ThemeBridge();
		objInwardRemittanceView.selectMessageTypeFromThemeBridge();
		objInwardRemittanceView.FileUploadFromThemeBrizge();
		// Fcc
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		// FTI
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickOnCleanPaymentProcessing();
		objFTI.clickOnStartButton();
		objFTI.clickOnMasterBrowserButton();
		objInwardRemittanceView.setOpenMasterForFTI();
		objFTI.clickOnRefreshButton();
		objFTI.clickOnMasterBrowserResult();
		objFTI.clickOnOpenButton();
		objFTI.clickOnContinueButton();
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickOnDetails();
		objIR.clickOnTransctionButton();
	}

	@Title("TCID_FCC_CG_IRM_0026_verifyAuditDetailsForRemittanceCreditTransaction")
	@Description("verifyAuditDetailsForRemittanceCreditTransaction")
	@Test(priority = 6, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM0026verifyAuditDetailsForRemittanceCreditTransaction() {
		this.loadTestData("FCC_CG_IRM_0026_verifyAuditDetailsForRemittanceCreditTransaction");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickOnDetails();
		objIR.clickOnTransctionButton();
	}

	@Title("TCID_FCC_CG_IRM_0034_verifyTransactionCopyValidation")
	@Description("verifyTransactionCopyValidation")
	@Test(priority = 7, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM0034verifyTransactionCopyValidation() {
		this.loadTestData("FCC_CG_IRM_0034_verifyTransactionCopyValidation");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		String windowUrl = objIR.clickOnView();
		objIR.clickOnDownload(windowUrl);
		objCommonFlow.navigateToDIInwardRemittance();
	}

	@Title("FCC_CGIRM0023verifyInwardRemittanceSwiftDetails")
	@Description("verifyInwardRemittanceSwiftDetails")
	@Test(priority = 8, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM0023verifyInwardRemittanceSwiftDetails() {
		this.loadTestData("FCC_CGIRM0023verifyInwardRemittanceSwiftDetails");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickEditTransactions();
		objIR.clickEditIcon();
		testdata = objIRGeneralDetails.getSwiftFT();
		objInwardRemittanceView.checkSwiftAllDetailsDisplayed();

	}

	@Title("FCC_CG_IRM_0017_verifySubProductDisposalInstructions")
	@Description("verifyTransactionCopyValidation")
	@Test(priority = 9, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM0017verifySubProductDisposalInstructions() {
		this.loadTestData("FCC_CG_IRM_0017_verifySubProductDisposalInstructions");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickEditTransactions();
		objIR.clickEditIcon();
		testdata = objIRGeneralDetails.getSwiftFT();
		System.out.println(testdata + "swift ");
		testdataone = objIRGeneralDetails.getSettledAmount();
		System.out.println(testdata + "getSettledAmount");
		objIRGeneralDetails.clickNextButton();
		objInwardRemittanceView.verifySubProductDisposal();
		// objIRDisposalInstructionDetails.verifyFieldValidationPurposeType();

	}

	@Title("FCC_CG_IRM_0019_verifyFieldValidationPurposeType")
	@Description("verifyFieldValidationPurposeType")
	@Test(priority = 10, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM0019verifyFieldValidationPurposeType() {
		this.loadTestData("FCC_CG_IRM_0019_verifyFieldValidationPurposeType");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickEditTransactions();
		objIR.clickEditIcon();
		testdata = objIRGeneralDetails.getSwiftFT();
		System.out.println(testdata + "swift ");
		testdataone = objIRGeneralDetails.getSettledAmount();
		System.out.println(testdata + "getSettledAmount");
		objIRGeneralDetails.clickNextButton();
		objInwardRemittanceView.verifySubProductDisposal();
		// objIRDisposalInstructionDetails.verifyFieldValidationPurposeType();

	}

	@Title("FCC_CG_IRM_0020_verifyverifyFieldValidationRealisatiopExportBillsInwardRemittance")
	@Description("verifyverifyFieldValidationRealisatiopExportBillsInwardRemittance")
	@Test(priority = 11, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM0020verifyverifyFieldValidationRealisatiopExportBillsInwardRemittance() {
		this.loadTestData("FCC_CG_IRM_0020_verifyverifyFieldValidationRealisatiopExportBillsInwardRemittance");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickEditTransactions();
		objIR.clickEditIcon();
		testdata = objIRGeneralDetails.getSwiftFT();
		System.out.println(testdata + "swift ");
		testdataone = objIRGeneralDetails.getSettledAmount();
		System.out.println(testdata + "getSettledAmount");
		objIRGeneralDetails.clickNextButton();
		objInwardRemittanceView.verifySubProductDisposal();

	}

	@Title("FCC_CGIRM0021verifyFieldValidationPurposeTypeOtherReceiptMISCInwardRemittance")
	@Description("verifyFieldValidationPurposeTypeOtherReceiptMISCInwardRemittance")
	@Test(priority = 12, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM0021verifyFieldValidationPurposeTypeOtherReceiptMISCInwardRemittance() {
		this.loadTestData("FCC_CGIRM0021verifyFieldValidationPurposeTypeOtherReceiptMISCInwardRemittance");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToDIInwardRemittance();
		objIR.clickEditTransactions();
		objIR.clickEditIcon();
		testdata = objIRGeneralDetails.getSwiftFT();
		System.out.println(testdata + "swift ");
		testdataone = objIRGeneralDetails.getSettledAmount();
		System.out.println(testdata + "getSettledAmount");
		objIRGeneralDetails.clickNextButton();
		objInwardRemittanceView.verifySubProductDisposal();
		objIRDisposalInstructionDetails.verifyUnderlyingInvoiceField();

	}

	@Title("TCID_FCC_CG_IRM_031_verifyPullBackMenuOptionsInFTI")
	@Description("verifyPullBackMenuOptionsInFTI")
	@Test(priority = 16, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM031verifyPullBackMenuOptionsInFTI() {
		this.loadTestData("FCC_CG_IRM_031_verifyPullBackMenuOptionsInFTI");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();

		objFTI.clickNostroUtility();
		objFTI.clickOnStartButton();
		objFTI.checkPullBackDisplayed();
		objFTI.clickOnPullBack();
		objFTI.verifyBullBankOption();
	}

	@Title("TCID_FCC_CG_IRM_032_verifyPullBackEnquirySubmenuInFTI")
	@Description("verifyPullBackEnquirySubmenuInFTI")
	@Test(priority = 17, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM032verifyPullBackEnquirySubmenuInFTI() {
		this.loadTestData("FCC_CG_IRM_032_verifyPullBackEnquirySubmenuInFTI");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickNostroUtility();
		objFTI.clickOnStartButton();
		objFTI.checkPullBackDisplayed();
		objFTI.clickOnPullBack();
		objFTI.verifyBullBankOption();
		objFTI.clickOnPullBackfromFCC();
		objFTI.verifyPullBackInquiryMenuSearchCriteriaDisplayed();

	}

	@Title("TCID_FCC_CG_IRM_033_verifyFunctionalityOfPullBackFCCSubmenu")
	@Description("verifyFunctionalityOfPullBackFCCSubmenu")
	@Test(priority = 19, groups = { "InwardRemittance_Verification" })
	public void TCID_FCCCGIRM033verifyFunctionalityOfPullBackFCCSubmenu() {
		this.loadTestData("FCC_CG_IRM_033_verifyFunctionalityOfPullBackFCCSubmenu");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL_FTI();
		objLoginLogoutFlow.doLoginFTI();
		objFTI.clickOnZoneList();
		objFTI.clickOnStartButton();
		objFTI.clickNostroUtility();
		objFTI.clickOnStartButton();
		objFTI.checkPullBackDisplayed();
		objFTI.clickOnPullBack();
		objFTI.verifyBullBankOption();
		objFTI.clickOnPullBackfromFCC();
		objFTI.verifyPullBackMessageDisplayed();

	}

	@Title("FCC_CGIRM002MessageToBankEditTransactionsValidation")
	@Description("VerifyMessageToBank_EditTransactions_Validation")
	@Test(priority = 13, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM002MessageToBankEditTransactionsValidation() {
		this.loadTestData("FCC_CGIRM002MessageToBankEditTransactionsValidation");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickRequestToBankIcon();
		objIRGeneralDetails.setInstructions("abcdefg");
		objIRGeneralDetails.clickSaveButton();
		objIRGeneralDetails.clickNextButton();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickEditTransactions();
		objInwardRemittanceView.setOpenMasterForFTI();
		 objIR.clickEditIcon();
		 objIRGeneralDetails.clickNextButton();
		 objIRAttachment.Attachment("FileName");
		 objIRGeneralDetails.clickNextButton();
		 objIRGeneralDetails.clickSubmitButton();

	}

	@Title("FCC_CGIRM003MessageToBankEditTransactionsValidation")
	@Description("VerifyMessageToBankEditTransactionsValidation")
	@Test(priority = 14, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM003MessageToBankEditTransactionsValidation() {
		this.loadTestData("FCC_CGIRM003MessageToBankEditTransactionsValidation");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickRequestToBankIcon();
		objIRGeneralDetails.setInstructions("abcdefg");
		objIRGeneralDetails.clickSaveButton();
		objIRGeneralDetails.clickNextButton();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickEditTransactions();
		objInwardRemittanceView.setOpenMasterForFTI();
		 objIR.clickEditIcon();
		 objIRGeneralDetails.clickNextButton();
		 objIRAttachment.Attachment("FileName");
		 objIRGeneralDetails.clickNextButton();
		 objIRGeneralDetails.clickSubmitButton();

	}

	@Title("FCC_CGIRM004MessageToBankReviewTransactionsReturn")
	@Description("MessageToBankReviewTransactionsReturn")
	@Test(priority = 15, groups = { "InwardRemittance_Verification" })
	public void FCC_CGIRM004MessageToBankReviewTransactionsReturn() {
		this.loadTestData("FCC_CGIRM004MessageToBankReviewTransactionsReturn");
		if (!this.getObjUtilities().dpString("runmode").equals("Y")) {
			throw new SkipException("Run Mode 'No'");
		}
		objCommonFlow.openAUT_URL();
		objLoginLogoutFlow.doLoginFCC();
		objCommonFlow.clickOnTradeLink();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickRequestToBankIcon();
		objIRGeneralDetails.setInstructions("Instruction Message");
		objIRGeneralDetails.clickSaveButton();
		objIRGeneralDetails.clickNextButton();
		objCommonFlow.navigateToInwardRemittance();
		objIR.clickEditTransactions();
		objInwardRemittanceView.setOpenMasterForFTI();
		 objIR.clickEditIcon();
		 objIRGeneralDetails.clickNextButton();
		 objIRAttachment.Attachment("FileName");
		 objIRGeneralDetails.clickNextButton();
		 objIRGeneralDetails.clickSubmitButton();

	}

}
