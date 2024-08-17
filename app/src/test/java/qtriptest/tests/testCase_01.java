package qtriptest.tests;

import qtriptest.DProvider;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testCase_01 extends BaseTest {
    SoftAssert sa ;
    public String lastUsername;
      @Test(dataProvider = "TestCase1",dataProviderClass = DProvider.class,description = "verify Login flow" , priority = 1, groups={"Login Flow"},enabled = true)
    public void TestCase01(String Username,String password) throws InterruptedException{


        test = report.startTest("Verify User Registration Login-Logout");

        sa = new SoftAssert();
     
        hp.CheckNavigationToHomePage();

        try{
            sa.assertTrue(hp.CheckNavigationToHomePage());
            test.log(LogStatus.PASS, "Navigation to HomePage is successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Navigation to HomePage Failed");
        }

        hp.selectOptionsOnHomePage("Register");

        try{
            sa.assertTrue( rp.navigateToRegisterPage());
            test.log(LogStatus.PASS, "Navigation to Registertion is successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Navigation to Registertion Failed");
        }

        rp.registeerANewUser(Username,password,password,true);

        try{
            sa.assertTrue( lp.navigateToLoginPage());
            test.log(LogStatus.PASS, "Navigation to Login is successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Navigation to Login Failed");
        }

        lastUsername = rp.lastGeneratedUsername;

        lp.performLogin(lastUsername,password);

        try{
            sa.assertTrue( hp.verifyLogin());
            test.log(LogStatus.PASS, "Navigation to Login is successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Login process failed");
        }

        hp.selectOptionsOnHomePage("Logout");

        try{
            sa.assertTrue( hp.verifyLogut());
            test.log(LogStatus.PASS, "Navigation to Login is successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "LogOut process failed");
        }


         // TODO - End the test
         report.endTest(test);

         // TODO - Write the test to filesystem
         report.flush();
       
    }
}

