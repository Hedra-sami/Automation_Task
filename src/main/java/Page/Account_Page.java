package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account_Page {
private WebDriver driver;

// Elements
By title = By.className("app_logo");

// Constructor
public Account_Page(WebDriver driver){
    this.driver = driver ;
}

// Actions
public String Check_Title(){
    return (driver.findElement(title).getText());
}
}
