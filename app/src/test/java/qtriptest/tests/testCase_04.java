package qtriptest.tests;

import qtriptest.DProvider;
import org.testng.annotations.Test;

public class testCase_04 extends BaseTest {

       @Test(dataProvider = "TestCase4",dataProviderClass =DProvider.class,description = "verify Relaibility flow" , priority = 4, groups={"Reliability Flow"},enabled = true)
    public void TestCase04(String user, String pass,String DataSet1 ,String DataSet2,String DataSet3) throws InterruptedException{
       // 1. Navigate to QTrip
        // 2.Create a new User
        lp.navigateToLoginPage();
        lp.performLogin(user,pass);

        // 3. Search for an adventure
        // 4. Enter Name and Date and Reserve the adventure
        // 5. Verify that the adventure booking was successful
        // 6. Repeat steps 3-5 to make two more bookings
        // 7. Click on the History Page
        // 8. Check if all the bookings are displayed on the history page
    
        adp.read_Data_Set(DataSet1);       
        adp.click_ON_Res_History();       
        adp.cancel_tc4( DataSet1);      

        adp.read_Data_Set(DataSet2);
        adp.click_ON_Res_History();
        adp.cancel_tc4( DataSet2);

        adp.read_Data_Set(DataSet3);
        adp.click_ON_Res_History();
        adp.cancel_tc4( DataSet3);
 
    }

 }
