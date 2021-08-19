package Tests;

import Commons.CommonData;
import Pages.FormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class FormPageTest {
  // private WebDriver driver;
   private ChromeDriver browser;
   CommonData utils = new CommonData();




    // Test Data
    public String home_url = "https://formy-project.herokuapp.com/form";


    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(home_url);



    }

    @Test
    public void LoadPage(){
        FormPage form = new FormPage(browser);
        form.getPageURL();
        Assert.assertEquals(form.getPageURL(),home_url);
        System.out.println("It works");
    }

    @Test
    public void fillForm_and_Submit_Successfully(){
        FormPage form = new FormPage(browser);
        form.setFirst_name(utils.firstname);
        form.setLast_name(utils.lastname);
        form.setJob_title(utils.jobtitle);
        form.setGrad_school();
        form.setMale();
        form.setYearsOfExperience();
        form.setData_picker(utils.dob);
        form.clickSubmit();
        Assert.assertEquals(form.getSuccessMassage(),utils.successmsg);
    }



    @After
    public void tearDown(){
       browser.quit();

    }
}
