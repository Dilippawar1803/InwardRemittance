package com.kotak.fcc.product.InwardRemittance;

 

import org.openqa.selenium.By;

import com.generic.Pojo;

 

public class IRAttachment {
	
	private Pojo objPojo;
	public IRAttachment(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	By uploadIcon = By.xpath("//*[@class='pi pi-cloud-upload']");
	By browseFilePath = By.xpath("//*[@class='mat-ripple mat-button-ripple']");
	By uploadFileTitle = By.xpath("//*[@id='fileUploadTitle']");
	By chooseButton = By.xpath("//span[@class='ui-fileupload-choose ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']//*[@class='ui-button-icon-left ui-clickable pi pi-plus']");
	By uploadButton = By.xpath("//*[@type='button' and @class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']//span[@class='pi pi-upload ui-clickable ui-button-icon-left ng-star-inserted']");
	By cancelUpload = By.xpath("//*[@type='button' and @class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']//span[text()='Cancel' and @class='ui-button-text ui-clickable']");
	By updloadedFileTable = By.xpath("//div[@class='fcc-table fileUploadTable ng-star-inserted']");
	By browseButton = By.xpath("//button[@id='browseButton']");

 

	public void clickBrowseButton() {
		objPojo.getObjUtilities().logReporter("click Browse Button",
				objPojo.getObjWrapperFunctions().click(browseButton));
	}
	public void clickChooseButton() {
		objPojo.getObjUtilities().logReporter("click choose Button",
				objPojo.getObjWrapperFunctions().click(chooseButton));
	}
	public void clickUploadButton() {
		objPojo.getObjUtilities().logReporter("click Upload Button",
				objPojo.getObjWrapperFunctions().click(uploadButton));
	}          
	public void setUploadFileTitle(String title) {
		objPojo.getObjUtilities().logReporter("set Upload File Title '" + title + "' ",
				objPojo.getObjWrapperFunctions().setText(uploadFileTitle, title));
		
	}
              

                public void Attachment(String fileTitle) {

                                clickBrowseButton();

                    setUploadFileTitle(fileTitle);

                                clickChooseButton();

                                clickUploadButton();

                               

}

 

}