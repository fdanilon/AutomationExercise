package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpLoginPage {
    private final WebDriver driver;

    public SignUpLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String capturaTextoPaginaDeRegistro(){

        return driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).getText();
    }

    public String capturaTextoLabelLogin(){

        return driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();
    }

    public String capturaTextoLabelLoginIncorreto(){

        return driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText();
    }

    public String capturaTextoLabelEmailExistente(){

        return driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).getText();
    }

    public SignUpFillPage preencheNovoUsuario(String signUpName, String signUpEmail){
        driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(signUpName);
        driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(signUpEmail);
        driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

        return new SignUpFillPage(driver);
    }

    public SignUpLoginPage preencheUsuarioExistente(String signUpName, String signUpEmail){
        driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(signUpName);
        driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(signUpEmail);
        driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

        return this;
    }

    public HomePage preencheLogin(String loginName, String loginPassword){
        driver.findElement(By.cssSelector("[data-qa=login-email]")).sendKeys(loginName);
        driver.findElement(By.cssSelector("[data-qa=login-password]")).sendKeys(loginPassword);
        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

        return new HomePage(driver);
    }

    public SignUpLoginPage preencheLoginIncorreto(String loginName, String loginPassword){
        driver.findElement(By.cssSelector("[data-qa=login-email]")).sendKeys(loginName);
        driver.findElement(By.cssSelector("[data-qa=login-password]")).sendKeys(loginPassword);
        driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

        return this;
    }

    public SignUpLoginPage clicaNoBotaoLogout(){
        driver.findElement(By.linkText("Logout")).click();

        return this;
    }
}
