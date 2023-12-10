package Pages;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPackage.BasePage;
import commonPackage.Utility;

public class GooglePage extends BasePage {

	public Utility utils = new Utility();

	WebElement searchBox = driver.findElement(By.id("APjFqb"));

	public void searchKeyword(String keyWord) throws IOException {
		searchBox.isDisplayed();
		driver.navigate().refresh();
		
		try {
			searchBox.sendKeys(keyWord);
		} catch (StaleElementReferenceException e) {
			WebElement searchBox = driver.findElement(By.id("APjFqb"));
			searchBox.sendKeys(keyWord);
			searchBox.sendKeys(Keys.ENTER);
			utils.takeAScreenshot(driver, prop.getProperty("ScreenshotPath"), getRandomString(keyWord));
		}
		
		
	}
	
	
	public void solutionOfStaleElement(String keyWord) {
		
		searchBox.isDisplayed();
		driver.navigate().refresh();
		
		try {
			searchBox.sendKeys(keyWord);
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			new WebDriverWait(driver, Duration.ofSeconds(10))
			.ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(By.id("APjFqb")));
			driver.findElement(By.id("APjFqb")).sendKeys(keyWord);
		}
		
		
		
	}

	public String getRandomString(String prefix) {
		Random random = new SecureRandom();
		return prefix +" "+ random.nextInt(999999) +".png";
	}
}
