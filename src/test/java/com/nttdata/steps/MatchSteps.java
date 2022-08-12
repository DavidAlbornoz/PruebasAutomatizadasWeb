package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import com.nttdata.page.MatchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MatchSteps {

    private WebDriver driver;

    //contrsuctor
    public MatchSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getUser(){

        return this.driver.findElement(MatchPage.nameUser).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */
    public String getProductAdd(){
        return this.driver.findElement(MatchPage.productAdd).getText();
    }
}
