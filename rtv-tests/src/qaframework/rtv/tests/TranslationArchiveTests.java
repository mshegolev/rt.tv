package qaframework.rtv.tests;


import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TranslationArchiveTests extends TestBase  {
	@Test(testName = "RTV-19", description = "Catalog Exist")
	public void catalogExist() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test004";
		account.password = "004test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		Thread.sleep(3000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(5000);
		String getArchiveCatalogName = app.getNavigationHelper().getArchiveCatalogName();
		String expArchiveCatalogName = "Архив мероприятий. Каталог";
		Assert.assertEquals(getArchiveCatalogName, expArchiveCatalogName, "Wrong page name");
		app.getNavigationHelper().clicktableArchiveEventsFirstRow();		
		String getArchiveEventsModalName = app.getNavigationHelper().getArchiveEventsModalName();
		app.getNavigationHelper().clickBuyLink();
		Thread.sleep(2000);
		String getIpProductName = app.getNavigationHelper().getIpProductName();
		//org.hamcrest.MatcherAssert matcher = new MatcherAssert();
		MatcherAssert.assertThat(getIpProductName, getIpProductName.contains(getArchiveEventsModalName));
		app.getNavigationHelper().navigate_back();
		Thread.sleep(2000);
		app.getNavigationHelper().clickButtonExit();
	}
	
	
	@Test
	public void catalogBoughtEventsExist() throws Exception {
		app.getNavigationHelper().openMainPage();
		AccountData account = new AccountData();
		account.username = "test003";
		account.password = "003test";
		app.getAccountHelper().fillLoginForm(app, account);
		app.getNavigationHelper().clickCheckBoxRemember();
		app.getNavigationHelper().clickButtonLogin();
		Thread.sleep(5000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(8000);
		app.getNavigationHelper().clickpersonalArchiveEventsPurchasesControl();
		Thread.sleep(6000);
		
		String emptyBoughtCatalogText = app.getNavigationHelper().getEmptyBoughtCatalogText();
		String expTextInBoughtPage = "У вас не куплено ни одной записи трансляции,";
		MatcherAssert.assertThat(emptyBoughtCatalogText, emptyBoughtCatalogText.contains(expTextInBoughtPage));
		
		app.getNavigationHelper().clickPersonalArchiveEventsCatalogControlFromPurchases();
		Thread.sleep(3000);
		String productId = app.getNavigationHelper().getProductId(); 
		
		//app.getNavigationHelper().openMainPage();
		
		app.getNavigationHelper().openPageForSetPayment();
		app.getNavigationHelper().fillFormForSetPayment(app, account, productId);
		app.getNavigationHelper().clickButtonSetPayment();	
		app.getNavigationHelper().openMainPage();
	
		Thread.sleep(4000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(500);

		String videoNameInCatalog = app.getNavigationHelper().getNameFirstVideoInCatalog();
		Thread.sleep(3000);
		app.getNavigationHelper().clicktableArchiveEventsFirstRow();
		Thread.sleep(3000);
		
		String archiveEventsPurchasesName = app.getNavigationHelper().getTextArchiveEventsPurchasesName();
		String expResult = "После нажатия на кнопку у вас будет 24 часа для просмотра фильма";
		Assert.assertEquals(archiveEventsPurchasesName, expResult, "Wrong text in lightbox");
	
		String getvideoNameLightbox = app.getNavigationHelper().getArchiveEventsModalName();
	    Assert.assertEquals(videoNameInCatalog, getvideoNameLightbox, "Text in table and in lightbox is not equal");
	   
	    app.getNavigationHelper().clickAgreeWatchingButton();
	    Thread.sleep(500);
	    //проверка , что времени осталось 24 часа
	    String restTime = app.getNavigationHelper().getRestTimeText();
	    String expRestTime = "24 часа";
	    Assert.assertEquals(expRestTime, restTime, "Rest time in lightbox is not 24 hour");
	    
//	    app.getNavigationHelper().clickCloseLightboxButton();
	    
		app.getNavigationHelper().openPageForSetPayment();
		app.getNavigationHelper().fillFormForUnsetPayment(app, account, productId);
		app.getNavigationHelper().clickButtonSetPayment();	
		app.getNavigationHelper().openMainPage();
		
	//	app.getNavigationHelper().clickButtonExit();
	//	app.getVideoHelper().videoTranslationArchivePlayerIframe(); //ToDo
		
		//app.getNavigationHelper().clickCloseLightbox();
		app.getNavigationHelper().clickButtonExit();
	}
	
	
	

	
	
}

