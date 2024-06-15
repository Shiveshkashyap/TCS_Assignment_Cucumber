package StepsPageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClaimPage {

    WebDriver driver;
    public ClaimPage(WebDriver rDriver){
        driver=rDriver;
        PageFactory.initElements(rDriver,this);

    }
    @FindBy (xpath = "//a[.='Claim']")
    WebElement ClaimBtn;
   @FindBy(xpath = "//button[.=' Assign Claim ']")
    WebElement AssignClaimBtn;
   @FindBy(xpath = "//div[.=' Assign Claim ']")
    WebElement ClaimRequestPageTitle;
   @FindBy(xpath = "//input[contains(@placeholder,'Type for hints..')]")
    WebElement txtEmployeeName;
//   By DropdownEvent =By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/div");
    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/div")
    WebElement DropdownEvent;
   @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/div[1]")
    WebElement DropdownCurrency;

//   By DropdownCurrency = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div");

   @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    WebElement txtRemarks;
   @FindBy(xpath = "//button[.=' Create ']")
    WebElement createBtn;
   @FindBy(xpath = "//a[.='Employee Claims']")
    WebElement employeeClaimBtn;

   By ClaimRecordTable = By.xpath("//div[@class='oxd-table-card']//div[4]");
   @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropDownlogoutBtn;

   public void ClaimBtn(){
       ClaimBtn.click();
   }
   public void AssignClaimBtn(){
       AssignClaimBtn.click();
   }
   public void ClaimRequestPageTitle(String pageTitle){
       String Title = driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']")).getText();
       if (Title.equals(pageTitle)){
           Assert.assertTrue(true);
       }else
           Assert.assertTrue(false);

   }

   public void txtEmployeeName(String name) throws InterruptedException {
       txtEmployeeName.click();
       txtEmployeeName.sendKeys(name);
//       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
       Thread.sleep(3000);// Only this wait is working
//       Wait<WebDriver> wait = ne
//       w FluentWait<>(driver).withTimeout(Duration.ofSeconds(15));
//       WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5)); // for driver wait
//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=app]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/div[3]")));
//
//       List<WebElement>employeeName=driver.findElements(By.xpath("//div[@role='listbox']"));
//       System.out.println(employeeName);
////       Using argument number passing selecting dropdown
//        if (!employeeName.isEmpty()){
//            employeeName.get(0).click();
//        }else {
//            System.out.println("No dropdown found.");
//        }
       Actions actions= new Actions(driver);
       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

   }
   public void DropdownEvent() throws InterruptedException {
        DropdownEvent.click();
        Thread.sleep(5000);
//       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//      WebElement dropdownoptions= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//div[contains(text(),'Accommodation')]")));
////       List<WebElement>dropdown=driver.findElements(By.xpath("//div[@role='listbox']"));
//        dropdownoptions.click();

       Actions actions = new Actions(driver);
       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();


   }

   public void DropdownCurrency(String currency) throws InterruptedException {
//       Select dropdown2= new Select(driver.findElement(DropdownCurrency));
//       dropdown2.selectByVisibleText(currency);
       DropdownCurrency.click();
       Thread.sleep(3000);
//       List<WebElement>dropdown2=driver.findElements(By.xpath(""));
//       for (WebElement option2:dropdown2){
//           if (option2.getText().equals(currency)){
//               option2.click();
//               break;
//           }
//       }

       Actions actions = new Actions(driver);
//       actions.sendKeys(currency).sendKeys(Keys.ENTER).perform();
       actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
   }

   public void txtRemarks(String remarks){
       txtRemarks.sendKeys(remarks);
   }
   public void createBtn(){
       createBtn.click();
   }
   public void employeeClaimBtn(){
       employeeClaimBtn.click();
       driver.manage().timeouts().getPageLoadTimeout();
   }
   public void claimRecord(String Desc){
       WebElement recordlist=driver.findElements(By.xpath("//div[@class='oxd-table-body']/div//div[4]")).getFirst();
       String Recordlist = recordlist.getText();
//      String expectedDesc= txtRemarks.getText();
//       System.out.println("Recordlist = " + Recordlist);

       if (Recordlist.equals(Desc)){
           Assert.assertTrue(true);
       }else
           Assert.assertTrue(false);

   }


   public void dropDownlogoutBtn(){
       dropDownlogoutBtn.click();
       Actions actions= new Actions(driver);
       WebElement option=driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]"));
       actions.moveToElement(option).build().perform();

   }

}
