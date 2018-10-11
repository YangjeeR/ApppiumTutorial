package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidDriver;

public class HiUp {

	AppiumDriver<MobileElement> driver;
	String path;
	
	@BeforeMethod
	public void setup() 

	{
		
		System.out.println("Session is creating");
	
     path=System.getProperty("user.dir");
	 DesiredCapabilities cap=new DesiredCapabilities();
	 cap.setCapability("platformName","Android");
	 cap.setCapability("deviceName","192.168.188.102:5555");
	 cap.setCapability("app",path+"\\app\\hiup.apk");
	
	 try
	 {
	 driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	 
	 }
	 catch(MalformedURLException e)
	 {
		 e.printStackTrace();
	 }
	 driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
	 System.out.println("Session is created");
	}
	
	@Test
	public void startButton() throws InterruptedException
	{
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/control_hint")).click();//first menu button
		System.out.println("Successfully connected to HiUp aap.");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']")).click();//Job Feed
	 boolean flag=driver.findElement(By.xpath("//android.widget.TextView[@text='Jobs']")).isDisplayed();
	 if(flag) {
		System.out.println("Job Feed is opened sucessfully.");

	}
	 else
	 {
		 System.out.println("Job Feed could not be opened.");
	 }
	
	}
	
	@Test
	public void JobFeed() throws InterruptedException
	{
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/bt_refine")).click();//refine
		Thread.sleep(2000);
		//Using current Location
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/bt_current_location")).click();
		//Using area postal code
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_postcode")).sendKeys("94016");
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
		
	}
	
	public void Profile() throws InterruptedException
	{
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/control_hint")).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']")).click();//main menu
		//click on profile
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Profile']")).click(); 
		Thread.sleep(1000);
		
	}
	
	public void Signup() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.Button[@text='Sign up']")).click(); 
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_sign_up_email_address")).
		sendKeys("yrai12@gmail.com");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_sign_up_confirm_email_address"))
		.sendKeys("yrai12@gmail.com");//confirm email
		verticalSwipe();
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_sign_up_firstname")).sendKeys("Yangjee");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_sign_up_lastname")).sendKeys("Rai");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_sign_up_password")).sendKeys("123456789");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_sign_up_confirm_password")).sendKeys("123456789");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/sign_up_agree_checkbox")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/bt_continue_sign_up")).click();
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_validation_number_country_number")).sendKeys("12");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_mobile_number")).sendKeys("98099999");
		Thread.sleep(1000);
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/submit_button")).click();//finish
		
		String login=driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/tv_user_profile_email_address")).getText();
		
		if(login.equals("yrai12@gmail.com"))
		{
			System.out.println("Login successful");
			driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/bt_edit")).click();
			driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_edit_user_profile_title")).sendKeys("Mrs");
			verticalSwipe();
			driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_user_profile_about_me")).
			sendKeys("Hi I am Yangjee Rai.");	
			driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/bt_save_edit_profile")).click();
			System.out.println("Profile has been successfully updated");
		}
		
		else
		{
			System.out.println("User cannot be created.Issue in login.");
			
		}
	}
	
	public void Logout()
	{
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/control_hint")).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']")).click();//main menu
		//click on logout
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Logout']")).click(); 
		driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click(); 
		
	}
	
	public void Login() throws InterruptedException
	{
	Profile();
	//login form
	driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click(); 
	driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/email")).sendKeys("yrai12@gmail.com");	
	driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/password")).sendKeys("123456789");	
	driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/sign_in_button")).click();
	
	}
	
	public void ForgetPwd() throws InterruptedException
	{
		Profile();
		driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click(); 
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/forgotten_password")).click();
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/et_email_reset_password")).sendKeys("thulungyanzee@gmail.com");
		driver.findElement(By.id("co.olivemedia.hihoandroidwebapp:id/bt_reset_password")).click();
		boolean flag=driver.findElement(By.xpath("//android.widget.TextView[@text='Email sent']")).isDisplayed(); 
		if(flag)
		{
			System.out.println("Email has been sent to reset password");
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		}
		else
		{
			System.out.println("Reset password is unsuccessful");
			
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

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		HiUp obj=new HiUp();
		obj.setup();
		//obj.startButton();
		//obj.JobFeed();
		//obj.Profile();
		//obj.Signup();
		//obj.Login();
		//obj.Logout();
		obj.ForgetPwd();
	}

}
