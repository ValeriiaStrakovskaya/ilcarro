package test;

import manager.AppManager;
//import manager.NgListener;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

//@Listeners(NgListener.class)

public class TestBase {
    public static AppManager app=new AppManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method method){
        logger.info("Start test------> " + method.getName());
    }

    @AfterMethod
    public void end(){
        logger.info("***********************");
    }

    @BeforeSuite
    public void init(){
        app.init();
    }



    @AfterSuite
    public void tearDown(){

    //    app.stop();


    }
    }
