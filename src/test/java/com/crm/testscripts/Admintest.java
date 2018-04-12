package com.crm.testscripts;

import java.util.List;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.services.Crmservice;
import com.crm.testdata.AccountsData;
import com.crm.testdata.CrmAccountData;
import com.crm.testdata.CrmTestData;
import com.crm.validators.CrmValidator;

public class Admintest {
	Crmservice cservice = new Crmservice();
	CrmValidator cvalidator = new CrmValidator();
	CrmAccountData cadata = null;
	List<AccountsData> crmaccountsdata = null;

	@BeforeClass
	public void init() throws InterruptedException {
		cadata = CrmTestData.accountTestData();
		crmaccountsdata = cadata.getCaccountdata();
		cservice.openCrmApplication();
		cservice.loginCrmApplication(crmaccountsdata.get(0).getUsername(), crmaccountsdata.get(0).getPassword());

	}

	// @Test (description = "creating account details with copybilling and
	// without details section", priority = 0 )
	// public void creatingAccount() throws InterruptedException{
	// cservice.clickDashboardAccount().clickCreateAccountButton().enterAccountDetails().enterBillingAddress().clickCopyBillingButton().clickSaveButton();
	// //cservice.getCreatedAccountUserName();
	// cservice.getCreatedAccontMobileNumber();
	// cservice.getCreatedAccountBillingAddress();
	// cservice.getCreatedAccountShippingAddress();
	// cvalidator.validateUserLogin(cservice);
	// cvalidator.validateGivenUserAccountDetails(cservice);
	// //cvalidator.validateGivenUserAccountDetails(cservice, "Test User");
	// }
	//

	// @Test (description = "creating account details with copybilling and
	// without details section", priority = 1)
	// public void enterNewShippingAddress() throws InterruptedException{
	// Thread.sleep(1000);
	// cservice.clickDashboardAccount().clickCreateAccountButton().enterAccountDetails().enterBillingAddress().enterShippingAddress().clickSaveButton().clickSaveNewAccountOnExistingAccount();
	// cvalidator.validateUserAccountWithoutCopybillingButton(cservice);
	// }

	// @Test (description = "Removing the existing account", priority = 1)
	public void removeAccount() throws InterruptedException {
		Thread.sleep(2000);
		cservice.clickDashboardAccount().removeAllAccounts();
	}

	// @Test (description = "creating account with copy billing" , priority = 0)
	public void enterBasicUserDetails() throws InterruptedException {
		cservice.clickDashboardAccount().clickCreateAccountButton()
				.enterAccountName(crmaccountsdata.get(0).getAccountUserName());
		cservice.enterAccountEmail(crmaccountsdata.get(0).getAccountEmail());
		cservice.enterAccountPhoneNumber(crmaccountsdata.get(0).getAccountPhoneNumber());
		cservice.enterAccountWebsite(crmaccountsdata.get(0).getAccountWebsite());
		cservice.enterBillingAddress(crmaccountsdata.get(0).getAccountStreet(), crmaccountsdata.get(0).getAccountCity(),
				crmaccountsdata.get(0).getAccountState(), crmaccountsdata.get(0).getAccountPostalCode(),
				crmaccountsdata.get(0).getAccountCountry());
		// cservice.clickCopyBillingButton();
		cservice.clickSaveButton();
		// cservice.getCreatedAccountUserName();
		cvalidator.validateAccountNameAgainstDb("src//test//db_queries//tc_001.sql", cservice);
		// cvalidator.validateGivenXmlUserAccountDetails(cservice);
	}

	// @Test (description = "creating account without copy billing" , priority =
	// 1)
	public void enterBasicUserDetailsWithoutCopyBilling() throws InterruptedException {
		cservice.clickDashboardAccount().clickCreateAccountButton()
				.enterAccountName(crmaccountsdata.get(0).getAccountUserName());
		cservice.enterAccountEmail(crmaccountsdata.get(0).getAccountEmail());
		cservice.enterAccountPhoneNumber(crmaccountsdata.get(0).getAccountPhoneNumber());
		cservice.enterAccountWebsite(crmaccountsdata.get(0).getAccountWebsite());
		cservice.enterBillingAddress(crmaccountsdata.get(0).getAccountStreet(), crmaccountsdata.get(0).getAccountCity(),
				crmaccountsdata.get(0).getAccountState(), crmaccountsdata.get(0).getAccountPostalCode(),
				crmaccountsdata.get(0).getAccountCountry());
		cservice.enterShippingAddress(crmaccountsdata.get(0).getAccountSStreet(),
				crmaccountsdata.get(0).getAccountSCity(), crmaccountsdata.get(0).getAccountSState(),
				crmaccountsdata.get(0).getAccountSPostalCode(), crmaccountsdata.get(0).getAccountSCountry());
		cservice.clickSaveButton();
		cvalidator.validateGivenXmlUserAccountDetails(cservice);
	}

