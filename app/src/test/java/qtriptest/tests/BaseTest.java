package qtriptest.tests;

import qtriptest.ReportSingleton;
import qtriptest.SingletonDriver;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest  {

    static public RemoteWebDriver driver; // static because the value should not change
    public static ExtentReports report ;
    public static ExtentTest test;
    public static HomePage hp ;
    public static LoginPage lp;
    public static RegisterPage rp;
    public  static AdventurePage ap;
    public static AdventureDetailsPage adp;

    @BeforeSuite(alwaysRun = true)
    public void config() throws MalformedURLException{
        driver = SingletonDriver.getDriver();
        ReportSingleton rs1 = ReportSingleton.getInstanceOfSingletonReportClass();
        report = rs1.getReport();
        // System.out.println("  driver  "+ driver);
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        


        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        rp = new RegisterPage(driver);
        ap = new AdventurePage(driver);
        adp = new AdventureDetailsPage(driver);

        
        //  test = report.startTest("Qtrip");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.close();
         // TODO - End the test
         report.endTest(test);

         // TODO - Write the test to filesystem
         report.flush();

         

    }

    
}
