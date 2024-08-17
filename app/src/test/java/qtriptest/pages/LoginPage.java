package qtriptest.pages;

import qtriptest.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage  {
    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";

    @FindBy(xpath = "//input[@name='email']")
    WebElement Enter_UserName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement Enter_Password;

    @FindBy(xpath = "//button[text()='Login to QTrip']")
    WebElement Login_to_Qtrip;

    @FindBy(xpath = "//input[@placeholder='Search a City ']")
    WebElement Search_City;

    @FindBy(xpath = "//input[@id='autocomplete']/../ul")
    WebElement onAutoComplete;

   public LoginPage(RemoteWebDriver driver){
    this.driver = driver;
    // PageFactory.initElements(driver, this);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
   }

   public boolean navigateToLoginPage() throws InterruptedException{
    if(!driver.getCurrentUrl().equals(url)){
        driver.get(url);
    }
    return true;
}

   public void performLogin(String username ,String password) throws InterruptedException{
    Enter_UserName.sendKeys(username);
    Thread.sleep(1000);
    Enter_Password.sendKeys(password);
    // System.out.println(username+" hi "+password);
    Login_to_Qtrip.click();
    Thread.sleep(2000);
   }

  
   public  boolean Search_City(String city_name) throws InterruptedException{
    Search_City.clear();
    Search_City.sendKeys(city_name);
    Thread.sleep(3000);
      if(onAutoComplete.getText().equalsIgnoreCase(city_name)){
        return true;
      }
      return false;
   }

        public boolean verify_City_Not_found() throws InterruptedException{
            
                if(onAutoComplete.getText().equalsIgnoreCase("No City found")){
                     System.out.println("no city found :"+onAutoComplete.getText() );
                    return true;
                }
                System.out.println("no city found its failing  :"+onAutoComplete.getText() );
            return false;
        }

    public boolean verify_city_found(String city_name) throws InterruptedException{
    
            if(onAutoComplete.getText().equalsIgnoreCase(city_name)){
                 System.out.println("*******city found :"+onAutoComplete.getText() );
                return true;
            }
        return false;
    } 
    
    public void selectCity(){
        onAutoComplete.click();
    }

 
// public class LoginPage {
    
}
