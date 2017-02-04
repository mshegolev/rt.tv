package time.tv.Authorization;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import time.tv.TestNgTestBase;
import time.tv.pages.HomePage;

/**
 * Created by myname on 04.02.17.
 */
public class Authorization extends TestNgTestBase{
    private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testHomePageHasAHeader() {
        driver.get(baseUrl);
        Assert.assertTrue(homepage.getTitle().toString().equals("Ритмовремя-ТВ"));
        //Assert.assertFalse("".equals(homepage.header.getText()));
    }
}
