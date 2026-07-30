import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class YourTest {


    @Test
    public void test() {
    WebDriver driver = new ChromeDriver();
    driver.get("http:www.google.com/");

    driver.quit();
    }
}
