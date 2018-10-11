package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class tutorial14 {
	AppiumDriver<MobileElement> driver;
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "192.168.188.101:5555");
		cap.setCapability("browserName", "Chrome");
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	public void searchkeyword() throws InterruptedException
	{
		driver.findElementByName("q").sendKeys("appium");
		Thread.sleep(1000);
	}
	
	public void teardown()
	{
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		tutorial14 obj =new tutorial14();
		obj.setUp();
		obj.searchkeyword();
		obj.teardown();

	}

}
