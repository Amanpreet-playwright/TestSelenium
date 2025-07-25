import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
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
		driver.findElement(By.xpath("//span[contains(text(),'Broken Links - Images')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Click Here for Broken Link')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String str= driver.getTitle().toString();
		System.out.println(str);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().back();
		
		
		
		
		
	}

}
