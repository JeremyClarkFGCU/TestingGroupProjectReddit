import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class posting {
    @Test (priority = 0)
    public void MakingAPost() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.reddit.com/login/?dest=https%3A%2F%2Fwww.reddit.com%2Fr%2FtestingPostFunction%2Fsubmit%3Fcollection%3D391044e7-5ea9-463a-bc50-7bebf02361bb");
        driver.manage().window().maximize();

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
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.className("notranslate")));
        text.sendKeys("⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⣠⣤⣶⣶\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢰⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣀⣀⣾⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀⢄⠀⢀⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿");
        post.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);// "it just works" - Todd Howard

        // Assertion for test
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "(1) this is a test : testingPostFunction";

        Assert.assertEquals(actualTitle.substring(3) ,expectedTitle.substring(3));
        driver.quit();
    }
    @Test (priority = 1)
    public void PostingAComment() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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
        WebElement c = wait.until(ExpectedConditions.elementToBeClickable(By.className("public-DraftStyleDefault-block")));
        c.sendKeys("well that just happened.");
        WebElement comment = wait.until(ExpectedConditions.elementToBeClickable(By.className("_22S4OsoDdOqiM-hPTeOURa")));
        comment.click();

        Thread.sleep(5000);

        // scrolls down
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(5000);
        driver.quit();
    }
}
