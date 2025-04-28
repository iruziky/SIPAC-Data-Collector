package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {}
    
    public static void getUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("A URL não pode ser nula ou vazia.");
        }
        getDriver().get(url);
    }
    
    public static boolean isEqualToCurrentUrl(String url) {
		return getDriver().getCurrentUrl().equals(url);
	}

    public static WebDriver getDriver() {
        if (driver == null) {
        	WebDriverManager.chromedriver()
            .clearDriverCache()
            .clearResolutionCache()
            .setup();
        	
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    public static void resetDriver() {
        killDriver();
        getDriver();
    }
}