package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Exercise1Steps {
    ChromeDriver driver;
    final String element1 = "/html/body/div/table/tbody/tr[2]/td[2]/code";
    final String element2 = "/html/body/div/table/tbody/tr[3]/td[2]/code";
    final String element3 = "/html/body/div/table/tbody/tr[4]/td[2]/code";
    final String button1 = "btnButton1";
    final String button2 = "btnButton2";
    final String btnSolution = "solution";
    final String responseId = "trail";

    @Given("Uzytkownik wszedl na strone {string}")
    public void uzytkownik_wszedl_na_strone(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//Lis//Downloads//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
    }
    @When("Uzytkownik klika w pierwszy przycisk")
    public void uzytkownik_klika_w_pierwszy_przycisk() {
        if (driver.findElementByXPath(element1).getText().equals("B1")){
                driver.findElementById(button1).click();
        } else {
                driver.findElementById(button2).click();
        }
    }
    @When("Uzytkownik klika w drugi przycisk")
    public void uzytkownik_klika_w_drugi_przycisk() {
        if (driver.findElementByXPath(element2).getText().equals("B1")){
            driver.findElementById(button1).click();
        } else {
            driver.findElementById(button2).click();
        }
    }
    @When("Uzytkownik klika w trzeci przycisk")
    public void uzytkownik_klika_w_trzeci_przycisk() {
        if (driver.findElementByXPath(element3).getText().equals("B1")){
            driver.findElementById(button1).click();
        } else {
            driver.findElementById(button2).click();
        }
    }
    @When("Uzytkownik klika w przycisk checkSolution")
    public void uzytkownik_klika_w_przycisk_checkSolution() throws InterruptedException {
        driver.findElementById(btnSolution).click();
    }
    @Then("Uzytkownik widzi napis OK. Good answer")
    public void sprawdzenie_wyniku(){
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById(responseId),"OK. Good answer"));
        Assert.assertEquals("OK. Good answer", driver.findElementById(responseId).getText());
        driver.close();
    }
}
