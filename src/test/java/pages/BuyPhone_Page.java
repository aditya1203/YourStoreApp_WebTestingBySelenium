package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class BuyPhone_Page {

    WebDriver driver;
    public BuyPhone_Page(WebDriver driver){
        this.driver=driver;
    }



    public void verifyHeading() throws Exception{
        String headingText=driver.findElement(By.xpath("//div[@id='logo']/h1/a")).getText();
        System.out.println(headingText);
        Assert.assertEquals(headingText,"Your Store");
    }

    public void clickOnPhone(){
        WebElement mobileClick= driver.findElement(By.xpath("//div[contains(@class, 'product-thumb')][.//a[@href=\"http://opencart.abstracta.us:80/index.php?route=product/product&product_id=40\"]]"));
        mobileClick.click();
        String cartPhoneHeading=driver.findElement(By.xpath("//h1[text()='iPhone']")).getText();
        System.out.println(cartPhoneHeading);
        Assert.assertEquals(cartPhoneHeading,"iPhone");
    }

    public void addItemToCart(){
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();
        String expected="Success: You have added iPhone to your shopping cart!\n" +
                "×";
        String actual=driver.findElement(By.xpath("//div[text()='Success: You have added ']")).getText();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
    }

    public void clickCart(){
        driver.findElement(By.className("btn btn-danger btn-xs")).click();
        driver.findElement(By.xpath("//*[text()=' View Cart']")).click();
    }

    public void cartDetails(){
        String expected="Success: You have added iPhone to your shopping cart!\n" +
                "×";
//        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/div[@class='alert alert-danger alert-dismissible']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       String actual=driver.findElement(By.xpath("(//div[@id='product-product']/div)[1]")).getText();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);

        driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        driver.findElement(By.xpath("//*[text()=' View Cart']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void shoppingCart(){
        String actual =driver.findElement(By.className("alert alert-danger alert-dismissible")).getText();

        System.out.println(actual);
    }


}
