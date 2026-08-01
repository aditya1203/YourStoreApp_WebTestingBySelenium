package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage{

    WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickMyAccount(){
        System.out.println("We are under click account");
        driver.findElement(By.xpath("//li[contains(., 'My Account')]/a[contains(@title,'My')]")).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        String actual=driver.findElement(By.xpath("//h2[text()='Returning Customer']")).getText();

        System.out.println(actual);
        Assert.assertEquals(actual,"Returning Customer");
    }

    public void login(){
        driver.findElement(By.id("input-email")).sendKeys("121aaa@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("abcabc");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("//a[contains(.,'Your')]")).click();

    }


}
