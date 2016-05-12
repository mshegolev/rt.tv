package qaframework.rtv.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nikolay.g on 21.04.2016.
 */
public class VideoTests extends TestBase {
    @Test(testName = "RTV-11", description = "Check player and autostart")
    public void authorizationWithRememberCheckBox() throws Exception {
        app.getNavigationHelper().openMainPage();
       // AccountData account = new AccountData();
      //  account.username = "test002";
      //  account.password = "002test";
     //   app.getAccountHelper().fillLoginForm(app, account);

      //  app.getNavigationHelper().clickButtonLogin();
        String result=  app.getNavigationHelper().getPlayerContainer();
    String expresult = "div1";
        Assert.assertEquals(result,expresult,"Main page doesn't have player");
        app.getNavigationHelper().clickButtonExit();
    }
}
