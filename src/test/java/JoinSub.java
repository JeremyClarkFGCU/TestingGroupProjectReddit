import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class JoinSub {
@Test(priority = 7)
    void join_subreddit_test() throws InterruptedException {
    WebDriver driver = Browser.d;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://www.reddit.com/r/testingPostFunction/");

    // Find Join Btn
    WebElement //shadowHost1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("shreddit-app")));
    shadowHost1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("dsa-transparency-modal-provider")));
    shadowHost1.getShadowRoot();
    WebElement shadowHost3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("shreddit-subreddit-header-buttons")));
    SearchContext shadowRoot4 = shadowHost3.getShadowRoot();
    WebElement shadowHost5 = shadowRoot4.findElement(By.cssSelector("shreddit-join-button"));
    SearchContext shadowRoot5 = shadowHost5.getShadowRoot();
    WebElement joinButton = shadowRoot5.findElement(By.cssSelector("button"));
    System.out.println(joinButton.getText() + " button located.");
    joinButton.click();

    // Redundant -Tryting to get before/after status
    Thread.sleep(5000);
    joinButton = shadowRoot5.findElement(By.cssSelector("button"));
    System.out.println(joinButton.getText());
} // End of join_subreddit_test


    } // End of JoinSub Class
