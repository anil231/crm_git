package com.crm.services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.crm.config.BaseConfiguration;
import com.crm.objectrepo.Crmor;
import com.crm.testdata.CsvFileData;
import com.crm.utils.CommonUtils;

public class Crmservice extends BaseConfiguration {

	private static Logger log = Logger.getLogger(Crmservice.class.getName());
	Crmor crmobjects = new Crmor();
	Screen sc = new Screen();
	CsvFileData cdata = new CsvFileData();

	public Crmservice openCrmApplication() {
		invokebrowser();
		return this;
	}

	public Crmservice loginCrmApplication(String username, String password) throws InterruptedException {
		CommonUtils.insertText("id", wd, crmobjects.getObjects().getProperty("crm_login_username"), username);
		CommonUtils.insertText("id", wd, crmobjects.getObjects().getProperty("crm_login_password"), password);
		CommonUtils.clickButton("id", crmobjects.getObjects().getProperty("crm_login_button"), wd);
		Thread.sleep(2000);
		log.info("user logged in successfully");
		return this;
	}

	public boolean checkHomePageHeader() {
		return CommonUtils.isElementPresent("css", crmobjects.getObjects().getProperty("homepageheader"), wd);
	}

	public String getLoginUserAccount() throws InterruptedException {
		Thread.sleep(3000);
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_user_menu"), wd);
		String uname = CommonUtils.getText("css", crmobjects.getObjects().getProperty("login_user_account"), wd);
		System.out.println(uname);
		return uname;
	}

	public Crmservice clickDashboardAccount() throws InterruptedException {
		CommonUtils.wait(2);
		CommonUtils.clickLink("xpath", crmobjects.getObjects().getProperty("login_dashboard_accounts"), wd);
		return this;
	}

	public Crmservice clickCreateAccountButton() {
		CommonUtils.clickButton("xpath", crmobjects.getObjects().getProperty("login_dashboard_accounts_createaccount"),
				wd);
		return this;
	}

