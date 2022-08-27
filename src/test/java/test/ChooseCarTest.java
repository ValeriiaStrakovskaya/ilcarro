package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ChooseCarTest extends TestBase{

    @Test
    public void chooseYourCar(){
app.getCar().fillSearchForm("Netanya","8/27/2022 - 8/31/2022");
app.getUser().submitForm();
Assert.assertTrue(app.getCar().isChoosed());

    }

    @Test
    public void chooseYourCar2(){
        app.getCar().fillSearchForm2("Netanya","27 30");
        app.getUser().submitForm();
        Assert.assertTrue(app.getCar().isChoosed());

    }

    @Test
    public void chooseYourCar3(){
        app.getCar().fillSearchForm3("Netanya","10 27 11 10");
       app.getUser().submitForm();
       Assert.assertTrue(app.getCar().isChoosed());

    }
//    @AfterTest
//    public void Back(){
//        app.getUser().click(By.xpath("//a[@id='0']"));
//    }
}
