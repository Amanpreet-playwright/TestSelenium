import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsFrames {

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
		driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();
		String Parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		Set <String> s=driver.getWindowHandles();
		Iterator<String> i =s.iterator();
		
		while(i.hasNext())
		{
			String child=i.next();
			if(!Parent.equals(child))
			{
				driver.switchTo().window(child);
				System.out.println(driver.getPageSource().toString());
				driver.close();
				driver.switchTo().window(Parent);
			}
		}
driver.findElement(By.xpath("//button[@id='windowButton']")).click();	
String Parent1=driver.getWindowHandle();
Set <String> s1=driver.getWindowHandles();

Iterator<String> i1 =s1.iterator();


while(i1.hasNext())
{

	String child1=i1.next();
	if(!Parent1.equals(child1))
	{
	driver.switchTo().window(child1);
	driver.close();
	driver.switchTo().window(Parent1);
	}
}
	
		
	}

}
