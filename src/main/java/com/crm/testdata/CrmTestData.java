package com.crm.testdata;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class CrmTestData {
	
	static CrmAccountData  craccountdata = null;
	
	public static CrmAccountData accountTestData() {
		try {
		File file = new File("src//test//data//account_data.xml");
		JAXBContext jaxbcontext = JAXBContext.newInstance(CrmAccountData.class);
		Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
		craccountdata = (CrmAccountData) unmarshaller.unmarshal(file);
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return craccountdata;
	}

}
