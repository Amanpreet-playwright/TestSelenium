import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uploads {
	
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
		driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Download')]")).click();
		File uploadfile = new File("/home/amanpreet.kaur/Downloads/Holidays.pdf");
		WebElement file= driver.findElement(By.xpath("//input[@id='uploadFile']"));
		file.sendKeys(uploadfile.getAbsolutePath());
		driver.findElement(By.xpath("//input[@id='uploadFile']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
		
		
			
	}

}
