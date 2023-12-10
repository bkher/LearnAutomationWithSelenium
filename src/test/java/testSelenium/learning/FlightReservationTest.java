package testSelenium.learning;


import java.io.IOException;

import org.testng.annotations.Test;

import Pages.FlightReservationPage;
import commonPackage.BasePage;

public class FlightReservationTest extends BasePage{
	
	@Test (groups = {"test1"} , priority = -3 , dependsOnGroups = {"test2"} )
	public void logwithValidDataTest() throws IOException {
		FlightReservationPage fsp = new FlightReservationPage();
		fsp.selectTripType();
		fsp.selectServiceClass();
		fsp.selectPassnger();
		fsp.selectFromMonthAndDay();
		fsp.selectFromPart();
		fsp.selectToMonthAndDay();
	}	
}
