import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Commenting {

    String desiredComment = "Comment Test Successful.";
    @Test(priority = 9)
    public void find_comment_field() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement commentField = null;

        // post comment
        try{
             commentField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > shreddit-async-loader > comment-body-header > shreddit-async-loader > comment-composer-host > faceplate-tracker:nth-child(1) > button")));
            System.out.println("Comment field located.");
        }catch (Exception e){
            System.out.println("Could not locate comment field.");
        }
        try{
            commentField.click();
            System.out.println("Clicking comment field. Entering Text.");
        }catch(Exception e){
            System.out.println("Comment field could not be clicked.");
        }


    }// End of find_comment_field

    @Test (priority = 10)
    public void enter_comment() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentField = driver.findElement(By.cssSelector("#main-content > shreddit-async-loader > comment-body-header > shreddit-async-loader > comment-composer-host > faceplate-form > shreddit-composer > div > p"));
        commentField.sendKeys(desiredComment);

    } // End of enter_comment()

    @Test (priority = 11)
    public void post_comment() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement commentBtn = driver.findElement(By.cssSelector("#main-content > shreddit-async-loader > comment-body-header > shreddit-async-loader > comment-composer-host > faceplate-form > shreddit-composer > button.relative"));
        commentBtn.click();

        Thread.sleep(2500);

        // scrolls to bottom of page.
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

    }

}
