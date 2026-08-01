package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class Base {

    protected WebDriver driver;
    protected ConfigReader reader=new ConfigReader();
    protected ExtentReports ls=new ExtentReports();
    @BeforeClass
    public void setup(){
       // ConfigReader reader=new ConfigReader();
        String url=reader.getProperties("url");
        System.out.println(url);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    //Creating TestNg Reports
    @BeforeSuite
    public void createReport() {
        //ExtentReports ls=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter(reader.getProperties("report.path"));
        ls.attachReporter(spark);
        ExtentTest test=ls.createTest("Buy phone");
    }
    @AfterSuite
    public void flushReport(){
        ls.flush();
    }


    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


}


