package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class AddProductPopupPage {
	private Pojo objPojo;

	public AddProductPopupPage(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_hdrAddProduct = By.xpath("(//div[text()='Add Product'])[1]");
	By loc_btnCreate = By.xpath("//input[@id='createNew'][@type='radio']");
	By loc_inpProductName = By
			.xpath("//label[contains(text(),'Product Name')]//parent::div//input[@id='txtDocumentName']");
	By loc_drpProductType = By.xpath("//select[@id='drpDocumentType']");
	By loc_btnSubmit = By.xpath("//button[@id='btnSave'][text()='Submit'][@type='submit']");
	By loc_drpSelectFolderType = By.xpath(
			"(//label[text()='Select Folder Type:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	By loc_drpCopyFrom = By.xpath("//select[@id='drpCopyFrom']");
	By loc_drpSelectFolder = By.xpath(
			"(//label[text()='Select Folder:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	By loc_drpSelectFolderVersion = By.xpath(
			"(//label[text()='Select Folder Version:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	By loc_drpSelectProduct = By.xpath(
			"(//label[text()='Select Product:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	By loc_inputSetProductName = By
			.xpath("//label[text()='Product Name:']/following::input[@type='text' and @id='txtDocumentName']");
	By loc_btnCopy = By.xpath("(//input[@id='createType'][@type='radio'])[1]");
	By loc_btnCreateDisabled = By.xpath("//input[@name='createType' and @disabled='disabled']");
	By loc_drpArrowSelectProduct = By.xpath(
			"(//label[text()='Select Product:']//following::span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[1]");
	By loc_selectProduct=By.xpath("(//label[text()='Select Product:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");

	
	//Test and Prod
	By loc_SelectFolderType = By.xpath(
			"(//label[text()='Select Folder Type:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	By loc_folderType_item = By.xpath("//small[normalize-space()='Folder Type is required.']");
	By loc_folder_item = By.xpath("//small[normalize-space()='Folder is required.']");
	By loc_folderVersion_item = By.xpath("//small[normalize-space()='Folder Version is required.']");
	By loc_folderProduct_item = By.xpath("//small[normalize-space()='Product is required.']");
	By loc_selectVersion = By.xpath(
			"(//label[text()='Select Folder Version:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	By loc_selectFolder = By.xpath(
			"(//label[text()='Select Folder:']/following::input[contains(@class,'custom-combobox-input ui-widget ui-widget')])[1]");
	
	
	public void verifyUserIsOnAddProductPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify Add Product popup page is displayed",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_hdrAddProduct));
	}

	public void clickCreateRadioButtonOnAddProductPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Create radio button on Add Product popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnCreate));
	}

	public String enterProductNameOnAddProductPopupPage(String strProductName) {
		String strProductNameRandom = "";
		strProductNameRandom = strProductName + objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjWrapperFunctions().setText(loc_inpProductName, strProductNameRandom);
		objPojo.getObjUtilities().logReporter(
				"Enter '" + strProductNameRandom + "' as product name on Add Product popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpProductName));
		return strProductNameRandom;
	}

	public String selectProductTypeDropDownOnAddProductPopupPage(String strProductType) {
		objPojo.getObjUtilities().logReporter("Verify user can select '" + strProductType + "' as product type",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpProductType, strProductType, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpProductType);
		return strProductType;
	}

	public void clickOnSubmitButtonOnAddProductPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on submit button on Add Product popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnSubmit));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	/**
	 * Scenario: 118188 Description: Verify Functionality for generating SOB
	 * Collateral
	 */

	public String selectFolderTypeOptionFromDropdown(String strSelectFolderType) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolderType, strSelectFolderType);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderType, "keydown");
		objPojo.getObjUtilities().logReporter(
				"Verify user can select folder type dropdown '" + strSelectFolderType + "' ",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderType, "enter"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strSelectFolderType;
	}

	public void selectCopyFromOptionFromDropdown(String strCopyFromTestOrProd) {
		objPojo.getObjUtilities().logReporter(
				"Verify user can select '" + strCopyFromTestOrProd + "' from copy from dropdown",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpCopyFrom, strCopyFromTestOrProd, "Text"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpCopyFrom);
	}

	public String selectFolderOptionFromDropdown(String strSelectFolder) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolder, strSelectFolder);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolder, "keydown");
		objPojo.getObjUtilities().logReporter("Verify user can select folder '" + strSelectFolder + "' ",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolder, "enter"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strSelectFolder;
	}

	public String selectFolderVersionOptionFromDropdown(String strSelectFolderVersion) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolderVersion, strSelectFolderVersion);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "keydown");
		objPojo.getObjUtilities().logReporter("Verify user can select folder version '" + strSelectFolderVersion + "' ",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "enter"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strSelectFolderVersion;
	}

	public String selectProductOptionFromDropdown(String strSelectProduct) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjWrapperFunctions().setText(loc_drpSelectProduct, strSelectProduct);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "keydown");
		objPojo.getObjUtilities().logReporter("Verify user can select product '" + strSelectProduct + "' ",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "enter"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strSelectProduct;
	}

