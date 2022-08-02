package test;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {



    @BeforeMethod
    public void preCondition(){
        if(TestBase.app.getUser().isLogged()){
            TestBase.app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTestModel(){

        String email = "child.valery@gmail.com";
        String password = "BigBubbles@182";
        User data=new User().withEmail(email).withPassword(password);
        TestBase.app.getUser(). openLoginForm();
        //app.getUser().fillLoginForm(email,password);
        TestBase.app.getUser().fillLoginForm(data);
        TestBase.app.getUser().submitLogin();
        TestBase.app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isLogged());
       

    }
    @Test
    public void loginTestNegativeWrongEmail(){

        String email = "Child.valerygmail.com";
        String password = "BigBubbles@182";
        User data=new User().withEmail(email).withPassword(password);
        TestBase.app.getUser(). openLoginForm();
        TestBase.app.getUser().fillLoginForm(data);
        TestBase.app.getUser().submitLogin();
        TestBase.app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//div[contains(text(),\"It'snot look like email\")]")));
    }

    @Test
    public void loginTestNegativeInvalidUser(){

        String email = "jhjh@df.cl";
        String password = "jhg";
        User data=new User().withEmail(email).withPassword(password);
        TestBase.app.getUser(). openLoginForm();
        TestBase.app.getUser().fillLoginForm(data);
        TestBase.app.getUser().submitLogin();
        TestBase.app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//h2[text()='Wrong email or password']")));


    }

    @Test
    public void loginTestNegativeEmptyFields(){

        String email = "";
        String password = "";
        User data=new User().withEmail(email).withPassword(password);
        TestBase.app.getUser(). openLoginForm();
        TestBase.app.getUser().fillLoginForm(data);
        Assert.assertFalse(TestBase.app.getUser().isButtonClickable(By.xpath("//button[@type='submit']")));

    }

    @AfterMethod
    public void postCondition(){
        TestBase.app.getUser().clickOkButton();
    }
}
