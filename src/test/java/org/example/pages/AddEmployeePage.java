package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends PageBase{

    @FindBy(css = "input[name=\"firstName\"]")
    public WebElement fname;

    @FindBy(css = "input[name=\"lastName\"]")
    public WebElement lname;

    @FindBy(css = "input[name=\"middleName\"]")
    public WebElement mname;

    @FindBy(xpath = "//input[@type='file' and contains(@class,'oxd-file-input')]")
    public WebElement img;

    @FindBy(css = "span.oxd-switch-input")
    public WebElement chackbox;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @autocomplete='off']")
    public WebElement uniqueUsername;

    @FindBy(css = "span.oxd-radio-input--active")
    public WebElement enable;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement savebtn;


}
