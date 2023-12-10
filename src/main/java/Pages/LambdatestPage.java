package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPackage.BasePage;

public class LambdatestPage extends BasePage{

	@FindBy(xpath = "//a[text()='Table Data Search']")
	WebElement tableDataSearchLink;
	
	@FindBy(id = "task-table-filter")
	WebElement taskTableFilter;
	
	
	public void ClickTableSearchLink() {
		tableDataSearchLink.click();
		
	}
	
	public void EnterFilterKeyword(String Keyword) {
		taskTableFilter.clear();
		taskTableFilter.sendKeys(Keyword);
	}
	
	public void nevogationBack() {
		driver.navigate().back();
	}
	
	public void filterKeywordBox() {
		driver.findElement(By.id("task-table-filter"));
	}
	
}
