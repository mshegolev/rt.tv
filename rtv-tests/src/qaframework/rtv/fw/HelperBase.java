package qaframework.rtv.fw;

import org.openqa.selenium.*;

public abstract class HelperBase {

    public boolean acceptNextAlert = true;
    protected ApplicationManager manager;
    protected WebDriver driver;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.driver;

    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            manager.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = manager.driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    /**
     * @param locator
     */
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * @param locator
     * @param text
     */
    protected void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

}