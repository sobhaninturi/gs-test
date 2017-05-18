package pac;

import java.util.ArrayList;
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

			ArrayList array1 = new ArrayList();
			array1.add("sobhan");
			array1.add("praveen");
			array1.add("kumar");
			ArrayList array2 = new ArrayList();
			array2.add("inturi");
			array2.add("billampati");
			array2.add("mallavarapu");
			System.out.println(array1);
			System.out.println(array2);

			driver.findElement(By.xpath("//*[@id='gwt-uid-" + x + "']")).sendKeys(array1);

			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='gwt-uid-" + (x + 2) + "']")).sendKeys("inturi");
			x = x + 4;
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[5]/div/div[5]/div/div[1]")).click();
		}
		Thread.sleep(4000);
		WebElement table = driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]"));
		// *[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]-this is one xpath
		// *[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]/table/tbody/tr

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Assert.assertEquals(8, rows.size());

		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cell = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < cell.size(); j++)

			{

				String x1 = cell.get(j).getText();
				System.out.println(x1);

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
