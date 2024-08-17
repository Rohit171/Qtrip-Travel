package qtriptest.pages;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class AdventurePage {
    RemoteWebDriver driver;
    

   

    @FindBy(xpath = "//select[@id='category-select']/../div")
    WebElement clear_filter_by_cat;

    @FindBy(xpath = "//select[@name='duration']/../div")
    WebElement clear_filter_by_hours;

    public AdventurePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }


    public void select_Duration(String hours) throws InterruptedException{
        WebElement Filter_By_Duration = driver.findElement(By.xpath("//select[@name='duration']"));//Because from page factory you can get only static locator
        Select dropdown = new Select(Filter_By_Duration);
        dropdown.selectByVisibleText(hours);
        Thread.sleep(2000);
    }

        public boolean verify_time_duration(String hours){
        hours= hours.replace("Hours","");
        hours= hours.replace("-"," ");
        String []hr = hours.split(" ");
        int a = Integer.parseInt(hr[0]);
        int b = Integer.parseInt(hr[1]);
        

        List<WebElement>durations = driver.findElements(By.xpath("//h5[text()='Duration']/../p"));
        for(WebElement duration : durations){
    
            String[]s1 = duration.getText().split("Hours");
            char[]ch = s1[0].toCharArray();
            // System.out.println("char : "+ ch);
            if(ch[0]>=a || ch[0]<=b){
                // System.out.println("char : "+ ch + " AAA value :"+ a +"  BBB value :"+ b);
                return true;
            }
        }

        return false;
    }


    public void select_Category(String category) throws InterruptedException{
        WebElement Filter_By_Category = driver.findElement(By.xpath("//select[@id='category-select']"));//Because from page factory you can get only static locator
        Select dropdown = new Select(Filter_By_Category);
        dropdown.selectByVisibleText(category);
        // System.out.println("*&&&&&&&&&&&&--> : "+  category);
        Thread.sleep(2000);
    }

    public boolean verify_category_Value(String value){

      List<WebElement> cyclicTags = driver.findElements(By.xpath("//div[@class='col-6 col-lg-3 mb-4']/a/div[1]"));
        for(WebElement cyclic : cyclicTags){
            
            if(value.contains(cyclic.getText())){
                // System.out.println("*====--> : "+ cyclic.getText() );
                return true;
            }
        }
        return false;
    }

    public void clear_Filter_By_Category()  {
        clear_filter_by_cat.click();
        
    }

    public void clear_Filter_By_hrs(){
        clear_filter_by_hours.click();
    }
    public void NavigatebacktoHome(){
        driver.navigate().back();
    }


// public class AdventurePage {
}