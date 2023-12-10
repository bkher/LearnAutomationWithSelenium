package testSelenium.learning;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import commonPackage.BasePage;
import commonPackage.Utility;

public class LoginPageTest extends BasePage{
	
	
	@DataProvider (name ="data-provider")
	public Object [][] dpmethod() throws InvalidFormatException, IOException{
		return new Object[][] {
			{utils.readDateFromExcel("SauceDemo", 1, 0),utils.readDateFromExcel("SauceDemo", 1, 1)},
			{utils.readDateFromExcel("SauceDemo", 2, 0),utils.readDateFromExcel("SauceDemo", 2, 1)},
			{utils.readDateFromExcel("SauceDemo", 3, 0),utils.readDateFromExcel("SauceDemo", 3, 1)}
			};
	}
	
	@Test (groups = {"test2"}, dataProvider = "data-provider")
	public void logwithValidDataTest(String username, String password) {
		LoginPage lp = new LoginPage();
		System.out.println(username+"   "+password);
		lp.loginWithValidData(username,password);
		lp.logoutMethod();
	}
	
}
