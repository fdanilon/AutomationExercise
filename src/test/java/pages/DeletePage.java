package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePage {
    private WebDriver driver;

    public DeletePage(WebDriver driver){
        this.driver = driver;
    }

    public String capturaTextoExcluiuConta(){
        String textAccountDeleted = driver.findElement(By.cssSelector("[data-qa=account-deleted]")).getText();


        return textAccountDeleted;
    }

    public HomePage clicaNoBotaoContinuarPaginaInicial(){
        driver.findElement(By.cssSelector("[data-qa=continue-button]")).click();

        return new HomePage(driver);
    }



}
