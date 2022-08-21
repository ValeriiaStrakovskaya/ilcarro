package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AppManager {
    Logger logger = LoggerFactory.getLogger(AppManager.class);

    //WebDriver wd;
    HelperUser user;
    HelperCar car;
    EventFiringWebDriver wd;

    public void init(){
        WebDriverManager.chromedriver().setup();
        logger.info("Test starts on ChromeDriver");
       // wd =  new ChromeDriver();
        wd=new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        user=new HelperUser(wd);
        car = new HelperCar(wd);

    }

    public HelperUser getUser() {
        return user;
    }

    public void stop(){
        wd.quit();

    }
    public HelperCar getCar() {
        return car;
    }
}
