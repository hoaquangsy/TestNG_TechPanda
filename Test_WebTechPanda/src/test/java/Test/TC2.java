package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.sym.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2 {
	WebDriver driver;
	
 	
	
  @BeforeTest
  public void BeforeTest() {

	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://live.techpanda.org/");
	    driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
	    driver.findElement(By.cssSelector("#header-account > div > ul > li.first > a")).click();
	    driver.findElement(By.cssSelector("#login-form > div > div.col-1.new-users > div.buttons-set > a > span > span")).click();
	    driver.findElement(By.cssSelector("#firstname")).sendKeys("Hoa");
	    driver.findElement(By.cssSelector("#middlename")).sendKeys("Quang");
	    driver.findElement(By.cssSelector("#lastname")).sendKeys("Sy");
	    driver.findElement(By.cssSelector("#email_address")).sendKeys("SyH124567@gmail.com");
	    driver.findElement(By.cssSelector("#password")).sendKeys("123456");
	    driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
	    driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

    	
    	driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.last > a")).click();
    	driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(1) > a")).click();
    	driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-share > span > span")).click(); 
    	
    	
  }
	
  @Test(dataProvider = "name")
  public void f(String email, String mess) {
	  driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
  	driver.findElement(By.cssSelector("#message")).sendKeys(mess);
  	driver.findElement(By.cssSelector("#form-validate > div.buttons-set.form-buttons > button")).click();
  	String nameString2=driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div > div.my-wishlist > ul > li > ul > li > span")).getText();
  	String execp2="Your Wishlist has been shared.";
  	assertEquals(nameString2,execp2);
  	driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-share > span > span")).click(); 
  	
  }
  @Test
  public void ngoaiLe() {
	  driver.findElement(By.cssSelector("#email_address")).sendKeys("aaaa@gmail.com");
	  	driver.findElement(By.cssSelector("#message")).sendKeys("11111");
	  	driver.findElement(By.cssSelector("#form-validate > div.buttons-set.form-buttons > button")).click();
	  	String nameString2=driver.findElement(By.cssSelector("body > div > div > div.main-container.col2-left-layout > div > div.col-main > div > div.my-wishlist > ul > li > ul > li > span")).getText();
	  	String execp2="Your Wishlist has been shared.NgoaiLe";
	  	try {
	  		assertEquals(nameString2,execp2);
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  
  @DataProvider(name = "name")
  public Object [][] sendemail() {
	  return new Object[][] {
		  {"sy1@gmail.com", "1"},
		  {"sy2@gmail.com", "2"},
		  {"sy3@gmail.com", "3"},
		  {"sy4@gmail.com", "4"},
		  {"sy5@gmail.com", "5"},

	  };
	  }
  @AfterTest
  public void AfterTest() {
	  driver.close();
  }
}
