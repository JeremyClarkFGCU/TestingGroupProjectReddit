import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignOut {
    @Test(priority = 18)
    public void click_user_button() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnUser = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#USER_DROPDOWN_ID")));
        btnUser.click();
        Thread.sleep(3000);
    }

    @Test(priority = 19)
    public void log_out() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnLogout = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(23) > div > div > button:nth-child(15)")));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",btnLogout);
        btnLogout.click();
        Thread.sleep(3000);
        driver.quit();
    }
}// End of SignOut Class
