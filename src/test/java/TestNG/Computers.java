package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Computers {
	public static WebDriver driver;

  @Test(priority=1)
  public void Execute() throws Exception {
	  Thread.sleep(10);
List<WebElement> Ls=driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
for(WebElement L:Ls)
{
	if(L.getText().equals("Electronics"))
	{

		L.click();
		driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute' and @name='field-keywords']")).sendKeys("Electronics");
		
		}}

	//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30)) hi;
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nav-search-submit-button' and @class='nav-input nav-progressive-attribute']")));
	try {
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-button")));
	driver.findElement(By.id("nav-search-submit-button")).click();
	//driver.findElement(By.xpath("")).click();
	}
	catch(StaleElementReferenceException e)
	{
		driver.navigate().refresh();
		driver.findElement(By.id("nav-search-submit-button")).click();

		
	}
	
	
			
}
  @Test(priority=0)
  public void A()
  {
	  System.out.println("hello");
  }
	
  
  @BeforeMethod
  public void Init() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterexecute() {
	  driver.close();
	  
  }

}