	public Crmservice enterAccountName(String name) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_name"),
				name);
		return this;
	}

	public Crmservice enterAccountEmail(String email) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_email"),
				email);
		return this;
	}

	public Crmservice enterAccountPhoneNumber(String phone) {
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_accounts_createaccount_phonedd"), "Mobile", "value");
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_phonetb"),
				phone);
		return this;
	}

	public Crmservice enterAccountWebsite(String website) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_website"),
				website);
		return this;
	}

	public Crmservice enterAccountDetails1() {
		CommonUtils.insertText("xpath", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_name"),
				"Test User1");
		CommonUtils.insertText("xpath", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_email"),
				"Testuser@abc.com");
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_accounts_createaccount_phonedd"), "Mobile", "value");
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_phonetb"),
				"9876543210");
		CommonUtils.insertText("xpath", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_website"),
				"www.espocrm.com");
		return this;
	}

	public Crmservice enterBillingAddress(String street, String city, String state, String pincode, String country) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_street"),
				street);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_city"),
				city);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_state"),
				state);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_pincode"),
				pincode);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_country"),
				country);
		return this;
	}

	public Crmservice enterShippingAddress(String street, String city, String state, String pincode, String country) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_sstreet"),
				street);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_scity"),
				city);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_sstate"),
				state);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_spincode"),
				pincode);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_scountry"),
				country);
		copyBillingAddress = false;
		return this;
	}

	Boolean copyBillingAddress = false;

	public Crmservice clickCopyBillingButton() {
		CommonUtils.clickButton("xpath",
				crmobjects.getObjects().getProperty("login_accounts_createaccount_copybilling"), wd);
		copyBillingAddress = true;
		return this;
	}

	public Boolean isBillingAddressCopied() {
		return copyBillingAddress;
	}

	public Crmservice clickSaveButton() throws InterruptedException {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_accounts_createaccount_save"), wd);
		CommonUtils.wait(2);
		log.info("account created successfully");
		return this;
	}

	// public Crmservice clickNameLink(String username) throws
	// InterruptedException{
	// Thread.sleep(1000);
	// CommonUtils.clickLink("xpath",
	// crmobjects.getObjects().getProperty("crm_accounts_existingaccount_firstusername"),
	// wd);
	// String uname = getFirstUserName();
	// if(username.equals(uname)){
	// CommonUtils.clickButton("xpath",
	// crmobjects.getObjects().getProperty("crm_accounts_existingaccount_firstusername"),
	// wd);
	// }
	// else{
	// System.out.println("Invalid Username");
	// }
	// return this;
	// }

	public String getCreatedAccountUserName() throws InterruptedException {
		Thread.sleep(1000);
		String txt = CommonUtils.getText("css", crmobjects.getObjects().getProperty("get_account_username"), wd);
		System.out.println(txt);
		return txt;
	}

	public String getCreatedAccontMobileNumber() {
		String mobilenumber = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_phone"),
				wd);
		System.out.println(mobilenumber);
		return mobilenumber;
	}

	public String getCreatedAccountEmail() {
		String email = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_email"), wd);
		System.out.println(email);
		return email;
	}

	public String getCreatedAccountWebsite() {
		String website = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_website"),
				wd);
		System.out.println(website);
		return website;
	}

	public ArrayList<String> getCreatedAccountBillingAddress() {

		ArrayList<String> billadd = new ArrayList<String>();
		String address = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_billingaddress"), wd);
		String[] baddress = address.split(" ");
		String[] a11 = baddress[0].split("\n");
		String street = a11[0];
		String city = a11[1];
		String state = baddress[1];
		String[] a12 = baddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		billadd.add(street);
		billadd.add(city);
		billadd.add(state);
		billadd.add(postal);
		billadd.add(country);
		System.out.println(billadd);

		// for(String badd : baddress){
		// System.out.println(badd);
		// }
		// System.out.println(baddress[0]);
		// System.out.println(baddress[0]);
		// System.out.println(baddress[1]);
		// System.out.println(baddress[2]);
		return billadd;
		// String data = "Mehdipatnam-Hyderabad-Telangana-500006-India";
		// return data.split(new String[] {"-"}), StringSplitOptions.None);
	}

	public ArrayList<String> getCreatedAccountShippingAddress() {
		String shippingaddress = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_shippingaddress"), wd);
		ArrayList<String> shipadd = new ArrayList<String>();
		String[] saddress = shippingaddress.split(" ");
		String[] sa1 = saddress[0].split("\n");
		String street = sa1[0];
		String city = sa1[1];
		String state = saddress[1];
		String[] sa2 = saddress[2].split("\n");
		String postal = sa2[0];
		String country = sa2[1];
		shipadd.add(street);
		shipadd.add(city);
		shipadd.add(state);
		shipadd.add(postal);
		shipadd.add(country);
		System.out.println(shipadd);
		// System.out.println(saddress[0]);
		// System.out.println(saddress[1]);
		// System.out.println(saddress[2]);
		// System.out.println(shippingaddress);
		return shipadd;

		// method-2
		// System.out.println(saddress.length);
		// for(int i = 0; i<saddress.length; i++){
		// Scanner scanner = new Scanner(saddress[i]);
		// while (scanner.hasNextLine()){
		// String line = scanner.nextLine();
		// shipadd.add(line);
		// }
		//
		// }

	}

	public ArrayList<String> getCreatedAccountBillingAddress1() {

		ArrayList<String> billadd = new ArrayList<String>();
		String address = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_billingaddress"), wd);
		String[] baddress = address.split(" ");
		String[] a11 = baddress[0].split("\n");
		String street = a11[0];
		String city = a11[1];
		String state = baddress[1];
		String[] a12 = baddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		billadd.add(street);
		billadd.add(city);
		billadd.add(state);
		billadd.add(postal);
		billadd.add(country);
		System.out.println(billadd);
		return billadd;
	}

	public ArrayList<String> getCreatedAccountShippingAddress1() {
		String shippingaddress = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_shippingaddress"), wd);
		ArrayList<String> shipadd = new ArrayList<String>();
		String[] saddress = shippingaddress.split(" ");
		String[] sa1 = saddress[0].split("\n");
		String street = sa1[0];
		String city = sa1[1];
		String state = saddress[1];
		String[] sa2 = saddress[2].split("\n");
		String postal = sa2[0];
		String country = sa2[1];
		shipadd.add(street);
		shipadd.add(city);
		shipadd.add(state);
		shipadd.add(postal);
		shipadd.add(country);
		System.out.println(shipadd);
		return shipadd;
	}

	public String getFirstUserName() {
		String uname = CommonUtils.getText("xpath",
				crmobjects.getObjects().getProperty("crm_accounts_existingaccount_firstusername"), wd);
		return uname;
	}

	public Crmservice clickEditButton() {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("crm_accounts_click_editbutton"), wd);
		return this;
	}

	public Crmservice clickExistingName() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_accounts_existingaccount_clickname"),
				wd);
		return this;
	}

	public Crmservice removeAccountdd() {
		CommonUtils.clickButton("xpath", crmobjects.getObjects().getProperty("crm_account_remove"), wd);
		return this;
	}

	public Crmservice editAccountDetails() {
		CommonUtils.clickButton("xpath", crmobjects.getObjects().getProperty("login_accounts_edit"), wd);
		return this;
	}

	public Crmservice clickSaveNewAccountOnExistingAccount() {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_accounts_existingaccount_save"), wd);
		return this;
	}

	public Crmservice editDropdown() {
		CommonUtils.clickButton("xpath",
				crmobjects.getObjects().getProperty("html/body/div/div/div[2]/div/div/div/button[2]/span"), wd);
		return this;
	}

	public Crmservice pageRefresh() {
		CommonUtils.pageRefresh(wd);
		return this;
	}

	public Crmservice clearAndReEnterTheUserDetails() throws InterruptedException {

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_name"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_name"),
				"Test User1");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_email"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_email"),
				"Testuser@abc.com");

		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_accounts_createaccount_phonedd"), "Mobile", "value");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_phonetb"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_phonetb"),
				"9876543210");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_website"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_website"),
				"www.espocrm.com");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_street"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_street"),
				"Mehidipatnam");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_city"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_city"),
				"Hyderabad");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_state"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_state"),
				"Telangana");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_pincode"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_pincode"),
				"500006");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_country"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_country"),
				"India");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_sstreet"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_sstreet"),
				"Tallagadda");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_scity"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_scity"),
				"Hyd");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_sstate"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_sstate"),
				"Ap");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_spincode"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_spincode"),
				"500028");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_scountry"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_accounts_createaccount_scountry"),
				"US");
		return this;
	}

	public String getEditedAccountUserName() throws InterruptedException {
		Thread.sleep(1000);
		String txt = CommonUtils.getText("css", crmobjects.getObjects().getProperty("get_account_username"), wd);
		System.out.println(txt);
		return txt;
	}

	public String getEditedAccontMobileNumber() {
		String mobilenumber = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_phone"),
				wd);
		System.out.println(mobilenumber);
		return mobilenumber;
	}

	public String getEditedAccountEmail() {
		String email = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_email"), wd);
		System.out.println(email);
		return email;
	}

	public String getEditedAccountWebsite() {
		String website = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_website"),
				wd);
		System.out.println(website);
		return website;
	}

	public ArrayList<String> getEditedAccountBillingAddress1() {

		ArrayList<String> billadd = new ArrayList<String>();
		String address = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_billingaddress"), wd);
		String[] baddress = address.split(" ");
		String[] a11 = baddress[0].split("\n");
		String street = a11[0];
		String city = a11[1];
		String state = baddress[1];
		String[] a12 = baddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		billadd.add(street);
		billadd.add(city);
		billadd.add(state);
		billadd.add(postal);
		billadd.add(country);
		System.out.println(billadd);
		return billadd;
	}

	public ArrayList<String> getEditedAccountShippingAddress1() {
		String shippingaddress = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_shippingaddress"), wd);
		ArrayList<String> shipadd = new ArrayList<String>();
		String[] saddress = shippingaddress.split(" ");
		String[] sa1 = saddress[0].split("\n");
		String street = sa1[0];
		String city = sa1[1];
		String state = saddress[1];
		String[] sa2 = saddress[2].split("\n");
		String postal = sa2[0];
		String country = sa2[1];
		shipadd.add(street);
		shipadd.add(city);
		shipadd.add(state);
		shipadd.add(postal);
		shipadd.add(country);
		System.out.println(shipadd);
		return shipadd;
	}

	public Crmservice removeAllAccounts() throws InterruptedException {
		Thread.sleep(1000);
		CommonUtils.clickRadioButton("css", wd, "crm_accounts_existingaccountselectcheckbox");
		return this;
	}

	public String getXmlCreatedAccountUserName() throws InterruptedException {
		Thread.sleep(1000);
		String txt = CommonUtils.getText("css", crmobjects.getObjects().getProperty("get_account_username"), wd);
		System.out.println(txt);
		return txt;
	}

	public String getXmlCreatedAccontMobileNumber() {
		String mobilenumber = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_phone"),
				wd);
		System.out.println(mobilenumber);
		return mobilenumber;
	}

	public String getXmlCreatedAccountEmail() {
		String email = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_email"), wd);
		System.out.println(email);
		return email;
	}

	public String getXmlCreatedAccountWebsite() {
		String website = CommonUtils.getText("css", crmobjects.getObjects().getProperty("accounts_created_website"),
				wd);
		System.out.println(website);
		return website;
	}

	public ArrayList<String> getXmlCreatedAccountBillingAddress() {

		ArrayList<String> billadd = new ArrayList<String>();
		String address = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_billingaddress"), wd);
		String[] baddress = address.split(" ");
		String[] a11 = baddress[0].split("\n");
		String street = a11[0];
		String city = a11[1];
		String state = baddress[1];
		String[] a12 = baddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		billadd.add(street);
		billadd.add(city);
		billadd.add(state);
		billadd.add(postal);
		billadd.add(country);
		System.out.println(billadd);
		return billadd;
	}

	public ArrayList<String> getXmlCreatedAccountShippingAddress() {
		String shippingaddress = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_shippingaddress"), wd);
		ArrayList<String> shipadd = new ArrayList<String>();
		String[] saddress = shippingaddress.split(" ");
		String[] sa1 = saddress[0].split("\n");
		String street = sa1[0];
		String city = sa1[1];
		String state = saddress[1];
		String[] sa2 = saddress[2].split("\n");
		String postal = sa2[0];
		String country = sa2[1];
		shipadd.add(street);
		shipadd.add(city);
		shipadd.add(state);
		shipadd.add(postal);
		shipadd.add(country);
		System.out.println(shipadd);
		return shipadd;

	}

	public ArrayList<String> getCreatedXmlAccountBillingAddress1() {

		ArrayList<String> billadd = new ArrayList<String>();
		String address = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_billingaddress"), wd);
		String[] baddress = address.split(" ");
		String[] a11 = baddress[0].split("\n");
		String street = a11[0];
		String city = a11[1];
		String state = baddress[1];
		String[] a12 = baddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		billadd.add(street);
		billadd.add(city);
		billadd.add(state);
		billadd.add(postal);
		billadd.add(country);
		System.out.println(billadd);
		return billadd;
	}

	public ArrayList<String> getCreatedXmlAccountShippingAddress1() {
		String shippingaddress = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("accounts_created_shippingaddress"), wd);
		ArrayList<String> shipadd = new ArrayList<String>();
		String[] saddress = shippingaddress.split(" ");
		String[] sa1 = saddress[0].split("\n");
		String street = sa1[0];
		String city = sa1[1];
		String state = saddress[1];
		String[] sa2 = saddress[2].split("\n");
		String postal = sa2[0];
		String country = sa2[1];
		shipadd.add(street);
		shipadd.add(city);
		shipadd.add(state);
		shipadd.add(postal);
		shipadd.add(country);
		System.out.println(shipadd);
		return shipadd;
	}

	// CREATING CONTACT

	public Crmservice clickOnDashboardContacts() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_dashboard_contacts"), wd);
		return this;
	}

	public Crmservice clickOnCreateContact() {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_dashboard_contacts_createcontact"),
				wd);
		return this;
	}

	public Crmservice enterContactDetails(String firstname, String lastname, String email, String phonenumber) {
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_name"), "Mr.", "value");
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_firstname"),
				firstname);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_lastname"),
				lastname);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_email"),
				email);
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_phonedd"), "Mobile", "value");
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_phonetab"),
				phonenumber);
		return this;
	}

	public Crmservice enterContactAddressDetails(String street, String city, String state, String postalcode,
			String country, String description) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_street"),
				street);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_city"),
				city);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_state"),
				state);
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_postalcode"), postalcode);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_country"),
				country);
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_description"), description);
		return this;
	}

	public Crmservice clickSaveButtonAfterEnteringContactDetails() throws InterruptedException {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_accounts_createcontact_save"), wd);
		return this;
	}

	// VALIDATING CREATE CONTACTS

	// public Crmservice getCreatedContactName(){
	// String contactname = CommonUtils.getText("css",
	// crmobjects.getObjects().getProperty("getcontact_name"), wd);
	// System.out.println(contactname);
	// return this;
	// }

	public ArrayList<String> getCreatedContactNameList() {
		String contactnamelist = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_name"), wd);
		ArrayList<String> contactname = new ArrayList<String>();
		String[] cname = contactnamelist.split(" ");
		// String sname = cname[0];
		String firstname = cname[0];
		String lastname = cname[1];
		// contactname.add(sname);
		contactname.add(firstname);
		contactname.add(lastname);
		System.out.println(contactname);
		return contactname;
	}

	public String getCreatedContactEmail() {
		String contactemail = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_email"), wd);
		System.out.println(contactemail);
		return contactemail;
	}

	public String getCreatedContactPhone() {
		String contactphone = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_phone"), wd);
		System.out.println(contactphone);
		return contactphone;
	}

	// public Crmservice getCreatedContactAddress(){
	// String contactaddress = CommonUtils.getText("css",
	// crmobjects.getObjects().getProperty("getcontact_address"), wd);
	// System.out.println(contactaddress);
	// return this;
	// }

	public ArrayList<String> getCreatedContactAddressforcsv() {

		ArrayList<String> contaddress = new ArrayList<String>();
		String caddress = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_address"), wd);
		String[] contactaddress = caddress.split(" ");
		String[] a11 = contactaddress[0].split("\n");
		String street = a11[0];

		String c1 = a11[1];
		String[] c2 = c1.split(",");
		String city = c2[0];

		String state = contactaddress[1];
		String[] a12 = contactaddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		contaddress.add(street);

		System.out.println("This is new city : " + city);
		contaddress.add(city);
		contaddress.add(state);
		contaddress.add(postal);
		contaddress.add(country);
		System.out.println(contaddress);
		return contaddress;
	}

	public ArrayList<String> getCreatedContactAddress() {

		ArrayList<String> contaddress = new ArrayList<String>();
		String caddress = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_address"), wd);
		String[] contactaddress = caddress.split(" ");
		String[] a11 = contactaddress[0].split("\n");
		String street = a11[0];

		String c1 = a11[1];
		String[] c2 = c1.split(",");
		String city = c2[0];

		String state = contactaddress[1];
		String[] a12 = contactaddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		contaddress.add(street);

		System.out.println("This is new city : " + city);
		contaddress.add(city);

		contaddress.add(state);
		contaddress.add(country);
		contaddress.add(postal);
		System.out.println(contaddress);
		return contaddress;
	}

	public String getCreatedContactDescription() {
		String contactdescription = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcontact_description"), wd);
		System.out.println(contactdescription);
		return contactdescription;
	}

	// EDITING CONTACT DETAILS

	public Crmservice clearAndReEnterTheContactDetails(String firstname, String lastname, String email, String phone)
			throws InterruptedException {

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_firstname"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_firstname"),
				firstname);

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_lastname"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_lastname"),
				lastname);

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_email"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_email"),
				email);

		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_phonedd"), "Mobile", "value");

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_phonetab"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_phonetab"),
				phone);
		return this;

	}

	public Crmservice clearAndReEnterContactAddress(String street, String city, String state, String postalcode,
			String country, String description) {

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_street"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_street"),
				street);

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_city"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_city"),
				city);

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_state"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_state"),
				state);

		CommonUtils.clearText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_postalcode"));
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_postalcode"), postalcode);

		CommonUtils.clearText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_country"));
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_country"),
				country);

		CommonUtils.clearText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_description"));
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_description"), description);

		return this;
	}

	// VALIDATING EDITING CONTACT DETAILS

	public ArrayList<String> getEditedContactNameList() {
		String contactnamelist = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_name"), wd);
		ArrayList<String> contactname = new ArrayList<String>();
		String[] cname = contactnamelist.split(" ");
		String name = cname[0];
		String firstname = cname[1];
		String lastname = cname[2];
		contactname.add(name);
		contactname.add(firstname);
		contactname.add(lastname);
		System.out.println(contactname);
		return contactname;
	}

	public String getCreatedRContactEmail() {
		String contactemail = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_email"), wd);
		System.out.println(contactemail);
		return contactemail;
	}

	public String getCreatedRContactPhone() {
		String contactphone = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_phone"), wd);
		System.out.println(contactphone);
		return contactphone;
	}

	public ArrayList<String> getCreatedRContactAddress() {

		ArrayList<String> contaddress = new ArrayList<String>();
		String caddress = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_address"), wd);
		String[] contactaddress = caddress.split(" ");
		String[] a11 = contactaddress[0].split("\n");
		String street = a11[0];
		String city = a11[1];
		String state = contactaddress[1];
		String[] a12 = contactaddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		contaddress.add(street);
		contaddress.add(city);
		contaddress.add(state);
		contaddress.add(postal);
		contaddress.add(country);
		System.out.println(contaddress);
		return contaddress;
	}

	public String getCreatedRContactDescription() {
		String contactdescription = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcontact_description"), wd);
		System.out.println(contactdescription);
		return contactdescription;
	}

	// REMOVING ITEM FORM TABLIST

	public Crmservice clickMenuBar() {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_user_menu"), wd);
		return this;
	}

	public Crmservice clickOnAdministrationInMenu() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_user_menu_administration"), wd);
		return this;
	}

	public Crmservice clickOnUserInterfaceLink() {
		CommonUtils.clickLink("css",
				crmobjects.getObjects().getProperty("login_user_menu_administration_userinterface"), wd);
		return this;
	}

	public Crmservice removeCalendarFromTabList() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_user_menu_administration_userinterface_removecalendar"), wd);
		return this;
	}

	public Crmservice clickOnSaveAfterRemoving() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_user_menu_administration_userinterface_removecalendar_save"),
				wd);
		return this;
	}

	public Crmservice clickAddButtonAfterDeleting() {
		CommonUtils.doubleClick("xpath", wd,
				crmobjects.getObjects().getProperty("login_user_administration_userinterface_afterdelete_addbutton"));
		return this;
	}

	public Crmservice clickAddButtonInAddItem() {
		CommonUtils.clickButton("css", crmobjects.getObjects()
				.getProperty("login_user_administration_userinterface_afterdelete_addbutton_additem"), wd);
		return this;
	}

	// VALIDATING CALENDAR FROM TAB LIST

	public String getItemFromTabList() {
		String item = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("login_user_administration_userinterface_calendar"), wd);
		System.out.println(item);
		return item;
	}

	public ArrayList<String> getItemsInTabList() {
		ArrayList<String> tablistitems = new ArrayList<String>();
		tablistitems = CommonUtils.getItemsFromList("css",
				crmobjects.getObjects().getProperty("login_user_administration_userinterface_tablist"), wd);
		System.out.println(tablistitems);
		return tablistitems;
	}

	public ArrayList<String> getItemsFromDashboardList() {
		ArrayList<String> dashboardlist = new ArrayList<String>();
		dashboardlist = CommonUtils.getItemsFromList("css",
				crmobjects.getObjects().getProperty("login_user_administration_userinterface_dashboardlist"), wd);
		System.out.println(dashboardlist);
		return dashboardlist;
	}

	public String getItemAfterDelete() {
		String item = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("login_user_administration_userinterface_afterdelete"), wd);
		System.out.println(item);
		return item;
	}

	// CREATING LEADS

	public Crmservice clickOnDashboardLead() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_dashboard_leads"), wd);
		return this;
	}

	public Crmservice clickOnCreateLead() {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_dashboard_contacts_createlead"), wd);
		return this;
	}

	public Crmservice enterLeadDetails(String firstname, String lastname, String accountname, String email,
			String phonenumber, String title) {
		CommonUtils.selectDropdownItem("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_name"),
				"Mr.", "value");
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_firstname"),
				firstname);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_lastname"),
				lastname);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_accountname"),
				accountname);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_email"), email);
		CommonUtils.selectDropdownItem("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_phonedd"),
				"Mobile", "value");
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_phonetab"),
				phonenumber);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_title"), title);
		return this;
	}

	public Crmservice enterLeadAddressDetails(String street, String city, String state, String postalcode,
			String country) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_street"),
				street);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_city"),
				city);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_state"),
				state);
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_contacts_createcontact_postalcode"), postalcode);
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_contacts_createcontact_country"),
				country);
		return this;
	}

	public Crmservice enterLeadWebsite(String website) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_leads_createlead_website"),
				website);
		return this;
	}

	public Crmservice clickSaveButtonAfterEnteringLeadDetails() throws InterruptedException {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_leads_createlead_save"), wd);
		return this;
	}

	public Crmservice enterLeadDetailsFields(String opportunityamount, String description) {
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_leads_createlead_details_status"), "Assigned", "value");
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_leads_createlead_details_source"), "Call", "value");
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_leads_createlead_details_opportunityamount"),
				opportunityamount);
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_leads_createlead_details_industry"), "Advertising", "value");
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_leads_createlead_details_description"), description);
		return this;
	}

	// VALIDATING CREATE LEAD WITHOUT DETAILS FIELD

	public ArrayList<String> getCreatedLeadNameList() {
		String contactnamelist = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_name"), wd);
		ArrayList<String> contactname = new ArrayList<String>();
		String[] cname = contactnamelist.split(" ");
		//String name = cname[0];
		String firstname = cname[0];
		String lastname = cname[1];
		//contactname.add(name);
		contactname.add(firstname);
		contactname.add(lastname);
		System.out.println(contactname);
		return contactname;
	}

	public String getCreatedLeadAccountName() {
		String leadaccountname = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_accountname"),
				wd);
		System.out.println(leadaccountname);
		return leadaccountname;
	}

	public String getCreatedLeadEmail() {
		String contactemail = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_email"), wd);
		System.out.println(contactemail);
		return contactemail;
	}

	public String getCreatedLeadPhone() {
		String contactphone = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcontact_phone"), wd);
		System.out.println(contactphone);
		return contactphone;
	}

	public String getCreatedLeadTitle() {
		String contacttitle = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_title"), wd);
		System.out.println(contacttitle);
		return contacttitle;
	}

	public ArrayList<String> getCreatedLeadAddress() {

		ArrayList<String> leadaddress = new ArrayList<String>();
		String laddress = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_address"), wd);
		String[] leadsaddress = laddress.split(" ");
		String[] a11 = leadsaddress[0].split("\n");
		String street = a11[0];
		String c1 = a11[1];
		String[] c2 = c1.split(",");
		String city = c2[0];
		String state = leadsaddress[1];
		String[] a12 = leadsaddress[2].split("\n");
		String postal = a12[0];
		String country = a12[1];
		leadaddress.add(street);
		leadaddress.add(city);
		leadaddress.add(state);
		leadaddress.add(country);
		leadaddress.add(postal);
		System.out.println(leadaddress);
		return leadaddress;
	}

	public String getCreatedLeadWebsite() {
		String leadwebsite = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_website"), wd);
		System.out.println(leadwebsite);
		return leadwebsite;
	}

	public ArrayList<String> getCreatedLeadDetails() throws InterruptedException {
		ArrayList<String> leadinfo = new ArrayList<String>();
		leadinfo.add(getCreatedLeadNameList().get(0));
		leadinfo.add(getCreatedLeadNameList().get(1));
		//leadinfo.add(getCreatedLeadAccountName());
		leadinfo.add(getCreatedLeadEmail());
		leadinfo.add(getCreatedLeadPhone());
		leadinfo.add(getCreatedLeadTitle());
		leadinfo.addAll(getCreatedLeadAddress());
		//leadinfo.add(getCreatedLeadWebsite());
		leadinfo.add(getCreatedLeadDescription());
		return leadinfo;
	}
	// VALIDATING CREATELEAD WITH DETAILS FIELDS

	public String getCreatedLeadStatus() {
		String leadstatus = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_status"), wd);
		System.out.println(leadstatus);
		return leadstatus;
	}

	public String getCreatedLeadSource() {
		String leadsource = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_source"), wd);
		System.out.println(leadsource);
		return leadsource;
	}

	public String getCreatedLeadOpportunityAmount() {
		String leadsopportunityamount = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getlead_opportunityamount"), wd);
		System.out.println(leadsopportunityamount);
		return leadsopportunityamount;
	}

	public String getCreatedLeadIndustry() {
		String leadsindustry = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_industry"), wd);
		System.out.println(leadsindustry);
		return leadsindustry;
	}

	public String getCreatedLeadDescription() {
		String leaddescription = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getlead_description"),
				wd);
		System.out.println(leaddescription);
		return leaddescription;
	}

	// CREATING ENTITY

	public Crmservice clickEntityManagerLink() {
		CommonUtils.clickLink("css",
				crmobjects.getObjects().getProperty("menu_administration_customization_entitymanager"), wd);
		return this;
	}

	public Crmservice clickCreateEntityButton() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("menu_administration_customization_entitymanager_createentity"),
				wd);
		return this;
	}

	public Crmservice enterEntityName(String ename) {
		CommonUtils.insertText("css", wd, ".modal-content>div>div:nth-child(1)>div:nth-child(1)>div>input", ename);
		return this;
	}

	public Crmservice selectDropDownType(String type) {
		CommonUtils.selectDropdownItem("css", wd, crmobjects.getObjects()
				.getProperty("menu_administration_customization_entitymanager_createentity_type"), type, "value");
		return this;
	}

	public Crmservice enterLabelSingular(String labelsingular) {
		CommonUtils
				.insertText("css", wd,
						crmobjects.getObjects().getProperty(
								"menu_administration_customization_entitymanager_createentity_labelsingular"),
						labelsingular);
		return this;
	}

	public Crmservice enterLabelPlural(String labelplural) {
		CommonUtils
				.insertText("css", wd,
						crmobjects.getObjects().getProperty(
								"menu_administration_customization_entitymanager_createentity_labelplural"),
						labelplural);
		return this;
	}

	public Crmservice clickStreamCheckBox() {
		CommonUtils.clickButton("css", crmobjects.getObjects()
				.getProperty("menu_administration_customization_entitymanager_createentity_stream"), wd);
		return this;
	}

	public Crmservice clickSaveAfterCreatingEntity() {
		CommonUtils.clickButton("css", crmobjects.getObjects()
				.getProperty("menu_administration_customization_entitymanager_createentity_save"), wd);
		return this;
	}

	// VALIDATING ENTITY PAGE OBJECTS

	public String getCreatedEntityName() {
		String ename = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcreatedentity_name"), wd);
		System.out.println(ename);
		return ename;
	}

	public String getCreatedEntityLabelSingular() {
		String elabelsingular = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcreatedentity_labelsingular"), wd);
		System.out.println(elabelsingular);
		return elabelsingular;
	}

	public String getCreatedEntityType() {
		String etype = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcreatedentity_type"), wd);
		System.out.println(etype);
		return etype;
	}

	// VALIDATING CREATE CONTACTS

	public ArrayList<String> getCreatedContactDetails() throws InterruptedException {
		ArrayList<String> contactinfo = new ArrayList<String>();
		contactinfo.add(getCreatedContactNameList().get(0));
		contactinfo.add(getCreatedContactNameList().get(1));
		contactinfo.add(getCreatedContactEmail());
		contactinfo.add(getCreatedContactPhone());
		contactinfo.addAll(getCreatedContactAddressforcsv());
		contactinfo.add(getCreatedContactDescription());

		System.out.println(contactinfo);

		return contactinfo;
	}

	public ArrayList<String> getCreatedContactDetailsforDB() throws InterruptedException {
		ArrayList<String> contactinfo = new ArrayList<String>();
		contactinfo.add(getCreatedContactNameList().get(0));
		contactinfo.add(getCreatedContactNameList().get(1));
		// contactinfo.add(getCreatedContactEmail());
		// contactinfo.add(getCreatedContactPhone());
		contactinfo.addAll(getCreatedContactAddress());
		contactinfo.add(getCreatedContactDescription());

		System.out.println(contactinfo);

		return contactinfo;
	}

	// CREATING CASE

	public Crmservice clickOnDashboardCase() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_dashboard_cases"), wd);
		return this;
	}

	public Crmservice clickOnCreateCaseButton() {
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("login_dashboard_cases_createcase"), wd);
		return this;
	}

	public Crmservice enterCaseName(String cname) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_cases_createcase_name"), cname);
		return this;
	}

	public Crmservice selectStatus(String status) {
		CommonUtils.selectDropdownItem("css", wd, crmobjects.getObjects().getProperty("login_cases_createcase_status"),
				status, "value");
		return this;
	}

	public Crmservice selectPriority(String priority) {
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_cases_createcase_priority"), priority, "value");
		return this;
	}

	public Crmservice selectType(String type) {
		CommonUtils.selectDropdownItem("css", wd, crmobjects.getObjects().getProperty("login_cases_createcase_type"),
				type, "value");
		return this;
	}

	public Crmservice enterDescription(String description) {
		CommonUtils.insertText("css", wd, crmobjects.getObjects().getProperty("login_cases_createcase_description"),
				description);
		return this;
	}

	public Crmservice clickOnAccountSelectButton() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_cases_createcase_accountselectbutton"), wd);
		return this;
	}

	public Crmservice selectExistingAccountName() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_cases_createcase_accountnameselection"),
				wd);
		return this;
	}

	public Crmservice clickOnContactSelectButton() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_cases_createcase_contactselectbutton"), wd);
		return this;
	}

	public Crmservice selectExistingContactName() {
		CommonUtils.clickLink("css", crmobjects.getObjects().getProperty("login_cases_createcase_contactnameselection"),
				wd);
		return this;
	}

	// VALIDATING CASE CREATED PAGE OBJECTS

	public String getCreatedCaseName() {
		String cname = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcase_name"), wd);
		System.out.println(cname);
		return cname;
	}

	public String getCreatedCaseStatus() {
		String cstatus = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcase_status"), wd);
		System.out.println(cstatus);
		return cstatus;
	}

	public String getCreatedCasePriority() {
		String cpriority = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcase_priority"), wd);
		System.out.println(cpriority);
		return cpriority;
	}

	public String getCreatedCaseType() {
		String ctype = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcase_type"), wd);
		System.out.println(ctype);
		return ctype;
	}

	public String getCreatedCaseDescription() {
		String cdescription = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcase_description"),
				wd);
		System.out.println(cdescription);
		return cdescription;
	}

	public String getExistingAccountName() {
		String cexistingaccountname = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcase_existingaccountname"), wd);
		System.out.println(cexistingaccountname);
		return cexistingaccountname;
	}

	public String getExistingContactName() {
		String cexistingcontactname = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcase_existingcontactname"), wd);
		System.out.println(cexistingcontactname);
		return cexistingcontactname;
	}

	// CREATING OPPORTUNITIES

	public Crmservice clickOnDashboardOpportunity() {
		CommonUtils.clickLink("link", crmobjects.getObjects().getProperty("login_dashboard_opportunities"), wd);
		return this;
	}

	public Crmservice clickOnCreateOpportunity() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_dashboard_opportunities_createopportunity"), wd);
		return this;
	}

	public Crmservice enterOpportunityName(String opportunityname) {
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_name"), opportunityname);
		return this;
	}

	public Crmservice selectStagedd(String stage) {
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_stage"), stage, "value");
		return this;
	}

	public Crmservice enterAmount(String amount) {
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_amount"), amount);
		return this;
	}

	public Crmservice enterProbability(String probability) {
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_probability"), probability);
		return this;
	}

	public Crmservice clickOnDatePicker() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_datepicker"), wd);
		return this;
	}

	public Crmservice selectDate() {
		CommonUtils.clickButton("css",
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_calendardate"), wd);
		return this;
	}

	public Crmservice selectLeadSource(String leadsource) {
		CommonUtils.selectDropdownItem("css", wd,
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_leadsources"), leadsource,
				"value");
		return this;
	}

	public Crmservice enterOpportunityDescription(String description) {
		CommonUtils.insertText("css", wd,
				crmobjects.getObjects().getProperty("login_opportunities_createopportunity_description"), description);
		return this;
	}

	// VALIDATING OPPORTUNITY PAGE OBJECTS

	public String getCreatedOpportunityName() {
		String oname = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcreatedopportunity_name"),
				wd);
		System.out.println(oname);
		return oname;
	}

	public String getCreatedOpportunityStage() {
		String ostage = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcreatedopportunity_stage"),
				wd);
		System.out.println(ostage);
		return ostage;
	}

	public String getCreatedOpportunityAmount() {
		String oamount = CommonUtils.getText("css", crmobjects.getObjects().getProperty("getcreatedopportunity_amount"),
				wd);
		System.out.println(oamount);
		return oamount;
	}

	public String getCreatedOpportunityCloseDate() {
		String oclosedate = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcreatedopportunity_closedate"), wd);
		System.out.println(oclosedate);
		return oclosedate;
	}

	public String getCreatedOpportunityLeadSource() {
		String oleadsource = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcreatedopportunity_leadsource"), wd);
		System.out.println(oleadsource);
		return oleadsource;
	}

	public String getCreatedOpportunityDescription() {
		String odescription = CommonUtils.getText("css",
				crmobjects.getObjects().getProperty("getcreatedopportunity_description"), wd);
		System.out.println(odescription);
		return odescription;
	}

	public Crmservice clickeditButton() {

		CommonUtils.clickButton("link", crmobjects.getObjects().getProperty("testeditbuttontext"), wd);

		return this;
	}

	public Crmservice navigateToAccountsDashboard() throws FindFailed {

		sc.click("src\\test\\resources\\app_images\\Account_dashboard.png");
		return this;
	}

	public Crmservice accountsAddField() throws FindFailed, InterruptedException {
		sc.click("src\\test\\resources\\app_images\\Account_AddField.png");
		sc.click("src\\test\\resources\\app_images\\account_AssignedUser.png");

		sc.click("src\\test\\resources\\app_images\\Account_AddField.png");
		sc.click("src\\test\\resources\\app_images\\account_desp.png");
		sc.click("src\\test\\resources\\app_images\\Account_AddField.png");
		sc.click("src\\test\\resources\\app_images\\account_indus.png");
		sc.click("src\\test\\resources\\app_images\\Account_AddField.png");
		sc.click("src\\test\\resources\\app_images\\Account_type.png");
		sc.click("src\\test\\resources\\app_images\\SelectUser.png");
		CommonUtils.wait(2);
		sc.click("src\\test\\resources\\app_images\\existingAdmin.png");

		return this;
	}

	public Crmservice uploadContactcsvfile() throws FindFailed, InterruptedException {
		sc.click("src//test//resources//contact_images//contact_dashboard.png");
		CommonUtils.wait(2);
		sc.click("src//test//resources//contact_images//hamburger.png");
		sc.click("src//test//resources//contact_images//menu_admin.png");
		CommonUtils.wait(2);
		CommonUtils.clickButton("link", crmobjects.getObjects().getProperty("contacts_admin_import"), wd);
		sc.click("src//test//resources//contact_images//Selectlist.png");
		sc.click("src//test//resources//contact_images//selectcontact.png");
		sc.click("src//test//resources//contact_images//uploadbtn.png");
		CommonUtils.wait(2);
		// sc.click("src//test//resources//contact_images//drive.png");
		// sc.doubleClick("src//test//resources//contact_images//projectfolder.png");
		sc.doubleClick("src//test//resources//contact_images//csvfile.png");
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("contact_admin_import_next"), wd);

		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_firstname"), "value",
				"firstName", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_lastname"), "value",
				"lastName", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_email"), "value",
				"emailAddress", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_phone"), "value",
				"phoneNumberMobile", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_street"), "value",
				"addressStreet", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_city"), "value",
				"addressCity", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_state"), "value",
				"addressState", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_postal"), "value",
				"addressPostalCode", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_country"), "value",
				"addressCountry", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("contact_upload_desp"), "value",
				"description", wd);
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("contact_upload_runimport"), wd);
		CommonUtils.wait(3);
		// sc.click("src//test//resources//contact_images//contact_dashboard.png");
		// CommonUtils.wait(2);
		sc.click("src//test//resources//contact_images//existingcontact.png");

		return this;

	}

	public Crmservice uploadLeadsCSVFile() throws FindFailed, InterruptedException {

		CommonUtils.clickButton("link", crmobjects.getObjects().getProperty("leads_dashboard"), wd);

		sc.click("src//test//resources//contact_images//hamburger.png");
		sc.click("src//test//resources//contact_images//menu_admin.png");
		CommonUtils.wait(2);
		CommonUtils.clickButton("link", crmobjects.getObjects().getProperty("contacts_admin_import"), wd);
		sc.click("src//test//resources//contact_images//Selectlist.png");
		sc.click("src//test//resources//leads_images//leads_selectlist.png");
		sc.click("src//test//resources//contact_images//uploadbtn.png");
		CommonUtils.wait(2);
		sc.doubleClick("src//test//resources//leads_images//leads_csvfile.png");
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("contact_admin_import_next"), wd);

		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_firstname"), "value",
				"firstName", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_lastname"), "value",
				"lastName", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_email"), "value",
				"emailAddress", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_phone"), "value",
				"phoneNumberMobile", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_street"), "value",
				"addressStreet", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_city"), "value",
				"addressCity", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_state"), "value",
				"addressState", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_postal"), "value",
				"addressPostalCode", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_country"), "value",
				"addressCountry", wd);
		CommonUtils.selectItemFromList("id", crmobjects.getObjects().getProperty("leads_upload_desp"), "value",
				"description", wd);
		CommonUtils.wait(2);
		CommonUtils.clickButton("css", crmobjects.getObjects().getProperty("contact_upload_runimport"), wd);
		CommonUtils.clickButton("link", crmobjects.getObjects().getProperty("leads_dashboard"), wd);
		CommonUtils.wait(2);
		CommonUtils.clickLink("xpath", crmobjects.getObjects().getProperty("leads_createdby_csv"), wd);
		return this;
	}

	public Crmservice uploadTaskCSVFile() {

		return this;
	}
}
