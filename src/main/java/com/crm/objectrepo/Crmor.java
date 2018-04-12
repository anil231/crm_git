package com.crm.objectrepo;

import java.io.FileInputStream;
import java.util.Properties;

public class Crmor {
	
	public FileInputStream fis = null;
	public Properties prop = null;
	
	public Properties getObjects(){
		
		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\crmobjects.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return prop;
	}

}
