package com.crm.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtils {
	
	public static WebDriver wd =null;
	
	public static void clickButton(String identifiedby, String locator, WebDriver wd){
		
	if(identifiedby.equalsIgnoreCase("id")){
		wd.findElement(By.id(locator)).click();
	}
	
	else if(identifiedby.equalsIgnoreCase("css")){
		wd.findElement(By.cssSelector(locator)).click();
	}
	
	else if(identifiedby.equalsIgnoreCase("name")){
		wd.findElement(By.className(locator)).click();
	}
	
	else if(identifiedby.equalsIgnoreCase("xpath")){
		wd.findElement(By.xpath(locator)).click();
	}
	else if(identifiedby.equalsIgnoreCase("link")){
		wd.findElement(By.linkText(locator)).click();
	}
	}
	
	public static void selectItemFromList(String identifiedBy, String locator, String itemType, String value,WebDriver wd) {

		WebElement element = null;
		if (identifiedBy.equalsIgnoreCase("id")) {
			element = wd.findElement(By.id(locator));
		} else if (identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
		} else if (identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		} else if (identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		} else if (identifiedBy.equalsIgnoreCase("link")) {
			element = wd.findElement(By.linkText(locator));
		} else if (identifiedBy.equalsIgnoreCase("plink")) {
			element = wd.findElement(By.partialLinkText(locator));
		}
		Select se = new Select(element);
		if (itemType.equalsIgnoreCase("value")) {
			se.selectByValue(value);
		} else if (itemType.equalsIgnoreCase("index")) {
			se.selectByIndex(Integer.parseInt(value));
		} else if (itemType.equalsIgnoreCase("text")) {
			se.selectByValue(value);
		}
	}
	public static void insertText(String identifiedby, WebDriver wd, String locator, String value){
		
		if(identifiedby.equalsIgnoreCase("id")){
			wd.findElement(By.id(locator)).sendKeys(value);
		}
		
		else if(identifiedby.equalsIgnoreCase("css")){
			wd.findElement(By.cssSelector(locator)).sendKeys(value);
		}
		
		else if(identifiedby.equalsIgnoreCase("name")){
			wd.findElement(By.className(locator)).sendKeys(value);
		}
		
		else if(identifiedby.equalsIgnoreCase("xpath")){
			wd.findElement(By.xpath(locator)).sendKeys(value);
		}
	}
	
	public static void clickLink(String identifiedby, String locator, WebDriver wd){
		
		if(identifiedby.equalsIgnoreCase("link")){
			wd.findElement(By.linkText(locator)).click();
		}
		
		else if(identifiedby.equalsIgnoreCase("id")){
			wd.findElement(By.id(locator)).click();
		}
		
		else if(identifiedby.equalsIgnoreCase("css")){
			wd.findElement(By.cssSelector(locator)).click();
		}
		
		else if(identifiedby.equalsIgnoreCase("xpath")){
			wd.findElement(By.xpath(locator)).click();
		}
		
		else if(identifiedby.equalsIgnoreCase("name")){
			wd.findElement(By.className(locator)).click();
		}
	}
	
	public static void selectDropdownItem(String identifiedby, WebDriver wd, String locator, String value, String itemType){
		
		WebElement element = null;
		if(identifiedby.equalsIgnoreCase("id")){
			element = wd.findElement(By.id(locator));	
		}
		else if(identifiedby.equalsIgnoreCase("name")){
			element = wd.findElement(By.className(locator));	
		}
		else if(identifiedby.equalsIgnoreCase("css")){
			element = wd.findElement(By.cssSelector(locator));	
		}
		else if(identifiedby.equalsIgnoreCase("xpath")){
			element = wd.findElement(By.xpath(locator));	
		}
		
		Select selobj = new Select(element);
		if(itemType.equals("value")){
			selobj.selectByValue(value);
		}
		else if(itemType.equals("text")){
			selobj.selectByVisibleText(value);
		}
		else if(itemType.equals("index")){
			selobj.selectByIndex(Integer.parseInt(value));
		}
		
	}
	
	public static void waitForElement(String identifiedby, WebDriver wd, String locator){
		if(identifiedby.equalsIgnoreCase("id")){
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		}
		else if(identifiedby.equalsIgnoreCase("name")){
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
		}
		else if(identifiedby.equalsIgnoreCase("xpath")){
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
		else if(identifiedby.equalsIgnoreCase("css")){
			WebDriverWait wait = new WebDriverWait(wd, 50);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		}
	}
	
	public static void clickRadioButton(String identifiedby, WebDriver wd, String locator){
		
		if(identifiedby.equalsIgnoreCase("id")){
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedby.equalsIgnoreCase("name")){
			wd.findElement(By.className(locator)).click();
		}
		else if(identifiedby.equalsIgnoreCase("css")){
			wd.findElement(By.cssSelector(locator)).click();
		}
		else if(identifiedby.equalsIgnoreCase("xpath")){
			wd.findElement(By.xpath(locator)).click();
		}
	}
	
	public static boolean checkIsTextPresent (String verifyText, WebDriver wd){
		boolean isTextPresent = false;
		isTextPresent = wd.getPageSource().contains(verifyText);
		return isTextPresent;
	}
	
	public static void closeAlert(WebDriver wd){
		if(wd.switchTo().alert() != null){
			Alert alert = wd.switchTo().alert();
			alert.accept();
		}
	}
	
	public static void navigateForward(WebDriver wd){
		wd.navigate().forward();	
	}
	
	public static void navigateBackward(WebDriver wd){
		wd.navigate().back();
	}
	
	public static void pageRefresh(WebDriver wd){
		wd.navigate().refresh();
	}
	
	public static void scrollUp(WebDriver wd){
		JavascriptExecutor js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollTo(0, index)");
	}
	
	public static void scrollDown(WebDriver wd){
		JavascriptExecutor js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollTo(0, -index)");
	}
	
	public static String getEditBoxText(String identifiedby, WebDriver wd, String locator){
		if(identifiedby.equalsIgnoreCase("id")){
			return wd.findElement(By.id(locator)).getAttribute("value");
		}
		else if(identifiedby.equalsIgnoreCase("name")){
			return wd.findElement(By.className(locator)).getAttribute("value");
		}
		else if(identifiedby.equalsIgnoreCase("xpath")){
			return wd.findElement(By.xpath(locator)).getAttribute("value");
		}
		else if(identifiedby.equalsIgnoreCase("css")){
			return wd.findElement(By.cssSelector(locator)).getAttribute("value");
		}
		return null;
	}
	
	public static String getText(String identifiedBy, String locator, WebDriver wd){
		
		if(identifiedBy.equalsIgnoreCase("id")){
			return wd.findElement(By.id(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("name")){
			return wd.findElement(By.name(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			return wd.findElement(By.xpath(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("css")){
			return wd.findElement(By.cssSelector(locator)).getText();
		}
		return null;
		
	}
	
	public static void switchToFrame(int index, WebDriver wd){
		wd.switchTo().frame(index);
		
	}
	
	public static void pressEnterKey(String identifiedBy, String locator,String value, WebDriver wd){
		
		if(identifiedBy.equalsIgnoreCase("id")){
			wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
		}
		else if(identifiedBy.equalsIgnoreCase("name")){
			wd.findElement(By.className(locator)).sendKeys(Keys.ENTER);
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			wd.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
		}
		else if(identifiedBy.equalsIgnoreCase("css")){
			wd.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
		}
		
	}
	
	public static void doubleClick(String identifiedBy, WebDriver wd, String locator){
		
		WebElement element = null;
		Actions action = new Actions(wd);
		if(identifiedBy.equalsIgnoreCase("id")){
			element = wd.findElement(By.id(locator));
			action.doubleClick(element).perform();
		}
		else if(identifiedBy.equalsIgnoreCase("css")){
			element = wd.findElement(By.cssSelector(locator));
			action.doubleClick(element).perform();
		}
		else if(identifiedBy.equalsIgnoreCase("name")){
			element = wd.findElement(By.className(locator));
			action.doubleClick(element).perform();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			element = wd.findElement(By.xpath(locator));
			action.doubleClick(element).perform();
		}
		
	}
	
	public static void mouseOverOnElement(String identifiedBy, WebDriver wd, String locator){
		
		WebElement element = null;
		Actions action = new Actions(wd);
		if(identifiedBy.equalsIgnoreCase("linktext")){
			element = wd.findElement(By.linkText(locator));
			action.moveToElement(element).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			element = wd.findElement(By.xpath(locator));
			action.moveToElement(element).click();
		}
		else if(identifiedBy.equalsIgnoreCase("id")){
			element = wd.findElement(By.id(locator));
			action.moveToElement(element).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")){
			element = wd.findElement(By.className(locator));
			action.moveToElement(element).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")){
			element = wd.findElement(By.cssSelector(locator));
			action.moveToElement(element).click();
		}
	}
	
	public static void clearText(String identifiedBy, WebDriver wd, String locator){
		
		if(identifiedBy.equalsIgnoreCase("id")){
			wd.findElement(By.id(locator)).clear();
		}
		else if(identifiedBy.equalsIgnoreCase("name")){
			wd.findElement(By.className(locator)).clear();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			wd.findElement(By.xpath(locator)).clear();
		}
		else if(identifiedBy.equalsIgnoreCase("css")){
			wd.findElement(By.cssSelector(locator)).clear();
		}
	}
	
	public static void dragAndDrop(String identifiedBy, WebDriver wd, String locator){
		
		Actions act = new Actions(wd);
		if(identifiedBy.equalsIgnoreCase("id")){
		WebElement drag = wd.findElement(By.id(locator));
		WebElement drop = wd.findElement(By.id(locator));
		act.dragAndDrop(drag, drop).build().perform();
			}
		else if(identifiedBy.equalsIgnoreCase("name")){
			WebElement drag = wd.findElement(By.className(locator));
			WebElement drop = wd.findElement(By.className(locator));
			act.dragAndDrop(drag, drop).build().perform();
				}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			WebElement drag = wd.findElement(By.xpath(locator));
			WebElement drop = wd.findElement(By.xpath(locator));
			act.dragAndDrop(drag, drop).build().perform();
				}
		else if(identifiedBy.equalsIgnoreCase("css")){
			WebElement drag = wd.findElement(By.cssSelector(locator));
			WebElement drop = wd.findElement(By.cssSelector(locator));
			act.dragAndDrop(drag, drop).build().perform();
				}
			
		}
	
	public static void selectCheckBox(String identifiedBy, WebDriver wd, String locator){
//		List<WebElement> list = wd.findElements(By.name(locator));
//		int count = list.size();
//		for(int i=0;i<count;i++){
//			String svalue = list.get(i).getAttribute("value");
//			if(svalue.equalsIgnoreCase("name")){
//				list.get(i).click();
//			}
//		}
		
		WebElement checkbox = wd.findElement(By.cssSelector(locator));
		checkbox.click();
		
	}
	
	public static ArrayList<String> getItemsFromList(String identifiedBy, String locator, WebDriver wd){
		ArrayList<String> listitems = new ArrayList<String>();
		if(identifiedBy.equalsIgnoreCase("id")){
		 List<WebElement> options = wd.findElements(By.id(locator));
		 for(int i=0;i<options.size();i++){
			listitems.add(options.get(i).getText());
		 }
		}
		 else if(identifiedBy.equalsIgnoreCase("name")){
			 List<WebElement> options = wd.findElements(By.className(locator));
			 for(int i=0;i<options.size();i++){
				 listitems.add(options.get(i).getText());
			 }
		}
		 else if(identifiedBy.equalsIgnoreCase("xpath")){
			 List<WebElement> options = wd.findElements(By.xpath(locator));
			 for(int i=0;i<options.size();i++){
				 listitems.add(options.get(i).getText());
			 }
		}
		 else if(identifiedBy.equalsIgnoreCase("css")){
			 List<WebElement> options = wd.findElements(By.cssSelector(locator));
			 for(int i=0;i<options.size();i++){
				 listitems.add(options.get(i).getText());
			 }
		}
		 else if(identifiedBy.equalsIgnoreCase("link")){
			 List<WebElement> options = wd.findElements(By.linkText(locator));
			 for(int i=0;i<options.size();i++){
				 listitems.add(options.get(i).getText());
			 }
		}
		return listitems;
	}
	
	public static void getAllOptionsDataFromDropDown(String identifiedBy, String locator, WebDriver wd){
		if(identifiedBy.equalsIgnoreCase("id")){
		Select se = new Select(wd.findElement(By.id(locator)));
		se.getOptions();
		}
		else if(identifiedBy.equalsIgnoreCase("name")){
			Select se = new Select(wd.findElement(By.className(locator)));
			se.getOptions();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")){
			Select se = new Select(wd.findElement(By.xpath(locator)));
			se.getOptions();
		}
		else if(identifiedBy.equalsIgnoreCase("css")){
			Select se = new Select(wd.findElement(By.cssSelector(locator)));
			se.getOptions();
		}
	}
	
	public static boolean isElementPresent(String identifiedBy, String locator, WebDriver wd){
		WebElement element = null;
		boolean elementavailable = true;
		if(identifiedBy.equalsIgnoreCase("id")){
		try{
			element=wd.findElement(By.id(locator));
			}
		
		catch(Exception e){
		 elementavailable = false;
			e.printStackTrace();
		}
		return elementavailable;
		
	}
	else if(identifiedBy.equalsIgnoreCase("css")){
		try{
			element=wd.findElement(By.cssSelector(locator));
			}
		
		catch(Exception e){
		 elementavailable = false;
			e.printStackTrace();
		}
		return elementavailable;
		
	}
		return elementavailable;
	}
	
	public static void wait(int timeout) throws InterruptedException{
		int timeoutval = timeout * 1;
		for(int second = 0; second < timeoutval; second++){
			Thread.sleep(1000);
		}
	}
	
	public static void takeScreenShot(WebDriver wd){
		try{
			int count = 0;
			String newFileNamePath;
			File directory = new File(".");
			DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa");
			Date date = new Date();
			
			newFileNamePath = directory.getCanonicalPath()+"\\ScreenShots\\" + dateformat.format(date)+ "_" + ".png";
			BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(968, 1009));
			
			File file = new File(newFileNamePath);
			ImageIO.write(screencapture, "png", file);
			count ++;
			File screenshot = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(newFileNamePath));
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
	
