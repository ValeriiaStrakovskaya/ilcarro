package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void submitLogin() {
       click(By.xpath("//button[@type='submit']"));

    }
//    public void fillLoginForm(String email,String password) {
//        type(By.xpath("//*[@id='email']"),email);
//        type(By.xpath("//*[@id='password']"),password);
//
//    }

    public void fillLoginForm(User data) {
        type(By.xpath("//*[@id='email']"), data.getEmail());
        type(By.xpath("//*[@id='password']"), data.getPassword());

    }

    public void openLoginForm() {
        click(By.xpath("*[text()=' Log in ']"));

    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[contains(text(),' Logout ')]"));


    }

    public boolean isRegistered(){
            WebDriverWait wait = new WebDriverWait(wd, 10);
            WebElement element = wd.findElement(By.xpath("//div[@class='dialog-container']"
            ));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText().contains("Registered");
        }


    public void logout(){
        click(By.xpath("//*[contains(text(),' Logout ')]"));

    }

    public void clickOkButton() {
if(isElementPresent(By.xpath("//button[contains(.,'Ok')]"))){
    click(By.xpath("//button[contains(.,'Ok')]"));
        }
    }

    public boolean isButtonClickable(By locator){
        return wd.findElement(locator).isEnabled();

    }
    public void submitForm() {
//        wd.findElement(By.cssSelector("[type='submit']")).submit();
        WebElement element =   wd.findElement(By.cssSelector("[type='submit']"));
        new WebDriverWait(wd,10).until(ExpectedConditions.elementToBeClickable(element));

    }

    public void login(User user) {

        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(1000);

    }

    public void openRegistrationForm() {
click(By.xpath("//a[text()=' Sign up ']"));


    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
       //click(By.cssSelector("//label[@for='terms-of-use']"));
//        JavascriptExecutor js=(JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click()");
    }

    public void checkPolicy() {
//        JavascriptExecutor js=(JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click()");
//    click(By.cssSelector("//label[@for='terms-of-use']"));

        Actions actions = new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector(".checkbox-container"));
        Rectangle rectangle = container.getRect();
        int x = rectangle.getX()+5;
        int y = rectangle.getY()+ rectangle.getHeight()*1/4;
        actions.moveByOffset(x,y).click().perform();
    }
}
