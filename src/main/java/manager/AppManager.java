package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
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
    String browser;


    public void init(){
        WebDriverManager.chromedriver().setup();
        logger.info("Test starts on ChromeDriver");
        WebDriverManager.firefoxdriver().setup();
        logger.info("Test starts on Firefox");
       // wd =  new ChromeDriver();
        if(browser.equals((BrowserType.CHROME))){
        wd=new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests start on Chrome");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd=new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests start on Firefox");
        }
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
    
    public AppManager(String browser) {
        this.browser = browser;
    }
}
