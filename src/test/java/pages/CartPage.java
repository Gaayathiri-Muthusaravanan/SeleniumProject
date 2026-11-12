package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="item_4_title_link")
    WebElement productTitle;

    public String getProductTitle(){
        return productTitle.getText();
    }


}
