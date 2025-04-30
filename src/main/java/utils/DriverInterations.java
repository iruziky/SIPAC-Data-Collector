package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInterations {
	protected static WebDriver driver;

    public static void write(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public static void click(By by) {
        driver.findElement(by).click();
    }

    public static void waitElement(By by, int segundos) {
        new WebDriverWait(driver, Duration.ofSeconds(segundos))
            .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static String getText(By by) {
        return driver.findElement(by).getText();
    }
}
