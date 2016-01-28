package rithmtime.tv.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SmokeTest
{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://rithm-time.tv/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.testng.annotations.Test
  public void testAuthorizationTrue() throws Exception {
	  openMainPage();
	  AccountData account = new AccountData();
	  account.username = "mshegolev@gmail.com";
	  account.password = "Passw0rd";
		authorization(account);
		clickAuthorization();
  }
  @Test
  public void testAuthorizationWronglogin() throws Exception {
		  openMainPage();
		  AccountData account = new AccountData();
		  account.username = "wrongLogin";
		  account.password = "Passw0rd";
			authorization(account);
			clickAuthorization();
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
      fail(verificationErrorString);
    }
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


