package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCheckout {
    private final WebDriver driver;

    public PageCheckout(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение формы: {firstName} {lastName} {postalCode}")
    public PageCheckout fillCheckoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        return this;
    }

    @Step("Нажатие Continue")
    public PageCheckoutOverview clickContinue() {
        driver.findElement(By.id("continue")).click();
        return new PageCheckoutOverview(driver);
    }
}

