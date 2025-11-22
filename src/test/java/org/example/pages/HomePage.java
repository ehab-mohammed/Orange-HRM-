package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement dropdownIcon;

    @FindBy(linkText = "Logout")
    public WebElement logoutbtn;

    @FindBy(linkText = "PIM")
    public WebElement pim;

    @FindBy(css = "i[class=\"oxd-icon bi-plus oxd-button-icon\"]")
    public WebElement addbtn;

    @FindBy(css = "input[placeholder=\"Type for hints...\"]")
    public WebElement searchNmae;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement searchbtn;

    @FindBy(css = "i[class=\"oxd-icon bi-trash\"]")
    public WebElement trashIcon;

    @FindBy(linkText = "Buzz")
    public WebElement Buzz;
}
