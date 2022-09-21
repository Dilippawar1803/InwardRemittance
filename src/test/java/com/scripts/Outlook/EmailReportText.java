package com.scripts.Outlook;
import java.lang.reflect.Method;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.flows.LoginLogoutFlow;
import com.flows.commonFlows.CommonFlow;
import com.generic.BaseTest;
import com.generic.Outlook;
import com.pageFactory.LoginPage;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

public class EmailReportText extends BaseTest {

	// Global variables
	
	private Outlook objOutlook;
	private String testCaseID="";

	// Initialize Flows
	public void initializeFlowsAndPages() {
		
		objOutlook = new Outlook(this);
	}

	
	@BeforeClass(groups = { "P1", "P2", "P3" })
	public void initializeEnvironment() {
		this.initializeWebEnvironmentWithIncognitoBrowserMode("excel/KST");
		//this.initializeWebEnvironment("excel/KST");
		this.initializeFlowsAndPages();
		/* Resource Name has to be before login */
		// objLoginLogoutView.doLogin();
	}

	@AfterClass(groups = { "P1", "P2", "P3" })
	public void tearDownEnvironment() {
		this.getObjWrapperFunctions().waitFor(7);
		this.tearDownWebEnvironment();
		objOutlook=null;
	}

	@BeforeMethod(groups = { "P1", "P2", "P3" })
	public void redirect_Me_To_HomePage_On_SH_Application(Method method) {
		testCaseID = method.getName();
		this.startTestExecutionVideoRecording(testCaseID);
		this.getObjWrapperFunctions().waitFor(5);
		System.out.println("Video Recording Started ....!!");
	}

	@AfterMethod
	public void stopVideoRecording(){
		this.stopTestExecutionVideoRecording();
		this.getObjWrapperFunctions().waitFor(5);
		System.out.println("Video Recording Stopped ....!!");
	}
	
	
	@Test()
	public void SendExcelReportEmail() {
		
		objOutlook.sendReport();
	}
	
	
}
