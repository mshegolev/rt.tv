package qaframework.rtv.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qaframework.rtv.tests.AccountData;

public class NavigationHelper extends HelperWithWebDriverBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage(){
        openUrl(manager.getProperty("baseUrl"));
	}

	public void clickButtonLogin() {
		click(By.id("auth_btn"));
	}

	public void clickButtonExit() {
		click(By.id("exit"));
	}

	public void clickButtonNavbarToggle() {
		click(By.cssSelector("button.navbar-toggle"));
	}

	public void clickCheckBoxRemember() {
		click(By.id("USER_REMEMBER_frm"));
	}

	public boolean checkWarrningMessage() {
		return findElements(By.id("auth_message")).get(0).getText() != null;
	}
	
	public boolean gettableSheduleFirstRow() {
        return findElements(By.xpath(".//*[@id='tableShedule']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	
	public boolean checkAbonentType(String foundText) {
        if (getAbonentType().contains(foundText)) return true;
        else return false;
	}
	
    public String getAbonentType() {
        return findElement(By.id("abonementType")).getText();
    }

	//public  void getPlayerContainer() { driver.findElement(By.id("videoArchivePlayer")).findElement(By.tagName("iframe"));}
	public  String getPlayerContainer() {return findElement(By.id("videoArchivePlayer")).getTagName().toString();}
	public String getabonementTypeContent() {return findElement(By.id("abonementType")).findElement(By.tagName("h4")).getText();}
	public  String getPlayerVideoContainer() {return findElement(By.id("playerVideo")).getTagName().toString();}
	public boolean gettableSheduleLightFirstRow() {
        return findElements(By.xpath(".//*[@id='tableSheduleLight']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	public String getstatus1Content(){return findElement(By.id("status1")).getText(); }
	public String getProductId(){
		return findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]")).getAttribute("data-product-id");
	}
	
	public void openPageForSetPayment() {
        openUrl(manager.getProperty("urlForSetPayment"));
	}
	
	public void fillFormForSetPayment(ApplicationManager applicationManager,
			AccountData accountData, String productId) {
		type(String.valueOf(By.id("user_login")), accountData.username);
		type(String.valueOf(By.id("product_id")), productId);
		findElement(By.id("add_payment")).click();
	}
	public void fillFormForUnsetPayment(ApplicationManager applicationManager,
			AccountData accountData, String productId) {
		type(String.valueOf(By.id("user_login")), accountData.username);
		type(String.valueOf(By.id("product_id")), productId);
	}
	
	public void clickButtonSetPayment(){findElement(By.id("submitForm")).click();}
	
	
	public  String getGiftBlockWithoutGiftContent() {return findElement(By.id("paramList")).getText();}
	public  void clickGiftBlockMenu() 
	{
		//click(By.id("paramsRadastv"));
		WebElement element = findElement(By.xpath(".//*[@id='paramsRadastv']"));
		element.click();
		//actions.moveToElement(element).click().perform();
	}
	
	public String getFirstRowContentGiftTable() {return findElement(By.xpath("//*[@id='jan2016RadasTVTable']/tbody/tr[1]/td[1]")).getText();}
	

	
	
	public void clickIdPersoanlSubscribe() {click(By.id("personalSubscribe"));}
	public void clickOpenPhoneSubscribeButton() {click(By.id("OpenPhoneSubscribeButton"));}
	public String checkInputPhoneExistence() {
		return findElement(By.id("phone")).getTagName();
	}
	
	public void fillPhone(String phone) {
		type(String.valueOf(By.id("phone")), phone);
	}
	
	public String getVideoNamePersonalArchiveEventsCatalog()
	{
		return findElement(By.xpath("//*[@id='archiveEventsPurchases']/table/tbody/tr/td[2]/div")).getAttribute("data-name");
	}
	
	public void clickpersonalArchiveEventsHeaderControl(){
		
		WebElement elementToClick = findElement(By.id("personalArchiveEventsHeaderControl"));
		
		WebElement rateElement = findElement(By.id("personalArchiveEventsHeaderControl"));
        new JavascriptExecutor() {
            @Override
            public Object executeScript(String s, Object... objects) {
                return null;
            }

            @Override
            public Object executeAsyncScript(String s, Object... objects) {
                return null;
            }
        }.executeScript("arguments[0].click();",rateElement);
        //(javascriptExecutor).executeScript("arguments[0].click();",rateElement);


		//WebElement element = driver.findElement(By.id("personalArchiveEventsHeaderControl"));
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView()", element); 
		//Actions actions = new Actions(driver);
		//click(By.id("personalArchiveEventsHeaderControl"));
		//actions.moveToElement(element).click().perform();
	}
	public void clickPersonalArchiveEventsCatalogControl(){
		WebElement element = findElement(By.id("personalArchiveEventsCatalogControl"));
        WebDriver driver = null;
        Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	
	public void clickpersonalArchiveEventsCatalogControl(){click(By.id("personalArchiveEventsCatalogControl"));}
//	public void clickpersonalArchiveEventsPurchasesControl(){
//		//click(By.id("personalArchiveEventsPurchasesControl"));
//		WebElement element = findElement(By.id("personalArchiveEventsPurchasesControl"));
//		Actions actions = new Actions();
//		actions.moveToElement(element).click().perform();
//	}

	public boolean gettableArchiveEventsFirstRow() {
		
        return findElements(By.xpath(".//*[@id='archiveEvents']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	public boolean gettableArchiveEventsPurchasesFirstRow() {
        return findElements(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
//	public void clicktableArchiveEventsFirstRow(){
//		//click(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]"));
//		WebElement element = findElement(By.xpath(".//*[@id='archiveEvents']/table/tbody/tr[1]/td[1]"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().perform();
//	}

	public void clicktableArchiveEventsPurchasesFirstRow(){
		click(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr/td[1]"));
		//WebElement element = driver.findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr/td[1]"));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(element).click().perform();
	
	}
	public void clickBuyLink(){click(By.xpath(".//*[@id='archiveEventsModalLink']/a"));}
	public String getArchiveEventsModalName(){return findElement(By.id("archiveEventsModalName")).getText();}
//	public String getIpProductName(){
//		switchTo().frame(0);
//		return driver.findElement(By.id("product_name")).getText();
//
//	}
//	public void navigate_back(){driver.navigate().back();}
	
	
//	public String getNameArchiveEventsPurchasesFirstRow(){return driver.findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]/div")).getText();}
	public String getTextArchiveEventsPurchasesName(){
		//driver.switchTo().frame(0);  
//String a = driver.findElement(By.id("archiveEventsBlockPurchases")).findElement(By.tagName("h4")).getText();
		return  findElement(By.xpath(".//*[@id='archiveEventsPurchasesName']")).getText();
	}
	public void clickarchiveEventsPurchasesVideo(){
		//driver.switchTo().frame(0);
		click(By.xpath(".//*[@id='archiveEventsPurchasesVideo']/div/div"));
	}
	public void clickCloseLightbox(){
		//driver.switchTo().frame(0);
		click(By.xpath(".//*[@id='modal-archiveEventsPurchases']/div/div/div[1]/button"));
	}
	
	public String getvideoNameLightbox(){return findElement(By.xpath("//*[@id='modal-archiveEventsPurchases/div/div/div/h4']")).getText();}
	public void clickCloseLightboxButton(){click(By.xpath("//*[@id='modal-archiveEventsPurchases']/div/div/div[1]/button"));}

	
	public void clickBodyElement(){click(By.id("personalContent"));}
	
	
	public void clickSendConfirmCode(){click(By.id("sendConfirmCode"));}
	public String getTextInsendCodeFailBlock(){return findElement(By.id("sendCodeFail")).getText();}
	public String getTextInAgainCodeSendedBlock(){return findElement(By.id("againCodeSended")).getText();}

	public void clickPersonalCioroicControl(){click(By.id("personalCioroicControl"));}
	public String getTextInPersonalTsioroits(){return findElement(By.className("block_cont")).findElement(By.tagName("p")).getText();}
	
	public String getTextButtonCioroic(){return findElement(By.id("buttonCioroic")).getText();}
	public void clickButtonCioroic(){click(By.id("buttonCioroic"));}
	
	
	
	//test for users roles 
	public String getNextInRtv(){return findElement(By.xpath(".//*[@id='status1d']/div/h4")).getText(); }
	public String getClassAccessButton(){return findElement(By.xpath(".//*[@id='tableShedule']/table/tbody/tr[1]/td[4]/span")).getClass().toString(); }
	public String getEventId(){return findElement(By.xpath(".//*[@id='tableShedule']/table/tbody/tr[1]")).getAttribute("data-id");}
	public String getEventById(String eventId){return findElement(By.id(eventId)).getText();}
	public String getEventDateInTable(){return findElement(By.xpath("//*[@id='tableShedule']/table/tbody/tr[1]/td[1]")).getText(); }
	public String getTagNameVideoPlayer(){return findElement(By.id("player_video")).getTagName().toString();}
	public String getStatusRowText(){return findElement(By.id("status1")).getText();}
	public String getBlockTag(String block_id){return findElement(By.id(block_id)).getTagName().toString(); }
	public String getStatus1dText(){return findElement(By.xpath("//*[@id='status1d']/div/h3")).getText();}
	//public boolean existenceOfPlayer(){return driver.findElement(By.id("player_video")).getSize().toString();}

	public String getFirstGiftBlockContent(){return findElement(By.xpath("//*[@id='blockParams1']/div/h4")).getText();}

	public  void clickGiftBlockFirstTable() 
	{
		WebElement element = findElement(By.id("newParam"));
		JavascriptExecutor jse = new JavascriptExecutor() {
            @Override
            public Object executeScript(String s, Object... objects) {
                return null;
            }

            @Override
            public Object executeAsyncScript(String s, Object... objects) {
                return null;
            }
        };

        jse.executeScript("arguments[0].scrollIntoView()", element);
		click(By.id("newParam"));
	}
	
	public void clickPersonalSubscribeBlock(){
		WebElement element = findElement(By.id("personalSubscribeControl"));
		JavascriptExecutor jse = new JavascriptExecutor() {
            @Override
            public Object executeScript(String s, Object... objects) {
                return null;
            }

            @Override
            public Object executeAsyncScript(String s, Object... objects) {
                return null;
            }
        };
		jse.executeScript("arguments[0].scrollIntoView()", element); 
		click(By.xpath("//*[@id='personalSubscribeControl']/a"));
	}
	public String getNamePersonalSubscribeBlock(){
		WebElement element = findElement(By.id("subscribeEmailBlock"));
		JavascriptExecutor jse = new JavascriptExecutor() {
            @Override
            public Object executeScript(String s, Object... objects) {
                return null;
            }

            @Override
            public Object executeAsyncScript(String s, Object... objects) {
                return null;
            }
        };
        jse.executeScript("arguments[0].scrollIntoView()", element);
		return findElement(By.xpath("//*[@id='subscribeEmailBlock']/h3[1]")).getText();}
}
