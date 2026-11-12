package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{

    @Test
    public void addProductToCart(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        System.out.println(driver.getPageSource().contains("add-to-cart-sauce-labs-backpack"));
        ProductsPage productPage = new ProductsPage(driver);
        productPage.clickAddToCart();
        System.out.println(driver.getCurrentUrl());



    }
}
