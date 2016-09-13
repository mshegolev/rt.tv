package qaframework.rtv.tests;


import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;


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
		Thread.sleep(5000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(2000);
		app.getNavigationHelper().clickpersonalArchiveEventsCatalogControl();
		Assert.assertTrue(app.getNavigationHelper().gettableArchiveEventsFirstRow());
		app.getNavigationHelper().clicktableArchiveEventsFirstRow();
		String getArchiveEventsModalName = app.getNavigationHelper().getArchiveEventsModalName();
		app.getNavigationHelper().clickBuyLink();
		Thread.sleep(2000);
		String getIpProductName = app.getNavigationHelper().getIpProductName();
		//org.hamcrest.MatcherAssert matcher = new MatcherAssert();
		
		MatcherAssert.assertThat(getIpProductName, containsString(getArchiveEventsModalName));
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
		//Thread.sleep(5000);
		//app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(2000);
		app.getNavigationHelper().clickpersonalArchiveEventsPurchasesControl();
		Thread.sleep(1000);
		
		String productId = app.getNavigationHelper().getProductId(); 
		
		//app.getNavigationHelper().openMainPage();
		
		app.getNavigationHelper().openPageForSetPayment();
		app.getNavigationHelper().fillFormForSetPayment(app, account, productId);
		app.getNavigationHelper().clickButtonSetPayment();	
		app.getNavigationHelper().openMainPage();
	
		Thread.sleep(4000);
		app.getNavigationHelper().clickpersonalArchiveEventsHeaderControl();
		Thread.sleep(500);
		app.getNavigationHelper().clickpersonalArchiveEventsPurchasesControl();
		String videoNameInCaralog = app.getNavigationHelper().getVideoNamePersonalArchiveEventsCatalog();
		Thread.sleep(3000);
		app.getNavigationHelper().clicktableArchiveEventsPurchasesFirstRow();
		Thread.sleep(3000);
		String archiveEventsPurchasesName = app.getNavigationHelper().getTextArchiveEventsPurchasesName();
		String expResult = "После нажатия на кнопку у вас будет 24 часа для просмотра фильма";
		Assert.assertEquals(archiveEventsPurchasesName, expResult, "Wrong text in lightbox");
	
		app.getNavigationHelper().clickarchiveEventsPurchasesVideo();
		
		//String getvideoNameLightbox = app.getNavigationHelper().getvideoNameLightbox();
	   // Assert.assertEquals(videoNameInCaralog, getvideoNameLightbox, "Text in table and in lightbox is not equal");
	    app.getNavigationHelper().clickCloseLightboxButton();
	    
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

