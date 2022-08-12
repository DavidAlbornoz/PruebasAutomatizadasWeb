package com.nttdata.page;

import org.openqa.selenium.By;

public class LinioLoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("login_form_email");
    public static By passInput = By.id("login_form_password");
    public static By loginButton = By.xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/form/button");

    //Producto al carrito
    public static By hrefMejores = By.xpath("/html/body/div[4]/main/div[1]/div[1]/div[1]/a[4]");

    public static By anyProduct = By.xpath("/html/body/div[4]/main/div[1]/div[2]/div/div/div/div[1]/a[1]/div[1]/picture/img");

    public static By addCart = By.xpath("/html/body/div[4]/main/div[1]/div[2]/div[3]/div[2]/div[3]/div[2]/div[2]/button");
}
