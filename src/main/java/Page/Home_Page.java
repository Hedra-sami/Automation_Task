package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page {
    private WebDriver driver ;

    // Elements
    By Usernamefield = By.id("user-name");
    By Passwordfield = By.id("password");
    By Login_button = By.id("login-button");

    By invalid_text = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");



    // Constructor
    public Home_Page(WebDriver driver){
        this.driver = driver;
    }


    // Actions
    public boolean Check_Username(){
     return (driver.findElement(Usernamefield).isDisplayed());
    }
    public boolean Check_Password(){
        return (driver.findElement(Passwordfield).isDisplayed());
    }
    public boolean Check_Login_button(){
        return (driver.findElement(Login_button).isDisplayed());
    }
    public Account_Page login(String username , String password){
        driver.findElement(Usernamefield).sendKeys(username);
        driver.findElement(Passwordfield).sendKeys(password);
        driver.findElement(Login_button).click();
        return new Account_Page(driver);
    }
    public String Check_invalid_login(String username , String password){
        driver.findElement(Usernamefield).sendKeys(username);
        driver.findElement(Passwordfield).sendKeys(password);
        driver.findElement(Login_button).click();
        return (driver.findElement(invalid_text).getText());
    }
}
