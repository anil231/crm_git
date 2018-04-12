package com.crm.testscripts;

import java.io.IOException;
import java.util.List;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.services.Crmservice;
import com.crm.testdata.AccountsData;
import com.crm.testdata.CrmAccountData;
import com.crm.testdata.CrmTestData;
import com.crm.validators.CrmValidator;

public class AdminTest2 {
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
	//@Test(description = "Add fields to the accounts", priority = 0)
	public void testUsingSikuli() throws InterruptedException, FindFailed {
		
		cservice.navigateToAccountsDashboard().accountsAddField();
	
}
	@Test(description = "Creating contact using csv file", priority = 0)

	public void createContactusingcsvfile() throws FindFailed, InterruptedException, IOException{
		
		cservice.uploadContactcsvfile();
		//cservice.getCreatedContactDetails();
		//cservice.getCreatedContactNameList();
	cvalidator.validateContactDataFromCSVtoUI(cservice);
		cvalidator.validateContactAganistDBtoUI("src//test//db_queries//contactDB.sql", cservice);
		cvalidator.validateContactDatafromDBtoCSV("src//test//db_queries//contactDB.sql", cservice);
	//cservice.getcsvData();
	}
	
	
	//@Test(description = "Creating leads using csv file", priority = 1)

public void createLeadsusingcsvfile() throws FindFailed, InterruptedException, IOException{
		
		cservice.uploadLeadsCSVFile();
		//cvalidator.validateLeadFromCSVtoUI(cservice);
		cvalidator.validateLeadAgainstDBtoUI("src//test//db_queries//leads.sql", cservice);
		
		
	}

}