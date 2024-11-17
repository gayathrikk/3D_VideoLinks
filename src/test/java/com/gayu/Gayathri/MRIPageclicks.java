package com.gayu.Gayathri;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertArrayEquals;

import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration; // Correct import for Duration

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class MRIPageclicks {
    private RemoteWebDriver driver;


	 @BeforeTest
	    public void setup() throws MalformedURLException {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.20.23.92:4444/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	    }

	    @Test(priority = 1)
	    public void testSanity() throws InterruptedException {
	        driver.get("https://brainportal.humanbrain.in/");
	        driver.manage().window().maximize();
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentURL);
	    }

	    @Test(priority = 2)
	    public void Videovalidate() {
	    	try {
	    		WebDriverWait wait = new WebDriverWait(driver, 30);
	    		WebElement v1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoLink1']")));
	    		v1.click();
	    		Thread.sleep(3000);
	    		System.out.println("--------------------------*****************-----------------------");
	    		System.out.println("The 3d Vido 1 Click Successfully");
	    		} catch (Exception e) {
	    		System.out.println("--------------------------*****************-----------------------");
	    		System.out.println("The 3d Vido 1 is not Click");
	    		}
	    	driver.findElement(By.xpath("//button[@id='closeButton']")).click();
	        
	    try {
    		WebDriverWait wait = new WebDriverWait(driver, 30);
    		WebElement v2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoLink2']")));
    		v2.click();
    		Thread.sleep(3000);
    		System.out.println("--------------------------*****************-----------------------");
    		System.out.println("The 3d Vido 2 Click Successfully");
    		} catch (Exception e) {
    		System.out.println("--------------------------*****************-----------------------");
    		System.out.println("The 3d Vido 2 is not Click");
    		}
    	driver.findElement(By.xpath("//button[@id='closeButton']")).click();
    	
   
	    try {
    		WebDriverWait wait = new WebDriverWait(driver, 30);
    		WebElement v3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoLink3']")));
    		v3.click();
    		Thread.sleep(3000);
    		System.out.println("--------------------------*****************-----------------------");
    		System.out.println("The 3d Vido 3 Click Successfully");
    		} catch (Exception e) {
    		System.out.println("--------------------------*****************-----------------------");
    		System.out.println("The 3d Vido 3 is not Click");
    		}
    	driver.findElement(By.xpath("//button[@id='closeButton']")).click();
    	
      try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement v4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoLink4']")));
		v4.click();
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The 3d Vido 4 Click Successfully");
		} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The 3d Vido 4 is not Click");
		}
	driver.findElement(By.xpath("//button[@id='closeButton']")).click();
	
   try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement v5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoLink5']")));
	v5.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The 3d Vido 5 Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The 3d Vido 5 is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();

  try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement a1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videoaxial'])[1]")));
	a1.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 1 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 1 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();

 try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement a2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videoaxial'])[2]")));
	a2.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 2 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 2 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement a3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videoaxial'])[3]")));
	a3.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 3 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 3 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement a4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videoaxial'])[4]")));
	a4.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 4 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Axial 4 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
//try {
//	WebDriverWait wait = new WebDriverWait(driver, 30);
//	WebElement a5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videoaxial'])[5]")));
//	a5.click();
//	Thread.sleep(3000);
//	System.out.println("--------------------------*****************-----------------------");
//	System.out.println("The Axial 5 video Click Successfully");
//	} catch (Exception e) {
//	System.out.println("--------------------------*****************-----------------------");
//	System.out.println("The Axial 5 video is not Click");
//	}
//driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement c1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videocoronal'])[1]")));
	c1.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 1 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 1 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement c2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videocoronal'])[2]")));
	c2.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 2 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 2 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement c3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videocoronal'])[3]")));
	c3.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 3 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 3 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement c4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videocoronal'])[4]")));
	c4.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 4 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Coronal 4 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
//try {
//	WebDriverWait wait = new WebDriverWait(driver, 30);
//	WebElement c5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videocoronal'])[5]")));
//	c5.click();
//	Thread.sleep(3000);
//	System.out.println("--------------------------*****************-----------------------");
//	System.out.println("The Coronal 5 video Click Successfully");
//	} catch (Exception e) {
//	System.out.println("--------------------------*****************-----------------------");
//	System.out.println("The Coronal 5 video is not Click");
//	}
//driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement s1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videosagittal'])[1]")));
	s1.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 1 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 1 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement s2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videosagittal'])[2]")));
	s2.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 2 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 2 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();

try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement s3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videosagittal'])[3]")));
	s3.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 3 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 3 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement s4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videosagittal'])[4]")));
	s4.click();
	Thread.sleep(3000);
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 4 video Click Successfully");
	} catch (Exception e) {
	System.out.println("--------------------------*****************-----------------------");
	System.out.println("The Sagittal 4 video is not Click");
	}
driver.findElement(By.xpath("//button[@id='closeButton']")).click();
//try {
//	WebDriverWait wait = new WebDriverWait(driver, 30);
//	WebElement s5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='videosagittal'])[5]")));
//	s5.click();
//	Thread.sleep(3000);
//	System.out.println("--------------------------*****************-----------------------");
//	System.out.println("The Sagittal 5 video Click Successfully");
//	} catch (Exception e) {
//	System.out.println("--------------------------*****************-----------------------");
//	System.out.println("The Sagittal 5 video is not Click");
//	}
//driver.findElement(By.xpath("//button[@id='closeButton']")).click();

	    }
@AfterTest
public void tearDown() {
   if (driver != null) {
       driver.quit();
   }}
}
