package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.AddEmployeePage;
import org.example.pages.HomePage;
import com.github.javafaker.Faker;
import org.example.pages.loginPage;
import org.example.pages.personalDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;


public class addEmployee {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Faker fake = new Faker();
    AddEmployeePage add = new AddEmployeePage();
    loginPage login = new loginPage();
    HomePage home = new HomePage();
    SoftAssert soft = new SoftAssert();
    personalDetailsPage personal = new personalDetailsPage();

   @Given("admin logs in with valid credentials")
    public void AddminLogin()
   {
       login.username.sendKeys(configReaders.get("userName"));
       login.password.sendKeys(configReaders.get("password"));
       login.loginbtn.click();


       wait.until(ExpectedConditions.elementToBeClickable(home.dropdownIcon));

       home.dropdownIcon.click();
       soft.assertTrue(home.logoutbtn.isDisplayed());
       soft.assertAll();

   }

 @When("navigates to PIM add employee page")
 public void navigatesToPIMAddEmployeePage() {

       home.pim.click();
     soft.assertTrue(home.addbtn.isDisplayed());
     soft.assertAll();
 }

 @And("enters first name and last name")
 public void entersFirstNameAndLastName() {


      wait.until(ExpectedConditions.elementToBeClickable(home.addbtn)).click();

      String fname = fake.name().firstName();
      String lname = fake.name().lastName();

      configReaders.set("firstname",fname);
      configReaders.set("lastname",lname);

      add.fname.sendKeys(fname);
      add.mname.sendKeys(configReaders.get("middlename"));
      add.lname.sendKeys(lname);

 }

 @And("uploads profile picture")
 public void uploadsProfilePicture()  {
       String ID = fake.number().digits(6);
       configReaders.set("EmployeeId",ID);

           driver.findElements(By.xpath("//input[@class=\"oxd-input oxd-input--active\"]"))
                   .get(1).sendKeys(ID);

       add.img.sendKeys("D:\\automationTask\\OrangeHrm\\src\\test\\resources\\images\\test.jpg");


 }

 @And("enables login details with username and password")
 public void enablesLoginDetailsWithUsernameAndPassword() throws InterruptedException {

        String empName = fake.name().fullName();
        configReaders.set("employeename",empName);

       add.chackbox.click();

       add.uniqueUsername.sendKeys(empName);

       add.enable.click();

     List<WebElement> password = driver.findElements(By.xpath("//input[@type='password']"));
       password.get(0).sendKeys(configReaders.get("employeepassword"));
       password.get(1).sendKeys(configReaders.get("employeepassword"));
       add.savebtn.click();
       Thread.sleep(3000);
 }

 @Then("employee personal page is displayed")
 public void employeePersonalPageIsDisplayed() {


     wait.until(ExpectedConditions.visibilityOf(personal.details));

     soft.assertTrue(personal.details.isDisplayed());


 }

 @And("employee profile picture should be visible")
 public void employeeProfilePictureShouldBeVisible() {

     wait.until(ExpectedConditions.visibilityOf(personal.pic));
     soft.assertTrue(personal.pic.isDisplayed());

     soft.assertAll();

 }

 @And("employee who added appears in employee list")
 public void employeeWhoAddedAppearsInEmployeeList() throws InterruptedException {

       //that include admin search to verify employee data

     home.pim.click();
     home.searchNmae.sendKeys(configReaders.get("lastname"));

     Thread.sleep(3000);
     home.searchbtn.click();
     Assert.assertTrue(home.trashIcon.isDisplayed());





 }

}
