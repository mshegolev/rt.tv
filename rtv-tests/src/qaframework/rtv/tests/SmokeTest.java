package qaframework.rtv.tests;

import org.testng.annotations.Test;
import org.testng.Assert;



public class SmokeTest extends TestBase {
	
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
		Assert.assertTrue(((app.getNavigationHelper().checkAbonentType("� ��� ������� ����������� ��������� �� 11 �������"))),"Wrong abonent type"); 
		app.getNavigationHelper().clickButtonExit();
	}
	@Test
	public void authorizationNonCredentional() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getAccountHelper().fillLoginForm(app, new AccountData("wrong", ""));
		app.getNavigationHelper().clickButtonLogin();
		Assert.assertTrue(app.getNavigationHelper().checkWarrningMessage());
	}
	// TODO: Write test for checkBox remember
	@Test(description = "CheckBox remember user", dependsOnMethods = { "authorizationCorrectCredentianal"})
	public void authorizationWithRememberCheckBox() throws Exception {
		// app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
		app.getNavigationHelper().clickButtonExit();
	}
}