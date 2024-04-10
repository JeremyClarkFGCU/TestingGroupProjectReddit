import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {
    @Test (priority = 0)
    public void VerifyLoginInformation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.reddit.com/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-password")));

        // incorrect username and password
        username.sendKeys("wrongUsername");
        Thread.sleep(5000);

        pass.sendKeys("wrongPassword");
        Thread.sleep(5000);

        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);

        // clears username and password fields
        driver.navigate().refresh();

        // correct username and password
        username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
        username.sendKeys("CurbSideBabyDropOff");// could change user

        pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("@Bcm4fbby0112"); // could change password

        // submits
        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);

        driver.quit();
    }

    @Test (priority = 1)
    public void SignOut() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.reddit.com/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // logs in
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
        username.sendKeys("CurbSideBabyDropOff");// could change user

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("@Bcm4fbby0112"); // could change password
        Thread.sleep(5000);

        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);

        //finds drop down menu to log out
        WebElement findDropDownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("USER_DROPDOWN_ID")));
        findDropDownMenu.click();
        Thread.sleep(5000);

        // finds log out button
        WebElement logOut = driver.findElement(By.className("GCltVwsXPu5lE-gs4Nucu"));
        // this look stupid, but it gets results
        // don't question it
        logOut.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
        Thread.sleep(5000);

        driver.quit();
    }
}
