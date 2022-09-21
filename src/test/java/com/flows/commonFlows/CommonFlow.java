package com.flows.commonFlows;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Constants;
import com.generic.Pojo;
import com.pageFactory.LoginPage;
import ru.yandex.qatools.allure.annotations.Step;

/*
 *  Author  : Framework Developer
 *  Date	:
 *  
 *  This view will contain most of common functionalities .
 *   
 * 
 */
public class CommonFlow {

	// Global Variable
	private Pojo objPojo;
	private String strUniqueKey = "";
	private String testData = "", testData_2 = "";
	private Integer intTestData = null;
	private Integer intTestData_1 = null;
	private String strReturnVal = "";
	private String strReturnVal_1 = "", strReturnVal_2 = "", strReturnVal_3 = "", strReturnVal_4 = "";
	private int intReturnVal = 0;
	private boolean blnReturnStatus = false;
	private double dblReturnVal = 0.0;
	private List<WebElement> listReturnElement;
	private WebElement weReturnElement;
	private int intRow = 0;
	private int intColumn = 0;

	// Reference object of Pages
	private LoginPage objLoginPage;

	// Constructor of class
	public CommonFlow(Pojo objPojo) {
		this.objPojo = objPojo;
		strUniqueKey=objPojo.getObjUtilities().getRandomString(3);
		objLoginPage = new LoginPage(objPojo);
	}
	
	By loc_TradeLink = By.xpath("//span[text()='fyn Trade']");
	By loc_Iframe = By.xpath("//iframe[@id='knb2ContainerFrame']");
	By loc_Remittance = By.xpath("(//span[text()='Remittance'])[2]");
	By loc_InwardRemittance = By.xpath("(//span[text()='Inward Remittance'])[2]");
	By loc_DIInwardRemittance = By.xpath("(//span[text()='DI - Inward Remittance'])[2]");
	
			
					
	public void clickOnTradeLink() {
		objPojo.getObjUtilities().logReporter("Click 'Trade Link' ",
				objPojo.getObjWrapperFunctions().scrollToView(loc_TradeLink));
		objPojo.getObjUtilities().logReporter("Click 'Trade Link' ",
				objPojo.getObjWrapperFunctions().click(loc_TradeLink));
	}
	
	public void navigateToInwardRemittance() {
		objPojo.getObjWrapperFunctions().switchToFrameUsingIframeElement(loc_Iframe);
		objPojo.getObjUtilities().logReporter("Click Inward Remittance",
				objPojo.getObjWrapperFunctions().click(loc_Remittance));
		objPojo.getObjUtilities().logReporter("Click DI Inward Remittance",
				objPojo.getObjWrapperFunctions().click(loc_InwardRemittance));
	}
	public void navigateToDIInwardRemittance() {
		objPojo.getObjWrapperFunctions().switchToFrameUsingIframeElement(loc_Iframe);
		objPojo.getObjUtilities().logReporter("Click Inward Remittance",
				objPojo.getObjWrapperFunctions().click(loc_Remittance));
		objPojo.getObjUtilities().logReporter("Click DI Inward Remittance",
				objPojo.getObjWrapperFunctions().click(loc_DIInwardRemittance));
	}
	// This common method will take screen shot for your RMID
	// Creator : Framework Developer
	public void takeScreenShot() {

		// DO NOT ADD Extra PAUSE - as 2 sec of Pause is already given
		objPojo.getObjWrapperFunctions().takeTCIDScreenShot();

	}

	public void setResourceName(String strResourceName) {
		objPojo.getObjWrapperFunctions().setResouceName(strResourceName);
	}

	// This common method will Refresh whole page - F5
	// Creator : Framework Developer
	public void refreshWholePageF5() {

		objPojo.getObjWrapperFunctions().pageRefresh();
		objPojo.getObjWrapperFunctions().waitFor(5);
	}

	// Author: Framework Developer
	// Below method takes to Verify Print Preview with screenshot.
	@Step("Verify Print Preview with screenshot.")
	public void verifyPrintPreview() {
		Robot robot = null;
		objPojo.getObjWrapperFunctions().waitFor(5);
		this.takeScreenShot();
		objPojo.getObjWrapperFunctions().waitFor(5);
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	// Author: Framework Developer
	// Date: 11-Nov-2017
	// Description: This method verifies whether the latest file download is as
	// expected.
	// : FileNamePrefix key should contain the fixed part of the expected
	// filename
	// : e.g. filename = "Report_Active Patients 2 years_1510298460100.csv"
	// : FileNamePrefix value would be "Report_Active Patients 2 years"
	@Step("Verify file is downloaded or not")
	public void verifyFileDownLoad() {
		testData = objPojo.getObjUtilities().dpString("FileNamePrefix");
		System.out.println("testData  :->" + testData);
		strReturnVal = objPojo.getObjWrapperFunctions().getLatestDownloadedFileName();
		System.out.println("Verify File Download :->" + strReturnVal);
		if (strReturnVal != "" && !strReturnVal.isEmpty() && strReturnVal != null)
			objPojo.getObjUtilities().logReporter("Verify whether the file is downloaded or not.",
					strReturnVal.startsWith(testData));

		else
			objPojo.getObjUtilities().logReporter("File is not downloaded.", false);

	}

	// Author : Framework Developer
	// 22 Jan 2018
	// Call this method whenever you want to clear "Temp" folder during
	// execution.
	public void clearTempDirectory() {

		objPojo.getObjWrapperFunctions().deleteAllBrowserCookies();
	}

	


	/**
	 * Author : Framework Developer Date: 02-Jan-2019 Module : Excel Parameter-
	 * Description: This method used for Switch to default Iframe on Home Page
	 */
	@Step("Switch to default Iframe on Home Page")
	public void commonSwitchToDefualtIFrame() {
		objPojo.getObjWrapperFunctions().switchToDefaultContent();
	}


	@Step("Open AUT_URL")
	public void openAUT_URL(String strUrl) {
		if (!strUrl.equals(""))
			objPojo.getObjUtilities().logReporter("Open AUT URL -----> ", strUrl, objPojo.getObjWrapperFunctions().getUrl(strUrl));
	}


	@Step("Open AUT_URL")
	public void openAUT_URL() {
		String strUrl=objPojo.getObjConfig().getProperty("AUT_URL");
		Constants.baseURL=strUrl;
		objPojo.getObjUtilities().logReporter("Open AUT URL -----> "+strUrl,objPojo.getObjWrapperFunctions().getUrl(strUrl));
	}

	
	
}
