package qaframework.rtv.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by nikolay.g on 21.04.2016.
 */
public class VideoTests extends TestBase {
    private char w=0;

    @Test(testName = "RTV-11", description = "Check player and autostart")
    public void authorizationWithRememberCheckBox() throws Exception {
        WebDriver driver = null;
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test002";
        account.password = "002test";
        app.getAccountHelper().fillLoginForm(app, account);
        app.getNavigationHelper().clickButtonLogin();
        //app.getNavigationHelper().getPlayerContainer();
        app.getNavigationHelper().clickButtonExit();
        }
    @Test(testName = "RTV-17", description = "Check player and autostart")
    public void checkPlayerOnMainPage() throws Exception {
        WebDriver driver = null;
        app.getNavigationHelper().openMainPage();
        Assert.assertTrue(app.getVideoHelper().clickButtonPlay(), "Button start don't work, video isn't stated");
        while ( !(app.getVideoHelper().getDuration().equals("0:10")) && w < 30){
            Thread.sleep(1000);
            w++;
        }
        //TODO: add check video stream or url or screenshot
        Assert.assertTrue(app.getVideoHelper().clickButtonPause(), "Button start don't work, video isn't stated");
        Assert.assertEquals(app.getVideoHelper().getDuration(), "0:10");

        //*------- add some tests
        //TODO: needed mouse move to iframe for open buttons panel
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
