package RabuDay_12;

import Reusable_Library.Reusable_method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class List_Checkbox {

    @Test
    public void verifications() throws InterruptedException {
        WebDriver driver = Reusable_method.getDriver();
        driver.navigate().to("http://www.yahoo.com");
        Thread.sleep(2000);
        //get the count of all link in yahoo page
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));
        //print out the link count..return 12
        System.out.println("Link count is" + linkCount.size());
        //click on sign in button
        Reusable_method.click(driver,"//*[@class='_yb_687jt']","SSign in button");

        Thread.sleep(2000);
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting the checkbox to be selected
        if (checkboxState== true) {
            System.out.println("Checkbox is selected as expected");
        }else {
            System.out.println("checkbox is not selected by default");

        }//end of if else

    }//end test

}//end java
