package com.testtravel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.junit.jupiter.api.Test;

import com.baseclass.Library;
import com.baseclass.Utility;
//import com.excel.excel;
import com.pages.Travelinsurance;

//import excel.Excel;

public class testpolicy extends Library {
	@BeforeTest
	public void start() throws IOException {
		launchApp("chrome", "https://www.policybazaar.com/");
	}

	@Test
	public void testing() throws Throwable {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Travelinsurance pol = new Travelinsurance(driver);
		pol.travelinsurance();
		pol.student();
		pol.destinationclick();
		pol.destinationenter();
		pol.student1();
		pol.student2();
		pol.startdate();
		pol.enddate();
		pol.proceedbutton();
		pol.details();
		pol.getLowestPrices();
		
	}

	@AfterTest

	public void closeapp() {
		Utility screenshot = new Utility(driver);
		screenshot.takeSnapShot("E:\\srikanth\\ecl\\Travelins\\file.png");
	
		driver.quit();
	
	
	}
}