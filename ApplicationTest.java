package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import hello.Application;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ApplicationTest {

	public static WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Sobhan\\gs-crud-with-vaadin\\initial\\src\\main\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080");
		driver.manage().window().maximize();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[1]/div/div[3]/div")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id='gwt-uid-3']")).sendKeys("sobhan");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='gwt-uid-5']")).sendKeys("inturi");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[5]/div/div[5]/div/div[1]")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[3]/div/div[3]/table/tbody/tr[5]/td[2]"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='ROOT-2521314']/div/div[2]/div[5]/div/div[5]/div/div[3]")).click();

	}

	@BeforeMethod
	public void startApp() {
		String[] args = { "" };
		Application.main(args);

	}

}
