package com.crm.testdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CsvFileData {

	public static List<String> getContactCsvData(){
		
		List<String> csvData = new ArrayList<String>();
		try {
			FileReader file = new FileReader("src\\test\\csvfiledata\\contact.csv");
			BufferedReader br = new BufferedReader(file);
			StringBuilder sb = new StringBuilder();
			String s = null;
			while((s = br.readLine())!= null){
				
				s = br.readLine();
							
				sb.append(s);
			}
			String sc = sb.toString();
			String[] arr = sc.split(",");
			
			csvData = Arrays.asList(arr);
			
				
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return csvData; 
		
		
	}

	public static List<String> getLeadCsvData() throws IOException {
		List<String> leadcsvdata = new ArrayList<String>();
		FileReader file = new FileReader("src\\test\\csvfiledata\\leads.csv");
		BufferedReader br = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		String s= null;
		while((s = br.readLine())!=null){
			s = br.readLine();
			sb.append(s);
		}
		String sc = sb.toString();
		String[] arr = sc.split(",");
		leadcsvdata = Arrays.asList(arr);
		System.out.println(leadcsvdata);
		
		return leadcsvdata;
		
	}
	
	public static List<String> getTaskCsvData() throws IOException {
		List<String> taskcsvdata = new ArrayList<String>();
		FileReader file = new FileReader("C:\\Users\\vkovida\\Desktop\\tasks.csv");
		BufferedReader br = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		String s= null;
		while((s = br.readLine())!=null){
			sb.append(s);
		}
		String sc = sb.toString();
		String[] arr = sc.split(",");
		taskcsvdata = Arrays.asList(arr);
		System.out.println(taskcsvdata);
		
		return taskcsvdata;
		
	}
		
		

}

	