	// @Test (description = "creating contact without accounts field" , priority
	// = 0)
	public void creatingContact() throws InterruptedException {
		cservice.clickOnDashboardContacts().clickOnCreateContact().enterContactDetails(
				crmaccountsdata.get(0).getContactFirstName(), crmaccountsdata.get(0).getContactLastName(),
				crmaccountsdata.get(0).getContactEmail(), crmaccountsdata.get(0).getContactPhoneNumber());
		cservice.enterContactAddressDetails(crmaccountsdata.get(0).getContactStreet(),
				crmaccountsdata.get(0).getContactCity(), crmaccountsdata.get(0).getContactState(),
				crmaccountsdata.get(0).getContactPostalCode(), crmaccountsdata.get(0).getContactCountry(),
				crmaccountsdata.get(0).getContactDescription());
		cservice.clickSaveButtonAfterEnteringContactDetails();

		cvalidator.validateContactDetails(cservice);
	}

	// @Test (description = "editing contact with all fields" , priority = 1)
	public void editContact() throws InterruptedException {
		cservice.clickOnDashboardContacts().clickExistingName().clickEditButton();
		cservice.clearAndReEnterTheContactDetails(crmaccountsdata.get(0).getContactRFirstName(),
				crmaccountsdata.get(0).getContactRLastName(), crmaccountsdata.get(0).getContactREmail(),
				crmaccountsdata.get(0).getContactRPhoneNumber());
		cservice.clearAndReEnterContactAddress(crmaccountsdata.get(0).getContactRStreet(),
				crmaccountsdata.get(0).getContactRCity(), crmaccountsdata.get(0).getContactRState(),
				crmaccountsdata.get(0).getContactRPostalCode(), crmaccountsdata.get(0).getContactRCountry(),
				crmaccountsdata.get(0).getContactRDescription());
		cservice.clickSaveButton();
		cvalidator.validateEditedContactDetails(cservice);
	}

	

	// @Test (description = "Adding removed item into tab list", priority = 0)
	public void addingListItemAfterDeleting() throws InterruptedException {
		cservice.clickMenuBar().clickOnAdministrationInMenu().clickOnUserInterfaceLink().getItemFromTabList();
		cservice.removeCalendarFromTabList();
		cservice.clickAddButtonAfterDeleting();
		cservice.clickAddButtonInAddItem();
		cservice.clickSaveButton();
	}

	// @Test (description = "Creating Lead without details section", priority =
	// 0)
	public void creatingLead() throws InterruptedException {
		cservice.clickOnDashboardLead().clickOnCreateLead().enterLeadDetails(crmaccountsdata.get(0).getLeadFirstName(),
				crmaccountsdata.get(0).getLeadLastName(), crmaccountsdata.get(0).getLeadAccountName(),
				crmaccountsdata.get(0).getLeadEmail(), crmaccountsdata.get(0).getLeadPhoneNumber(),
				crmaccountsdata.get(0).getLeadTitle());
		cservice.enterLeadAddressDetails(crmaccountsdata.get(0).getLeadStreet(), crmaccountsdata.get(0).getLeadCity(),
				crmaccountsdata.get(0).getLeadState(), crmaccountsdata.get(0).getLeadPostalCode(),
				crmaccountsdata.get(0).getLeadCountry());
		cservice.enterLeadWebsite(crmaccountsdata.get(0).getLeadWebsite());
		cservice.clickSaveButtonAfterEnteringLeadDetails();

		cvalidator.validateLeadDetails(cservice);
	}

	// @Test (description = "Creating Lead with details section", priority = 0)
	public void creatingLeadWithDetails() throws InterruptedException {
		cservice.clickOnDashboardLead().clickOnCreateLead().enterLeadDetails(crmaccountsdata.get(0).getLeadFirstName(),
				crmaccountsdata.get(0).getLeadLastName(), crmaccountsdata.get(0).getLeadAccountName(),
				crmaccountsdata.get(0).getLeadEmail(), crmaccountsdata.get(0).getLeadPhoneNumber(),
				crmaccountsdata.get(0).getLeadTitle());
		cservice.enterLeadAddressDetails(crmaccountsdata.get(0).getLeadStreet(), crmaccountsdata.get(0).getLeadCity(),
				crmaccountsdata.get(0).getLeadState(), crmaccountsdata.get(0).getLeadPostalCode(),
				crmaccountsdata.get(0).getLeadCountry());
		cservice.enterLeadWebsite(crmaccountsdata.get(0).getLeadWebsite());
		cservice.enterLeadDetailsFields(crmaccountsdata.get(0).getLeadOpportunityAmount(),
				crmaccountsdata.get(0).getLeadDescription());
		cservice.clickSaveButtonAfterEnteringLeadDetails();
		cvalidator.validateLeadDetails(cservice);
	}

