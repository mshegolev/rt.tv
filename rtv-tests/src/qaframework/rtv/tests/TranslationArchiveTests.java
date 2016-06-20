package qaframework.rtv.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TranslationArchiveTests extends TestBase  {
	@Test 
	public void catalogExist() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		Thread.sleep(2000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		app.getNavigationHelper().clickpersonalArchiveEventsCatalogControl();
		Assert.assertTrue(app.getNavigationHelper().gettableArchiveEventsFirstRow());
		app.getNavigationHelper().clicktableArchiveEventsPurchasesFirstRow();
		//String getArchiveEventsModalName = app.getNavigationHelper().getArchiveEventsModalName();
		app.getNavigationHelper().clickBuyLink();
		
		
		
		app.getNavigationHelper().clickButtonExit();
	}
	@Test
	public void catalogBoughtEventsExist() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test001";
		account.password = "001test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(2000);
		app.getNavigationHelper().clickpersonalArchiveEventsPurchasesControl();
		Assert.assertTrue(app.getNavigationHelper().gettableArchiveEventsPurchasesFirstRow());
		app.getNavigationHelper().clickArchiveEventsPurchasesFirstRow();
		String archiveEventsPurchasesName = app.getNavigationHelper().getTextArchiveEventsPurchasesName();
		String expResult = "�� ����� ������ ������ ��������?";
		Assert.assertEquals(archiveEventsPurchasesName, expResult, "Wrong text in lightbox");

		//�������� ���������
		app.getNavigationHelper().clickarchiveEventsPurchasesVideo();
		app.getVideoHelper().videoTranslationArchivePlayerIframe(); //ToDo
		
		app.getNavigationHelper().clickButtonExit();
	}
	
	
	
}

