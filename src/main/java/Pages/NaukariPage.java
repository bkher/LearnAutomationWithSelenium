package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.BaseClassFinder;

import commonPackage.BasePage;
import commonPackage.Utility;

public class NaukariPage extends BasePage{
	
	@FindBy(xpath = "//*[@title='Naukri FastForward- Resume Services']")
	public WebElement service;
	
	@FindBy(xpath = "//*[@title='Text resume']")
	public WebElement textResume;
	
	
	
	public void mouseHoverAndClick() {
		Utility utils =  new Utility();
		utils.testWithActionClass("moveToElement",service);
		
		utils.testWithActionClass("click",textResume);
		
		
		utils.swtichingBetweenWindoes(getDriver());
	}

}
