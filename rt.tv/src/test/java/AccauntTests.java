import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rithmtime.tv.tests.AccountData;
import rithmtime.tv.tests.NovigationPages;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by mikhail on 4/2/16.
 */
public class AccauntTests extends NovigationPages{
    AccountData ac= new AccountData();
    //NovigationPages pages = new NovigationPages();
    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://rithm-time.tv/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
    @AfterMethod
    public void logout() {
        clickExit();
        //System.out.println("@AfterMethod: The annotated method will be run after each test method.");
    }

    @Test(testName = "testAuthorizationSuccess",
            description = "Login with correct account")
    public void testAuthorizationSuccess() throws Exception {
        String username = "test001";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");
        assertTrue(gettableSheduleFirstRow(), "Table tableShedule is empty.");
        //assertTrue(checkAbonentType("У вас оплачен Расширенный абонемент на 11 месяцев"), " Wrong abonent type");

    }


    @Test(testName = "testAuthorizationSuccess-2",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess2() throws Exception {
        String username = "test002";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username),"Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-3",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess3() throws Exception {
        String username = "test003";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-4",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess4() throws Exception {
        String username = "test004";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-5",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess5() throws Exception {
        String username = "test005";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-6",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess6() throws Exception {
        String username = "test006";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-7",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess7() throws Exception {
        String username = "test007";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-8",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess8() throws Exception {
        String username = "test008";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

    @Test(testName = "testAuthorizationSuccess-9",
            description = "Try login with incorrect username")
    public void testAuthorizationSuccess9() throws Exception {
        String username = "test009";
        openMainPage();
        authorization(username, null);
        assertTrue(checkUsername(username), "Creds has wrong value");

    }

//    @Test(testName = "testAuthorizationWrongPassword",
//            description = "Login with incorrect password")
//    public void testAuthorizationWrongPassword() throws Exception {
//        openMainPage();
//        setUsername("test001");
//        setPassword("wrongpass");
//        clickAuthorization();
//        assertTrue(authMessage().contains("Неверный"),"Don't has warning about wrong authentication");
//        assertFalse(buttonExit().isDisplayed(),"Button EXIT doesn't exist");
//        clickExit();
//    }
//    @Test(testName = "testAuthorizationEmptyPassword",
//            description = "Login with empty password")
//    public void testAuthorizationEmptyPassword() throws Exception {
//        openMainPage();
//        AccountData account = new AccountData();
//        clickAuthorization();
//        assertTrue(authMessage().contains("Неверный"),"Don't has warning about wrong authentication");
//        assertFalse(buttonExit().isDisplayed(),"Button EXIT doesn't exist");
//        clickExit();
//    }
//    @Test(testName = "testAuthorizationEmptylogin",
//            description = "Login with empty username")
//    public void testAuthorizationEmptylogin() throws Exception {
//        openMainPage();
//        AccountData account = new AccountData();
//        clickAuthorization();
//        assertTrue(authMessage().contains("Неверный"),"Don't has warning about wrong authentication");
//        assertFalse(buttonExit().isDisplayed(),"Button EXIT doesn't exist");
//        clickExit();
//    }

}
