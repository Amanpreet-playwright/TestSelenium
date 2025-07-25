import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeForm {
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
		driver.findElement(By.xpath("//div[contains(text(),'Forms')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       js.executeScript("window.scrollBy(0,800)", "");
	//Select dropdown= new Select(driver.findElement(By.xpath("")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.findElement(By.xpath("//div[@id='state']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
List <WebElement> ele=driver.findElements(By.xpath("//div[@tabindex='-1']"));
//System.out.println(ele.size());
for(WebElement e:ele)
{
	ele.get(1).click();
}
		
	



	
	}

}
