package one.neobank.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {

	@Test

	public void loginTest() {

		System.out.println("Start loginTest");

//		 Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		open test page
		String url = "https://web.neobank.one";
		driver.get(url);
		System.out.println("Page is oprned.");

//		Check the name of the tab "NEOBANK для бізнесу"
		String checkTitle = driver.getTitle();	
		String expectedTitle = "NEOBANK для бізнесу";
		String actualTitle = checkTitle;
		Assert.assertTrue(actualTitle.contains(expectedTitle), 
				"Actual title does not contain expected title.\nActual Message: " + actualTitle
				+ "\nExpected Message: " + expectedTitle);


//		sleep for 9 seconds
		sleep(9000);

//		Enter phone number +380636901677 
		WebElement phone = driver.findElement(By.id("login"));
		phone.sendKeys("636901677");


//		click «Продовжити» button
		WebElement logInButton = driver.findElement(By.id("btnNext"));
		logInButton.click();

//		maximize browser window
		driver.manage().window().maximize();

//		sleep for 6 seconds
		sleep(6000);

//		check that the text "Відкриття бізнес-рахунку можливе тільки через NEOBANK для бізнесу" is displayed on the screen
		WebElement checkText = driver.findElement(By.xpath("//div[@class='auth-form-title']"));
		String expectedText = "Відкриття бізнес-рахунку можливе тільки через додаток NEOBANK для бізнесу";
		String actualText = checkText.getText();
		Assert.assertTrue(actualText.contains(expectedText), "Actual text dos not cotain text");

//		Close browser
		driver.quit();

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
