package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void submitLogin() {
       click(By.xpath("//button[@type='submit']"));

    }
    public void fillLoginForm(String email,String password) {
        type(By.xpath("//*[@id='email']"),email);
        type(By.xpath("//*[@id='password']"),password);

    }

    public void fillLoginForm(User data) {
        type(By.xpath("//*[@id='email']"), data.getEmail());
        type(By.xpath("//*[@id='password']"), data.getPassword());

    }

    public void openLoginForm() {
        click(By.xpath("//*[text()=' Log in ']"));

    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[contains(text(),' Logout ')]"));


    }
    public void logout(){
        click(By.xpath("//*[contains(text(),' Logout ')]"));

    }

    public void clickOkButton() {
if(isElementPresent(By.xpath("//button[contains(.,'Ok')]"))){
    click(By.xpath("//button[contains(.,'Ok')]"));
        };
    }

    public boolean isButtonClickable(By locator){
     boolean yes= wd.findElement(locator).isEnabled();
return yes;
    }
}
