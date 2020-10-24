package Cucumber_Framework.Step_Definitions;

import Reusable_Library.Abstract_Class_Cucumber;
import Reusable_Library.Reusable_Method_logger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;

public class Google_Search_Result extends Abstract_Class_Cucumber {

    @Test(priority = 1)
    @Given("^I navigate to Google homepage$")
    public void navigateToGoogleHome() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
    }//end of navigate

    @Test(dependsOnMethods = "navigateToGoogleHome")
    @When("^I enter a keyword on search field$")
    public void googleSearchField(){
        Reusable_Method_logger.sendkeys(driver,"//*[@name='q']","cars",logger,"Search Field");
    }//end of search field

    @Test(dependsOnMethods = "googleSearchField")
    @When("^I click on Search button$")
    public void googleSubmitButton(){
        Reusable_Method_logger.submit(driver,"//*[@name='btnK']",logger,"Search Field");
    }//end of submit button



}//end of Test
