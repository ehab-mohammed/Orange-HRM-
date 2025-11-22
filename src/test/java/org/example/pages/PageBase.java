package org.example.pages;

import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;

public class PageBase {

    public PageBase(){
        PageFactory.initElements(driver,this);
    }
}
