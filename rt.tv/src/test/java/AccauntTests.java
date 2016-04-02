import org.testng.annotations.Test;
import rithmtime.tv.tests.AccountData;

/**
 * Created by mikhail on 4/2/16.
 */
public class AccauntTests {
    @Test(testName = "testAuthorizationSuccess",
            description = "Login with correct account")
    public void testAuthorizationSuccess() throws Exception {
        AccountData ac = new AccountData();
        ac.getPassByName("test002");
    }
//
//    @Test(testName = "testAuthorizationSuccess",
//            description = "Login with correct account")
//    public void testAuthorizationSuccess() throws Exception {
//        openMainPage();
//        AccountData account = new AccountData();
//        account.username = "test001";
//        account.password = "";
//        authorization(account);
//        clickAuthorization();
//        assertTrue(getUsername().contains(account.username));
//        assertTrue(buttonExitEnabled(),"Button EXIT doesn't exist");
//        clickExit();
//    }
}
