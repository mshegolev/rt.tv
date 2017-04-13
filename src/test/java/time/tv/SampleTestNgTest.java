package time.tv;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import time.tv.pages.HomePage;
import time.tv.pages.LoginPage;
import time.tv.util.MyClass;

import java.io.IOException;

public class SampleTestNgTest extends TestNgTestBase {

    private HomePage homepage;
    private LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);

    }

    @Test
    public void testHomePageHasAHeader() throws IOException, InterruptedException {
        driver.get(baseUrl);
        MyClass myClass = new MyClass();
        myClass.logSimpleMessage();
        Assert.assertTrue(homepage.getTitle().toString().equals("Ритмовремя-ТВ"));
        Assert.assertTrue(loginPage.getTitle().toString().equals("Ритмовремя-ТВ"));
        Thread.sleep(5000);
        loginPage.setUsername("");
        loginPage.setPassword("");
        Assert.assertFalse(loginPage.isRememberMe());
        loginPage.enablerememberMe();
        Assert.assertTrue(loginPage.isRememberMe());
        Assert.assertTrue(loginPage.buttonLogin.isDisplayed());
        //homepage


    }
}
