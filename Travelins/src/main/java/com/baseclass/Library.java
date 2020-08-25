package com.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Library {
	protected WebDriver driver;

	//To launch the browser in required browser
		public void launchApp(String browser, String url) {
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "E:\\srikanth\\ecl\\Travelins\\chromedriver.exe");
					driver = new ChromeDriver();
				} else if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.geckodriver.driver", "E:\\srikanth\\ecl\\Travelins\\geckodriver.exe");
					driver = new FirefoxDriver();
				}

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(url);

			} catch (WebDriverException e) {
				System.out.println("browser couldnot be launched");
			}
		}

	//To close the browser
		public void quit() {
			driver.quit();
		}
	}


