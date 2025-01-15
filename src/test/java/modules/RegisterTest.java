package modules;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        driver.quit();
    }

    WebDriver driver;
    @Test
    @DisplayName("Test Case 1: Register User")
    public void testRegisterUser(){
        String textNewUser = new HomePage(driver)
                .clicaNaPaginaDeRegistro()
                .capturaTextoPaginaDeRegistro();
        assertTrue(textNewUser.contains("New User Signup!"));

        String textEnterAccount = new SignUpLoginPage(driver)
                .preencheNovoUsuario("Danilo", "danilo3@gmail.com")
                .capturaTextoPreencherInformacoes();
        assertEquals("ENTER ACCOUNT INFORMATION", textEnterAccount);

        String textAccountCreated = new SignUpFillPage(driver)
                .preencheRegistro()
                .capturaTextoContaCriada();
        assertEquals("ACCOUNT CREATED!", textAccountCreated);

        String textAccountDeleted = new AccountCreatedPage(driver)
                .clicaNoBotaoContinuarPaginaInicial()
                .clicaNaPaginaDeExclusao()
                .capturaTextoExcluiuConta();
        assertEquals("ACCOUNT DELETED!", textAccountDeleted);

        new DeletePage(driver).clicaNoBotaoContinuarPaginaInicial();
    }

    @Test
    @DisplayName("Test Case 2: Login User with correct email and password")
    public void testLoginUserWithCorrectEmailAndPassword(){

        String texLoginAccount = new HomePage(driver)
                .clicaNaPaginaDeRegistro()
                .capturaTextoLabelLogin();
        assertTrue(texLoginAccount.contains("Login to your account"));

        String textLoggedIn = new SignUpLoginPage(driver)
                .preencheLogin("danilo3@gmail.com", "12345")
                .capturaTextoLoggedIn();

        assertTrue(textLoggedIn.contains("Logged in as"));

        String textAccountDeleted = new HomePage(driver)
                .clicaNaPaginaDeExclusao()
                .capturaTextoExcluiuConta();
        assertEquals("ACCOUNT DELETED!", textAccountDeleted);

        new DeletePage(driver).clicaNoBotaoContinuarPaginaInicial();
    }

    @Test
    @DisplayName("Test Case 3: Login User with incorrect email and password")
    public void testLoginUserWithIncorrectEmailAndPassword(){
        String texLoginAccount = new HomePage(driver)
                .clicaNaPaginaDeRegistro()
                .capturaTextoLabelLogin();
        assertTrue(texLoginAccount.contains("Login to your account"));

        String textWrongLogin = new SignUpLoginPage(driver)
                .preencheLoginIncorreto("dani2233@gmail.com","432413123")
                .capturaTextoLabelLoginIncorreto();

        assertEquals(textWrongLogin,"Your email or password is incorrect!");
    }

    @Test
    @DisplayName("Test Case 4: Logout User")
    public void testLogoutUser(){
        String texLoginAccount = new HomePage(driver)
                .clicaNaPaginaDeRegistro()
                .capturaTextoLabelLogin();
        assertTrue(texLoginAccount.contains("Login to your account"));

        String textLoggedIn = new SignUpLoginPage(driver)
                .preencheLogin("danilo3@gmail.com", "12345")
                .capturaTextoLoggedIn();

        assertTrue(textLoggedIn.contains("Logged in as"));

        String textLoginAccount = new SignUpLoginPage(driver)
                .clicaNoBotaoLogout()
                .capturaTextoLabelLogin();

        assertTrue(textLoginAccount.contains("Login to your account"));
    }

    @Test
    @DisplayName("Test Case 5: Register User with existing email")
    public void testRegisterUserWithExistingEmail(){
        driver.findElement(By.linkText("Signup / Login")).click();

        String textNewUser = new HomePage(driver)
                .clicaNaPaginaDeRegistro()
                .capturaTextoPaginaDeRegistro();

        assertTrue(textNewUser.contains("New User Signup!"));

        String textEmailAlreadyExists = new SignUpLoginPage(driver)
                .preencheUsuarioExistente("Danilo", "danilo3@gmail.com")
                .capturaTextoLabelEmailExistente();

        assertTrue(textEmailAlreadyExists.contains("Email Address already exist!"));
    }



}
