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

public class Checkbox {

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
driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
String element=  driver.findElement(By.xpath("//div[@class='display-result mt-4']")).getText();
System.out.print(element);
driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
driver.findElement(By.xpath("//label[contains(text(),'Impressive')]")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Web Tables')]")));
driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
driver.findElement(By.xpath("//span[@id='edit-record-1']")).click();
driver.findElement(By.xpath("//input[@id='firstName']")).clear();
driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Amanp");
driver.findElement(By.xpath("//button[@id='submit']")).click();
js.executeScript("window.scrollBy(0,250)","");
driver.findElement(By.xpath("//option[contains(text(),'10 rows')]")).click();
driver.findElement(By.xpath("//span[@id='delete-record-1']")).click();




}

}
