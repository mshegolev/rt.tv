package qaframework.rtv.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
 
/**
 * Created by nikolay.g on 22.04.2016.
 */
public class PersonalAccountPageTest extends qaframework.rtv.tests.TestBase{

    @Test(testName = "RTV-13", description = "Check existence of block with gifts for user without gifts")
    public void existenceGiftsBlockUserWithoutGifts() throws Exception {
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test009";
        account.password = "009test";
        app.getAccountHelper().fillLoginForm(app, account);

        app.getNavigationHelper().clickButtonLogin();

        String result=  app.getNavigationHelper().getGiftBlockWithoutGiftContent();
        String expresult = "У вас нет подарков.";
        Assert.assertEquals(result,expresult,"User without gifts doesn't see the error.");
        app.getNavigationHelper().clickButtonExit();
    }

    @Test(testName = "RTV-12", description = "Check existence of block with gifts for user with gifts")
    public void existenceGiftsBlockUserWithGifts() throws Exception {
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test005";
        account.password = "005test";
        app.getAccountHelper().fillLoginForm(app, account);

        app.getNavigationHelper().clickButtonLogin();
        Thread.sleep(4000);
        app.getNavigationHelper().clickGiftBlockMenu();
        app.getNavigationHelper().clickGiftBlockFirstTable();
        String firstGiftName = app.getNavigationHelper().getFirstRowContentGiftTable();
        String firstGiftNameExp = "Орган";
        Assert.assertEquals(firstGiftName,firstGiftNameExp,"User with gifts doesn't have table with gifts");
        app.getNavigationHelper().clickButtonExit();
    }

    @Test(testName = "RTV-14", description = "Check correct work of subscription block for user without phone")
    public void existenceSubscriptionBlockUserWithoutPhone() throws Exception {
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test005";
        account.password = "005test";
        app.getAccountHelper().fillLoginForm(app, account);
        app.getNavigationHelper().clickButtonLogin();
    }
    
    @Test(testName = "RTV-15", description = "Check existence of block with Tsioroitc for user without access")
    public void existenceBlockTsioroitcWithoutAccess() throws Exception {
        app.getNavigationHelper().openMainPage();
        AccountData account = new AccountData();
        account.username = "test005";
        account.password = "005test";
        app.getAccountHelper().fillLoginForm(app, account);
        app.getNavigationHelper().clickButtonLogin();
    }
}
