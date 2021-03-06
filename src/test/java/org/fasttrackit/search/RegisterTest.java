package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterTest {

    @Test
    public void registerTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mury7\\IdeaProjects\\madisonIslandTestByMry\\src\\test\\resources\\drivers\\chromedriver.exe");

        // Creating unique e-mail.
        String email = "mail" + System.currentTimeMillis() + "@mail.com";

        // Verifying successful register with valid data.
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        registerUser(driver, email);
        driver.findElement(By.className("success-msg"));
        WebElement successMsgContainer = driver.findElement(By.className("success-msg"));
        assertThat("Success message not displayed", successMsgContainer.isDisplayed());
        Thread.sleep(1000);
        driver.quit();

        // Verifying error message if user enter an existing e-mail when register.
        driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        registerUser(driver, email);
        driver.findElement(By.className("error-msg"));
        WebElement errorMsgContainer = driver.findElement(By.className("error-msg"));
        assertThat("Error message not displayed", errorMsgContainer.isDisplayed());
        Thread.sleep(1000);
        driver.quit();
    }

    // Completing register form.
    private void registerUser(WebDriver driver, String email) {
        driver.findElement(By.linkText("ACCOUNT")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstname")).sendKeys("First");
        driver.findElement(By.id("middlename")).sendKeys("Automation");
        driver.findElement(By.id("lastname")).sendKeys("TestAttempt");
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.name("is_subscribed")).click();
        driver.findElement(By.cssSelector("button[title='Register']")).click();
    }
}
