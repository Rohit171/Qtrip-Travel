package qtriptest.tests;

import qtriptest.DProvider;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase_03 extends BaseTest {

    
     @Test(dataProvider = "TestCase3",dataProviderClass =DProvider.class,description = "verify booking and cancellation flow" , priority = 3, groups={"Booking and Cancellation Flow"},enabled = true)
    public void TestCase03(String user, String pass,String city,String adventure_name,String Guest_name ,String date,String count) throws InterruptedException{
        // // 1. Navigate to QTrip
        // // 2.Create a new User
        // lp.navigateToLoginPage();
        // lp.performLogin(user ,pass);
        // //3. Search for an adventure
        // lp.Search_City(city);
        // lp.selectCity();
        // adp.Search_for_Adventure(adventure_name);
        // //4. Enter Name and Date and Reserve the adventure
        // adp.click_0n_Adventure(adventure_name);
        // Thread.sleep(2000);
        // adp.Enter_Name(Guest_name);
        // adp.Enter_Date(date);
        // adp.Reserve(count);
        // adp.click_On_Reservation();
        // // 5. Verify that the adventure booking was successful
        // Assert.assertTrue(adp.verify_Succesful_booking(),"Resevation UnsucessFull!!!");
        // //6. Click on the history page
        // adp.click_ON_Res_History();
        // //7. Note down the transaction ID 
        // adp.get_transaction_id();
        // // 8. Cancel the Reservation
        // adp.cancel_Reservation(Guest_name);
        // //9. Refresh the page
        // adp.refresh_Page();
        // // 10. Check if the transaction ID is removed
        //  Assert.assertTrue(adp.check_remove_trans_id(),"Transcation is not cancel please cancel it");

         /**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
        //  String lastUsername;
        //  hp.CheckNavigationToHomePage();
        //  hp.selectOptionsOnHomePage("Register");
        //  rp.registeerANewUser(user,pass,pass,true);

        // lastUsername = rp.lastGeneratedUsername;    

        test = report.startTest("Booking and Cancellation Flow");

        lp.navigateToLoginPage();
        lp.performLogin(user ,pass);
    
        lp.Search_City(city);
        lp.selectCity();
        adp.Search_for_Adventure(adventure_name);
    
        adp.click_0n_Adventure(adventure_name);
        Thread.sleep(2000);
        adp.Enter_Name(Guest_name);
        adp.Enter_Date(date);
        adp.Reserve(count);
        adp.click_On_Reservation();
       
       

        try{
            Assert.assertTrue(adp.verify_Succesful_booking());
            test.log(LogStatus.PASS, "Reservation is suceesfull successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Resevation UnsucessFull!!!");
        }
        
        adp.click_ON_Res_History();
       
        adp.get_transaction_id();
       
        adp.cancel_Reservation(Guest_name);
        
        adp.refresh_Page();
        
         Assert.assertTrue(adp.check_remove_trans_id(),"Transcation is not cancel please cancel it");

         try{
            Assert.assertTrue(adp.check_remove_trans_id());
            test.log(LogStatus.PASS, "Transcation is  cancel suceesfull successfull !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Transcation is not cancel please cancel it!!!");
        }







    }
}

    