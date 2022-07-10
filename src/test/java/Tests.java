import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
       // wd.get("https://ilcarro-1578153671498.web.app/search");
    }

    @Test
    public void testURL(){}


}
