package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BUZZpage extends PageBase{

    @FindBy(className = "oxd-buzz-post-input")
    public WebElement text;

    @FindBy(css = "button.oxd-glass-button")
    public WebElement sharePhotobtn;

    @FindBy(className = "oxd-file-input")
    public WebElement addPhoto;

    @FindBy(css = "button[disabled]")
    public WebElement shareBtn;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main")
    public WebElement postBtn;


}
