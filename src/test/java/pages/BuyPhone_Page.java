package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BuyPhone_Page {

    WebDriver driver;
    public BuyPhone_Page(WebDriver driver){
        this.driver=driver;
    }



    public void verifyHeading() throws Exception{
        String headingText=driver.findElement(By.xpath("//div[@id='logo']/h1/a")).getText();
        System.out.println(headingText);
        assertEquals(headingText,"Your Store");
    }

    public void clickOnPhone(){
        WebElement mobileClick= driver.findElement(By.xpath("//div[@class='image']//img[@title='iPhone']"));
        System.out.println(mobileClick);
        mobileClick.click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='iPhone']")
        ));
        String cartPhoneHeading=driver.findElement(By.xpath("//h1[text()='iPhone']")).getText();
        System.out.println(cartPhoneHeading);
        assertEquals(cartPhoneHeading,"iPhone");
    }

    public void addItemToCart(){
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
        String expected="Success: You have added iPhone to your shopping cart!\n" +
                "×";
        String actual=driver.findElement(By.xpath("//div[text()='Success: You have added ']")).getText();
        System.out.println(actual);
        assertEquals(actual,expected);
    }

    public void clickCart(){
        driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        driver.findElement(By.xpath("//*[text()=' View Cart']")).click();
    }

    public void cartDetails(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expected="Products marked with *** are not available in the desired quantity or not in stock!\n" +
                "�";

        String actual=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        System.out.println(actual);
        //Assert.assertEquals(actual,expected);
    }

//    public void shoppingCart(){
//        String actual =driver.findElement(By.xpath("//div[contains(@class,'alert-danger') and contains(normalize-space(.),'Products marked with ***')]")).getText();
//
//        System.out.println(actual);
//    }

    public void checkOut(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pull-right' and contains(.,'Checkout')]")));

        Actions actions=new Actions(driver);
        WebElement element= (WebElement) By.xpath("//div[@class='pull-right' and contains(.,'Checkout')]");
        actions.moveToElement((WebElement) By.xpath("//div[@class='pull-right' and contains(.,'Checkout')]"));
        driver.findElement(By.xpath("//div[@class='pull-right' and contains(.,'Checkout')]")).click();
    }

    public void billingDetails(){

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='payment_address' and @value='new']")).click();
        driver.findElement(By.id("input-payment-firstname")).sendKeys("abc");
        driver.findElement(By.id("input-payment-lastname")).sendKeys("abc");
        driver.findElement(By.id("input-payment-address-1")).sendKeys("abc");
        driver.findElement(By.id("input-payment-city")).sendKeys("abc");
        driver.findElement(By.id("input-payment-postcode")).sendKeys("abc");

        driver.findElement(By.xpath("//select[@id='input-payment-country']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-payment-country']/option[@value='99']")));
        driver.findElement(By.xpath("//select[@id='input-payment-country']/option[@value='99']")).click();
        driver.findElement(By.xpath("//select[@id='input-payment-zone']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-payment-zone']/option[@value='1502']")));
        driver.findElement(By.xpath("//select[@id='input-payment-zone']/option[@value='1505']")).click();

        driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();
        driver.findElement(By.xpath("//div[@class='pull-right']//a[contains(.,'Checkout')]")).click();
    }

    public void deliveryDetails(){
        driver.findElement(By.xpath("//input[@name='shipping_address' and @value='new']")).click();
        driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();

        driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();

        driver.findElement(By.xpath("//div[@class='radio'and contains(.,'Cash')]")).click();

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@id='button-confirm']")).click();

        String value=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(value);

    }

}
