package qaframework.rtv.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import qaframework.rtv.tests.AccountData;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage(){
		openMainPage("");
	};
	public void openMainPage(String url) {
		driver.get(String.format("%s%s", manager.baseUrl,url));
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
		return driver.findElements(By.id("auth_message")).get(0).getText() != null;
	}
	
	public boolean gettableSheduleFirstRow() {
        return driver.findElements(By.xpath(".//*[@id='tableShedule']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	
	public boolean checkAbonentType(String foundText) {
        if (getAbonentType().contains(foundText)) return true;
        else return false;
	}
	
    public String getAbonentType() {
        return driver.findElement(By.id("abonementType")).getText();
    }

	//public  void getPlayerContainer() { driver.findElement(By.id("videoArchivePlayer")).findElement(By.tagName("iframe"));}
	public  String getPlayerContainer() {return driver.findElement(By.id("videoArchivePlayer")).getTagName().toString();}
	public String getabonementTypeContent() {return driver.findElement(By.id("abonementType")).findElement(By.tagName("h4")).getText();}
	public  String getPlayerVideoContainer() {return driver.findElement(By.id("playerVideo")).getTagName().toString();}
	public boolean gettableSheduleLightFirstRow() {
        return driver.findElements(By.xpath(".//*[@id='tableSheduleLight']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	public String getstatus1Content(){return driver.findElement(By.id("status1")).getText(); }
	
	
	
	
	
	
	public  String getGiftBlockWithoutGiftContent() {return driver.findElement(By.id("paramList")).getText();}
	public  void clickGiftBlockFirstTable() {click(By.id("blockParams1"));}
	public String getFirstRowContentGiftTable() {return driver.findElement(By.id("jan2016RadasTVTable")).findElement(By.className("table_param_name")).getText();}
	

	
	
	public void clickIdPersoanlSubscribe() {click(By.id("personalSubscribe"));}
	public void clickOpenPhoneSubscribeButton() {click(By.id("OpenPhoneSubscribeButton"));}
	public String checkInputPhoneExistence() {
		return driver.findElement(By.id("phone")).getTagName();
	}
	
	public void fillPhone(String phone) {
		type(By.id("phone"), phone);
	}
	
	public void clickpersonalArchiveEventsHeaderControl(){
		
		//click(By.id("personalArchiveEventsHeaderControl"));
		WebElement element = driver.findElement(By.id("personalArchiveEventsHeaderControl"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	
	}
	public void clickpersonalArchiveEventsCatalogControl(){click(By.id("personalArchiveEventsCatalogControl"));}
	public void clickpersonalArchiveEventsPurchasesControl(){
		//click(By.id("personalArchiveEventsPurchasesControl"));
		WebElement element = driver.findElement(By.id("personalArchiveEventsPurchasesControl"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	public boolean gettableArchiveEventsFirstRow() {
		
        return driver.findElements(By.xpath(".//*[@id='archiveEvents']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	public boolean gettableArchiveEventsPurchasesFirstRow() {
        return driver.findElements(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }
	public void clicktableArchiveEventsFirstRow(){
		//click(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]"));
		WebElement element = driver.findElement(By.xpath(".//*[@id='archiveEvents']/table/tbody/tr[1]/td[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	
	}
	public void clicktableArchiveEventsPurchasesFirstRow(){
		//click(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]"));
		WebElement element = driver.findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	
	}
	public void clickBuyLink(){click(By.xpath(".//*[@id='archiveEventsModalLink']/a"));}
	public String getArchiveEventsModalName(){return driver.findElement(By.id("archiveEventsModalName")).getText();}
	public String getIpProductName(){
		driver.switchTo().frame(0);
		return driver.findElement(By.id("product_name")).getText();
		
	}
	public void navigate_back(){driver.navigate().back();}
	
	
	
	public void clickArchiveEventsPurchasesFirstRow(){click(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]"));}
	public String getNameArchiveEventsPurchasesFirstRow(){return driver.findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]/div")).getText();}
	public String getTextArchiveEventsPurchasesName(){
		driver.switchTo().frame(0); 
		return driver.findElement(By.id("archiveEventsPurchasesName")).getText();
	}
	public void clickarchiveEventsPurchasesVideo(){
		driver.switchTo().frame(1);
		click(By.xpath(".//*[@id='archiveEventsPurchasesVideo']/div/div"));
	}
	public String getvideoNameLightbox(){return driver.findElement(By.id("archiveEventsPurchasesName")).getText();}
	
	
	
	public void clickSendConfirmCode(){click(By.id("sendConfirmCode"));}
	public String getTextInsendCodeFailBlock(){return driver.findElement(By.id("sendCodeFail")).getText();}
	public String getTextInAgainCodeSendedBlock(){return driver.findElement(By.id("againCodeSended")).getText();}

	public void clickPersonalCioroicControl(){click(By.id("personalCioroicControl"));}
	public String getTextInPersonalTsioroits(){return driver.findElement(By.className("block_cont")).findElement(By.tagName("p")).getText();}
	
	public String getTextButtonCioroic(){return driver.findElement(By.id("buttonCioroic")).getText();}
	public void clickButtonCioroic(){click(By.id("buttonCioroic"));}
	
}