	// @Test (description = "creating an entity", priority = 0)
	public void createEntity() {
		cservice.clickMenuBar().clickOnAdministrationInMenu().clickEntityManagerLink().clickCreateEntityButton();
		cservice.enterEntityName(crmaccountsdata.get(0).getEntityName());
		cservice.selectDropDownType(crmaccountsdata.get(0).getEntityType());
		// cservice.enterLabelSingular(crmaccountsdata.get(0).getEntityLabelSingular());
		// cservice.enterLabelPlural(crmaccountsdata.get(0).getEntityLabelPlural());
		cservice.clickStreamCheckBox();
		cservice.clickSaveAfterCreatingEntity();
		cservice.getCreatedEntityName();
		cservice.getCreatedEntityLabelSingular();
		cservice.getCreatedEntityType();
	}

	// @Test (description = "creating case without accounts and contacts
	// section", priority = 0)
	public void createCaseWithoutAccountsAndContactsSection() throws InterruptedException {
		cservice.clickOnDashboardCase().clickOnCreateCaseButton().enterCaseName(crmaccountsdata.get(0).getCaseName());
		cservice.selectStatus(crmaccountsdata.get(0).getCaseStatus())
				.selectPriority(crmaccountsdata.get(0).getCasePriority());
		cservice.selectType(crmaccountsdata.get(0).getCaseType())
				.enterDescription(crmaccountsdata.get(0).getCaseDescription());
		cservice.clickSaveButton();
		cservice.getCreatedCaseName();
		cservice.getCreatedCaseStatus();
		cservice.getCreatedCasePriority();
		cservice.getCreatedCaseType();
		cservice.getCreatedCaseDescription();
		cvalidator.validateCaseAgainstDb("src//test//db_queries//tc_003.sql", cservice);
	}

	// @Test (description = "creating case with accounts and contacts section",
	// priority = 0)
	public void createCaseWithAccountsAndContactsSection() throws InterruptedException {
		cservice.clickOnDashboardCase().clickOnCreateCaseButton().enterCaseName(crmaccountsdata.get(0).getCaseName());
		cservice.selectStatus(crmaccountsdata.get(0).getCaseStatus())
				.selectPriority(crmaccountsdata.get(0).getCasePriority());
		cservice.clickOnContactSelectButton();
		cservice.selectExistingContactName();
		cservice.clickOnAccountSelectButton();
		cservice.selectExistingAccountName();
		cservice.selectType(crmaccountsdata.get(0).getCaseType()).enterDescription(crmaccountsdata.get(0).getCaseDescription());
		cservice.clickSaveButton();
		cservice.getCreatedCaseName();
		cservice.getCreatedCaseStatus();
		cservice.getCreatedCasePriority();
		cservice.getCreatedCaseType();
		cservice.getCreatedCaseDescription();
		cservice.getExistingAccountName();
		cservice.getExistingContactName();
		cvalidator.validateCaseAgainstDb("src//test//db_queries//tc_003.sql", cservice);
	}

	//@Test(description = "creating opportunity without accounts and contacts fields", priority = 0)
	public void createOpportunityWithoutAccountsAndContacts() throws InterruptedException {
		cservice.clickOnDashboardOpportunity().clickOnCreateOpportunity();
		cservice.enterOpportunityName(crmaccountsdata.get(0).getOpportunityName())
				.selectStagedd(crmaccountsdata.get(0).getOpportunityStage());
		cservice.enterAmount(crmaccountsdata.get(0).getOpportunityAmount());
		// cservice.enterProbability(crmaccountsdata.get(0).getOpportunityProbability());
		cservice.clickOnDatePicker();
		cservice.selectDate();
		cservice.selectLeadSource(crmaccountsdata.get(0).getOpportunityLeadSource()).enterOpportunityDescription(crmaccountsdata.get(0).getOpportunityDescription());
		cservice.clickSaveButton();

		cservice.getCreatedOpportunityCloseDate();
		cvalidator.validateOpportunityDate(cservice);
		cvalidator.validateOpportunityAgaintDb("src//test//db_queries//tc_004.sql", cservice);
	}
	
	
	}
