package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest23 {
	AppiumDriver<MobileElement> driver;
	String path;
	@Parameters("androidversion")
	
	@BeforeMethod
	public void setUp(@Optional("6")String version)
	{
		System.out.println("Session is creating");
		
	     path=System.getProperty("user.dir");
		 DesiredCapabilities cap=new DesiredCapabilities();
		 cap.setCapability("platformName","Android");
		// cap.setCapability("platformVersion", "7.1.1");
		 cap.setCapability("deviceName","Galaxy Nexus 5");
		 cap.setCapability("app",path+"\\app\\ApiDemos.apk");
		if (version.equals("6"))
				{
			cap.setCapability("udid","192.168.188.101:5555");
				}
		else if(version.equals("7"))
		{
			cap.setCapability("udid","192.168.188.102:5555");
		}
		 //cap.setCapability("app","C:\\Users\\Acer\\eclipse-workspace\\Appium\\app");
		 try
		 {
		 driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		 
		 }
		 catch(MalformedURLException e)
		 {
			 e.printStackTrace();
		 }
		 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		 System.out.println("Session is created");
		
	}
	

	@Test
	public void clickTab()
	{
		boolean flag=false;
		driver.findElementByAccessibilityId("Views").click();
		
		for(int i=0;i<=20;i++)
		{
			try
			{
				driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("Tabs").click();
				break;
			}
			catch(Exception e)
			{
				verticalSwipe();
			}
			
		}
		
		flag=driver.findElementByAccessibilityId("1. Content By Id").isDisplayed();
		if(flag)
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	public void verticalSwipe() {
		
		Dimension dim=driver.manage().window().getSize();
		int height=dim.getHeight();
		int width=dim.getWidth();
		int x= width/2;
		int starty=(int)(height*0.80);
		int endy=(int)(height*0.20);
		driver.swipe(x, starty, x, endy, 500);
	}

}
