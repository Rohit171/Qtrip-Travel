package qtriptest.pages;


import net.bytebuddy.asm.Advice.Return;
import qtriptest.tests.BaseTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AdventureDetailsPage extends BaseTest {
    RemoteWebDriver driver;
    
    @FindBy(xpath = "//input[@name='search-adventures']")
    WebElement Search_By_Adventure ;

    @FindBy(xpath = "//input[@name='name']")
    WebElement Enter_Name;

    @FindBy(xpath = "//input[@name='person']")
    WebElement Person_count;

    @FindBy(xpath = "//button[@class='reserve-button']")
    WebElement Reservation_button;

    @FindBy(xpath = "//input[@name='date']")
    WebElement Enter_date;

    @FindBy(xpath = "//a[text()='Reservations']")
    WebElement Resevation_History;

    @FindBy(xpath = "//tbody[@id='reservation-table']/tr/th")
    WebElement trans_id;

    @FindBy(xpath = "//tbody[@id='reservation-table']/tr/td[1]")
    WebElement Booking_name;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancel_button;

    @FindBy(xpath = "//div[@class='alert alert-dark']")
    WebElement No_Reservation;

    @FindBy(xpath = "//a[text()='Home']")
    WebElement Home;

    public AdventureDetailsPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void Search_for_Adventure(String Adventure) throws InterruptedException{
        Search_By_Adventure.clear();
        Thread.sleep(3000);
        // System.out.println(" Value Adventure : " +Adventure);
        Search_By_Adventure.sendKeys(Adventure);
        Thread.sleep(5000);
    }

    public void click_0n_Adventure(String Adventure) throws InterruptedException{
        List<WebElement> adventure_name = driver.findElements(By.xpath("//div[contains(@class,'flex-wrap pl-3 pr-3')]/h5"));

        for(WebElement ad : adventure_name){
            System.out.print("++++from Adventure List Value :"+ad.getText());
            System.out.print("++++Actual value Adventure  :"+ Adventure);
            if(!ad.getText().equalsIgnoreCase("Duration")){
                if(ad.getText().equalsIgnoreCase(Adventure)){
                    ad.click();
                  
                    Thread.sleep(3000);
                    break;
                }
               
                
            }
        }
        
    }
    public void Enter_Name(String name) throws InterruptedException{
        Enter_Name.sendKeys(name);
        Thread.sleep(3000);
    }

    public void Enter_Date(String Date){
        Enter_date.sendKeys(Date);
    }

    public void Reserve(String reserve) {
      Person_count.clear();
      Person_count.sendKeys(reserve);
        
    }

    public boolean verify_Succesful_booking(){

        WebElement Successfull = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        // System.out.println("THE SUCESS MESSAGE : "+ Successfull.getText());
        if(Successfull.getText().contains("this adventure is successful")){
            return true;
        }
        return false;
    }

    public void click_On_Reservation() throws InterruptedException{
        Reservation_button.click();
        Thread.sleep(3000);
    }

    public void click_ON_Res_History(){
        Resevation_History.click();
        
        
    }

    public void get_transaction_id(){
        trans_id.getText();
    }

    public void cancel_Reservation(String name) throws InterruptedException{
       
            cancel_button.click();
            Thread.sleep(3000);
    
    }

    public void refresh_Page() throws InterruptedException{
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    public boolean check_remove_trans_id(){

        if(No_Reservation.getText().contains("have not made any reservations yet!")){
            return true;
        }
        return false;

    }

    public void read_Data_Set(String DataSet) throws InterruptedException{
        String s1 []= DataSet.split(";");
        lp.Search_City(s1[0]);
        lp.selectCity();

        adp.Search_for_Adventure(s1[1]);
        adp.click_0n_Adventure(s1[1]);
        Thread.sleep(2000);
        adp.Enter_Name(s1[2]);
        adp.Enter_Date(s1[3]);
        adp.Reserve(s1[4]);
        adp.click_On_Reservation();

    }

    public void cancel_tc4(String DataSet) throws InterruptedException{
        String s1 []= DataSet.split(";");
        adp.cancel_Reservation(s1[2]);
        // ap.NavigatebacktoHome();
        // Thread.sleep(3000);
        // ap.NavigatebacktoHome();
        // Thread.sleep(3000);
        //  ap.NavigatebacktoHome();
        //  Thread.sleep(3000);
        // ap.NavigatebacktoHome();

        //  String mainWindowHandle = driver.getWindowHandle();
        // Set<String> allWindowHandles = driver.getWindowHandles();

        // List<String> li = new ArrayList<String>(allWindowHandles);

        // for(String l :li){
        //     String title = driver.switchTo().window(l).getWindowHandle();
        //     if(title.equals(mainWindowHandle)){
        //         driver.switchTo().window(mainWindowHandle);
        //     }
        
        // }  

        Home.click();
        Thread.sleep(3000);
        
    }

 }