package OrangeHRM_StepDef;

import StepsPageObject.ClaimPage;
import StepsPageObject.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class stepDefinitions extends BaseClass{
    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","C://Driver//chromedriver.exe");
        driver=new ChromeDriver();
        Lp = new LoginPage(driver);
        Cp = new ClaimPage(driver);
    }
    @When("User open url {string}")
    public void user_open_url(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driverWait();



    }
    @When("User Enter Email as {string} and password as {string}")
    public void user_enter_email_as_and_password_as(String username, String password) {
        Lp.setUserName(username);
        Lp.password(password);

    }
    @When("Click on Login")
    public void click_on_login() {
        Lp.ClickOnLogin();
        driverWait();

    }
    @Then("Page Title Should be {string}")
    public void page_title_should_be(String Title) {
        String title = driver.getTitle();
        driverWait();
        if (Title.equals(title)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }


    }
    @Then("User click on Claim menu")
    public void user_click_on_claim_menu() {
        Cp.ClaimBtn();

    }
    @Then("User validate page title claim")
    public void user_validate_page_title_claim() {
        Cp.ClaimRequestPageTitle("Claim");
        driverWait();

    }
    @Then("User click on Assign Claim button")
    public void user_click_on_assign_claim_button() {
        Cp.AssignClaimBtn();
        driverWait();

    }
    @Then("User enter the claim request Details")
    public void user_enter_the_claim_request_details() throws InterruptedException {
        Cp.txtEmployeeName("P");
        Cp.DropdownEvent();
        Cp.DropdownCurrency("Australian Dollar");
        Cp.txtRemarks("Testing Assignment");


    }
    @Then("User click on Create button")
    public void user_click_on_create_button() {
        Cp.createBtn();
        driverWait();


    }
    @Then("User validate the the claim confirmation message")
    public void user_validate_the_the_claim_confirmation_message() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"oxd-toaster_1\"]/div")));
//        WebElement toastElement= driver.findElement(By.xpath("//div[@class='oxd-toaster_1']"));
        String confirmation_message ="Success";
        String toastMessage= driver.findElement(By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]")).getText();
//        JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
//       String toastMessage = (String) jsExecutor.executeScript("return argument[0].innerText",toastElement);
       if (toastMessage.contains(confirmation_message)){
           Assert.assertTrue(true);
       }else
           Assert.assertTrue(false);

       Thread.sleep(4000);

       By SubmitButton= By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button']");
//       driver.findElement(SubmitButton).click();

    }
    @Then("User validate the raised claim in Record")
    public void user_validate_the_raised_claim_in_record() {

        Cp.employeeClaimBtn();
        driverWait();
        Cp.claimRecord("Testing Assignment");


    }
    @Then("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        Thread.sleep(5000);
        Cp.dropDownlogoutBtn();
        driverWait();

    }
    @Then("Page Title  should be {string} after logout")
    public void page_title_should_be_after_logout(String logoutTitle) {
        String afterLogoutPageTitle=driver.getTitle();
        if (afterLogoutPageTitle.equals(logoutTitle)){
            Assert.assertTrue(true);
        }else
            Assert.assertTrue(false);

    }
    @Then("close browser")
    public void close_browser() {
        driver.quit();

    }

}
