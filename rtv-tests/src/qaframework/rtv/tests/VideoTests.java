package qaframework.rtv.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nikolay.g on 21.04.2016.
 */
public class VideoTests extends TestBase {
    @Test(testName = "RTV-11", description = "Check player and autostart")
    public void authorizationWithRememberCheckBox() throws Exception {
        WebDriver driver = null;
        app.getNavigationHelper().openMainPage();
        //app.getVideoHelper().videoPlayerIframe();
        Assert.assertTrue(app.getVideoHelper().clickButtonPlay(),"Button start don't work, video isn't stated");
        //TODO: add check video stream or url.
        Thread.sleep(10000);
        //TODO: needed mouse move to iframe for open buttons panel
        Assert.assertTrue(app.getVideoHelper().clickButtonPause(),"Button pause don't work, video isn't paused");
    }

    private void loginMainPageUserAdmin(){
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test002";
        account.password = "002test";
        app.getAccountHelper().fillLoginForm(app, account);
        app.getNavigationHelper().clickButtonLogin();
    }
}
