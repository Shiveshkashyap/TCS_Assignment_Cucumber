package StepsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimPage {

    WebDriver driver;
    public ClaimPage(WebDriver rDriver){
        driver=rDriver;
        PageFactory.initElements(rDriver,this);

    }
    @FindBy (xpath = "//a[.='Claim']")
    WebElement ClaimBtn;
   @FindBy(xpath = "//div[.=' Assign Claim ']")
    WebElement AssignClaimBtn;
   @FindBy(xpath = "//div[.=' Assign Claim ']")
    WebElement ClaimRequestPageTitle;
   @FindBy(xpath = "//input[contains(@placeholder,'Type for hints..')]")
    WebElement txtEmployeeName;
   @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div")
    WebElement DropdownEvent;
   @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div")
    WebElement DropdownCurrency;

   @FindBy(xpath = "oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical")
    WebElement txtRemarks;
   @FindBy(xpath = "//button[.=' Create ']")
    WebElement createBtn;
   @FindBy(xpath = "//a[.='Employee Claims']")
    WebElement employeeClaimBtn;
   @FindBy(xpath = "//div[@class='orangehrm-container']")
    WebElement claimRecord;
   @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropDownlogoutBtn;
}
