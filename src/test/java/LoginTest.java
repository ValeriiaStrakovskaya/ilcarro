import org.openqa.selenium.By;
import org.testng.Assert;
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
    public void loginPositiveTest(){

        String email = "Child.valery@gmail.com";
        String password = "BigBubbles@182";
        app.getUser(). openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[contains(.,'Ok')]")));

    }
}
