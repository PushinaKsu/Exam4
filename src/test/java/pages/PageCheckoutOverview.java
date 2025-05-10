package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCheckoutOverview {
    private final WebDriver driver;

    public PageCheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка суммы заказа: {expectedTotal}")
    public PageCheckoutOverview verifyTotal(String expectedTotal) {
        String totalText = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        Assertions.assertTrue(totalText.contains(expectedTotal),
                "Ожидалась сумма " + expectedTotal + ", но была: " + totalText);
        return this;
    }
    @Step("Завершение заказа (Finish)")
    public void clickFinish() {
        driver.findElement(By.xpath("//button[@data-test='finish']")).click();
    }
}

