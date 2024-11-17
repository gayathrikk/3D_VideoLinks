package com.gayu.Gayathri;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LLM_Feedback {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4444/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in/");
		driver.manage().window().maximize();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The server is Opened sucessfully");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement viewerSectionLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));
		viewerSectionLink.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Viewer Icon is clicked");
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement login = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
		login.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The login Button is clicked");
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement emailInput = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
		emailInput.sendKeys("softwaretestingteam9@gmail.com");
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("Mail I'd is entered");
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		WebElement Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Next Button is clicked");
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
		System.out.println("--------------------------*****************-----------------------");
		WebElement PasswordInput = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		PasswordInput.sendKeys("Health#123");
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("Password is entered");
		WebDriverWait wait5 = new WebDriverWait(driver, 20);
		WebElement Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next2.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Next Button is clicked");
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
	}
	@Test(priority = 2)
	public void table() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		try {
			WebDriverWait wait6 = new WebDriverWait(driver, 30);
			WebElement search = wait6
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
			search.sendKeys("222\n");
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is not Entered successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement icon = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@icon='info']")));
			icon.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The More info icon is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The More info icon is not clicked");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement feedback = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@icon='feedback']")));
			feedback.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The feedback icon is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The feedback icon is not clicked");
		}
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		// try {
		// 	WebDriverWait wait7 = new WebDriverWait(driver, 30);
		// 	WebElement biosamp = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Input']")));
		// 	biosamp.getText();
		// 	System.out.println("--------------------------*****************-----------------------");
		// 	System.out.println("The getext the biosample id sucessfully");
		// } catch (Exception e) {
		// 	System.out.println("--------------------------*****************-----------------------");
		// 	System.out.println("The can't get biosample id");
		// }
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement Text = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Textarea']")));
			Text.sendKeys("This feedback working well");
			Thread.sleep(3000);
			Text.clear();
			System.out.println("The given text is cleared");
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The given text is Entered");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The given text is not Entered");
		}
		}
//		try {
//			WebDriverWait wait7 = new WebDriverWait(driver, 30);
//			WebElement submit = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
//			submit.click();
//			Thread.sleep(3000);
//			System.out.println("--------------------------*****************-----------------------");
//			System.out.println("The submit button is cliked");
//		} catch (Exception e) {
//			System.out.println("--------------------------*****************-----------------------");
//			System.out.println("The submit button is not cliked");
//		}
		
			}

@AfterTest
public void tearDown() {
	if (driver != null) {
		driver.quit();
	}
}
}
