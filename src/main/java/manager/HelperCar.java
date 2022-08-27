package manager;
import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class HelperCar extends HelperBase{


    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }

    public boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("h2")),
                                "some details"));
    }

    public void typeLocation(String address){
        type(By.id("pickUpPlace"),address);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public void fillCarForm(Car car) {
        if(isCarFormPresent()){
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());
            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());
            type(By.id("doors"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getClasS());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegNumber());
            type(By.id("price"), car.getPrice());
            type(By.id("distance"), car.getDistanceInclude());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"), car.getAbout());
        }
    }

    public void attachPhoto() {
        wd.findElement(By.id("photos")).sendKeys("/Users/valeriiastrakovskaya/Documents/GitHub/ilcarro/kia.jpeg");

    }

    public void fillSearchForm(String city,String date) {
        chooseCity(city);
        WebElement Dates =wd.findElement(By.id("dates"));
        Dates.sendKeys(date);
        Dates.sendKeys(Keys.ENTER);
        pause(500);
    }

    public boolean isChoosed(){
        WebDriverWait wait = new WebDriverWait(wd, 10);
        WebElement element = wd.findElement(By.cssSelector("div[class='sub-search-card'] h1[class='title']"
        ));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().contains("Find your car now");
    }

    public void fillSearchForm2(String city, String date) {
        chooseCity(city);
        String[] dates = date.split(" ");
        System.out.println(dates.length);
        WebElement Dates =wd.findElement(By.id("dates"));
        Dates.click();
        String locator = String.format("//div[normalize-space()='%s']",dates[0]);
        WebElement element =wd.findElement(By.xpath(locator));
        element.click();
        String locator2 = String.format("//div[normalize-space()='%s']",dates[1]);
        WebElement element2 =wd.findElement(By.xpath(locator2));
        element2.click();
        Dates.sendKeys(Keys.ENTER);
    }



    public void fillSearchForm3(String city, String date) {
        chooseCity(city);

        String[] dates = date.split(" ");
        int month = Integer.parseInt(dates[0]);
        String monthStr = getNameOfMonth(month, new Locale("ENG")).toUpperCase(Locale.ROOT);
        System.out.println(monthStr);
        WebElement Dates = wd.findElement(By.id("dates"));
        Dates.click();
        WebElement element = wd.findElement(By.xpath("//button[@aria-label='Next month']"));
        WebElement find2 = wd.findElement(By.cssSelector("button[aria-label='Choose month and year'] span[class='mat-button-wrapper']"));
        System.out.println(find2.getText());
        while (!find2.getText().contains(monthStr)) {
            element.click();
        }
        String locator = String.format("//div[normalize-space()='%s']",dates[1]);
        WebElement day =wd.findElement(By.xpath(locator));
        day.click();

        int month2 = Integer.parseInt(dates[2]);
        String monthStr2 = getNameOfMonth(month2, new Locale("ENG")).toUpperCase(Locale.ROOT);
        while (!find2.getText().contains(monthStr2)) {
            element.click();
        }
        String locator2 = String.format("//div[normalize-space()='%s']",dates[3]);
        WebElement day2 =wd.findElement(By.xpath(locator2));
        day2.click();
        Dates.sendKeys(Keys.ENTER);


    }

   public String getNameOfMonth(int month, Locale locale){
        Calendar c;
        String s;
            c=Calendar.getInstance();
            c.set(Calendar.MONTH,month);
            s=c.getDisplayName(Calendar.MONTH,Calendar.LONG,locale);
       return s;
    }




public void chooseCity(String city){
    type(By.id("city"), city);
    click(By.cssSelector("div.pac-item"));
    pause(500);


}

}