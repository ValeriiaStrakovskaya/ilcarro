package test;

import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public static AppManager app=new AppManager();

    @BeforeSuite
    public void init(){
        app.init();
    }
    @AfterSuite
    public void tearDown(){

        app.stop();


    }
    }
