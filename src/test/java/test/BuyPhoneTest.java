package test;

import base.Base;
import org.openqa.selenium.devtools.latest.page.model.Screenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BuyPhone_Page;
import pages.LoginPage;

import java.time.Duration;


public class BuyPhoneTest extends Base {


    @Test
    public void loggingAccount(){
        LoginPage loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginpage.clickMyAccount();
        loginpage.login();
    }

    @Test(dependsOnMethods = "loggingAccount")
    public void test() throws Exception {

        BuyPhone_Page buyPhone=new BuyPhone_Page(driver);
        buyPhone.verifyHeading();
        buyPhone.clickOnPhone();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        buyPhone.addItemToCart();
        buyPhone.clickCart();
        buyPhone.cartDetails();
//        buyPhone.shoppingCart();

        //buyPhone.checkOut();

        //buyPhone.billingDetails();
//        buyPhone.deliveryDetails();
    }
}
