package internshala;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest {

	ChromeDriver	driver;
@Before
	public void setUp() {
		// Initialize ChromeDriver instance
			driver = new ChromeDriver();	
			// Navigate to the GIC login page
	driver.get("https://app.germanyiscalling.com/common/login/"); }
	
@Test
	 //valid login test
	 public void login() {
		  // Locate the user name and password fields
	WebElement username =	driver.findElement(By.xpath("//*[@id='username']"));
	WebElement password =	driver.findElement(By.xpath("//*[@id='password']"));
		  // Enter valid credentials
	username.sendKeys("johnmaria234@gmail.com");
	password.sendKeys("ryaneldho234");	
	      // Locate the login button
	WebElement login =	driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/button"));
		 // submit using login button
	login.submit(); 
	loginsuccess();      }
	
	     // method to check login success or not
	public void loginsuccess() {String src =driver.getPageSource();
	if(src.contains("Maria John")) {System.out.println("Succesfully logged in");}
	else {System.out.println("login not success");}}
	
	@Test
	public void emptylogin() throws  IOException {
		// Locate the login button
		 WebElement login =	driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/button"));
			// submit using login button
		 login.submit();  
		 // Capture the error message
		 errormsg();     }
	
	@Test
	public void wronglogin() {		
		 // Locate the user name and password fields
		   WebElement username =	driver.findElement(By.xpath("//*[@id='username']"));
		   WebElement password =	driver.findElement(By.xpath("//*[@id='password']"));
		   // Enter invalid credentials
		 username.sendKeys("@&");
		 password.sendKeys("$%&*");
		// Locate the login button
		 WebElement login =	driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/button"));
			// submit using login button
		 login.submit(); 
		// Capture the error message
		 errormsg();     }
	
	
	// method to Capture the error message
	public void errormsg() {WebElement errorMessage= driver.findElement(By.cssSelector(".alert.alert-danger"));
    String actualERRORMessage = errorMessage.getText();
	System.out.println("error msg is: "+actualERRORMessage);}
	
	
	@After
		public void end() {
		// Close the WebDriver
	driver.close();}
	 
	
}
