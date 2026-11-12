package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtilityClass;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @Parameters({"browser"})
    @Test(priority = 1,groups = "smoke", enabled = false)
    public void loginTest(String browser){
        System.out.println("Browser: " + browser);
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
    }
    @Test(priority = 3, groups = "regression",enabled = false)
    public void loginInvalidUserTest(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Raji");
        loginPage.enterPassword("secfdbfdhjf");
        loginPage.clickLogin();
        String actualError = loginPage.displayError();

        Assert.assertEquals(actualError,
                "Epic sadface: Username and password do not match any user in this service");
    }
    @Test(priority = 2, enabled = false)
    public void loginBlankUserTest(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        String actualError = loginPage.displayError();

        Assert.assertEquals(actualError,
                "Epic sadface: Username is required");
    }
    @Test(dependsOnMethods = "loginTest",enabled = false)
    public void dependentTest()
    {
        System.out.println("Dependent test executed");
    }

    @DataProvider(name = "excelData")
    public Object[][] loginData() throws IOException {
        ExcelUtilityClass excel = new ExcelUtilityClass();
        Object[][] data = new Object[excel.getRowCount()-1][excel.getColumnCount()];
        for(int i=1;i< excel.getRowCount();i++){
            for(int j=0;j<excel.getColumnCount();j++){
                data[i-1][j]= excel.getCellData(i,j);
            }
        }
        return data;

    }
    @Test(dataProvider = "excelData")
    public void dataProviderTest(String username,String password,String expectedResult) {

        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if(expectedResult.equals("success")) {
            //Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        }
        else{
            Assert.assertEquals(loginPage.displayError(),"Epic sadface: Username and password do not match any user in this service");
        }
    }
}
