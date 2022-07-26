package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    WebDriver wd;
    HelperUser user;

    public void init(){
        WebDriverManager.chromedriver().setup();
        wd =  new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        user=new HelperUser(wd);

    }

    public HelperUser getUser() {
        return user;
    }

    public void stop(){
        wd.quit();

    }
}
