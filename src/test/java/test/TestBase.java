package test;

import manager.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static AppManager app=new AppManager();
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void init(){
        app.init();
    }
    @AfterSuite
    public void tearDown(){

        app.stop();


    }
    }
