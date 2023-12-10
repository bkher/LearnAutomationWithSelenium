package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import commonPackage.BasePage;
import commonPackage.Utility;

public class Guru99AlertPage extends BasePage{

	/*
	WebElement customerId = driver.findElement(By.name("cusid"));
	WebElement resetButton = driver.findElement(By.name("res"));
	WebElement submitButton = driver.findElement(By.name("submit"));
	*/
	
	
	WebElement clickhere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
	
	
	Utility util = new Utility();
	
	/*
	public void PopupHandle() throws InterruptedException {
		customerId.sendKeys("test check");
		util.clickRadioButton(submitButton);
		
		Alert ale = driver.switchTo().alert();
		String msg = ale.getText();
		System.out.println(msg);
		ale.accept();
		
		util.clickRadioButton(submitButton);
		
		ale.dismiss();
		
		String enteredText=customerId.getText();
		System.out.println(enteredText);
		
		resetButton.click();
		
		util.explicitWaitOnElement(5000, "alertPresent", customerId);
		
		msg=ale.getText();
		System.out.println(msg);
		ale.accept();
		
		Thread.sleep(5000);
		
	}
	*/
	
	public void handleWindow() throws InvalidFormatException, IOException {
		
		util.explicitWaitOnElement(4000, "elementClickable", clickhere);
		util.readDateFromExcel("Sheet1", 1, 1);
		
		clickhere.click();
		
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		
		
		Set<String> set = driver.getWindowHandles();
		
		Iterator<String> it = set.iterator();
		
		while (it.hasNext()) {
			String childWindow = it.next();
			
			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				
				driver.switchTo().window(childWindow);
				
				String pagetitle = driver.getTitle();
				System.out.println(pagetitle);
				WebElement emailField = driver.findElement(By.name("emailid"));
				emailField.sendKeys("Test@mail.com");
				
				driver.close();
			}
			
		}
		
		driver.switchTo().window(mainWindow);
		
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
	}
	
	
	
}
