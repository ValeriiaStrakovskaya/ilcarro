import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{



    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTestModel(){

        String email = "child.valery@gmail.com";
        String password = "BigBubbles@182";
        User data=new User().withEmail(email).withPassword(password);
        app.getUser(). openLoginForm();
        //app.getUser().fillLoginForm(email,password);
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLogged());
       

    }
    @Test
    public void loginTestNegativeWrongEmail(){

        String email = "Child.valerygmail.com";
        String password = "BigBubbles@182";
        User data=new User().withEmail(email).withPassword(password);
        app.getUser(). openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),\"It'snot look like email\")]")));
    }

    @Test
    public void loginTestNegativeInvalidUser(){

        String email = "jhjh@df.cl";
        String password = "jhg";
        User data=new User().withEmail(email).withPassword(password);
        app.getUser(). openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[text()='Wrong email or password']")));


    }

    @Test
    public void loginTestNegativeEmptyFields(){

        String email = "";
        String password = "";
        User data=new User().withEmail(email).withPassword(password);
        app.getUser(). openLoginForm();
        app.getUser().fillLoginForm(data);
        Assert.assertFalse(app.getUser().isButtonClickable(By.xpath("//button[@type='submit']")));

    }

    @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}
