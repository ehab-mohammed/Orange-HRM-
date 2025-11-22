package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class personalDetailsPage extends PageBase{

    @FindBy(css = "img[class=\"employee-image\"]")
    public WebElement pic;

    @FindBy(css = "input[name=\"firstName\"]")
    public WebElement firstname;

    @FindBy(linkText = "Personal Details")
    public WebElement details;

    @FindBy(css = "input[class=\"oxd-input oxd-input--active\"]")
    public WebElement empID;
}
