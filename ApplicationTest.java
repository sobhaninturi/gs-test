package pac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import hello.Application;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ApplicationTest {
	int i;

	public static WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Sobhan\\gs-crud-with-vaadin\\initial\\src\\main\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		int x = 3;
		for (i = 0; i <= 1; i++) {
			driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[1]/div/div[3]/div")).click();
			Thread.sleep(4000);

			// i=0, id=3
			// i=1, id =7
			// i =2, id = 11
			// i=3, id = 15
			driver.findElement(By.xpath("//*[@id='gwt-uid-" + x + "']")).sendKeys("sobhan");

			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='gwt-uid-" + (x + 2) + "']")).sendKeys("inturi");
			x = x + 4;
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[5]/div/div[5]/div/div[1]")).click();
		}
		Thread.sleep(4000);
		WebElement table = driver
				.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]/table/tbody/tr"));
		//*[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]-this is one xpath

		List<WebElement> rows = table.findElements(By.tagName("td"));

		for (int rnum = 0; rnum < rows.size(); rnum++)

		{

			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("tr"));

			for (int cnum = 0; cnum < columns.size(); cnum++)

			{
				String x1 = rows.get(rnum).getText();

				System.out.println(x1);

				Assert.assertEquals(7, x1);

			}

		}

	}

	// Thread.sleep(4000);
	// driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]/table/tbody/tr[5]/td[2]"))
	// .click();
	// Thread.sleep(4000);
	// driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[5]/div/div[5]/div/div[3]")).click();

	@BeforeTest
	public void startApp() {
		String[] args = { "" };
		Application.main(args);

	}

}
