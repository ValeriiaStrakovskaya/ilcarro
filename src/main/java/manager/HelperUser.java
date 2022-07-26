package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));

    }
    public void fillLoginRegistrationForm(String email,String password) {
        type(By.xpath("//*[@id='email']"),email);
        type(By.xpath("//*[@id='password']"),password);

    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//*[text()=' Log in ']"));

    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[contains(text(),' Logout ')]"));

    }
    public void logout(){
        click(By.xpath("//*[contains(text(),' Logout ')]"));

    }
}
