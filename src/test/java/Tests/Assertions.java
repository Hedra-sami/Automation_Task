package Tests;

import Page.Account_Page;
import Page.Home_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assertions{

    public WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";

    protected Home_Page homePage;

    /*
    - Open Chrome Driver
    - Navigate to the URL
    - Go to Home Page
     */


    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get(baseURL);
        homePage = new Home_Page(driver);
    }


    /*
    - Check Username Field is visible
    - Check Password Field is visible
    - Check Login Button Field is visible
     */


    @Test(priority = 0)
    public void homepage_check(){

        Assert.assertTrue(homePage.Check_Username());
        Assert.assertTrue(homePage.Check_Password());
        Assert.assertTrue(homePage.Check_Login_button());
    }

    /*
    - Check Login with valid credentials
     */

    @Test(priority = 1)
    public void account_check(){
       Account_Page account = homePage.login("standard_user","secret_sauce");
       Assert.assertEquals(account.Check_Title(),"Swag Labs");
       driver.get(baseURL);
    }

    /*
    - Check Login with invalid credentials
     */

    @Test(priority = 2)
    public void account_check_invalid(){

       Assert.assertEquals(homePage.Check_invalid_login("standard","secret"),"Epic sadface: Username and password do not match any user in this service");
       driver.get(baseURL);
    }

    /*
    - Check Login with empty password field
    - Check Login with empty username field
     */

    @Test(priority = 3)
    public void account_check_empty(){

        Assert.assertEquals(homePage.Check_invalid_login("standard",""),"Epic sadface: Password is required");
        driver.navigate().refresh();
        Assert.assertEquals(homePage.Check_invalid_login("","kdjbd"),"Epic sadface: Username is required");

        driver.get(baseURL);
    }

}
