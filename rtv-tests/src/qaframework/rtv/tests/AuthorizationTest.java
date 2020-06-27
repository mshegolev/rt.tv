package qaframework.rtv.tests;

import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AuthorizationTest extends TestBase {
    private Logger log = Logger.getLogger("AuthorizationTest");

    @Test
    public void testAbonentType1() throws Exception {
        app.getNavigationHelper().openMainPage();
        qaframework.rtv.tests.AccountData account = new qaframework.rtv.tests.AccountData();
        account.username = "test001";
        account.password = "001test";

        app.getAccountHelper().fillLoginForm(account);
        app.getNavigationHelper().clickButtonLogin();
        boolean result = app.getNavigationHelper().exit();
        assertThat(result, equalTo(true));
    }


}
