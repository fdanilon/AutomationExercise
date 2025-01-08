package modules;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
    }

    @AfterEach
    public void afterEach(){
        //driver.quit();
    }

    WebDriver driver;
    @Test
    @DisplayName("Test Case 1: Register User")
    public void testRegisterUser(){
        String textNewUser = new HomePage(driver)
                .clickSignUpPage()
                .capturaTextoSignUpPage();
        assertTrue(textNewUser.contains("New User Signup!"));

        String textEnterAccount = new SignUpLoginPage(driver)
                .preencheNovoUsuario("Danilo", "d3255@gmail.com")
                .verificaPaginaDeRegistro();
        assertEquals("ENTER ACCOUNT INFORMATION", textEnterAccount);

        String textAccountCreated = new SignUpFillPage(driver)
                .fillSignUp()
                .verificaContaCriada();
        assertEquals("ACCOUNT CREATED!", textAccountCreated);

        String textAccountDeleted = new AccountCreatedPage(driver)
                .clickContinueButton()
                .clickDeletePage()
                .verificaQueDeletouConta();
        assertEquals("ACCOUNT DELETED!", textAccountDeleted);

        new DeletePage(driver).clickContinueButtonDelete();
    }

    @Test
    @DisplayName("Test Case 2: Login User with correct email and password")
    public void testLoginUserWithCorrectEmailAndPassword(){
        driver.findElement(By.linkText("Signup / Login")).click();
        String textNewUser = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();
        assertTrue(textNewUser.contains("Login to your account"));

        driver.findElement(By.cssSelector("[data-qa=login-email]")).sendKeys("danilo3@gmail.com");
        driver.findElement(By.cssSelector("[data-qa=login-password]")).sendKeys("12345");

        driver.findElement(By.cssSelector("[data-qa=login-button]")).click();

        String textLogin = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).getText();
        assertEquals(textLogin, "Logged in as");
//        driver.findElement(By.linkText("Delete Account")).click();
//
//        String accountDeleted = driver.findElement(By.cssSelector("[data-qa=account-deleted]")).getText();
//        assertEquals("ACCOUNT DELETED!", accountDeleted);
    }

    @Test
    @DisplayName("Test Case 3: Login User with incorrect email and password")
    public void testLoginUserWithIncorrectEmailAndPassword(){
        driver.findElement(By.linkText("Signup / Login")).click();
        String textNewUser = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();
        assertTrue(textNewUser.contains("Login to your account"));

        driver.findElement(By.cssSelector("[data-qa=login-email]")).sendKeys("danilo233@gmail.com");
        driver.findElement(By.cssSelector("[data-qa=login-password]")).sendKeys("432413123");

        driver.findElement(By.cssSelector("[data-qa=login-button]")).click();

        String textWrongLogin = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText();
        assertEquals(textWrongLogin,"Your email or password is incorrect!");
    }

    @Test
    @DisplayName("Test Case 4: Logout User")
    public void testLogoutUser(){
        driver.findElement(By.linkText("Signup / Login")).click();
        String textNewUser = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();
        assertTrue(textNewUser.contains("Login to your account"));

        driver.findElement(By.cssSelector("[data-qa=login-email]")).sendKeys("danilo3@gmail.com");
        driver.findElement(By.cssSelector("[data-qa=login-password]")).sendKeys("12345");

        driver.findElement(By.cssSelector("[data-qa=login-button]")).click();

        String textLogin = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).getText();
        assertEquals(textLogin, "Logged in as Danilo");

        driver.findElement(By.linkText("Logout")).click();

        String textLoginAccount = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();

        assertTrue(textLoginAccount.contains("Login to your account"));
    }

    @Test
    @DisplayName("Test Case 5: Register User with existing email")
    public void testRegisterUserWithExistingEmail(){
        driver.findElement(By.linkText("Signup / Login")).click();

        String textNewUser = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).getText();

        assertTrue(textNewUser.contains("New User Signup!"));

        driver.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys("Danilo");
        driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys("danilo3@gmail.com");
        driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

        String textEmailAlreadyExists = driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).getText();
        assertTrue(textEmailAlreadyExists.contains("Email Address already exist!"));
    }



}
