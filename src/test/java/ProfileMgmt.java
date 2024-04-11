import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileMgmt {
    @Test (priority = 14)
    public void open_user_menu() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btnUser = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#expand-user-drawer-button")));
        btnUser.click();
        Thread.sleep(3000);
    } // End of open_user_menu

    @Test (priority = 15)
    public void goto_profile() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnUser = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-drawer-content > ul:nth-child(1) > faceplate-tracker:nth-child(1) > li > a")));
        btnUser.click();
        Thread.sleep(3000);
    }// End of goto_profile

    @Test (priority = 16)
    public void goto_edit() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnEdit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#right-sidebar-container > aside > div.p-md > ul > li:nth-child(1) > div > span.flex.items-center.shrink-0 > span > faceplate-tracker > a")));
        btnEdit.click();
        Thread.sleep(1500);
    }//End of goto_edit

    @Test (priority = 17)
    public void edit_profile() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aboutField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#AppRouter-main-content > div > div._1OrNGmpfcSuSebbZM5vYq4 > div._3FVpvZ7OLbS_68QzaxplxT > div:nth-child(4) > div._1oREjd5ToMFah-VfX5Zt1z > textarea")));
        aboutField.sendKeys("Two students who deserve an A.");
        Thread.sleep(5000);
    }

}
