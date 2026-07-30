//package test;
//
//import base.BaseTest;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//public class Test1 extends BaseTest {
//
//    @Test
//    public void started() throws InterruptedException {
//
//
//
//        String heading =driver.findElement(By.xpath("//div[@id='logo']/h1/a")).getText();
//
//        System.out.println(heading);
//
//        System.out.println("this are working");
//    }
//
//}
// protected WebDriver driver;
/// /    protected ConfigReader reader=new ConfigReader();
/// /    protected ExtentReports ls=new ExtentReports();
//    @BeforeMethod
//    public void setup(){
//        ConfigReader reader=new ConfigReader();
//        String url=reader.getProperties("url");
//        System.out.println(url);
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(url);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//    }
//
//    //Creating TestNg Reports
////    @BeforeTest
////    public void createReport(){
////        ExtentReports Report=ExtentReports.g
//
//    }
////
////    @AfterTest
////    public void flushReport(){
////        ls.flush();
////    }
//
//
//
//    @AfterMethod
//
//    public void tearDown(){
//        if(driver!=null){
//            driver.quit();
//        }
//    }