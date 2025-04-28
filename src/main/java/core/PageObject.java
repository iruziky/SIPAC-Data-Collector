package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageObject {
    protected WebDriver driver;

    public PageObject() {
        this.driver = DriverFactory.getDriver();
    }

    protected void write(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void waitElement(By by, int segundos) {
        new WebDriverWait(driver, Duration.ofSeconds(segundos))
            .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected String getText(By by) {
        return driver.findElement(by).getText();
    }
}