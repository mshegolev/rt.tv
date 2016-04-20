package qaframework.rtv.tests;

import org.testng.annotations.Test;

public class AuthorizationTest extends TestBase {

	@Test
	public void testAbonentType1() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType2() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test002";
		account.password = "002test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType3() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test003";
		account.password = "003test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType4() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test004";
		account.password = "004test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType5() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test005";
		account.password = "005test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType6() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test006";
		account.password = "006test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType7() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test007";
		account.password = "007test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType8() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test008";
		account.password = "008test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType9() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test009";
		account.password = "009test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}

}
