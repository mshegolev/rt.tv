package qaframework.rtv.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import qaframework.rtv.fw.ApplicationManager;

/**
 * Created by nikolay.g on 21.04.2016.
 */
public class VideoTests extends TestBase {
        char w = 0;
        ApplicationManager app = new ApplicationManager();

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

    @Test(testName = "RTV-17",singleThreaded = true, description = "Check player and autostart")
    public void checkPlayerOnMainPage() throws Exception {
        WebDriver driver = null;
        app.getNavigationHelper().openMainPage();
        Assert.assertTrue(app.getVideoHelper().clickButtonPlay(), "Button start don't work, video isn't stated");
        if (w < 30) while (!(app.getVideoHelper().getDuration().equals("0:10")) && w < 30) {
            Thread.sleep(1000);
            w++;
        }
         else System.err.println("The bicycle has already stopped!");

        //TODO: add check video stream or url or screenshot
        Assert.assertTrue(app.getVideoHelper().clickButtonPause(), "Button start don't work, video isn't stated");
        Assert.assertEquals(app.getVideoHelper().getDuration(), "0:10");
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
