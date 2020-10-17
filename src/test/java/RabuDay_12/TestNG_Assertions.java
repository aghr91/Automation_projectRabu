package RabuDay_12;

import Reusable_Library.Reusable_method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions {
   @Test
   public void assertions() throws InterruptedException {
       WebDriver driver = Reusable_method.getDriver();

       driver.navigate().to("http://www.google.com");
       Thread.sleep(2000);
       //verify the google tittle using hard assert
     //  Assert.assertEquals("Google",driver.getTitle());
       //using soft assertions
       SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(driver.getTitle(),"GOOGLE");
       //enter keword search
      // Reusable_method.sendkeys(driver,"//*[@name='q']","cars","Search field");
       softAssert.assertAll();

   }//end test


}//end of java class
