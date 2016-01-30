package rithmtime.tv.tests;

import static org.testng.AssertJUnit.*;

import org.testng.AssertJUnit;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;


public class SmokeTest 
{
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  final private String trueuser = "666";
  final private String truepassword = "555";

 

@BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://rithm-time.tv/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
    
@Test(testName = "testAuthorizationSuccess", 
	  description = "Login with correct account")
  public void testAuthorizationSuccess() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = trueuser;
	  account.password = truepassword;
		authorization(account);
		clickAuthorization();
		assertTrue(getUsername().contains(account.username));
		assertTrue("Button EXIT doesn't exist", buttonExitEnabled());
		clickExit();
  }
  @Test(testName = "testAuthorizationWronglogin", 
		  description = "Try login with incorrect username")
  public void testAuthorizationWronglogin() throws Exception {
		  openMainPage();
		  AccountData account = new AccountData();
		  account.username = "wrongUsername";
		  account.password = truepassword;
			authorization(account);
     		clickAuthorization();
     		assertTrue("Don't has warning about wrong authentication", authMessage().contains("Неверный"));
     		assertFalse("Button EXIT doesn't exist", buttonExit().isDisplayed());
				
  }
  @Test(testName = "testAuthorizationWrongPassword", 
		  description = "Login with incorrect password")
  public void testAuthorizationWrongPassword() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = trueuser;
	  account.password = "Passw0rd";
		authorization(account);
 		clickAuthorization();
 		assertTrue("Don't has warning about wrong authentication", authMessage().contains("Неверный"));
 		assertFalse("Button EXIT doesn't exist", buttonExit().isDisplayed());
 		}
  @Test(testName = "testAuthorizationEmptyPassword", 
		  description = "Login with empty password")
  public void testAuthorizationEmptyPassword() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = trueuser;
	  account.password = "";
		authorization(account);
 		clickAuthorization();
 		assertTrue("Don't has warning about wrong authentication", authMessage().contains("Неверный"));
 		assertFalse("Button EXIT doesn't exist", buttonExit().isDisplayed());  
  }
  @Test(testName = "testAuthorizationEmptylogin", 
		  description = "Login with empty username")
  public void testAuthorizationEmptylogin() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = "";
	  account.password = "Passw0rd";
		authorization(account);
 		clickAuthorization();
 		assertTrue("Don't has warning about wrong authentication", authMessage().contains("Неверный"));
 		assertFalse("Button EXIT doesn't exist", buttonExit().isDisplayed());
	  }

  
  
  
  
private void authorization(AccountData account) {
	setUsername(account.username);
	setPassword(account.password);
}
  
  

private void clickAuthorization() {
	buttonAuthorization().click();
	WaitForPageToLoad.class.equals(authMessage());
	
}

private WebElement buttonAuthorization() {
	return driver.findElement(By.id("auth_btn"));
}

private String authMessage() {
	return driver.findElement(By.id("auth_message")).getText();
}

private boolean clickExit() {
	if (buttonExitEnabled())
		{
		buttonExit().click();
		return true;
		};
	System.out.println("It's hot out, and so am I!");
	return false;		

}


private boolean buttonExitEnabled() {
	if (buttonExit().isEnabled()) {
		return true;
	}
	else 
		return false;
}

private WebElement buttonExit() {
	return driver.findElement(By.id("exit"));
}

@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

private String getUsername() {
	return driver.findElement(By.id("userName")).getText();
}


private void setPassword(String password) {
	driver.findElement(By.id("auth_password")).clear();
    driver.findElement(By.id("auth_password")).sendKeys(password);
}

private void setUsername(String login) {
	driver.findElement(By.xpath("//*[@id=\"auth_login\"]")).clear();
    driver.findElement(By.xpath("//*[@id=\"auth_login\"]")).sendKeys(login);
}

private void openMainPage() {
	//open main page
	  driver.get(baseUrl + "/");
}


@AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);}
  }
}


