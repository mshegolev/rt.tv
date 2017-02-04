package time.tv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by myname on 04.02.17.
 */
public class LoginPage extends Page {
    public LoginPage() {


    }


    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;
    public WebElement buttonLogin;
    public WebElement buttonForgotPassword;
    public WebElement buttonRegistry;
    public WebElement buttonAuth;
    public WebElement buttonSupport;
    public WebElement buttonTechData;

    public static String getButtonLoginName(String auth) {
        return auth;
    }





}
