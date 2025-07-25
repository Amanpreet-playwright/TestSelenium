import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.errorprone.annotations.Var;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

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
	List<WebElement> element=	driver.findElements(By.xpath("//span[contains(text(),'Links')]//parent::li"));
	element.get(0).click();
	String parentwindow=driver.getWindowHandle();
	driver.findElement(By.xpath("//a[contains(text(),'Home')][1]")).click();
	
	Set<String> s=  driver.getWindowHandles();
	
	Iterator<String> I= s.iterator();
	while(I.hasNext())
	{
		String child_window=I.next();
		if(!parentwindow.equals(child_window) )
		{
			driver.switchTo().window(child_window);
			driver.close();
		}
	}
	driver.switchTo().window(parentwindow);
	js.executeScript("window.scrollBy(0,250)", "");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	String ele=	driver.findElement(By.xpath("//strong[contains(text(),'Following links will send an api call')]/parent::h5/following-sibling::p[4]")).getText().toString();

	if(ele.equals("Bad Request"))
	{
		driver.findElement(By.xpath("//strong[contains(text(),'Following links will send an api call')]/parent::h5/following-sibling::p[4]//a[contains(text(),'Bad Request')]")).click();
		System.out.println("hello");

	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//driver.findElement(By.xpath("//a[@id='unauthorized']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
//String resp=driver.findElement(By.xpath("//p[@id='linkResponse']")).getText().toString();
//System.out.println(resp);

		
	}

}
