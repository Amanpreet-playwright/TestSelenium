import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
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
		driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='doubleClickBtn']")));
		Actions act=new Actions(driver);
		WebElement elements= driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		System.out.println(elements.getText());
		act.doubleClick(elements).perform();
		act.doubleClick(elements).perform();
		//System.out.println("Double click operation performed");
		elements=driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		act.contextClick(elements).perform();
		driver.findElement(By.xpath("//div[@class='mt-4'][2]")).click();
	
	
	}

}
