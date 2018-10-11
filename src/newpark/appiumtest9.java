package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest9 {

	/**
	 * @author Yangjee
	 */	
	
	AppiumDriver<MobileElement>driver;
	String path;
	public void setup() throws MalformedURLException
	{
		path=System.getProperty("user.dir");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("PlatformName", "Android");
		cap.setCapability("deviceName", "192.168.188.101:5555");
		cap.setCapability("app",path+"\\app\\ApiDemos.apk");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		 
		driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		
	}
	
	public void addTwoNum()
	{
		driver.findElementById("com.android.calculator2:id/digit_7").click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElementByXPath("//*[@text='2']").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		String text=driver.findElementById("com.android.calculator2:id/result").getText();
		
		if(text.equals("9"))
		{
			System.out.println("The answer is" + text);
		}
		else
		{
			System.out.println("Query failed");
		}
		
	}
	
	public void TearDown()
	{
		driver.quit();
	}
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		appiumtest9 obj = new appiumtest9();
		obj.setup();
		obj.addTwoNum();
		obj.TearDown();

	}

}
