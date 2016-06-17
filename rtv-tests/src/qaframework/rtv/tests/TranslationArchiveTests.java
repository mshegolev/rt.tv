package qaframework.rtv.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TranslationArchiveTests extends TestBase  {
	@Test
	public void authorizationCorrectCredentianal() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow());
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow(),"Table tableShedule is empty.");
		app.getNavigationHelper().clickButtonExit();
	}
}

