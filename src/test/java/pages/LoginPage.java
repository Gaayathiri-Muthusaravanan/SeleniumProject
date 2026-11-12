package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id = 'user-name']")
    WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    WebElement password;
    @FindBy(xpath = "//input[@id = 'login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test = 'error']")
    WebElement errorMessage;
    public void enterUsername(String user){
        username.sendKeys(user);
    }
    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public String displayError(){
        return errorMessage.getText();
    }
    public void clickLogin(){
        loginButton.click();
    }
}
