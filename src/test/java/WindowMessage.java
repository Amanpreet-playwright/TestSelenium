import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowMessage {

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
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		String Parent=driver.getWindowHandle();
		Set <String> s=driver.getWindowHandles();
		Iterator<String> i =s.iterator();
		
		while(i.hasNext())
		{
			String child=i.next();
			if(!Parent.equals(child))
			{
			driver.switchTo().window(child);
				
				//System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(Parent);
			}
		}
		
	}

}
