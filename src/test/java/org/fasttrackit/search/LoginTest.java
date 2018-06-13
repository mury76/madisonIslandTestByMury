package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {

    @Test
    public void loginTestWithValidData(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestByMury\\src\\test\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://fasttrackit.org/selenium-test/");
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();
            driver.findElement(By.name("login[username]")).sendKeys("mail@mail.com");
            driver.findElement(By.name("login[password]")).sendKeys("123456");
            driver.findElement(By.cssSelector("button[title='Login']")).click();
            driver.findElement(By.className("welcome-msg"));
            WebElement errorMsgContainer = driver.findElement(By.className("welcome-msg"));
            assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
            driver.quit();
        }

    }

    @Test
    public void loginTestWithUnregisteredEmail(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestByMury\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Making sure it is an unused email.
        String email = "mail" + System.currentTimeMillis() + "@mail.com";

        WebDriver driver = new ChromeDriver(); {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://fasttrackit.org/selenium-test/");
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();
            driver.findElement(By.name("login[username]")).sendKeys(email);
            driver.findElement(By.name("login[password]")).sendKeys("123456");
            driver.findElement(By.cssSelector("button[title='Login']")).click();
            driver.findElement(By.className("error-msg"));
            WebElement errorMsgContainer = driver.findElement(By.className("error-msg"));
            assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
            driver.quit();
        }

    }

    @Test
    public void loginTestWithWrongPassword(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestByMury\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Making sure it is an unused password.
        String uniquePassword = "Password" + System.currentTimeMillis();

        WebDriver driver = new ChromeDriver(); {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://fasttrackit.org/selenium-test/");
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();
            driver.findElement(By.name("login[username]")).sendKeys("mail@mail.com");
            driver.findElement(By.name("login[password]")).sendKeys(uniquePassword);
            driver.findElement(By.cssSelector("button[title='Login']")).click();
            driver.findElement(By.className("error-msg"));
            WebElement errorMsgContainer = driver.findElement(By.className("error-msg"));
            assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
            driver.quit();
        }

    }

    @Test
    public void loginTestWithoutEmail(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestByMury\\src\\test\\resources\\drivers\\chromedriver.exe");


        WebDriver driver = new ChromeDriver(); {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://fasttrackit.org/selenium-test/");
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();
            driver.findElement(By.name("login[password]")).sendKeys("123456");
            driver.findElement(By.cssSelector("button[title='Login']")).click();
            WebElement errorMsgContainer = driver.findElement(By.className("validation-advice"));
            assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
            driver.quit();
        }

    }

    @Test
    public void loginTestWithoutAtInEmail(){
        System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\mury7\\FastTrackIt\\madisonIslandTestByMury\\src\\test\\resources\\drivers\\chromedriver.exe");


        WebDriver driver = new ChromeDriver(); {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://fasttrackit.org/selenium-test/");
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();
            driver.findElement(By.name("login[username]")).sendKeys("mailmail.com");
            driver.findElement(By.name("login[password]")).sendKeys("123456");
            driver.findElement(By.cssSelector("button[title='Login']")).click();

            JavascriptExecutor js = (JavascriptExecutor)driver;

            WebElement field = driver.findElement(By.id("email"));
            Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
            String message = (String)js.executeScript("return arguments[0].validationMessage;", field);

            assertThat("The email field validates email without @ !", is_valid, is(false));
            driver.quit();
        }

    }

}