package com.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;

import ru.yandex.qatools.allure.annotations.Step;

public class Outlook {
	private Pojo objPojo;
	String testData = "";

	public Outlook(Pojo pojo) {
		this.objPojo = pojo;
	}

	By lnk_header = By.xpath("//div[@id='mectrl_headerPicture']");
	//By lnk_email = By.xpath("//a[@id='ShellMail_link']");
	By lnk_email = By.xpath("//span[text()='Outlook']");
	
	By inp_email = By.xpath("//input[@name='loginfmt']");
	By inp_pass = By.xpath("//input[@name='passwd']");
	By inp_toMail = By.xpath("//div[text()='To']/following::div//div[@role='textbox']");
	By inp_subject = By.xpath("//input[@placeholder='Add a subject']");
	By inp_content = By.xpath("//div[contains(@aria-label,'Message body')]");
	By btn_next = By.xpath("//input[@type='submit']");
	By btn_newMessage = By.xpath("//div[@role='menubar']//span[text()='New message']");
	By btn_attachment = By.xpath("//button[@name='Insert pictures inline']//preceding::button[@name='Attach'][2]");
	By btn_browseThisComputer = By.xpath("//button[@name='Browse this computer']");
	By btn_send = By.xpath("//button[@name='Send']");

	public void sendReport() {
		this.openOutlook_URL();
		this.clickOnHeaderLinkonHomePage();
		this.inputEmail();
		this.clickOnNext();
		this.inputPassword();
		this.clickOnNext();
		objPojo.getObjWrapperFunctions().waitFor(2);
		this.clickOnNext();
		objPojo.getObjWrapperFunctions().waitFor(5);
		this.clickOnEmailLink();
		objPojo.getObjWrapperFunctions().waitFor(5);
		this.switchToOutlookPage();
		objPojo.getObjWrapperFunctions().waitFor(2);
		this.clickOnNewMessage();
		objPojo.getObjWrapperFunctions().waitFor(2);
		this.inputToEmail();
		this.inputSubject();
		objPojo.getObjWrapperFunctions().waitFor(2);
		this.inputContentinMailBody();
		this.clickOnAttahment();
		objPojo.getObjWrapperFunctions().waitFor(2);
		this.clickOnBrowseThisComputerAndUploadFile();
		objPojo.getObjWrapperFunctions().waitFor(5);
		this.clickOnSendMail();
	}

	@Step("Open Outlook_URL")
	public void openOutlook_URL() {
		objPojo.getObjUtilities().logReporter("Open Outlook URL -----> ",
				objPojo.getObjWrapperFunctions().getUrl(objPojo.getObjConfig().getProperty("Outlook_URL")));
	}

