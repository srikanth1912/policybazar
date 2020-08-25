package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.Library;
import com.baseclass.excel;

//import baseclass.Baseclass;

public class Travelinsurance extends Library {
	WebDriver driver;
	
	

	By clickotherinsurance =By.xpath("//a[contains(text(),'Other Insurance')]");
	By clickstudent =By.xpath("//a[contains(text(),'Student')]");
	
	By clickdestination=By.xpath("//input[@id='destination-autocomplete']");

	By clickstudent1 =By.xpath("//input[@placeholder='Student 1']");
	By clickstudent2= By.xpath("//input[@placeholder='Student 2']");
	By startBox = By.xpath("//input[@class='date_at']");
	By endBox = By.xpath("//input[@class='date_to']");
	By yearSelect = By.xpath("//div[@class='drp-calendar left single']//select[@class='yearselect']");
	By MonthSelect = By.xpath("//div[@class='calendar-table']//select[@class='monthselect']");
	By calendarstartRows = By.xpath("//*[@id=\"navigatorType\"]/body/div[6]/div[2]/div[1]/table/tbody/tr");
	By calendarEndRows = By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/tbody/tr");
    By proceedButton = By.xpath("//a[@class='proceedButton']");
	By gender=By.xpath("//*[@id=\"travelgender\"]/option[2]");
    By text_name=By.id("travelname");
	By text_number=By.id("travelmobile");
	By text_mail=By.id("travelemail");
	By getQuotes = By.xpath("//a[@class='proceedButton travelproceed']");
	By lowtohigh = By.xpath("//*[@id=\"mainView\"]/div[2]/div[7]/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div[2]/select");

	

	public Travelinsurance(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public void travelinsurance() {
		driver.findElement(clickotherinsurance).click();
	}

	public void student() {
		driver.findElement(clickstudent).click();

	}
	public void destinationclick() {
		driver.findElement(clickdestination).click();

	}

	public void destinationenter() {
		
			driver.findElement(clickdestination).sendKeys("Nepal");
			driver.findElement(clickdestination).sendKeys(Keys.ENTER);

	}
	  

	public void student1() {
		driver.findElement(clickstudent1).sendKeys("20");

	}

	public void student2() {
		driver.findElement(clickstudent2).sendKeys("22");

	}

	public void startdate() {
		driver.findElement(startBox).click();
		Select sel1 = new Select(driver.findElement(yearSelect));
		sel1.selectByVisibleText("2020");
		Select sel = new Select(driver.findElement(MonthSelect));
		sel.selectByVisibleText("Sep");

		
		List<WebElement> lis = driver.findElements(calendarstartRows);
		int rows = lis.size();
		
		for(int i=1;i<=rows;i++)
		{
			List<WebElement> list = driver.findElements(By.xpath("//*[@id='navigatorType']/body/div[6]/div[2]/div[1]/table/tbody/tr["+i+"]/td"));
			int cols = list.size();
			for(int j=1;j<=cols;j++)
			{
				WebElement text = driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[6]/div[2]/div[1]/table/tbody/tr["+i+"]/td["+j+"]"));
				if(text.getText().equals("8")) {
					text.click();
					break;
				}
			}
		}
		}
       public void enddate() {	
    	   driver.findElement(endBox).click();
    	   Select sel3 = new Select(driver.findElement(yearSelect));
   		sel3.selectByVisibleText("2020");
   		Select sel2 = new Select(driver.findElement(MonthSelect));
   		sel2.selectByVisibleText("Sep");

   		
   		List<WebElement> lis1 = driver.findElements(calendarEndRows);
   		int rows1 = lis1.size();
   		
   		for(int i=1;i<=rows1;i++)
   		{
   			List<WebElement> list = driver.findElements(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/tbody/tr["+i+"]/td"));
   			int cols = list.size();
   			for(int j=1;j<=cols;j++)
   			{
   				WebElement text = driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/tbody/tr["+i+"]/td["+j+"]"));
   				if(text.getText().equals("15")) {
   					text.click();
   					break;
   				}
   			}
   		}
      }
       public void proceedbutton() {
    	   driver.findElement(proceedButton).click();
       }

       public void details() {
	    driver.findElement(text_name).sendKeys("srikanth");
	driver.findElement(gender).click();
	driver.findElement(text_number).sendKeys("7075031830");
	driver.findElement(text_mail).sendKeys("nooksrikanth143@gmail.com");
	driver.findElement(getQuotes).click();
	}
      public void getLowestPrices() throws InterruptedException
      {
	excel eu=new excel();
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.presenceOfElementLocated(lowtohigh));
	Select s1 = new Select(driver.findElement(lowtohigh));
	s1.selectByVisibleText("Low to High");
	Thread.sleep(1000);
	String[] str = new String[3];
	str[0] = driver.findElement(By.xpath("//*[@id=\"219\"]/span")).getText();
	str[1] = driver.findElement(By.xpath("//*[@id=\"111\"]/span")).getText();
	str[2] = driver.findElement(By.xpath("//*[@id=\"18\"]/span")).getText();
	eu.writeToExcel(str);
	
}
}


