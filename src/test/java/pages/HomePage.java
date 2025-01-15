package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SignUpLoginPage clicaNaPaginaDeRegistro(){
        driver.findElement(By.linkText("Signup / Login")).click();

        return new SignUpLoginPage(driver);
    }

    public DeletePage clicaNaPaginaDeExclusao(){
        driver.findElement(By.linkText("Delete Account")).click();

        return new DeletePage(driver);
    }



    public String capturaTextoLoggedIn(){

        return driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).getText();
    }
}
