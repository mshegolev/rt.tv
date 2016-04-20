package qaframework.rtv.tests;

import org.testng.annotations.Test;

public class SmokeTest extends TestBase {
	@Test
	public void authorization() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	// TODO: Write test for checkBox remember
	@Test(description = "CheckBox remember user", dependsOnMethods = "authorization")
	public void testRememberCheckBox() throws Exception {
		// app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testNonAbonentType() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getAccountHelper().fillLoginForm(app, new AccountData("", ""));
		app.getNavigationHelper().clickButtonLogin();
		app.getNavigationHelper().warrningMessage();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		// clickButtonExit();
	}

}
