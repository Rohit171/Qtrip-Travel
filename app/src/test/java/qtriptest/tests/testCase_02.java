package qtriptest.tests;


import qtriptest.DProvider;
import qtriptest.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCase_02 extends BaseTest {

    
     @Test(dataProvider = "TestCase2",dataProviderClass = DProvider.class,description = "verify Search and Filter flow" , priority = 2, groups={"Search and Filter flow"},enabled = true)
    public void TestCase02(String City_name ,String Category_filter,String DurationFilter,String expectedFilterResult, String expectedUnfilteredResult) throws InterruptedException{
        //    String city = "Indian";
        // //1. Navigate to the Home page of QTrip
        // //2. Search for a city that's not present
        // hp.CheckNavigationToHomePage();
        //  lp.Search_City(city);
        // //3. Verify if the no matches found message is displayed       
        //  Assert.assertEquals(lp.verify_City_Not_found(), true,"Given City is expected to Not Found");
        // //4. Search for a city that's present
        // lp.Search_City(City_name);
        // //5. verify that the city is displayed on auto complete
        // Assert.assertEquals(lp.verify_city_found(City_name), true,"Given City is expected to found");
        // //6. Click on the city
        //  lp.selectCity();
        //  //7. Select Filters : hours
        //   ap.select_Duration(DurationFilter);
        // //8. Verify that appropriate data is displayed
        // Assert.assertEquals(ap.verify_time_duration(DurationFilter), true,"Duration is out of range");
        // //9. Select category
        // ap.select_Category(Category_filter);
        // // 10. Verify that appropriate data is displayed
        // Assert.assertEquals(ap.verify_category_Value(Category_filter), true,"Category_filter Not working");
        // // 11. Clear Filters and category
        // ap.clear_Filter_By_Category();
        // ap.clear_Filter_By_hrs();
        // //12. Verify that all the records are displayed
        // ap.NavigatebacktoHome();
        
        /*======================================================================================== */
        test = report.startTest("Verify that search and filter Work fine");

         String city = "Indian";
        hp.CheckNavigationToHomePage();
         lp.Search_City(city);
         Assert.assertEquals(lp.verify_City_Not_found(), true,"Given City is expected to Not Found");
         
            
        // try{                   
            // Assert.assertEquals(lp.verify_City_Not_found(),true);
        //     test.log(LogStatus.PASS, "Given City is not found as excpected !!!");
        // }catch(AssertionError e){
        //     test.log(LogStatus.FAIL, "ndGiven City is expected to Not Fou !!!");
        // }

        lp.Search_City(City_name);

       try{
        Assert.assertEquals(lp.verify_city_found(City_name),true);
        test.log(LogStatus.PASS, "Expected city is found !!!");
        }catch(AssertionError e){
        test.log(LogStatus.FAIL, "Expected city is Not found !!!");
        }

        lp.selectCity();
        ap.select_Duration(DurationFilter);

        try{
            Assert.assertEquals(ap.verify_time_duration(DurationFilter), true);
            test.log(LogStatus.PASS, " Duration Found !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Duration is out of range !!!");
        }

        ap.select_Category(Category_filter);

        try{
            Assert.assertEquals(ap.verify_category_Value(Category_filter), true);
            test.log(LogStatus.PASS, " Category_filter Found !!!");
        }catch(AssertionError e){
            test.log(LogStatus.FAIL, "Category_filter not found !!!");
        }


        ap.clear_Filter_By_Category();
        ap.clear_Filter_By_hrs();
        ap.NavigatebacktoHome();







    }

}
   
