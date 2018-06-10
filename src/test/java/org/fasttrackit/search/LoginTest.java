package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {

    @Test
    public void loginTestWithValidData(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\IdeaProjects\\madisonIslandTestByMry\\src\\test\\resources\\drivers\\chromedriver.exe");

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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\IdeaProjects\\madisonIslandTestByMry\\src\\test\\resources\\drivers\\chromedriver.exe");

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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\IdeaProjects\\madisonIslandTestByMry\\src\\test\\resources\\drivers\\chromedriver.exe");

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

//    @Test
//    public void loginTestWithoutEmail(){
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\IdeaProjects\\madisonIslandTestByMry\\src\\test\\resources\\drivers\\chromedriver.exe");
//
//
//        WebDriver driver = new ChromeDriver(); {
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//            driver.get("https://fasttrackit.org/selenium-test/");
//            driver.findElement(By.linkText("ACCOUNT")).click();
//            driver.findElement(By.linkText("Log In")).click();
//            driver.findElement(By.name("login[password]")).sendKeys("123456");
//            driver.findElement(By.cssSelector("button[title='Login']")).click();
//            driver.findElement(By.cssSelector("style>This is a required field."));   // <<< ???????????
//            WebElement errorMsgContainer = driver.findElement(By.className("error-msg"));
//            assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
//            driver.quit();
//        }
//
//    }

}