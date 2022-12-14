package com.nttdata.steps;

import com.nttdata.page.GuruLoginPage;
import com.nttdata.page.LinioLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinioLoginSteps {

    private WebDriver driver;

    //constructor
    public LinioLoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LinioLoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LinioLoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){

        this.driver.findElement(LinioLoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login() {
        try {
            this.driver.findElement(LinioLoginPage.loginButton).click();
        } catch (Exception e) {
        }
    }

    public void betterProduct(){
        try {
            this.driver.findElement(LinioLoginPage.hrefMejores).click();
        } catch (Exception e) {
        }
    }

    public void any(){
        try {
            this.driver.findElement(LinioLoginPage.anyProduct).click();
        } catch (Exception e) {
        }
    }

    public void add(){
        try {
            this.driver.findElement(LinioLoginPage.addCart).click();
        } catch (Exception e) {
        }
    }
}
