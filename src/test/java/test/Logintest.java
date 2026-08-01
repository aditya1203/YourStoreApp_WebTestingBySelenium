package test;


import base.Base;
import org.testng.annotations.Test;
import pages.LoginPage;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;

import java.time.Duration;


public class Logintest extends Base {



   // @Test
    public void loggingAccount(){
        LoginPage  loginpage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginpage.clickMyAccount();
        loginpage.login();
    }
}
