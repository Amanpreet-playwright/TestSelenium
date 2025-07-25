import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

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
		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText().toString());
		al.accept();
	List<WebElement> Ele=driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
	for(WebElement e:Ele)
	{
		//Ele.get(2).click();
	//Alert Al=	driver.switchTo().alert();
	//Al.accept();
	//System.out.println(Al.getText().toString());
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Ele.get(3).click();
	driver.switchTo().alert().sendKeys("Amanpreet");
	driver.switchTo().alert().accept();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Ele.get(2).click();
	//driver.switchTo().alert().accept();
	}

	}

}
