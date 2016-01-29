package rithmtime.tv.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SmokeTest
{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
private String gg;

@BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://rithm-time.tv/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

@Test
  public void testAuthorizationTrue() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = "666";
	  account.password = "555";
		authorization(account);
		clickAuthorization();
		Assert.assertTrue(buttonExitEnabled(),"Somthing wrong!");
		clickExit();
		
  }
  @Test
  public void testAuthorizationWronglogin() throws Exception {
		  openMainPage();
		  AccountData account = new AccountData();
		  account.username = "wrongLogin";
		  account.password = "Passw0rd";
			authorization(account);
			clickAuthorization();
			System.out.println("!!!!!");
			System.out.print(authMessage().toString());
			
  }
  @Test
  public void testAuthorizationWrongPassword() throws Exception {
	  }
  @Test
  public void testAuthorizationEmptyPassword() throws Exception {
	  }
  @Test
  public void testAuthorizationEmptylogin() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = "";
	  account.password = "Passw0rd";
		authorization(account);
		clickAuthorization();
	  }

private void authorization(AccountData account) {
	setUsername(account.username);
	setPassword(account.password);

	
}
  
  

private void clickAuthorization() {
	driver.findElement(By.id("auth_btn")).click();
}

private String authMessage() {
	return driver.findElement(By.id("auth_message")).getText();
}

private boolean clickExit() {
	if (buttonExitEnabled())
		{
		driver.findElement(By.id("exit")).click();
		return true;
		};
	System.out.println("It's hot out, and so am I!");
	return false;		

}


private boolean buttonExitEnabled() {
	if (driver.findElement(By.id("exit")).isEnabled()) {
		return true;
	}
	else 
		return false;
}

@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
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


  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}


