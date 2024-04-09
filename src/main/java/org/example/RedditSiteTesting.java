import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class RedditSiteTesting {
   @Test
    public void Login() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.reddit.com/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
        username.sendKeys("CurbSideBabyDropOff");// could change user

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("@Bcm4fbby0112"); // could change password
        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);

        driver.quit();
    }
    @Test
    public void FailedLogin() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.reddit.com/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
        username.sendKeys("wrongUsername");
        Thread.sleep(5000);

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("wrongPassword");
        Thread.sleep(5000);
        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Reddit - Dive into anything";

        Assert.assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }
    @Test
    public void PostingAComment() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.reddit.com/r/testingPostFunction/comments/1bzws0h/just_a_test/");
        driver.manage().window().maximize();

        WebElement loginLink = driver.findElement(By.id("login-button"));
        loginLink.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("CurbSideBabyDropOff");// could change user
        Thread.sleep(5000);

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("@Bcm4fbby0112"); // could change password
        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // post comment
        Thread.sleep(5000);
        WebElement c = driver.findElement(By.className("public-DraftStyleDefault-block"));
        c.sendKeys("well that just happened.");
        WebElement comment = driver.findElement(By.className("_22S4OsoDdOqiM-hPTeOURa"));
        comment.sendKeys(Keys.ENTER);

        driver.quit();
    }
    @Test
    public void MakingAPost(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com%2Fr%2FtestingPostFunction%2Fsubmit%3Fcollection%3D391044e7-5ea9-463a-bc50-7bebf02361bb");

        WebElement username = driver.findElement(By.id("login-username"));
        username.sendKeys("CurbSideBabyDropOff");// could change user

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("@Bcm4fbby0112"); // could change password
        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);
        // posting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement post = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("textArea")));
        post.sendKeys("this is a test");
        post.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);// "it just works" - Todd Howard

        driver.quit();
    }
    @Test
    public void SignOut() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.reddit.com/login");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-username")));
        username.sendKeys("CurbSideBabyDropOff");// could change user

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("@Bcm4fbby0112"); // could change password
        pass.sendKeys(Keys.TAB);
        pass.sendKeys(Keys.ENTER);

        WebElement findDropDownMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("USER_DROPDOWN_ID")));
        findDropDownMenu.click();

        WebElement logOut = driver.findElement(By.className("GCltVwsXPu5lE-gs4Nucu"));
        // this look stupid but it gets results
        logOut.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);

        driver.quit();
    }
}