/*	public String setProductName(String strProductName) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Verify user can set product name '" + strProductName + "'",
				objPojo.getObjWrapperFunctions().setText(loc_inputSetProductName, strProductName));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strProductName;
	}*/
	
	public String setProductName(String strProductName) {
        objPojo.getObjWrapperFunctions().waitFor(3);
        objPojo.getObjUtilities().logReporter("Verify user can set product name '" + strProductName + "'",
                objPojo.getObjWrapperFunctions().setText(loc_inputSetProductName, strProductName + objPojo.getObjWrapperFunctions().getRandomStrings(5)));
        objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
        return strProductName;
    }
	
	public String setUniqueProductNameForPortfolio() {
		String strProduct="Test_Product_"+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Verify user can set product name '" + strProduct + "'",
				objPojo.getObjWrapperFunctions().setText(loc_inputSetProductName, strProduct));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strProduct;
	}


	/**
	 * Scenario: 169870 Description: Verify that user able to create Folder/Products
	 * in quote module when Quote/.Sales toggle button is "ON" from settings module
	 */

	public void selectBundleProductSelectionCheckbox(String strBundleCheckBoxName) {
		By loc_chkBundleProdSelection = By
				.xpath("(//label[text()='" + strBundleCheckBoxName + "']/parent::div//input)[2]");
		objPojo.getObjUtilities().logReporter("Click on Bundle Product Selection checkbox",
				objPojo.getObjWrapperFunctions().click(loc_chkBundleProdSelection));
	}

	// temporary method
	public void clickCopyRadioButtonOnAddProductPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can click on Copy radio button on Add Product popup page",
				objPojo.getObjWrapperFunctions().click(loc_btnCopy));
	}

	/**
	 * Scenario:149529 Description: Verify that user able to perform Copy Network
	 * From functionality for RX Product
	 */
	public String setProductNameonFoundation(String strProductName) {
		String strFolderNameRandom = "";
		objPojo.getObjWrapperFunctions().waitFor(3);
		strFolderNameRandom = strProductName + objPojo.getObjWrapperFunctions().getRandomStrings(5);
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputSetProductName);
		objPojo.getObjWrapperFunctions().setText(loc_inputSetProductName, strFolderNameRandom);
		objPojo.getObjUtilities().logReporter("Verify user can set product name '" + strProductName + "'",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inputSetProductName));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strProductName;
	}

	public String selectFolderVersionOptionFromDropdownversion(String strSelectFolderVersion) {
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjWrapperFunctions().setText(loc_drpSelectFolderVersion, strSelectFolderVersion);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "keydown");
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "keydown");
		objPojo.getObjUtilities().logReporter("Verify user can select folder version '" + strSelectFolderVersion + "' ",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectFolderVersion, "enter"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strSelectFolderVersion;
	}

	public void verifyCreateProductOptionIsDisabledForPortfolio() {
		objPojo.getObjUtilities().logReporter("Verify create product is create product option is disabled",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCreateDisabled));
	}

	public String verifySelectProductOnAddProductPopupPage() {
		String strProductNameRandom = "";
		// strProductNameRandom =
		// strProductName+objPojo.getObjWrapperFunctions().getRandomStrings(5);
		// objPojo.getObjWrapperFunctions().setText(loc_inpProductName,
		// strProductNameRandom);
		objPojo.getObjUtilities().logReporter("List of product name on Add Product popup page",
				objPojo.getObjWrapperFunctions().actionClick(loc_drpArrowSelectProduct));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_inpProductName);

		return strProductNameRandom;
	}

	public String setProductNameForFoundation(String ProductName) {
		String strProductName;
		objPojo.getObjWrapperFunctions().waitFor(3);
		strProductName = ProductName + objPojo.getObjWrapperFunctions().getRandomNumber(3);
		objPojo.getObjWrapperFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Verify user can set product name '" + strProductName + "'",
				objPojo.getObjWrapperFunctions().setText(loc_inputSetProductName, strProductName));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strProductName;
	}

	public void verifyCreateProductOptionIsEnabledForAccount() {
		objPojo.getObjUtilities().logReporter("Verify create product option is enabled",
				objPojo.getObjWrapperFunctions().click(loc_btnCreate));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCreate);

	}
	/**
	 * Scenario: 119968
	 * Description: Verify the UI of "New Product" pop up window for Copy option
	 */
	public void verifyDropdownOptionsfromAddFolderPopupForAccountsForCopyFromField(String strdrpName) {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify user can see the dropdown value '" + strdrpName + "'  from  dropdown ",
				objPojo.getObjWrapperFunctions().verifyDropDownOptionValues(loc_drpCopyFrom, strdrpName));
	}
	public void verifyCreateRadioButtonOnAddProductPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can see create radio button on Add Product popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnCreate));
	}
	public void verifySubmittButtonOnAddProductPopupPage() {
		objPojo.getObjUtilities().logReporter("Verify user can see submitt button on Add Product popup page",
				objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_btnSubmit));
	}
	/**
	 * Scenario: 171475
	 * Description: Verify user is able to change the Grid Preference of Repeater AG grid in any product at FT module
	 */
	public void selectProductValuefromDropdownFirstValue() {
		objPojo.getObjWrapperFunctions().clearText(loc_selectProduct);
		objPojo.getObjWrapperFunctions().waitFor(4);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectProduct, "keydown");
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectProduct, "keydown");
		objPojo.getObjUtilities().logReporter("Verify user can select product from dropdown", 
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectProduct, "enter"));
		
	}

	/**
	 * Scenario: 253671
	 * Description: Verify that data copied from source
	 *  product to target product  at Portfolio module
	 */
	public void selectProductFirstOptionFromDropdown() {
		objPojo.getObjWrapperFunctions().waitFor(2);
		objPojo.getObjWrapperFunctions().clearText(loc_drpSelectProduct);
		objPojo.getObjWrapperFunctions().waitFor(1);
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "keydown");
		objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "keydown");
		objPojo.getObjUtilities().logReporter("Verify user can select product",
				objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_drpSelectProduct, "enter"));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
	}

	public String setProductNameRandonString() {
		objPojo.getObjWrapperFunctions().waitFor(3);
		String strProductName="Product_"+objPojo.getObjWrapperFunctions().getRandomStrings(4);
		objPojo.getObjUtilities().logReporter("Verify user can set product name '" + strProductName + "'",
				objPojo.getObjWrapperFunctions().setText(loc_inputSetProductName, strProductName));
		objPojo.getObjWrapperFunctions().waitForLoaderToDisappear();
		return strProductName;
	}
	
	
	

	public String selectFolderTypeDropDownOnAddProductPopupPage(String strFolderType) {
//		objPojo.getObjWrapperFunctions().waitFor(2);
    objPojo.getObjWrapperFunctions().setText(loc_SelectFolderType, strFolderType);
    objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_SelectFolderType, "keydown");
    objPojo.getObjUtilities().logReporter("Select Folder type dropdown value on AddProductPopupPage",
            "user should able to select Folder type dropdown value on AddProductPopupPage",
            "user is able to select Folder type dropdown value on AddProductPopupPage",
            objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_SelectFolderType, "enter"));

    objPojo.getObjUtilities().logReporter("Select Folder type dropdown value on AddProductPopupPage",
            "user should able to select Folder type dropdown value on AddProductPopupPage",
            "Folder Type Value is not present, update the test data ",
            objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_folderType_item));

    return strFolderType;
	}
	
	public void selectCopyFromDropDownOnAddProductPopupPage(String strCopyFrom) {
		objPojo.getObjUtilities().logReporter("Verify user can select '"+strCopyFrom+"' as Copy from",
				objPojo.getObjWrapperFunctions().selectDropDownOption(loc_drpCopyFrom, strCopyFrom, "Text"));
		objPojo.getObjWrapperFunctions().checkElementDisplayed(loc_drpCopyFrom);
	}
	
	public String selectFolderValuefromDropdown(String strSelectFolder) {
//		objPojo.getObjWrapperFunctions().waitFor(2);
    objPojo.getObjWrapperFunctions().setText(loc_selectFolder, strSelectFolder);
    objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectFolder, "keydown");
    objPojo.getObjUtilities().logReporter("Select Folder dropdown value on create product page",
            "user should able to select Folder dropdown value on create product page",
            "user is able to select Folder dropdown value on create product page",
            objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectFolder, "enter"));

    objPojo.getObjUtilities().logReporter("Select Folder dropdown value on create product page",
            "user should able to select Folder dropdown value on create product page",
            "Folder value is not present,update the test data.",
            objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_folder_item));

    return strSelectFolder;
	}
	

	public String selectFolderVersionValuefromDropdown(String strSelectFolderVersion) {
//		objPojo.getObjWrapperFunctions().waitFor(3);
    objPojo.getObjWrapperFunctions().setText(loc_selectVersion, strSelectFolderVersion);
    objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectVersion, "keydown");
    objPojo.getObjUtilities().logReporter("Select Folder version dropdown value on create product page",
            "user should able to select Folder version dropdown value on create product page",
            "user is able to select Folder version dropdown value on create product page",
            objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectVersion, "enter"));

    objPojo.getObjUtilities().logReporter("Select Folder version dropdown value on create product page",
            "user should able to select Folder version dropdown value on create product page",
            "Folder version is not available, update the test data sheet",
            objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_folderVersion_item));
    return strSelectFolderVersion;
	}
	
	public String selectProductValuefromDropdown(String strSelectProduct) {
        objPojo.getObjWrapperFunctions().waitFor(2);
        objPojo.getObjWrapperFunctions().clearText(loc_selectProduct);
        objPojo.getObjWrapperFunctions().waitFor(2);
        objPojo.getObjWrapperFunctions().setText(loc_selectProduct, strSelectProduct);
        objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectProduct, "keydown");
        objPojo.getObjUtilities().logReporter("Select Product dropdown value on create product page",
                "user should able to select Product dropdown value on create product page",
                "Product value is not present, update the test data sheet.",
                objPojo.getObjWrapperFunctions().sendKeyBoardKeys(loc_selectProduct, "enter"));

        objPojo.getObjUtilities().logReporter("Select Product dropdown value on create product page",
                "user should able to select Product dropdown value on create product page",
                "user is able to select Product dropdown value on create product page",
                objPojo.getObjWrapperFunctions().checkElementNOTDisplayed(loc_folderProduct_item));

        return strSelectProduct;
    }


}
