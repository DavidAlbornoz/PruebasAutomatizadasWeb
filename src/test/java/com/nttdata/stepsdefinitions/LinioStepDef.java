package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LinioLoginSteps;

import com.nttdata.steps.MatchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinioStepDef {

    private WebDriver driver;
    private Scenario scenario;
    private LinioLoginSteps loginSteps;

    private MatchSteps matchSteps(WebDriver driver){
        return new MatchSteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("Que estoy en la pagina de inicio de Linio")
    public void queEstoyEnLaPaginaDeInicioDeLinio() {
        driver.get("https://www.linio.com.pe/account/login");
        screenShot();
    }

    @When("Ingreso mis credenciales {string} y pass {string}")
    public void ingreseMisCredencialesYPass(String user, String password) {
        //loginSteps = new GuruLoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        screenShot();
    }

    @Then("Hago click en el boton iniciar sesión")
    public void hagoClickEnElBotonIniciarSesión() {
        loginSteps.login();
        screenShot();
    }

    @And("Valido que estoy logeado correctamente con el nombre {string}")
    public void validoQueEstoyLogeadoCorrectamenteConElNombre(String expectedName) {
        String name = matchSteps(driver).getUser();
        //prueba: validamos el nombre del usuario
        Assertions.assertEquals(expectedName, name);
    }



    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }



    @Given("Estoy logeado")
    public void estoyLogeado() {
        driver.get("https://www.linio.com.pe/account/login");
        loginSteps.typeUser("no.david.albornoz@gmail.com");
        loginSteps.typePassword("c3p0r2d2");
        loginSteps.login();
    }

    @When("Hago click en mejores calificados")
    public void hagoClickEnMejoresCalificados() {
        loginSteps.betterProduct();
        screenShot();
    }

    @And("Hago click en cualquier producto")
    public void hagoClickEnCualquierProducto() {
        loginSteps.any();
        screenShot();
    }

    @And("Hago click en el boton añadir al carrito")
    public void hagoClickEnElBotonAñadirAlCarrito() {
        loginSteps.add();
        screenShot();
    }

    @Then("El producto se agrego al carrito")
    public void elProductoSeAgregoAlCarrito() {
    }

    @And("Valido que se agrego al carrito con el mensaje {string}")
    public void validoQueSeAgregoAlCarrito(String expectedMessage) {
        String message = matchSteps(driver).getProductAdd();
        //prueba: validamos el nombre del usuario
        Assertions.assertEquals(expectedMessage, message);
    }
}
