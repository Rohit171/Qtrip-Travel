package qtriptest.pages;

import qtriptest.tests.BaseTest;
import javax.xml.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage  {

    RemoteWebDriver driver;

    String url = "https://qtripdynamic-qa-frontend.vercel.app/";


    @FindBy(xpath = "//h1[text()='Welcome to QTrip']")
    WebElement Welcomee;

   
    @FindBy(xpath = "//a[text()='Login Here']")
    WebElement Login_Button;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement Register_Button;

    @FindBy(xpath = "//a[text()='Home']")
    WebElement Home_Button;

    @FindBy(xpath = "//a[text()='Reservations']")
    WebElement Reservation_Button;

    @FindBy(xpath = "//div[text()='Logout']")
    WebElement Logout;


  
    public  HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        // System.out.println(" Homepage driver --> "+ driver);
        // PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    //Navigate to the Home page of QTrip

    public boolean CheckNavigationToHomePage(){
        // System.out.println(" Homepage driver --> "+ driver);
        System.out.println(driver.getCurrentUrl());
        if(!driver.getCurrentUrl().equals(url)){
            driver.get(url);
           
        }
        return true;
    }

    public void selectOptionsOnHomePage(String Options) throws InterruptedException{
        if(Options.equalsIgnoreCase("Register")){
            Register_Button.click();
            Thread.sleep(2000);

        }else if(Options.equalsIgnoreCase("Login")){
            Login_Button.click();
            Thread.sleep(2000);

        }else if(Options.equalsIgnoreCase("Reservations")){
            Reservation_Button.click();
            Thread.sleep(2000);

        }else if(Options.equalsIgnoreCase("Logout")){
            Logout.click();
            Thread.sleep(2000);
        }else{
            Home_Button.click();
        }
    }


    public boolean verifyLogin(){
         if(driver.findElement(By.xpath("//h1[text()='Welcome to QTrip']")).getText().equalsIgnoreCase("Welcome to QTrip")){
            return true;
         }
         return false;
    }

    public boolean verifyLogut(){
        return Register_Button.isDisplayed();
    }

    

// public class HomePage {
 }
