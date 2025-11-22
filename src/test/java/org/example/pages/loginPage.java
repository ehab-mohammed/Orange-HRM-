package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends PageBase{
    @FindBy(css = "input[name=\"username\"]")
    public WebElement username;

    @FindBy(css = "input[name=\"password\"]")
    public WebElement password;

    @FindBy(className = "orangehrm-login-button")
    public WebElement loginbtn;

}
