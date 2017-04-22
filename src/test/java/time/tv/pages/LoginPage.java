package time.tv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

/**
 * Sample page
 */
public class LoginPage extends AnyPages {


    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(id = "id__2_5")
    public WebElement buttonLogin;

    @FindBy(id = "id__2_3")
    private WebElement usernameField;

    @FindBy(id = "id__2_4")
    private WebElement passwordField;

    @FindBy(id = "USER_REMEMBER_frm")
    private WebElement rememberMe;

    @FindBy(xpath = ".//*[@id='app']/div[2]/div/div/form/div[3]/a[1]")
    private WebElement forgetPassword;

    @FindBy(id = ".//*[@id='app']/div[2]/div/div/form/div[3]/a[2]")
    private WebElement registration;


    public LoginPage(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    public LoginPage
    setUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public boolean clickLoginBtn() {
        if (buttonLogin.isDisplayed()) {
            buttonLogin.click();
            return true;
        } else System.out.println("Button Войти doesn't exist");
        return false;
    }

    public boolean enablerememberMe() {
        if (!rememberMe.isSelected()) {
            rememberMe.click();
            return true;
        }
        return true;
    }

    public boolean disablerememberMy() {
        if (rememberMe.isSelected()) {
            rememberMe.click();
            return true;
        }
        return true;
    }

    public boolean isRememberMe() {
        return rememberMe.isSelected();
    }

}
