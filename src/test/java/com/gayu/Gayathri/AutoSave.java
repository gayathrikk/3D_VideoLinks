


package com.gayu.Gayathri;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoSave {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4443/wd/hub");
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
			WebElement table1 = wait6
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
			table1.sendKeys("AuTest\n");
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is not Entered successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement table2 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
			table2.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Altas Editor is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Editor is not clicked");
		}
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	@Test(priority = 3)
	public void contributor() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).build().perform();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Action Pressing *m* executed successfully!");

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error executing action: " + e.getMessage());
		}
		try {
			WebDriverWait wait6 = new WebDriverWait(driver, 30);
			WebElement contri = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(" //nb-accordion-item-header[text()='Contributors']")));
			contri.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Our contributor selected Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Our Contributor   is not selected");
		}
	try {
		WebDriverWait wait6 = new WebDriverWait(driver, 30);
		WebElement radio = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]")));
		radio.click();
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The software Team contributor is selected Successfully");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The software Team contributor is  not selected");
	}
	
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.SHIFT).sendKeys("o").keyUp(Keys.SHIFT).build().perform();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Action Pressing *O* executed successfully!");

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error executing action: " + e.getMessage());
		}
//		try {
//		    // Sleep for 5 minutes (300,000 milliseconds)
//		    Thread.sleep(300000);
//		} catch (InterruptedException e) {
//		    // Handle interrupted exception if needed
//		    e.printStackTrace();
//		}

	
	
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		Thread.sleep(3000);
		WebElement annotation = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()='Annotation']")));
		Thread.sleep(3000);
		annotation.click();

		System.out.println("-------------------------------------------------");
		System.out.println("The annotation icon is clicked");

	} catch (Exception e) {
		System.out.println("The annotation icon is not clicked");
	}

	try {
		Actions actions = new Actions(driver);

		Thread.sleep(3000);
		actions.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build().perform();
		Thread.sleep(3000);
		System.out.println("-------------------------------------------------");
		System.out.println("Action executed successfully!");

	} catch (NoSuchElementException e) {
		System.out.println("Element not found: " + e.getMessage());
	} catch (Exception e) {
		System.out.println("Error executing action: " + e.getMessage());
	}
//	try {
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
//		search.click();
//		Thread.sleep(3000);
//		System.out.println("-------------------------------------------------");
//		System.out.println("The search icon is clicked");
//	} catch (Exception e) {
//		System.out.println("The search icon is not clicked");
//	}

	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement present = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@role='presentation'])[1]")));
		Thread.sleep(3000);
		present.click();
		Thread.sleep(3000);

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The presentation has clicked");

	} catch (Exception e) {
		System.out.println("The presentation name has not clicked");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='20']")));
		Thread.sleep(3000);
		id.click();
		Thread.sleep(3000);

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Central Sulcus name has clicked");

	} catch (Exception e) {
		System.out.println("The Central Sulcus name has not clicked");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add']")));
		Thread.sleep(3000);
		add.click();
		Thread.sleep(3000);

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Add icon has clicked");

	} catch (Exception e) {
		System.out.println("The Add icon has not clicked");
	}
	WebElement canvas = driver.findElement(By.xpath("//canvas"));
	Actions actions = new Actions(driver);
	actions.moveToElement(canvas).click().moveByOffset(200, 0).click().moveByOffset(0, 200).click()
			.moveByOffset(-200, 0).click().moveByOffset(0, -200).click().release().perform();
	// Wait for visualization (optional)
	Thread.sleep(5000);
	driver.navigate().refresh();
	Thread.sleep(5000);

	}
	
	
//	try {
//	    Thread.sleep(4 * 60 * 1000); // 3 minutes wait
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}
//	 
//	}
//	try {
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//
//		// Click on the annotation icon
//		WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes']")));
//		Thread.sleep(3000);
//		save.click();
//		Thread.sleep(3000);
//
//		System.out.println("--------------------------*****************-----------------------");
//		System.out.println("The Yes button has clicked");
//
//	} catch (Exception e) {
//		System.out.println("The Yes button has not clicked");
//	}
//}
//	


	


	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}