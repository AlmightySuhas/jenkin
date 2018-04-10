package jenkin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;

public class WikijUnit {
 
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  @Test
  public void f() {
	  driver.get("http://www.wikipedia.org");
		driver.findElement(By.id("js-link-box-en")).click();
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		driver.findElement(By.id("searchButton")).click();
		String pageTitle=driver.getTitle();
		AssertJUnit.assertEquals("Title test case failed","Selenium - Wikipedia", pageTitle);
		String pageHeading=driver.findElement(By.id("firstHeading")).getText();
		AssertJUnit.assertEquals("Heading test case failed","Selenium", pageHeading);
  }
  @Test
	public void googleTest()
	{
		driver.get("http://www.google.com");
	}
}
