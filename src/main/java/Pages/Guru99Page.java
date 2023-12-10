package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPackage.BasePage;
import commonPackage.Utility;

public class Guru99Page extends BasePage{
	
	@FindBy(xpath = "//a[@title='Software Testing']")
	WebElement simpleXpath;
	
	@FindBy(xpath = "//*[contains(text(),'SoapUI')]")
	WebElement textWithContainsXpath;
	
	@FindBy(xpath = "(//ul[contains(@id,'java')])[1]")
	WebElement idWithContainsXpath;
	
	@FindBy(xpath = "//a[text()= 'Software Testing' and @title='Software Testing']")
	WebElement xpathWithAnd;
	
	@FindBy(xpath="//a[text()= 'Software Testing' or @title='Software Testing']")
	WebElement xpathWithOr;
	
	@FindBy(xpath = "//a[starts-with(@title,'Mobile')]")
	WebElement xpathWithStartsWith;
	
	@FindBy(xpath="//a[starts-with(@title,'Mobile')]//following::a[text()='Live Testing Project']")
	WebElement xpathWithFollowing;
	
	@FindBy (xpath = "//a[starts-with(@title,'Mobile')]//ancestor::div/h4/b[text()='Testing']")
	WebElement xpathWithAncestor;
	
	@FindBy (xpath = "//ul[@class='menu']//child::li/a[starts-with(text(),'Soap')]")
	WebElement xpathWithChild;
	
	@FindBy (xpath = "//ul[@id='java_technologies']//preceding::li/a[text()='Flash Movie Demo']")
	WebElement xpathWithPreceding;
	
	@FindBy (xpath = "//ul[@id='java_technologies']//following-sibling::li/a[@title='C#']")
	WebElement xpathWithFollowingSibling;
	
	@FindBy (xpath = "//ul[@id='java_technologies']//parent::li/a[@title='C#']")
	WebElement xpathWithParent;
	
	@FindBy (xpath = "//ul[@id='java_technologies']//self::li/a[@title='C#']")
	WebElement xpathWithSelf;
	
	@FindBy (xpath = "//ul[@id='java_technologies']//descendant::li/a[@title='C#']")
	WebElement xpathWithDescendants;
	
	
	public void getThetextOfXapath() throws IOException {
		System.out.println(xpathWithDescendants.getText());
		
		System.out.println(xpathWithSelf.getText());
		
		System.out.println(xpathWithParent.getText());
		
		System.out.println(xpathWithFollowingSibling.getText());
		
		System.out.println(xpathWithPreceding.getText());
		
		System.out.println(xpathWithChild.getText());
		
		System.out.println(xpathWithAncestor.getText());
		
		System.out.println(xpathWithFollowing.getText());
		
		System.out.println(xpathWithStartsWith.getText());
		
		System.out.println(xpathWithOr.getText());
		
		System.out.println(xpathWithAnd.getText());
		
		System.out.println(idWithContainsXpath.getText());
		
		System.out.println(textWithContainsXpath.getText());

		System.out.println(simpleXpath.getText());
		
		Utility ul = new Utility();
		ul.takeAScreenshot(driver,prop.getProperty("ScreenshotPath"),"Home.png");
		
	}

}
