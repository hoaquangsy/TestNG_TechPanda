package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1 {
	WebDriver driver;
	
	@BeforeTest
	public void BeforeTest() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://live.techpanda.org/");
	}
    @Test
  public void Test() {
	  
	    driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
	    driver.findElement(By.cssSelector("#header-account > div > ul > li.first > a")).click();
	    driver.findElement(By.cssSelector("#login-form > div > div.col-1.new-users > div.buttons-set > a > span > span")).click();
	    driver.findElement(By.cssSelector("#firstname")).sendKeys("Hoa");
	    driver.findElement(By.cssSelector("#middlename")).sendKeys("Quang");
	    driver.findElement(By.cssSelector("#lastname")).sendKeys("Sy");
	    driver.findElement(By.cssSelector("#email_address")).sendKeys("SyH4@gmail.com");
	    driver.findElement(By.cssSelector("#password")).sendKeys("123456");
	    driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
	    driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
	    String nameString=driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div > div > ul > li > ul > li")).getText();
    	String execp="Thank you for registering with Main Website Store.";
    	assertEquals(nameString,execp);
    	
    	driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.last > a")).click();
    	driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(1) > a")).click();
    	driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-share > span > span")).click(); 
    	driver.findElement(By.cssSelector("#email_address")).sendKeys("sy1@gmail.com");
    	driver.findElement(By.cssSelector("#message")).sendKeys("sy1@gmail.com");
    	driver.findElement(By.cssSelector("#form-validate > div.buttons-set.form-buttons > button")).click();
    	String nameString2=driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div > div.my-wishlist > ul > li > ul > li > span")).getText();
    	String execp2="Your Wishlist has been shared.";
    	assertEquals(nameString2,execp2);
    	
  
  }
   @AfterTest
   public void AfterTest() {
		driver.close();
	}
}
