package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class MyStepdefsMylist {

    private AppiumDriver driver;

    @Given("ingreso a la app de WhenDo")
    public void ingresoALaAppDeWhenDo() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy S20 FE");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @When("yo agrego una nueva nota")
    public void yoAgregoUnaNuevaNota(Map<String, String> listData) {
        for (String key: listData.keySet()){
            System.out.print(key +" : " + listData.get(key));
        }
        //Click en agregar Nota
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();

        //Ingresamos el titulo de la nota
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(listData.get("titulo"));

        //Ingresamos la descripcion de la nota
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(listData.get("notes"));

        //Click en guardar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
    }

    @Then("se debe crear la nota {string}")
    public void seDebeCrearLaNota(String expectedResult) {
        String actualResult = driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();

        Assertions.assertEquals(expectedResult, actualResult, "Error en registrar");

    }
}


























