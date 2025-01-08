package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpLoginPage {
    private WebDriver driver;

    public SignUpLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String capturaTextoPaginaDeRegistro(){
        String textNewUser = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).getText();

        return textNewUser;
    }

    public SignUpFillPage preencheNovoUsuario(String signUpName, String signUpEmail){
        driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(signUpName);
        driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(signUpEmail);
        driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

        return new SignUpFillPage(driver);
    }
}
