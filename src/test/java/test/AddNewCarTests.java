package test;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{
    // is logged? -> preCondition
    // open form
    // fiil form + model Car
    // attach photo + image
    // submit form

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()==false){
            app.getUser().login(new User()
                    .withEmail("child.valery@gmail.com")
                    .withPassword("BigBubbles@182"));
        }
    }

    @Test
    public void addNewCarTestPositive(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Haifa")
                .make("KIA")
                .model("Sportage")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("5")
                .clasS("C")
                .fuelConsumption("8.9")
                .carRegNumber("100-200-" + i)
                .price("150")
                .distanceInclude("500")
                .typeFeature("Climate control")
                .about("Like new")
                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
       app.getCar().attachPhoto();
     app.getUser().submitForm();
    }
    @Test
    public void addNewCarTestNegative(){
        //validation test
        app.getCar().openCarForm();
        app.getCar().click(By.xpath("//input[@id='make']"));
        app.getCar().click(By.xpath("//input[@id='model']"));
        Assert.assertTrue(app.getCar().isElementPresent(By.xpath("//div[contains(text(),'Make is required')]")));
    }

    @Test
    public void addNewCarTestNegative2(){

        //ALL required fields should be filled.Photo isn't attached
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car2 = Car.builder()
                .address("Haifa")
                .make("KIA")
                .model("Sportage")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("AT")
                .wD("AWD")
                .doors("5")
                .seats("5")
                .clasS("C")
                .fuelConsumption("8.9")
                .carRegNumber("100-200-" + i)
                .price("150")
                .distanceInclude("500")
                .typeFeature("Climate control")
                .about("Like new")
                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car2);
        Assert.assertFalse(app.getUser().isButtonClickable(By.xpath("//button[@type='submit']")));

    }

    @Test
    public void addNewCarTestPositiveForFeatures(){

        app.getCar().openCarForm();
        app.getCar().click(By.xpath("//input[@placeholder='Type feature']"));
        app.getCar().type(By.xpath("//input[@placeholder='Type feature']"),"Something");
        app.getCar().click(By.cssSelector("#about"));
        app.getCar().click(By.cssSelector("button[type$='button']"));
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//input[position()=2]")));

    }
    @Test
    public void addNewCarTestNegativeForFeatures(){

        app.getCar().openCarForm();
        app.getCar().click(By.xpath("//input[@placeholder='Type feature']"));
        app.getCar().type(By.xpath("//input[@placeholder='Type feature']"),"");
        app.getCar().click(By.cssSelector("#about"));
        Assert.assertFalse(app.getUser().isButtonClickable(By.cssSelector("button[type$='button']")));
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//input[position()=2]")));

    }

}

