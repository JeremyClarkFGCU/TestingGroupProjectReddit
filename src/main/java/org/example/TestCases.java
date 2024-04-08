package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class TestCases {

    String userName = "ThrowAwayTestingbot";
    String password = "CEN4072!";

    WebElement shadowHost;
    WebElement shadowChild;

    WebDriver create_driver( char browser){
        if(browser == 'c'){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\pr0je\\Desktop\\Spring2024\\CEN4072 - Software Testing\\FinalGroupProject\\src\\main\\java\\org\\example\\chromedriver.exe");
            return new ChromeDriver();
        }else if(browser == 'f'){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\pr0je\\Desktop\\Spring2024\\CEN4072 - Software Testing\\FinalGroupProject\\src\\main\\java\\org\\example\\geckodriver.exe");
            return new FirefoxDriver();
        }else if(browser == 'e'){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\pr0je\\Desktop\\Spring2024\\CEN4072 - Software Testing\\FinalGroupProject\\src\\main\\java\\org\\example\\msedgedriver.exe");
            return new EdgeDriver();
        }
            else System.out.println("Sorry, we could not start a browser. Attempting to start Chrome.");
            return new ChromeDriver();
    }

    WebDriver driver = create_driver('c');

    @Test (priority = 1)
    void test_sign_in() throws InterruptedException, AWTException {

        // Visit Reddit.com
        driver.get("https://www.reddit.com");
        driver.manage().window().maximize();


        String mainWindow = driver.getWindowHandle();
        String popUp = null;
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        Thread.sleep(2000);

        // Get PopUp Info
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while(iterator.hasNext()){
            popUp = iterator.next();
        }
        driver.switchTo().window(popUp);

        // Find the Log In button in the pop-up window.
        driver.findElement(By.id("login-username")).sendKeys(userName);
        Thread.sleep(250);
        driver.findElement(By.id("login-password")).sendKeys(password);
        Thread.sleep(500);
        shadowHost = driver.findElement(By.xpath("/html/body/shreddit-app"));
        shadowHost = shadowHost.findElement(By.xpath("/html/body/shreddit-app/shreddit-overlay-display"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowChild = shadowRoot.findElement(By.cssSelector("shreddit-signup-drawer"));
        shadowRoot = shadowChild.getShadowRoot();
        shadowChild = shadowRoot.findElement(By.cssSelector("shreddit-drawer"));
        shadowChild = shadowChild.findElement(By.cssSelector("div > shreddit-async-loader"));
        shadowChild = shadowChild.findElement(By.className("block"));
        shadowChild = shadowChild.findElement(By.cssSelector("shreddit-slotter"));
        shadowRoot = shadowChild.getShadowRoot();
        shadowChild = shadowRoot.findElement(By.cssSelector("span > shreddit-async-loader > auth-flow-login"));
        shadowChild = shadowChild.findElement(By.id("login"));
        shadowChild = shadowChild.findElement(By.cssSelector("faceplate-tabpanel > auth-flow-modal > div.w-100 > faceplate-tracker > button"));
        shadowChild.click();

        Thread.sleep(6000);
        driver.switchTo().window(mainWindow);
    } // End of test_sign_in()

    @Test (priority = 2)
void search_test() throws InterruptedException {
        Thread.sleep(500);
        WebElement searchBar = driver.findElement(By.id("header-search-bar"));
        searchBar.sendKeys("Software Engineering");
        Thread.sleep(500);
        searchBar.sendKeys(Keys.RETURN);
} // End of search_test()

@Test (priority = 3)
void join_subreddit_test(){

WebElement link = driver.findElement(By.id("2x-container"));
link = link.findElement(By.id("SHORTCUT_FOCUSABLE_DIV"));
link = link.findElement(By.id("AppRouter-main-content"));
link = link.findElement(By.cssSelector("div > div"));
link = link.findElement(By.xpath("//div[1]"));
link = link.findElement(By.cssSelector("div > div"));
link = link.findElement(By.xpath("//div[1]"));
link = link.findElement(By.xpath("//div[1]"));
link = link.findElement(By.cssSelector("div > div > div > div > div"));
String textInElement = link.getText();

System.out.println(textInElement);
//link.click();
}


} // END OF TestCases Class
