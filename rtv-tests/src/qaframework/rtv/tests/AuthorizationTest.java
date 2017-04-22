package qaframework.rtv.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class AuthorizationTest extends TestBase {
	private Logger log = Logger.getLogger("AuthorizationTest");

	@Test
	public void testAbonentType1() throws Exception {
		app.getNavigationHelper().openMainPage();
		qaframework.rtv.tests.AccountData account = new qaframework.rtv.tests.AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType2() throws Exception {
		app.getNavigationHelper().openMainPage();
		qaframework.rtv.tests.AccountData account = new qaframework.rtv.tests.AccountData();
		account.username = "test002";
		account.password = "002test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow(),"Table tableShedule is empty.");
		
//		String textInNextRtv = app.getNavigationHelper().getNextInRtv();
//		String ExpTextInNextRtv = "Далее в программе: ";
//		assertThat(textInNextRtv, containsString(ExpTextInNextRtv));
//TODO: What is check?
		
		String getEventId = app.getNavigationHelper().getEventId();
		//String getEventById = app.getNavigationHelper().getEventById(getEventId+"_Allow");
		//Assert.assertEquals(getEventById,"","User hasn't access to event");

		app.getNavigationHelper().clickButtonExit();
	}
	
	
	@Test
	public void testAbonentType1FullAbonement() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		// driver.findElement(By.cssSelector("button.navbar-toggle")).click();
		// // open list with button Exit
//		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow());
//		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow(),"Table tableShedule is empty.");
		//Assert.assertTrue(((app.getNavigationHelper().checkAbonentType("У вас оплачен Расширенный абонемент на 11 месяцев"))),"Wrong abonent type");
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
		
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow());
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow(),"Table tableShedule is empty.");
		//Assert.assertTrue(((app.getNavigationHelper().checkAbonentType("У вас оплачен Расширенный абонемент на август"))),"Wrong abonent type");

		String textInNextRtv = app.getNavigationHelper().getNextInRtv();
		String ExpTextInNextRtv = "Далее в программе: ";
		assertThat(textInNextRtv, containsString(ExpTextInNextRtv));
		
		String getEventId = app.getNavigationHelper().getEventId();
		String getEventById = app.getNavigationHelper().getEventById(getEventId+"_Allow");
		Assert.assertEquals(getEventById,"","User hasn't access to event");
		
		
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
		
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow());
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow(),"Table tableShedule is empty.");
		Assert.assertTrue(((app.getNavigationHelper().checkAbonentType("У вас оплачен Базовый абонемент на август 2016"))),"Wrong abonent type"); 
		
		String getEventId = app.getNavigationHelper().getEventId();
		String getEventDateInTable = app.getNavigationHelper().getEventDateInTable();
		if(getEventDateInTable == "6 августа" || getEventDateInTable == "9 августа" || getEventDateInTable == "14 августа"
				|| getEventDateInTable == "17 августа" || getEventDateInTable == "26 августа")
		{
			String getEventById = app.getNavigationHelper().getEventById(getEventId+"_Allow");
			Assert.assertEquals(getEventById,"","User hasn't access to event");
		}
		else 
		{
			String getEventById = app.getNavigationHelper().getEventById(getEventId+"_Denied");
			Assert.assertEquals(getEventById,"","User has! access to event!");
		}
		
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
		
		String getEventId = app.getNavigationHelper().getEventId();
		String getEventById = app.getNavigationHelper().getEventById(getEventId+"_Denied");
		Assert.assertEquals(getEventById,"","User has! access to event!");
		
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
		
		app.getNavigationHelper().openPageForSetPayment();
		app.getNavigationHelper().fillFormForSetPayment(app, account, "163982");
		app.getNavigationHelper().clickButtonSetPayment();	
		app.getNavigationHelper().openMainPage();
		
		String tagNameVideoPlayer = app.getNavigationHelper().getTagNameVideoPlayer();
		String expTagNameDiv = "div";
		Assert.assertEquals(tagNameVideoPlayer,expTagNameDiv,"No player on the page!");
		
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow());
		Assert.assertTrue(app.getNavigationHelper().gettableSheduleFirstRow(),"Table tableShedule is empty.");

		String statusRowText = app.getNavigationHelper().getStatusRowText();
		String expStatusRowText = "Сейчас в эфире: ";
		assertThat(statusRowText, containsString(expStatusRowText));
		
		String voteBlockTag = app.getNavigationHelper().getBlockTag("vote");
		Assert.assertEquals(voteBlockTag,expTagNameDiv,"No vote block on the page!");

		String chatBlockTag = app.getNavigationHelper().getBlockTag("chat_view");
		Assert.assertEquals(chatBlockTag,expTagNameDiv,"No chat block on the page!");

		String chatFormBlockTag = app.getNavigationHelper().getBlockTag("chat_form");
		Assert.assertEquals(chatFormBlockTag,expTagNameDiv,"No vote form block on the page!");

		
		
		app.getNavigationHelper().clickButtonExit();
	}

	@Test
	public void testAbonentType7() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test008";
		account.password = "008test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickButtonLogin();
		
		String tagNameVideoPlayer = app.getNavigationHelper().getTagNameVideoPlayer();
		//Assert.assertEquals(tagNameVideoPlayer,"","Player on the page!");

		String status1dText = app.getNavigationHelper().getStatus1dText();
		String expStatusRowText = "У вас не оплачено ни одно из мероприятий Ритмовремя-ТВ";
		assertThat(status1dText, containsString(expStatusRowText));

		
		
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
