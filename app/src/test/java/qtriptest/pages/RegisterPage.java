package qtriptest.pages;

import qtriptest.tests.BaseTest;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage {
    RemoteWebDriver driver;

    public String lastGeneratedUsername = "";
    
    @FindBy(xpath = "//input[@name='email']")
    WebElement Enter_EmailAdd;

    @FindBy(xpath = "//input[@name='password']")
    WebElement Create_Password;

    @FindBy(xpath = "//input[@name='confirmpassword']")
    WebElement ReType_Password;

    @FindBy(xpath = "//button[text()='Register Now']")
    WebElement Register_Now;

    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;
        // System.out.println("-------------------------"+driver);
        // PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public boolean navigateToRegisterPage(){
        if(!driver.getCurrentUrl().endsWith("/pages/register/")){
            return false;
        }
        return true;
    }

    public boolean registeerANewUser(String username , String password ,String confirmPassword ,boolean generateRandomUsername) throws InterruptedException{
        
        
        if (generateRandomUsername == true)
        username = username+UUID.randomUUID().toString();
        
        Enter_EmailAdd.sendKeys(username);
        Create_Password.sendKeys(password);
        ReType_Password.sendKeys(confirmPassword);
        this.lastGeneratedUsername = username;
        Register_Now.click();
        Thread.sleep(3000);
        return this.driver.getCurrentUrl().endsWith("/login");
    }

    


    
 }
