package OrangeHRM_StepDef;

import StepsPageObject.ClaimPage;
import StepsPageObject.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public LoginPage Lp;
    public ClaimPage Cp;
    public void driverWait(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
