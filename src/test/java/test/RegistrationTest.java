package test;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user=new User().withName("Vasya")
                .withLastName("Popov")
                .withEmail("Vasya" + i + "@mail.com")
                .withPassword("$Vasya12345");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void registrationNegativeTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user=new User().withName("Vasya")
                .withLastName("Popov")
                .withEmail("Vasya" + i + "@mail.com")
                .withPassword("asya12345");
        logger.info("Reg test starts with: " + user.getEmail() + "and " +user.getPassword());
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().checkPolicy();

        //app.getUser().submitForm();
       // Assert.assertTrue(app.getUser().isRegistered());
    }
}
