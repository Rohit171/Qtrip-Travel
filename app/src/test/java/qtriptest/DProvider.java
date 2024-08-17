package qtriptest;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DProvider {

    @DataProvider(name = "TestCase1")
	public static Object[][] getData1() throws IOException 
	{
		 return DP.dpMethod("TestCase01");
	}

	@DataProvider(name = "TestCase2")
	public static Object[][] getData2() throws IOException 
	{
		 return DP.dpMethod("TestCase02");
	}

	@DataProvider(name = "TestCase3")
	public static Object[][] getData3() throws IOException 
	{
		 return DP.dpMethod("TestCase03");
	}

	@DataProvider(name = "TestCase4")
	public static Object[][] getData4() throws IOException 
	{
		 return DP.dpMethod("TestCase04");
	}
    
}
// 