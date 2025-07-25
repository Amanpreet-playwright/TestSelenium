package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Home {
	public static WebDriver driver;
  @Test(enabled=false)
  public void Execute() {
driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute' and @name='field-keywords']")).sendKeys("Books");
driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and @class='nav-input nav-progressive-attribute']")).click();
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,250)","");
List<WebElement> Ls= driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
 Ls.get(3).click();
  }
  @Test
  public void A()
  {
	  System.out.println("Hello");
  }
  @BeforeMethod
  public void Init() {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();


}

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  
}
/*sequence of execution:-
 * before suite
 * before class
 * before method
 * before test
 * test(alphabetically if multiple tests)
 * after test
 * after method
 * after class
 * after suite
 * 
 * 
 * 
 * 
 *
 */

