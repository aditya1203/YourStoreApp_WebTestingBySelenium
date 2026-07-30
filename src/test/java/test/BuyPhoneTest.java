package test;

import base.Base;
import org.testng.annotations.Test;

import pages.BuyPhone_Page;

import java.time.Duration;

public class BuyPhoneTest extends Base {


    @Test
    public void test() throws Exception {

        BuyPhone_Page buyPhone=new BuyPhone_Page(driver);
        buyPhone.verifyHeading();
        buyPhone.clickOnPhone();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        buyPhone.addItemToCart();
        buyPhone.cartDetails();
        buyPhone.shoppingCart();
    }
}
