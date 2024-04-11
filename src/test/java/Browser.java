import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;


import java.time.Duration;

public class Browser {

    public static WebDriver d;

    @Test (priority = 1)
    public  void before_suite() {
        System.out.println("Setting up Chrome browser.");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pr0je\\Desktop\\Spring2024\\CEN4072 - Software Testing\\FinalGroupProject\\src\\main\\java\\org\\example\\chromedriver.exe");
        d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }


}


