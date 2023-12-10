package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPackage.BasePage;
import commonPackage.Utility;

public class FlightReservationPage extends BasePage{
	
	@FindBy (xpath = "//input[@value='roundtrip' or contains(text(),'Round Trip')]")
	WebElement roundTrip;
	
	@FindBy (xpath = "//input[@value='oneway' or contains(text(),'One Way')]")
	WebElement oneWayTrip;
	
	WebElement passengers = driver.findElement(By.name("passCount"));
	
	WebElement fromMonth = driver.findElement(By.name("fromMonth"));
	
	WebElement fromDay = driver.findElement(By.name("fromDay"));
	
	WebElement fromPart = driver.findElement(By.name("fromPort"));
	
	WebElement toMonth = driver.findElement(By.name("toMonth"));
	
	WebElement toDay = driver.findElement(By.name("toDay"));
	
	@FindBy (xpath = "//input[@type='radio' and @value='Business']")
	WebElement serviceClass;
	
	Utility util = new Utility();
	
	
	public void selectTripType() throws IOException {
		util.clickRadioButton(oneWayTrip);
		util.takeAScreenshot(driver,prop.getProperty("ScreenshotPath"),"FlightReservationPage.png");
	}
	
	public void selectServiceClass() {
		util.clickRadioButton(serviceClass);
	}
	
	public void selectPassnger() {
		
		util.dropDownSelection(passengers,"value", "2");
	}
	
	public void selectFromMonthAndDay() {
		
		util.dropDownSelection(fromMonth, "text", "February");
		
		util.dropDownSelection(fromDay,"value", "15");
	}
	
	public void selectFromPart() {
	
		util.dropDownSelection(fromPart, "text", "Sydney");
		
	}
	
	public void selectToMonthAndDay() {
		
		util.dropDownSelection(toMonth, "value", "11");
		
		util.dropDownSelection(toDay, "text", "15");
	}

}
