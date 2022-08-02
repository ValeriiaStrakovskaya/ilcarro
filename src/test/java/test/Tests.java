package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    WebDriver wd1;
    @BeforeMethod
    public void preCondition(){
        WebDriverManager.chromedriver().setup();
        wd1 = new ChromeDriver();
      // wd1.navigate().to("https://ilcarro-1578153671498.web.app/search");
       wd1.get("https://ilcarro-1578153671498.web.app/search");
    }

    @Test
    public void testURL(){

    }


}
