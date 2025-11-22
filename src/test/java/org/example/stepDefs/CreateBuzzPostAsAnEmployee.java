package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.BUZZpage;
import org.example.pages.loginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class CreateBuzzPostAsAnEmployee {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    loginPage login = new loginPage();
    HomePage home = new HomePage();
    SoftAssert soft = new SoftAssert();
    BUZZpage buzz = new BUZZpage();

    @Given("the employee is logged in with valid credentials")
    public void EmployeeLogin(){
        login.username.sendKeys(configReaders.get("employeename"));
        login.password.sendKeys(configReaders.get("employeepassword"));
        login.loginbtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(home.dropdownIcon));

        home.dropdownIcon.click();
        soft.assertTrue(home.logoutbtn.isDisplayed());
        soft.assertAll();

    }

    @When("the employee navigates to the Buzz from the main menu")
    public void theEmployeeNavigatesToTheBuzzFromTheMainMenu() {

        home.Buzz.click();
    }

    @And("enters a text message with attaches an image")
    public void entersATextMessage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(buzz.text));
        buzz.text.sendKeys(configReaders.get("post"));

//        buzz.sharePhotobtn.click();
//
//        buzz.addPhoto.sendKeys("D:\\automationTask\\OrangeHrm\\src\\test\\resources\\images\\Automated.jpg");
//        Thread.sleep(2000);
//        buzz.shareBtn.click();

        buzz.postBtn.click();


    }

    @Then("the post displays the correct text content")
    public void thePostDisplaysTheCorrectTextContent() {
        String  sure = driver.findElements(By.cssSelector("p.orangehrm-buzz-post-body-text")).get(0).getText();
        Assert.assertEquals(sure,configReaders.get("post"));

    }

    @And("the employee name and timestamp are displayed")
    public void theEmployeeNameAndTimestampAreDisplayed() {

        String firstname = configReaders.get("firstname");
        String middlename = configReaders.get("middlename");
        String lastname = configReaders.get("lastname");
        String fullname = firstname + " " + middlename + " " + lastname;
        String name = driver.findElements(By.cssSelector("p.orangehrm-buzz-post-emp-name")).get(0).getText();
        Assert.assertEquals(name,fullname);

        String time = driver.findElements(By.cssSelector("p.orangehrm-buzz-post-time")).get(0).getText();
        Assert.assertFalse(time.isEmpty());

    }

    @And("if the employee attempts to post without text or media, a validation message is shown")
    public void ifTheEmployeeAttemptsToPostWithoutTextOrMediaAValidationMessageIsShown() throws InterruptedException {

        //just the share button still disabled the employee can not attempt tho post without text
        Thread.sleep(3000);
        buzz.sharePhotobtn.click();
        Thread.sleep(3000);
        Assert.assertTrue(buzz.shareBtn.isDisplayed());




    }

}
