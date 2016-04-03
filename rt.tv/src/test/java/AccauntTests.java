import org.testng.annotations.Test;
import rithmtime.tv.tests.AccountData;
import rithmtime.tv.tests.NovigationPages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by mikhail on 4/2/16.
 */
public class AccauntTests extends NovigationPages{
    AccountData ac= new AccountData();
    //NovigationPages pages = new NovigationPages();


    @Test(testName = "testAuthorizationSuccess",
            description = "Login with correct account")
    public void testAuthorizationSuccess() throws Exception {
    }


    @Test(testName = "testAuthorizationWronglogin",
            description = "Try login with incorrect username")
    public void testAuthorizationWronglogin() throws Exception {
        String username = "test002";
        openMainPage();
        authorization(username,"null");
        assertTrue(checkUsername(username),"Creds has wrong value");
    }

    @Test(testName = "testAuthorizationWrongPassword",
            description = "Login with incorrect password")
    public void testAuthorizationWrongPassword() throws Exception {
        openMainPage();
        setUsername("test001");
        setPassword("wrongpass");
        clickAuthorization();
        assertTrue(authMessage().contains("Неверный"),"Don't has warning about wrong authentication");
        assertFalse(buttonExit().isDisplayed(),"Button EXIT doesn't exist");
    }
    @Test(testName = "testAuthorizationEmptyPassword",
            description = "Login with empty password")
    public void testAuthorizationEmptyPassword() throws Exception {
        openMainPage();
        AccountData account = new AccountData();
        clickAuthorization();
        assertTrue(authMessage().contains("Неверный"),"Don't has warning about wrong authentication");
        assertFalse(buttonExit().isDisplayed(),"Button EXIT doesn't exist");
    }
    @Test(testName = "testAuthorizationEmptylogin",
            description = "Login with empty username")
    public void testAuthorizationEmptylogin() throws Exception {
        openMainPage();
        AccountData account = new AccountData();
        clickAuthorization();
        assertTrue(authMessage().contains("Неверный"),"Don't has warning about wrong authentication");
        assertFalse(buttonExit().isDisplayed(),"Button EXIT doesn't exist");
    }

}
