import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoComplete {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[contains(text(),'Widgets')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Auto Complete')]")).click();
	    //js.executeScript("window.scrollBy(0,250)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String[] str={"Red","Green","Pink"};
for(int i=0;i<=str.length;i++)
{
	   driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys(str[i]);
	   driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']")).sendKeys(Keys.ENTER);
}	
	}

}
