package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpFillPage {
    private final WebDriver driver;

    public SignUpFillPage(WebDriver driver){
        this.driver = driver;
    }

    public String capturaTextoPreencherInformacoes(){

        return driver.findElement(By.xpath("//b[contains(text(), 'Enter Account Information')]")).getText();
    }

    public AccountCreatedPage preencheRegistro(){
        driver.findElement(By.id("id_gender1")).click();

        driver.findElement(By.cssSelector("[data-qa='password']")).sendKeys("12345");

        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByValue("10");

        Select selectMonth = new Select(driver.findElement(By.id("months")));
        selectMonth.selectByValue("7");

        Select selectYear = new Select(driver.findElement(By.id("years")));
        selectYear.selectByValue("2001");

        driver.findElement(By.id("first_name")).sendKeys("Danilo");
        driver.findElement(By.id("last_name")).sendKeys("Nascimento");
        driver.findElement(By.id("company")).sendKeys("JCN");
        driver.findElement(By.id("address1")).sendKeys("av cr7");
        driver.findElement(By.id("address2")).sendKeys("av messi");

        Select selectCountry = new Select(driver.findElement(By.id("country")));
        selectCountry.selectByValue("United States");

        driver.findElement(By.id("state")).sendKeys("Michigan");
        driver.findElement(By.id("city")).sendKeys("Detroit");
        driver.findElement(By.id("zipcode")).sendKeys("11111");
        driver.findElement(By.id("mobile_number")).sendKeys("5513123456789");

        driver.findElement(By.cssSelector("[data-qa=create-account]")).click();

        return new AccountCreatedPage(driver);
    }
}
