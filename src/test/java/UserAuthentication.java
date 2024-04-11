import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class UserAuthentication {

    // Set Up Users
    User invalidUser = new User("thisbadusername102","P@ssw0rd!");
    User validUser = new User("ThrowAwayTestingbot","CEN4072!" );

    String mainW;




    @Test (priority = 1)  // Navigate to Reddit.com
    void navigate_to_reddit() {
        WebDriver driver = Browser.d;
        System.out.println("Attempting to navigate to Reddit.com");
        try{
            driver.get("http://www.reddit.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.print("Successfully navigated to Reddit.com!");
        } catch(Exception e){
            System.out.println("Could not navigate to the target URL.");
        }
    }// End of navigate_to_reddit

    @Test (priority = 2) // Test Case: Invalid Login Attempt
    void invalid_sign_in() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String u = invalidUser.get_userName();
        String p = invalidUser.get_password();
        String pop = null;
        WebElement fieldLoginID;
        try {
            WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            btnLogin.click();
        }catch(Exception e){
            System.out.println("Could not locate Log In button.");
        }
        // Get Pop-up
        mainW = driver.getWindowHandle();
        Set<String> wHandles = driver.getWindowHandles();
        Iterator<String> iterator = wHandles.iterator();
        while (iterator.hasNext()){
            pop = iterator.next();
        }
        driver.switchTo().window(pop);

        System.out.println("The handle is : " + pop);

        try{
            fieldLoginID = driver.findElement(By.id("login-username"));
            fieldLoginID.sendKeys(u);
            try {
                WebElement fieldPassword = driver.findElement(By.id("login-password"));
                fieldPassword.sendKeys(p);
           }catch (Exception e){
                System.out.println("Could not locate Password Field");
                } // End of Try/Catch Statement (inner)
        }catch (Exception e){
            System.out.println("Could not locate User Name field element");
            } // End of Try/Catch Statement (Outer)
        WebElement shadowHost1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > shreddit-app > shreddit-overlay-display")));
        SearchContext shadowRoot = shadowHost1.getShadowRoot();
        WebElement shadowChild1 = shadowRoot.findElement(By.cssSelector("shreddit-signup-drawer"));
        shadowRoot = shadowChild1.getShadowRoot();
        WebElement shadowChild2 = shadowRoot.findElement(By.cssSelector("shreddit-drawer > div > shreddit-async-loader > div > shreddit-slotter"));
        shadowRoot = shadowChild2.getShadowRoot();
        WebElement btnLogin = shadowRoot.findElement(By.cssSelector("span > shreddit-async-loader > auth-flow-login"));
        btnLogin = btnLogin.findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.w-100 > faceplate-tracker > button"));
        btnLogin.click();
        System.out.println("The Button Text is: " + btnLogin.getText());


        // Check Invalid Login Message
        WebElement messageElement = shadowRoot.findElement(By.cssSelector("span > shreddit-async-loader > auth-flow-login"));
        messageElement = messageElement.findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.font-sans.bg-ui-modalbackground.pb-\\[env\\(safe-area-inset-bottom\\)\\] > fieldset:nth-child(5)"));
        messageElement = messageElement.findElement(By.id("login-password"));
        shadowRoot = messageElement.getShadowRoot();
        messageElement = shadowRoot.findElement(By.cssSelector("faceplate-form-helper-text"));
        shadowRoot = messageElement.getShadowRoot();
        WebElement helperText = shadowRoot.findElement(By.cssSelector("span > span"));
        System.out.println(helperText.getText());

        // Close dialogue box
        shadowRoot = shadowChild2.getShadowRoot();
        WebElement btnCLose = shadowRoot.findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > faceplate-tracker > button"));
        btnCLose.click();
        Thread.sleep(1500);

    } // End of Invalid User Attempt Test

    @Test (priority = 3)
    void valid_sign_in() throws InterruptedException {
        WebDriver driver = Browser.d;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String u = validUser.get_userName();
        String p = validUser.get_password();
        String pop = null;
        WebElement fieldLoginID = null;
        try {
            WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            btnLogin.click();
        }catch(Exception e){
            System.out.println("Could not locate Log In button.");
        }
        // Get Pop-up
        Set<String> wHandles = driver.getWindowHandles();
        Iterator<String> iterator = wHandles.iterator();
        while (iterator.hasNext()){
            pop = iterator.next();
        }
        driver.switchTo().window(pop);

        System.out.println("The Main Window handle is : " + mainW);
        System.out.println("The Pop-Up handle is: " + pop);

        try{
            fieldLoginID = driver.findElement(By.id("login-username"));
            fieldLoginID.sendKeys(u);
            try {
                WebElement fieldPassword = driver.findElement(By.id("login-password"));
                fieldPassword.sendKeys(p);
            }catch (Exception e){
                System.out.println("Could not locate Password Field");
            } // End of Try/Catch Statement (inner)
        }catch (Exception e){
            System.out.println("Could not locate User Name field element");
        } // End of Try/Catch Statement (Outer)
        WebElement shadowHost1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > shreddit-app > shreddit-overlay-display")));
        SearchContext shadowRoot = shadowHost1.getShadowRoot();
        WebElement shadowChild1 = shadowRoot.findElement(By.cssSelector("shreddit-signup-drawer"));
        shadowRoot = shadowChild1.getShadowRoot();
        WebElement shadowChild2 = shadowRoot.findElement(By.cssSelector("shreddit-drawer > div > shreddit-async-loader > div > shreddit-slotter"));
        shadowRoot = shadowChild2.getShadowRoot();
        WebElement btnLogin = shadowRoot.findElement(By.cssSelector("span > shreddit-async-loader > auth-flow-login"));
        btnLogin = btnLogin.findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.w-100 > faceplate-tracker > button"));

        try{
            btnLogin.click();
            System.out.println("Logging into Reddit.");
        }catch(Exception e){
            System.out.println("Could not click Log In Button");
        }
        Thread.sleep(5000);
        driver.switchTo().window(mainW);
    }// End of Valid User Sign In Test

}// End of UserAuthentication
