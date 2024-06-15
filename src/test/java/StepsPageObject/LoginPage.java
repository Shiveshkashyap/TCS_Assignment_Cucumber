package StepsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver rDriver){
        driver=rDriver;
        PageFactory.initElements(rDriver,this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement txtUserName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txtpassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitButton;
    public void setUserName(String UserName){
        txtUserName.clear();
        txtUserName.sendKeys(UserName);
    }
    public void password(String pwd){
        txtpassword.clear();
        txtpassword.sendKeys(pwd);
    }
    public void ClickOnLogin(){
        SubmitButton.click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }
}
