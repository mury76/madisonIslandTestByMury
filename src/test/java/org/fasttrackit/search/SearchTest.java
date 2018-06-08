package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    @Test
    public void registerTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\FastTrackIt\\nadisonIslandTest\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstname")).sendKeys("First");
        driver.findElement(By.id("middlename")).sendKeys("Automation");
        driver.findElement(By.id("lastname")).sendKeys("TestAttempt");
        driver.findElement(By.id("email_address")).sendKeys("mail@mail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.name("is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        driver.findElement(By.className("error-msg"));
        WebElement errorMsgContainer = driver.findElement(By.className("error-msg"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());

//      driver.quit();
    }
}