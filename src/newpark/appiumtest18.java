package newpark;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class appiumtest18 {
	
	AppiumDriver<MobileElement> driver;
	String path;
	
	public void setUp()
	{
		System.out.println("Session is creating");
		path=System.getProperty("user.dir");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "192.168.188.101:5555");
		cap.setCapability("app", path+"\\app\\ApiDemos.apk");
		
		try
		{
			driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		System.out.println("Session is created");
	}
	
	public void handleAutoComplete() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		driver.findElement(By.xpath("//*[@text='Auto Complete']")).click();
		driver.findElement(By.xpath("//*[@text='1. Screen Top']")).click();
		Thread.sleep(2000);
		driver.findElementById("io.appium.android.apis:id/edit").sendKeys("Netherlands Antilles");
		Thread.sleep(2000);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
		Thread.sleep(2000);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
		Thread.sleep(2000);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(2000);
		String text=driver.findElementById("io.appium.android.apis:id/edit").getText();
		System.out.println("The text searched is :"+text);
		if(text.equals("Netherlands Antilles"))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	public void teardown()
	{
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		appiumtest18 obj=new appiumtest18();
		obj.setUp();
		obj.handleAutoComplete();
		obj.teardown();

	}

}