	public void clickOnHeaderLinkonHomePage() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(lnk_header);
		objPojo.getObjUtilities().logReporter("click On Header Link on HomePage ",
				objPojo.getObjWrapperFunctions().click(lnk_header));
	}

	public void inputEmail() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(inp_email);
		objPojo.getObjUtilities().logReporter("Input Email Id ", objPojo.getObjWrapperFunctions().setText(inp_email,
				objPojo.getObjConfig().getProperty("Outlook_Email")));
	}

	public void inputPassword() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(inp_pass);
		objPojo.getObjUtilities().logReporter("Input Password",
				objPojo.getObjWrapperFunctions().setText(inp_pass, objPojo.getObjConfig().getProperty("Outlook_Pass")));
	}

	public void clickOnNext() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_next);
		objPojo.getObjUtilities().logReporter("click On Next Button ",
				objPojo.getObjWrapperFunctions().click(btn_next));
	}

	public void clickOnEmailLink() {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(lnk_email);
		objPojo.getObjUtilities().logReporter("click On Email Link", objPojo.getObjWrapperFunctions().click(lnk_email));
	}

	public void switchToOutlookPage() {
		objPojo.getObjWrapperFunctions().switchTabToRight();
	}

	public void clickOnNewMessage() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_newMessage);
		objPojo.getObjUtilities().logReporter("click On New Message",
				objPojo.getObjWrapperFunctions().click(btn_newMessage));
	}

	public void inputToEmail() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(inp_toMail);
		String str = objPojo.getObjConfig().getProperty("Outlook_SendUser");
		String[] arr = str.split(",");
		String str1 = "";
		for (int i = 0; i < arr.length; i++) {
			str1 = str1 + arr[i] + ";";
		}
		objPojo.getObjUtilities().logReporter("Input To Email",
				objPojo.getObjWrapperFunctions().setText(inp_toMail, str1));
	}

	public void inputSubject() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(inp_subject);
		ArrayList<String> list = this.getListofExcelFileList();
		objPojo.getObjUtilities().logReporter("Input Subject", objPojo.getObjWrapperFunctions().setText(inp_subject,
				"Test Execution Report: " + this.getTodaysDate() + "_" + this.getSuiteName(list.get(0))));
	}

	public void inputContentinMailBody() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(inp_content);
		objPojo.getObjWrapperFunctions().actionClick(inp_content);
		ArrayList<String> list = this.getListofExcelFileList();
		String str_MailBody = "Hi All," + "\n\n" + "Please find attached Reports of " + this.getSuiteName(list.get(0))
				+ "\n\n" + "Summary Report:-" + this.getSuiteName(list.get(0)) + "\n" + "PASS: " + this.getNumber(0, 2)
				+ "\n" + "FAIL: " + this.getNumber(1, 2) + "\n" + "SKIPPED: " + this.getNumber(2, 2) + "\n" + "TOTAL: "
				+ this.getNumber(3, 2)+ "\n\n" + "Start Time:-" +this.getStartTime(13, 3) + "\n" + 
				"End Time: " + this.getEndTime(13) + "\n"+"\n\n" +"Thanks & Regards,"+"\n"+"Automation Team";

		objPojo.getObjUtilities().logReporter("input Content in Mail Body",
				objPojo.getObjWrapperFunctions().setText(inp_content, str_MailBody));
	}

	public void clickOnAttahment() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_attachment);
		objPojo.getObjUtilities().logReporter("click On Attahment",
				objPojo.getObjWrapperFunctions().click(btn_attachment));
	}

	public void clickOnBrowseThisComputerAndUploadFile() {
		ArrayList<String> list = this.getListofExcelFileList();
		int total = list.size();
		objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_browseThisComputer);
		objPojo.getObjUtilities().logReporter("click On Browse This Computer",
				objPojo.getObjWrapperFunctions().actionClick(btn_browseThisComputer));
		objPojo.getObjWrapperFunctions().waitFor(2);
		String filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(0);
		String sys_path = System.getProperty("user.dir") + "\\src\\main\\resources\\externalResources\\";
		try {
			Runtime.getRuntime().exec(sys_path + "OutlookFileupload.exe" + " " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		objPojo.getObjWrapperFunctions().waitFor(10);
		if (total > 1) {
			this.clickOnAttahment();
			objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_browseThisComputer);
			objPojo.getObjUtilities().logReporter("click On Browse This Computer",
					objPojo.getObjWrapperFunctions().actionClick(btn_browseThisComputer));
			objPojo.getObjWrapperFunctions().waitFor(2);
			filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(1);
			try {
				Runtime.getRuntime().exec(sys_path + "OutlookFileupload.exe" + " " + filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			objPojo.getObjWrapperFunctions().waitFor(10);
		}

	}

	public void clickOnSendMail() {
		objPojo.getObjWrapperFunctions().checkElementDisplayed(btn_send);
		objPojo.getObjUtilities().logReporter("click On Send Mail", objPojo.getObjWrapperFunctions().click(btn_send));
	}

	public String getTodaysDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public String getDataFromSheet(String sFilePath, String strSheetName, int intColmnNum, int intRowNum) {
		ExcelUtilities objExcelUtilities = new ExcelUtilities(sFilePath);
		String str = objExcelUtilities.getTotalCellData(strSheetName, intColmnNum, intRowNum);
		objExcelUtilities = null;
		return str;
	}

	public String getSuiteName(String fileName) {
		String filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + fileName;
		return this.getDataFromSheet(filePath, "TestResult", 7, 3);
	}

	public int getNumber(int colNum, int rowNum) {
		ArrayList<String> list = this.getListofExcelFileList();
		int total = list.size();
		String filePath, doubleValue;
		int returnValue = 0;
		filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(0);
		doubleValue = this.getDataFromSheet(filePath, "TestSummary", colNum, rowNum);
		float testFloat = Float.parseFloat(doubleValue);
		returnValue = (int) testFloat;
		if (total > 1) {
			filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(1);
			doubleValue = this.getDataFromSheet(filePath, "TestSummary", colNum, rowNum);
			float testFloat1 = Float.parseFloat(doubleValue);
			returnValue = returnValue + ((int) testFloat1);
		}
		return returnValue;
	}

	public ArrayList<String> getListofExcelFileList() {

		File directory = new File(System.getProperty("user.dir") + "\\target\\custom-reports\\");
		File[] files = directory.listFiles();
		ArrayList<String> list = new ArrayList<String>();

		for (File file : files) {
			String fileName = file.toString();
			if (fileName.endsWith(".xlsx")) {
				String[] arr = fileName.split("custom-reports");
				String str1 = arr[1];
				list.add(str1.substring(1));
			}
		}
		return list;
	}

	public String getStartTime(int colNum, int rowNum) {
		ArrayList<String> list = this.getListofExcelFileList();
		String filePath, strStartTime;
		filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(0);
		strStartTime = this.getDataFromSheet(filePath, "TestResult", colNum, rowNum);
		return strStartTime;
	}
	
	public String getEndTime(int colNum) {
		int rowNum = 0;
		ArrayList<String> list = this.getListofExcelFileList();
		int total = list.size();
		String filePath, strEndTime;
		filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(0);
		rowNum= this.getLastRowCount(filePath, "TestResult");
		strEndTime = this.getDataFromSheet(filePath, "TestResult", colNum, rowNum);
		if (total > 1) {
			filePath = System.getProperty("user.dir") + "\\target\\custom-reports\\" + list.get(1);
			rowNum= this.getLastRowCount(filePath, "TestResult");
			strEndTime = this.getDataFromSheet(filePath, "TestResult", colNum, rowNum);
		}
		return strEndTime;
	}
	
	public int getLastRowCount(String sFilePath, String strSheetName) {
		ExcelUtilities objExcelUtilities = new ExcelUtilities(sFilePath);
		int num = objExcelUtilities.getTotalRowCount(strSheetName);
		objExcelUtilities = null;
		return num;
	}
	
}
