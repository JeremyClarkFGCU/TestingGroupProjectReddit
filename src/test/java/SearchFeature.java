import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


    public class SearchFeature {

        @Test (priority = 5)// Test Search Feature of Reddit
            void find_search_bar() throws InterruptedException {
                WebDriver driver = Browser.d;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement shadowHost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/shreddit-app/reddit-header-large/reddit-header-action-items/header/nav/div[2]/div/div/search-dynamic-id-cache-controller/reddit-search-large")));
                SearchContext shadowRoot = shadowHost.getShadowRoot();
                WebElement searchBar = shadowRoot.findElement(By.cssSelector("#search-input"));
                try{
                    searchBar.sendKeys("r/SoftwareEngineering");
                } catch(Exception e) {
                    System.out.println("Element couldn't receive Keys");
                }
                searchBar.sendKeys(Keys.RETURN);
                Thread.sleep(3000);
            } // End of find_search_bar()

        @Test (priority = 6)
            void go_to_subreddit() throws InterruptedException {
            WebDriver driver = Browser.d;
            WebElement element = null;
            try {
                element = driver.findElement(By.id("right-sidebar-container"));
                element = element.findElement(By.cssSelector("div > div > section:nth-child(1) > faceplate-tracker:nth-child(2) > div > faceplate-tracker > a "));

            }catch(Exception e){
                System.out.println("Could not locate element.");
            } // End of Try/Catch

                element.click();
            Thread.sleep(3000);
            String actualTitle = driver.getTitle();
            String expectedTitle = "Software Engineering";
            Assert.assertEquals(actualTitle,expectedTitle);
            Thread.sleep(5000);
        }// End of go_to_subreddit()

}// End of SearchFeature Class
