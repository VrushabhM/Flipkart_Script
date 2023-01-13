package Flipkar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Flipkart_Script {
	public static void main(String[] args) throws InterruptedException {
		String Path= "D:\\NewAutomation\\Flipkart\\driver folder\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement close_login_tab=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close_login_tab.click();
		
		WebElement search_bar = driver.findElement(By.name("q"));
		search_bar.sendKeys("readmi note 11pro");
		
		WebElement search_button = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		search_button.click();

		System.out.println(driver.getTitle());
		String page_title=driver.getTitle();
		if(page_title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		Thread.sleep(5000);
		WebElement selectpricerange = driver.findElement(By.xpath("//span[text()=\"Filters\"]/ancestor::div[3]//div[@class=\"_1YAKP4\"]/select"));
		Select select=new Select(selectpricerange);
		select.selectByValue("15000");
		Thread.sleep(2000);
		WebElement selectpricerange1 = driver.findElement(By.xpath("//span[text()=\"Filters\"]/ancestor::div[3]//div[@class=\"_3uDYxP\"]/select"));
		Select select1=new Select(selectpricerange1);
		select1.selectByValue("20000");
		List<WebElement> listofprice = driver.findElements(By.xpath("//div[@class=\"_30jeq3 _1_WHN1\"]"));
		System.out.println(listofprice.size());
		for(int i=0; i<=listofprice.size()-1;i++)
		{
			String pr = listofprice.get(i).getText();
			pr= pr.replaceAll("₹","");
			pr= pr.replaceAll(",","");
			int j=Integer.parseInt(pr);
			if(j>=1500 && j<=20000)
			{
				System.out.println("Price filter is correct as per applied filter");
			}
			else
			{
				System.out.println("Price filter is incorrect as per applied filter");
			}
		}
		String window = driver.getWindowHandle();
		System.out.println(window);
		driver.switchTo().window(window);
		Thread.sleep(2000);
		WebElement mobilelink = driver.findElement(By.xpath("//a[contains(@href,\"/redmi-note-11-pro-stealth-black-128-gb/p/itm22dabad\")]"));
		mobilelink.click();
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			String Childwindow=it.next();
			if(!window.equals(windows));
			{
				driver.switchTo().window(Childwindow);
			}
		}
		WebElement addtocart = driver.findElement(By.xpath("//button[text()=\"Add to cart\"]"));
		addtocart.click();
		Thread.sleep(2000);
		WebElement placeorder = driver.findElement(By.xpath("//span[text()=\"Place Order\"]"));
		placeorder.click();
		Thread.sleep(8000);
		WebElement inputmobno = driver.findElement(By.xpath("//input[@class=\"_2IX_2- _17N0em\"]"));
		inputmobno.click();
		inputmobno.sendKeys("7758090946");
		
		//due to OTP issue cannot proceed with further script so providing screenshot till this line of execution
		// still further code is executable on flipkart if OTP issue resolves
		
		WebElement continue1 = driver.findElement(By.xpath("//span[text()=\"CONTINUE\"]"));
		continue1.click();
		Thread.sleep(8000);
		WebElement deliverhere = driver.findElement(By.xpath("//button[text()=\"Deliver Here\"]"));
		deliverhere.click();
		WebElement continue2 = driver.findElement(By.xpath("//button[text()=\"CONTINUE\"]"));
		continue2.click();
		WebElement acceptandcontinue = driver.findElement(By.xpath("//button[text()=\"Accept & Continue\"]"));
		acceptandcontinue.click();
		WebElement COD = driver.findElement(By.xpath("//div[text()=\"Cash on Delivery\"]/preceding::div[2]"));
		COD.click();	
	}

}
