package qaframework.rtv.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qaframework.rtv.fw.ApplicationManager;

/**
 * Created by nikolay.g on 21.04.2016.
 */
public class ArchiveVideoTests extends TestBase {
    @BeforeClass
    public void openBrowser() {
        app.getNavigationHelper().openMainPage();
    }

    @Test(testName = "RTV-11", description = "Check player on main page")
    public void checkArchivePlayerExistsOnMainPage() throws Exception {
        Assert.assertNotNull(app.getNavigationHelper().getPlayerContainer(), "Don't have player on the main page.");
    }

    @Test(testName = "RTV-11", description = "Check player on personal page")
    public void checkArchivePlayerExistsOnPersonalPage() throws Exception {
        AccountData account = new AccountData();
        account.username = "test002";
        account.password = "002test";
        app.getAccountHelper().fillLoginForm(app, account);
        app.getNavigationHelper().clickButtonLogin();
        Assert.assertNotNull(app.getNavigationHelper().getPlayerContainer(), "Don't have player on the main page.");
    }


    @Test(testName = "RTV-17", description = "Check play video on main page")
    public void checkArchivePlayerOnMainPage() throws Exception {
        char w = 0;
        ApplicationManager app2 = new ApplicationManager();
        app2.getNavigationHelper().openMainPage();
        Assert.assertTrue(app2.getVideoHelper().clickButtonPlay(), "Button start don't work, video isn't stated");
        if (w < 30) while (!(app2.getVideoHelper().getDurationArchivePlayer().equals("0:10")) && w < 30) {
            Thread.sleep(1000);
            w++;
        }
        else {
            app2.stop();
        }
        //TODO: add check video stream or url or screenshot
        Assert.assertTrue(app2.getVideoHelper().clickButtonPause(), "Button start don't work, video isn't stated");
        Assert.assertEquals(app2.getVideoHelper().getDurationArchivePlayer(), "0:10","Duration is't same");
        app2.stop();
        //TODO: needed mouse move to iframe for open buttons panel
    }
}
