package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SignUpLoginPage clickSignUpPage(){
        driver.findElement(By.linkText("Signup / Login")).click();

        return new SignUpLoginPage(driver);
    }

    public DeletePage clickDeletePage(){
        driver.findElement(By.linkText("Delete Account")).click();

        return new DeletePage(driver);
    }
}
