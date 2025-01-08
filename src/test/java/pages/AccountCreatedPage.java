package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountCreatedPage {
    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
    }

    public String capturaTextoContaCriada(){
        String textAccountCreated = driver.findElement(By.cssSelector("[data-qa=account-created]")).getText();


        return textAccountCreated;
    }

    public HomePage clicaNoBotaoContinuarPaginaInicial(){
        driver.findElement(By.cssSelector("[data-qa=continue-button]")).click();

        return new HomePage(driver);
    }
}
