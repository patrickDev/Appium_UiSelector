package com.appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class TestUiSelector {
  
	AndroidDriver driver; 
	File file = new File("C:\\Users\\Patrick\\Documents\\LearnSelenium\\Appium_FindingElements\\apk\\com.davemac327.gesture.tool.apk");
	
	
  @Test
  public void testApp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Moto G");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("appPackage","");
		capabilities.setCapability("appPackage","");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		//Using ID => resourceId
		//driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
		//Using className()
		//driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").click();
		
		//Multiple button
		/*
		List<WebElement>  buttons =  driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
		  	
		  System.out.println("Total buttons present: " + buttons.size());
		  for(WebElement button: buttons){
			  System.out.println(button.getText());
			  if(button.getText().equals("Reload")){
				  System.out.println("button clicked");
				  button.click();
			  }
		  }
  	*/
		//Using index to select a button
		//driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("UiSelector().checkable(false)").size());
  }
  
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.quit();
  }

}
