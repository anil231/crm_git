package com.crm.testdata;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Csvfiledata1 {
	
//	public FileInputStream fis;
//	HSSFWorkbook wb = null;
//	HSSFSheet sh = null;
//	
//	public HSSFSheet loginDetails(){
//		
//		try {
//			fis = new FileInputStream("src\\test\\csvfiledata\\contact.csv");
//			 wb = new HSSFWorkbook(fis);
//			 sh = wb.getSheet("contact");
//		} 
//		catch (Exception e) {
//						
//			e.printStackTrace();
//		}
//		return sh;
//	}

	public FileInputStream fis;
	XSSFWorkbook wb1 = null;
	XSSFSheet sh1 =null;
public XSSFSheet loginDetails1(){
		
		try {
			fis = new FileInputStream("src\\test\\csvfiledata\\contact.csv");
			 wb1= new XSSFWorkbook(fis);
			 sh1 = wb1.getSheet("contact");
		} 
		catch (Exception e) {
						
			e.printStackTrace();
		}
		return sh1;
	}

}
