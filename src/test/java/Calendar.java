import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

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
		driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
		//driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//List<WebElement> Ls=driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));
	   // for(WebElement E:Ls)
	   // {
	    	//if(E.getText().equals("28"))
	    		//E.click();
	    //}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
	   // System.out.println(System.currentTimeMillis());
		//js.executeScript("window.scrollBy(0,250)","");
		DateFormat date= new SimpleDateFormat("dd");
		Date currentdate=new Date();
		String current=date.format(currentdate);
		System.out.println(current);
		
driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']")).click();
List<WebElement> Ele=driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));
for(WebElement E:Ele)
{
	if(E.equals(current))
	{
		E.click();
	}
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

List<WebElement> Es=driver.findElements(By.xpath("//ul[@class='react-datepicker__time-list']/li"));
for(WebElement ET:Es)
{
	if(ET.equals(System.currentTimeMillis()))
	{
		ET.click();
	}
}

}

}
