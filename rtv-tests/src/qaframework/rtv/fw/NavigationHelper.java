package qaframework.rtv.fw;

import org.openqa.selenium.By;

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

	public  String getGiftBlockWithoutGiftContent() {return driver.findElement(By.id("paramList")).getText();}
	public  void clickGiftBlockFirstTable() {click(By.id("blockParams1"));}
}
