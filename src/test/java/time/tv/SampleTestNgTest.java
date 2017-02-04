package time.tv;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import time.tv.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    Assert.assertTrue(homepage.getTitle().toString().equals("Ритмовремя-ТВ"));
      System.out.println(homepage.getLoginPage());
    //Assert.assertFalse("".equals(homepage.header.getText()));
  }
}
