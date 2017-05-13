package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import hello.Application;

import org.testng.annotations.BeforeTest;

public class ApplicationTest {
	public static WebDriver driver;

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Sobhan\\gs-crud-with-vaadin\\initial\\src\\main\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/");
	}

	@BeforeTest
	public void startApp() {
		String[] args = { "" };
		Application.main(args);

	}

}
