package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest22 {

	AppiumDriver<MobileElement>driver;
	String path;
	public void setup() throws MalformedURLException
	{
		path=System.getProperty("user.dir");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("PlatformName", "Android");
		cap.setCapability("deviceName", "192.168.188.101:5555");
		cap.setCapability("app",path+"\\app\\ApiDemos.apk");
		 
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		
	}
	
	public void tapAction()
	{
		//tap method by Appium driver
		MobileElement view=driver.findElementByAccessibilityId("Views");
		driver.tap(1, view, 1000);
		
		//tap method by touch action
		MobileElement autocomplete= driver.findElementByAccessibilityId("Auto Complete");
		new TouchAction(driver).tap(autocomplete).perform().release();
		
		boolean flag=driver.findElementByAccessibilityId("1. Screen Top").isDisplayed();
		if(flag)
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		appiumtest22 obj=new appiumtest22();
		obj.setup();
		obj.tapAction();

	}

}
