package testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver.exe\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com/");
		System.out.println("Title of page" + driver.getTitle());
		String amount;
		String fdurations;
		driver.findElement(By.className("more-arr")).click();
		driver.findElement(By.xpath("//*[text()='Adventures']")).click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Destinations']"))).build().perform();
		driver.findElement(By.linkText("Andaman")).click();
		List<WebElement> lists = driver.findElements(By.xpath("//div[@class='price-container']/span[2]"));
		for (WebElement list : lists) {
			if (list.getText().equalsIgnoreCase("72,000")) {
				amount = list.getText();
				System.out.println(amount);
			}
		}
		// String title = driver.findElement(By.linkText("Scuba Diving Course in
		// Andaman, Ind")).getText();
		String title = driver.findElements(By.xpath("//a[text()='Scuba Diving Course in Andaman, Ind']")).get(1)
				.getText();
		System.out.println(title);
		List<WebElement> durations = driver.findElements(By.xpath("//div[@class='duration-container']/span[2]"));
		for (WebElement duration : durations) {

			if (duration.getText().equalsIgnoreCase("7 Days")) {
				fdurations = duration.getText();
				System.out.println(fdurations);
			}

		}
		driver.findElements(By.cssSelector("[class='submit-query-link'] ")).get(1).click();
		String amount2 = driver.findElement(By.xpath("//div[@class='trip-banner-title-inner']//span[2]")).getText();
		String durations2 = driver.findElements(By.xpath("//div[@class='trip-banner-title-inner']//span")).get(6)
				.getText();
		String title2 = driver.findElement(By.cssSelector("[class='trip-banner-title-head']")).getText();

		Assert.assertEquals("title", "title2");
		Assert.assertEquals("amount", "amount2");
		Assert.assertEquals("fdurations", "durations2");

	}

}
