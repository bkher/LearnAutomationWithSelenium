package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPackage.BasePage;

public class LoginPage extends BasePage{

	
	WebElement username = driver.findElement(By.id("user-name"));
	
	WebElement password = driver.findElement(By.id("password"));
	
	@FindBy(xpath = "//input[@data-test='login-button']")
    public WebElement loginButton;
	
	@FindBy(id = "react-burger-menu-btn")
	public WebElement meuButton;
	
	@FindBy(id="logout_sidebar_link")
	public WebElement logoutButton;
	
	
	
	
	
	public void enterUsername(String user) {
		username.isDisplayed();
		username.clear();
		username.sendKeys(user);
	}
	
	public void enterPassword(String pwd) {
		password.isDisplayed();
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.isDisplayed();
		loginButton.click();
	}
	
	
	public void loginWithValidData(String user , String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLoginButton();
	}
	
	public void logoutMethod() {
		if ( driver.findElements(By.xpath("//*[@class='error-message-container error']")).size()!=1) {
			meuButton.click();
			logoutButton.click();
		}
	}

}
