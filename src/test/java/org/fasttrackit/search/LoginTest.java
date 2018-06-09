package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {

    @Test
    public void loginTestWithValidData(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\IdeaProjects\\madisonIslandTestByMry\\src\\test\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); {

            driver.get("https://fasttrackit.org/selenium-test/");
            driver.findElement(By.linkText("ACCOUNT")).click();
            driver.findElement(By.linkText("Log In")).click();
            driver.findElement(By.name("login[username]")).sendKeys("mail@mail.com");
            driver.findElement(By.name("login[password]")).sendKeys("123456");
            driver.findElement(By.cssSelector("button[title='Login']")).click();
            driver.findElement(By.className("welcome-msg"));
            WebElement errorMsgContainer = driver.findElement(By.className("welcome-msg"));
            assertThat("The user failed to log in", errorMsgContainer.isDisplayed());
            driver.quit();
        }

    }

}