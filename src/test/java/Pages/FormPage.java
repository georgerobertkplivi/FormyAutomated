package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }



    // Form Page locators
    By first_name = By.id("first-name");
    By last_name = By.id("last-name");
    By job_title = By.id("job-title");
    By grad_school = By.id("radio-button-3");
    By male = By.id("checkbox-1");
    By yoe_menu = By.id("select-menu");
    By success_msg = By.cssSelector(".alert");
    By submit_btn = By.linkText("Submit");
    By data_picker_box = By.id("datepicker");
    By dropdown_menu = By.id("select-menu");
    By dropdown_menu_item = By.xpath("//option[. = '2-4']");


    //get date
    public void setData_picker(String date){
        driver.findElement(data_picker_box).sendKeys(date);
    }

    //get Page current url
    public String getPageURL(){
        return driver.getCurrentUrl();
    }



    //get success message
    public String getSuccessMassage(){
        return driver.findElement(success_msg).getText();
    }


    //click submit button
    public void clickSubmit(){
        driver.findElement(submit_btn).click();
    }



    //get gender male
    public void setMale(){
        driver.findElement(male).click();
    }

    //get first name
    public void setFirst_name(String fname){
        driver.findElement(first_name).sendKeys(fname);
    }


    //get last name
    public void setLast_name(String lname){
        driver.findElement(last_name).sendKeys(lname);
    }

    //get job title
    public void setJob_title(String jobtitle){
        driver.findElement(job_title).sendKeys(jobtitle);
    }

    //get level of education
    public void setGrad_school(){
        driver.findElement(grad_school).click();
    }

    //get year of experience
    public void setYearsOfExperience(){
        driver.findElement(yoe_menu).click();
        WebElement dropdown = driver.findElement(dropdown_menu);
        dropdown.findElement(dropdown_menu_item).click();
    }
}
