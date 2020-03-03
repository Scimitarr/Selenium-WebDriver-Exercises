package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class LogowanieSteps {

    ChromeDriver driver;
    final String buttonLogin = "/html/body/div[2]/div/div/form/button/i";

    @Given("Uzytkownik jest na stronie {string}")
    public void uzytkownik_jest_na_stronie(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//Lis//Downloads//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
//    @When("Uzytkownik w pole o id username wprowadza wartosc {string}")
//    public void uzytkownik_w_pole_o_id_username_wprowadza_wartosc(String wartoscWprowadzana){
//        WebElement znalezionyElement = driver.findElementById("username");
//        znalezionyElement.sendKeys(wartoscWprowadzana);
//
//        //driver.findElementById("username").sendKeys(wartoscWprowadzana);
//    }
//    @When("Uzytkownik w pole o id password wprowadza wartosc {string}")
//    public void uzytkownik_w_pole_o_id_password_wprowadza_wartosc(String wartoscWprowadzana){
//        WebElement znalezionyElement = driver.findElementById("password");
//        znalezionyElement.sendKeys(wartoscWprowadzana);
//
//        //driver.findElementById("password").sendKeys(wartoscWprowadzana);
//    }
    @When("Uzytkownik w pole o id {string} wprowadza wartosc {string}")
    public void uzytkownik_w_pole_o_id_wprowadza_wartosc(String idPola, String wartoscWprowadzana){
            WebElement znalezionyElement = driver.findElementById(idPola);
            znalezionyElement.sendKeys(wartoscWprowadzana);

            //driver.findElementById(idPola).sendKeys(wartoscWprowadzana);
    }
    @When("Uzytkownik klika w przycisk Login")
    public void uzytkownik_klika_w_przycisk_Login(){
        WebElement znalezionyElement = driver.findElementByXPath(buttonLogin);
        znalezionyElement.click();
    }
    @Then("Uzytkownik zostal poprawnie zalogowany")
    public void uzytkownik_zostal_poprawnie_zalogowany(){
        Assert.assertEquals("https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
        driver.close();
    }
    @Then("Uzytkownik nie zostal zalogowany")
    public void uzytkownik_nie_zostal_zalogowany(){
        Assert.assertEquals("Your username is invalid!\n×",driver.findElementById("flash").getText());
        driver.close();
    }
}
