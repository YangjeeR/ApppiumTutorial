package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest21 {

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
	

	public void test() throws InterruptedException
	{
		if(driver.getOrientation().equals("LANDSCAPE"))
		{
			switchtomode("LANDSCAPE");
		}
		else
		{
			switchtomode("PORTRAIT");
		}
		
	}
	
	public void switchtomode(String switchmode) throws InterruptedException
	{
		ScreenOrientation currentornt= driver.getOrientation();
		System.out.println("CurrentOrientation:" +currentornt);
		if(switchmode.equalsIgnoreCase("LANDSCAPE"))
		driver.rotate(ScreenOrientation.LANDSCAPE);
		else if(switchmode.equalsIgnoreCase("PORTRAIT"))
		{
		driver.rotate(ScreenOrientation.PORTRAIT);
		}
		try {
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		 currentornt= driver.getOrientation();
		System.out.println("After Rotate:" +currentornt);
	}

	
	public void teardown()
	{
		driver.quit();
	}
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		appiumtest21 obj=new appiumtest21();
		obj.setup();
		obj.test();
		obj.teardown();

	}

}
