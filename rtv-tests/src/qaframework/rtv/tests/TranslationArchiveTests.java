package qaframework.rtv.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TranslationArchiveTests extends TestBase  {

	@Test(testName = "RTV-19", description = "Catalog Exist")
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
		//app.getNavigationHelper().clickpersonalArchiveEventsCatalogControl();
		//Assert.assertTrue(app.getNavigationHelper().gettableArchiveEventsFirstRow());
		app.getNavigationHelper().clicktableArchiveEventsFirstRow();
		String getArchiveEventsModalName = app.getNavigationHelper().getArchiveEventsModalName();
		app.getNavigationHelper().clickBuyLink();
		Thread.sleep(2000);
		String getIpProductName = app.getNavigationHelper().getIpProductName();
		Assert.assertEquals(getIpProductName, getArchiveEventsModalName, "Product in IP is not equal produst in RTV");
		app.getNavigationHelper().navigate_back();
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
		Thread.sleep(2000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(500);
		app.getNavigationHelper().clickpersonalArchiveEventsPurchasesControl();
		//Assert.assertTrue(app.getNavigationHelper().gettableArchiveEventsPurchasesFirstRow());
		app.getNavigationHelper().clickArchiveEventsPurchasesFirstRow();
		String getTextArchiveEventsPurchasesName = app.getNavigationHelper().getTextArchiveEventsPurchasesName();
			String archiveEventsPurchasesName = app.getNavigationHelper().getTextArchiveEventsPurchasesName();
			String expResult = "После нажатия на кнопку у вас будет 24 часа для просмотра фильма";
			Assert.assertEquals(archiveEventsPurchasesName, expResult, "Wrong text in lightbox");
	//	
			app.getNavigationHelper().clickarchiveEventsPurchasesVideo();
		String getvideoNameLightbox = app.getNavigationHelper().getvideoNameLightbox();
		Assert.assertEquals(getTextArchiveEventsPurchasesName, getvideoNameLightbox, "Text in table and in lightbox is not equal");

		
	//	app.getVideoHelper().videoTranslationArchivePlayerIframe(); //ToDo
	//	
		//app.getNavigationHelper().clickButtonExit();
	}
	
	
	
}

