package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addToCartButton;
    @FindBy(xpath="//a[@data-test='shopping-cart-link']")
    WebElement cartButton;

    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        System.out.println("Button text: " + addToCartButton.getText());
        System.out.println("Button displayed: " + addToCartButton.isDisplayed());
        System.out.println("Button enabled: " + addToCartButton.isEnabled());
        addToCartButton.click();
    }
    public void clickCart(){
        cartButton.click();
    }
}
