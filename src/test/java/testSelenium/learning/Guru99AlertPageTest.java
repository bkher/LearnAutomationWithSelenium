package testSelenium.learning;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import Pages.Guru99AlertPage;
import commonPackage.BasePage;

public class Guru99AlertPageTest extends BasePage{
	
	@Test (groups = {"test1"})
	public void logwithValidDataTest() throws InvalidFormatException, IOException{
		Guru99AlertPage lp = new Guru99AlertPage();
		lp.handleWindow();
	}
	
}
