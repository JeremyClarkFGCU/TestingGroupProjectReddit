import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Voting {
    @Test(priority = 12)
    public void down_vote() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = driver.findElement(By.cssSelector("#main-content > shreddit-post"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement btnDown = shadowRoot.findElement(By.cssSelector("div.flex > span > span > button:nth-child(3)"));
        btnDown.click();
        Thread.sleep(5000);
    }// End down_vote
    @Test (priority = 13)
    public void up_vote() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = driver.findElement(By.cssSelector("#main-content > shreddit-post"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement btnDown = shadowRoot.findElement(By.cssSelector("div.flex > span > span > button:nth-child(1)"));
        btnDown.click();
        Thread.sleep(5000);
    }

}// End Voting Class
