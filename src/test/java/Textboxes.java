import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Textboxes {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://demoqa.com/");
driver.manage().window().maximize();
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,250)", "");
driver.findElement(By.xpath("//h5[text()='Elements']")).click();
driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Aman");
driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("amanpreeti@gmail.com");
driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("bdasgdhagf67234532654#7865374563456");
driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("#478674565bvnvsfsdgfsgfsdgfsdg");
driver.findElement(By.xpath("//button[@id='submit']")).click();
}

}
