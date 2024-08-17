package qtriptest;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapper {

//     /*Check if the element is displayed before attempting to click

//     Scroll in to view before clicking on an element
    
//     return false if the element is not displayed / any other exception*/
    
    public static boolean click(WebElement elementToClick, WebDriver driver) throws InterruptedException{

        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
//     /*clear the existing text on the inputBox
    
//     Type in the new keys*/

     public static boolean sendKeys(WebElement inputBox, String keysToSend) {

        try{
            if(inputBox.isDisplayed()){
                if(inputBox.isEnabled()){
                    inputBox.clear();
                    inputBox.sendKeys(keysToSend);
                }
                return false;
            }
            return false;
        }catch(ElementNotInteractableException e){
            e.printStackTrace();
        }

        return false;
     }
    
//    /*  Navigate to the given url if the current url is not equal to the given url
    
//     after navigation, ensure that the current url is updated as per the given url*/
    
    public static boolean navigate(WebDriver driver, String url){
        boolean status;

        try {
            status = driver.getCurrentUrl().equals(url);

            if (!status) {
                driver.get(url);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception based on your requirements
            status = false;
        }

        return status;
 }
    
//    /*  Try to find the webelement with the given By
    
//     if the element is not found, retry for the given number of times
    
//     if you do not want retry, set the retry value to*/
    
    public static WebElement findElementWithRetry(WebDriver driver, By by, int retryCount) throws Exception{

        WebElement ele = null;

        for (int i = 0; i < retryCount; i++) {
            try {
                ele = driver.findElement(by);
                break; 
            } catch (NoSuchElementException e) {
                // Handle the exception based on your requirements
                System.out.println("Attempt " + (i + 1) + ": Element not found. Retrying...");
            }
        }

        return ele;
    }

}
