package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commonPackage.BasePage;

public class Guru99HomePage extends BasePage{

	WebElement homeLink = driver.findElement(By.linkText("Home"));
	
	@FindBy (xpath = "//a[text()='Home']/ancestor::tr[@class='mouseOut']/td[1]")
	WebElement td_Home;
	
	
	
	public void checkBGColor() {
		Actions act = new Actions(driver);
	//	act.click(homeLink).build().perform();
		Action builder =act.moveToElement(homeLink).build();
		
		String bgColor = td_Home.getCssValue("background-color");
		
		System.out.println(bgColor);
		
		builder.perform();
		
		bgColor = td_Home.getCssValue("background-color");
		
		System.out.println(bgColor);
		
	}
}
