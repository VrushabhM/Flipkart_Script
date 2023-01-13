package Flipkar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException
	{
		String Path= "D:\\NewAutomation\\Flipkart\\driver folder\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/account/login");
		driver.manage().window().maximize();
		WebElement MobNo = driver.findElement(By.xpath("//form/following::input[@type=\"text\"]"));
		WebDriverWait wait = new WebDriverWait(driver, null);
		//wait.until(ExpectedConditions.visibilityOf(MobNo));
		MobNo.click();
		MobNo.sendKeys("7758090946");
		WebElement OTP = driver.findElement(By.xpath("//button[text()=\"Request OTP\"]"));
		OTP.click();
	}

}
