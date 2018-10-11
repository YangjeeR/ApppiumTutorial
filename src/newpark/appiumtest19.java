package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest19 {
	
	AppiumDriver<MobileElement>driver;
	String path;
	public void setup() throws MalformedURLException
	{
		path=System.getProperty("user.dir");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("PlatformName", "Android");
		cap.setCapability("deviceName", "192.168.188.101:5555");
		cap.setCapability("app",path+"\\app\\ApiDemos.apk");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		 
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		
	}
	
	public void LongPress() throws InterruptedException
	{
		TouchAction TC=new TouchAction(driver);
		MobileElement el=driver.findElementById("com.android.mms:id/subject");
		TC.longPress(el).perform().release();
		Thread.sleep(2000);
		
		boolean flag=driver.findElementById("com.android.mms:id/delete").isDisplayed();
		if(flag)
		{
			System.out.println("Passed");
		}
		else 
		{
			System.out.println("failed");
		}
	}
	

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		
		appiumtest19 obj=new appiumtest19();
		obj.setup();
		obj.LongPress();

	}

}
